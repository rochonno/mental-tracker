package tracker.GuiComponents.Containers;

import com.codename1.ui.Component;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.events.DataChangedListener;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.util.Resources;
import tracker.Data.Prompts.MentalPrompt;
import tracker.Data.Prompts.PromptResult;
import tracker.GuiComponents.ImageNames;
import tracker.GuiComponents.Individual.GuiButton;
import tracker.GuiComponents.Individual.GuiLabel;
import tracker.GuiComponents.Individual.GuiSlider;
import tracker.GuiComponents.Individual.GuiTextArea;

/**
 * @author Nolan Rochon
 *
 * This creates all components needed for asking a single prompt.
 * Spacing is done to allow up to 4 on each page.
 */
public class SinglePromptDisplay {

    /** Page this single prompt belongs to. */
    private Form _Page;
    /** Prompt to be displayed. */
    private MentalPrompt _CurrPrompt;
    /** String for the user answer (all answers are converted). */
    private String _UserAnswer = "";
    /** PromptResult of this single prompt. */
    private PromptResult _Result;
    /** Current instance resources. */
    private Resources _Resources;


    public SinglePromptDisplay(
            final Form parentPage,
            final MentalPrompt prompt,
            final Resources resources) {

        _Page = parentPage;
        _Resources = resources;
        _CurrPrompt = prompt;
    }

    /** Location of the prompt on the page. */
    private float _Location;
    /** Reference component of the prompt.
     *      (BackButton recommended)
     */
    private Component _RefComponent;

    /** Title of the prompt. */
    private GuiLabel _Title;
    /** Question of the prompt. */
    private GuiLabel _Question;
    /** No answer button of the prompt. */
    private GuiButton _NoButton;
    /** Yes answer button of the prompt. */
    private GuiButton _YesButton;
    /** Slider of the prompt. */
    private GuiSlider _Slider;
    /** Text Area of the prompt. */
    private GuiTextArea _InputText;


    public void initialize(final int location, final Component refComponent) {
        setLocation(location);
        _RefComponent = refComponent;

        _Title = new GuiLabel(_CurrPrompt.getName(), _Resources);
        _Question = new GuiLabel("PromptName", _Resources);

        PromptCallbackClass callback = new PromptCallbackClass();

        switch (_CurrPrompt.getDataType()) {
            case INT: initSlider(callback); break;
            case STRING: initTextArea(callback); break;
            case BOOL: initYesNo(callback); break;
            case DOUBLE: initTextArea(callback); break;
            default: break;
        }

        createComponents();
    }

    private void setLocation(final int location) {
        switch (location) {
            case 1: _Location = 1; break;
            case 2: _Location = 3; break;
            case 3: _Location = 5; break;
            case 4: _Location = 7; break;
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

    /**
     * Called when the no button is selected.
     * Swapped images to simulate a toggle and confirm input.
     * Set back to the unselected state to make the check-mark disappear
     */
    private void onNoButtonEvent() {
        _NoButton.setSelected(false);
        _NoButton.switchIcons();
        if (_UserAnswer.equals("true")) {
            _YesButton.switchIcons();
        }
        _UserAnswer = "false";
    }

    /**
     * Called when the yes button is selected.
     * Swapped images to simulate a toggle and confirm input.
     * Set back to the unselected state to make the check-mark disappear
     */
    private void onYesButtonEvent() {
        _YesButton.setSelected(false);
        _YesButton.switchIcons();
        if (_UserAnswer.equals("false")) {
            _NoButton.switchIcons();
        }
        _UserAnswer = "true";
    }

    /**
     * Called when the contents of the input text box are changed.
     */
    private void onTextChangedEvent() {
        // TODO: Check if valid input
        _UserAnswer = _InputText.getText();
    }

    /**
     * Called when the slider is changed.
     */
    private void onSliderEvent() {
        _UserAnswer = "" + _Slider.getNumber();
    }

    /**
     * Also called when the slider data is changed.
     * @param index The number on the slider
     */
    private void onSliderDataChangeEvent(final int index) {
        _UserAnswer = "" + index;
    }

    /**
     * Event callback class for the prompt.
     */
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

            if (_YesButton != null) {
                if (sourceName.equals(_YesButton.getName())) {
                    onYesButtonEvent();
                } else if (sourceName.equals(_NoButton.getName())) {
                    onNoButtonEvent();
                }
            }
            if (_InputText != null) {
                if (sourceName.equals(_InputText.getName())) {
                    onTextChangedEvent();
                }
            }
            if (_Slider != null) {
                if (sourceName.equals(_Slider.getName())) {
                    onSliderEvent();
                }
            }
        }
    }

    /**
     * Create the components on the Page.
     * Only the needed ones are made.
     */
    private void createComponents() {
        createQuestion();
        createSlider();
        createYesNo();
        createTextArea();
        //createTitle();
    }

    public void createTitle() {
        _Title.setText(_CurrPrompt.getName());
        _Title.setSizeStr("126.455025mm 24.338625mm");
        _Title.setLocation(50, 70);
        _Title.centerAllign(true);

        _Page.addComponent(_Title.getLabel());

        ((LayeredLayout) _Title.getLabel().getParent().getLayout()).
                setInsets(_Title.getLabel(), "-92% 0 0 -70%").
                setReferenceComponentTop(
                        _Title.getLabel(), _Question.getLabel(), 1f);
    }

    private void createQuestion() {
        _Question.setText(_CurrPrompt.getPrompt());
        _Page.addComponent(_Question.getLabel());
        ((LayeredLayout) _Question.getLabel().getParent().getLayout()).
                setInsets(_Question.getLabel(), "0% auto auto auto").
                setReferenceComponentTop(
                        _Question.getLabel(), _RefComponent, _Location);
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
                setReferenceComponentTop(
                        _Slider.getSlider(), _Question.getLabel(), 1f);
    }

    private void createYesNo() {
        if ((_YesButton == null) || (_NoButton == null)) {
            return;
        }

        _NoButton.setSelected(false);
        _NoButton.setSizeStr("18.78307mm 6.6137567mm");
        _NoButton.getButton().setGroup("toggleButton");

        _Page.addComponent(_NoButton.getButton());
        ((LayeredLayout) _NoButton.getButton().getParent().getLayout()).
                setInsets(_NoButton.getButton(), "0 60% auto 20%").
                setReferenceComponentTop(
                        _NoButton.getButton(), _Question.getLabel(), 1f);


        _YesButton.setSelected(false);
        _YesButton.setSizeStr("22.486773mm 6.6137567mm");
        _YesButton.getButton().setGroup("toggleButton");

        _Page.addComponent(_YesButton.getButton());
        ((LayeredLayout) _YesButton.getButton().getParent().getLayout()).
                setInsets(_YesButton.getButton(), "0 auto auto 0").
                setReferenceComponentLeft(
                        _YesButton.getButton(), _NoButton.getButton(), 2f).
                setReferenceComponentTop(
                        _YesButton.getButton(), _NoButton.getButton(), 0);
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
                setReferenceComponentTop(
                        _InputText.getTextArea(), _Question.getLabel(), 1f);
    }

    public MentalPrompt getPrompt() {
        return _CurrPrompt;
    }

    public String getResult() {
        return _UserAnswer;
    }

}
