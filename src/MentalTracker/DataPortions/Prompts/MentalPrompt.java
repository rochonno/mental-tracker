/*******************************************************************************************
 * @author: Nolan Rochon
 * @date: 07/07/19
 * @project: Mental Health Tracker
 *
 * This class holds a single prompt for the user. Once created these objects are stored
 *      in a list retrieved each time the questions are asked.
 *******************************************************************************************/
package MentalTracker.DataPortions.Prompts;

import com.codename1.io.Externalizable;
import com.codename1.io.Util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class MentalPrompt implements Externalizable {
    // Registers the class to enable reading it in
    static { Util.register("MentalPrompt", MentalPrompt.class); }

    private final String _Id = MentalPrompt.class.getName();

    private String _Name;
    private String _Prompt;
    private int _Min;
    private int _Max;
    private PromptDataType _ResultType;

    public MentalPrompt (String name, String prompt, PromptDataType resultType)
    {
        _Name = name;
        _Prompt = prompt;
        _Min = 0;
        _ResultType = resultType;
    }

    public void SetMinMax (int min, int max)
    {
        _Min = min;
        _Max = max;
    }

    public void SetMax (int max)
    {
        _Max = max;
    }

    public String get_Name () { return _Name; }
    public String get_Prompt () { return _Prompt; }
    public int GetMin () { return _Min; }
    public int GetMax () { return _Max; }
    public PromptDataType GetDataType () { return _ResultType; }

    /**
     * Returns the version for the current persistance code, the version will be
     * pased to internalized thus allowing the internalize method to recognize
     * classes persisted in older revisions
     *
     * @return version number for the persistant code
     */
    @Override
    public int getVersion() {
        return 0;
    }

    /**
     * Allows us to store an object state, this method must be implemented
     * in order to save the state of an object
     *
     * @param out the stream into which the object must be serialized
     * @throws IOException the method may throw an exception
     */
    @Override
    public void externalize(DataOutputStream out) throws IOException {
        out.writeUTF(_Name);
        out.writeUTF(_Prompt);
        out.writeInt(_Min);
        out.writeInt(_Max);
        out.writeInt(_ResultType.ordinal());
    }

    /**
     * Loads the object from the input stream and allows deserialization
     *
     * @param version the version the class returned during the externalization processs
     * @param in      the input stream used to load the class
     * @throws IOException the method may throw an exception
     */
    @Override
    public void internalize(int version, DataInputStream in) throws IOException {
        _Name = Util.readUTF(in);
        _Prompt = Util.readUTF(in);
        _Min = in.readInt();
        _Max = in.readInt();
        _ResultType = PromptDataType.FromInt(in.readInt());
    }

    /**
     * The object id must be unique, it is used to identify the object when loaded
     * even when it is obfuscated.
     *
     * @return a unique id
     */
    @Override
    public String getObjectId() {
        return _Id;
    }
}
