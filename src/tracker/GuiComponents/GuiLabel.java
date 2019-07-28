package tracker.GuiComponents;
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

    public Label getLabel()
    {
        return _Label;
    }

    public void setLocation(int x, int y) {
        _Label.setX(x);
        _Label.setY(y);
    }

    public void centerAllign(boolean center) {
        if (center) {
            _Label.setInlineAllStyles("alignment:center");
        }
    }

    public void setRefLocation(int refX, int refY, int x, int y) {
        setLocation(refX + x, refY + y);
    }

    public void setTraverseIndex(int index) {
        _Label.setTraversable(true);
        _Label.setPreferredTabIndex(index);
    }

    public void setSmoothScroll(boolean smooth) {
        _Label.setSmoothScrolling(smooth);
    }

    public void setSizeStr(String size) {
        _Label.setPreferredSizeStr(size);
    }

    public int getCenterX() {
        return _Label.getX();
    }

    public int getCenterY() {
        return _Label.getY();
    }

    public int getTotalWidth() {
        return _Label.getWidth();
    }

    public int getTotalHeight() {
        return _Label.getHeight();
    }
}
