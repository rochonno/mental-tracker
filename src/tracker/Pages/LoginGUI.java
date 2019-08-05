package tracker.Pages;

import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import tracker.Pages.NeedDailyGUI;

public class LoginGUI extends com.codename1.ui.Form {

    private Form _Page;

    public LoginGUI() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public LoginGUI(final com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

    public void onScaled_ButtonActionEvent(ActionEvent ev) {
    }

    public void onButtonActionEvent(final ActionEvent ev) {

        //Needs Validation that a correct account was input. **************************
        if (gui_UserPass.getText() != "" && gui_UserLogin.getText() != "") {
            _Page = new NeedDailyGUI();
            _Page.show();
        } else {
            Dialog.show("Error!", "Make sure you entered a Username and Password.", "Okay", null);
        }
    }

    //-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Label gui_TopInset = new com.codename1.ui.Label();
    protected com.codename1.components.ScaleImageLabel gui_Scaled_Label = new com.codename1.components.ScaleImageLabel();
    protected com.codename1.ui.TextField gui_UserLogin = new com.codename1.ui.TextField();
    protected com.codename1.ui.TextField gui_UserPass = new com.codename1.ui.TextField();
    protected com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_Button = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Button.addActionListener(callback);
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

            if(sourceComponent == gui_Button) {
                onButtonActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableX(false);
        setScrollableY(false);
                setInlineStylesTheme(resourceObjectInstance);
        setInlineAllStyles("border:roundRect stroke(3.0mm fc083b66) -top-left -top-right -bottom-left -bottom-right 2.0mm; bgColor:efefef;");
        setTitle("tracker.Pages.LoginGUI");
        setName("tracker.Pages.LoginGUI");
        addComponent(gui_TopInset);
        addComponent(gui_Scaled_Label);
        addComponent(gui_UserLogin);
        addComponent(gui_UserPass);
        addComponent(gui_Button_1);
        addComponent(gui_Button_2);
        addComponent(gui_Button);
        gui_TopInset.setPreferredSizeStr("inherit 7.936508mm");
                gui_TopInset.setInlineStylesTheme(resourceObjectInstance);
        gui_TopInset.setName("TopInset");
        ((com.codename1.ui.layouts.LayeredLayout)gui_TopInset.getParent().getLayout()).setInsets(gui_TopInset, "1.6mm 5.0mm auto 5.0mm").setReferenceComponents(gui_TopInset, "-1 -1 -1 -1").setReferencePositions(gui_TopInset, "0.0 0.0 0.0 0.0");
        gui_Scaled_Label.setPreferredSizeStr("52.1164mm 30.68783mm");
                gui_Scaled_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Scaled_Label.setInlineAllStyles("bgType:image_scaled_fit; bgImage:Logo.png;");
        gui_Scaled_Label.setName("Scaled_Label");
        gui_Scaled_Label.setBackgroundType((byte)34);
        gui_Scaled_Label.setIcon(resourceObjectInstance.getImage("Logo.png"));
        ((com.codename1.ui.layouts.LayeredLayout)gui_Scaled_Label.getParent().getLayout()).setInsets(gui_Scaled_Label, "5.497241% 19.866919% auto 19.73711%").setReferenceComponents(gui_Scaled_Label, "0 0 -1 0 ").setReferencePositions(gui_Scaled_Label, "1.0 0.0 0.0 0.0");
        gui_UserLogin.setPreferredSizeStr("85.44974mm 9.259259mm");
        gui_UserLogin.setHint("Username");
                gui_UserLogin.setInlineStylesTheme(resourceObjectInstance);
        gui_UserLogin.setName("UserLogin");
        gui_UserLogin.setHintIcon(com.codename1.ui.FontImage.createMaterial("\ue7fd".charAt(0), gui_UserLogin.getUnselectedStyle()));
        ((com.codename1.ui.layouts.LayeredLayout)gui_UserLogin.getParent().getLayout()).setInsets(gui_UserLogin, "10.835914% 2.9802322E-7mm auto 2.9802322E-7mm").setReferenceComponents(gui_UserLogin, "1 0 -1 0 ").setReferencePositions(gui_UserLogin, "1.0 0.0 0.0 0.0");
        gui_UserPass.setPreferredSizeStr("126.455025mm 8.465609mm");
        gui_UserPass.setHint("Password");
                gui_UserPass.setInlineStylesTheme(resourceObjectInstance);
        gui_UserPass.setName("UserPass");
        gui_UserPass.setRows(1);
        gui_UserPass.setHintIcon(com.codename1.ui.FontImage.createMaterial("\ue897".charAt(0), gui_UserPass.getUnselectedStyle()));
        ((com.codename1.ui.layouts.LayeredLayout)gui_UserPass.getParent().getLayout()).setInsets(gui_UserPass, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_UserPass, "2 0 -1 0 ").setReferencePositions(gui_UserPass, "1.0 0.0 0.0 0.0");
        gui_Button_1.setPreferredSizeStr("78.57143mm 8.994709mm");
        gui_Button_1.setText("Create Account");
                gui_Button_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Button_1.setInlineAllStyles("alignment:center;");
        gui_Button_1.setName("Button_1");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Button_1.getParent().getLayout()).setInsets(gui_Button_1, "2.116402mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Button_1, "6 0 -1 0 ").setReferencePositions(gui_Button_1, "1.0 0.0 0.0 0.0");
        gui_Button_2.setPreferredSizeStr("114.81482mm 9.523809mm");
        gui_Button_2.setText("Forgot Password?");
                gui_Button_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Button_2.setInlineAllStyles("alignment:center;");
        gui_Button_2.setName("Button_2");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Button_2.getParent().getLayout()).setInsets(gui_Button_2, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Button_2, "4 0 -1 0 ").setReferencePositions(gui_Button_2, "1.0 0.0 0.0 0.0");
        gui_Button.setPreferredSizeStr("28.571428mm 10.8465605mm");
                gui_Button.setInlineStylesTheme(resourceObjectInstance);
        gui_Button.setInlineAllStyles("bgColor:efefef; bgType:image_scaled; bgImage:signInButton - Copy.png;");
        gui_Button.setInlineSelectedStyles("bgType:image_scaled; bgImage:signInPressed1.png;");
        gui_Button.setInlinePressedStyles("bgType:image_scaled; bgImage:signInPressed1 - Copy.png;");
        gui_Button.setName("Button");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Button.getParent().getLayout()).setInsets(gui_Button, "2.910053mm auto auto auto").setReferenceComponents(gui_Button, "3 0 -1 0 ").setReferencePositions(gui_Button, "1.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
