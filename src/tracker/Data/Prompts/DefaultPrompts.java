package tracker.Data.Prompts;

/******************************************************************************
 * This class constructs the basic default Prompts for the user individually.
 *
 * @author Nolan Rochon
 ******************************************************************************/
final class DefaultPrompts {

    /** Default minimum value for slider input. */
    private static final int MIN = 0;
    /** Default maximum value for slider input. */
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
        String prompt = "Hours of sleep last night";
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
        String prompt = "Recent mood (higher is better!)";
        PromptDataType promptDataType = PromptDataType.INT;

        return createPrompt(name, prompt, MIN, MAX, promptDataType);
    }

    /**
     * 
     * @return MentalPrompt
     */
    static MentalPrompt createExercisePrompt() {
        String name = "Exercise";
        String prompt = "Did you exercise recently?";
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
        String name = "Mood Shifts";
        String prompt = "Noticeable mood shifts since yesterday";
        PromptDataType promptDataType = PromptDataType.INT;

        return createPrompt(name, prompt, MIN, MAX, promptDataType);
    }

    static MentalPrompt createConfidencePrompt() {
        String name = "Confidence Level";
        String prompt = "How confident have you felt recently?";
        PromptDataType promptDataType = PromptDataType.INT;

        return createPrompt(name, prompt, MIN, MAX, promptDataType);
    }

    static MentalPrompt createAnxietyPrompt() {
        String name = "Anxiety";
        String prompt = "How anxious do you feel?";
        PromptDataType promptDataType = PromptDataType.INT;

        return createPrompt(name, prompt, MIN, MAX, promptDataType);
    }

    static MentalPrompt createStressPrompt() {
        String name = "Stress";
        String prompt = "How stressed are you?";
        PromptDataType promptDataType = PromptDataType.INT;

        return createPrompt(name, prompt, MIN, MAX, promptDataType);
    }

    static MentalPrompt createPanicPrompt() {
        String name = "Panic Symptoms";
        String prompt = "Any symptoms of panic recently?";
        PromptDataType promptDataType = PromptDataType.BOOL;

        return createPrompt(name, prompt, promptDataType);
    }

    static MentalPrompt createDepressedPrompt() {
        String name = "Depressed Mood";
        String prompt = "Have you had a depressed mood?";
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
            final int min,
            final int max,
            final PromptDataType resultType) {
        MentalPrompt newPrompt = new MentalPrompt(name, prompt, resultType);
        newPrompt.setMinMax(min, max);
        return newPrompt;
    }
}
