package tracker.GuiComponents.Individual;

import com.codename1.ui.TextArea;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import org.w3c.dom.Text;

/******************************************************************************
 * @author Nolan Rochon
 *
 * Wrapper for a Text Area in the GUI.
 * Used to get text input from the user.
 ******************************************************************************/
public class GuiTextArea {

    /** Codename One object for displaying/receiving text input from user. */
    private TextArea _TextArea;

    public GuiTextArea(final String name, final Resources instanceTheme) {
        _TextArea = new TextArea();
        _TextArea.setName(name);
        _TextArea.setEditable(true);
        _TextArea.setInlineStylesTheme(instanceTheme);
    }

    public void setHint(final String hint) {
        _TextArea.setHint(hint);
    }

    public void setSingleLine(final boolean singleLine) {
        _TextArea.setSingleLineTextArea(singleLine);
    }

    /**
     * Sets the vertical alignment of the text in the Text Area.
     * @param alignment 0=Top, 1=Left, 2=Bottom, 3=Right, 4=Center
     */
    public void setVertAlign(final int alignment) {
        _TextArea.setVerticalAlignment(alignment);
    }

    public void setActionListener(final ActionListener callback) {
        _TextArea.addActionListener(callback);
    }

    public String getText() {
        return _TextArea.getText();
    }

    public TextArea getTextArea() {
        return _TextArea;
    }

    public void setLocation(int x, int y) {
        _TextArea.setX(x);
        _TextArea.setY(y);
    }

    public void centerAllign(boolean center) {
        if (center) {
            _TextArea.setInlineAllStyles("alignment:center");
        }
    }

    public void setRefLocation(int refX, int refY, int x, int y) {
        setLocation(refX + x, refY + y);
    }

    public void setTraverseIndex(int index) {
        _TextArea.setTraversable(true);
        _TextArea.setPreferredTabIndex(index);
    }

    public void setSmoothScroll(boolean smooth) {
        _TextArea.setSmoothScrolling(smooth);
    }

    public void setSizeStr(String size) {
        _TextArea.setPreferredSizeStr(size);
    }

    public int getCenterX() {
        return _TextArea.getX();
    }

    public int getCenterY() {
        return _TextArea.getY();
    }

    public int getTotalWidth() {
        return _TextArea.getWidth();
    }

    public int getTotalHeight() {
        return _TextArea.getHeight();
    }

    public String getName() {
        return _TextArea.getName();
    }
}
