package tracker.GuiComponents.Individual;

import com.codename1.ui.spinner.Picker;

public class GuiPicker {

    private Picker _Picker;

    GuiPicker(final String name, final int pickerType) {
        _Picker = new Picker();
        _Picker.setType(pickerType);
        setName(name);
    }

    Picker getPicker() {
        return _Picker;
    }

    public String getName() {
        return _Picker.getName();
    }

    private void setName(final String name) {
        _Picker.setName(name);
    }
}
