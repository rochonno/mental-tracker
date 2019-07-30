package tracker.Data;

import com.codename1.io.Storage;
import tracker.Data.Prompts.PromptDataType;
import tracker.Data.Prompts.PromptResult;
import tracker.Data.Prompts.PromptResults;

import java.util.Vector;

import static tracker.Data.Prompts.PromptDataType.DOUBLE;

public class createLocalData {

    public createLocalData(){
        DataStorage data = new DataStorage();
        PromptResults prompt = new PromptResults();

        Vector<PromptResult> temp = new Vector<>();
        try {
            temp.add(new PromptResult("Sleep", PromptDataType.DOUBLE,"12.0"));
            temp.add(new PromptResult("Depressed", PromptDataType.INT, "7"));
            temp.add(new PromptResult("Anxiety", PromptDataType.INT, "6"));
            temp.add(new PromptResult("Confidence", PromptDataType.INT, "8"));
            temp.add(new PromptResult("Meds", PromptDataType.BOOL, "true"));
            temp.add(new PromptResult("Sugar", PromptDataType.INT, "25.3"));
        }catch(Exception e){
            //Ignore
        }
        prompt.set_ResultsList(temp);
        try {
            data.savePromptResults("2019.07.01", prompt);
        }catch(Exception e){
            //ignore
        }

        Storage s = new Storage().getInstance();
        String [] test = s.listEntries();
        for (String i : test){
            System.out.println(i);
        }
    }


}
