package tracker.GuiComponents.Individual;

import com.codename1.ui.Component;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.spinner.Picker;

public class GuiPicker {

    private Picker _Picker;

    GuiPicker(final String name, final int pickerType) {
        _Picker = new Picker();
        _Picker.setType(pickerType);
        _Picker.setUseLightweightPopup(true);
        setName(name);
    }

    public void centerAllign(boolean center) {
        if (center) {
            _Picker.setInlineAllStyles("alignment:center");
            _Picker.getStyle().setAlignment(4);
        }
    }

    public void centerVertically() {
        _Picker.setVerticalAlignment(Component.CENTER);
    }

    public void setActionListener(ActionListener callback) {
        _Picker.addActionListener(callback);
    }

    public Picker getPicker() {
        return _Picker;
    }

    public String getName() {
        return _Picker.getName();
    }

    private void setName(final String name) {
        _Picker.setName(name);
    }
}
