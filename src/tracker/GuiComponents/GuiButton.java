/******************************************************************************
 * @author: Nolan Rochon
 * @project: Mental Health Tracker
 *
 * Wrapper for a Button in the GUI.
 ******************************************************************************/
package tracker.GuiComponents;

import com.codename1.ui.RadioButton;
import com.codename1.ui.util.Resources;

public class GuiButton extends GuiComponent {

    /** Button object from the Codename One tools. */
    private RadioButton _Button;

    /**
     *
     * @param name Name of the button
     * @param instanceTheme Current theme to apply
     * @param iconName Icon for the button (default = unselected)
     * @param pressedIconName Image when pressed. Can be null String
     */
    public GuiButton(
            final String name,
            final Resources instanceTheme,
            final String iconName,
            final String pressedIconName) {

        _Button = new RadioButton();
        _Button.setName(name);
        _Button.setInlineStylesTheme(instanceTheme);
        _Button.setIcon(instanceTheme.getImage(iconName));

        _Button.setInlineAllStyles("border:none; bgColor:efefef;");
        _Button.setInlineSelectedStyles("border:none;");
        _Button.setInlinePressedStyles("border:none;");

        if (pressedIconName != null) {
            _Button.setPressedIcon(instanceTheme.getImage(pressedIconName));
        }
    }

    public void setSelected(final boolean selected) {
        _Button.setSelected(selected);
    }

    public void setUIID(final String uiid) {
        _Button.setUIID(uiid);
    }

    public void setEventCallback(final GuiEventCallback callback) {
        _Button.addActionListener(callback);
    }

}
