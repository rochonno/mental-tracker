package tracker;

import static com.codename1.ui.CN.*;

import com.codename1.notifications.LocalNotificationCallback;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.ui.Toolbar;
import tracker.Data.InstanceData;
import tracker.Pages.ModularGUI.MainPage;

/**
 * This file was generated by
 * <a href="https://www.codenameone.com/">Codename One</a>
 * for the purpose of building native mobile applications using Java.
 */
public class CoreApp implements LocalNotificationCallback {

    private Form current;
    private InstanceData _Data;

    public void init(final Object context) {
        // use two network threads instead of one
        updateNetworkThreadCount(2);
        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        UIManager.initFirstTheme("/theme");

    }
    
    public void start() {

        if (current != null) {
            current.show();
            return;
        }

        if (_Data == null) {
            _Data = new InstanceData();
        }

        //LoginGUI login = new LoginGUI();
        //login.show();

        MainPage main = new MainPage(_Data);
        main.show();

    }

    public void stop() {
        current = getCurrentForm();
        if (current instanceof Dialog) {
            ((Dialog) current).dispose();
            current = getCurrentForm();
        }
    }
    
    public void destroy() {
    }

    @Override
    public void localNotificationReceived(final String notificationId) {

        //Testing purposes
        System.out.println("Recieved local notification" + notificationId);

    }
}
