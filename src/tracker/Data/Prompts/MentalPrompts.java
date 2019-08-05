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

/*******************************************************************************
 * @author Nolan Rochon
 *
 * This class holds a list of all the Prompts and manages it accordingly
 ******************************************************************************/
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

    public void deletePrompt(final MentalPrompt prompt) {
        _Prompts.remove(prompt);
    }

    public void changePrompt(final MentalPrompt target, final MentalPrompt changed) {
        int index = _Prompts.indexOf(target);
        _Prompts.remove(target);
        _Prompts.add(index, changed);
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
        return _Prompts.size();
    }

    public List<MentalPrompt> getPrompts() {
        return _Prompts;
    }

    public MentalPrompt getPrompt(int index) {
        return _Prompts.get(index);
    }

    public int getIndex(MentalPrompt prompt) {
        return _Prompts.indexOf(prompt);
    }

    public boolean doesContain(MentalPrompt searchPrompt) {
        for (MentalPrompt prompt : _Prompts) {
            if (prompt.equals(searchPrompt)) {
                return true;
            }
        }
        return false;
    }

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
