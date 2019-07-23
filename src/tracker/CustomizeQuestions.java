package tracker;

import com.codename1.ui.events.ActionEvent;

import java.util.ArrayList;

public class CustomizeQuestions extends com.codename1.ui.Form {
    private ArrayList<com.codename1.ui.TextArea> questions = new ArrayList<com.codename1.ui.TextArea>();

    public CustomizeQuestions() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public CustomizeQuestions(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

    public void onminusButtonActionEvent(ActionEvent ev) {
        questions.remove(questions.get(questions.size() - 1));
        gui_Box_Layout_Y.removeComponent(this.getComponentAt(0, this.getComponentCount() + 1));
        repaint();

    }

    public void onplusButtonActionEvent(ActionEvent ev) {
        questions.add(new com.codename1.ui.TextArea());
        gui_Box_Layout_Y.add(questions.get(questions.size() - 1));
        repaint();
    }



//-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Button gui_plusButton = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_minusButton = new com.codename1.ui.Button();
    protected com.codename1.ui.Container gui_Box_Layout_Y = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.TextArea gui_Text_Area_4 = new com.codename1.ui.TextArea();
    protected com.codename1.ui.TextField gui_TextField = new com.codename1.ui.TextField();
    protected com.codename1.ui.TextArea gui_Text_Area_2 = new com.codename1.ui.TextArea();
    protected com.codename1.ui.TextArea gui_Text_Area = new com.codename1.ui.TextArea();
    protected com.codename1.ui.TextArea gui_Text_Area_1 = new com.codename1.ui.TextArea();
    protected com.codename1.ui.TextArea gui_Text_Area_3 = new com.codename1.ui.TextArea();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_plusButton.addActionListener(callback);
        gui_minusButton.addActionListener(callback);
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

            if(sourceComponent == gui_plusButton) {
                onplusButtonActionEvent(ev);
            }
            if(sourceComponent == gui_minusButton) {
                onminusButtonActionEvent(ev);
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
        setTitle("CustomizeQuestions");
        setName("CustomizeQuestions");
        gui_Label.setText("Personalized Questions:");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("fgColor:0; alignment:center;");
        gui_Label.setName("Label");
        gui_plusButton.setPreferredSizeStr("20.899471mm 13.4920635mm");
        gui_plusButton.setText("+");
                gui_plusButton.setInlineStylesTheme(resourceObjectInstance);
        gui_plusButton.setName("plusButton");
        gui_minusButton.setPreferredSizeStr("19.31217mm 13.4920635mm");
        gui_minusButton.setText("-");
                gui_minusButton.setInlineStylesTheme(resourceObjectInstance);
        gui_minusButton.setName("minusButton");
        gui_Box_Layout_Y.setPreferredSizeStr("168.25397mm 132.80423mm");
        gui_Box_Layout_Y.setScrollableX(false);
        gui_Box_Layout_Y.setScrollableY(false);
                gui_Box_Layout_Y.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y.setName("Box_Layout_Y");
        addComponent(gui_Label);
        addComponent(gui_plusButton);
        addComponent(gui_minusButton);
        addComponent(gui_Box_Layout_Y);
        gui_Text_Area_4.setText("TextArea");
                gui_Text_Area_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Text_Area_4.setName("Text_Area_4");
        gui_Text_Area_4.setColumns(8);
        gui_TextField.setText("TextArea");
                gui_TextField.setInlineStylesTheme(resourceObjectInstance);
        gui_TextField.setName("TextField");
        gui_TextField.setColumns(20);
        gui_TextField.setRows(1);
        gui_Text_Area_2.setText("TextArea");
                gui_Text_Area_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Text_Area_2.setName("Text_Area_2");
        gui_Text_Area_2.setColumns(8);
        gui_Text_Area.setText("TextArea");
                gui_Text_Area.setInlineStylesTheme(resourceObjectInstance);
        gui_Text_Area.setName("Text_Area");
        gui_Text_Area.setColumns(8);
        gui_Text_Area_1.setText("TextArea");
                gui_Text_Area_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Text_Area_1.setName("Text_Area_1");
        gui_Text_Area_1.setColumns(8);
        gui_Text_Area_3.setText("TextArea");
                gui_Text_Area_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Text_Area_3.setName("Text_Area_3");
        gui_Text_Area_3.setColumns(8);
        gui_Box_Layout_Y.addComponent(gui_Text_Area_4);
        gui_Box_Layout_Y.addComponent(gui_TextField);
        gui_Box_Layout_Y.addComponent(gui_Text_Area_2);
        gui_Box_Layout_Y.addComponent(gui_Text_Area);
        gui_Box_Layout_Y.addComponent(gui_Text_Area_1);
        gui_Box_Layout_Y.addComponent(gui_Text_Area_3);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "8.143323% auto auto 12.406577%").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_plusButton.getParent().getLayout()).setInsets(gui_plusButton, "0.0mm 30.941704% 0.0mm auto").setReferenceComponents(gui_plusButton, "0 -1 2 -1").setReferencePositions(gui_plusButton, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_minusButton.getParent().getLayout()).setInsets(gui_minusButton, "0.0mm 14.05082% auto auto").setReferenceComponents(gui_minusButton, "0 -1 -1 -1").setReferencePositions(gui_minusButton, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_Y.getParent().getLayout()).setInsets(gui_Box_Layout_Y, "2.6455002mm 5.8201065mm 5.291008mm 2.9100533mm").setReferenceComponents(gui_Box_Layout_Y, "0 -1 -1 -1").setReferencePositions(gui_Box_Layout_Y, "1.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
