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
            sampleResults.AddResult( new PromptResult("intResult1", PromptDataType.INT, "1"));
            sampleResults.AddResult( new PromptResult("intResult2", PromptDataType.INT, "1"));
            sampleResults.AddResult( new PromptResult("boolResult", PromptDataType.BOOL, "true"));
            sampleResults.AddResult( new PromptResult("doubleResult", PromptDataType.DOUBLE, "99.99"));
            sampleResults.AddResult( new PromptResult("stringResult", PromptDataType.STRING, "A Single Answer"));

        } catch (EmptyStringException e) {
            Log.e(e);
        }

        return sampleResults;
    }

}
