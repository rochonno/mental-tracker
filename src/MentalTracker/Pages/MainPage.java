package MentalTracker.Pages;

import MentalTracker.Components.SideMenu;
import MentalTracker.CustomizeQuestions;
import MentalTracker.DataPortions.Prompts.*;
import com.codename1.ui.Form;
import com.codename1.ui.util.Resources;



   //STRICTLY FOR TESTING PURPOSES. DELETE LATER
import MentalTracker.DailySurveyPgTwoGUI;
import MentalTracker.LoginGUI;
import MentalTracker.DailySurveyPgOneGUI;
/***
 * This class is for the main page of the application.
 * Automatically displayed upon start-up.
 */
public class MainPage {

    private Form _Page;
    private SideMenu _SideMenu;
    private Resources _Theme;

    public MainPage(Resources theme)
    {
        _Theme = theme;

        //_Page = new DailySurveyPgTwoGUI();
        //_Page = new NeedDailyGUI();
        //_Page = new DailySurveyPgOneGUI();
        //_Page = new DailySurveyPgTwoGUI();
        //_Page = new LoginGUI();
        MentalPrompt samplePrompt = new MentalPrompt( "Exercise", "Have you exercised in the past day?", PromptDataType.BOOL);
        MentalPrompts samplePrompts = GenerateDefaultPrompts.DefaultMorningOnlyPrompts();
        PromptResults results = new PromptResults();
        _Page = new UserPromptPage(samplePrompts, results, null);
        //_Page = new CustomizeQuestions();

        //_Page = new Form("MainPage");

        //_Page.addComponent(new Label("Main Page"));
        initialize();
    }

    /**'
     * Components should be initialized here.
     */
    private void initialize()
    {
        _SideMenu = new SideMenu(_Theme, _Page.getToolbar());
    }

    public void Show()
    {
        _Page.show();
    }
}
