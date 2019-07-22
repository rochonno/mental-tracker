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

    private PromptsReminder(final String name) {
        _Name = name;
        _Prompt = "Take a break for a minute to answer a few questions!";
    }

    private void setNotification(
            final int hour,
            final int min,
            final boolean isDaily) {
        _Hour = hour;
        _Minute = min;

        _UserNotify = new UserNotification(_Name, _Prompt);
        _UserNotify.setTime(hour, min);

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

    public String getName() {
        return _Name; }
}
