package tracker.Data.Reminders;

import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Display;

/**
 * @author: Nolan Rochon
 * @project: Mental Health Tracker
 *
 * This class creates and handles a single local notification
 */
public class UserNotification {

    /** The local notification to set on the device. */
    private LocalNotification _Ln;
    /** Id of the local notification on the device. */
    private String _Id;

    /** First time of the local notification on the device. */
    private long _TimeInMilli;

    public UserNotification(final String title, final String body) {
        _Ln = new LocalNotification();
        _Id = title;
        _Ln.setId(title);
        _Ln.setAlertTitle(title);
        _Ln.setAlertBody(body);
        _Ln.setAlertSound("/notification_sound_chime.mp3");
    }

    /**
     * Hour must be in 24 hour (military time) format.
     *
     * @param hour - The hour of the day the notification will occur
     * @param minute - Minute of the hour the notification will occur
     */
    public void setTime(final int hour, final int minute) {
        _TimeInMilli = System.currentTimeMillis()
                + ((long) ((hour * 60 * 60 * 1000) + (minute * 60 * 1000)));
    }

    public void activateDaily() {
        Display.getInstance().scheduleLocalNotification(
                _Ln, _TimeInMilli, LocalNotification.REPEAT_DAY);
    }

    public void activateOnce() {
        Display.getInstance().scheduleLocalNotification(
                _Ln, _TimeInMilli, LocalNotification.REPEAT_NONE);
    }

    public void deactivate() {
        Display.getInstance().cancelLocalNotification(_Id);
    }
}
