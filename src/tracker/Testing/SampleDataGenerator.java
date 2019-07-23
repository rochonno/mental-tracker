package tracker.MentalTrackerTesting;

import tracker.Data.Prompts.PromptDataType;
import tracker.Data.Prompts.PromptResult;
import tracker.Data.Prompts.PromptResults;
import tracker.MentalExceptions.EmptyStringException;
import com.codename1.io.Log;

public class SampleDataGenerator {

    public static PromptResults GeneratePromptResults ()
    {
        PromptResults sampleResults = new PromptResults();

        try {
            sampleResults.addResult( new PromptResult("intResult1", PromptDataType.INT, "1"));
            sampleResults.addResult( new PromptResult("intResult2", PromptDataType.INT, "1"));
            sampleResults.addResult( new PromptResult("boolResult", PromptDataType.BOOL, "true"));
            sampleResults.addResult( new PromptResult("doubleResult", PromptDataType.DOUBLE, "99.99"));
            sampleResults.addResult( new PromptResult("stringResult", PromptDataType.STRING, "A Single Answer"));

        } catch (EmptyStringException e) {
            Log.e(e);
        }

        return sampleResults;
    }

}
