package tracker.Data;

import tracker.Data.Prompts.MentalPrompt;
import tracker.Data.Prompts.MentalPrompts;
import tracker.Data.Prompts.PromptResult;
import tracker.Data.Prompts.PromptResults;

public class InstanceData {

    public InstanceData() {
        _HasAnswered = false;
    }

    private MentalPrompts _AllPrompts;
    private PromptResults _AllAnswers;

    private boolean _HasAnswered;

    public void deletePrompt(final MentalPrompt prompt) {
        _AllPrompts.deletePrompt(prompt);
    }

    public void changePrompt(final MentalPrompt target, MentalPrompt changed) {
        _AllPrompts.changePrompt(target, changed);
    }

    public void addPrompt(final MentalPrompt prompt) {
        _AllPrompts.add(prompt);
    }

    public MentalPrompt getSinglePrompt(int index) {
        return _AllPrompts.getPrompt(index);
    }

    public int getPromptIndex(MentalPrompt prompt) {
        return _AllPrompts.getIndex(prompt);
    }

    public MentalPrompts getInstancePrompts() {
        return _AllPrompts;
    }

    public void setInstancePrompts(final MentalPrompts prompts) {
        _AllPrompts = prompts;
    }

    public void addResult(final PromptResult result, final int index) {
        _AllAnswers.addResult(result, index);
    }

    public PromptResults getInstanceResults() {
        return _AllAnswers;
    }

    public void setInstanceResults(final PromptResults results) {
        _AllAnswers = results;
    }

    public boolean getHasAnswered() {
        return _HasAnswered;
    }

    public void setHasAnswered(final boolean hasAnswered) {
        _HasAnswered = true;
    }
}
