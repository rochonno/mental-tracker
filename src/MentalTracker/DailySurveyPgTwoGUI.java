

/*
Fix Insets before resizing this.
 */

package MentalTracker;

import com.codename1.ui.events.ActionEvent;

public class DailySurveyPgTwoGUI extends com.codename1.ui.Form {
    public DailySurveyPgTwoGUI() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public DailySurveyPgTwoGUI(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

    public void oncontinueButtonActionEvent(ActionEvent ev) {
        //Verify Input data
        boolean pass = false;
        String errors = "The following prompts were't answered: \n";
        while (pass = false){
            pass = true;
            if (!(gui_depressedButtonNo.isSelected() || gui_depressedButtonYes.isSelected())){
                errors += "Have you felt depressed recently? \n";
            }
            if (!(gui_panicButtonNo.isSelected() || gui_panicButtonYes.isSelected())){
                errors += "Any symptoms of panic recently? \n";
            }
            if (!(gui_exerciseButtonYes.isSelected() || gui_exerciseButtonNo.isSelected())){
                errors += "Did you exercise? \n";
            }
            //if (!())
        }
    }


    public void onbackButtonActionEvent(ActionEvent ev) {
    }

    //-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Label gui_topInset = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_depressedLabel = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_panicLabel = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_exerciseLabel = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_sleepLabel = new com.codename1.ui.Label();
    protected com.codename1.ui.RadioButton gui_depressedButtonYes = new com.codename1.ui.RadioButton();
    protected com.codename1.ui.Label gui_yesterdayLabel = new com.codename1.ui.Label();
    protected com.codename1.ui.Button gui_backButton = new com.codename1.ui.Button();
    protected com.codename1.ui.RadioButton gui_depressedButtonNo = new com.codename1.ui.RadioButton();
    protected com.codename1.ui.RadioButton gui_panicButtonNo = new com.codename1.ui.RadioButton();
    protected com.codename1.ui.RadioButton gui_panicButtonYes = new com.codename1.ui.RadioButton();
    protected com.codename1.ui.RadioButton gui_exerciseButtonYes = new com.codename1.ui.RadioButton();
    protected com.codename1.ui.RadioButton gui_exerciseButtonNo = new com.codename1.ui.RadioButton();
    protected com.codename1.ui.TextArea gui_sleepInput = new com.codename1.ui.TextArea();
    protected com.codename1.ui.TextField gui_sugarInput = new com.codename1.ui.TextField();
    protected com.codename1.ui.Label gui_yesButtonInset = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_noButtonInset = new com.codename1.ui.Label();
    protected com.codename1.ui.Button gui_continueButton = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_backButton.addActionListener(callback);
        gui_continueButton.addActionListener(callback);
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

            if(sourceComponent == gui_backButton) {
                onbackButtonActionEvent(ev);
            }
            if(sourceComponent == gui_continueButton) {
                oncontinueButtonActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(false);
                setInlineStylesTheme(resourceObjectInstance);
        setInlineAllStyles("bgColor:efefef;");
        setTitle("DailySurveyPgTwoGUI");
        setName("DailySurveyPgTwoGUI");
        addComponent(gui_topInset);
        addComponent(gui_Label);
        addComponent(gui_depressedLabel);
        addComponent(gui_panicLabel);
        addComponent(gui_exerciseLabel);
        addComponent(gui_sleepLabel);
        addComponent(gui_depressedButtonYes);
        addComponent(gui_yesterdayLabel);
        addComponent(gui_backButton);
        addComponent(gui_depressedButtonNo);
        addComponent(gui_panicButtonNo);
        addComponent(gui_panicButtonYes);
        addComponent(gui_exerciseButtonYes);
        addComponent(gui_exerciseButtonNo);
        addComponent(gui_sleepInput);
        addComponent(gui_sugarInput);
        addComponent(gui_yesButtonInset);
        addComponent(gui_noButtonInset);
        addComponent(gui_continueButton);
        gui_topInset.setPreferredSizeStr("inherit 6.6137567mm");
                gui_topInset.setInlineStylesTheme(resourceObjectInstance);
        gui_topInset.setName("topInset");
        ((com.codename1.ui.layouts.LayeredLayout)gui_topInset.getParent().getLayout()).setInsets(gui_topInset, "1.6mm 5.0mm 95.26387% 5.0mm").setReferenceComponents(gui_topInset, "-1 -1 -1 -1").setReferencePositions(gui_topInset, "0.0 0.0 0.0 0.0");
        gui_Label.setPreferredSizeStr("126.190475mm 10.8465605mm");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("alignment:center;");
        gui_Label.setName("Label");
        gui_Label.setIcon(resourceObjectInstance.getImage("sugarLabel.png"));
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "-0.26455027mm -1.3227513mm auto -4.497355mm").setReferenceComponents(gui_Label, "14 0 -1 0 ").setReferencePositions(gui_Label, "1.0 0.0 0.0 0.0");
        gui_depressedLabel.setPreferredSizeStr("133.33333mm 10.8465605mm");
                gui_depressedLabel.setInlineStylesTheme(resourceObjectInstance);
        gui_depressedLabel.setInlineAllStyles("alignment:center;");
        gui_depressedLabel.setName("depressedLabel");
        gui_depressedLabel.setIcon(resourceObjectInstance.getImage("depressedLabel.png"));
        ((com.codename1.ui.layouts.LayeredLayout)gui_depressedLabel.getParent().getLayout()).setInsets(gui_depressedLabel, "auto 5.026455mm 0.0mm 0.0mm").setReferenceComponents(gui_depressedLabel, "-1 -1 8 0 ").setReferencePositions(gui_depressedLabel, "0.0 0.0 0.0 0.0");
        gui_panicLabel.setPreferredSizeStr("133.33333mm 7.936508mm");
                gui_panicLabel.setInlineStylesTheme(resourceObjectInstance);
        gui_panicLabel.setInlineAllStyles("alignment:center;");
        gui_panicLabel.setName("panicLabel");
        gui_panicLabel.setIcon(resourceObjectInstance.getImage("panicLabel.png 1"));
        ((com.codename1.ui.layouts.LayeredLayout)gui_panicLabel.getParent().getLayout()).setInsets(gui_panicLabel, "2.6455026mm -1.322751mm auto -3.7037036mm").setReferenceComponents(gui_panicLabel, "6 0 -1 0 ").setReferencePositions(gui_panicLabel, "1.0 0.0 0.0 0.0");
        gui_exerciseLabel.setPreferredSizeStr("133.33333mm 10.05291mm");
                gui_exerciseLabel.setInlineStylesTheme(resourceObjectInstance);
        gui_exerciseLabel.setInlineAllStyles("alignment:center;");
        gui_exerciseLabel.setName("exerciseLabel");
        gui_exerciseLabel.setIcon(resourceObjectInstance.getImage("exerciseLabel.png"));
        ((com.codename1.ui.layouts.LayeredLayout)gui_exerciseLabel.getParent().getLayout()).setInsets(gui_exerciseLabel, "6.267806% 0.0mm auto 0.0mm").setReferenceComponents(gui_exerciseLabel, "7 0 -1 0 ").setReferencePositions(gui_exerciseLabel, "1.0 0.0 0.0 0.0");
        gui_sleepLabel.setPreferredSizeStr("133.33333mm 8.730159mm");
                gui_sleepLabel.setInlineStylesTheme(resourceObjectInstance);
        gui_sleepLabel.setInlineAllStyles("alignment:center;");
        gui_sleepLabel.setInlinePressedStyles("alignment:left;");
        gui_sleepLabel.setName("sleepLabel");
        gui_sleepLabel.setIcon(resourceObjectInstance.getImage("sleepLabel.png"));
        ((com.codename1.ui.layouts.LayeredLayout)gui_sleepLabel.getParent().getLayout()).setInsets(gui_sleepLabel, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_sleepLabel, "12 0 -1 0 ").setReferencePositions(gui_sleepLabel, "1.0 0.0 0.0 0.0");
        gui_depressedButtonYes.setPreferredSizeStr("22.486773mm 6.6137567mm");
        gui_depressedButtonYes.setSelected(false);
        gui_depressedButtonYes.setUIID("ToggleButton");
                gui_depressedButtonYes.setInlineStylesTheme(resourceObjectInstance);
        gui_depressedButtonYes.setInlineAllStyles("border:none; bgColor:efefef;");
        gui_depressedButtonYes.setInlineSelectedStyles("border:none;");
        gui_depressedButtonYes.setInlinePressedStyles("border:none;");
        gui_depressedButtonYes.setGroup("depressedButtonGroup");
        gui_depressedButtonYes.setName("depressedButtonYes");
        gui_depressedButtonYes.setIcon(resourceObjectInstance.getImage("yesButtonUnselect.png"));
        gui_depressedButtonYes.setPressedIcon(resourceObjectInstance.getImage("yesButtonSelect.png"));
        ((com.codename1.ui.layouts.LayeredLayout)gui_depressedButtonYes.getParent().getLayout()).setInsets(gui_depressedButtonYes, "7.632094% 0.0mm auto 0.0mm").setReferenceComponents(gui_depressedButtonYes, "2 16 -1 16 ").setReferencePositions(gui_depressedButtonYes, "0.0 0.0 0.0 0.0");
        gui_yesterdayLabel.setPreferredSizeStr("61.640213mm 9.523809mm");
                gui_yesterdayLabel.setInlineStylesTheme(resourceObjectInstance);
        gui_yesterdayLabel.setName("yesterdayLabel");
        gui_yesterdayLabel.setIcon(resourceObjectInstance.getImage("yesterdayLabel.png"));
        ((com.codename1.ui.layouts.LayeredLayout)gui_yesterdayLabel.getParent().getLayout()).setInsets(gui_yesterdayLabel, "4.4973545mm auto auto 0.0mm").setReferenceComponents(gui_yesterdayLabel, "11 0 -1 0 ").setReferencePositions(gui_yesterdayLabel, "1.0 0.0 0.0 0.0");
        gui_backButton.setPreferredSizeStr("17.724869mm 14.550264mm");
                gui_backButton.setInlineStylesTheme(resourceObjectInstance);
        gui_backButton.setName("backButton");
        gui_backButton.setIcon(resourceObjectInstance.getImage("backButton.png"));
        gui_backButton.setPressedIcon(resourceObjectInstance.getImage("backPressed.png"));
        ((com.codename1.ui.layouts.LayeredLayout)gui_backButton.getParent().getLayout()).setInsets(gui_backButton, "0.0mm 83.553925% 90.45307% 1.3227515mm").setReferenceComponents(gui_backButton, "17 -1 -1 -1").setReferencePositions(gui_backButton, "1.0 0.0 0.0 0.0");
        gui_depressedButtonNo.setPreferredSizeStr("18.78307mm 6.878307mm");
        gui_depressedButtonNo.setSelected(false);
        gui_depressedButtonNo.setUIID("ToggleButton");
                gui_depressedButtonNo.setInlineStylesTheme(resourceObjectInstance);
        gui_depressedButtonNo.setInlineAllStyles("border:none; bgColor:efefef;");
        gui_depressedButtonNo.setInlineSelectedStyles("border:none;");
        gui_depressedButtonNo.setInlinePressedStyles("border:none;");
        gui_depressedButtonNo.setGroup("depressedButtonGroup");
        gui_depressedButtonNo.setName("depressedButtonNo");
        gui_depressedButtonNo.setIcon(resourceObjectInstance.getImage("noButtonUnsele.png"));
        gui_depressedButtonNo.setPressedIcon(resourceObjectInstance.getImage("noButtonSelect.png"));
        ((com.codename1.ui.layouts.LayeredLayout)gui_depressedButtonNo.getParent().getLayout()).setInsets(gui_depressedButtonNo, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_depressedButtonNo, "6 17 6 10 ").setReferencePositions(gui_depressedButtonNo, "0.0 0.0 0.0 0.0");
        gui_panicButtonNo.setPreferredSizeStr("inherit 5.555556mm");
        gui_panicButtonNo.setUIID("ToggleButton");
                gui_panicButtonNo.setInlineStylesTheme(resourceObjectInstance);
        gui_panicButtonNo.setInlineAllStyles("border:none; bgColor:efefef;");
        gui_panicButtonNo.setInlineSelectedStyles("border:none;");
        gui_panicButtonNo.setInlinePressedStyles("border:none;");
        gui_panicButtonNo.setGroup("panicButtonGroup");
        gui_panicButtonNo.setName("panicButtonNo");
        gui_panicButtonNo.setIcon(resourceObjectInstance.getImage("noButtonUnsele.png"));
        ((com.codename1.ui.layouts.LayeredLayout)gui_panicButtonNo.getParent().getLayout()).setInsets(gui_panicButtonNo, "0.0mm 0.0mm 2.6455002mm 0.0mm").setReferenceComponents(gui_panicButtonNo, "11 17 11 17 ").setReferencePositions(gui_panicButtonNo, "0.0 0.0 0.0 0.0");
        gui_panicButtonYes.setPreferredSizeStr("22.486773mm 8.730159mm");
        gui_panicButtonYes.setSelected(false);
        gui_panicButtonYes.setUIID("ToggleButton");
                gui_panicButtonYes.setInlineStylesTheme(resourceObjectInstance);
        gui_panicButtonYes.setInlineAllStyles("border:none; bgColor:efefef;");
        gui_panicButtonYes.setInlineSelectedStyles("border:none;");
        gui_panicButtonYes.setInlinePressedStyles("border:none;");
        gui_panicButtonYes.setGroup("panicButtonGroup");
        gui_panicButtonYes.setName("panicButtonYes");
        gui_panicButtonYes.setIcon(resourceObjectInstance.getImage("yesButtonUnselect.png"));
        gui_panicButtonYes.setPressedIcon(resourceObjectInstance.getImage("yesButtonSelect.png"));
        ((com.codename1.ui.layouts.LayeredLayout)gui_panicButtonYes.getParent().getLayout()).setInsets(gui_panicButtonYes, "0.7936508mm 0.0mm auto 0.0mm").setReferenceComponents(gui_panicButtonYes, "3 16 -1 16 ").setReferencePositions(gui_panicButtonYes, "1.0 0.0 0.0 0.0");
        gui_exerciseButtonYes.setPreferredSizeStr("21.16402mm 7.142857mm");
        gui_exerciseButtonYes.setSelected(false);
        gui_exerciseButtonYes.setUIID("ToggleButton");
                gui_exerciseButtonYes.setInlineStylesTheme(resourceObjectInstance);
        gui_exerciseButtonYes.setInlineAllStyles("border:none; bgColor:efefef;");
        gui_exerciseButtonYes.setInlineSelectedStyles("border:none;");
        gui_exerciseButtonYes.setInlinePressedStyles("border:none;");
        gui_exerciseButtonYes.setGroup("exerciseButtonGroup");
        gui_exerciseButtonYes.setName("exerciseButtonYes");
        gui_exerciseButtonYes.setIcon(resourceObjectInstance.getImage("yesButtonUnselect.png"));
        gui_exerciseButtonYes.setPressedIcon(resourceObjectInstance.getImage("yesButtonSelect.png"));
        ((com.codename1.ui.layouts.LayeredLayout)gui_exerciseButtonYes.getParent().getLayout()).setInsets(gui_exerciseButtonYes, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_exerciseButtonYes, "4 16 -1 16 ").setReferencePositions(gui_exerciseButtonYes, "1.0 0.0 0.0 0.0");
        gui_exerciseButtonNo.setPreferredSizeStr("18.78307mm 6.6137567mm");
        gui_exerciseButtonNo.setSelected(false);
        gui_exerciseButtonNo.setUIID("ToggleButton");
                gui_exerciseButtonNo.setInlineStylesTheme(resourceObjectInstance);
        gui_exerciseButtonNo.setInlineAllStyles("border:none; bgColor:efefef;");
        gui_exerciseButtonNo.setInlineSelectedStyles("border:none;");
        gui_exerciseButtonNo.setInlinePressedStyles("border:none;");
        gui_exerciseButtonNo.setGroup("exerciseButtonGroup");
        gui_exerciseButtonNo.setName("exerciseButtonNo");
        gui_exerciseButtonNo.setIcon(resourceObjectInstance.getImage("noButtonUnsele.png"));
        gui_exerciseButtonNo.setPressedIcon(resourceObjectInstance.getImage("noButtonSelect.png"));
        ((com.codename1.ui.layouts.LayeredLayout)gui_exerciseButtonNo.getParent().getLayout()).setInsets(gui_exerciseButtonNo, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_exerciseButtonNo, "4 17 -1 9 ").setReferencePositions(gui_exerciseButtonNo, "1.0 0.0 0.0 0.0");
        gui_sleepInput.setPreferredSizeStr("75.66138mm inherit");
        gui_sleepInput.setHint("In Hours");
                gui_sleepInput.setInlineStylesTheme(resourceObjectInstance);
        gui_sleepInput.setName("sleepInput");
        gui_sleepInput.setColumns(8);
        ((com.codename1.ui.layouts.LayeredLayout)gui_sleepInput.getParent().getLayout()).setInsets(gui_sleepInput, "3.968254mm 37.200737% auto 30.939226%").setReferenceComponents(gui_sleepInput, "5 0 -1 0 ").setReferencePositions(gui_sleepInput, "1.0 0.0 0.0 0.0");
        gui_sugarInput.setPreferredSizeStr("23.015873mm 5.555556mm");
        gui_sugarInput.setHint("In Grams");
                gui_sugarInput.setInlineStylesTheme(resourceObjectInstance);
        gui_sugarInput.setName("sugarInput");
        ((com.codename1.ui.layouts.LayeredLayout)gui_sugarInput.getParent().getLayout()).setInsets(gui_sugarInput, "0.0mm 0.0mm auto 57.218094%").setReferenceComponents(gui_sugarInput, "1 9 -1 0 ").setReferencePositions(gui_sugarInput, "1.0 1.0 0.0 0.0");
        gui_yesButtonInset.setPreferredSizeStr("27.513227mm 4.7619047mm");
                gui_yesButtonInset.setInlineStylesTheme(resourceObjectInstance);
        gui_yesButtonInset.setName("yesButtonInset");
        ((com.codename1.ui.layouts.LayeredLayout)gui_yesButtonInset.getParent().getLayout()).setInsets(gui_yesButtonInset, "0.0mm 33.314266% auto 24.45237%").setReferenceComponents(gui_yesButtonInset, "0 17 -1 -1").setReferencePositions(gui_yesButtonInset, "1.0 1.0 0.0 0.0");
        gui_noButtonInset.setPreferredSizeStr("25.132275mm 1.3227513mm");
                gui_noButtonInset.setInlineStylesTheme(resourceObjectInstance);
        gui_noButtonInset.setName("noButtonInset");
        ((com.codename1.ui.layouts.LayeredLayout)gui_noButtonInset.getParent().getLayout()).setInsets(gui_noButtonInset, "3.174603mm 16.619184% auto 60.144547%").setReferenceComponents(gui_noButtonInset, "-1 -1 -1 -1").setReferencePositions(gui_noButtonInset, "0.0 0.0 0.0 0.0");
                gui_continueButton.setInlineStylesTheme(resourceObjectInstance);
        gui_continueButton.setName("continueButton");
        gui_continueButton.setIcon(resourceObjectInstance.getImage("continueButton.png"));
        gui_continueButton.setPressedIcon(resourceObjectInstance.getImage("continuePress.png"));
        ((com.codename1.ui.layouts.LayeredLayout)gui_continueButton.getParent().getLayout()).setInsets(gui_continueButton, "auto auto 9.259259mm 22.008547%").setReferenceComponents(gui_continueButton, "0 0 -1 0 ").setReferencePositions(gui_continueButton, "1.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
