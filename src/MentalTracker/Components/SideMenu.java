package MentalTracker.Components;

import MentalTracker.Pages.CreateCustomPromptPage;
import MentalTracker.Pages.MainPage;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.util.Resources;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SideMenu {

    private Resources _Theme;
    private Toolbar _PageTb;
    private Form _Page;
    private boolean _IsInit;

    public SideMenu(Resources theme, Form form)
    {
        _Page = form;
        _Theme = theme;
        _PageTb = _Page.getToolbar();
        _IsInit = false;

        Initialize();
    }



    private void Initialize()
    {
        Image sampleIcon = _Theme.getImage("icon.png");
        Container topBar = BorderLayout.east(new Label(sampleIcon));

        topBar.add(BorderLayout.SOUTH, new Label("Menu", "SideMenuTagline"));
        topBar.setUIID("SideCommand");
        _PageTb.addComponentToSideMenu(topBar);

        _PageTb.addMaterialCommandToSideMenu("MainMenu", FontImage.MATERIAL_QUESTION_ANSWER, e -> {});
        _PageTb.addMaterialCommandToSideMenu("AddPrompt", FontImage.MATERIAL_SETTINGS, e -> {});
        _PageTb.addMaterialCommandToSideMenu("Notification", FontImage.MATERIAL_VERIFIED_USER, e -> {});
        _PageTb.addMaterialCommandToSideMenu("About", FontImage.MATERIAL_INFO, e -> {});

        _IsInit = true;
    }


    private void goToMainMenu()
    {
        MainPage main = new MainPage(true);
        main.setSidePanel();
        main.show();
    }

    private void goToAddPrompt()
    {
        //CreateCustomPromptPage main = new CreateCustomPromptPage();
        //main.setSidePanel();
        //main.show();
    }
}
