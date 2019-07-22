/******************************************************************************
 * @author: Nolan Rochon
 * @date: 07/09/19
 * @project: Mental Health Tracker
 *
 * This class constructs the basic default prompts for the user individually
 ******************************************************************************/

package MentalTracker.DataPortions.Prompts;

class DefaultPrompts {

    private static final int MIN = 0;
    private static final int MAX = 20;
    /**
     *
     * @return MentalPrompt for the hours of sleep
     */
    static MentalPrompt CreateSleepPrompt() {
        String name = "Sleep";
        String prompt = "How much sleep did you get last night?";
        PromptDataType promptDataType = PromptDataType.DOUBLE;

        MentalPrompt sleep =
                CreatePrompt(name, prompt, MIN, MAX, promptDataType);
        return sleep;
    }

    /**
     *
     * @return MentalPrompt for the mood
     */
    static MentalPrompt CreateMoodPrompt() {
        String name = "Recent Mood";
        String prompt = "Rate your recent mood (higher is better!)";
        PromptDataType promptDataType = PromptDataType.INT;

        return CreatePrompt(name, prompt, MIN, MAX, promptDataType);
    }

    /**
     * 
     * @return
     */
    static MentalPrompt CreateExercisePrompt() {
        String name = "Exercise Past Day";
        String prompt = "Did you exercise?";
        PromptDataType promptDataType = PromptDataType.BOOL;

        return CreatePrompt(name, prompt, promptDataType);
    }

    static MentalPrompt CreateSugarPrompt() {
        String name = "Sugar Past Day";
        String prompt = "Grams of sugar consumed";
        PromptDataType promptDataType = PromptDataType.INT;

        return CreatePrompt(name, prompt, MIN, MAX, promptDataType);
    }

    static MentalPrompt CreateMoodShiftPrompt() {
        String name = "Mood Shifts Past Day";
        String prompt = "Mod shifts experienced since the last check-in?";
        PromptDataType promptDataType = PromptDataType.INT;

        return CreatePrompt(name, prompt, MIN, MAX, promptDataType);
    }

    static MentalPrompt CreateConfidencePrompt() {
        String name = "Overall Confidence Level";
        String prompt = "How confident have you felt recently?";
        PromptDataType promptDataType = PromptDataType.INT;

        return CreatePrompt(name, prompt, MIN, MAX, promptDataType);
    }

    static MentalPrompt CreateAnxietyPrompt() {
        String name = "Overall Anxiety";
        String prompt = "How anxious do you feel?";
        PromptDataType promptDataType = PromptDataType.INT;

        return CreatePrompt(name, prompt, MIN, MAX, promptDataType);
    }

    static MentalPrompt CreateStressPrompt() {
        String name = "Overall Stress";
        String prompt = "How stressed are you?";
        PromptDataType promptDataType = PromptDataType.INT;

        return CreatePrompt(name, prompt, MIN, MAX, promptDataType);
    }

    static MentalPrompt CreatePanicPrompt() {
        String name = "Recent Panic Symptoms";
        String prompt = "Any experiences symptoms of panic?";
        PromptDataType promptDataType = PromptDataType.BOOL;

        return CreatePrompt(name, prompt, promptDataType);
    }

    static MentalPrompt CreateDepressedPrompt() {
        String name = "Depressed Mood";
        String prompt = "Have you experienced a depressed mood?";
        PromptDataType promptDataType = PromptDataType.BOOL;

        return CreatePrompt(name, prompt, MIN, MAX, promptDataType);
    }

    private static MentalPrompt CreatePrompt(
            final String name,
            final String prompt,
            final PromptDataType resultType) {
        MentalPrompt newPrompt = new MentalPrompt(name, prompt, resultType);
        return newPrompt;
    }

    private static MentalPrompt CreatePrompt(
            final String name,
            final String prompt,
            final int max,
            final PromptDataType resultType) {
        MentalPrompt newPrompt = new MentalPrompt(name, prompt, resultType);
        newPrompt.SetMax(max);
        return newPrompt;
    }

    private static MentalPrompt CreatePrompt(
            final String name,
            final String prompt,
            final int min,
            final int max,
            final PromptDataType resultType) {
        MentalPrompt newPrompt = new MentalPrompt(name, prompt, resultType);
        newPrompt.SetMinMax(min, max);
        return newPrompt;
    }
}
