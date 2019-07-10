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
        DataType dataType = DataType.DOUBLE;

        MentalPrompt sleep = CreatePrompt(name, prompt, min, max, dataType);
        return sleep;
    }

    public static MentalPrompt CreateMoodPrompt ()
    {
        String name = "Mood";
        String prompt = "Rate your current mood (higher is better!)";
        int min = 0;
        int max = 10;
        DataType dataType = DataType.INT;

        return CreatePrompt(name, prompt, min, max, dataType);
    }

    public static MentalPrompt CreateExercisePrompt ()
    {
        String name = "Exercise";
        String prompt = "Did you exercise?";
        DataType dataType = DataType.BOOL;

        return CreatePrompt(name, prompt, dataType);
    }

    public static MentalPrompt CreateSugarPrompt ()
    {
        String name = "Sugar";
        String prompt = "About how many grams of sugar did you consume?";
        DataType dataType = DataType.INT;

        return CreatePrompt(name, prompt, dataType);
    }

    public static MentalPrompt CreateMoodShiftPrompt ()
    {
        String name = "Mood Shift";
        String prompt = "How many mood shifts have you experienced since the last check-in?";
        DataType dataType = DataType.INT;

        return CreatePrompt (name, prompt, dataType);
    }

    public static MentalPrompt CreateConfidencePrompt ()
    {
        String name = "Confidence Level";
        String prompt = "How confident have you felt recently?";
        DataType dataType = DataType.INT;
        int max = 10;

        return CreatePrompt (name, prompt, max, dataType);
    }

    public static MentalPrompt CreateAnxietyPrompt ()
    {
        String name = "Anxiety";
        String prompt = "How anxious do you feel?";
        DataType dataType = DataType.INT;
        int max = 10;

        return CreatePrompt (name, prompt, max, dataType);
    }

    public static MentalPrompt CreateStressPrompt ()
    {
        String name = "Stress";
        String prompt = "How stressed are you?";
        DataType dataType = DataType.INT;
        int max = 10;

        return CreatePrompt (name, prompt, max, dataType);
    }

    public static MentalPrompt CreatePanicPrompt ()
    {
        String name = "Panic Symptoms";
        String prompt = "Have you experiences symptoms of panic recently?";
        DataType dataType = DataType.BOOL;

        return CreatePrompt (name, prompt, dataType);
    }

    public static MentalPrompt CreateDepressedPrompt ()
    {
        String name = "Depressed Prompt";
        String prompt = "Have you experienced a depressed mood?";
        DataType dataType = DataType.BOOL;

        return CreatePrompt (name, prompt, dataType);
    }

    private static MentalPrompt CreatePrompt (String name, String prompt, DataType resultType)
    {
        MentalPrompt newPrompt = new MentalPrompt(name, prompt, resultType);
        return newPrompt;
    }

    private static MentalPrompt CreatePrompt (String name, String prompt, int max, DataType resultType)
    {
        MentalPrompt newPrompt = new MentalPrompt(name, prompt, resultType);
        newPrompt.SetMax(max);
        return newPrompt;
    }

    private static MentalPrompt CreatePrompt (String name, String prompt, int min, int max, DataType resultType)
    {
        MentalPrompt newPrompt = new MentalPrompt(name, prompt, resultType);
        newPrompt.SetMinMax(min, max);
        return newPrompt;
    }
}
