package tests;

import com.codename1.testing.AbstractTest;

import com.codename1.ui.Display;

public class anxiousTest2 extends AbstractTest {
    public boolean runTest() throws Exception {
        waitForFormName("UserPromptPage");
        assertLabel("TopInset", "");
        assertLabel("Prompt", "How anxious do you feel?");
        assertLabel("Label", "Overall Anxiety");
        assertLabel("confirmButton", "");
        assertLabel("BackButton", "");
        assertLabel("Slider", "");
        pointerPress(0.51319647f, 0.45714286f, "Slider");
        waitFor(73);
        pointerRelease(0.51319647f, 0.45714286f, "Slider");
        assertLabel("TopInset", "");
        assertLabel("Prompt", "How anxious do you feel?");
        assertLabel("Label", "Overall Anxiety");
        assertLabel("confirmButton", "");
        assertLabel("BackButton", "");
        assertLabel("Slider", "10");
        pointerPress(0.9926686f, 0.47428572f, "Slider");
        waitFor(81);
        pointerRelease(0.9926686f, 0.47428572f, "Slider");
        assertLabel("TopInset", "");
        assertLabel("Prompt", "How anxious do you feel?");
        assertLabel("Label", "Overall Anxiety");
        assertLabel("confirmButton", "");
        assertLabel("BackButton", "");
        assertLabel("Slider", "19");
        pointerPress(0.016129032f, 0.47428572f, "Slider");
        waitFor(65);
        pointerRelease(0.016129032f, 0.47428572f, "Slider");
        assertLabel("TopInset", "");
        assertLabel("Prompt", "How anxious do you feel?");
        assertLabel("Label", "Overall Anxiety");
        assertLabel("confirmButton", "");
        assertLabel("BackButton", "");
        assertLabel("Slider", "0");
        clickButtonByName("confirmButton");
        waitForFormName("UserPromptPage");
        assertTitle("Track Your Mind");
        return true;
    }
}
