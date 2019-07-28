package tracker.Pages.ModularGUI;

import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.events.DataChangedListener;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.util.Resources;
import tracker.Data.Prompts.MentalPrompt;
import tracker.Data.Prompts.PromptResult;
import tracker.GuiComponents.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SinglePromptDisplay implements PropertyChangeListener {
    private Form _Page;
    private MentalPrompt _CurrPrompt;
    private String _UserAnswer;
    private PromptResult _Result;
    private Resources _Resources;
    private int _Location;


    public SinglePromptDisplay(final MentalPrompt prompt, Resources resources) {
        _Resources = resources;
        _CurrPrompt = prompt;
    }

    private GuiLabel _Title;
    private GuiLabel _Question;
    private GuiButton _NoButton;
    private GuiButton _YesButton;
    private GuiSlider _Slider;
    private GuiTextArea _InputText;

    private GuiEventCallback _NoCallback;
    private GuiEventCallback _YesCallback;
    private GuiEventCallback _SliderCallback;
    private GuiEventCallback _TextCallback;

    public void initialize(final int location) {
        _Location = location;
        _Title = new GuiLabel(_CurrPrompt.getName(), _Resources);
        _Question = new GuiLabel(_CurrPrompt.getPrompt(), _Resources);
        PromptCallbackClass callback = new PromptCallbackClass();

        switch (_CurrPrompt.getDataType()) {
            case INT: initSlider(callback); break;
            case STRING: initTextArea(callback); break;
            case BOOL: initYesNo(callback); break;
            case DOUBLE: initTextArea(callback); break;
            default: break; //TODO: add new exception type
        }

        createComponents();
    }


    private void initSlider(final PromptCallbackClass callback) {
        _Slider = new GuiSlider(
                "inputSlider",
                _Resources,
                _CurrPrompt.getMin(),
                _CurrPrompt.getMax()
        );
        _Slider.setActionListener(callback);
    }

    private void initTextArea(final PromptCallbackClass callback) {
        _InputText = new GuiTextArea("inputTextArea", _Resources);
        _InputText.setActionListener(callback);
    }

    private void initYesNo(final PromptCallbackClass callback) {
        _NoButton = new GuiButton(
                ImageNames.NO_SELECT,
                _Resources,
                ImageNames.NO_UNSELECT,
                ImageNames.NO_SELECT
        );
        _YesButton = new GuiButton(
                ImageNames.YES_SELECT,
                _Resources,
                ImageNames.YES_UNSELECT,
                ImageNames.YES_SELECT
        );
        _NoButton.setActionListener(callback);
        _YesButton.setActionListener(callback);
    }

    private void onNoButtonEvent(final ActionEvent ev) {
        _UserAnswer = "false";
    }

    private void onYesButtonEvent(final ActionEvent ev) {
        _UserAnswer = "true";
    }

    private void onTextChangedEvent(final ActionEvent ev) {
        // TODO: Check if valid input
        _UserAnswer = _InputText.getText();
    }

    public void onSliderEvent(final ActionEvent ev) {
        _UserAnswer = "" + _Slider.getNumber();
    }

    private void onSliderDataChangeEvent(final int index) {
        _UserAnswer = "" + index;
    }


    class PromptCallbackClass implements ActionListener, DataChangedListener {

        PromptCallbackClass() {
        }
        /**
         * Invoked when there was a change in the underlying model.
         *
         * @param type  the type data change; REMOVED, ADDED or CHANGED
         * @param index item index in a list model
         */
        public void dataChanged(final int type, final int index) {
            onSliderDataChangeEvent(index);
        }

        /**
         * Invoked when an action occurs.
         *
         * @param ev the event to be processed
         */
        public void actionPerformed(final ActionEvent ev) {
            String sourceName = ev.getComponent().getName();

            if (sourceName == _YesButton.getName()) {
                onYesButtonEvent(ev);
            } else if (sourceName == _NoButton.getName()) {
                onNoButtonEvent(ev);
            } else if (sourceName == _InputText.getName()) {
                onTextChangedEvent(ev);
            } else if (sourceName == _Slider.getName()) {
                onSliderEvent(ev);
            }
        }
    }


    private void createComponents() {
        createTitle();
        createQuestion();
        createSlider();
        createYesNo();
        createTextArea();
    }

    public void createTitle() {
        _Title.setSizeStr("126.455025mm 24.338625mm");
        _Title.setLocation(50, 70);
        _Title.centerAllign(true);

        _Page.addComponent(_Title.getLabel());

        if (_Location == 1) {
            ((LayeredLayout) _Title.getLabel().getParent().getLayout()).
                    setInsets(_Title.getLabel(), "0% auto auto 0").
                    setReferencePositions(_Title.getLabel(), "0, 0, 0, 0");
        } else if (_Location == 2) {
            ((LayeredLayout) _Title.getLabel().getParent().getLayout()).
                    setInsets(_Title.getLabel(), "0% auto auto 0").
                    setReferencePositions(_Title.getLabel(), "1, 0, 0, 0");
        } else if (_Location == 3) {
            ((LayeredLayout) _Title.getLabel().getParent().getLayout()).
                    setInsets(_Title.getLabel(), "0% auto auto 0").
                    setReferencePositions(_Title.getLabel(), "2, 0, 0, 0");
        }
    }

    public void createQuestion() {
        _Page.addComponent(_Question.getLabel());
        ((LayeredLayout) _Question.getLabel().getParent().getLayout()).
                setInsets(_Question.getLabel(), "0% auto auto auto").
                setReferenceComponentTop(_Question.getLabel(), _Title.getLabel(), 1f);
    }

    private void createSlider() {
        _Slider.setSizeStr("88.88889mm 11.111112mm");
        _Slider.centerAllign(true);
        _Page.addComponent(_Slider.getSlider());

        ((LayeredLayout) _Slider.getSlider().getParent().getLayout()).
                setInsets(_Slider.getSlider(), "0 20% auto 20%").
                setReferenceComponentTop(_Slider.getSlider(), _Title.getLabel(), 2f);
    }

    private void createYesNo() {
        _NoButton.setUIID("ToggleButton");
        _NoButton.setSizeStr("18.78307mm 6.6137567mm");

        ((LayeredLayout) _NoButton.getButton().getParent().getLayout()).
                setInsets(_NoButton.getButton(),"0 60% auto 20%").
                setReferenceComponentTop(_NoButton.getButton(), _Title.getLabel(), 2f);

        _YesButton.setUIID("ToggleButton");
        _YesButton.setSizeStr("22.486773mm 6.6137567mm");

        ((LayeredLayout) _YesButton.getButton().getParent().getLayout()).
                setInsets(_YesButton.getButton(),"0 auto auto 0").
                setReferenceComponentLeft(_YesButton.getButton(), _NoButton.getButton(), 2f).
                setReferenceComponentTop(_YesButton.getButton(), _NoButton.getButton(), 0);
    }

    private void createTextArea() {
        _InputText.centerAllign(true);
        _InputText.setSingleLine(true);
        _InputText.setVertAlign(4);

        ((LayeredLayout) _InputText.getTextArea().getParent().getLayout()).
                setInsets(_InputText.getTextArea(), "0 30% auto 33%").
                setReferenceComponentTop(_InputText.getTextArea(), _Title.getLabel(), 2f);
    }

    /**
     * This method gets called when a bound property is changed.
     *
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }


}
