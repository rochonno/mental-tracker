package tracker.Data.Prompts;

import tracker.MentalExceptions.EmptyStringException;
import com.codename1.io.Externalizable;
import com.codename1.io.Util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

/*******************************************************************************
 * @author Nolan Rochon
 *
 * This class holds the results from all the Prompts.
 * A time stamp is added once the questions have been completed to
 *      make storage and retrieval of the data simple.
 ******************************************************************************/
public class PromptResults implements Externalizable {
    // Registers the class to enable reading it in
    static {
        Util.register("PromptResults", PromptResults.class);
    }

    /** Timestamp of the results. Used to load results from a date range. */
    private String _TimeStamp;
    /** List of the results from the prompts asked. */
    private List<PromptResult> _ResultsList;

    public PromptResults() {
        _TimeStamp = new SimpleDateFormat("yyyy.MM.dd HH.mm").
                format(new Date());
        _ResultsList = new Vector<>();
    }

    public void addResult(final PromptResult result, final int index) {
        _ResultsList.add(index, result);
    }

    public void updateResult(final PromptResult promptRes, final String result)
            throws EmptyStringException {
        _ResultsList.remove(promptRes);
        promptRes.changeResult(result);
    }

    @Override
    public int getVersion() {
        return 0;
    }

    @Override
    public void externalize(final DataOutputStream out)
            throws IOException {
        Util.writeUTF(_TimeStamp, out);
        Util.writeObject(_ResultsList, out);
    }

    @Override
    public void internalize(final int version, final DataInputStream in)
            throws IOException {
        _TimeStamp = Util.readUTF(in);
        _ResultsList = (List<PromptResult>) Util.readObject(in);
    }

    @Override
    public String getObjectId() {
        return "PromptResults";
    }
}
