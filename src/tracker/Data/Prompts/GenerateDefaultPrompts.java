/*****************************************************************************
 * @author: Nolan Rochon
 * @date: 07/09/19
 * @project: Mental Health Tracker
 *
 * This class constructs the basic default Prompts for the user in groups
 ******************************************************************************/

package tracker.Data.Prompts;

public final class GenerateDefaultPrompts {

    private GenerateDefaultPrompts() {
    }

    public static MentalPrompts defaultMorningPrompts() {
        MentalPrompts morningPrompts = new MentalPrompts();

        morningPrompts.add(DefaultPrompts.createSleepPrompt());
        morningPrompts.add(DefaultPrompts.createMoodPrompt());
        morningPrompts.add(DefaultPrompts.createStressPrompt());
        morningPrompts.add(DefaultPrompts.createAnxietyPrompt());
        morningPrompts.add(DefaultPrompts.createMoodShiftPrompt());
        morningPrompts.add(DefaultPrompts.createConfidencePrompt());
        morningPrompts.add(DefaultPrompts.createDepressedPrompt());

        return morningPrompts;
    }

    public static MentalPrompts defaultEveningPrompts() {
        MentalPrompts eveningPrompts = new MentalPrompts();

        eveningPrompts.add(DefaultPrompts.createMoodPrompt());
        eveningPrompts.add(DefaultPrompts.createExercisePrompt());
        eveningPrompts.add(DefaultPrompts.createStressPrompt());
        eveningPrompts.add(DefaultPrompts.createAnxietyPrompt());
        eveningPrompts.add(DefaultPrompts.createPanicPrompt());
        eveningPrompts.add(DefaultPrompts.createMoodShiftPrompt());
        eveningPrompts.add(DefaultPrompts.createSugarPrompt());
        eveningPrompts.add(DefaultPrompts.createDepressedPrompt());

        return eveningPrompts;
    }

    public static MentalPrompts defaultMorningOnlyPrompts() {
        MentalPrompts morningPrompts = defaultEveningPrompts();

        morningPrompts.add(DefaultPrompts.createSleepPrompt());
        morningPrompts.add(DefaultPrompts.createConfidencePrompt());

        return morningPrompts;
    }
}
