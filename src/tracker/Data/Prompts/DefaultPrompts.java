/******************************************************************************
 * @author: Nolan Rochon
 * @date: 07/09/19
 * @project: Mental Health Tracker
 *
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
        String name = "Sleep";
        String prompt = "How much sleep did you get last night?";
        PromptDataType promptDataType = PromptDataType.DOUBLE;

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
        String prompt = "Did you exercise?";
        PromptDataType promptDataType = PromptDataType.BOOL;

        return createPrompt(name, prompt, promptDataType);
    }

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
        String prompt = "How confident have you felt recently?";
        PromptDataType promptDataType = PromptDataType.INT;

        return createPrompt(name, prompt, MIN, MAX, promptDataType);
    }

    static MentalPrompt createAnxietyPrompt() {
        String name = "Overall Anxiety";
        String prompt = "How anxious do you feel?";
        PromptDataType promptDataType = PromptDataType.INT;

        return createPrompt(name, prompt, MIN, MAX, promptDataType);
    }

    static MentalPrompt createStressPrompt() {
        String name = "Overall Stress";
        String prompt = "How stressed are you?";
        PromptDataType promptDataType = PromptDataType.INT;

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
        MentalPrompt newPrompt = new MentalPrompt(name, prompt, resultType);
        return newPrompt;
    }

    private static MentalPrompt createPrompt(
            final String name,
            final String prompt,
            final int max,
            final PromptDataType resultType) {
        MentalPrompt newPrompt = new MentalPrompt(name, prompt, resultType);
        newPrompt.setMax(max);
        return newPrompt;
    }

    private static MentalPrompt createPrompt(
            final String name,
            final String prompt,
            final int min,
            final int max,
            final PromptDataType resultType) {
        MentalPrompt newPrompt = new MentalPrompt(name, prompt, resultType);
        newPrompt.setMinMax(min, max);
        return newPrompt;
    }
}
