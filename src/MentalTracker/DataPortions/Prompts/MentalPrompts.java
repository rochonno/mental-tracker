/*******************************************************************************************
 * @author: Nolan Rochon
 * @date: 07/07/19
 * @project: Mental Health Tracker
 *
 * This class holds a list of all the prompts and manages it accordingly
 *******************************************************************************************/

package MentalTracker.DataPortions.Prompts;

import com.codename1.io.Externalizable;
import com.codename1.io.Util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.*;

public class MentalPrompts implements Externalizable {

    // Registers the class to enable reading it in
    static { Util.register("MentalPrompts", MentalPrompts.class); }

    private List<MentalPrompt> _Prompts;

    public MentalPrompts()
    {
        _Prompts = new Vector<MentalPrompt>();
    }

    public void add(MentalPrompt prompt)
    {
        _Prompts.add (prompt);
    }

    public boolean remove(MentalPrompt prompt)
    {
        return _Prompts.remove(prompt);
    }

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
        _Prompts = (List<MentalPrompt>) Util.readObject(in);
    }

    @Override
    public String getObjectId() {
        return "MentalPrompts";
    }
}
