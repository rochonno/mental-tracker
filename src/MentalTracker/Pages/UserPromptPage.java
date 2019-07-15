package MentalTracker.Pages;

import MentalTracker.DataPortions.Prompts.MentalPrompt;
import MentalTracker.GuiComponents.PromptComponentsGenerator;
import MentalTracker.GuiComponents.ComponantName;
import com.codename1.ui.Component;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.util.Resources;
import static com.codename1.ui.util.Resources.getGlobalResources;

public class UserPromptPage extends Form{
    private Form _Page;
    private MentalPrompt _Prompt;
    private PromptComponentsGenerator _Components;

    public UserPromptPage(MentalPrompt prompt)
    {
        this (getGlobalResources(), prompt);
    }

    public UserPromptPage (Resources resourceObjectInstance, MentalPrompt prompt)
    {
        _Prompt = prompt;
        _Components = new PromptComponentsGenerator(_Prompt);
        initGuiBuilderComponents (resourceObjectInstance);
    }

    private void onSliderActionEvent(ActionEvent ev) {

    }

    private void onSliderDataChangeEvent(Component cmp, int type, int index) {

    }

    private void onNextButtonActionEvent (ActionEvent ev) {

    }

    private void onBackButtonActionEvent (ActionEvent ev) {

    }

    private void guiBuilderBindComponentListeners()
    {
        EventCallbackClass callback = new EventCallbackClass();

        _Components.BackButton.addActionListener(callback);
        _Components.AdvanceButton.addActionListener(callback);

        if (_Components.CheckInputButtons())
        {
            _Components.InputButtonNo.addActionListener(callback);
            _Components.InputButtonYes.addActionListener(callback);
        }
        if (_Components.CheckSlider())
        {
            _Components.InputSlider.addActionListener(callback);
            _Components.InputSlider.addDataChangedListener(callback);
        }
    }

    class EventCallbackClass implements com.codename1.ui.events.ActionListener, com.codename1.ui.events.DataChangedListener {
        private com.codename1.ui.Component cmp;

        public EventCallbackClass(com.codename1.ui.Component cmp) {
            this.cmp = cmp;
        }

        public EventCallbackClass() {
        }

        public void actionPerformed(com.codename1.ui.events.ActionEvent ev) {
            com.codename1.ui.Component sourceComponent = ev.getComponent();

            if(sourceComponent.getParent().getLeadParent() != null && (sourceComponent.getParent().getLeadParent() instanceof com.codename1.components.MultiButton || sourceComponent.getParent().getLeadParent() instanceof com.codename1.components.SpanButton)) {
                sourceComponent = sourceComponent.getParent().getLeadParent();
            }

            if(sourceComponent == _Components.InputSlider) {
                onSliderActionEvent(ev);
            }
            if(sourceComponent == _Components.AdvanceButton) {
                onNextButtonActionEvent(ev);
            }
            if(sourceComponent == _Components.BackButton) {
                onBackButtonActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
            onSliderDataChangeEvent(cmp, type, index);
        }
    }

