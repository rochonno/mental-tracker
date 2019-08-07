/**
 *
 * Class that takes in a start and end date,
 * along with a prompt name to cycle through
 * PromptResults stored in local data to send
 * back an array of data pertaining to
 * that prompt in that date range.
 *
 * @Author Douglas Yacenick
 */
package tracker.Data;

import tracker.Data.Prompts.PromptResult;
import tracker.Data.Prompts.PromptResults;
import tracker.Data.Storage.DataStorage;
import tracker.MentalExceptions.ReadFileException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

/**
 * Gets the graph data used for populate the info on a graph.
 */
public abstract class GetGraphData {
    /** Start date selected by drop down box. */
    private Date _StartDate;
    /** End date selected by drop down box. */
    private Date _EndDate;
    /** Calendar for iterating through dates. */
    private Calendar _Calendar;
    /** Instantiate DataStorage class to access local data. */
    private DataStorage _Data;

    /**
     *
     * @param start Start date passed by drop down box.
     * @param end End date passed by drop down box.
     * @param name Name of prompt passed in.
     * @return Array of all the prompt's values between date range.
     */
    public ArrayList<String> getArrays(
            final Date start,
            final Date end,
            final String name) {

        ArrayList<String> values = new ArrayList<String>();
        PromptResults results;
        _Calendar.setTime(start);
        while (_Calendar.getTime().toString().equals(end.toString())) {
            try {
                results = _Data.loadPromptResults(
                        _Calendar.getTime().toString(),
                        0);
                PromptResult singleResult = results.getFromName(name);
                if (singleResult == null) {
                    _Calendar.add(_Calendar.DATE, 1);
                } else {
                    values.add(singleResult.getName());
                }
            } catch (ReadFileException ex) {
                // Failed to read file
            }
        }
        return values;
    }


}
