/*******************************************************************************************
 * @author: Nolan Rochon
 * @date: 07/07/19
 * @project: Mental Health Tracker
 *
 * This class holds the results from all the prompts. A time stamp is added once the
 *      questions have been completed to make storage and retrieval of the data simple.
 *******************************************************************************************/

package MentalTracker.DataPortions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PromptResults implements Externalizable {

    private String _TimeStamp;
    private List<PromptResults> _ResultsList;

    public PromptResults ()
    {
        _TimeStamp = new SimpleDateFormat("yyyy.MM.dd HH.mm").format(new Date());
        _ResultsList = new Vector<PromptResults>();
    }
}