package tracker.GuiComponents;
import com.codename1.ui.Slider;
import com.codename1.ui.util.Resources;

public class GuiSlider extends GuiComponent {

    /** Codename One object for receiving slider input from user. */
    private Slider _Slider;

    public GuiSlider(final String name, final Resources instanceTheme,
                     final int min, final int max) {
        _Slider = new Slider();
        _Slider.setName(name);
        _Slider.setInlineStylesTheme(instanceTheme);
        setBounds(min, max);
        _Slider.setRenderValueOnTop(true);

        _Slider.setEditable(true);
        _Slider.setFocusable(true);
        _Slider.setInlineAllStyles("fgColor:0;");
        _Slider.setInlineAllStyles("alignment:center;");
        setIncrements(1);
        setProgress(1);
        setGap(2);
    }

    public void setBounds(final int min, final int max) {
        _Slider.setMinValue(min);
        _Slider.setMaxValue(max);
    }

    public void setIncrements(final int increments) {
        _Slider.setIncrements(increments);
    }

    public void setProgress(final int progress) {
        _Slider.setProgress(progress);
    }

    public void setGap(final int gap) {
        _Slider.setGap(gap);
    }

    public void setUiid(final String uiid) {
        _Slider.setUIID(uiid);
    }
}
