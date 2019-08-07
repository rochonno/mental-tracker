package tracker.Data;

import com.codename1.io.Storage;
import tracker.Data.Prompts.PromptResult;
import tracker.Data.Prompts.PromptResults;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class GetGraphData {
    private Date _StartDate;
    private Date _EndDate;
    private DataStorage d;
    private Storage s = new Storage().getInstance();

    public void getArrays(Date start, Date end, String name){
        ArrayList<String> values = new ArrayList<String>();
        try {
            PromptResults prompt = d.loadPromptResults(s.toString(), 0);
            List<PromptResult> temp = prompt.get_ResultsList();
            for(PromptResult item: temp) {
            if(item.get_PromptName() == name){
                values.add(item.get_StringResult());
                    break;
                }
            }
        }catch(Exception e){

        }
    }
}
