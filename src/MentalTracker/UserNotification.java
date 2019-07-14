/*******************************************************************************************
 * @author: Nolan Rochon
 * @date: 07/10/19
 * @project: Mental Health Tracker
 *
 * This class creates and handles a single local notification
 *******************************************************************************************/

package MentalTracker;

import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Display;

public class UserNotification {

    private LocalNotification _Ln;
    private String _Id;
    private Boolean _Activated;

    private int _TimeInMilli;

    public UserNotification (String title, String body)
    {
        _Ln = new LocalNotification();
        _Id = title;
        _Ln.setId( title );
        _Ln.setAlertTitle( title );
        _Ln.setAlertBody( body );
        _Activated = false;
    }

    /**
     * Hour must be in 24 hour (military time) format
     *
     * @param hour - The hour of the day the notification will occur
     * @param minute - Minute of the hour the notification will occur
     */
    public void SetTime (int hour, int minute)
    {
        _TimeInMilli = (hour * 60 * 60 * 1000) + (minute * 60 * 1000);
    }

    public void ActivateDaily ()
    {
        if (_Activated) Deactivate();
        Display.getInstance().scheduleLocalNotification( _Ln, _TimeInMilli, LocalNotification.REPEAT_DAY);
        _Activated = true;
    }

    public void ActivateWeekly ()
    {
        if (_Activated) Deactivate();
        Display.getInstance().scheduleLocalNotification( _Ln, _TimeInMilli, LocalNotification.REPEAT_DAY);
        _Activated = true;
    }

    public boolean IsActivated ()
    {
        return _Activated;
    }

    public void Deactivate ()
    {
        if (_Activated)
        {
            Display.getInstance().cancelLocalNotification(_Id);
            _Activated = false;
        }
    }
}
