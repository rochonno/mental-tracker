/*******************************************************************************
 * @author: Nolan Rochon
 * @date: 07/07/19
 * @project: Mental Health Tracker
 *
 * This exception is thrown when a file fails to load
 ******************************************************************************/

package tracker.MentalExceptions;

public class ReadFileException extends Exception {

    public ReadFileException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ReadFileException(final String message) {
        super(message);
    }

    public ReadFileException(final Throwable cause) {
        super(cause);
    }

    public ReadFileException() {
        super();
    }
}
