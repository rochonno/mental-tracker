package tracker.Pages.ModularGUI;

import com.codename1.ui.Component;
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

    private Component _RefComponent;
    private float _Location;


    public SinglePromptDisplay(Form parentPage, final MentalPrompt prompt, Resources resources) {
        _Page = parentPage;
        _Resources = resources;
        _CurrPrompt = prompt;
    }

    private GuiLabel _Title;
    private GuiLabel _Question;
    private GuiButton _NoButton;
    private GuiButton _YesButton;
    private GuiSlider _Slider;
    private GuiTextArea _InputText;


    public void initialize(final int location, final Component refComponent) {
        setLocation(location);
        _RefComponent = refComponent;

        _Title = new GuiLabel(_CurrPrompt.getName(), _Resources);
        _Question = new GuiLabel("prompt", _Resources);

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

    private void setLocation(final int location)
    {
        switch (location) {
            case 1: _Location = 1f; break;
            case 2: _Location = 4f; break;
            case 3: _Location = 6f; break;
            default: _Location = 1f; break;
        }
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
            Component sourceComponent = ev.getComponent();

            if (sourceComponent.getParent().getLeadParent() != null
                    && (sourceComponent.getParent().getLeadParent()
                    instanceof com.codename1.components.MultiButton
                    || sourceComponent.getParent().getLeadParent()
                    instanceof com.codename1.components.SpanButton)) {
                sourceComponent = sourceComponent.getParent().getLeadParent();
            }
            String sourceName = sourceComponent.getName();

            if (_YesButton != null) {
                if (sourceName.equals(_YesButton.getName())) {
                    onYesButtonEvent(ev);
                } else if (sourceName.equals(_NoButton.getName())) {
                    onNoButtonEvent(ev);
                }
            }
            if (_InputText != null) {
                if (sourceName.equals(_InputText.getName())) {
                    onTextChangedEvent(ev);
                }
            }
            if (_Slider != null) {
                if (sourceName.equals(_Slider.getName())) {
                    onSliderEvent(ev);
                }
            }
        }
    }


    private void createComponents() {
        createQuestion();
        createSlider();
        createYesNo();
        createTextArea();
        createTitle();
    }

    public void createTitle() {
        _Title.setText(_CurrPrompt.getName());
        _Title.setSizeStr("126.455025mm 24.338625mm");
        _Title.setLocation(50, 70);
        _Title.centerAllign(true);

        _Page.addComponent(_Title.getLabel());

        ((LayeredLayout) _Title.getLabel().getParent().getLayout()).
                setInsets(_Title.getLabel(), "-92% 0 0 -70%").
                setReferenceComponentTop(_Title.getLabel(), _Question.getLabel(), 1f);
    }

    public void createQuestion() {
        _Question.setText(_CurrPrompt.getPrompt());
        _Page.addComponent(_Question.getLabel());
        ((LayeredLayout) _Question.getLabel().getParent().getLayout()).
                setInsets(_Question.getLabel(), "0% auto auto auto").
                setReferenceComponentTop(_Question.getLabel(), _RefComponent, _Location);
    }

    private void createSlider() {
        if (_Slider == null) {
            return;
        }

        _Slider.setSizeStr("88.88889mm 11.111112mm");
        _Slider.centerAllign(true);
        _Page.addComponent(_Slider.getSlider());

        ((LayeredLayout) _Slider.getSlider().getParent().getLayout()).
                setInsets(_Slider.getSlider(), "0 20% auto 20%").
                setReferenceComponentTop(_Slider.getSlider(), _Question.getLabel(), 1f);
    }

    private void createYesNo() {
        if ((_YesButton == null) || (_NoButton == null)) {
            return;
        }

        _NoButton.setUIID("ToggleButton");
        _NoButton.setSizeStr("18.78307mm 6.6137567mm");
        _Page.addComponent(_NoButton.getButton());

        ((LayeredLayout) _NoButton.getButton().getParent().getLayout()).
                setInsets(_NoButton.getButton(),"0 60% auto 20%").
                setReferenceComponentTop(_NoButton.getButton(), _Question.getLabel(), 1f);

        _YesButton.setUIID("ToggleButton");
        _YesButton.setSizeStr("22.486773mm 6.6137567mm");
        _Page.addComponent(_YesButton.getButton());

        ((LayeredLayout) _YesButton.getButton().getParent().getLayout()).
                setInsets(_YesButton.getButton(),"0 auto auto 0").
                setReferenceComponentLeft(_YesButton.getButton(), _NoButton.getButton(), 2f).
                setReferenceComponentTop(_YesButton.getButton(), _NoButton.getButton(), 0);
    }

    private void createTextArea() {
        if (_InputText == null) {
            return;
        }

        _InputText.centerAllign(true);
        _InputText.setSingleLine(true);
        _InputText.setVertAlign(4);
        _Page.addComponent(_InputText.getTextArea());

        ((LayeredLayout) _InputText.getTextArea().getParent().getLayout()).
                setInsets(_InputText.getTextArea(), "0 30% auto 33%").
                setReferenceComponentTop(_InputText.getTextArea(), _Question.getLabel(), 1f);
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
