package tracker.Testing.IntegrateTesting;

import com.codename1.io.Log;
import com.codename1.ui.Form;
import tracker.Pages.MainPage;
import com.codename1.testing.AbstractTest;

public class CreatePagesUnitTest extends AbstractTest {

    CreatePagesUnitTest() {

    }

    public static boolean run() {
        CreatePagesUnitTest test = new CreatePagesUnitTest();
        try {
            return test.runTest();
        } catch (Exception e) {
            Log.e(e.getCause());
            return false;
        }
    }

    /**
     * Runs a unit test, if it returns true it passed. If it threw an exception or returned
     * false it failed.
     *
     * @return whether it passed
     * @throws Exception thrown if it failed
     */
    @Override
    public boolean runTest() throws Exception {
        Form MainPage = new MainPage(false);
        MainPage.show();
        waitForFormName("MainPage");
        clickButtonByName("confirmButton");
        waitForFormName("UserPromptPage");
        goBack();
        waitForFormName("MainPage");
        clickButtonByName("confirmButton");
        return false;
    }

    /**
     * Prepares the unit test for execution
     */
    @Override
    public void prepare() {
    }

    /**
     * Cleanup after a test case executed
     */
    @Override
    public void cleanup() {

    }

    /**
     * Returns the time in milliseconds after which the test should be automatically failed.
     *
     * @return time in milliseconds
     */
    @Override
    public int getTimeoutMillis() {
        return 0;
    }

    /**
     * Returns true to indicate that the test expects to be executed on the EDT
     *
     * @return whether the test should execute on the EDT or the testing thread
     */
    @Override
    public boolean shouldExecuteOnEDT() {
        return false;
    }
}
