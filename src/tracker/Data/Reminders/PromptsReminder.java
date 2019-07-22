package tracker.Data.Reminders;

import tracker.UserNotification;

public class PromptsReminder {

    private String _Name;
    private String _Prompt;
    private UserNotification _UserNotify;

    private int _Hour;
    private int _Minute;

    private PromptsReminder ( String name )
    {
        _Name = name;
        _Prompt = "Take a break for a minute to answer a few questions!";
    }

    private void SetNotification ( int hour, int min, boolean isDaily )
    {
        _Hour = hour;
        _Minute = min;

        _UserNotify = new UserNotification(_Name, _Prompt);
        _UserNotify.SetTime (hour, min);

        if (isDaily) _UserNotify.ActivateDaily();
        else _UserNotify.ActivateWeekly();
    }

    public void Deactivate ()
    {
        if (_UserNotify.IsActivated()) _UserNotify.Deactivate();
    }

    public int GetHour () { return _Hour; }
    public int GetMinute () { return _Minute; }
    public String GetName () { return _Name; }
}
