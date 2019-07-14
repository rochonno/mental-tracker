/*******************************************************************************************
 * @author: Nolan Rochon
 * @date: 07/07/19
 * @project: Mental Health Tracker
 *
 * This exception is thrown when a file fails to load
 *******************************************************************************************/

package MentalTracker.MentalExceptions;

public class ReadFileException extends Exception {

    public ReadFileException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public ReadFileException(String message)
    {
        super(message);
    }

    public ReadFileException(Throwable cause)
    {
        super(cause);
    }

    public ReadFileException()
    {
        super();
    }
}
