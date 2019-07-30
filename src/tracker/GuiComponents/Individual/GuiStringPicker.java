package tracker.GuiComponents.Individual;

import com.codename1.ui.Display;

/**
 * Class for a gui picker for a list of strings.
 * Originally designed for selected the type of prompt.
 */
public class GuiStringPicker extends GuiPicker {

    public GuiStringPicker(final String name) {
        super(name, Display.PICKER_TYPE_STRINGS);
    }

    public void setStrings(final String[] strArray) {
        getPicker().setStrings(strArray);
    }

    public void setSelectedString(final String selected) {
        getPicker().setSelectedString(selected);
    }

    public String getSelectedString() {
        return getPicker().getSelectedString();
    }
}
