/*******************************************************************************
 * @author: Nolan Rochon
 * @date: 07/07/19
 * @project: Mental Health Tracker
 *
 * This exception is thrown when a file fails to save
 ******************************************************************************/

package tracker.MentalExceptions;

public class SaveFileException extends Exception {

    public SaveFileException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public SaveFileException(final String message) {
        super(message);
    }

    public SaveFileException(final Throwable cause) {
        super(cause);
    }

    public SaveFileException() {
        super();
    }
}
