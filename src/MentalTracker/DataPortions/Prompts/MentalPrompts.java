/*******************************************************************************************
 * @author: Nolan Rochon
 * @date: 07/07/19
 * @project: Mental Health Tracker
 *
 * This class holds a list of all the prompts and manages it accordingly
 *******************************************************************************************/

package MentalTracker.DataPortions.Prompts;

import com.codename1.io.Externalizable;
import com.codename1.io.Log;
import com.codename1.io.Util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Vector;


public class MentalPrompts implements Externalizable {
    // Registers the class to enable reading it in
    static { Util.register("MentalPrompts", MentalPrompts.class); }

    private List<MentalPrompt> _Prompts;
    private int _PromptCount = 0;

    public MentalPrompts()
    {
        _Prompts = new Vector<MentalPrompt>();
    }

    /**
     * Adds a MentalPrompt to the Vector
     * @param prompt the prompt to be added
     */
    public void add(MentalPrompt prompt)
    {
        _Prompts.add (prompt);
        _PromptCount++;
    }

    public MentalPrompt remove(int index)
    {
        try {
            MentalPrompt prompt = _Prompts.remove(index);
            _PromptCount--;
            return prompt;
        }
        catch (Exception e) {
            Log.e(e.getCause());
            return null;
        }
    }

    public int get_PromptCount() {return _PromptCount}

    @Override
    public int getVersion() {
        return 0;
    }

    @Override
    public void externalize(DataOutputStream out) throws IOException {
        Util.writeObject(_Prompts, out);
    }

    @Override
    public void internalize(int version, DataInputStream in) throws IOException {
        _Prompts = (Vector<MentalPrompt>) Util.readObject(in);
    }

    @Override
    public String getObjectId() {
        return "MentalPrompts";
    }
}
