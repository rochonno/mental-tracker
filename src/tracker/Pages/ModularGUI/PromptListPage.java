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

public class PromptListPage extends DefaultPageComponents {

    private List<PromptEditDelete> _PromptList = new Vector<>();

    private GuiFloatButton _FloatButton;

    /**
     * Constructor of a page listing all the active prompts.
     * @param data Instance data of the prompts and results
     * @param previous the previous page.
     */
    public PromptListPage(InstanceData data, Form previous) {
        super(data, previous, "All Questions");

        setIsScrollable();
        createAllComponents();
    }

    /**
     * Creates all the components on this page.
     */
    private void createAllComponents() {
        initDefault();
        createDefaults();

        initFloatButton();
        createFloatButton();
        createPromptList();
    }

    /**
     * Maybe remove.
     */
    private void onAddPrompt() {
    }

    /**
     * Need to implement.
     * Should give the user a list to choose from with only the defaults
     *      not already in use.
     */
    private void onAddDefault() {
        Form addDefault = new AddDefaultPromptPage(getData(), getPreviousForm());
        addDefault.show();
    }

    /**
     * Called with the user pressed the create custom prompt button.
     */
    private void onAddCustom() {
        Form createPrompt = new CreatePromptPage(getData(), this);
        createPrompt.show();
    }

    /**
     * Action callback class for all components used on this page.
     * Called when an action is invoked.
     */
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

    /**
     * Called when the user chooses to delete a single prompt.
     * @param source The source prompt to delete
     */
    private void onDeletePrompt(Object source) {
        PromptEditDelete targetPrompt = (PromptEditDelete) source;
        MentalPrompt prompt = targetPrompt.getPrompt();
        getData().deletePrompt(prompt);

        PromptListPage newList = new PromptListPage(getData(), getPreviousForm());
        newList.show();
    }

    /**
     * Called with the user chooses to edit a single prompt.
     * @param source The source prompt to edit
     */
    private void onEditPrompt(Object source) {
        PromptEditDelete target = (PromptEditDelete) source;
        MentalPrompt targetPrompt = target.getPrompt();

        EditPromptPage editPage = new EditPromptPage(getData(), this, targetPrompt);
        editPage.show();
    }

    /**
     * Class that is called whenever the user chooses to edit or delete a prompt.
     * This is passed through to each prompt and invoke in it's method.
     */
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

    /**
     * Initializes the float button and its sub-buttons.
     */
    private void initFloatButton() {
        _FloatButton = new GuiFloatButton(FontImage.MATERIAL_ADD, "Add", new PromptListCallback());
        _FloatButton.addSubButton2(FontImage.MATERIAL_SUPERVISED_USER_CIRCLE, "Custom");
        _FloatButton.addSubButton1(FontImage.MATERIAL_LAYERS, "Default");
    }

    /**
     * Binds float button to the container.
     */
    private void createFloatButton() {
        _FloatButton.getButton().bindFabToContainer(this.getContentPane());
    }

    /**
     * Initialize all the prompts on the screen individually.
     * Stores each prompt in a list (_PromptList).
     */
    private void createPromptList() {
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
