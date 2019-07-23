package tracker.Pages;

import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;




/*
Break up side Label into four pieces and fix insets on back button to fix scaling issues.
 */

public class DailySurveyPgOneGUI extends com.codename1.ui.Form {
    private Form _Page;

    public DailySurveyPgOneGUI() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public DailySurveyPgOneGUI(final com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

    public void onoverallSliderActionEvent(final ActionEvent ev) {
        gui_overallNum.setText("" + gui_overallSlider.getProgress());
        gui_overallNum.repaint();
    }

    public void onconfidenceSliderActionEvent(final ActionEvent ev) {
        gui_confidenceNum.setText("" + gui_confidenceSlider.getProgress());
        gui_confidenceNum.repaint();
    }


    public void onbackButtonActionEvent(final ActionEvent ev) {
        _Page = new NeedDailyGUI();
        _Page.show();
    }

    public void onconfirmButtonActionEvent(final ActionEvent ev) {

        //Needs to confirm input!
        _Page = new DailySurveyPgTwoGUI();
        _Page.show();

    }


    public void onstressSliderActionEvent(final ActionEvent ev) {
        gui_stressNum.setText("" + gui_stressSlider.getScrollable());
        gui_stressNum.repaint();
    }


    public void onanxietySliderActionEvent(final ActionEvent ev) {
        gui_anxietyNum.setText("" + gui_anxietySlider.getScrollable());
        gui_anxietyNum.repaint();
    }

    //-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Label gui_topInset = new com.codename1.ui.Label();
    protected com.codename1.ui.Button gui_confirmButton = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_backButton = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_moodLabels = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_stressLabel = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_anxietyLabel = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_confidenceLabel = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_overallLabel = new com.codename1.ui.Label();
    protected com.codename1.ui.Slider gui_stressSlider = new com.codename1.ui.Slider();
    protected com.codename1.ui.Slider gui_anxietySlider = new com.codename1.ui.Slider();
    protected com.codename1.ui.Slider gui_confidenceSlider = new com.codename1.ui.Slider();
    protected com.codename1.ui.Slider gui_overallSlider = new com.codename1.ui.Slider();
    protected com.codename1.ui.Label gui_stressNum = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_anxietyNum = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_confidenceNum = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_overallNum = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_confirmButton.addActionListener(callback);
        gui_backButton.addActionListener(callback);
        gui_stressSlider.addActionListener(callback);
        gui_anxietySlider.addActionListener(callback);
        gui_confidenceSlider.addActionListener(callback);
        gui_overallSlider.addActionListener(callback);
    }

    class EventCallbackClass implements com.codename1.ui.events.ActionListener, com.codename1.ui.events.DataChangedListener {
        EventCallbackClass(final com.codename1.ui.Component cmp) {
        }

        EventCallbackClass() {
        }

        public void actionPerformed(final com.codename1.ui.events.ActionEvent ev) {
            com.codename1.ui.Component sourceComponent = ev.getComponent();

            if (sourceComponent.getParent().getLeadParent() != null && (sourceComponent.getParent().getLeadParent() instanceof com.codename1.components.MultiButton || sourceComponent.getParent().getLeadParent() instanceof com.codename1.components.SpanButton)) {
                sourceComponent = sourceComponent.getParent().getLeadParent();
            }

            if (sourceComponent == gui_confirmButton) {
                onconfirmButtonActionEvent(ev);
            }
            if (sourceComponent == gui_backButton) {
                onbackButtonActionEvent(ev);
            }
            if (sourceComponent == gui_stressSlider) {
                onstressSliderActionEvent(ev);
            }
            if (sourceComponent == gui_anxietySlider) {
                onanxietySliderActionEvent(ev);
            }
            if (sourceComponent == gui_confidenceSlider) {
                onconfidenceSliderActionEvent(ev);
            }
            if (sourceComponent == gui_overallSlider) {
                onoverallSliderActionEvent(ev);
            }
        }

