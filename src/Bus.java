/**
 * Creates a bus that is a form of transportation.
 *
 * @author dsharma97
 * @version 11.0.12
 **/

public class Bus extends Transportation {
    private int stops;

    /**
     * Created Bus with all required parameters.
     *
     * @param company transportation company
     * @param id id of vehicle
     * @param departDate date when vehicle departs in format "MM-DD-YYYY"
     * @param departTime time when vehicle departs in format "HHMM"
     * @param arrivalTime time when vehicle arrives in format "HHMM"
     * @param stops number of places the bus stops
     * @throws IllegalArgumentException when stops is negative
     */
    public Bus(String company, int id, String departDate, String departTime, String arrivalTime, int stops)
            throws IllegalArgumentException {
        super(company, id, departDate, departTime, arrivalTime);
        if (stops < 0) {
            throw new IllegalArgumentException();
        } else {
            this.stops = stops;
        }
    }

    /**
     * @return a string of information about Bus
     */
    public String toString() {
        return "Bus" + "," + super.toString() + "," + stops;
    }

    /**
     * Checks if an object is equal to Bus calling the equals method.
     *
     * @param obj is compared to Bus calling the method if it is equal
     * @return true or false depending on whether the objects are equal or not
     */
    public boolean equals(Object obj) {
        if (obj instanceof Bus) {
            return ((Bus) obj).stops == stops
                    && super.equals(obj);
        } else {
            return false;
        }
    }
}
