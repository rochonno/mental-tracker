package tracker.MentalExceptions;

/*******************************************************************************
 * @author Nolan Rochon
 *
 * This exception is thrown when a file fails to load
 ******************************************************************************/
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
