/**
 * Creates an exception for when an invalid booking has been made.
 *
 * @author dsharma97
 * @version 11.0.12
 **/

public class InvalidBookingException extends Exception {

    /**
     * Created an InvalidBookingException with all required parameters.
     *
     * @param message message to be displayed
     */
    public InvalidBookingException(String message) {
        super(message);
    }

    /**
     * Created an InvalidBookingException with the default parameter.
     */
    public InvalidBookingException() {
        this("Invalid booking type");
    }
}
