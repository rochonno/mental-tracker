package MentalTracker;

import MentalTracker.Pages.MainPage;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;

public class NeedDailyGUI extends com.codename1.ui.Form {
    private Form _Page;

    public NeedDailyGUI() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public NeedDailyGUI(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

    public void onTakeSurveyActionEvent(ActionEvent ev) {
        _Page = new DailySurveyPgOneGUI();
        _Page.show();
    }


//-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_TopInset = new com.codename1.ui.Label();
    protected com.codename1.ui.Button gui_TakeSurvey = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(false);
                setInlineStylesTheme(resourceObjectInstance);
        setInlineAllStyles("bgColor:efefef;");
        setTitle("NeedDailyGUI");
        setName("NeedDailyGUI");
        addComponent(gui_Label);
        addComponent(gui_TopInset);
        addComponent(gui_TakeSurvey);
        gui_Label.setPreferredSizeStr("179.10052mm inherit");
        gui_Label.setText("You still need to take today's survey!");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("fgColor:0; transparency:0; opacity:255; alignment:center;");
        gui_Label.setName("Label");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "5.47504% 0.0mm auto 0.0mm").setReferenceComponents(gui_Label, "1 1 -1 1 ").setReferencePositions(gui_Label, "1.0 0.0 0.0 0.0");
        gui_TopInset.setPreferredSizeStr("91.53439mm 8.994709mm");
                gui_TopInset.setInlineStylesTheme(resourceObjectInstance);
        gui_TopInset.setName("TopInset");
        ((com.codename1.ui.layouts.LayeredLayout)gui_TopInset.getParent().getLayout()).setInsets(gui_TopInset, "1.6mm 5.0mm auto 5.0mm").setReferenceComponents(gui_TopInset, "-1 -1 -1 -1").setReferencePositions(gui_TopInset, "0.0 0.0 0.0 0.0");
        gui_TakeSurvey.setPreferredSizeStr("194.709mm 24.338625mm");
        gui_TakeSurvey.setText("Take Today's Survey!");
                gui_TakeSurvey.setInlineStylesTheme(resourceObjectInstance);
        gui_TakeSurvey.setName("TakeSurvey");
        ((com.codename1.ui.layouts.LayeredLayout)gui_TakeSurvey.getParent().getLayout()).setInsets(gui_TakeSurvey, "29.36937% 0.0mm 53.333332% 0.0mm").setReferenceComponents(gui_TakeSurvey, "0 1 -1 1 ").setReferencePositions(gui_TakeSurvey, "1.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