        public void dataChanged(final int type, final int index) {
        }
    }
    private void initGuiBuilderComponents(final com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(false);
                setInlineStylesTheme(resourceObjectInstance);
        setInlineAllStyles("bgColor:efefef;");
        setTitle("DailySurveyPgOneGUI");
        setName("DailySurveyPgOneGUI");
        gui_topInset.setPreferredSizeStr("inherit 4.2328043mm");
                gui_topInset.setInlineStylesTheme(resourceObjectInstance);
        gui_topInset.setName("topInset");
        gui_confirmButton.setPreferredSizeStr("64.021164mm 23.544973mm");
                gui_confirmButton.setInlineStylesTheme(resourceObjectInstance);
        gui_confirmButton.setName("confirmButton");
        gui_confirmButton.setIcon(resourceObjectInstance.getImage("continueButton.png"));
        gui_confirmButton.setPressedIcon(resourceObjectInstance.getImage("continuePress.png"));
        gui_backButton.setPreferredSizeStr("28.042328mm 10.8465605mm");
                gui_backButton.setInlineStylesTheme(resourceObjectInstance);
        gui_backButton.setName("backButton");
        gui_backButton.setIcon(resourceObjectInstance.getImage("backButton.png"));
        gui_backButton.setPressedIcon(resourceObjectInstance.getImage("backPressed.png"));
        gui_moodLabels.setPreferredSizeStr("126.455025mm 24.338625mm");
                gui_moodLabels.setInlineStylesTheme(resourceObjectInstance);
        gui_moodLabels.setInlineAllStyles("alignment:center;");
        gui_moodLabels.setName("moodLabels");
        gui_moodLabels.setIcon(resourceObjectInstance.getImage("moodLabel.png"));
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_topInset);
        addComponent(gui_confirmButton);
        addComponent(gui_backButton);
        addComponent(gui_moodLabels);
        addComponent(gui_Container);
        gui_stressLabel.setPreferredSizeStr("21.16402mm 9.259259mm");
                gui_stressLabel.setInlineStylesTheme(resourceObjectInstance);
        gui_stressLabel.setName("stressLabel");
        gui_stressLabel.setIcon(resourceObjectInstance.getImage("Stress.png"));
        gui_anxietyLabel.setPreferredSizeStr("29.100528717041016mm 8.994709014892578mm");
                gui_anxietyLabel.setInlineStylesTheme(resourceObjectInstance);
        gui_anxietyLabel.setName("anxietyLabel");
        gui_anxietyLabel.setIcon(resourceObjectInstance.getImage("Anxiety.png 1"));
        gui_confidenceLabel.setPreferredSizeStr("39.153438568115234mm 9.523809432983398mm");
                gui_confidenceLabel.setInlineStylesTheme(resourceObjectInstance);
        gui_confidenceLabel.setName("confidenceLabel");
        gui_confidenceLabel.setIcon(resourceObjectInstance.getImage("Confidence.png"));
        gui_overallLabel.setPreferredSizeStr("27.513227462768555mm 10.052909851074219mm");
                gui_overallLabel.setInlineStylesTheme(resourceObjectInstance);
        gui_overallLabel.setName("overallLabel");
        gui_overallLabel.setIcon(resourceObjectInstance.getImage("Overall.png"));
        gui_stressSlider.setPreferredSizeStr("76.190475mm 17.989418mm");
        gui_stressSlider.setEditable(true);
        gui_stressSlider.setFocusable(true);
        gui_stressSlider.setRTL(false);
        gui_stressSlider.setUIID("SliderFull");
                gui_stressSlider.setInlineStylesTheme(resourceObjectInstance);
        gui_stressSlider.setName("stressSlider");
        gui_stressSlider.setGap(2);
        gui_stressSlider.setIncrements(1);
        gui_stressSlider.setProgress(1);
        gui_anxietySlider.setPreferredSizeStr("36.772488mm 17.460318mm");
        gui_anxietySlider.setEditable(true);
        gui_anxietySlider.setFocusable(true);
        gui_anxietySlider.setScrollVisible(true);
        gui_anxietySlider.setUIID("SliderFull");
                gui_anxietySlider.setInlineStylesTheme(resourceObjectInstance);
        gui_anxietySlider.setName("anxietySlider");
        gui_anxietySlider.setIncrements(1);
        gui_anxietySlider.setProgress(1);
        gui_confidenceSlider.setPreferredSizeStr("100.26455mm 18.518518mm");
        gui_confidenceSlider.setEditable(true);
        gui_confidenceSlider.setFocusable(true);
        gui_confidenceSlider.setUIID("SliderFull");
                gui_confidenceSlider.setInlineStylesTheme(resourceObjectInstance);
        gui_confidenceSlider.setName("confidenceSlider");
        gui_confidenceSlider.setIncrements(1);
        gui_confidenceSlider.setProgress(1);
        gui_overallSlider.setPreferredSizeStr("125.92593mm 19.047619mm");
        gui_overallSlider.setEditable(true);
        gui_overallSlider.setFocusable(true);
        gui_overallSlider.setUIID("SliderFull");
                gui_overallSlider.setInlineStylesTheme(resourceObjectInstance);
        gui_overallSlider.setName("overallSlider");
        gui_overallSlider.setIncrements(1);
        gui_overallSlider.setProgress(1);
        gui_stressNum.setPreferredSizeStr("6.6137567mm 12.433863mm");
                gui_stressNum.setInlineStylesTheme(resourceObjectInstance);
        gui_stressNum.setInlineAllStyles("fgColor:0;");
        gui_stressNum.setName("stressNum");
        gui_anxietyNum.setPreferredSizeStr("6.3492064mm 9.78836mm");
                gui_anxietyNum.setInlineStylesTheme(resourceObjectInstance);
        gui_anxietyNum.setInlineAllStyles("fgColor:0;");
        gui_anxietyNum.setName("anxietyNum");
        gui_confidenceNum.setPreferredSizeStr("6.0846562mm 9.78836mm");
                gui_confidenceNum.setInlineStylesTheme(resourceObjectInstance);
        gui_confidenceNum.setInlineAllStyles("fgColor:0;");
        gui_confidenceNum.setName("confidenceNum");
        gui_overallNum.setPreferredSizeStr("6.0846562mm inherit");
                gui_overallNum.setInlineStylesTheme(resourceObjectInstance);
        gui_overallNum.setInlineAllStyles("fgColor:0;");
        gui_overallNum.setName("overallNum");
        gui_Container.addComponent(gui_stressLabel);
        gui_Container.addComponent(gui_anxietyLabel);
        gui_Container.addComponent(gui_confidenceLabel);
        gui_Container.addComponent(gui_overallLabel);
        gui_Container.addComponent(gui_stressSlider);
        gui_Container.addComponent(gui_anxietySlider);
        gui_Container.addComponent(gui_confidenceSlider);
        gui_Container.addComponent(gui_overallSlider);
        gui_Container.addComponent(gui_stressNum);
        gui_Container.addComponent(gui_anxietyNum);
        gui_Container.addComponent(gui_confidenceNum);
        gui_Container.addComponent(gui_overallNum);
        ((com.codename1.ui.layouts.LayeredLayout) gui_stressLabel.getParent().getLayout()).setInsets(gui_stressLabel, "4.7619047mm auto auto 0.0mm").setReferenceComponents(gui_stressLabel, "-1 -1 -1 -1").setReferencePositions(gui_stressLabel, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_anxietyLabel.getParent().getLayout()).setInsets(gui_anxietyLabel, "23.809525% auto auto 0.0mm").setReferenceComponents(gui_anxietyLabel, "-1 -1 -1 -1").setReferencePositions(gui_anxietyLabel, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_confidenceLabel.getParent().getLayout()).setInsets(gui_confidenceLabel, "15.566038% auto 65.09434% 0.0mm").setReferenceComponents(gui_confidenceLabel, "1 -1 -1 -1").setReferencePositions(gui_confidenceLabel, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_overallLabel.getParent().getLayout()).setInsets(gui_overallLabel, "23.188406% auto 46.376812% 0.0mm").setReferenceComponents(gui_overallLabel, "2 -1 -1 -1").setReferencePositions(gui_overallLabel, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_stressSlider.getParent().getLayout()).setInsets(gui_stressSlider, "0.0mm 2.3809524mm 82.01944% 0.0mm").setReferenceComponents(gui_stressSlider, "-1 -1 -1 2 ").setReferencePositions(gui_stressSlider, "0.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_anxietySlider.getParent().getLayout()).setInsets(gui_anxietySlider, "-1.0582008mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_anxietySlider, "1 7 6 2 ").setReferencePositions(gui_anxietySlider, "0.0 0.0 1.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_confidenceSlider.getParent().getLayout()).setInsets(gui_confidenceSlider, "auto 0.0mm 38.78788% 0.0mm").setReferenceComponents(gui_confidenceSlider, "-1 4 -1 2 ").setReferencePositions(gui_confidenceSlider, "0.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_overallSlider.getParent().getLayout()).setInsets(gui_overallSlider, "-2.6455026mm 0.0mm auto 0.0mm").setReferenceComponents(gui_overallSlider, "3 8 -1 2 ").setReferencePositions(gui_overallSlider, "0.0 1.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_stressNum.getParent().getLayout()).setInsets(gui_stressNum, "0.0mm 0.0mm auto auto").setReferenceComponents(gui_stressNum, "4 10 0 -1").setReferencePositions(gui_stressNum, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_anxietyNum.getParent().getLayout()).setInsets(gui_anxietyNum, "0.0mm auto 0.0mm 0.0mm").setReferenceComponents(gui_anxietyNum, "1 -1 1 5 ").setReferencePositions(gui_anxietyNum, "0.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_confidenceNum.getParent().getLayout()).setInsets(gui_confidenceNum, "84.0% 0.0mm -1.3227513mm auto").setReferenceComponents(gui_confidenceNum, "-1 -1 2 -1").setReferencePositions(gui_confidenceNum, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_overallNum.getParent().getLayout()).setInsets(gui_overallNum, "67.251465% 0.0mm 20.760235% 0.0mm").setReferenceComponents(gui_overallNum, "-1 -1 -1 10 ").setReferencePositions(gui_overallNum, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_topInset.getParent().getLayout()).setInsets(gui_topInset, "1.6mm 5.0mm auto 5.0mm").setReferenceComponents(gui_topInset, "-1 -1 -1 -1").setReferencePositions(gui_topInset, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_confirmButton.getParent().getLayout()).setInsets(gui_confirmButton, "auto auto auto auto").setReferenceComponents(gui_confirmButton, "4 0 -1 0 ").setReferencePositions(gui_confirmButton, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_backButton.getParent().getLayout()).setInsets(gui_backButton, "0.0mm auto auto 0.0mm").setReferenceComponents(gui_backButton, "0 -1 -1 0 ").setReferencePositions(gui_backButton, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_moodLabels.getParent().getLayout()).setInsets(gui_moodLabels, "8.0% 0.0mm auto 0.0mm").setReferenceComponents(gui_moodLabels, "0 0 -1 0 ").setReferencePositions(gui_moodLabels, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container.getLayout()).setPreferredWidthMM((float) 106.084656);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container.getLayout()).setPreferredHeightMM((float) 90.47619);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container.getParent().getLayout()).setInsets(gui_Container, "4.926351% 0.0mm auto 0.0mm").setReferenceComponents(gui_Container, "3 -1 -1 -1").setReferencePositions(gui_Container, "1.0 0.0 0.0 0.0");
    } // </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
