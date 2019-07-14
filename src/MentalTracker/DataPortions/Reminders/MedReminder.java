package MentalTracker.DataPortions.Reminders;

import MentalTracker.UserNotification;

public class MedReminder {

    private String _Name;
    private String _Dosage;
    private String _Prompt;

    private UserNotification _UserNotify;
    private int _Hour;
    private int _Minute;

    public MedReminder (String name, String dosage)
    {
        _Name = name;
        _Dosage = dosage;
        _Prompt = "Time to take " + dosage + " of " + name;
    }

    public void SetNotification (int hour, int minute, boolean isDaily)
    {
        _Hour = hour;
        _Minute = minute;

        _UserNotify = new UserNotification (_Name, _Prompt);
        _UserNotify.SetTime (hour, minute);
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
    public String GetDosage () { return _Dosage; }
}
