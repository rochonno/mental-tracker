package tracker.GuiComponents.Individual;

import com.codename1.components.Switch;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;

public class GuiSwitch {

    /** Switch component for the Gui. */
    private Switch _Switch;

    public GuiSwitch(final String name, final Resources instanceTheme) {
        _Switch = new Switch();
        _Switch.setName(name);
    }

    public void addActionListener(final ActionListener callback) {
        _Switch.addActionListener(callback);
    }

    public boolean getValue() {
        return _Switch.isValue();
    }

    public void setValue(final boolean value) {
        _Switch.setValue(value);
    }

    public Switch getSwitch() {
        return _Switch;
    }

    public String getName() {
        return _Switch.getName();
    }
}
