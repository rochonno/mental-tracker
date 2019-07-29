package tracker.Pages.ModularGUI;

import com.codename1.ui.events.ActionListener;
import com.codename1.ui.events.DataChangedListener;
import tracker.Data.InstanceData;
import tracker.Data.Prompts.MentalPrompt;
import tracker.Data.Prompts.PromptResult;
import tracker.Data.Prompts.PromptResults;
import tracker.ComponentGenerators.PromptComponentsGenerator;
import tracker.ComponentGenerators.ComponentName;
import tracker.MentalExceptions.EmptyStringException;
import com.codename1.io.Log;
import com.codename1.ui.Component;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.util.Resources;

import static com.codename1.ui.util.Resources.getGlobalResources;

/******************************************************************************
 * @author Nolan Rochon
 *
 * Creates a page for a single user prompt.
 ******************************************************************************/
public class UserPromptPage extends Form {
    private Form _NextForm;
    private Form _PrevForm;

    private PromptComponentsGenerator _Components;
    private InstanceData _Data;

    private MentalPrompt _CurrPrompt;

    private String _UserAnswer;
    private PromptResult _Result;
    private PromptResults _AllResults;


    public UserPromptPage(InstanceData data, Form previous) {
        _Data = data;
        _PrevForm = previous;

        _CurrPrompt = _Data.getInstancePrompts().remove(0);
        _Components = new PromptComponentsGenerator(_CurrPrompt);
        initGuiBuilderComponents(getGlobalResources());
    }

    private void onSliderActionEvent(final ActionEvent ev) {
        _UserAnswer = "" + _Components.InputSlider.getProgress();
    }

    private void onSliderDataChangeEvent(
            final Component cmp, final int type, final int index) {
        _UserAnswer = "" + index;
    }

    private void onNextButtonActionEvent(final ActionEvent ev) {
        if (_Data.getInstancePrompts().getPromptCount() > 0) {
            if (_UserAnswer != null) {
                if (_Result == null) {
                    try {
                        _Result = new PromptResult(_CurrPrompt.getName(),
                                _CurrPrompt.getDataType(), _UserAnswer);
                        _AllResults.addResult(_Result);
                        _NextForm = new UserPromptPage(_Data, this);
                        _NextForm.show();
                    } catch (EmptyStringException e) {
                        Log.e(e.getCause());
                    }
                } else {
                    try {
                        _AllResults.updateResult(_Result, _UserAnswer);
                    } catch (EmptyStringException e) {
                        Log.e(e.getCause());
                    }
                }
            } else {
                //TODO:: Error asking them to answer the Prompt as best they can
            }

        } else {
            MainPage main = new MainPage(_Data);
            main.show();
        }
    }

    private void onBackButtonActionEvent(final ActionEvent ev) {
        _PrevForm.show();
    }

    private void onButtonNoActionEvent(final ActionEvent ev) {
        _UserAnswer = "false";
    }

    private void onButtonYesActionEvent(final ActionEvent ev) {
        _UserAnswer = "true";
    }
    private void onTextAreaChangedEvent(final ActionEvent ev) {
        // TODO: Check if valid input
        _UserAnswer = _Components.InputTextArea.getText();
    }


    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();

        _Components.BackButton.addActionListener(callback);
        _Components.AdvanceButton.addActionListener(callback);

