package tests;

import com.codename1.testing.AbstractTest;

import com.codename1.ui.Display;

public class panicTest2 extends AbstractTest {
    public boolean runTest() throws Exception {
        waitForFormName("UserPromptPage");
        assertLabel("TopInset", "");
        assertLabel("Prompt", "Any experiences symptoms of panic?");
        assertLabel("Label", "Recent Panic Symptoms");
        assertLabel("confirmButton", "");
        assertLabel("BackButton", "");
        assertLabel("depressedButtonNo", "");
        assertLabel("depressedButtonYes", "");
        clickButtonByName("confirmButton");
        assertTitle("Track Your Mind");
        clickButtonByName("depressedButtonNo");
        assertLabel("TopInset", "");
        assertLabel("Prompt", "Any experiences symptoms of panic?");
        assertLabel("Label", "Recent Panic Symptoms");
        assertLabel("confirmButton", "");
        assertLabel("BackButton", "");
        assertLabel("depressedButtonNo", "");
        assertLabel("depressedButtonYes", "");
        clickButtonByName("depressedButtonYes");
        assertLabel("TopInset", "");
        assertLabel("Prompt", "Any experiences symptoms of panic?");
        assertLabel("Label", "Recent Panic Symptoms");
        assertLabel("confirmButton", "");
        assertLabel("BackButton", "");
        assertLabel("depressedButtonNo", "");
        assertLabel("depressedButtonYes", "");
        clickButtonByName("confirmButton");
        waitForFormName("UserPromptPage");
        assertTitle("Track Your Mind");
        return true;
    }
}
