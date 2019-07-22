package tracker.MentalTrackerTesting.IntegrateTesting;

import tracker.Data.DataStorage;
import tracker.Data.Prompts.GenerateDefaultPrompts;
import tracker.Data.Prompts.MentalPrompts;
import tracker.MentalExceptions.ReadFileException;
import tracker.MentalExceptions.SaveFileException;
import tracker.MentalTrackerTesting.TempTestingDirectory;
import com.codename1.io.Log;
import com.codename1.testing.UnitTest;
import java.io.IOException;

public class UserPromptStorageIntTest implements UnitTest{

    private final int _Version = 0;
    private final String _TestFileName = "SavingPrompts";
    private TempTestingDirectory _TestDir;

    /**
     * Runs a unit test, if it returns true it passed. If it threw an exception or returned
     *      false it failed.
     *
     * @returnwhether it passed
     * @throws IOException thrown if it could not create a temporary testing directory
     * @throws ReadFileException if file failed to read
     * @throws SaveFileException if file failed to save
     */
    @Override
    public boolean runTest() throws ReadFileException, SaveFileException {

        DataStorage storage = new DataStorage();

        String testFilePath = _TestDir.CreateFilePath(_TestFileName);

        MentalPrompts userPrompts = GenerateDefaultPrompts.DefaultMorningOnlyPrompts();
        storage.SavePrompts(testFilePath, userPrompts);

        MentalPrompts loadedPrompts = storage.LoadPrompts(testFilePath, _Version);

        if (userPrompts.equals(loadedPrompts)) return true;
        return false;
    }

    /**
     * Prepares the unit test for execution
     */
    @Override
    public void prepare() {
        Log.setLevel(Log.DEBUG);
        _TestDir = new TempTestingDirectory();
    }

    /**
     * Cleanup after a test case executed
     */
    @Override
    public void cleanup() {
        _TestDir.DeleteTempFiles();
    }

    /**
     * Returns the time in milliseconds after which the test should be automatically failed.
     *
     * @return time in milliseconds
     */
    @Override
    public int getTimeoutMillis() {
        return 10000;
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
