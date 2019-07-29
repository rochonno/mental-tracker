package tracker.Pages;

import com.codename1.ui.Component;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.events.ActionEvent;

;import java.util.ArrayList;

public class SurveyPg1 extends com.codename1.ui.Form {
    private ArrayList<com.codename1.ui.Label> transparent;
    private ArrayList<com.codename1.ui.Label> filled;

    public SurveyPg1() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }
    
    public SurveyPg1(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }


    public void onanxietySliderActionEvent(ActionEvent ev) {
        updateText(gui_anxietyNum, gui_anxietySlider);
    }

    public void onconfidenceSliderActionEvent(ActionEvent ev) {
        updateText(gui_confidenceNum, gui_confidenceSlider);
    }

    public void onstressSliderActionEvent(ActionEvent ev) {
        updateText(gui_stressNum, gui_stressSlider);
    }

    public void onoverallSliderActionEvent(ActionEvent ev) {
        updateText(gui_overallNum, gui_overallSlider);
    }

    public void updateText(Label label, Slider slider){
        label.setText("" + (slider.getProgress() % 10));
        int temp = Integer.parseInt(label.getText());
        if(temp >= 7){
            label.getAllStyles().setFgColor(0xd68f);
        }else if(temp >= 4){
            label.getAllStyles().setFgColor(0xffaa00);
        }else{
            label.getAllStyles().setFgColor(0xff3d71);
        }

        updateSlider(slider, temp);
        //label.repaint(); //Change?
    }

    public void updateSlider(Slider slider, int temp){
        com.codename1.ui.Container layout;
        if (slider == gui_anxietySlider){
             layout = gui_anxietyBox;
        }else if (slider == gui_confidenceSlider){
            layout = gui_confidenceBox;
        }else if (slider == gui_stressSlider){
            layout = gui_stressBox;
        }else{
            layout = gui_overallBox;
        }

        int boxIncrement = 10 - temp;

        for(int i = 0; i < boxIncrement; i++){
            layout.getComponentAt(0 + i).setInlineAllStyles("bgType:image_scaled_fit; bgImage:s" + (0 + i) + ".png");
        }
        for (int i = boxIncrement; i >= 1; i--){
            layout.getComponentAt(i).setInlineAllStyles("bgType:image_scaled_fit; bgImage:" + i + ".png");
        }
        layout.repaint();

    }

    //-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_moodLabel = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_slideGrid = new com.codename1.ui.Container(new com.codename1.ui.layouts.GridLayout(1, 4));
    protected com.codename1.ui.Container gui_anxietyBox = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Label gui_anxiety_10 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_anxiety_9 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_anxiety_8 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_anxiety_7 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_anxiety_6 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_anxiety_5 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_anxiety_4 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_anxiety_3 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_anxiety_2 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_anxiety_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_anxietyLabel = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_anxietyNum = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_confidenceBox = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Label gui_confidence_10 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_confidence_9 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_confidence_8 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_confidence_7 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_confidence_6 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_confidence_5 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_confidence_4 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_confidence_3 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_confidence_2 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_confidence_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_confidenceLabel = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_confidenceNum = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_stressBox = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Label gui_stress_10 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_stress_9 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_stress_8 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_stress_7 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_stress_6 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_stress_5 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_stress_4 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_stress_3 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_stress_2 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_stress_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_stressLabel = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_stressNum = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_overallBox = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Label gui_overall_10 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_overall_9 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_overall_8 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_overall_7 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_overall_6 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_overall_5 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_overall_4 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_overall_3 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_overall_2 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_overall_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_overallLabel = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_overallNum = new com.codename1.ui.Label();
    protected com.codename1.ui.Slider gui_overallSlider = new com.codename1.ui.Slider();
    protected com.codename1.ui.Slider gui_stressSlider = new com.codename1.ui.Slider();
    protected com.codename1.ui.Slider gui_confidenceSlider = new com.codename1.ui.Slider();
    protected com.codename1.ui.Slider gui_anxietySlider = new com.codename1.ui.Slider();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_overallSlider.addActionListener(callback);
        gui_stressSlider.addActionListener(callback);
        gui_confidenceSlider.addActionListener(callback);
        gui_anxietySlider.addActionListener(callback);
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

            if(sourceComponent == gui_overallSlider) {
                onoverallSliderActionEvent(ev);
            }
            if(sourceComponent == gui_stressSlider) {
                onstressSliderActionEvent(ev);
            }
            if(sourceComponent == gui_confidenceSlider) {
                onconfidenceSliderActionEvent(ev);
            }
            if(sourceComponent == gui_anxietySlider) {
                onanxietySliderActionEvent(ev);
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
        setTitle("tracker.Pages.SurveyPg1");
        setName("tracker.Pages.SurveyPg1");
        addComponent(gui_Button_1);
        addComponent(gui_moodLabel);
        addComponent(gui_slideGrid);
        gui_slideGrid.setPreferredSizeStr("213.75662mm 113.492065mm");
        gui_slideGrid.setScrollableY(false);
                gui_slideGrid.setInlineStylesTheme(resourceObjectInstance);
        gui_slideGrid.setName("slideGrid");
        ((com.codename1.ui.layouts.LayeredLayout)gui_slideGrid.getParent().getLayout()).setInsets(gui_slideGrid, "17.396593% -0.52910054mm auto 0.0mm").setReferenceComponents(gui_slideGrid, "-1 -1 -1 -1").setReferencePositions(gui_slideGrid, "0.0 0.0 0.0 0.0");
        gui_slideGrid.addComponent(gui_anxietyBox);
        gui_anxietyBox.setPreferredSizeStr("48.67725mm 97.8836mm");
                gui_anxietyBox.setInlineStylesTheme(resourceObjectInstance);
        gui_anxietyBox.setName("anxietyBox");
        gui_anxietyBox.addComponent(gui_anxiety_10);
        gui_anxietyBox.addComponent(gui_anxiety_9);
        gui_anxietyBox.addComponent(gui_anxiety_8);
        gui_anxietyBox.addComponent(gui_anxiety_7);
        gui_anxietyBox.addComponent(gui_anxiety_6);
        gui_anxietyBox.addComponent(gui_anxiety_5);
        gui_anxietyBox.addComponent(gui_anxiety_4);
        gui_anxietyBox.addComponent(gui_anxiety_3);
        gui_anxietyBox.addComponent(gui_anxiety_2);
        gui_anxietyBox.addComponent(gui_anxiety_1);
        gui_anxietyBox.addComponent(gui_anxietyLabel);
        gui_anxietyBox.addComponent(gui_anxietyNum);
        gui_anxiety_10.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_anxiety_10.setInlineStylesTheme(resourceObjectInstance);
        gui_anxiety_10.setInlineAllStyles("bgType:image_scaled_fit; bgImage:10.png;");
        gui_anxiety_10.setName("anxiety_10");
        gui_anxiety_9.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_anxiety_9.setInlineStylesTheme(resourceObjectInstance);
        gui_anxiety_9.setInlineAllStyles("bgType:image_scaled_fit; bgImage:9.png;");
        gui_anxiety_9.setName("anxiety_9");
        gui_anxiety_8.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_anxiety_8.setInlineStylesTheme(resourceObjectInstance);
        gui_anxiety_8.setInlineAllStyles("bgType:image_scaled_fit; bgImage:8.png;");
        gui_anxiety_8.setName("anxiety_8");
        gui_anxiety_7.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_anxiety_7.setInlineStylesTheme(resourceObjectInstance);
        gui_anxiety_7.setInlineAllStyles("bgType:image_scaled_fit; bgImage:7.png;");
        gui_anxiety_7.setName("anxiety_7");
        gui_anxiety_6.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_anxiety_6.setInlineStylesTheme(resourceObjectInstance);
        gui_anxiety_6.setInlineAllStyles("bgType:image_scaled_fit; bgImage:6.png;");
        gui_anxiety_6.setName("anxiety_6");
        gui_anxiety_5.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_anxiety_5.setInlineStylesTheme(resourceObjectInstance);
        gui_anxiety_5.setInlineAllStyles("bgType:image_scaled_fit; bgImage:5.png;");
        gui_anxiety_5.setName("anxiety_5");
        gui_anxiety_4.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_anxiety_4.setInlineStylesTheme(resourceObjectInstance);
        gui_anxiety_4.setInlineAllStyles("bgType:image_scaled_fit; bgImage:4.png;");
        gui_anxiety_4.setName("anxiety_4");
        gui_anxiety_3.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_anxiety_3.setInlineStylesTheme(resourceObjectInstance);
        gui_anxiety_3.setInlineAllStyles("bgType:image_scaled_fit; bgImage:3.png;");
        gui_anxiety_3.setName("anxiety_3");
        gui_anxiety_2.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_anxiety_2.setInlineStylesTheme(resourceObjectInstance);
        gui_anxiety_2.setInlineAllStyles("bgType:image_scaled_fit; bgImage:2.png;");
        gui_anxiety_2.setName("anxiety_2");
        gui_anxiety_1.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_anxiety_1.setInlineStylesTheme(resourceObjectInstance);
        gui_anxiety_1.setInlineAllStyles("bgType:image_scaled_fit; bgImage:1.png;");
        gui_anxiety_1.setName("anxiety_1");
        gui_anxietyLabel.setText("Anxiety");
                gui_anxietyLabel.setInlineStylesTheme(resourceObjectInstance);
        gui_anxietyLabel.setInlineAllStyles("font:native:MainRegular native:MainRegular; alignment:center;");
        gui_anxietyLabel.setName("anxietyLabel");
        gui_anxietyNum.setText("0");
                gui_anxietyNum.setInlineStylesTheme(resourceObjectInstance);
        gui_anxietyNum.setInlineAllStyles("font:native:MainRegular native:MainRegular; alignment:center;");
        gui_anxietyNum.setName("anxietyNum");
        gui_slideGrid.addComponent(gui_confidenceBox);
        gui_confidenceBox.setPreferredSizeStr("48.67725mm 111.90476mm");
                gui_confidenceBox.setInlineStylesTheme(resourceObjectInstance);
        gui_confidenceBox.setName("confidenceBox");
        gui_confidenceBox.addComponent(gui_confidence_10);
        gui_confidenceBox.addComponent(gui_confidence_9);
        gui_confidenceBox.addComponent(gui_confidence_8);
        gui_confidenceBox.addComponent(gui_confidence_7);
        gui_confidenceBox.addComponent(gui_confidence_6);
        gui_confidenceBox.addComponent(gui_confidence_5);
        gui_confidenceBox.addComponent(gui_confidence_4);
        gui_confidenceBox.addComponent(gui_confidence_3);
        gui_confidenceBox.addComponent(gui_confidence_2);
        gui_confidenceBox.addComponent(gui_confidence_1);
        gui_confidenceBox.addComponent(gui_confidenceLabel);
        gui_confidenceBox.addComponent(gui_confidenceNum);
        gui_confidence_10.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_confidence_10.setInlineStylesTheme(resourceObjectInstance);
        gui_confidence_10.setInlineAllStyles("bgType:image_scaled_fit; bgImage:10.png;");
        gui_confidence_10.setName("confidence_10");
        gui_confidence_9.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_confidence_9.setInlineStylesTheme(resourceObjectInstance);
        gui_confidence_9.setInlineAllStyles("bgType:image_scaled_fit; bgImage:9.png;");
        gui_confidence_9.setName("confidence_9");
        gui_confidence_8.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_confidence_8.setInlineStylesTheme(resourceObjectInstance);
        gui_confidence_8.setInlineAllStyles("bgType:image_scaled_fit; bgImage:8.png;");
        gui_confidence_8.setName("confidence_8");
        gui_confidence_7.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_confidence_7.setInlineStylesTheme(resourceObjectInstance);
        gui_confidence_7.setInlineAllStyles("bgType:image_scaled_fit; bgImage:7.png;");
        gui_confidence_7.setName("confidence_7");
        gui_confidence_6.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_confidence_6.setInlineStylesTheme(resourceObjectInstance);
        gui_confidence_6.setInlineAllStyles("bgType:image_scaled_fit; bgImage:6.png;");
        gui_confidence_6.setName("confidence_6");
        gui_confidence_5.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_confidence_5.setInlineStylesTheme(resourceObjectInstance);
        gui_confidence_5.setInlineAllStyles("bgType:image_scaled_fit; bgImage:5.png;");
        gui_confidence_5.setName("confidence_5");
        gui_confidence_4.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_confidence_4.setInlineStylesTheme(resourceObjectInstance);
        gui_confidence_4.setInlineAllStyles("bgType:image_scaled_fit; bgImage:4.png;");
        gui_confidence_4.setName("confidence_4");
        gui_confidence_3.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_confidence_3.setInlineStylesTheme(resourceObjectInstance);
        gui_confidence_3.setInlineAllStyles("bgType:image_scaled_fit; bgImage:3.png;");
        gui_confidence_3.setName("confidence_3");
        gui_confidence_2.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_confidence_2.setInlineStylesTheme(resourceObjectInstance);
        gui_confidence_2.setInlineAllStyles("bgType:image_scaled_fit; bgImage:2.png;");
        gui_confidence_2.setName("confidence_2");
        gui_confidence_1.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_confidence_1.setInlineStylesTheme(resourceObjectInstance);
        gui_confidence_1.setInlineAllStyles("bgType:image_scaled_fit; bgImage:1.png;");
        gui_confidence_1.setName("confidence_1");
        gui_confidenceLabel.setText("Confidence");
                gui_confidenceLabel.setInlineStylesTheme(resourceObjectInstance);
        gui_confidenceLabel.setInlineAllStyles("font:native:MainRegular native:MainRegular; alignment:center;");
        gui_confidenceLabel.setName("confidenceLabel");
        gui_confidenceNum.setText("0");
                gui_confidenceNum.setInlineStylesTheme(resourceObjectInstance);
        gui_confidenceNum.setInlineAllStyles("font:native:MainRegular native:MainRegular; alignment:center;");
        gui_confidenceNum.setName("confidenceNum");
        gui_slideGrid.addComponent(gui_stressBox);
        gui_stressBox.setPreferredSizeStr("48.67725mm 111.90476mm");
                gui_stressBox.setInlineStylesTheme(resourceObjectInstance);
        gui_stressBox.setName("stressBox");
        gui_stressBox.addComponent(gui_stress_10);
        gui_stressBox.addComponent(gui_stress_9);
        gui_stressBox.addComponent(gui_stress_8);
        gui_stressBox.addComponent(gui_stress_7);
        gui_stressBox.addComponent(gui_stress_6);
        gui_stressBox.addComponent(gui_stress_5);
        gui_stressBox.addComponent(gui_stress_4);
        gui_stressBox.addComponent(gui_stress_3);
        gui_stressBox.addComponent(gui_stress_2);
        gui_stressBox.addComponent(gui_stress_1);
        gui_stressBox.addComponent(gui_stressLabel);
        gui_stressBox.addComponent(gui_stressNum);
        gui_stress_10.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_stress_10.setInlineStylesTheme(resourceObjectInstance);
        gui_stress_10.setInlineAllStyles("bgType:image_scaled_fit; bgImage:10.png;");
        gui_stress_10.setName("stress_10");
        gui_stress_9.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_stress_9.setInlineStylesTheme(resourceObjectInstance);
        gui_stress_9.setInlineAllStyles("bgType:image_scaled_fit; bgImage:9.png;");
        gui_stress_9.setName("stress_9");
        gui_stress_8.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_stress_8.setInlineStylesTheme(resourceObjectInstance);
        gui_stress_8.setInlineAllStyles("bgType:image_scaled_fit; bgImage:8.png;");
        gui_stress_8.setName("stress_8");
        gui_stress_7.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_stress_7.setInlineStylesTheme(resourceObjectInstance);
        gui_stress_7.setInlineAllStyles("bgType:image_scaled_fit; bgImage:7.png;");
        gui_stress_7.setName("stress_7");
        gui_stress_6.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_stress_6.setInlineStylesTheme(resourceObjectInstance);
        gui_stress_6.setInlineAllStyles("bgType:image_scaled_fit; bgImage:6.png;");
        gui_stress_6.setName("stress_6");
        gui_stress_5.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_stress_5.setInlineStylesTheme(resourceObjectInstance);
        gui_stress_5.setInlineAllStyles("bgType:image_scaled_fit; bgImage:5.png;");
        gui_stress_5.setName("stress_5");
        gui_stress_4.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_stress_4.setInlineStylesTheme(resourceObjectInstance);
        gui_stress_4.setInlineAllStyles("bgType:image_scaled_fit; bgImage:4.png;");
        gui_stress_4.setName("stress_4");
        gui_stress_3.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_stress_3.setInlineStylesTheme(resourceObjectInstance);
        gui_stress_3.setInlineAllStyles("bgType:image_scaled_fit; bgImage:3.png;");
        gui_stress_3.setName("stress_3");
        gui_stress_2.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_stress_2.setInlineStylesTheme(resourceObjectInstance);
        gui_stress_2.setInlineAllStyles("bgType:image_scaled_fit; bgImage:2.png;");
        gui_stress_2.setName("stress_2");
        gui_stress_1.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_stress_1.setInlineStylesTheme(resourceObjectInstance);
        gui_stress_1.setInlineAllStyles("bgType:image_scaled_fit; bgImage:1.png;");
        gui_stress_1.setName("stress_1");
        gui_stressLabel.setText("Stress");
                gui_stressLabel.setInlineStylesTheme(resourceObjectInstance);
        gui_stressLabel.setInlineAllStyles("font:native:MainRegular native:MainRegular; alignment:center;");
        gui_stressLabel.setName("stressLabel");
        gui_stressNum.setText("0");
                gui_stressNum.setInlineStylesTheme(resourceObjectInstance);
        gui_stressNum.setInlineAllStyles("font:native:MainRegular native:MainRegular; alignment:center;");
        gui_stressNum.setName("stressNum");
        gui_slideGrid.addComponent(gui_overallBox);
        gui_overallBox.setPreferredSizeStr("48.67725mm 111.90476mm");
                gui_overallBox.setInlineStylesTheme(resourceObjectInstance);
        gui_overallBox.setName("overallBox");
        gui_overallBox.addComponent(gui_overall_10);
        gui_overallBox.addComponent(gui_overall_9);
        gui_overallBox.addComponent(gui_overall_8);
        gui_overallBox.addComponent(gui_overall_7);
        gui_overallBox.addComponent(gui_overall_6);
        gui_overallBox.addComponent(gui_overall_5);
        gui_overallBox.addComponent(gui_overall_4);
        gui_overallBox.addComponent(gui_overall_3);
        gui_overallBox.addComponent(gui_overall_2);
        gui_overallBox.addComponent(gui_overall_1);
        gui_overallBox.addComponent(gui_overallLabel);
        gui_overallBox.addComponent(gui_overallNum);
        gui_overall_10.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_overall_10.setInlineStylesTheme(resourceObjectInstance);
        gui_overall_10.setInlineAllStyles("bgType:image_scaled_fit; bgImage:10.png;");
        gui_overall_10.setName("overall_10");
        gui_overall_9.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_overall_9.setInlineStylesTheme(resourceObjectInstance);
        gui_overall_9.setInlineAllStyles("bgType:image_scaled_fit; bgImage:9.png;");
        gui_overall_9.setName("overall_9");
        gui_overall_8.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_overall_8.setInlineStylesTheme(resourceObjectInstance);
        gui_overall_8.setInlineAllStyles("bgType:image_scaled_fit; bgImage:8.png;");
        gui_overall_8.setName("overall_8");
        gui_overall_7.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_overall_7.setInlineStylesTheme(resourceObjectInstance);
        gui_overall_7.setInlineAllStyles("bgType:image_scaled_fit; bgImage:7.png;");
        gui_overall_7.setName("overall_7");
        gui_overall_6.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_overall_6.setInlineStylesTheme(resourceObjectInstance);
        gui_overall_6.setInlineAllStyles("bgType:image_scaled_fit; bgImage:6.png;");
        gui_overall_6.setName("overall_6");
        gui_overall_5.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_overall_5.setInlineStylesTheme(resourceObjectInstance);
        gui_overall_5.setInlineAllStyles("bgType:image_scaled_fit; bgImage:5.png;");
        gui_overall_5.setName("overall_5");
        gui_overall_4.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_overall_4.setInlineStylesTheme(resourceObjectInstance);
        gui_overall_4.setInlineAllStyles("bgType:image_scaled_fit; bgImage:4.png;");
        gui_overall_4.setName("overall_4");
        gui_overall_3.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_overall_3.setInlineStylesTheme(resourceObjectInstance);
        gui_overall_3.setInlineAllStyles("bgType:image_scaled_fit; bgImage:3.png;");
        gui_overall_3.setName("overall_3");
        gui_overall_2.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_overall_2.setInlineStylesTheme(resourceObjectInstance);
        gui_overall_2.setInlineAllStyles("bgType:image_scaled_fit; bgImage:2.png;");
        gui_overall_2.setName("overall_2");
        gui_overall_1.setPreferredSizeStr("7.936508mm 8.465609mm");
                gui_overall_1.setInlineStylesTheme(resourceObjectInstance);
        gui_overall_1.setInlineAllStyles("bgType:image_scaled_fit; bgImage:1.png;");
        gui_overall_1.setName("overall_1");
        gui_overallLabel.setText("Overall");
                gui_overallLabel.setInlineStylesTheme(resourceObjectInstance);
        gui_overallLabel.setInlineAllStyles("font:native:MainRegular native:MainRegular; alignment:center;");
        gui_overallLabel.setName("overallLabel");
        gui_overallNum.setText("0");
                gui_overallNum.setInlineStylesTheme(resourceObjectInstance);
        gui_overallNum.setInlineAllStyles("font:native:MainRegular native:MainRegular; alignment:center;");
        gui_overallNum.setName("overallNum");
        gui_anxietyBox.setPreferredSizeStr("48.67725mm 97.8836mm");
                gui_anxietyBox.setInlineStylesTheme(resourceObjectInstance);
        gui_anxietyBox.setName("anxietyBox");
        gui_confidenceBox.setPreferredSizeStr("48.67725mm 111.90476mm");
                gui_confidenceBox.setInlineStylesTheme(resourceObjectInstance);
        gui_confidenceBox.setName("confidenceBox");
        gui_stressBox.setPreferredSizeStr("48.67725mm 111.90476mm");
                gui_stressBox.setInlineStylesTheme(resourceObjectInstance);
        gui_stressBox.setName("stressBox");
        gui_overallBox.setPreferredSizeStr("48.67725mm 111.90476mm");
                gui_overallBox.setInlineStylesTheme(resourceObjectInstance);
        gui_overallBox.setName("overallBox");
        addComponent(gui_overallSlider);
        addComponent(gui_stressSlider);
        addComponent(gui_confidenceSlider);
        addComponent(gui_anxietySlider);
        gui_Button_1.setPreferredSizeStr("15.873016mm 12.1693125mm");
                gui_Button_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Button_1.setInlineAllStyles("bgType:image_scaled_fit; bgImage:backButton.png;");
        gui_Button_1.setInlinePressedStyles("bgType:image_scaled_fit; bgImage:backButtonPressed.png;");
        gui_Button_1.setName("Button_1");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Button_1.getParent().getLayout()).setInsets(gui_Button_1, "4.003797% auto 90.02962% 3.9473686%").setReferenceComponents(gui_Button_1, "-1 -1 -1 -1").setReferencePositions(gui_Button_1, "0.0 0.0 0.0 0.0");
        gui_moodLabel.setPreferredSizeStr("128.83598mm 29.100529mm");
                gui_moodLabel.setInlineStylesTheme(resourceObjectInstance);
        gui_moodLabel.setInlineAllStyles("bgType:image_scaled_fit; bgImage:moodLabel.png;");
        gui_moodLabel.setName("moodLabel");
        ((com.codename1.ui.layouts.LayeredLayout)gui_moodLabel.getParent().getLayout()).setInsets(gui_moodLabel, "1.3227522mm 16.45274% auto 3.4391534mm").setReferenceComponents(gui_moodLabel, "-1 -1 -1 0 ").setReferencePositions(gui_moodLabel, "0.0 0.0 0.0 1.0");
        gui_slideGrid.setPreferredSizeStr("213.75662mm 113.492065mm");
        gui_slideGrid.setScrollableY(false);
                gui_slideGrid.setInlineStylesTheme(resourceObjectInstance);
        gui_slideGrid.setName("slideGrid");
        ((com.codename1.ui.layouts.LayeredLayout)gui_slideGrid.getParent().getLayout()).setInsets(gui_slideGrid, "17.396593% -0.52910054mm auto 0.0mm").setReferenceComponents(gui_slideGrid, "-1 -1 -1 -1").setReferencePositions(gui_slideGrid, "0.0 0.0 0.0 0.0");
        gui_overallSlider.setPreferredSizeStr("11.904762mm 96.031746mm");
        gui_overallSlider.setEditable(true);
        gui_overallSlider.setFocusable(true);
        gui_overallSlider.setVertical(true);
        gui_overallSlider.setUIID("SliderFull");
                gui_overallSlider.setInlineStylesTheme(resourceObjectInstance);
        gui_overallSlider.setName("overallSlider");
        gui_overallSlider.setIncrements(1);
        gui_overallSlider.setProgress(1);
        ((com.codename1.ui.layouts.LayeredLayout)gui_overallSlider.getParent().getLayout()).setInsets(gui_overallSlider, "16.966806% 8.033015% auto auto").setReferenceComponents(gui_overallSlider, "-1 2 -1 -1").setReferencePositions(gui_overallSlider, "0.0 0.0 0.0 0.0");
        gui_stressSlider.setPreferredSizeStr("11.640212mm 96.296295mm");
        gui_stressSlider.setEditable(true);
        gui_stressSlider.setFocusable(true);
        gui_stressSlider.setVertical(true);
        gui_stressSlider.setUIID("SliderFull");
                gui_stressSlider.setInlineStylesTheme(resourceObjectInstance);
        gui_stressSlider.setName("stressSlider");
        gui_stressSlider.setIncrements(1);
        gui_stressSlider.setProgress(9);
        ((com.codename1.ui.layouts.LayeredLayout)gui_stressSlider.getParent().getLayout()).setInsets(gui_stressSlider, "17.121435% 16.191483% 25.776398% 68.76972%").setReferenceComponents(gui_stressSlider, "-1 3 -1 -1").setReferencePositions(gui_stressSlider, "0.0 1.0 0.0 0.0");
        gui_confidenceSlider.setPreferredSizeStr("14.285714mm 96.296295mm");
        gui_confidenceSlider.setEditable(true);
        gui_confidenceSlider.setFocusable(true);
        gui_confidenceSlider.setVertical(true);
        gui_confidenceSlider.setUIID("SliderFull");
                gui_confidenceSlider.setInlineStylesTheme(resourceObjectInstance);
        gui_confidenceSlider.setName("confidenceSlider");
        gui_confidenceSlider.setIncrements(1);
        gui_confidenceSlider.setProgress(9);
        ((com.codename1.ui.layouts.LayeredLayout)gui_confidenceSlider.getParent().getLayout()).setInsets(gui_confidenceSlider, "17.184776% 23.457268% auto auto").setReferenceComponents(gui_confidenceSlider, "-1 4 -1 -1").setReferencePositions(gui_confidenceSlider, "0.0 1.0 0.0 0.0");
        gui_anxietySlider.setPreferredSizeStr("11.111112mm 97.3545mm");
        gui_anxietySlider.setEditable(true);
        gui_anxietySlider.setFocusable(true);
        gui_anxietySlider.setVertical(true);
        gui_anxietySlider.setUIID("SliderFull");
                gui_anxietySlider.setInlineStylesTheme(resourceObjectInstance);
        gui_anxietySlider.setName("anxietySlider");
        gui_anxietySlider.setIncrements(1);
        gui_anxietySlider.setProgress(1);
        ((com.codename1.ui.layouts.LayeredLayout)gui_anxietySlider.getParent().getLayout()).setInsets(gui_anxietySlider, "16.770185% 43.08943% auto 6.349207mm").setReferenceComponents(gui_anxietySlider, "-1 5 -1 2 ").setReferencePositions(gui_anxietySlider, "0.0 1.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
