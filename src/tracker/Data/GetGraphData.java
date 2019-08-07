package tracker.Data;

import tracker.Data.Prompts.PromptResult;
import tracker.Data.Prompts.PromptResults;
import tracker.MentalExceptions.ReadFileException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

public abstract class GetGraphData {
    private Date _StartDate;
    private Date _EndDate;
    private Calendar _Calendar;
    private DataStorage _Data;

    public ArrayList<String> getArrays(Date start, Date end, String name){
        ArrayList<String> values = new ArrayList<String>();
        PromptResults results;
        _Calendar.setTime(start);
        while(_Calendar.getTime().toString() != end.toString()) {
            try {
                results = _Data.loadPromptResults(_Calendar.getTime().toString(), 0);
                PromptResult singleResult = results.getFromName(name);
                if (singleResult == null) {
                    _Calendar.add(_Calendar.DATE, 1);
                } else {
                    values.add(singleResult.get_StringResult());
                }
            } catch (ReadFileException ex) {
                // Failed to read file
            }
        }
        return values;
    }


}
