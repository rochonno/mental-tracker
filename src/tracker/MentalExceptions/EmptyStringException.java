/*******************************************************************************
 * @author: Nolan Rochon
 * @date: 07/07/19
 * @project: Mental Health Tracker
 *
 * This exception is thrown when a valid non-empty string is expected.
 * An empty string occurs instead.
 ******************************************************************************/

package tracker.MentalExceptions;

public class EmptyStringException extends Exception {

    public EmptyStringException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public EmptyStringException(final String message) {
        super(message);
    }

    public EmptyStringException(final Throwable cause) {
        super(cause);
    }

    public EmptyStringException() {
        super();
    }
}
