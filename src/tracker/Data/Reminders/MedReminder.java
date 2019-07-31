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
    private boolean _IsEnabled;

    public MedReminder() {
        _Prompt = "Time to take your dose of medications!";
        _IsEnabled = false;
    }

    public void setNotification() {
        _UserNotify = new UserNotification(NAME, _Prompt);
        _UserNotify.setTime(_Hour, _Minute);
        _UserNotify.activateDaily();
        _IsEnabled = true;
    }

    public void deactivate() {
        if(_IsEnabled) {
            _UserNotify.deactivate();
        }
    }

    public void setHour(final int hour) {
        _Hour = hour;
    }

    public void setMin(final int min) {
        _Minute = min;
    }

    public int getHour() {
        return _Hour;
    }

    public int getMinute() {
        return _Minute;
    }
}
