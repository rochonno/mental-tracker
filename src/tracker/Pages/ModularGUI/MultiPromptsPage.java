package tracker.Pages.ModularGUI;

import com.codename1.io.Log;
import com.codename1.ui.Form;
import tracker.Data.InstanceData;
import tracker.Data.Prompts.MentalPrompt;
import tracker.Data.Prompts.PromptResult;
import tracker.GuiComponents.Containers.SinglePromptDisplay;
import tracker.MentalExceptions.EmptyStringException;

import java.util.List;
import java.util.Vector;

/**
 * @author Nolan Rochon
 *
 * Parent page for the prompts.
 * This genereates each prompt and collects the input from the user.
 */
public class MultiPromptsPage extends DefaultPageComponents {

    /** Current index in the prompt list. */
    private int _PromptIndex;
    /** List of all prompts created in the Gui. */
    private List<SinglePromptDisplay> _GuiPrompts = new Vector<>();

    /**
     * Curstuctor for the MulitPromptPage.
     * @param data the instance data for prompts and results.
     * @param previous The previous Form.
     * @param promptIndex The Index of the next prompt in the list to ask.
     */
    public MultiPromptsPage(InstanceData data, Form previous, final int promptIndex) {
        super(data, previous, "Daily Tracking");
        _PromptIndex = promptIndex;

        super.initDefault();
        super.initConfirmButton();
        super.createComponents();

        createPrompts();
    }

    /**
     * Create all the prompts in the Gui.
     */
    private void createPrompts() {

        for (int location = 1; location <= 4; location++) {
            if (_PromptIndex >= getData().getInstancePrompts().getPromptCount()) {
                break;
            }
            _GuiPrompts.add(createPrompt(location));
        }
    }

    private void promptsComplete() {
        getData().setHasAnswered(true);
        MainPage main = new MainPage(getData());
        main.show();
    }

    /**
     * Create a single prompt in the Gui.
     * @param location The location of the prompt in the Gui.
     *                 Used to space them vertically.
     *                 Is spaced according to a reference component
     *                      passed through in initialize().
     * @return SinglePromptDisplay The Gui for an individual prompt.
     */
    private SinglePromptDisplay createPrompt(final int location) {
        MentalPrompt prompt = getData().getSinglePrompt(_PromptIndex++);
        SinglePromptDisplay newPrompt = new SinglePromptDisplay(this, prompt, getResources());
        newPrompt.initialize(location, getBackButton().getButton());
        return newPrompt;
    }


    /**
     * Called when the confirm/next button is pressed.
     * Need to check for answers before continuing.
     */
    @Override
    void onConfirmButton() {
        if (!checkForAnswers()) {
            // TODO: remind the user to answer all the prompts
            return;
        }
        convertAnswers();

        if (_PromptIndex >= getData().getInstancePrompts().getPromptCount()) {
            promptsComplete();
            return;
        }

        MultiPromptsPage nextPrompts =
                new MultiPromptsPage(getData(), this, _PromptIndex);
        nextPrompts.show();
    }

    /**
     * Checks if all the prompts have been answered.
     * @return boolean If all prompts have been answered.
     */
    private boolean checkForAnswers()
    {
        boolean answered = true;

        for (SinglePromptDisplay guiPrompt : _GuiPrompts) {
            if (guiPrompt.getResult() == null) {
                answered = false;
            } else if (guiPrompt.getResult().length() == 0) {
                answered = false;
            }
        }

        return answered;
    }

    /**
     * Converts all answers from the entered data in the prompt Gui.
     */
    private void convertAnswers() {
        for (SinglePromptDisplay guiPrompt : _GuiPrompts) {
            MentalPrompt prompt = guiPrompt.getPrompt();
            PromptResult result = null;
            try {
                result = new PromptResult(
                        prompt.getName(),
                        prompt.getDataType(),
                        guiPrompt.getResult()
                );
            } catch (EmptyStringException ex) {
                Log.e(ex.getCause());
            }

            if (result != null) {
                getData().addResult(result, 0);
                //TODO: fix list
            }
        }
    }
}
