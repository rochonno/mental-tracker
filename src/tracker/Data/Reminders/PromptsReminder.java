/******************************************************************************
 * @author: Nolan Rochon
 * @project: Mental Health Tracker
 *
 * Local notification for reminding user to answer the daily prompts.
 ******************************************************************************/
package tracker.Data.Reminders;

/**
 * Reminder to answer the daily prompts.
 */
public final class PromptsReminder extends MentalReminder {

    public PromptsReminder() {
        super("Time to take your dose of medications!");
    }

}
