package tracker.GuiComponents;

import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.util.Resources;

public class SideMenu {

    private Resources _Theme;
    private Toolbar _PageTb;
    private boolean _IsInit;

    public SideMenu(final Resources theme, final Toolbar tb) {
        _Theme = theme;
        _PageTb = tb;
        _IsInit = false;

        initialize();
    }

    private void initialize() {
        Image sampleIcon = _Theme.getImage("icon.png");
        Container topBar = BorderLayout.east(new Label(sampleIcon));

        topBar.add(BorderLayout.SOUTH, new Label("Menu", "SideMenuTagline"));
        topBar.setUIID("SideCommand");
        _PageTb.addComponentToSideMenu(topBar);

        _PageTb.addMaterialCommandToSideMenu(
                "Tracking", FontImage.MATERIAL_QUESTION_ANSWER, e -> { });
        _PageTb.addMaterialCommandToSideMenu(
                "Settings", FontImage.MATERIAL_SETTINGS, e -> { });
        _PageTb.addMaterialCommandToSideMenu(
                "Profile", FontImage.MATERIAL_VERIFIED_USER, e -> { });
        _PageTb.addMaterialCommandToSideMenu(
                "About", FontImage.MATERIAL_INFO, e -> { });

        _IsInit = true;
    }

}
