package tracker.Testing.IntegrateTesting;
import tracker.Testing.Codename1TestConstants;
import com.codename1.io.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class IntegrationTesting {

    IntegrationTesting() {

    }

    public static void runStorageTests() {
        IntegrationTesting test = new IntegrationTesting();
        test.runUserPromptStorageTest();
        test.runUserAnswerStorageTest();
    }

    /**
     *
     * @return if it passed
     */
    public boolean runUserPromptStorageTest() {
        UserPromptStorageIntTest intStorageTest = new UserPromptStorageIntTest();
        return runSingleStorageTest (intStorageTest);
    }

    /**
     *
     * @return if it passed
     */
    public boolean runUserAnswerStorageTest() {
        UserAnswerStorageIntTest intStorageTest = new UserAnswerStorageIntTest();
        return runSingleStorageTest(intStorageTest);
    }

    /**
     *
     * @param storageTest Expects a storage test object
     * @return if it passed
     */
    private boolean runSingleStorageTest(Object storageTest) {
        boolean passed = false;

        try {
            Method prepare = storageTest.getClass().getMethod(Codename1TestConstants.UnitTestPrep);
            Method runTest = storageTest.getClass().getMethod(Codename1TestConstants.UnitTestRun);
            Method cleanup = storageTest.getClass().getMethod(Codename1TestConstants.UnitTestClean);

            try {
                prepare.invoke(storageTest);
                passed = (boolean) runTest.invoke(storageTest);
                cleanup.invoke(storageTest);

            } catch (IllegalAccessException e) {
                Log.e(e);
            } catch (InvocationTargetException e) {
                Log.e(e.getCause());
            }

        } catch (NoSuchMethodException e) {
            Log.e(e);
        }

        return passed;
    }
}
