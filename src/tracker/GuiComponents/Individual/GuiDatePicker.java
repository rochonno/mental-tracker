package tracker.GuiComponents.Individual;

import com.codename1.ui.Display;

import java.util.Date;

/**
 * Class for a gui picker for a date.
 */
public class GuiDatePicker extends GuiPicker {

    public GuiDatePicker(final String name) {
        super(name, Display.PICKER_TYPE_CALENDAR);
    }

    public Date getDate() {
        return getPicker().getDate();
    }

    public void setDate(final Date date) {
        getPicker().setDate(date);
    }

}
