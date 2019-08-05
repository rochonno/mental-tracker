package tracker.GuiComponents;

import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.util.Resources;
import tracker.Data.InstanceData;
import tracker.Pages.ModularGUI.GraphSelectionPage;
import tracker.Pages.ModularGUI.NotificationPage;
import tracker.Pages.ModularGUI.PromptListPage;

/******************************************************************************
 * @author Nolan Rochon
 *
 * Adds a sidemenu to the current page.
 ******************************************************************************/
public class SideMenu {

    /** Theme to be used when creating the sidemenu. */
    private Resources _Theme;
    /** Toolbar of the page that the sidemenu is being created for. */
    private Toolbar _PageTb;
    /** If the sidemenu is added and initialized. */
    private boolean _IsInit;

    private InstanceData _Data;

    private final String MAIN_PAGE = "Home";
    private final String PROMTPS_LIST = "Questions Page";
    private final String REMINDERS = "Reminders";
    private final String GRAPHS = "Graphs";

    public SideMenu(final Resources theme,
                    final Toolbar tb,
                    InstanceData data) {
        _Theme = theme;
        _PageTb = tb;
        _Data = data;
        _IsInit = false;

        initialize();
    }

    private void initialize() {
        //Image sampleIcon = _Theme.getImage(ImageNames.LOGO);
        Container topBar = BorderLayout.east(new Label());

        SideMenuActionListener callback = new SideMenuActionListener();

        topBar.add(BorderLayout.SOUTH, new Label("Menu", "SideMenuTagline"));
        topBar.setUIID("SideCommand");
        _PageTb.addComponentToSideMenu(topBar);

        _PageTb.addMaterialCommandToSideMenu(
                MAIN_PAGE, FontImage.MATERIAL_HOME, callback);
        _PageTb.addMaterialCommandToSideMenu(
                PROMTPS_LIST, FontImage.MATERIAL_QUESTION_ANSWER, callback);
        _PageTb.addMaterialCommandToSideMenu(
                REMINDERS, FontImage.MATERIAL_NOTIFICATIONS, callback);
        _PageTb.addMaterialCommandToSideMenu(
                GRAPHS, FontImage.MATERIAL_TRENDING_UP, callback);

        _IsInit = true;
    }

    private void onMainPageSelected() {

    }

    private void onPromptsListSelected() {
        PromptListPage promptList = new PromptListPage(_Data, _PageTb.getComponentForm());
        promptList.show();
    }

    private void onRemindersSelected() {
        Form notificationPage = new NotificationPage(_Data, _PageTb.getComponentForm());
        notificationPage.show();
    }

    private void onGraphsSelected() {
        Form graphingPage = new GraphSelectionPage(_Data, _PageTb.getComponentForm());
        graphingPage.show();
    }

    class SideMenuActionListener implements ActionListener {

        /**
         * Invoked when an action occurred on a component.
         *
         * @param evt event object describing the source of the action as well
         *            as its trigger
         */
        @Override
        public void actionPerformed(ActionEvent evt) {
            String sourceName = evt.getSource().toString();

            if (sourceName.equals(MAIN_PAGE)) {
                onMainPageSelected();
            } else if (sourceName.equals(PROMTPS_LIST)) {
                onPromptsListSelected();
            } else if (sourceName.equals(REMINDERS)) {
                onRemindersSelected();
            } else if (sourceName.equals(GRAPHS)) {
                onGraphsSelected();
            }
        }
    }

}
