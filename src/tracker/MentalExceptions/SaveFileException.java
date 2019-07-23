package tracker.MentalExceptions;

/*******************************************************************************
 * @author Nolan Rochon
 *
 * This exception is thrown when a file fails to save
 ******************************************************************************/
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
