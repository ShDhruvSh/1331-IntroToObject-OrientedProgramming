/**
 * Creates a plane that is a form of transportation.
 *
 * @author dsharma97
 * @version 11.0.12
 **/

public class Flight extends Transportation {
    private int connectors;

    /**
     * Created Flight with all required parameters.
     *
     * @param company transportation company
     * @param id id of vehicle
     * @param departDate date when vehicle departs in format "MM-DD-YYYY"
     * @param departTime time when vehicle departs in format "HHMM"
     * @param arrivalTime time when vehicle arrives in format "HHMM"
     * @param connectors number of flights that are connecting to this one
     * @throws IllegalArgumentException when connectors is negative
     */
    public Flight(String company, int id, String departDate, String departTime, String arrivalTime, int connectors)
            throws IllegalArgumentException {
        super(company, id, departDate, departTime, arrivalTime);
        if (connectors < 0) {
            throw new IllegalArgumentException();
        } else {
            this.connectors = connectors;
        }
    }

    /**
     * @return a string of information about Flight
     */
    public String toString() {
        return "Flight" + "," + super.toString() + "," + connectors;
    }

    /**
     * Checks if an object is equal to Flight calling the equals method.
     *
     * @param obj is compared to Flight calling the method if it is equal
     *
     * @return true or false depending on whether the objects are equal or not
     */
    public boolean equals(Object obj) {
        if (obj instanceof Flight) {
            return ((Flight) obj).connectors == connectors && super.equals(obj);
        } else {
            return false;
        }
    }
}
