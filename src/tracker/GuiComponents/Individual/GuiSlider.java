package tracker.GuiComponents.Individual;

import com.codename1.ui.FontImage;
import com.codename1.ui.Slider;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;

/******************************************************************************
 * @author Nolan Rochon
 *
 * Wrapper for a Slider in the GUI.
 * Used to get numerical input from the user.
 ******************************************************************************/
public class GuiSlider {

    /**
     * Codename One object for receiving slider input from user.
     */
    private Slider _Slider;

    public GuiSlider(
            final String name,
            final Resources instanceTheme,
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

        _Slider.setThumbImage(FontImage.createMaterial(
                FontImage.MATERIAL_RADIO_BUTTON_CHECKED,
                "sliderOval.png", 4
                ).toImage()
        );
    }


    public void setActionListener(final ActionListener listener) {
        _Slider.addActionListener(listener);
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

    public int getNumber() {
        return _Slider.getProgress();
    }

    public Slider getSlider() {
        return _Slider;
    }

    public void centerAllign(final boolean center) {
        if (center) {
            _Slider.setInlineAllStyles("alignment:center");
        }
    }

    public void setTraverseIndex(final int index) {
        _Slider.setTraversable(true);
        _Slider.setPreferredTabIndex(index);
    }

    public void setSmoothScroll(final boolean smooth) {
        _Slider.setSmoothScrolling(smooth);
    }

    public void setSizeStr(final String size) {
        _Slider.setPreferredSizeStr(size);
    }

    public String getName() {
        return _Slider.getName();
    }
}
