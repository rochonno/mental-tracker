/*******************************************************************************************
 * @author: Nolan Rochon
 * @date: 07/07/19
 * @project: Mental Health Tracker
 *
 * This class saves and loads the Prompts and Results from storage on the phone
 *******************************************************************************************/
package tracker.Data;

import tracker.Data.Prompts.MentalPrompt;
import tracker.Data.Prompts.MentalPrompts;
import tracker.Data.Prompts.PromptResults;
import tracker.MentalExceptions.ReadFileException;
import tracker.MentalExceptions.SaveFileException;
import com.codename1.io.Storage;

public class DataStorage {

    public DataStorage()
    {
    }

    public MentalPrompts LoadPrompts (String filename, int version) throws ReadFileException
    {
        Storage s = Storage.getInstance();
        MentalPrompts tempPrompts = new MentalPrompts();    // Make sure Util registers the class to read it in
        new MentalPrompt("this", "ispointless", null);

            tempPrompts = (MentalPrompts) s.readObject(filename);
            return tempPrompts;
    }


    public PromptResults LoadPromptResutls (String filename, int version) throws ReadFileException
    {
        Storage s = Storage.getInstance();
        PromptResults results = new PromptResults();    // Make sure Util registers the class to read it in
        return (PromptResults) s.readObject(filename);
    }

    public void SavePrompts (String filename, MentalPrompts prompts) throws SaveFileException
    {
        Storage s =  Storage.getInstance();
        s.writeObject(filename, prompts);
    }

    public void SavePromptResults (String filename, PromptResults results) throws SaveFileException
    {
        Storage s = Storage.getInstance();
        s.writeObject(filename, results);
    }
}