    private void initGuiBuilderComponents(Resources resourceObjectInstance) {

        guiBuilderBindComponentListeners();
        setLayout(new LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(false);
        setInlineStylesTheme(resourceObjectInstance);
        setInlineAllStyles("bgColor:efefef;");
        setTitle("Track Your Mind");
        setName("UserPromptPage");

        for (ComponantName component: _Components.EnabledComponents)
        {
            switch (component) {
                case TOP_INSET:
                    addComponent(_Components.TopInset);
                    _Components.TopInset.setPreferredSizeStr("inherit 4.2328043mm");
                    _Components.TopInset.setInlineStylesTheme(resourceObjectInstance);
                    _Components.TopInset.setName("topInset");
                    ((LayeredLayout)_Components.TopInset.getParent().getLayout()).
                            setInsets(_Components.TopInset, "1.6mm 5.0mm auto 5.0mm").
                            setReferenceComponents(_Components.TopInset, "-1 -1 -1 -1").
                            setReferencePositions(_Components.TopInset, "0.0 0.0 0.0 0.0");
                    break;

                case ADV_BUTTON:
                    addComponent(_Components.AdvanceButton);
                    _Components.AdvanceButton.setPreferredSizeStr("116.93122mm 23.544973mm");
                    _Components.AdvanceButton.setInlineStylesTheme(resourceObjectInstance);
                    _Components.AdvanceButton.setName("confirmButton");
                    _Components.AdvanceButton.setIcon(resourceObjectInstance.getImage("continueButton.png"));
                    _Components.AdvanceButton.setPressedIcon(resourceObjectInstance.getImage("continuePress.png"));
                    ((LayeredLayout)_Components.AdvanceButton.getParent().getLayout()).
                            setInsets(_Components.AdvanceButton, "10% auto 25% 25%").
                            setReferenceComponents(_Components.AdvanceButton, "2 0 -1 0").
                            setReferencePositions(_Components.AdvanceButton, "2.8 0.0 0.0 0.1");
                    break;

                case BACK_BUTTON:
                    addComponent(_Components.BackButton);
                    _Components.BackButton.setPreferredSizeStr("20.042328mm 10.8465605mm");
                    _Components.BackButton.setInlineStylesTheme(resourceObjectInstance);
                    _Components.BackButton.setName("backButton");
                    _Components.BackButton.setIcon(resourceObjectInstance.getImage("backButton.png"));
                    _Components.BackButton.setPressedIcon(resourceObjectInstance.getImage("backPressed.png"));
                    ((LayeredLayout)_Components.BackButton.getParent().getLayout()).
                            setInsets(_Components.BackButton, "0.0mm auto auto 0.0mm").
                            setReferenceComponents(_Components.BackButton, "0 -1 -1 0 ").
                            setReferencePositions(_Components.BackButton, "-1 0.0 0.0 0.0");
                    break;

                case INPUT_SLIDER:
                    addComponent(_Components.InputSlider);
                    _Components.InputSlider.setPreferredSizeStr("88.88889mm 11.111112mm");
                    _Components.InputSlider.setEditable(true);
                    _Components.InputSlider.setFocusable(true);
                    _Components.InputSlider.setScrollVisible(true);
                    _Components.InputSlider.setText("Slider Here");
                    _Components.InputSlider.setInlineStylesTheme(resourceObjectInstance);
                    _Components.InputSlider.setInlineAllStyles("alignment:center;");
                    _Components.InputSlider.setName("Slider");
                    _Components.InputSlider.setGap(3);
                    _Components.InputSlider.setIncrements(1);
                    _Components.InputSlider.setProgress(5);
                    ((LayeredLayout)_Components.InputSlider.getParent().getLayout()).
                            setInsets(_Components.InputSlider, "0.0mm 0.0mm 0 0.0mm").
                            setReferenceComponents(_Components.InputSlider, "2 2 2 2 ").
                            setReferencePositions(_Components.InputSlider, "1.0 0.0 0.0 0.0");
                    break;

                case PROMPT_TITLE:
                    addComponent(_Components.PromptTitle);
                    _Components.PromptTitle.setPreferredSizeStr("126.455025mm 24.338625mm");
                    _Components.PromptTitle.setInlineStylesTheme(resourceObjectInstance);
                    _Components.PromptTitle.setInlineAllStyles("alignment:center;");
                    _Components.PromptTitle.setName("Label");
                    _Components.PromptTitle.setIcon(resourceObjectInstance.getImage("moodLabel.png"));
                    ((LayeredLayout)_Components.PromptTitle.getParent().getLayout()).
                            setInsets(_Components.PromptTitle, "25.0% 0.0mm auto 0.0mm").
                            setReferenceComponents(_Components.PromptTitle, "1 0 0 0 ").
                            setReferencePositions(_Components.PromptTitle, "3.5 0.0 0.0 0.0");
                    break;

                case INPUT_BUTTON_NO:
                    addComponent(_Components.InputButtonNo);
                    _Components.InputButtonYes.setPreferredSizeStr("18.78307mm 6.878307mm");
                    _Components.InputButtonYes.setSelected(false);
                    _Components.InputButtonYes.setUIID("ToggleButton");
                    _Components.InputButtonYes.setInlineStylesTheme(resourceObjectInstance);
                    _Components.InputButtonYes.setInlineAllStyles("border:none; bgColor:efefef;");
                    _Components.InputButtonYes.setInlineSelectedStyles("border:none;");
                    _Components.InputButtonYes.setInlinePressedStyles("border:none;");
                    _Components.InputButtonYes.setGroup("depressedButtonGroup");
                    _Components.InputButtonYes.setName("depressedButtonNo");
                    _Components.InputButtonYes.setIcon(resourceObjectInstance.getImage("noButtonUnsele.png"));
                    _Components.InputButtonYes.setPressedIcon(resourceObjectInstance.getImage("noButtonSelect.png"));
                    ((LayeredLayout)_Components.InputButtonYes.getParent().getLayout()).
                            setInsets(_Components.InputButtonYes, "0.0mm 0.0mm 0.0mm 0.0mm").
                            setReferenceComponents(_Components.InputButtonYes, "6 17 6 10 ").
                            setReferencePositions(_Components.InputButtonYes, "0.0 0.0 0.0 0.0");
                    break;

                case INPUT_BUTTON_YES:
                    addComponent(_Components.InputButtonYes);
                    _Components.InputButtonYes.setPreferredSizeStr("22.486773mm 6.6137567mm");
                    _Components.InputButtonYes.setSelected(false);
                    _Components.InputButtonYes.setUIID("ToggleButton");
                    _Components.InputButtonYes.setInlineStylesTheme(resourceObjectInstance);
                    _Components.InputButtonYes.setInlineAllStyles("border:none; bgColor:efefef;");
                    _Components.InputButtonYes.setInlineSelectedStyles("border:none;");
                    _Components.InputButtonYes.setInlinePressedStyles("border:none;");
                    _Components.InputButtonYes.setGroup("depressedButtonGroup");
                    _Components.InputButtonYes.setName("depressedButtonYes");
                    _Components.InputButtonYes.setIcon(resourceObjectInstance.getImage("yesButtonUnselect.png"));
                    _Components.InputButtonYes.setPressedIcon(resourceObjectInstance.getImage("yesButtonSelect.png"));
                    ((LayeredLayout)_Components.InputButtonYes.getParent().getLayout()).
                            setInsets(_Components.InputButtonYes, "7.632094% 0.0mm 0 0.0mm").
                            setReferenceComponents(_Components.InputButtonYes, "2 16 -1 16 ").
                            setReferencePositions(_Components.InputButtonYes, "0.0 0.0 0.0 0.0");
                    break;

                case PROMPT_QUESTION:
                    addComponent(_Components.PromptQuestion);
                    _Components.PromptQuestion.setName("Prompt");
                    ((LayeredLayout) _Components.PromptQuestion.getParent().getLayout()).
                            setInsets(_Components.PromptQuestion, "250% auto auto 25%").
                            //setReferenceComponentTop(_Components.InputTextBox, _Components.BackButton, 1).
                            setReferenceComponents(_Components.PromptQuestion, "1 0 0 0 ").
                            setReferencePositions(_Components.PromptQuestion, "2 0.0 0.0 0.0");
                    break;

                case INPUT_TEXT_BOX:
                    addComponent(_Components.InputTextBox);
                    _Components.InputTextBox.setHint("In Hours");
                    _Components.InputTextBox.setInlineStylesTheme(resourceObjectInstance);
                    _Components.InputTextBox.setName("sleepInput");
                    _Components.InputTextBox.setColumns(1);
                    ((LayeredLayout)_Components.InputTextBox.getParent().getLayout()).
                            setInsets(_Components.InputTextBox, "20% 37.200737% auto 38%").
                            //setReferenceComponents(_Components.InputTextBox, "1 0 1 0 ").
                            setReferenceComponentTop(_Components.InputTextBox, _Components.PromptQuestion, 2).
                            setReferencePositions(_Components.InputTextBox, "3 0.0 0.0 0.0");
                    break;
            }
        }
    }

}