        if (_Components.checkInputButtons()) {
            _Components.InputButtonNo.addActionListener(callback);
            _Components.InputButtonYes.addActionListener(callback);
        }
        if (_Components.checkSlider()) {
            _Components.InputSlider.addActionListener(callback);
            _Components.InputSlider.addDataChangedListener(callback);
        }
        if (_Components.checkTextArea()) {
            _Components.InputTextArea.addActionListener(callback);
        }

    }

    class EventCallbackClass implements ActionListener, DataChangedListener {
        private Component cmp;

        EventCallbackClass(final Component cmp) {
            this.cmp = cmp;
        }

        EventCallbackClass() {
        }

        public void actionPerformed(final ActionEvent ev) {
            com.codename1.ui.Component sourceComponent = ev.getComponent();

            if (sourceComponent.getParent().getLeadParent() != null
                    && (sourceComponent.getParent().getLeadParent()
                    instanceof com.codename1.components.MultiButton
                    || sourceComponent.getParent().getLeadParent()
                    instanceof com.codename1.components.SpanButton)) {
                sourceComponent = sourceComponent.getParent().getLeadParent();
            }

            if (sourceComponent == _Components.InputSlider) {
                onSliderActionEvent(ev);
            }
            if (sourceComponent == _Components.AdvanceButton) {
                onNextButtonActionEvent(ev);
            }
            if (sourceComponent == _Components.BackButton) {
                onBackButtonActionEvent(ev);
            }
            if (sourceComponent == _Components.InputButtonNo) {
                _Components.InputButtonNo.setSelected(true);
                _Components.InputButtonYes.setSelected(false);
                onButtonNoActionEvent(ev);
            }
            if (sourceComponent == _Components.InputButtonYes) {
                _Components.InputButtonNo.setSelected(false);
                _Components.InputButtonYes.setSelected(true);
                onButtonYesActionEvent(ev);
            }

            if (sourceComponent == _Components.InputTextArea) {
                onTextAreaChangedEvent(ev);
            }
        }

        public void dataChanged(final int type, final int index) {
            onSliderDataChangeEvent(cmp, type, index);
        }
    }

    private void initGuiBuilderComponents(final Resources resourceInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new LayeredLayout());
        setInlineStylesTheme(resourceInstance);
        setScrollableY(false);
        setInlineStylesTheme(resourceInstance);
        setInlineAllStyles("bgColor:efefef;");
        setTitle("Track Your Mind");
        setName("UserPromptPage");

        for (ComponentName component: _Components.EnabledComponents) {
            switch (component) {
                case TOP_INSET:
                    addComponent(_Components.TopInset);
                    _Components.TopInset.setPreferredSizeStr(
                            "inherit 4.2328043mm");
                    _Components.TopInset.setInlineStylesTheme(resourceInstance);
                    _Components.TopInset.setName("TopInset");
                    ((LayeredLayout) _Components.TopInset.
                            getParent().getLayout()).setInsets(
                                    _Components.TopInset,
                            "1.6mm 5.0mm auto 5.0mm").
                            setReferenceComponents(
                                    _Components.TopInset, "-1 -1 -1 -1").
                            setReferencePositions(
                                    _Components.TopInset, "0.0 0.0 0.0 0.0");
                    break;

                case ADV_BUTTON:
                    addComponent(_Components.AdvanceButton);
                    _Components.AdvanceButton.setPreferredSizeStr(
                            "116.93122mm 23.544973mm");
                    _Components.AdvanceButton.setInlineStylesTheme(
                            resourceInstance);
                    _Components.AdvanceButton.setName("confirmButton");
                    _Components.AdvanceButton.setIcon(
                            resourceInstance.getImage("continueButton.png"));
                    _Components.AdvanceButton.setPressedIcon(
                            resourceInstance.getImage("continuePress.png"));
                    ((LayeredLayout) _Components.AdvanceButton.
                            getParent().getLayout()).setInsets(
                                    _Components.AdvanceButton,
                            "auto -125% 0 auto");
                    break;

                case BACK_BUTTON:
                    addComponent(_Components.BackButton);
                    _Components.BackButton.setPreferredSizeStr(
                            "20.042328mm 10.8465605mm");
                    _Components.BackButton.setInlineStylesTheme(
                            resourceInstance);
                    _Components.BackButton.setName("BackButton");
                    _Components.BackButton.setIcon(
                            resourceInstance.getImage("BackButton.png"));
                    _Components.BackButton.setPressedIcon(
                            resourceInstance.getImage("backPressed.png"));
                    ((LayeredLayout) _Components.BackButton.
                            getParent().getLayout()).setInsets(
                                    _Components.BackButton,
                            "0.5mm auto auto 0.0mm").
                            setReferenceComponents(
                                    _Components.BackButton, "0 -1 -1 0 ").
                            setReferencePositions(
                                    _Components.BackButton, "-1 0.0 0.0 0.0");
                    break;

                case INPUT_SLIDER:
                    addComponent(_Components.InputSlider);
                    _Components.InputSlider.setPreferredSizeStr(
                            "88.88889mm 11.111112mm");
                    _Components.InputSlider.setEditable(true);
                    _Components.InputSlider.setFocusable(true);
                    _Components.InputSlider.setScrollVisible(true);
                    _Components.InputSlider.setInlineStylesTheme(
                            resourceInstance);
                    _Components.InputSlider.setInlineAllStyles(
                            "alignment:center;");
                    _Components.InputSlider.setName("Slider");
                    _Components.InputSlider.setGap(2);
                    _Components.InputSlider.setIncrements(1);
                    _Components.InputSlider.setProgress(2);
                    _Components.InputSlider.setRenderValueOnTop(true);
                    ((LayeredLayout) _Components.InputSlider.
                            getParent().getLayout()).setInsets(
                                    _Components.InputSlider, "0 20% auto 20%").
                            setReferenceComponentTop(_Components.InputSlider,
                                    _Components.BackButton, 5f);
                    break;

                case PROMPT_TITLE:
                    addComponent(_Components.PromptTitle);
                    _Components.PromptTitle.setPreferredSizeStr(
                            "126.455025mm 24.338625mm");
                    _Components.PromptTitle.setInlineStylesTheme(
                            resourceInstance);
                    _Components.PromptTitle.setInlineAllStyles(
                            "alignment:center;");
                    _Components.PromptTitle.setName("Label");
                    _Components.PromptTitle.setIcon(
                            resourceInstance.getImage("moodLabel.png"));
                    ((LayeredLayout) _Components.PromptTitle.
                            getParent().getLayout()).setInsets(
                                    _Components.PromptTitle, "0% auto auto 0").
                            setReferenceComponentTop(_Components.PromptTitle,
                                    _Components.BackButton, 7f);
                    break;

                case INPUT_BUTTON_NO:
                    addComponent(_Components.InputButtonNo);
                    _Components.InputButtonNo.setPreferredSizeStr(
                            "18.78307mm 6.6137567mm");
                    _Components.InputButtonNo.setSelected(false);
                    _Components.InputButtonNo.setUIID("ToggleButton");
                    _Components.InputButtonNo.setInlineStylesTheme(
                            resourceInstance);
                    _Components.InputButtonNo.setInlineAllStyles(
                            "border:none; bgColor:efefef;");
                    _Components.InputButtonNo.setInlineSelectedStyles(
                            "border:none;");
                    _Components.InputButtonNo.setInlinePressedStyles(
                            "border:none;");
                    _Components.InputButtonNo.setGroup("depressedButtonGroup");
                    _Components.InputButtonNo.setName("depressedButtonNo");
                    _Components.InputButtonNo.setIcon(
                            resourceInstance.getImage(
                                    "noButtonUnsele.png"));
                    _Components.InputButtonNo.setPressedIcon(
                            resourceInstance.getImage(
                                    "noButtonSelect.png"));
                    ((LayeredLayout) _Components.InputButtonNo.
                            getParent().getLayout()).setInsets(
                                    _Components.InputButtonNo,
                            "0 60% auto 20%").setReferenceComponentTop(
                                    _Components.InputButtonNo,
                                    _Components.BackButton, 5f);
                    break;

                case INPUT_BUTTON_YES:
                    addComponent(_Components.InputButtonYes);
                    _Components.InputButtonYes.setPreferredSizeStr(
                            "22.486773mm 6.6137567mm");
                    _Components.InputButtonYes.setSelected(false);
                    _Components.InputButtonYes.setUIID("ToggleButton");
                    _Components.InputButtonYes.setInlineStylesTheme(
                            resourceInstance);
                    _Components.InputButtonYes.setInlineAllStyles(
                            "border:none; bgColor:efefef;");
                    _Components.InputButtonYes.setInlineSelectedStyles(
                            "border:none;");
                    _Components.InputButtonYes.setInlinePressedStyles(
                            "border:none;");
                    _Components.InputButtonYes.setGroup("depressedButtonGroup");
                    _Components.InputButtonYes.setName("depressedButtonYes");
                    _Components.InputButtonYes.setIcon(
                            resourceInstance.getImage(
                                    "yesButtonUnselect.png"));
                    _Components.InputButtonYes.setPressedIcon(
                            resourceInstance.getImage(
                                    "yesButtonSelect.png"));
                    ((LayeredLayout) _Components.InputButtonYes.
                            getParent().getLayout()).setInsets(
                                    _Components.InputButtonYes,
                            "0 auto auto 0").
                            setReferenceComponentLeft(
                                    _Components.InputButtonYes,
                                    _Components.InputButtonNo, 2f).
                            setReferenceComponentTop(
                                    _Components.InputButtonYes,
                                    _Components.InputButtonNo, 0);
                    break;

                case PROMPT_QUESTION:
                    addComponent(_Components.PromptQuestion);
                    _Components.PromptQuestion.setName("Prompt");
                    ((LayeredLayout) _Components.PromptQuestion.
                            getParent().getLayout()).setInsets(
                                    _Components.PromptQuestion,
                            "0 auto auto auto").setReferenceComponentTop(
                                    _Components.PromptQuestion,
                                    _Components.BackButton, 3f);
                    break;

                case INPUT_TEXT_AREA:
                    addComponent(_Components.InputTextArea);
                    _Components.InputTextArea.setEditable(true);
                    _Components.InputTextArea.setSingleLineTextArea(true);
                    _Components.InputTextArea.setHint("Hours");
                    _Components.InputTextArea.setInlineStylesTheme(
                            resourceInstance);
                    _Components.InputTextArea.getStyle().setAlignment(CENTER);
                    _Components.InputTextArea.setVerticalAlignment(CENTER);
                    _Components.InputTextArea.setName("sleepInput");
                    ((LayeredLayout) _Components.InputTextArea.
                            getParent().getLayout()).setInsets(_Components.
                            InputTextArea, "0 30% auto 33%").
                            setReferenceComponentTop(_Components.InputTextArea,
                                    _Components.BackButton, 5f);
                    break;

                default: break;
            }
        }
    }
}
