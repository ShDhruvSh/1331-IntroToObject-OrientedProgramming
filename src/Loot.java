/**
 * Represents the loot gained from plunder.
 *
 * @author dsharma97
 * @version 11.0.12
 **/

public abstract class Loot {
    private double value;

    /**
     * Creates Loot with all required parameters (i.e. just the value).
     *
     * @param value how much the Loot is worth
     */
    public Loot(double value) {
        if (value > 0) {
            this.value = value;
        }
    }

    /**
     * Creates Loot with value = 0.
     */
    public Loot() {
        this(0);
    }

    /**
     * @return a string of information (the value) about the Loot
     */
    public String toString() {
        return "A piece of loot worth " + value;
    }

    /**
     * Checks if an object is equal to the Loot calling the equals method.
     *
     * @param obj is compared to the Loot object calling the method if it is equal
     *
     * @return true or false depending on whether the objects are equal or not
     */
    public boolean equals(Object obj) {
        if (obj instanceof Loot) {
            return ((Loot) obj).getValue() == getValue();
        } else {
            return false;
        }
    }

    //Getters
    /**
     * @return value of loot
     */
    public double getValue() {
        return value;
    }

    //Setters
    /**
     * @set the value of loot
     *
     * @param value of the loot now
     */
    public void setValue(double value) {
        this.value = value;
    }

}
