package tracker.ModularGUI;

import com.codename1.ui.events.ActionListener;
import tracker.Data.InstanceData;
import tracker.Data.Prompts.GenerateDefaultPrompts;
import tracker.Data.Prompts.PromptResults;
import tracker.GuiComponents.ImageNames;
import tracker.GuiComponents.Individual.GuiButton;
import tracker.GuiComponents.Individual.GuiImageViewer;
import tracker.GuiComponents.Individual.GuiLabel;
import tracker.GuiComponents.SideMenu;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import static com.codename1.ui.util.Resources.getGlobalResources;

/******************************************************************************
 * Main page (home) of the GUI. Displayed upon start-up.
 *
 * @author Nolan Rochon
 ******************************************************************************/
public class MainPage extends Form {

    /** The side menu of the page. */
    private SideMenu _SideMenu;
    /** The current resource instance. */
    private Resources _InstanceResources;
    /** The instance data. */
    private InstanceData _Data;

    public MainPage(final InstanceData data) {
        _Data = data;
        _InstanceResources = getGlobalResources();

        initializeData();
        setSidePanel();
        initializeLayout();
        initializeComponents();
        createComponents();
    }

    private void initializeLayout() {
        setLayout(new LayeredLayout());
        setInlineStylesTheme(_InstanceResources);
        setScrollableY(false);
        setInlineStylesTheme(_InstanceResources);
        setInlineAllStyles("bgColor:efefef;");
        setTitle("Mental Tracker");
        setName("MainPage");
    }

    /** Top inset on the page used for spacing. */
    private GuiLabel _TopInset;
    /** Title of the page. */
    private GuiLabel _PageTitle;
    /** Logo of the app. */
    private GuiImageViewer _TrackerLogo;
    /** Button to start the survey. */
    private GuiButton _StartButton;

    /**
     * Initialize all the Gui components.
     */
    private void initializeComponents() {
        _TopInset = new GuiLabel("TopInset", _InstanceResources);
        _PageTitle = new GuiLabel("PageTitle", _InstanceResources);
        _PageTitle.setText("Home");
        _TrackerLogo =
                new GuiImageViewer("Logo", _InstanceResources, ImageNames.LOGO);

        if (_Data.getHasAnswered()) {
            return;
        }
        _StartButton = new GuiButton(
                "StartButton",
                _InstanceResources,
                ImageNames.CONTINUE_UNSELECT,
                ImageNames.CONTINUE_SELECT
        );
        _StartButton.setActionListener(new MainEventCallback());
    }

    /**
     * Create all Gui components.
     */
    private void createComponents() {
        createTopInset();
        createPageTitle();
        createTackerLogo();
        createStartButton();
    }

    private void createTopInset() {
        addComponent(_TopInset.getLabel());
        _TopInset.setSizeStr("inherit 4.2328043mm");

        ((LayeredLayout) _TopInset.getLabel().getParent().getLayout()).
                setInsets(_TopInset.getLabel(), "1.6mm 5.0mm auto 5.0mm").
                setReferenceComponents(_TopInset.getLabel(), "-1 -1 -1 -1").
                setReferencePositions(_TopInset.getLabel(), "0.0 0.0 0.0 0.0");
    }

    private void createPageTitle() {
        addComponent(_PageTitle.getLabel());
        _PageTitle.getLabel().setAutoSizeMode(true);
        if (!_Data.getHasAnswered()) {
            _PageTitle.setText("How are you feeling today?");
        } else {
            _PageTitle.setText("Keep up the good work!");
        }

        ((LayeredLayout) _PageTitle.getLabel().getParent().getLayout()).
                setInsets(_PageTitle.getLabel(), "0 auto auto auto").
                setReferenceComponentTop(_PageTitle.getLabel(),
                        _TopInset.getLabel(), 5f);
    }

    private void createTackerLogo() {
        addComponent(_TrackerLogo.getImageViewer());

        ((LayeredLayout) _TrackerLogo.getImageViewer().
                getParent().getLayout()).
                setInsets(_TrackerLogo.getImageViewer(), "0 auto auto auto").
                setReferenceComponentTop(_TrackerLogo.getImageViewer(),
                        _TopInset.getLabel(), 10f);
    }

    private void createStartButton() {
        if (_StartButton == null) {
            return;
        }

        _StartButton.setSizeStr("116.93122mm 23.544973mm");
        addComponent(_StartButton.getButton());

        ((LayeredLayout) _StartButton.getButton().
                getParent().getLayout()).setInsets(
                _StartButton.getButton(), "auto -125% 0 auto");
    }

    /**
     * Called when the start button is pressed.
     */
    private void onStartQuestionsEvent() {
        // new questions page
        MultiPromptsPage prompt = new MultiPromptsPage(_Data, this, 0);
        prompt.show();
    }

    /**
     * Event callback class for the start button on the main page.
     */
    class MainEventCallback implements ActionListener {
        MainEventCallback() {
        }

        public void actionPerformed(final ActionEvent ev) {
            String sourceName = ev.getComponent().getName();

            if (sourceName.equals(_StartButton.getName())) {
                onStartQuestionsEvent();
            }

        }
    }

    /**'
     * Components should be initialized here.
     */
    private void initializeData() {
        /*
        try {
            _Prompts.loadPrompts(null);
        } catch (ReadFileException e) {
            Log.e(e.getCause());
        }*/

        if (_Data.getInstancePrompts() == null) {
            _Data.setInstancePrompts(
                    GenerateDefaultPrompts.defaultMorningOnlyPrompts());
        }
        if (_Data.getInstanceResults() == null) {
            _Data.setInstanceResults(new PromptResults());
        }
    }

    /**
     * Creates the side panel for the Main Page.
     */
    private void setSidePanel() {
        _SideMenu = new SideMenu(
                UIManager.initFirstTheme("/theme"),
                this.getToolbar(),
                _Data
                );
    }
}
