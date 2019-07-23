package tests;

import com.codename1.testing.AbstractTest;

import com.codename1.ui.Display;

public class moodShift2 extends AbstractTest {
    public boolean runTest() throws Exception {
        waitForFormName("UserPromptPage");
        assertLabel("TopInset", "");
        assertLabel("Prompt", "Mod shifts experienced since the last check-in?");
        assertLabel("Label", "Mood Shifts Past Day");
        assertLabel("confirmButton", "");
        assertLabel("BackButton", "");
        assertLabel("Slider", "");
        pointerPress(0.50879765f, 0.49142858f, "Slider");
        waitFor(62);
        pointerRelease(0.50879765f, 0.49142858f, "Slider");
        assertLabel("TopInset", "");
        assertLabel("Prompt", "Mod shifts experienced since the last check-in?");
        assertLabel("Label", "Mood Shifts Past Day");
        assertLabel("confirmButton", "");
        assertLabel("BackButton", "");
        assertLabel("Slider", "10");
        pointerPress(0.9926686f, 0.50857145f, "Slider");
        waitFor(72);
        pointerRelease(0.9926686f, 0.50857145f, "Slider");
        assertLabel("TopInset", "");
        assertLabel("Prompt", "Mod shifts experienced since the last check-in?");
        assertLabel("Label", "Mood Shifts Past Day");
        assertLabel("confirmButton", "");
        assertLabel("BackButton", "");
        assertLabel("Slider", "19");
        pointerPress(0.004398827f, 0.50857145f, "Slider");
        waitFor(80);
        pointerRelease(0.004398827f, 0.50857145f, "Slider");
        assertLabel("TopInset", "");
        assertLabel("Prompt", "Mod shifts experienced since the last check-in?");
        assertLabel("Label", "Mood Shifts Past Day");
        assertLabel("confirmButton", "");
        assertLabel("BackButton", "");
        assertLabel("Slider", "0");
        clickButtonByName("confirmButton");
        waitForFormName("UserPromptPage");
        assertTitle("Track Your Mind");
        return true;
    }
}
