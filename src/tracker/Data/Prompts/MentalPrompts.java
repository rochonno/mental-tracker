/*******************************************************************************
 * @author: Nolan Rochon
 * @date: 07/07/19
 * @project: Mental Health Tracker
 *
 * This class holds a list of all the Prompts and manages it accordingly
 ******************************************************************************/

package tracker.Data.Prompts;

import tracker.Data.DataStorage;
import tracker.MentalExceptions.ReadFileException;
import tracker.MentalExceptions.SaveFileException;
import com.codename1.io.Externalizable;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.io.Util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Vector;


public class MentalPrompts implements Externalizable {
    // Registers the class to enable reading it in
    static {
        Util.register("MentalPrompts", MentalPrompts.class); }

    /** List of the prompts to ask. */
    private List<MentalPrompt> _Prompts;

    public MentalPrompts() {
        _Prompts = new Vector<>();
    }

    /**
     * Adds a MentalPrompt to the Vector.
     * @param prompt the prompt to be added
     */
    public void add(final MentalPrompt prompt) {
        _Prompts.add(prompt);
    }

    public MentalPrompt remove(final int index) {
        try {
            MentalPrompt prompt = _Prompts.remove(index);
            return prompt;
        } catch (Exception e) {
            Log.e(e.getCause());
            return null;
        }
    }

    public void savePrompts(String filename) throws SaveFileException {
        if (filename == null) {
            filename = FileSystemStorage.getInstance().getAppHomePath()
                    + this.getClass();
        }
        DataStorage storage = new DataStorage();
        storage.savePrompts(filename, this);
    }

    public MentalPrompts loadPrompts(String filename)
            throws ReadFileException {
        if (filename == null) {
            filename = FileSystemStorage.getInstance().getAppHomePath()
                    + this.getClass();
        }
        DataStorage storage = new DataStorage();
        return storage.loadPrompts(filename, 0);
    }

    public int getPromptCount() {
        return _Prompts.size(); }

    @Override
    public int getVersion() {
        return 0;
    }

    @Override
    public void externalize(final DataOutputStream out) throws IOException {
        Util.writeObject(_Prompts, out);
    }

    @Override
    public void internalize(final int version, final DataInputStream in)
            throws IOException {
        _Prompts = (Vector<MentalPrompt>) Util.readObject(in);
    }

    @Override
    public String getObjectId() {

        return "MentalPrompts";
    }
}
