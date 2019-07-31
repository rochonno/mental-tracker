package tracker.GuiComponents.Individual;

import com.codename1.components.Switch;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;

public class GuiSwitch {

    private Switch _Switch;

    public GuiSwitch(final String name, final Resources instanceTheme) {
        _Switch = new Switch();
    }

    public void addActionListener(ActionListener callback) {
        _Switch.addActionListener(callback);
    }

    public boolean getValue() {
        return _Switch.isValue();
    }

    public void setValue(boolean value) {
        _Switch.setValue(value);
    }

    public Switch getSwitch() {
        return _Switch;
    }

    public String getName() {
        return _Switch.getName();
    }
}
