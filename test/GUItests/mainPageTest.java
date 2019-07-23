package tests;

import com.codename1.testing.AbstractTest;

import com.codename1.ui.Display;

public class mainPageTest extends AbstractTest {
    public boolean runTest() throws Exception {
        waitForFormName("MainPage");
        assertEqual(getToolbarCommands().length, 6);
        executeToolbarCommandAtOffset(0);
        pointerPress(0.8933764f, 0.30151975f, "Prompt");
        waitFor(88);
        pointerRelease(0.8933764f, 0.30151975f, "Prompt");
        clickButtonByName("confirmButton");
        waitForFormName("UserPromptPage");
        assertLabel("TopInset", "");
        assertLabel("Prompt", "Rate your recent mood (higher is better!)");
        assertLabel("Label", "Recent Mood");
        assertLabel("confirmButton", "");
        assertLabel("BackButton", "");
        assertLabel("Slider", "");
        assertTitle("Track Your Mind");
        screenshotTest("mainPageTest_1");
        assertLabel("TopInset", "");
        assertLabel("Prompt", "Rate your recent mood (higher is better!)");
        assertLabel("Label", "Recent Mood");
        assertLabel("confirmButton", "");
        assertLabel("BackButton", "");
        assertLabel("Slider", "");
        assertTitle("Track Your Mind");
        return true;
    }
}
