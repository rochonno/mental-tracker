package tracker.GuiComponents.Individual;

import com.codename1.components.FloatingActionButton;
import com.codename1.ui.events.ActionListener;

public class GuiFloatButton {

    /** Floating button. */
    private FloatingActionButton _Button;
    /** Sub button one of floating button. */
    private FloatingActionButton _Sub1;
    /** Sub button two of floating button. */
    private FloatingActionButton _Sub2;
    /** Action listener to be assigned to the buttons. */
    private ActionListener _Listener;

    public GuiFloatButton(
            final char icon,
            final String name,
            final ActionListener listener) {

        _Listener = listener;
        _Button = FloatingActionButton.createFAB(icon);
        _Button.setName(name);
        _Button.addActionListener(_Listener);
        _Button.setText(name);
    }

    public void addSubButton1(final char icon, final String text) {
        _Sub1 = _Button.createSubFAB(icon, text);
        _Sub1.setName(text);
        _Sub1.addActionListener(_Listener);
    }

    public void addSubButton2(final char icon, final String text) {
        _Sub2 = _Button.createSubFAB(icon, text);
        _Sub2.setName(text);
        _Sub2.addActionListener(_Listener);
    }

    public FloatingActionButton getButton() {
        return _Button;
    }

    public String getName() {
        return _Button.getName();
    }

    public String getSub1Name() {
        return _Sub1.getName();
    }

    public String getSub2Name() {
        return _Sub2.getName();
    }
}
