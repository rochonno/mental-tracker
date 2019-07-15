package MentalTracker.Pages;

import MentalTracker.DailySurveyPgOneGUI;
import MentalTracker.DataPortions.Prompts.MentalPrompt;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.events.DataChangedListener;
import com.codename1.ui.util.Resources;
import static com.codename1.ui.util.Resources.getGlobalResources;

public class UserPromptPage extends Form{
    private Form _Page;
    private MentalPrompt _Prompt;

    public UserPromptPage(MentalPrompt prompt)
    {
        this (getGlobalResources());
        _Prompt = prompt;
    }

    public UserPromptPage (Resources resourceObjectInstance)
    {
        initGuiBuilderComponents (resourceObjectInstance);
    }

    public void GenerateGuiComponents()
    {

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

            if(sourceComponent == gui_anxietySlider) {
                onanxietySliderActionEvent(ev);
            }
            if(sourceComponent == gui_stressSlider) {
                onstressSliderActionEvent(ev);
            }
            if(sourceComponent == gui_confirmButton) {
                onconfirmButtonActionEvent(ev);
            }
            if(sourceComponent == gui_backButton) {
                onbackButtonActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
            onmoodSliderDataChangeEvent(cmp, type, index);
            onconfidenceSliderDataChangeEvent(cmp, type, index);
            onanxietySliderDataChangeEvent(cmp, type, index);
            onstressSliderDataChangeEvent(cmp, type, index);
        }
    }

