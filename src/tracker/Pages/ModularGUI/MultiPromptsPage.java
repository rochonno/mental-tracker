package tracker.Pages.ModularGUI;

import com.codename1.io.Log;
import com.codename1.ui.Dialog;
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
class MultiPromptsPage extends DefaultPageComponents {

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
    MultiPromptsPage(
            final InstanceData data,
            final Form previous,
            final int promptIndex) {
        super(data, previous, "Daily Tracking");
        _PromptIndex = promptIndex;

        super.initDefault();
        super.initConfirmButton();
        super.createDefaults();

        createPrompts();
    }

    /**
     * Create all the prompts in the Gui.
     */
    private void createPrompts() {

        int index = _PromptIndex;
        for (int location = 1; location <= 4; location++) {
            if (index >= getData().getInstancePrompts().getPromptCount()) {
                break;
            }
            _GuiPrompts.add(createPrompt(location, index++));
        }
    }

    private void promptsComplete() {
        getData().setHasAnswered(true);
        MainPage main = new MainPage(getData());
        main.show();
    }

    /**
     *
     * @param location
     * @param index
     * @return
     */
    /**
     * Create a single prompt in the Gui.
     * @param location The location of the prompt in the Gui.
     *                 Used to space them vertically.
     *                 Is spaced according to a reference component
     *                      passed through in initialize().
     * @param index Index of the prompt in the instance data prompt list
     * @return SinglePromptDisplay The Gui for an individual prompt.
     */
    private SinglePromptDisplay createPrompt(
            final int location,
            final int index) {

        MentalPrompt prompt = getData().getSinglePrompt(index);
        SinglePromptDisplay newPrompt =
                new SinglePromptDisplay(this, prompt, getResources());
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
            return;
        }
        convertAnswers();

        if (_PromptIndex >= getData().getInstancePrompts().getPromptCount()) {
            promptsComplete();
            return;
        }

        MultiPromptsPage nextPrompts = new MultiPromptsPage(
                getData(),
                this,
                _PromptIndex + _GuiPrompts.size()
        );

        nextPrompts.show();
    }

    /**
     * Checks if all the prompts have been answered.
     * @return boolean If all prompts have been answered.
     */
    private boolean checkForAnswers() {
        boolean answered = true;

        for (SinglePromptDisplay guiPrompt : _GuiPrompts) {
            boolean currAnswer = true;
            if (guiPrompt.getResult() == null) {
                currAnswer = false;
            } else if (guiPrompt.getResult().length() == 0) {
                currAnswer = false;
            }

            if (!currAnswer) {
                answered = false;
                String notAnsweredSrt = " has not been answered";
                Dialog.show(
                        "Missing Answer",
                        guiPrompt.getPrompt().getName() + notAnsweredSrt,
                        "OK!",
                        null
                );
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
