/**
 * Creates an abstract class that represents transportation.
 *
 * @author dsharma97
 * @version 11.0.12
 **/

public abstract class Transportation extends IllegalArgumentException {
    protected String company;
    protected int id;
    protected String departDate;
    protected String departTime;
    protected String arrivalTime;

    /**
     * Created Transportation with all required parameters.
     *
     * @param company transportation company
     * @param id id of vehicle
     * @param departDate date when vehicle departs in format "MM-DD-YYYY"
     * @param departTime time when vehicle departs in format "HHMM"
     * @param arrivalTime time when vehicle arrives in format "HHMM"
     * @throws IllegalArgumentException when parameters are null or id isn't 5 digits
     */
    public Transportation(String company, int id, String departDate, String departTime, String arrivalTime)
            throws IllegalArgumentException {
        try {
            if (company.equals("") || company == null || departDate.equals("") || departDate == null
                    || departTime.equals("") || departTime == null || arrivalTime.equals("") || arrivalTime == null) {
                throw new IllegalArgumentException();
            }
            if (id < 10000 || id > 99999) {
                throw new IllegalArgumentException();
            } else {
                this.company = company;
                this.id = id;
                this.departDate = departDate;
                this.departTime = departTime;
                this.arrivalTime = arrivalTime;
            }
        } catch (NullPointerException n) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * @return a string of information about Transportation
     */
    public String toString() {
        return company + "," + id + "," + departDate + "," + departTime + "," + arrivalTime;
    }

    /**
     * Checks if an object is equal to Transportation calling the equals method.
     *
     * @param obj is compared to Transportation calling the method if it is equal
     *
     * @return true or false depending on whether the objects are equal or not
     */
    public boolean equals(Object obj) {
        if (obj instanceof Transportation) {
            return ((Transportation) obj).company == company && ((Transportation) obj).id == id
                    && ((Transportation) obj).departDate == departDate
                    && ((Transportation) obj).departTime == departTime
                    && ((Transportation) obj).arrivalTime == arrivalTime;
        } else {
            return false;
        }
    }
}
