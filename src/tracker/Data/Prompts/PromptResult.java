/*******************************************************************************************
 * @author: Nolan Rochon
 * @date: 07/07/19
 * @project: Mental Health Tracker
 *
 * This class hold a single user result from a specific prompt.
 * Takes the result as a string, then attempts to parse it based on the data type
 *******************************************************************************************/
package tracker.Data.Prompts;
import tracker.MentalExceptions.EmptyStringException;
import com.codename1.io.Externalizable;
import com.codename1.io.Util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class PromptResult implements Externalizable {
    // Registers the class to enable reading it in
    static { Util.register("PromptResult", PromptResult.class); }

    private final String _Id = PromptResult.class.getName();

    private String _PromptName;
    private PromptDataType _ExpectedType;

    private String _StringResult;
    private int _IntResult;
    private double _DoubleResult;
    private boolean _BoolResult;
    private boolean _ValidResult;

    /**
     * Constructor for PromptResult Object
     *
     * @param name name of the prompt
     * @param expectedType type of answer expected
     * @param result the answer recieved
     * @throws EmptyStringException If the name String is null/Empty
     */
    public PromptResult (String name, PromptDataType expectedType, String result) throws EmptyStringException {
        if (name.isEmpty()) throw new EmptyStringException("Trying to create result with no name", new Throwable());

        _PromptName = name;
        _ExpectedType = expectedType;
        _StringResult = result;
        try {
            _ValidResult = parseResult(result);
        }
        catch (NumberFormatException ex)
        {
            _ValidResult = false;
        }
    }

    /**
     * Parses the result based on the expected input type
     *
     * @param result the received result in the form of a String
     * @return if it was successfully parsed
     */
    private boolean parseResult(String result)
    {
        switch (_ExpectedType)
        {
            case STRING: return true;

            case BOOL:
                int tempIntResult = Integer.parseInt(_StringResult);
                if (tempIntResult == 1)
                {
                    _BoolResult = true;
                    return true;
                }
                else if (tempIntResult == 0)
                {
                    return true;
                }
                break;

            case INT:
                _IntResult = Integer.parseInt(_StringResult);
                return true;

            case DOUBLE:
                _DoubleResult = Double.parseDouble(_StringResult);
                return true;
        }
        return false;
    }

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
        out.writeUTF(_PromptName);
        out.writeInt(_ExpectedType.ordinal());
        Util.writeUTF(_StringResult, out);
        out.writeInt(_IntResult);
        out.writeDouble(_DoubleResult);
        out.writeBoolean(_BoolResult);
        out.writeBoolean(_ValidResult);
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
        _PromptName = Util.readUTF(in);
        _ExpectedType = PromptDataType.FromInt(in.readInt());
        _StringResult = Util.readUTF(in);
        _IntResult = in.readInt();
        _DoubleResult = in.readDouble();
        _BoolResult = in.readBoolean();
        _ValidResult = in.readBoolean();
    }

    /**
     * The object id must be unique, it is used to identify the object when loaded
     * even when it is obfuscated.
     *
     * @return a unique id
     */
    @Override
    public String getObjectId() { return _Id; }
}
