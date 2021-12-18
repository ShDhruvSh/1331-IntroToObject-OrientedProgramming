/**
 * Represents a black cat, the companion of a witch.
 *
 * @author dsharma97
 * @version 11.0.12
 **/

public class BlackCat {
    private String name;
    private boolean familiar;

    /**
     * Creates a BlackCat with all required parameters.
     *
     * @param name black cat's name
     * @param familiar whether the black cat is a companion of a witch or not
     */
    public BlackCat(String name, boolean familiar) {
        this.name = name;
        this.familiar = familiar;
    }

    /**
     * Prints out whether the cat is familiar to a witch or not.
     */
    public void meow() {
        if (getFamiliar()) {
            System.out.println(name + " is a familiar");
        } else {
            System.out.println(name + " is not a familiar");
        }
    }

    //Getters
    /**
     * @return black cat's name
     */
    public String getName() {
        return name;
    }

    /**
     * @return black's familiarity
     */
    public boolean getFamiliar() {
        return familiar;
    }

    //Setters
    /**
     * @set black cat's name
     *
     * @param name replaces current name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @set black cat's familiarity
     *
     * @param familiar replaces current familiar
     */
    public void setFamiliar(boolean familiar) {
        this.familiar = familiar;
    }

}
