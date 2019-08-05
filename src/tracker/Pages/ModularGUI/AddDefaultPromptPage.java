package tracker.Pages.ModularGUI;

import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import tracker.Data.InstanceData;
import tracker.Data.Prompts.GenerateDefaultPrompts;
import tracker.Data.Prompts.MentalPrompt;
import tracker.Data.Prompts.MentalPrompts;
import tracker.GuiComponents.Containers.PromptAdd;
import tracker.GuiComponents.Individual.GuiButton;

import java.util.List;
import java.util.Vector;

/**
 * Page for adding any default prompt that is not already included.
 */
public class AddDefaultPromptPage extends DefaultPageComponents {

    private MentalPrompts _DefaultPrompts;
    private List<PromptAdd> _PromptList = new Vector<>();

    /**
     * Constructor of a page listing all the default prompts not in use.
     *
     * @param data Instance data of the prompts and results
     * @param previous the previous page.
     */
    public AddDefaultPromptPage(InstanceData data, Form previous) {
        super(data, previous, "Choose Default");

        _DefaultPrompts = GenerateDefaultPrompts.defaultMorningOnlyPrompts();

        setIsScrollable();
        createAllComponents();
    }

    /**
     * Creates all the components on this page.
     */
    private void createAllComponents() {
        initDefault();
        createDefaults();

        initPromptList();
    }

    private void onAddPrompt(Object source) {
        PromptAdd target = (PromptAdd) source;
        getData().addPrompt(target.getPrompt());

        Form promptList = new PromptListPage(getData(), new MainPage(getData()));
        promptList.showBack();
    }

    /**
     * Class that is called whenever the user chooses to edit or delete a prompt.
     * This is passed through to each prompt and invoke in it's method.
     */
    class PromptAddCallback implements ActionListener {

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        public void actionPerformed(ActionEvent e) {


            if (e.getKeyEvent() == 0) {
                onAddPrompt(e.getSource());
            }
        }
    }


    /**
     * Initialize all the prompts on the screen individually.
     * Stores each prompt in a list (_PromptList).
     */
    private void initPromptList() {
        PromptAddCallback callback = new PromptAddCallback();

        float location = 1F;

        for (MentalPrompt prompt: _DefaultPrompts.getPrompts()) {
            if (getData().hasPrompt(prompt)) {
                continue;
            }
            PromptAdd singlePrompt = new
                    PromptAdd(this, prompt, getResources(), callback);
            singlePrompt.initialize(location, getBackButton().getButton());
            _PromptList.add(singlePrompt);
            location += 0.5F;
        }
    }
}
