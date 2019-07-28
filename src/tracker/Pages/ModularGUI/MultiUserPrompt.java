package tracker.Pages.ModularGUI;

import com.codename1.ui.Form;
import com.codename1.ui.util.Resources;
import tracker.Data.Prompts.MentalPrompt;
import tracker.Data.Prompts.MentalPrompts;
import tracker.Data.Prompts.PromptResults;

import static com.codename1.ui.util.Resources.getGlobalResources;

public class MultiUserPrompt extends Form {

    private Form _NextForm;
    private Form _PrevForm;

    private MentalPrompts _AllPrompts;
    private PromptResults _AllResults;

    private Resources _ResourceInstance;

    private SinglePromptDisplay _Prompt1;
    private SinglePromptDisplay _Prompt2;
    private SinglePromptDisplay _Prompt3;

    public MultiUserPrompt(
            MentalPrompts prompts, PromptResults results, Form previous) {
        _PrevForm = previous;
        _ResourceInstance = getGlobalResources();
        _AllResults = results;
        _AllPrompts = prompts;

        if (prompts.getPromptCount() >= 3) {
            createThreePrompts();
        } else if (prompts.getPromptCount() == 2) {
            createTwoPrompts();
        } else if (prompts.getPromptCount() == 1) {
            createSinglePrompt();
        } else {
            promptsComplete();
        }
    }

    private void createThreePrompts() {
        createTwoPrompts();
        _Prompt3 = createPrompt(3);
    }

    private void createTwoPrompts() {
        createSinglePrompt();
        _Prompt2 = createPrompt(2);
    }

    private void createSinglePrompt() {
        _Prompt1 = createPrompt(1);
    }

    private void promptsComplete() {

    }

    private SinglePromptDisplay createPrompt(final int location) {
        MentalPrompt prompt = _AllPrompts.remove(0);
        SinglePromptDisplay newPrompt = new SinglePromptDisplay(prompt, _ResourceInstance);
        newPrompt.initialize(location);
        return newPrompt;
    }

}
