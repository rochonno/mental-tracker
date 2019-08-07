package tracker.Data;

import com.codename1.io.Log;
import com.codename1.io.Storage;
import tracker.Data.Prompts.PromptDataType;
import tracker.Data.Prompts.PromptResult;
import tracker.Data.Prompts.PromptResults;
import tracker.Data.Storage.DataStorage;

public class CreateLocalData {

    public CreateLocalData() {
        DataStorage data = new DataStorage();
        PromptResults prompt = new PromptResults();

        try {
            prompt.addResult(new PromptResult(
                    "Sleep", PromptDataType.DOUBLE, "12.0"), 0);
            prompt.addResult(new PromptResult(
                    "Depressed", PromptDataType.INT, "7"), 1);
            prompt.addResult(new PromptResult(
                    "Anxiety", PromptDataType.INT, "6"), 2);
            prompt.addResult(new PromptResult(
                    "Confidence", PromptDataType.INT, "8"), 3);
            prompt.addResult(new PromptResult(
                    "Meds", PromptDataType.BOOL, "true"), 4);
            prompt.addResult(new PromptResult(
                    "Sugar", PromptDataType.INT, "25.3"), 5);
        } catch (Exception e) {
            Log.e(e.getCause());
        }
        try {
            data.savePromptResults("2019-07-01", prompt);
        } catch (Exception e) {
            //ignore
        }

        Storage s = new Storage().getInstance();
        String[] test = s.listEntries();
        for (String i : test) {
            System.out.println(i);
        }
    }


}
