/**
 * Represents a trick-or-treater, the super class of other specific trick-or-treaters.
 *
 * @author dsharma97
 * @version 11.0.12
 **/


public class TrickOrTreater {
    protected String name;
    protected String neighborhood;
    protected int numCandy;
    protected static int totalCandy;

    /**
     * Creates a TrickOrTreater with all required parameters.
     *
     * @param name trick-or-treater's name
     * @param neighborhood trick-or-treater's neighborhood
     * @param numCandy trick-or-treater's number of candy
     */
    public TrickOrTreater(String name, String neighborhood, int numCandy) {
        this.name = name;
        this.neighborhood = neighborhood;
        this.numCandy = numCandy;
        totalCandy += numCandy;
    }

    /**
     * Creates a TrickOrTreater with a name "Agnes", neighborhood "Halloweentown", and 0 candy.
     */
    public TrickOrTreater() {
        this("Agnes", "Halloweentown", 0);
    }

    /**
     * Increases numCandy when trick-or-treater pursues candy.
     *
     * @param luck how lucky the trick-or-treater is when getting more candy
     *        (multiplied by 3 and added to numCandy and totalCandy)
     */
    public void seekCandy(int luck) {
        numCandy += 3 * luck;
        totalCandy += 3 * luck;
    }

    //Getters
    /**
     * @return trick-or-treater's name
     */
    public String getName() {
        return name;
    }

    /**
     * @return trick-or-treater's neighborhood
     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**
     * @return trick-or-treater's number of candy
     */
    public int getNumCandy() {
        return numCandy;
    }

    /**
     * @return total candy of all trick-or-treaters
     */
    public static int getTotalCandy() {
        return totalCandy;
    }

    //Setters
    /**
     * @set trick-or-treater's name
     *
     * @param name replaces curent name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @set trick-or-treater's neighborhood
     *
     * @param neighborhood replaces current neighborhood
     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    /**
     * @set trick-or-treater's number of candy
     *
     * @param numCandy replaces current numCandy if it is greater than numCandy
     */
    public void setNumCandy(int numCandy) {
        if (numCandy > this.numCandy) {
            this.totalCandy += numCandy - this.numCandy;
            this.numCandy = numCandy;

        }
    }
    /**
     * @set total candy of all trick-or-treaters
     *
     * @param totCandy replaces totalCandy if it is greater than totalCandy
     */
    public static void setTotalCandy(int totCandy) {
        if (totCandy > totalCandy) {
            totalCandy = totCandy;
        }
    }
}
