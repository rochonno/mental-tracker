package tests;

import com.codename1.testing.AbstractTest;

import com.codename1.ui.Display;

public class sugarTest2 extends AbstractTest {
    public boolean runTest() throws Exception {
        waitForFormName("UserPromptPage");
        assertLabel("TopInset", "");
        assertLabel("Prompt", "Grams of sugar consumed");
        assertLabel("Label", "Sugar Past Day");
        assertLabel("confirmButton", "");
        assertLabel("BackButton", "");
        assertLabel("Slider", "");
        pointerPress(0.50879765f, 0.50857145f, "Slider");
        waitFor(69);
        pointerRelease(0.50879765f, 0.50857145f, "Slider");
        assertLabel("TopInset", "");
        assertLabel("Prompt", "Grams of sugar consumed");
        assertLabel("Label", "Sugar Past Day");
        assertLabel("confirmButton", "");
        assertLabel("BackButton", "");
        assertLabel("Slider", "10");
        pointerPress(0.016129032f, 0.49142858f, "Slider");
        waitFor(56);
        pointerRelease(0.016129032f, 0.49142858f, "Slider");
        assertLabel("TopInset", "");
        assertLabel("Prompt", "Grams of sugar consumed");
        assertLabel("Label", "Sugar Past Day");
        assertLabel("confirmButton", "");
        assertLabel("BackButton", "");
        assertLabel("Slider", "0");
        pointerPress(0.9926686f, 0.47428572f, "Slider");
        waitFor(53);
        pointerRelease(0.9926686f, 0.47428572f, "Slider");
        assertLabel("TopInset", "");
        assertLabel("Prompt", "Grams of sugar consumed");
        assertLabel("Label", "Sugar Past Day");
        assertLabel("confirmButton", "");
        assertLabel("BackButton", "");
        assertLabel("Slider", "19");
        clickButtonByName("confirmButton");
        waitForFormName("UserPromptPage");
        assertTitle("Track Your Mind");
        return true;
    }
}
