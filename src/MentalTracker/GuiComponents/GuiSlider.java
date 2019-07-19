package MentalTracker.GuiComponents;

import com.codename1.ui.Slider;
import com.codename1.ui.util.Resources;

public class GuiSlider extends GuiComponent {

    private Slider _Slider;

    public GuiSlider (String name, Resources instanceTheme, int min, int max)
    {
        _Slider = new Slider();
        _Slider.setName(name);
        _Slider.setInlineStylesTheme(instanceTheme);
        SetBounds(min, max);
        _Slider.setRenderValueOnTop(true);

        _Slider.setEditable(true);
        _Slider.setFocusable(true);
        _Slider.setInlineAllStyles("fgColor:0;");
        _Slider.setInlineAllStyles("alignment:center;");
        SetIncrements(1);
        SetProgress(1);
        SetGap(2);
    }

    public void SetBounds (int min, int max)
    {
        _Slider.setMinValue(min);
        _Slider.setMaxValue(max);
    }

    public void SetIncrements (int increments)
    {
        _Slider.setIncrements(increments);
    }

    public void SetProgress (int progress)
    {
        _Slider.setProgress(progress);
    }

    public void SetGap (int gap)
    {
        _Slider.setGap(gap);
    }

    public void SetUiid (String uiid)
    {
        _Slider.setUIID(uiid);
    }
}
