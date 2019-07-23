package tests;

import com.codename1.testing.AbstractTest;

import com.codename1.ui.Display;

public class exerciseTest2 extends AbstractTest {
    public boolean runTest() throws Exception {
        waitForFormName("UserPromptPage");
        assertLabel("TopInset", "");
        assertLabel("Prompt", "Did you exercise?");
        assertLabel("Label", "Exercise Past Day");
        assertLabel("confirmButton", "");
        assertLabel("BackButton", "");
        assertLabel("depressedButtonNo", "");
        assertLabel("depressedButtonYes", "");
        clickButtonByName("confirmButton");
        assertLabel("TopInset", "");
        assertLabel("Prompt", "Did you exercise?");
        assertLabel("Label", "Exercise Past Day");
        assertLabel("confirmButton", "");
        assertLabel("BackButton", "");
        assertLabel("depressedButtonNo", "");
        assertLabel("depressedButtonYes", "");
        clickButtonByName("depressedButtonNo");
        assertLabel("TopInset", "");
        assertLabel("Prompt", "Did you exercise?");
        assertLabel("Label", "Exercise Past Day");
        assertLabel("confirmButton", "");
        assertLabel("BackButton", "");
        assertLabel("depressedButtonNo", "");
        assertLabel("depressedButtonYes", "");
        clickButtonByName("depressedButtonYes");
        assertLabel("TopInset", "");
        assertLabel("Prompt", "Did you exercise?");
        assertLabel("Label", "Exercise Past Day");
        assertLabel("confirmButton", "");
        assertLabel("BackButton", "");
        assertLabel("depressedButtonNo", "");
        assertLabel("depressedButtonYes", "");
        clickButtonByName("confirmButton");
        waitForFormName("UserPromptPage");
        return true;
    }
}
