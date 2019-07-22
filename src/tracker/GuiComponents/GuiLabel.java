/******************************************************************************
 * @author: Nolan Rochon
 * @project: Mental Health Tracker
 *
 * Wrapper for a Label in the GUI.
 ******************************************************************************/
package tracker.GuiComponents;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.util.Resources;


public class GuiLabel extends GuiComponent {

    /** Codename One object for a Label Gui component. */
    private Label _Label;

    public GuiLabel(final String name, final Resources instanceTheme) {
        _Label = new Label();
        _Label.setName(name);
        _Label.setInlineStylesTheme(instanceTheme);
    }

    public void setText(final String text) {
        _Label.setText(text);
    }

    public void setIcon(final Image image) {
        _Label.setIcon(image);
    }

}
