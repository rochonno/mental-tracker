/*******************************************************************************************
 * @author: Nolan Rochon
 * @date: 07/09/19
 * @project: Mental Health Tracker
 *
 * This class constructs the basic default prompts for the user in groups
 *******************************************************************************************/

package MentalTracker.DataPortions.Prompts;

public class GenerateDefaultPrompts {

    public static MentalPrompts DefaultMorningPrompts ()
    {
        MentalPrompts morningPrompts = new MentalPrompts();

        morningPrompts.add( DefaultPrompts.CreateSleepPrompt() );
        morningPrompts.add( DefaultPrompts.CreateMoodPrompt() );
        morningPrompts.add( DefaultPrompts.CreateStressPrompt() );
        morningPrompts.add( DefaultPrompts.CreateAnxietyPrompt() );
        morningPrompts.add( DefaultPrompts.CreateMoodShiftPrompt() );
        morningPrompts.add( DefaultPrompts.CreateConfidencePrompt() );
        morningPrompts.add( DefaultPrompts.CreateDepressedPrompt() );

        return morningPrompts;
    }

    public static MentalPrompts DefaultEveningPrompts ()
    {
        MentalPrompts eveningPrompts = new MentalPrompts();

        eveningPrompts.add( DefaultPrompts.CreateMoodPrompt() );
        eveningPrompts.add( DefaultPrompts.CreateExercisePrompt() );
        eveningPrompts.add( DefaultPrompts.CreateStressPrompt() );
        eveningPrompts.add( DefaultPrompts.CreateAnxietyPrompt() );
        eveningPrompts.add( DefaultPrompts.CreatePanicPrompt() );
        eveningPrompts.add( DefaultPrompts.CreateMoodShiftPrompt() );
        eveningPrompts.add( DefaultPrompts.CreateSugarPrompt() );
        eveningPrompts.add( DefaultPrompts.CreateDepressedPrompt() );

        return eveningPrompts;
    }

    public static MentalPrompts DefaultMorningOnlyPrompts ()
    {
        MentalPrompts morningPrompts = DefaultEveningPrompts();

        morningPrompts.add( DefaultPrompts.CreateSleepPrompt() );
        morningPrompts.add( DefaultPrompts.CreateConfidencePrompt() );

        return morningPrompts;
    }
}
