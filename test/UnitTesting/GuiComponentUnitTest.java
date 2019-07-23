package tracker.Testing.UnitTesting;

import com.codename1.io.Log;
import com.codename1.testing.UnitTest;
import com.codename1.ui.util.Resources;
import tracker.GuiComponents.GuiButton;
import tracker.GuiComponents.GuiLabel;
import tracker.GuiComponents.GuiSlider;
import tracker.GuiComponents.GuiTextArea;

public class GuiComponentUnitTest implements UnitTest {

    private Resources _InstanceResources;

    public static boolean run() {
        GuiComponentUnitTest test = new GuiComponentUnitTest();
        test.prepare();
        try {
            return test.runTest();
        } catch (Exception e) {
            Log.e(e.getCause());
            return false;
        }
    }


    /**
     * Runs a unit test, if it returns true it passed.
     * If it threw an exception or returned false it failed.
     *
     * @return whether it passed
     * @throws Exception thrown if it failed
     */
    @Override
    public boolean runTest() throws Exception {
        GuiButton button = new GuiButton(
                "testButton", _InstanceResources, "ContinueButton", null);
        GuiLabel label = new GuiLabel("testLabel", _InstanceResources);
        GuiSlider slider = new GuiSlider(
                "testSlider", _InstanceResources, 0, 20);
        GuiTextArea testArea = new GuiTextArea(
                "testTextArea", _InstanceResources);

        return true;
    }

    /**
     * Prepares the unit test for execution.
     */
    @Override
    public void prepare() {
        _InstanceResources = Resources.getGlobalResources();
    }

    /**
     * Cleanup after a test case executed.
     */
    @Override
    public void cleanup() {

    }

    /**
     * Returns the time in milliseconds.
     * After which the test should be automatically failed.
     *
     * @return time in milliseconds
     */
    @Override
    public int getTimeoutMillis() {
        return 0;
    }

    /**
     * Returns true to indicate that the test expects to be executed on the EDT.
     *
     * @return whether the test should execute on the EDT or the testing thread
     */
    @Override
    public boolean shouldExecuteOnEDT() {
        return false;
    }
}
