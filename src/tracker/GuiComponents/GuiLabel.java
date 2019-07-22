package tracker.GuiComponents;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.util.Resources;


public class GuiLabel extends GuiComponent{

    private Label _Label;

    public GuiLabel ( String name, Resources instanceTheme )
    {
        _Label = new Label();
        _Label.setName(name);
        _Label.setInlineStylesTheme(instanceTheme);
    }

    public void SetText (String text)
    {
        _Label.setText(text);
    }

    public void SetIcon(Image image)
    {
        _Label.setIcon(image);
    }

}
