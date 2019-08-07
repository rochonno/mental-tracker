package tracker.Data.Prompts;

import com.codename1.io.Externalizable;
import com.codename1.io.Util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;

/*******************************************************************************
 * @author Nolan Rochon
 *
 * This class holds a single prompt for the user.
 * Once created these objects are stored in a list
 *      retrieved each time the questions are asked.
 ******************************************************************************/
public class MentalPrompt implements Externalizable {
    // Registers the class to enable reading it in
    static {
        Util.register("MentalPrompt", MentalPrompt.class);
    }

    /** String for the ID of the class. Used for loading from storage. */
    private String _Id = MentalPrompt.class.getName();

    /** Name of the prompt. */
    private String _Name;
    /** Question to be asked. */
    private String _Prompt;
    /** Minimum int value for answers. */
    private int _Min;
    /** Max int value for answers. */
    private int _Max;
    /** The expected form of the answer. */
    private PromptDataType _ResultType;

    public MentalPrompt(
            final String name,
            final String prompt,
            final PromptDataType resultType) {
        _Name = name;
        _Prompt = prompt;
        _Min = 0;
        _ResultType = resultType;
    }

    public void setMinMax(final int min, final int max) {
        _Min = min;
        _Max = max;
    }

    public void setMax(final int max) {
        _Max = max;
    }

    public void setMin(final int min) {
        _Min = min;
    }

    public String getName() {
        return _Name;
    }

    public void setName(final String name) {
        _Name = name;
    }

    public String getPrompt() {
        return _Prompt;
    }

    public void setPrompt(final String prompt) {
        _Prompt = prompt;
    }

    public int getMin() {
        return _Min;
    }

    public int getMax() {
        return _Max;
    }

    public PromptDataType getDataType() {
        return _ResultType;
    }

    public void setDataType(final PromptDataType dataType) {
        _ResultType = dataType;
    }

    /**
     * Returns a hash code value for the object. This method is
     * supported for the benefit of hash tables such as those provided by
     * {@link HashMap}.
     * <p>
     * The general contract of {@code hashCode} is:
     * <ul>
     * <li>Whenever it is invoked on the same object more than once during
     * an execution of a Java application, the {@code hashCode} method
     * must consistently return the same integer, provided no information
     * used in {@code equals} comparisons on the object is modified.
     * This integer need not remain consistent from one execution of an
     * application to another execution of the same application.
     * <li>If two objects are equal according to the {@code equals(Object)}
     * method, then calling the {@code hashCode} method on each of
     * the two objects must produce the same integer result.
     * <li>It is <em>not</em> required that if two objects are unequal
     * according to the {@link Object#equals(Object)}
     * method, then calling the {@code hashCode} method on each of the
     * two objects must produce distinct integer results.  However, the
     * programmer should be aware that producing distinct integer results
     * for unequal objects may improve the performance of hash tables.
     * </ul>
     *
     * @return a hash code value for this object.
     * @implSpec As far as is reasonably practical, the {@code hashCode}
     * method defined
     * by class {@code Object} returns distinct integers for distinct objects.
     * @see Object#equals(Object)
     * @see System#identityHashCode
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * Overrides the equals method.
     * Only compares the fields that matter for a prompt.
     *
     * @param obj The object being compared
     * @return boolean If the objects are equal
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() == this.getClass()) {
            MentalPrompt prompt = (MentalPrompt) obj;
            if ((_Prompt.equals(prompt._Prompt))
                    && (_Name.equals(prompt._Name))) {
                if (_ResultType == prompt._ResultType) {
                    return (_Min == prompt._Min) && (_Max == prompt._Max);
                }
            }
        }
        return false;
    }

    /**
     * Returns the version for the current persistance code.
     * The version will be passed to internalized.
     * Thus allowing the internalize method to recognize.
     * Classes persisted in older revisions.
     *
     * @return version number for the persistant code
     */
    @Override
    public int getVersion() {
        return 0;
    }

    /**
     * Allows us to store an object state.
     * This method must be implemented in order to save the state of an object.
     *
     * @param out the stream into which the object must be serialized
     * @throws IOException the method may throw an exception
     */
    @Override
    public void externalize(final DataOutputStream out) throws IOException {
        out.writeUTF(_Name);
        out.writeUTF(_Prompt);
        out.writeInt(_Min);
        out.writeInt(_Max);
        out.writeInt(_ResultType.ordinal());
    }

    /**
     * Loads the object from the input stream and allows deserialization.
     *
     * @param version Version the class returned during the extern. process
     * @param in      input stream used to load the class
     * @throws IOException the method may throw an exception
     */
    @Override
    public void internalize(final int version, final DataInputStream in)
            throws IOException {
        _Name = Util.readUTF(in);
        _Prompt = Util.readUTF(in);
        _Min = in.readInt();
        _Max = in.readInt();
        _ResultType = PromptDataType.fromInt(in.readInt());
    }

    /**
     * The object id must be unique.
     * It is used to identify the object when loaded,
     * even when it is obfuscated.
     *
     * @return a unique id
     */
    @Override
    public String getObjectId() {
        return _Id;
    }
}