    private void initGuiBuilderComponents(Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(false);
        setInlineStylesTheme(resourceObjectInstance);
        setInlineAllStyles("bgColor:efefef;");
        setTitle("DailySurveyPgOneGUI");
        setName("DailySurveyPgOneGUI");
        addComponent(gui_topInset);
        addComponent(gui_moodSlider);
        addComponent(gui_confidenceSlider);
        addComponent(gui_anxietySlider);
        addComponent(gui_stressSlider);
        addComponent(gui_confirmButton);
        addComponent(gui_backButton);
        addComponent(gui_Label);
        addComponent(gui_moodSlideLabels);
        gui_topInset.setPreferredSizeStr("inherit 4.2328043mm");
        gui_topInset.setInlineStylesTheme(resourceObjectInstance);
        gui_topInset.setName("topInset");
        ((com.codename1.ui.layouts.LayeredLayout)gui_topInset.getParent().getLayout()).setInsets(gui_topInset, "1.6mm 5.0mm auto 5.0mm").setReferenceComponents(gui_topInset, "-1 -1 -1 -1").setReferencePositions(gui_topInset, "0.0 0.0 0.0 0.0");
        gui_moodSlider.setPreferredSizeStr("88.88889mm 11.111112mm");
        gui_moodSlider.setEditable(true);
        gui_moodSlider.setFocusable(true);
        gui_moodSlider.setText("Mood Slider Here");
        gui_moodSlider.setInlineStylesTheme(resourceObjectInstance);
        gui_moodSlider.setInlineAllStyles("alignment:center;");
        gui_moodSlider.setName("moodSlider");
        gui_moodSlider.setIncrements(1);
        gui_moodSlider.setProgress(5);
        ((com.codename1.ui.layouts.LayeredLayout)gui_moodSlider.getParent().getLayout()).setInsets(gui_moodSlider, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_moodSlider, "2 2 8 2 ").setReferencePositions(gui_moodSlider, "1.0 0.0 0.0 0.0");
        gui_confidenceSlider.setPreferredSizeStr("85.978836mm 11.375662mm");
        gui_confidenceSlider.setEditable(true);
        gui_confidenceSlider.setFocusable(true);
        gui_confidenceSlider.setText("Confidence Slider Here");
        gui_confidenceSlider.setInlineStylesTheme(resourceObjectInstance);
        gui_confidenceSlider.setInlineAllStyles("alignment:center;");
        gui_confidenceSlider.setName("confidenceSlider");
        gui_confidenceSlider.setIncrements(1);
        gui_confidenceSlider.setProgress(3);
        ((com.codename1.ui.layouts.LayeredLayout)gui_confidenceSlider.getParent().getLayout()).setInsets(gui_confidenceSlider, "auto 0.0mm 34.15493% 0.0mm").setReferenceComponents(gui_confidenceSlider, "-1 3 -1 3 ").setReferencePositions(gui_confidenceSlider, "0.0 0.0 0.0 0.0");
        gui_anxietySlider.setPreferredSizeStr("89.94709mm 10.58201mm");
        gui_anxietySlider.setEditable(true);
        gui_anxietySlider.setFocusable(true);
        gui_anxietySlider.setInfinite(false);
        gui_anxietySlider.setScrollVisible(true);
        gui_anxietySlider.setText("Anxiety Slider Here");
        gui_anxietySlider.setUIID("SliderFull");
        gui_anxietySlider.setInlineStylesTheme(resourceObjectInstance);
        gui_anxietySlider.setInlineAllStyles("alignment:center;");
        gui_anxietySlider.setName("anxietySlider");
        gui_anxietySlider.setGap(2);
        gui_anxietySlider.setIncrements(1);
        gui_anxietySlider.setProgress(2);
        ((com.codename1.ui.layouts.LayeredLayout)gui_anxietySlider.getParent().getLayout()).setInsets(gui_anxietySlider, "1.5873067mm 0.0mm 86.39456% 0.0mm").setReferenceComponents(gui_anxietySlider, "4 4 -1 4 ").setReferencePositions(gui_anxietySlider, "1.0 0.0 0.0 0.0");
        gui_stressSlider.setPreferredSizeStr("89.68254mm 11.111112mm");
        gui_stressSlider.setEditable(true);
        gui_stressSlider.setFocusable(true);
        gui_stressSlider.setText("Stress Slider Here");
        gui_stressSlider.setInlineStylesTheme(resourceObjectInstance);
        gui_stressSlider.setInlineAllStyles("alignment:center;");
        gui_stressSlider.setName("stressSlider");
        gui_stressSlider.setIncrements(1);
        gui_stressSlider.setProgress(2);
        ((com.codename1.ui.layouts.LayeredLayout)gui_stressSlider.getParent().getLayout()).setInsets(gui_stressSlider, "15.748086% 14.214464% auto 0.0mm").setReferenceComponents(gui_stressSlider, "7 0 -1 8 ").setReferencePositions(gui_stressSlider, "1.0 0.0 0.0 1.0");
        gui_confirmButton.setPreferredSizeStr("116.93122mm 23.544973mm");
        gui_confirmButton.setInlineStylesTheme(resourceObjectInstance);
        gui_confirmButton.setName("confirmButton");
        gui_confirmButton.setIcon(resourceObjectInstance.getImage("continueButton.png"));
        gui_confirmButton.setPressedIcon(resourceObjectInstance.getImage("continuePress.png"));
        ((com.codename1.ui.layouts.LayeredLayout)gui_confirmButton.getParent().getLayout()).setInsets(gui_confirmButton, "auto 0.0mm 1.0582011mm 0.0mm").setReferenceComponents(gui_confirmButton, "0 0 -1 0 ").setReferencePositions(gui_confirmButton, "1.0 0.0 0.0 0.0");
        gui_backButton.setPreferredSizeStr("28.042328mm 10.8465605mm");
        gui_backButton.setInlineStylesTheme(resourceObjectInstance);
        gui_backButton.setName("backButton");
        gui_backButton.setIcon(resourceObjectInstance.getImage("backButton.png"));
        gui_backButton.setPressedIcon(resourceObjectInstance.getImage("backPressed.png"));
        ((com.codename1.ui.layouts.LayeredLayout)gui_backButton.getParent().getLayout()).setInsets(gui_backButton, "0.0mm auto auto 0.0mm").setReferenceComponents(gui_backButton, "0 -1 -1 0 ").setReferencePositions(gui_backButton, "1.0 0.0 0.0 0.0");
        gui_Label.setPreferredSizeStr("126.455025mm 24.338625mm");
        gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("alignment:center;");
        gui_Label.setName("Label");
        gui_Label.setIcon(resourceObjectInstance.getImage("moodLabel.png"));
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "8.0% 0.0mm auto 0.0mm").setReferenceComponents(gui_Label, "0 0 -1 0 ").setReferencePositions(gui_Label, "1.0 0.0 0.0 0.0");
        gui_moodSlideLabels.setPreferredSizeStr("38.095238mm 47.089947mm");
        gui_moodSlideLabels.setInlineStylesTheme(resourceObjectInstance);
        gui_moodSlideLabels.setName("moodSlideLabels");
        gui_moodSlideLabels.setIcon(resourceObjectInstance.getImage("moodSlideLabels.png"));
        ((com.codename1.ui.layouts.LayeredLayout)gui_moodSlideLabels.getParent().getLayout()).setInsets(gui_moodSlideLabels, "17.6318% -5.0264544mm 11.764706% -5.026455mm").setReferenceComponents(gui_moodSlideLabels, "7 6 5 0 ").setReferencePositions(gui_moodSlideLabels, "1.0 0.0 1.0 0.0");
    }// </editor-fold>

}