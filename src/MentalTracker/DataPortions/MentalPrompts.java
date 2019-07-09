/*******************************************************************************************
 * @author: Nolan Rochon
 * @date: 07/07/19
 * @project: Mental Health Tracker
 *
 * This class holds a list of all the prompts and manages it accordingly
 *******************************************************************************************/

package MentalTracker.DataPortions;

import java.util.*;

public class MentalPrompts implements Externalizable {
    private List<MentalPrompt> Prompts;

    public MentalPrompts()
    {
        Prompts = new Vector<MentalPrompt>();
    }

    public void add(MentalPrompt prompt)
    {
        Prompts.add (prompt);
    }

    public boolean remove(MentalPrompt prompt)
    {
        return Prompts.remove(prompt);
    }
}
