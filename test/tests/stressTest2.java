package tests;

import com.codename1.testing.AbstractTest;

import com.codename1.ui.Display;

public class stressTest2 extends AbstractTest {
    public boolean runTest() throws Exception {
        waitForFormName("UserPromptPage");
        assertLabel("TopInset", "");
        assertLabel("Prompt", "How stressed are you?");
        assertLabel("Label", "Overall Stress");
        assertLabel("confirmButton", "");
        assertLabel("BackButton", "");
        assertLabel("Slider", "");
        pointerPress(0.016129032f, 0.50857145f, "Slider");
        waitFor(575);
        pointerRelease(0.016129032f, 0.50857145f, "Slider");
        assertLabel("TopInset", "");
        assertLabel("Prompt", "How stressed are you?");
        assertLabel("Label", "Overall Stress");
        assertLabel("confirmButton", "");
        assertLabel("BackButton", "");
        assertLabel("Slider", "0");
        pointerPress(0.49266863f, 0.49142858f, "Slider");
        waitFor(69);
        pointerRelease(0.49266863f, 0.49142858f, "Slider");
        assertLabel("TopInset", "");
        assertLabel("Prompt", "How stressed are you?");
        assertLabel("Label", "Overall Stress");
        assertLabel("confirmButton", "");
        assertLabel("BackButton", "");
        assertLabel("Slider", "9");
        ensureVisible("confirmButton");
        assertLabel("TopInset", "");
        assertLabel("Prompt", "How stressed are you?");
        assertLabel("Label", "Overall Stress");
        assertLabel("confirmButton", "");
        assertLabel("BackButton", "");
        assertLabel("Slider", "20");
        clickButtonByName("confirmButton");
        waitForFormName("UserPromptPage");
        assertTitle("Track Your Mind");
        return true;
    }
}
