/*******************************************************************************************
 * @author: Nolan Rochon
 * @date: 07/07/19
 * @project: Mental Health Tracker
 *
 * Simple enum to hold the different data types that answers can be expected in.
 *******************************************************************************************/

package MentalTracker.DataPortions.Prompts;

public enum PromptDataType
{
    INT, DOUBLE, STRING, BOOL;

    public static PromptDataType FromInt (int x) {
        switch (x) {
            case 0: return INT;
            case 1: return DOUBLE;
            case 2: return STRING;
            case 3: return BOOL;
        }
        return null;
    }
}
