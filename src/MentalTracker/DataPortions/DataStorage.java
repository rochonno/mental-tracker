package MentalTracker.DataPortions;

import MentalTracker.MentalExceptions.ReadFileException;
import MentalTracker.MentalExceptions.SaveFileException;
import com.codename1.io.Storage;

import java.io.*;

public class DataStorage {

    public DataStorage()
    {
    }

    public MentalPrompts LoadPrompts (String filename, int version) throws ReadFileException
    {
        try ( InputStream iStream = Storage.getInstance().createInputStream(filename)) {
            DataInputStream iDataStream = new DataInputStream(iStream);

            MentalPrompts prompts = new MentalPrompts();
            prompts.internalize(version, iDataStream);
            return prompts;
        }
        catch (IOException err) {
            throw new ReadFileException("Failed to read prompts file: " + filename, new Throwable());
        }
    }

    public PromptResults LoadPromptResutls (String filename, int version) throws ReadFileException
    {
        try ( InputStream iStream = Storage.getInstance().createInputStream(filename)) {
            DataInputStream iDataStream = new DataInputStream(iStream);

            PromptResults results = new PromptResults();
            results.internalize(version, iDataStream);
            return results;
        }
        catch (IOException ex) {
            throw new ReadFileException("Failed to read results file: " + filename, new Throwable(ex));
        }
    }

    public void SavePrompts (String filename, MentalPrompts prompts) throws SaveFileException
    {
        try (OutputStream oStream = Storage.getInstance().createOutputStream(filename)) {
            DataOutputStream oDataStream = new DataOutputStream(oStream);

            prompts.externalize(oDataStream);
        }
        catch (IOException ex) {
            throw new SaveFileException("Failed to save prompts file: " + filename, new Throwable(ex));
        }
    }

    public void SavePromptResults (String filename, PromptResults results) throws SaveFileException
    {
        try (OutputStream oStream = Storage.getInstance().createOutputStream( filename )) {
            DataOutputStream oDataStream = new DataOutputStream(oStream);

            results.externalize(oDataStream);
        }
        catch (IOException ex) {
            throw new SaveFileException("Failed to save results file: " + filename, new Throwable(ex));
        }
    }
}
