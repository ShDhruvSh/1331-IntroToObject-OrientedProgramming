/**
 * Represents a ghost who is a trick-or-treater dressed up as a shost.
 *
 * @author dsharma97
 * @version 11.0.12
 **/


public class Ghost extends TrickOrTreater {
    private int transparency;

    /**
     * Creates a Ghost with all required parameters.
     *
     * @param name Ghost's name
     * @param neighborhood Ghost's neighborhood
     * @param numCandy Ghost's number of candy
     * @param transparency how transparent the Ghost is
     */
    public Ghost(String name, String neighborhood, int numCandy, int transparency) {
        super(name, neighborhood, numCandy);
        this.transparency = transparency;
    }

    /**
     * Creates a Ghost with all parameters besides transparency set to the super class' defaults.
     *
     * @param transparency how transparent the Ghost is
     */
    public Ghost(int transparency) {
        super();
        this.transparency = transparency;
    }

    /**
     * Copies a Ghost from another Ghost.
     *
     * @param other the other Ghost to be copied from
     */
    public Ghost(Ghost other) {
        this(other.getName(), other.getNeighborhood(), other.getNumCandy(), other.getTransparency());
    }

    /**
     * Shows how spooky a Ghost looks based off of it's transparency.
     */
    public void spook() {
        if (transparency >= 10) {
            System.out.println("Very spooky");
        } else if (transparency >= 3 && transparency <= 9) {
            System.out.println("Boo!");
        } else if (transparency <= 2) {
            System.out.println("Not very spooky");
        }
    }

    //Getters
    /**
     * @return Ghost's transparency
     */
    public int getTransparency() {
        return transparency;
    }

    /**
     * @set Ghost's transparency
     *
     * @param transparency replaces current transparency
     */
    //Setters
    public void setTransparency(int transparency) {
        this.transparency = transparency;
    }
}
