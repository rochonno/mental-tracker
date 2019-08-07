package tracker.GuiComponents.Individual;

import com.codename1.ui.Component;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;

/**
 * Generic Gui picker.
 */
public class GuiPicker {

    /** Generic picker Gui component. */
    private Picker _Picker;

    GuiPicker(
            final String name,
            final int pickerType,
            final Resources instanceTheme) {

        _Picker = new Picker();
        _Picker.setType(pickerType);
        _Picker.setUseLightweightPopup(false);
        _Picker.setInlineStylesTheme(instanceTheme);
        _Picker.setInlineAllStyles("border:none; bgColor:efefef;");
        setName(name);
    }

    public void centerAllign(final boolean center) {
        if (center) {
            _Picker.setInlineAllStyles("alignment:center");
            _Picker.getStyle().setAlignment(4);
        }
    }

    public void centerVertically() {
        _Picker.setVerticalAlignment(Component.CENTER);
    }

    public void setActionListener(final ActionListener callback) {
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

    public void setVisible(final boolean visible) {
        _Picker.setVisible(visible);
    }
}
