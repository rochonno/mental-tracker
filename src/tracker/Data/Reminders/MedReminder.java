/******************************************************************************
 * @author: Nolan Rochon
 * @project: Mental Health Tracker
 *
 * Local notification for reminding user to take medications.
 ******************************************************************************/
package tracker.Data.Reminders;

/**
 * Reminder for medication.
 */
public final class MedReminder extends MentalReminder {

    public MedReminder() {
        super("Time to take your dose of medications!");
    }
}
