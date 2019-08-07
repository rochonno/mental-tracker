package tracker.GuiComponents.Individual;

import com.codename1.ui.Display;
import com.codename1.ui.util.Resources;

import java.util.Date;

/**
 * Class for a gui picker for a date.
 */
public class GuiDatePicker extends GuiPicker {

    public GuiDatePicker(final String name, final Resources instanceTheme) {
        super(name, Display.PICKER_TYPE_CALENDAR, instanceTheme);
    }

    public Date getDate() {
        return getPicker().getDate();
    }

    public void setDate(final Date date) {
        getPicker().setDate(date);
    }

}
