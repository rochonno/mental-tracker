package tracker.Pages.ModularGUI;

import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.util.Resources;
import tracker.Data.InstanceData;
import tracker.Data.Prompts.MentalPrompt;
import tracker.GuiComponents.Containers.PromptEditDelete;
import tracker.GuiComponents.Individual.GuiButton;
import tracker.GuiComponents.Individual.GuiFloatButton;
import tracker.GuiComponents.Individual.GuiLabel;
import tracker.GuiComponents.ImageNames;

import java.util.List;
import java.util.Vector;

import static com.codename1.ui.util.Resources.getGlobalResources;

public class PromptList extends Form {

    private Form _PrevForm;
    private Resources _ResourceInstance;

    private InstanceData _Data;
    private List<PromptEditDelete> _PromptList = new Vector<>();

    private GuiLabel _TopInset;
    private GuiButton _BackButton;
    private GuiFloatButton _FloatButton;

    public PromptList(InstanceData data, Form previous) {
        _Data = data;
        _PrevForm = previous;
        _ResourceInstance = getGlobalResources();

        initializeLayout();
    }

    private void initializeLayout() {
        setLayout(new LayeredLayout());
        setInlineStylesTheme(_ResourceInstance);
        setScrollableY(true);
        setInlineStylesTheme(_ResourceInstance);
        setInlineAllStyles("bgColor:efefef;");
        setTitle("Mental Tracker");
        setName("Questions");

        createDefaultComponents();
    }

    private void createDefaultComponents() {
        PromptListCallback callback = new PromptListCallback();

        _TopInset = new GuiLabel("TopInset", _ResourceInstance);

        _BackButton = new GuiButton(
                ImageNames.BACK_UNSELECT,
                _ResourceInstance,
                ImageNames.BACK_UNSELECT,
                ImageNames.BACK_SELECT
        );
        _BackButton.setActionListener(callback);

        _FloatButton = new GuiFloatButton(FontImage.MATERIAL_ADD, "Add", callback);
        _FloatButton.addSubButton2(FontImage.MATERIAL_SUPERVISED_USER_CIRCLE, "Custom");
        _FloatButton.addSubButton1(FontImage.MATERIAL_LAYERS, "Default");

        initTopInset();
        initBackButton();
        initFloatButton();
        initPromptList();
    }

    private void onBackButton() {
        _PrevForm.showBack();
    }

    private void onAddPrompt() {

    }

    private void onAddDefault() {

    }

    private void onAddCustom() {

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

            if (sourceName.equals(_BackButton.getName())) {
                onBackButton();
            } else if (sourceName.equals(_FloatButton.getSub1Name())) {
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
        _Data.getInstancePrompts().deletePrompt(prompt);

        PromptList newList = new PromptList(_Data, _PrevForm);
        newList.show();
    }

    private void onEditPrompt(Object source) {
        PromptEditDelete target = (PromptEditDelete) source;
        MentalPrompt targetPrompt = target.getPrompt();

        EditPromptPage editPage = new EditPromptPage(_Data, this, targetPrompt);
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

    private void initTopInset() {
        _TopInset.setSizeStr("inherit 4.2328043mm");
        _TopInset.getLabel();
        addComponent(_TopInset.getLabel());

        ((LayeredLayout) _TopInset.getLabel().
                getParent().getLayout()).setInsets(
                _TopInset.getLabel(),
                "1.6mm 5.0mm auto 5.0mm").
                setReferenceComponents(
                        _TopInset.getLabel(), "-1 -1 -1 -1").
                setReferencePositions(
                        _TopInset.getLabel(), "0.0 0.0 0.0 0.0");
    }

    private void initBackButton() {
        _BackButton.setSizeStr("20.042328mm 10.8465605mm");
        addComponent(_BackButton.getButton());

        ((LayeredLayout) _BackButton.getButton().
                getParent().getLayout()).setInsets(
                _BackButton.getButton(),
                "0.5mm auto auto 0.0mm").
                setReferenceComponents(
                        _BackButton.getButton(), "0 -1 -1 0 ").
                setReferencePositions(
                        _BackButton.getButton(), "-1 0.0 0.0 0.0");
    }

    private void initFloatButton() {
        _FloatButton.getButton().bindFabToContainer(this.getContentPane());

    }

    private void initPromptList() {
        PromptChangedCallback callback = new PromptChangedCallback();

        float location = 1F;

        for (MentalPrompt prompt: _Data.getInstancePrompts().getPrompts()) {
            PromptEditDelete singlePrompt = new
                    PromptEditDelete(this, prompt, _ResourceInstance, callback);
            singlePrompt.initialize(location, _BackButton.getButton());
            _PromptList.add(singlePrompt);
            location += 0.5F;
        }
    }
}
