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

    public void deletePrompt(MentalPrompt prompt) {
        _AllPrompts.deletePrompt(prompt);
    }

    public void changePrompt(MentalPrompt target, MentalPrompt changed) {
        _AllPrompts.changePrompt(target, changed);
    }

    public void addPrompt(MentalPrompt prompt) {
        _AllPrompts.add(prompt);
    }

    public MentalPrompts getInstancePrompts() {
        return _AllPrompts;
    }

    public void setInstancePrompts(MentalPrompts prompts) {
        _AllPrompts = prompts;
    }

    public void addResult(PromptResult result) {
        _AllAnswers.addResult(result);
    }

    public PromptResults getInstanceResults() {
        return _AllAnswers;
    }

    public void setInstanceResults(PromptResults results) {
        _AllAnswers = results;
    }

    public boolean getHasAnswered() {
        return _HasAnswered;
    }

    public void setHasAnswered(boolean hasAnswered) {
        _HasAnswered = true;
    }
}
