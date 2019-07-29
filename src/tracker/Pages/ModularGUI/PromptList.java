package tracker.Pages.ModularGUI;

import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import tracker.Data.InstanceData;
import tracker.Data.Prompts.MentalPrompt;
import tracker.GuiComponents.Containers.PromptEditDelete;
import tracker.GuiComponents.Individual.GuiFloatButton;

import java.util.List;
import java.util.Vector;

public class PromptList extends DefaultPageComponents {

    private List<PromptEditDelete> _PromptList = new Vector<>();

    private GuiFloatButton _FloatButton;

    public PromptList(InstanceData data, Form previous) {
        super(data, previous, "All Questions");

        setIsScrollable();
        createAllComponents();
    }

    private void createAllComponents() {
        initDefault();
        createComponents();

        initFloatButton();
        createFloatButton();
        initPromptList();
    }

    private void onAddPrompt() {
    }

    private void onAddDefault() {

    }

    private void onAddCustom() {
        Form createPrompt = new CreatePromptPage(getData(), this);
        createPrompt.show();
    }

    class PromptListCallback implements ActionListener {

        /**
         * Invoked when an action occurred on a component.
         *
         * @param evt event object describing the source of the action as well
         *            as its trigger
         */
        @Override
        public void actionPerformed(ActionEvent evt) {
            String sourceName = evt.getComponent().getName();

            if (sourceName.equals(_FloatButton.getSub1Name())) {
                onAddDefault();
            } else if (sourceName.equals(_FloatButton.getSub2Name())) {
                onAddCustom();
            } else if (sourceName.equals(_FloatButton.getButton().getName())) {
                onAddPrompt();
            }
        }
    }

    private void onDeletePrompt(Object source) {
        PromptEditDelete targetPrompt = (PromptEditDelete) source;
        MentalPrompt prompt = targetPrompt.getPrompt();
        getData().getInstancePrompts().deletePrompt(prompt);

        PromptList newList = new PromptList(getData(), getPreviousForm());
        newList.show();
    }

    private void onEditPrompt(Object source) {
        PromptEditDelete target = (PromptEditDelete) source;
        MentalPrompt targetPrompt = target.getPrompt();

        EditPromptPage editPage = new EditPromptPage(getData(), this, targetPrompt);
        editPage.show();
    }

    class PromptChangedCallback implements java.awt.event.ActionListener {

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("DeletePrompt")) {
                onDeletePrompt(e.getSource());
            } else if (command.equals("EditPrompt")) {
                onEditPrompt(e.getSource());
            }
        }
    }

    private void initFloatButton() {
        _FloatButton = new GuiFloatButton(FontImage.MATERIAL_ADD, "Add", new PromptListCallback());
        _FloatButton.addSubButton2(FontImage.MATERIAL_SUPERVISED_USER_CIRCLE, "Custom");
        _FloatButton.addSubButton1(FontImage.MATERIAL_LAYERS, "Default");
    }

    private void createFloatButton() {
        _FloatButton.getButton().bindFabToContainer(this.getContentPane());
    }

    private void initPromptList() {
        PromptChangedCallback callback = new PromptChangedCallback();

        float location = 1F;

        for (MentalPrompt prompt: getData().getInstancePrompts().getPrompts()) {
            PromptEditDelete singlePrompt = new
                    PromptEditDelete(this, prompt, getResources(), callback);
            singlePrompt.initialize(location, getBackButton().getButton());
            _PromptList.add(singlePrompt);
            location += 0.5F;
        }
    }
}
