package tracker.Data.Prompts;
import tracker.MentalExceptions.EmptyStringException;
import com.codename1.io.Externalizable;
import com.codename1.io.Util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/*******************************************************************************
 * @author Nolan Rochon
 *
 * This class hold a single user result from a specific prompt.
 * Takes the result as a string, attempts to parse it based on the data type.
 ******************************************************************************/
public class PromptResult implements Externalizable {
    public String get_StringResult() {
        return _StringResult;
    }

    public String get_PromptName() {
        return _PromptName;
    }

    // Registers the class to enable reading it in
    static {
        Util.register("PromptResult", PromptResult.class);
    }

    /** ID of the class used when reading it in from storage. */
    private final String _Id = PromptResult.class.getName();

    /** Name of the prompt the result is for. */
    private String _PromptName;
    /** Expected data form of the answer. */
    private PromptDataType _ExpectedType;

    /** Result in the form of a String. */
    private String _StringResult;
    /** Result in the form of a int. */
    private int _IntResult;
    /** Result in the form of a double. */
    private double _DoubleResult;
    /** Result in the form of a bool. */
    private boolean _BoolResult;
    /** If the result is valid. */
    private boolean _ValidResult;

    /**
     * Constructor for PromptResult Object.
     *
     * @param name name of the prompt
     * @param expectedType type of answer expected
     * @param result the answer recieved
     * @throws EmptyStringException If the name String is null/Empty
     */
    public PromptResult(
            final String name,
            final PromptDataType expectedType,
            final String result)
            throws EmptyStringException {
        if (name.isEmpty() || result.isEmpty()) {
            throw new EmptyStringException(
                    "Trying to create result with no name or answer",
                    new Throwable());
        }

        _PromptName = name;
        _ExpectedType = expectedType;
        _StringResult = result;
        try {
            _ValidResult = parseResult();
        } catch (NumberFormatException ex) {
            _ValidResult = false;
        }
    }

    public void changeResult(final String result) throws EmptyStringException {
        if (result.isEmpty()) {
            throw new EmptyStringException(
                    "Trying to create result with no answer", new Throwable());
        }
        _StringResult = result;
        try {
            _ValidResult = parseResult();
        } catch (NumberFormatException ex) {
            _ValidResult = false;
        }
    }

    /**
     * Parses the result based on the expected input type.
     *
     * @return if it was successfully parsed
     */
    private boolean parseResult() {
        switch (_ExpectedType) {
            case STRING: return true;

            case BOOL:
                int tempIntResult = Integer.parseInt(_StringResult);
                if (tempIntResult == 1) {
                    _BoolResult = true;
                    return true;
                } else if (tempIntResult == 0) {
                    return true;
                }
                break;

            case INT:
                _IntResult = Integer.parseInt(_StringResult);
                return true;

            case DOUBLE:
                _DoubleResult = Double.parseDouble(_StringResult);
                return true;
            default: break;
        }
        return false;
    }

    String getName() {
        return _PromptName;
    }

    int getIntResult() {
        return _IntResult;
    }

    double getDoubleResult() {
        return _DoubleResult;
    }

    boolean getBoolResult() {
        return _BoolResult;
    }

    String setStringResult() {
        return _StringResult;
    }

    /**
     * Returns the version for the current persistence code.
     * The version will be passed to internalized thus allowing the
     * internalize method to recognize classes persisted in older revisions.
     *
     * @return version number for the persistent code
     */
    @Override
    public int getVersion() {
        return 0;
    }

    /**
     * Allows us to store an object state.
     * This method must be implemented in order to save the state of an object
     *
     * @param out the stream into which the object must be serialized
     * @throws IOException the method may throw an exception
     */
    @Override
    public void externalize(final DataOutputStream out) throws IOException {
        out.writeUTF(_PromptName);
        out.writeInt(_ExpectedType.ordinal());
        Util.writeUTF(_StringResult, out);
        out.writeInt(_IntResult);
        out.writeDouble(_DoubleResult);
        out.writeBoolean(_BoolResult);
        out.writeBoolean(_ValidResult);
    }

    /**
     * Loads the object from the input stream and allows deserialization.
     *
     * @param version Version the class returned during the extern. process
     * @param in      the input stream used to load the class
     * @throws IOException the method may throw an exception
     */
    @Override
    public void internalize(final int version, final DataInputStream in)
            throws IOException {
        _PromptName = Util.readUTF(in);
        _ExpectedType = PromptDataType.fromInt(in.readInt());
        _StringResult = Util.readUTF(in);
        _IntResult = in.readInt();
        _DoubleResult = in.readDouble();
        _BoolResult = in.readBoolean();
        _ValidResult = in.readBoolean();
    }

    /**
     * The object id must be unique, Used to identify the object when loaded.
     * even when it is obfuscated.
     *
     * @return a unique id
     */
    @Override
    public String getObjectId() {
        return _Id;
    }
}
