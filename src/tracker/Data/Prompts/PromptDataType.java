package tracker.Data.Prompts;

/*******************************************************************************
 * Simple enum to hold the different data types that answers can be expected in.
 *
 * @author Nolan Rochon
 ******************************************************************************/
public enum PromptDataType {
    /**
     * Expected form of data of the user's answers.
     */
    INT, DOUBLE, STRING, BOOL;

    public static PromptDataType fromInt(final int x) {
        switch (x) {
            case 0: return INT;
            case 1: return DOUBLE;
            case 2: return STRING;
            case 3: return BOOL;
            default: break;
        }
        return null;
    }
}
