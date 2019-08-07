package tracker.GuiComponents.Individual;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.util.Resources;

/******************************************************************************
 * @author Nolan Rochon
 *
 * Wrapper for a Label in the GUI.
 ******************************************************************************/
public class GuiLabel {

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

    public Label getLabel() {
        return _Label;
    }

    public void centerAllign(final boolean center) {
        if (center) {
            _Label.setInlineAllStyles("alignment:center");
        }
    }

    public void setTraverseIndex(final int index) {
        _Label.setTraversable(true);
        _Label.setPreferredTabIndex(index);
    }

    public void setSmoothScroll(final boolean smooth) {
        _Label.setSmoothScrolling(smooth);
    }

    public void setSizeStr(final String size) {
        _Label.setPreferredSizeStr(size);
    }

    public void setVisible(final boolean visible) {
        _Label.setVisible(visible);
    }
}
