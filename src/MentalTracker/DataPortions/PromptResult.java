/*******************************************************************************************
 * @author: Nolan Rochon
 * @date: 07/07/19
 * @project: Mental Health Tracker
 *
 * This class hold a single user result from a specific prompt.
 * Takes the result as a string, then attempts to parse it based on the data type
 *******************************************************************************************/
package MentalTracker.DataPortions;
import MentalTracker.MentalExceptions.EmptyStringException;

public class PromptResult {
    private String _PromptName;
    private DataType _ExpectedType;

    private String _StringResult;
    private int _IntResult;
    private double _DoubleResult;
    private boolean _BoolResult;
    private boolean _ValidResult;

    public PromptResult (String name, DataType expectedType, String result) throws EmptyStringException {
        if (name.isEmpty()) throw new EmptyStringException("Trying to create result with no name", new Throwable());

        _PromptName = name;
        _ExpectedType = expectedType;
        try {
            _ValidResult = parseResult(result);
        }
        catch (NumberFormatException ex)
        {
            _ValidResult = false;
        }

    }

    private boolean parseResult(String result)
    {
        switch (_ExpectedType)
        {
            case STRING: return true;

            case BOOL:
                int tempIntResult = Integer.parseInt(_StringResult);
                if (tempIntResult == 1)
                {
                    _BoolResult = true;
                    return true;
                }
                else if (tempIntResult == 0)
                {
                    return true;
                }
                break;

            case INT:
                _IntResult = Integer.parseInt(_StringResult);
                return true;

            case DOUBLE:
                _DoubleResult = Double.parseDouble(_StringResult);
                return true;
        }
        return false;
    }
}
