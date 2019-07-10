/*******************************************************************************************
 * @author: Nolan Rochon
 * @date: 07/09/19
 * @project: Mental Health Tracker
 *
 * This class constructs the basic default prompts for the user individually
 *******************************************************************************************/
package MentalTracker.DataPortions.Prompts;

public class DefaultPrompts {

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
        String prompt = "Did you exercise?";
        PromptDataType promptDataType = PromptDataType.BOOL;

        return CreatePrompt(name, prompt, promptDataType);
    }

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
        String prompt = "How confident have you felt recently?";
        PromptDataType promptDataType = PromptDataType.INT;
        int max = 10;

        return CreatePrompt (name, prompt, max, promptDataType);
    }

    public static MentalPrompt CreateAnxietyPrompt ()
    {
        String name = "Anxiety";
        String prompt = "How anxious do you feel?";
        PromptDataType promptDataType = PromptDataType.INT;
        int max = 10;

        return CreatePrompt (name, prompt, max, promptDataType);
    }

    public static MentalPrompt CreateStressPrompt ()
    {
        String name = "Stress";
        String prompt = "How stressed are you?";
        PromptDataType promptDataType = PromptDataType.INT;
        int max = 10;

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
