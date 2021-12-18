/**
 * Represents a Summer Showdown tournament: a new tournament mode run by UEFA.
 *
 * @author dsharma97
 * @version 11.0.12
 **/

public class SummerShowdown extends Tournament {
    private String backupReferee;

    /**
     * Creates a SummerShowdown with all required parameters.
     *
     * @param numTeams number of teams in SummerShowdown
     * @param knockout whether the SummerShowdown is a knockout tournament or not
     * @param finalReferee name of referee for final game of tournament
     * @param maxCapacity maximum number of people in crowd for all stadiums
     * @param backupReferee name of referee if final referee is already refereeing another final
     */
    public SummerShowdown(int numTeams, boolean knockout, String finalReferee, int maxCapacity, String backupReferee) {
        super("Summer Showdown", numTeams, knockout, finalReferee, maxCapacity);
        this.backupReferee = backupReferee;
    }

    /**
     * Creates a SummerShowdown with all parameters besides numTeams, knockout, and maxCapacity.
     *
     * @param finalReferee name of referee for final game of tournament
     * @param backupReferee name of referee if final referee is already refereeing another final
     */
    public SummerShowdown(String finalReferee, String backupReferee) {
        this(64, false, finalReferee, 20000, backupReferee);
    }

    /**
     * @return a string of information about the SummerShowdown
     */
    public String toString() {
        return "Name: " + getName() + ", Number of Teams: " + getNumTeams() + ", Final Referee: " + getFinalReferee()
                + ", Backup Referee: " + backupReferee + ", Maximum Capacity: " + getMaxCapacity();
    }

    /**
     * Checks if an object is equal to the SummerShowdown calling the equals method.
     *
     * @param obj is compared to the SummerShowdown object calling the method if it is equal
     *
     * @return true or false depending on whether the objects are equal or not
     */
    public boolean equals(Object obj) {
        if (obj instanceof SummerShowdown) {
            return ((SummerShowdown) obj).getFinalReferee() == getFinalReferee()
                    && ((SummerShowdown) obj).getMaxCapacity() == getMaxCapacity();
        } else {
            return false;
        }
    }

    /**
     * Hires a referee and checks to see if the hired referee isn't an already saved referee.
     *
     * @param ref is the referee being hired
     */
    public void refereeHire(String ref) {
        if (ref.equals(getFinalReferee())) {
            System.out.println("We need a new referee! " + getFinalReferee() + "is already refereeing the final!");
            backupReferee = "Undecided";
        } else if (ref.equals(backupReferee)) {
            System.out.println("Bereadyforsome conflicts!");
            setMaxCapacity(getMaxCapacity() / 2);
        } else {
            System.out.println("Ready to play!");
        }
    }
}
