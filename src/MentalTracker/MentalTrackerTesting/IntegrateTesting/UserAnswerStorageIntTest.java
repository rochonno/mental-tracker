package MentalTracker.MentalTrackerTesting.IntegrateTesting;

import MentalTracker.DataPortions.DataStorage;
import MentalTracker.DataPortions.Prompts.*;
import MentalTracker.MentalExceptions.ReadFileException;
import MentalTracker.MentalExceptions.SaveFileException;
import MentalTracker.MentalTrackerTesting.SampleDataGenerator;
import MentalTracker.MentalTrackerTesting.TempTestingDirectory;
import com.codename1.io.Log;
import com.codename1.testing.UnitTest;
import java.io.IOException;

public class UserAnswerStorageIntTest implements UnitTest {

    private final int _Version = 0;
    private final String _TestFileName = "SavingAnswers";
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

        PromptResults promptResults = SampleDataGenerator.GeneratePromptResults();
        storage.SavePromptResults(testFilePath, promptResults);

        PromptResults loadedResults = storage.LoadPromptResutls(testFilePath, _Version);

        if (promptResults.equals(loadedResults)) return true;
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
