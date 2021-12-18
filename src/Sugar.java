/**
 * Represents a type of loot, sugar, gained from plunder.
 *
 * @author dsharma97
 * @version 11.0.12
 **/

public class Sugar extends Loot {
    private double amount;
    private double sweetness;

    /**
     * Creates Sugar with all required parameters.
     *
     * @param amount how Sugar there is
     * @param sweetness how sweet the Sugar is (and hence it's value)
     */
    public Sugar(double amount, double sweetness) {
        this.amount = amount;
        if (sweetness >= 0 && sweetness <= 100) {
            this.sweetness = sweetness;
        } else {
            this.sweetness = 0;
        }
        setValue(amount * sweetness);
    }

    /**
     * @return a string of information about the Sugar
     */
    public String toString() {
        return "A pile of sugar of size " + amount + " and sweetness " + sweetness + ".";
    }

    /**
     * Checks if an object is equal to the Sugar calling the equals method.
     *
     * @param obj is compared to the Sugar object calling the method if it is equal
     *
     * @return true or false depending on whether the objects are equal or not
     */
    public boolean equals(Object obj) {
        if (obj instanceof Sugar) {
            return super.equals(obj) && ((Sugar) obj).amount == amount && ((Sugar) obj).sweetness == sweetness;
        } else {
            return false;
        }
    }

}
