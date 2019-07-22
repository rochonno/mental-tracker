package tracker.GuiComponents;

import com.codename1.ui.TextArea;
import com.codename1.ui.util.Resources;

public class GuiTextArea extends GuiComponent {

    /** Codename One object for displaying & receiving text input from user. */
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

    public void setEventCallback(final GuiEventCallback callback) {
        _TextArea.addActionListener(callback);
    }

}
