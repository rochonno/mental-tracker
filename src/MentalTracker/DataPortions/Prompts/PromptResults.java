/*******************************************************************************************
 * @author: Nolan Rochon
 * @date: 07/07/19
 * @project: Mental Health Tracker
 *
 * This class holds the results from all the prompts. A time stamp is added once the
 *      questions have been completed to make storage and retrieval of the data simple.
 *******************************************************************************************/

package MentalTracker.DataPortions.Prompts;

import com.codename1.io.Externalizable;
import com.codename1.io.Util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class PromptResults implements Externalizable {
    // Registers the class to enable reading it in
    static { Util.register("PromptResults", PromptResults.class); }

    private String _TimeStamp;
    private List<PromptResult> _ResultsList;

    public PromptResults ()
    {
        _TimeStamp = new SimpleDateFormat("yyyy.MM.dd HH.mm").format(new Date());
        _ResultsList = new Vector<PromptResult>();
    }

    public void AddResult (PromptResult result)
    {
        _ResultsList.add (result);
    }

    @Override
    public int getVersion()
    {
        return 0;
    }

    @Override
    public void externalize(DataOutputStream out) throws IOException
    {
        Util.writeUTF(_TimeStamp, out);
        Util.writeObject(_ResultsList, out);
    }

    @Override
    public void internalize(int version, DataInputStream in) throws IOException
    {
        _TimeStamp = Util.readUTF(in);
        _ResultsList = (List<PromptResult>) Util.readObject(in);
    }

    @Override
    public String getObjectId()
    {
        return "PromptResults";
    }
}
