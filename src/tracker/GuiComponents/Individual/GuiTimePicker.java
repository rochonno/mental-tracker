package tracker.GuiComponents.Individual;

import com.codename1.ui.Display;
import com.codename1.ui.util.Resources;

/**
 * Class for a gui picker for a time of day.
 */
public class GuiTimePicker extends GuiPicker {

    public GuiTimePicker(final String name, Resources instanceTheme) {
        super(name, Display.PICKER_TYPE_TIME, instanceTheme);
    }

    public void setTime(final int hours, final int minutes) {
        setTotalMinutes((hours*60) + minutes);
    }

    public void setTotalMinutes(final int mins) {
        getPicker().setTime(mins);
    }

    public int getTotalMins() {
        return getPicker().getTime();
    }

}
