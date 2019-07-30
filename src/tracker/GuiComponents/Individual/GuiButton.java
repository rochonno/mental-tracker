package tracker.GuiComponents.Individual;

import com.codename1.ui.Image;
import com.codename1.ui.RadioButton;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;

/******************************************************************************
 * @author Nolan Rochon
 *
 * Wrapper for a Button in the GUI.
 ******************************************************************************/
public class GuiButton {

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

    /**
     * Swaps the selected icon with the unselected.
     * Used in place of toggle buttons and to avoid check-marks.
     */
    public void switchIcons() {
        Image oldPressed = _Button.getPressedIcon();
        _Button.setPressedIcon(_Button.getIcon());
        _Button.setIcon(oldPressed);
    }

    public void setActionListener(final ActionListener listener) {
        _Button.addActionListener(listener);
    }

    public void setSelected(final boolean selected) {
        _Button.setSelected(selected);
    }

    public void setUIID(final String uiid) {
        _Button.setUIID(uiid);
    }

    public RadioButton getButton() {
        return _Button;
    }

    public void setLocation(int x, int y) {
        _Button.setX(x);
        _Button.setY(y);
    }

    public void centerAllign(boolean center) {
        if (center) {
            _Button.setInlineAllStyles("alignment:center");
        }
    }

    public void setRefLocation(int refX, int refY, int x, int y) {
        setLocation(refX + x, refY + y);
    }

    public void setTraverseIndex(int index) {
        _Button.setTraversable(true);
        _Button.setPreferredTabIndex(index);
    }

    public void setSmoothScroll(boolean smooth) {
        _Button.setSmoothScrolling(smooth);
    }

    public void setSizeStr(String size) {
        _Button.setPreferredSizeStr(size);
    }

    public int getCenterX() {
        return _Button.getX();
    }

    public int getCenterY() {
        return _Button.getY();
    }

    public int getTotalWidth() {
        return _Button.getWidth();
    }

    public int getTotalHeight() {
        return _Button.getHeight();
    }

    public String getName() {
        return _Button.getName();
    }
}
