/**
 * Represents a type of loot, a type of coin, gained from plunder.
 *
 * @author dsharma97
 * @version 11.0.12
 **/

public class Coin extends Loot {
    private boolean heads;
    private int yearMade;
    private String material;

    /**
     * Creates a Coin with all required parameters.
     *
     * @param value how much the Coin is worth
     * @param heads whether the Coin is turned heads up
     * @param yearMade the year the Coin was made
     * @param material material the Coin is made out of
     */
    public Coin(double value, boolean heads, int yearMade, String material) {
        super(value);
        this.heads = heads;
        if (yearMade >= 0 && yearMade <= 1700) {
            this.yearMade = yearMade;
        } else {
            this.yearMade = 1700;
        }
        this.material = material;
    }

    /**
     * Creates a Coin with all required parameters except for value and material, which are pre-filled.
     *
     * @param heads whether the Coin is turned heads up
     * @param yearMade the year the Coin was made
     */
    public Coin(boolean heads, int yearMade) {
        this((3000.00 - yearMade) / 100.00, heads, yearMade, "Gold");
    }

    /**
     * @return a string of information about the Coin
     */
    public String toString() {
        return "A " + material + " coin made in " + yearMade + ". Heads side is up: " + heads + ".";
    }

    /**
     * Checks if an object is equal to the Coin calling the equals method.
     *
     * @param obj is compared to the Coin object calling the method if it is equal
     *
     * @return true or false depending on whether the objects are equal or not
     */
    public boolean equals(Object obj) {
        if (obj instanceof Coin) {
            return super.equals(obj) && ((Coin) obj).yearMade == yearMade && ((Coin) obj).material == material;
        } else {
            return false;
        }
    }

}
