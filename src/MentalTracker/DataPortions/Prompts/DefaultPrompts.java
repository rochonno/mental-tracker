/*******************************************************************************************
 * @author: Nolan Rochon
 * @date: 07/09/19
 * @project: Mental Health Tracker
 *
 * This class constructs the basic default prompts for the user individually
 *******************************************************************************************/
package MentalTracker.DataPortions.Prompts;

public class DefaultPrompts {

    /**
     *
     * @return MentalPrompt for the hours of sleep
     */
    public static MentalPrompt CreateSleepPrompt ()
    {
        String name = "Sleep";
        String prompt = "How much sleep did you get last night?";
        int min = 0;
        int max = 24;
        PromptDataType promptDataType = PromptDataType.DOUBLE;

        MentalPrompt sleep = CreatePrompt(name, prompt, min, max, promptDataType);
        return sleep;
    }

    /**
     *
     * @return MentalPrompt for the mood
     */
    public static MentalPrompt CreateMoodPrompt ()
    {
        String name = "Recent Mood";
        String prompt = "Rate your recent mood (higher is better!)";
        int min = 0;
        int max = 20;
        PromptDataType promptDataType = PromptDataType.INT;

        return CreatePrompt(name, prompt, min, max, promptDataType);
    }

    /**
     * 
     * @return
     */
    public static MentalPrompt CreateExercisePrompt ()
    {
        String name = "Exercise Past Day";
        String prompt = "Did you exercise?";
        PromptDataType promptDataType = PromptDataType.BOOL;

        return CreatePrompt(name, prompt, promptDataType);
    }

    public static MentalPrompt CreateSugarPrompt ()
    {
        String name = "Sugar Past Day";
        String prompt = "Grams of sugar consumed";
        PromptDataType promptDataType = PromptDataType.INT;

        return CreatePrompt(name, prompt, 0, 200, promptDataType);
    }

    public static MentalPrompt CreateMoodShiftPrompt ()
    {
        String name = "Mood Shifts Past Day";
        String prompt = "Mod shifts experienced since the last check-in?";
        PromptDataType promptDataType = PromptDataType.INT;

        return CreatePrompt (name, prompt, 0, 20, promptDataType );
    }

    public static MentalPrompt CreateConfidencePrompt ()
    {
        String name = "Overall Confidence Level";
        String prompt = "How confident have you felt recently?";
        PromptDataType promptDataType = PromptDataType.INT;

        return CreatePrompt (name, prompt, 0, 20, promptDataType);
    }

    public static MentalPrompt CreateAnxietyPrompt ()
    {
        String name = "Overall Anxiety";
        String prompt = "How anxious do you feel?";
        PromptDataType promptDataType = PromptDataType.INT;
        int max = 10;

        return CreatePrompt (name, prompt, 0, 20, promptDataType);
    }

    public static MentalPrompt CreateStressPrompt ()
    {
        String name = "Overall Stress";
        String prompt = "How stressed are you?";
        PromptDataType promptDataType = PromptDataType.INT;
        int max = 10;

        return CreatePrompt (name, prompt, 0, 20, promptDataType);
    }

    public static MentalPrompt CreatePanicPrompt ()
    {
        String name = "Recent Panic Symptoms";
        String prompt = "Any experiences symptoms of panic?";
        PromptDataType promptDataType = PromptDataType.BOOL;

        return CreatePrompt (name, prompt, promptDataType);
    }

    public static MentalPrompt CreateDepressedPrompt ()
    {
        String name = "Depressed Mood";
        String prompt = "Have you experienced a depressed mood?";
        PromptDataType promptDataType = PromptDataType.BOOL;

        return CreatePrompt (name, prompt, 0, 10, promptDataType);
    }

    private static MentalPrompt CreatePrompt (String name, String prompt, PromptDataType resultType)
    {
        MentalPrompt newPrompt = new MentalPrompt(name, prompt, resultType);
        return newPrompt;
    }

    private static MentalPrompt CreatePrompt (String name, String prompt, int max, PromptDataType resultType)
    {
        MentalPrompt newPrompt = new MentalPrompt(name, prompt, resultType);
        newPrompt.SetMax(max);
        return newPrompt;
    }

    private static MentalPrompt CreatePrompt (String name, String prompt, int min, int max, PromptDataType resultType)
    {
        MentalPrompt newPrompt = new MentalPrompt(name, prompt, resultType);
        newPrompt.SetMinMax(min, max);
        return newPrompt;
    }
}
