/**
 * Represents a tournament run by UEFA.
 *
 * @author dsharma97
 * @version 11.0.12
 **/

public abstract class Tournament {
    private String name;
    private int numTeams;
    private boolean knockout;
    private String finalReferee;
    protected int maxCapacity;
    private static final int FINAL_CAPACITY = 30000;

    /**
     * Creates a Tournament with all required parameters.
     *
     * @param name Tournament's name
     * @param numTeams number of teams in Tournament
     * @param knockout whether the Tournament is a knockout tournament or not
     * @param finalReferee name of referee for final game of tournament
     * @param maxCapacity maximum number of people in crowd for all stadiums
     */
    public Tournament(String name, int numTeams, boolean knockout, String finalReferee, int maxCapacity) {
        this.name = name;
        this.finalReferee = finalReferee;
        this.maxCapacity = maxCapacity;
        if (numTeams % 2 == 1) {
            this.numTeams = 16;
        } else {
            this.numTeams = numTeams;
        }
        if (numTeams > 64) {
            this.knockout = true;
        } else {
            this.knockout = knockout;
        }
    }
    /**
     * @return a string of information about the Tournament
     */
    public String toString() {
        String knockedOrNot;
        if (getKnockout()) {
            knockedOrNot = "this is a KO tournament";
        } else {
            knockedOrNot = "this isn't a KO tournament";
        }

        return "Name: " + getName() + ", Number of Teams: " + getNumTeams() + ", KO: "
                + knockedOrNot + ", Final Referee: " + getFinalReferee() + ", Maximum Capacity: " + getMaxCapacity();
    }

    /**
     * Checks if an object is equal to the Tournament calling the equals method.
     *
     * @param obj is compared to the Tournament object calling the method if it is equal
     *
     * @return true or false depending on whether the objects are equal or not
     */
    public boolean equals(Object obj) {
        if (obj instanceof Tournament) {
            return ((Tournament) obj).getName() == getName() && ((Tournament) obj).getNumTeams() == getNumTeams()
                    && ((Tournament) obj).getKnockout() == getKnockout();
        } else {
            return false;
        }
    }

    /**
     * Abstract method that hires referees.
     *
     * @param ref is the referee being hired
     */
    public abstract void refereeHire(String ref);




    //Getters
    /**
     * @return Tournament's name
     */
    public String getName() {
        return name;
    }

    /**
     * @return number of teams in Tournament
     */
    public int getNumTeams() {
        return numTeams;
    }

    /**
     * @return whether the Tournament is a knockout tournament or not
     */
    public boolean getKnockout() {
        return knockout;
    }

    /**
     * @return name of referee for final game of tournament
     */
    public String getFinalReferee() {
        return finalReferee;
    }

    /**
     * @return maximum number of people in crowd for all stadiums
     */
    public int getMaxCapacity() {
        return maxCapacity;
    }

    /**
     * @return maximum number of people for final game
     */
    public int getFinalCapacity() {
        return FINAL_CAPACITY;
    }

    //Setters
    /**
     * @set Tournament's name
     *
     * @param name replaces current name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @set number of teams in Tournament
     *
     * @param numTeams replaces current numTeams if input is even
     */
    public void setNumTeams(int numTeams) {
        if (numTeams % 2 == 0) {
            this.numTeams = numTeams;
        }
    }

    /**
     * @set whether the Tournament is a knockout tournament or not
     *
     * @param knockout changes whether the tournament is knockout or not
     */
    public void setKnockout(boolean knockout) {
        this.knockout = knockout;
    }

    /**
     * @set name of referee for final game of tournament
     *
     * @param finalReferee replaces current final referee
     */
    public void setFinalReferee(String finalReferee) {
        this.finalReferee = finalReferee;
    }

    /**
     * @set maximum number of people in crowd for all stadiums
     *
     * @param maxCapacity replaces current maxCapacity
     */
    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
}