package tracker.GuiComponents.Individual;

import com.codename1.ui.Display;

import java.time.LocalTime;

/**
 * Class for a gui picker for a time of day.
 */
public class GuiTimePicker extends GuiPicker {

    public GuiTimePicker(final String name) {
        super(name, Display.PICKER_TYPE_TIME);
    }

    public void setTime(final LocalTime time) {
        getPicker().setTime(time.getHour(), time.getMinute());
    }

    public LocalTime getTime() {
        int totalMin = getPicker().getTime();
        int hours = totalMin / 60;
        int minutes = totalMin % 60;
        return LocalTime.of(hours, minutes, 0, 0);
    }
}
