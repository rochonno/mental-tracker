package tracker.Pages.ModularGUI;

import com.codename1.ui.events.ActionListener;
import tracker.GuiComponents.SideMenu;
import tracker.Data.Prompts.*;
import tracker.ComponentGenerators.MainPageComponents;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import tracker.Pages.LoginGUI;


//STRICTLY FOR TESTING PURPOSES. DELETE LATER

import static com.codename1.ui.util.Resources.getGlobalResources;

/******************************************************************************
 * @author Nolan Rochon
 *
 * Main page (home) of the GUI. Displayed upon start-up.
 ******************************************************************************/
public class MainPage extends Form {

    private Form _Page;
    private SideMenu _SideMenu;
    private MainPageComponents _Components;

    private MentalPrompts _Prompts;
    private PromptResults _Results;
    private boolean DoneSurvey;

    public MainPage(final boolean hasAnswered) {
        //runOtherPages();
        this(getGlobalResources(), hasAnswered);
    }

    MainPage(final Resources resourcesObjectInstance,
                    final boolean hasAnswered) {
        DoneSurvey = hasAnswered;
        initialize();
        _Components = new MainPageComponents();
        initGuiBuilderComponents(resourcesObjectInstance);
    }

    private void runOtherPages() {

        //_Page = new DailySurveyPgTwoGUI();
        //_Page = new NeedDailyGUI();
        //_Page = new DailySurveyPgOneGUI();
        //_Page = new DailySurveyPgTwoGUI();
        _Page = new LoginGUI();

        /*MentalPrompt samplePrompt = new MentalPrompt("Exercise",
                "Have you exercised in the past day?", PromptDataType.BOOL);
        */

        MentalPrompts samplePrompts =
                GenerateDefaultPrompts.defaultMorningOnlyPrompts();
        //_Page = new UserPromptPage(samplePrompts, results, null);

        _Page = new CreateCustomPromptPage(this, samplePrompts);
        //_Page = new CustomizeQuestions();

        //_Page = new Form("MainPage");

        //_Page.addComponent(new Label("Main Page"));
    }

    private void onStartQuestionsEvent(final ActionEvent ev) {
        Form prompts = new UserPromptPage(_Prompts, _Results, this);
        prompts.show();
    }


    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();

        _Components.StartQuestions.addActionListener(callback);
    }

    class EventCallbackClass implements ActionListener,
            com.codename1.ui.events.DataChangedListener {

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
            if (sourceComponent == _Components.StartQuestions) {
                onStartQuestionsEvent(ev);
            }

        }

        public void dataChanged(final int type, final int index) {
        }
    }

    private void initGuiBuilderComponents(final Resources resourceInstance) {

        guiBuilderBindComponentListeners();
        setLayout(new LayeredLayout());
        setInlineStylesTheme(resourceInstance);
        setScrollableY(false);
        setInlineStylesTheme(resourceInstance);
        setInlineAllStyles("bgColor:efefef;");
        setTitle("Mental Tracker");
        setName("MainPage");

        addComponent(_Components.TopInset);
        _Components.TopInset.setPreferredSizeStr("inherit 4.2328043mm");
        _Components.TopInset.setInlineStylesTheme(resourceInstance);
        _Components.TopInset.setName("topInset");
        ((LayeredLayout) _Components.TopInset.getParent().getLayout()).
                setInsets(_Components.TopInset, "1.6mm 5.0mm auto 5.0mm").
                setReferenceComponents(_Components.TopInset, "-1 -1 -1 -1").
                setReferencePositions(_Components.TopInset, "0.0 0.0 0.0 0.0");

        if (_Components.MentalTrackLogo != null) {
            addComponent(_Components.MentalTrackLogo);
            _Components.MentalTrackLogo.setImage(
                    resourceInstance.getImage("Logo.png"));
            _Components.MentalTrackLogo.setName("MentalTrackLogo");
            ((LayeredLayout) _Components.MentalTrackLogo.
                    getParent().getLayout()).
                    setInsets(_Components.MentalTrackLogo, "0 auto auto auto").
                    setReferenceComponentTop(_Components.MentalTrackLogo,
                            _Components.TopInset, 10f);

        }

        if (!DoneSurvey) {
            addComponent(_Components.StartQuestions);
            _Components.StartQuestions.setPreferredSizeStr(
                    "116.93122mm 23.544973mm");
            _Components.StartQuestions.setInlineStylesTheme(resourceInstance);
            _Components.StartQuestions.setName("confirmButton");
            _Components.StartQuestions.setIcon(
                    resourceInstance.getImage("continueButton.png"));
            _Components.StartQuestions.setPressedIcon(
                    resourceInstance.getImage("continuePress.png"));
            ((LayeredLayout) _Components.StartQuestions.
                    getParent().getLayout()).
                    setInsets(_Components.StartQuestions, "auto -125% 0 auto");
        }


        addComponent(_Components.PromptTitle);
        _Components.PromptTitle.setName("Prompt");
        _Components.PromptTitle.setAutoSizeMode(true);
        if (!DoneSurvey) {
            _Components.PromptTitle.setText("Daily Tracking Is Ready!");
        } else {
            _Components.PromptTitle.setText("Keep Up the Good Work!");
        }
        ((LayeredLayout) _Components.PromptTitle.getParent().getLayout()).
                setInsets(_Components.PromptTitle, "0 auto auto auto").
                setReferenceComponentTop(_Components.PromptTitle,
                        _Components.TopInset, 5f);

    }

    /**'
     * Components should be initialized here.
     */
    private void initialize() {
        /*
        try {
            _Prompts.loadPrompts(null);
        } catch (ReadFileException e) {
            Log.e(e.getCause());
        }*/

        if (_Prompts == null) {
            _Prompts = GenerateDefaultPrompts.defaultMorningOnlyPrompts();
        }
        if (_Results == null) {
            _Results = new PromptResults();
        }
    }

    public void setSidePanel() {
        _SideMenu = new SideMenu(
                UIManager.initFirstTheme("/theme"), this.getToolbar());
    }
}