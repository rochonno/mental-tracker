package tracker.Data;


import tracker.Data.Prompts.MentalPrompt;
import tracker.Data.Prompts.MentalPrompts;
import tracker.Data.Prompts.PromptResult;
import tracker.Data.Prompts.PromptResults;
import tracker.Data.Prompts.PromptDataType;

/**
 * Holds all the data needed for normal running of the application.
 */
public class InstanceData {

    public InstanceData() {
        _HasAnswered = false;
    }

    /** All the current prompts. */
    private MentalPrompts _AllPrompts;
    /** The prompt results. */
    private PromptResults _AllAnswers;

    /** If the user has answered the daily prompts. */
    private boolean _HasAnswered;

    /**
     * Deletes the specified prompt from the list.
     *
     * @param prompt Prompt to find and delete
     */
    public void deletePrompt(final MentalPrompt prompt) {
        _AllPrompts.deletePrompt(prompt);
    }

    /**
     * Changes the target prompt to the changed prompt.
     *
     * @param target The one to change
     * @param changed What to change it to
     */
    public void changePrompt(
            final MentalPrompt target,
            final MentalPrompt changed) {
        _AllPrompts.changePrompt(target, changed);
    }

    /**
     * Adds a prompt to the list.
     *
     * @param prompt Prompt to be added
     */
    public void addPrompt(final MentalPrompt prompt) {
        _AllPrompts.add(prompt);
    }

    /**
     * Gets a prompt at specified index.
     *
     * @param index Where to find the prompt.
     * @return MentalPrompt The prompt at the index
     */
    public MentalPrompt getSinglePrompt(final int index) {
        return _AllPrompts.getPrompt(index);
    }

    /**
     * Gets the index of the specified prompt.
     *
     * @param prompt What prompt to look for.
     * @return index Location of the prompt
     */
    public int getPromptIndex(final MentalPrompt prompt) {
        return _AllPrompts.getIndex(prompt);
    }

    /**
     * Gets if the list has the prompt.
     *
     * @param prompt What prompt to look for
     * @return boolean if the prompt is found
     */
    public boolean hasPrompt(final MentalPrompt prompt) {
        return _AllPrompts.doesContain(prompt);
    }

    /**
     * Returns all the current prompts.
     *
     * @return MentalPrompts all the prompts
     */
    public MentalPrompts getInstancePrompts() {
        return _AllPrompts;
    }

    /**
     * Sets the prompts.
     * Usually for loading from file or generating defaults.
     * @param prompts those to be set
     */
    public void setInstancePrompts(final MentalPrompts prompts) {
        _AllPrompts = prompts;
    }

    /**
     * Adds a result at a specified index.
     *
     * @param result The result to be added
     * @param index Where to add the result
     */
    public void addResult(final PromptResult result, final int index) {
        _AllAnswers.addResult(result, index);
    }

    /**
     * Gets the PromptResults.
     *
     * @return PromptResults all the prompt results
     */
    public PromptResults getInstanceResults() {
        return _AllAnswers;
    }

    /**
     * Sets the PromptResults.
     *
     * @param results the results to be set.
     */
    public void setInstanceResults(final PromptResults results) {
        _AllAnswers = results;
    }

    /**
     * Stores if the prompts have been answered today yet.
     *
     * @return boolean if the user has answered the prompts yet.
     */
    public boolean getHasAnswered() {
        return _HasAnswered;
    }

    /**
     * Sets if the user has answered the prompts yet.
     *
     * @param hasAnswered Has the user answered the prompts today
     */
    public void setHasAnswered(final boolean hasAnswered) {
        _HasAnswered = true;
    }

    public PromptDataType getTypeFromName(final String name) {
        return _AllPrompts.findFromName(name).getDataType();
    }
}
