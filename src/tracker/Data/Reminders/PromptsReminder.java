/******************************************************************************
 * @author: Nolan Rochon
 * @project: Mental Health Tracker
 *
 * Local notification for reminding user to answer the daily prompts.
 ******************************************************************************/
package tracker.Data.Reminders;

public final class PromptsReminder {

    private String _Name;
    private String _Prompt;
    private UserNotification _UserNotify;

    private int _Hour;
    private int _Minute;
    private boolean _IsEnabled;

    public PromptsReminder(final String name) {
        _Name = name;
        _Prompt = "Take a break for a minute to answer a few questions!";
    }

    public void createNotification() {

        _UserNotify = new UserNotification(_Name, _Prompt);
        _UserNotify.setTime(_Hour, _Minute);

        _UserNotify.activateDaily();
        _IsEnabled = true;
    }

    public void deactivate() {
        if (_IsEnabled) {
            _UserNotify.deactivate();
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

    public String getName() {
        return _Name;
    }
}
