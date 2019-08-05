/******************************************************************************
 * @author: Nolan Rochon
 * @project: Mental Health Tracker
 *
 * Local notification for reminding user to answer the daily prompts.
 ******************************************************************************/
package tracker.Data.Reminders;

public final class PromptsReminder {

    private String _Prompt;
    private UserNotification _UserNotify;

    private int _Hour;
    private int _Minute;
    private boolean _IsEnabled;

    private static final String NAME = "Prompts Reminder";

    public PromptsReminder() {
        _Prompt = "Take a break for a minute to answer a few questions!";
        _IsEnabled = false;
    }

    public void createNotification() {
        if (_IsEnabled) {
            deactivate();
        }
        _UserNotify = new UserNotification(NAME,_Prompt);
        _UserNotify.setTime(_Hour, _Minute);

        _UserNotify.activateDaily();
        _IsEnabled = true;
    }

    public void deactivate() {

        if (_IsEnabled) {
            _UserNotify.deactivate();
            _IsEnabled = false;
        }
    }

    public void setMinute(int min) {
        _Minute = min;
    }

    public void setHour(int hour) {
        _Hour = hour;
    }

    public int getHour() {
        return _Hour; }

    public int getMinute() {
        return _Minute; }

}
