/*******************************************************************************
 * @author: Nolan Rochon
 * @date: 07/07/19
 * @project: Mental Health Tracker
 *
 * This class saves and loads the Prompts and Results from storage on the phone
 ******************************************************************************/
package tracker.Data;

import tracker.Data.Prompts.MentalPrompt;
import tracker.Data.Prompts.MentalPrompts;
import tracker.Data.Prompts.PromptResults;
import tracker.MentalExceptions.ReadFileException;
import tracker.MentalExceptions.SaveFileException;
import com.codename1.io.Storage;

public class DataStorage {

    public DataStorage() {
    }

    public MentalPrompts loadPrompts(final String filename, final int version)
            throws ReadFileException {
        Storage s = Storage.getInstance();
        // Make sure Util registers the class to read it in
        MentalPrompts tempPrompts = new MentalPrompts();
        new MentalPrompt("this", "ispointless", null);

            tempPrompts = (MentalPrompts) s.readObject(filename);
            return tempPrompts;
    }


    public PromptResults loadPromptResults(
            final String filename, final int version)
            throws ReadFileException {
        Storage s = Storage.getInstance();
        // Make sure Util registers the class to read it in
        PromptResults results = new PromptResults();
        return (PromptResults) s.readObject(filename);
    }

    public void savePrompts(final String filename, final MentalPrompts prompts)
            throws SaveFileException {
        Storage s =  Storage.getInstance();
        s.writeObject(filename, prompts);
    }

    public void savePromptResults(
            final String filename, final PromptResults results)
            throws SaveFileException {
        Storage s = Storage.getInstance();
        s.writeObject(filename, results);
    }
}
