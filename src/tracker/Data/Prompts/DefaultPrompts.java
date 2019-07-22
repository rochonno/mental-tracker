/*******************************************************************************************
 * @author: Nolan Rochon
 * @date: 07/09/19
 * @project: Mental Health Tracker
 *
<<<<<<< Updated upstream:src/MentalTracker/DataPortions/Prompts/DefaultPrompts.java
 * This class constructs the basic default prompts for the user individually
 *******************************************************************************************/
package MentalTracker.DataPortions.Prompts;

public class DefaultPrompts {

    public static MentalPrompt CreateSleepPrompt ()
    {
=======
 * This class constructs the basic default Prompts for the user individually
 ******************************************************************************/

package tracker.Data.Prompts;

final class DefaultPrompts {

    private static final int MIN = 0;
    private static final int MAX = 20;

    private DefaultPrompts() {
        // No-op; won't be called
    }

    /**
     *
     * @return MentalPrompt for the hours of sleep
     */
    static MentalPrompt createSleepPrompt() {
>>>>>>> Stashed changes:src/tracker/Data/Prompts/DefaultPrompts.java
        String name = "Sleep";
        String prompt = "How much sleep did you get last night?";
        int min = 0;
        int max = 24;
        PromptDataType promptDataType = PromptDataType.DOUBLE;

<<<<<<< Updated upstream:src/MentalTracker/DataPortions/Prompts/DefaultPrompts.java
        MentalPrompt sleep = CreatePrompt(name, prompt, min, max, promptDataType);
        return sleep;
    }

    public static MentalPrompt CreateMoodPrompt ()
    {
        String name = "Mood";
        String prompt = "Rate your current mood (higher is better!)";
        int min = 0;
        int max = 10;
        PromptDataType promptDataType = PromptDataType.INT;

        return CreatePrompt(name, prompt, min, max, promptDataType);
    }

    public static MentalPrompt CreateExercisePrompt ()
    {
        String name = "Exercise";
=======
        MentalPrompt sleep =
                createPrompt(name, prompt, MIN, MAX, promptDataType);
        return sleep;
    }

    /**
     *
     * @return MentalPrompt for the mood
     */
    static MentalPrompt createMoodPrompt() {
        String name = "Recent Mood";
        String prompt = "Rate your recent mood (higher is better!)";
        PromptDataType promptDataType = PromptDataType.INT;

        return createPrompt(name, prompt, MIN, MAX, promptDataType);
    }

    /**
     * 
     * @return
     */
    static MentalPrompt createExercisePrompt() {
        String name = "Exercise Past Day";
>>>>>>> Stashed changes:src/tracker/Data/Prompts/DefaultPrompts.java
        String prompt = "Did you exercise?";
        PromptDataType promptDataType = PromptDataType.BOOL;

        return createPrompt(name, prompt, promptDataType);
    }

<<<<<<< Updated upstream:src/MentalTracker/DataPortions/Prompts/DefaultPrompts.java
    public static MentalPrompt CreateSugarPrompt ()
    {
        String name = "Sugar";
        String prompt = "About how many grams of sugar did you consume?";
        PromptDataType promptDataType = PromptDataType.INT;

        return CreatePrompt(name, prompt, promptDataType);
    }

    public static MentalPrompt CreateMoodShiftPrompt ()
    {
        String name = "Mood Shift";
        String prompt = "How many mood shifts have you experienced since the last check-in?";
        PromptDataType promptDataType = PromptDataType.INT;

        return CreatePrompt (name, prompt, promptDataType);
    }

    public static MentalPrompt CreateConfidencePrompt ()
    {
        String name = "Confidence Level";
=======
    static MentalPrompt createSugarPrompt() {
        String name = "Sugar Past Day";
        String prompt = "Grams of sugar consumed";
        PromptDataType promptDataType = PromptDataType.INT;

        return createPrompt(name, prompt, MIN, MAX, promptDataType);
    }

    static MentalPrompt createMoodShiftPrompt() {
        String name = "Mood Shifts Past Day";
        String prompt = "Mod shifts experienced since the last check-in?";
        PromptDataType promptDataType = PromptDataType.INT;

        return createPrompt(name, prompt, MIN, MAX, promptDataType);
    }

    static MentalPrompt createConfidencePrompt() {
        String name = "Overall Confidence Level";
>>>>>>> Stashed changes:src/tracker/Data/Prompts/DefaultPrompts.java
        String prompt = "How confident have you felt recently?";
        PromptDataType promptDataType = PromptDataType.INT;
        int max = 10;

<<<<<<< Updated upstream:src/MentalTracker/DataPortions/Prompts/DefaultPrompts.java
        return CreatePrompt (name, prompt, max, promptDataType);
    }

    public static MentalPrompt CreateAnxietyPrompt ()
    {
        String name = "Anxiety";
=======
        return createPrompt(name, prompt, MIN, MAX, promptDataType);
    }

    static MentalPrompt createAnxietyPrompt() {
        String name = "Overall Anxiety";
>>>>>>> Stashed changes:src/tracker/Data/Prompts/DefaultPrompts.java
        String prompt = "How anxious do you feel?";
        PromptDataType promptDataType = PromptDataType.INT;
        int max = 10;

<<<<<<< Updated upstream:src/MentalTracker/DataPortions/Prompts/DefaultPrompts.java
        return CreatePrompt (name, prompt, max, promptDataType);
    }

    public static MentalPrompt CreateStressPrompt ()
    {
        String name = "Stress";
=======
        return createPrompt(name, prompt, MIN, MAX, promptDataType);
    }

    static MentalPrompt createStressPrompt() {
        String name = "Overall Stress";
>>>>>>> Stashed changes:src/tracker/Data/Prompts/DefaultPrompts.java
        String prompt = "How stressed are you?";
        PromptDataType promptDataType = PromptDataType.INT;
        int max = 10;

<<<<<<< Updated upstream:src/MentalTracker/DataPortions/Prompts/DefaultPrompts.java
        return CreatePrompt (name, prompt, max, promptDataType);
    }

    public static MentalPrompt CreatePanicPrompt ()
    {
        String name = "Panic Symptoms";
        String prompt = "Have you experiences symptoms of panic recently?";
        PromptDataType promptDataType = PromptDataType.BOOL;

        return CreatePrompt (name, prompt, promptDataType);
    }

    public static MentalPrompt CreateDepressedPrompt ()
    {
        String name = "Depressed Prompt";
        String prompt = "Have you experienced a depressed mood?";
        PromptDataType promptDataType = PromptDataType.BOOL;

        return CreatePrompt (name, prompt, promptDataType);
    }

    private static MentalPrompt CreatePrompt (String name, String prompt, PromptDataType resultType)
    {
=======
        return createPrompt(name, prompt, MIN, MAX, promptDataType);
    }

    static MentalPrompt createPanicPrompt() {
        String name = "Recent Panic Symptoms";
        String prompt = "Any experiences symptoms of panic?";
        PromptDataType promptDataType = PromptDataType.BOOL;

        return createPrompt(name, prompt, promptDataType);
    }

    static MentalPrompt createDepressedPrompt() {
        String name = "Depressed Mood";
        String prompt = "Have you experienced a depressed mood?";
        PromptDataType promptDataType = PromptDataType.BOOL;

        return createPrompt(name, prompt, MIN, MAX, promptDataType);
    }

    private static MentalPrompt createPrompt(
            final String name,
            final String prompt,
            final PromptDataType resultType) {
>>>>>>> Stashed changes:src/tracker/Data/Prompts/DefaultPrompts.java
        MentalPrompt newPrompt = new MentalPrompt(name, prompt, resultType);
        return newPrompt;
    }

<<<<<<< Updated upstream:src/MentalTracker/DataPortions/Prompts/DefaultPrompts.java
    private static MentalPrompt CreatePrompt (String name, String prompt, int max, PromptDataType resultType)
    {
=======
    private static MentalPrompt createPrompt(
            final String name,
            final String prompt,
            final int max,
            final PromptDataType resultType) {
>>>>>>> Stashed changes:src/tracker/Data/Prompts/DefaultPrompts.java
        MentalPrompt newPrompt = new MentalPrompt(name, prompt, resultType);
        newPrompt.SetMax(max);
        return newPrompt;
    }

<<<<<<< Updated upstream:src/MentalTracker/DataPortions/Prompts/DefaultPrompts.java
    private static MentalPrompt CreatePrompt (String name, String prompt, int min, int max, PromptDataType resultType)
    {
=======
    private static MentalPrompt createPrompt(
            final String name,
            final String prompt,
            final int min,
            final int max,
            final PromptDataType resultType) {
>>>>>>> Stashed changes:src/tracker/Data/Prompts/DefaultPrompts.java
        MentalPrompt newPrompt = new MentalPrompt(name, prompt, resultType);
        newPrompt.SetMinMax(min, max);
        return newPrompt;
    }
}
