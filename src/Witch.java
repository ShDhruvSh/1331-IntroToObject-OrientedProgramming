/**
 * Represents a witch who is a trick-or-treater dressed up as a witch.
 *
 * @author dsharma97
 * @version 11.0.12
 **/

public class Witch extends TrickOrTreater {
    private String signatureSpell;
    private BlackCat companion;

    /**
     * Creates a Witch with all required parameters.
     *
     * @param name Witch's name
     * @param neighborhood Witch's neighborhood
     * @param numCandy Witch's number of candy
     * @param signatureSpell the signature spell of the Witch that allows her to get more candy
     * @param companion the Witch's companion black cat
     */
    public Witch(String name, String neighborhood, int numCandy, String signatureSpell, BlackCat companion) {
        super(name, neighborhood, numCandy);
        this.signatureSpell = signatureSpell;
        this.companion = companion;
    }

    /**
     * Creates a Witch with the neighborhood "Godric's Hollow" and numCandy of 13.
     *
     * @param name Witch's name
     * @param signatureSpell the signature spell of the Witch that allows her to get more candy
     * @param companion the Witch's companion black cat
     */
    public Witch(String name, String signatureSpell, BlackCat companion) {
        this(name, "Godric's Hollow", 13, signatureSpell, companion);
    }

    /**
     * Creates a deep copy of a Witch.
     *
     * @param other the Witch that is being deep copied
     */
    public Witch(Witch other) {
        this(other.getName(), other.getNeighborhood(), other.getNumCandy(), other.getSignatureSpell(),
                new BlackCat(other.getCompanion().getName(), other.getCompanion().getFamiliar()));
    }

    /**
     * Prints the spell and doubles the Witch's candy.
     */
    public void castSpell() {
        System.out.println(getName() + " casts " + getSignatureSpell() + "!");
        setNumCandy(2 * getNumCandy());
    }

    //Getters
    /**
     * @return Witch's signatureSpell
     */
    public String getSignatureSpell() {
        return signatureSpell;
    }

    /**
     * @return Witch's companion
     */
    public BlackCat getCompanion() {
        return companion;
    }

    //Setters
    /**
     * @set Witch's signatureSpell
     *
     * @param signatureSpell replaces current signatureSpell
     */
    public void setSignatureSpell(String signatureSpell) {
        this.signatureSpell = signatureSpell;
    }

    /**
     * @set Witch's companion
     *
     * @param companion replaces current companion
     */
    public void setCompanion(BlackCat companion) {
        this.companion = companion;
    }
}
