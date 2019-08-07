package tracker.Data.Reminders;

/**
 * Base Reminder class.
 */
public class MentalReminder {

    /** Prompt to display in the notification. */
    private String _Prompt;

    /** UserNotification of the notification. */
    private UserNotification _UserNotify;
    /** Hour of the notification. */
    private int _Hour;
    /** Minute of the notification. */
    private int _Minute;

    /** Name of the notification. */
    private static final String NAME = "Medication Reminder";
    /** If the notification is enabled. */
    private boolean _IsEnabled;

    public MentalReminder(final String prompt) {
        _Prompt = prompt;
    }

    public void createNotification() {
        if (_IsEnabled) {
            deactivate();
        }
        _UserNotify = new UserNotification(NAME, _Prompt);
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
