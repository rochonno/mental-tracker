/******************************************************************************
 * @author: Nolan Rochon
 * @project: Mental Health Tracker
 *
 * Local notification for reminding user to take medications.
 ******************************************************************************/
package tracker.Data.Reminders;

public class MedReminder {

    private String _Prompt;

    private UserNotification _UserNotify;
    private int _Hour;
    private int _Minute;
    private static final String NAME = "Medication Reminder";

    public MedReminder() {
        _Prompt = "Time to take your dose of medications!";
    }

    public void setNotification(
            final int hour,
            final int min,
            final boolean isDaily) {
        _Hour = hour;
        _Minute = min;


        _UserNotify = new UserNotification(NAME, _Prompt);
        _UserNotify.setTime(hour, _Minute);
        if (isDaily) {
            _UserNotify.activateDaily();
        } else {
            _UserNotify.activateWeekly();
        }
    }

    public void deactivate() {
        if (_UserNotify.isActivated()) {
            _UserNotify.deactivate();
        }
    }

    public int getHour() {
        return _Hour; }

    public int getMinute() {
        return _Minute; }
}
