/*******************************************************************************************
 * @author: Nolan Rochon
 * @date: 07/07/19
 * @project: Mental Health Tracker
 *
 * This exception is thrown when a valid non-empty string is expected but an empty string
 *      occurs instead.
 *******************************************************************************************/

package tracker.MentalExceptions;

public class EmptyStringException extends Exception {

    public EmptyStringException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public EmptyStringException(String message)
    {
        super(message);
    }

    public EmptyStringException(Throwable cause)
    {
        super(cause);
    }

    public EmptyStringException()
    {
        super();
    }
}
