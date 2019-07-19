package MentalTracker.GuiComponents;

import com.codename1.ui.RadioButton;
import com.codename1.ui.util.Resources;

public class GuiButton extends GuiComponent {

    private RadioButton _Button;

    /**
     *
     * @param name
     * @param instanceTheme
     * @param iconName
     * @param pressedIconName Image when pressed. Can be null String
     */
    public GuiButton (String name, Resources instanceTheme, String iconName, String pressedIconName)
    {
        _Button = new RadioButton();
        _Button.setName(name);
        _Button.setInlineStylesTheme(instanceTheme);
        _Button.setIcon(instanceTheme.getImage(iconName));

        _Button.setInlineAllStyles("border:none; bgColor:efefef;");
        _Button.setInlineSelectedStyles("border:none;");
        _Button.setInlinePressedStyles("border:none;");

        if (pressedIconName != null) _Button.setPressedIcon(instanceTheme.getImage(pressedIconName));
    }

    public void SetSelected (boolean selected)
    {
        _Button.setSelected(selected);
    }

    public void SetUIID (String uiid)
    {
        _Button.setUIID(uiid);
    }

    public void SetEventCallback (GuiEventCallback callback)
    {
        _Button.addActionListener(callback);
    }

}
