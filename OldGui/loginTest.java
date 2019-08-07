package tracker.Pages;

import com.codename1.testing.AbstractTest;

import com.codename1.ui.Display;

public class loginTest extends AbstractTest {
    public boolean runTest() throws Exception {
        waitForFormName("tracker.Pages.LoginGUI");
        assertTextArea("UserLogin", "");
        assertTextArea("UserPass", "");
        setText("UserLogin", "okay");
        waitFor(2000);
        gameKeyPress(Display.GAME_FIRE);
        assertTextArea("UserLogin", "okay");
        assertTextArea("UserPass", "");
        clickButtonByName("Button");
        waitForFormTitle("Error!");
        waitForFormName("tracker.Pages.LoginGUI");
        setText("UserPass", "okay");
        assertTextArea("UserLogin", "okay");
        assertTextArea("UserPass", "okay");
        clickButtonByName("Button");
        waitForFormName("NeedDailyGUI");
        assertTitle("NeedDailyGUI");
        return true;
    }
}
