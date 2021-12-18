/**
 * Represents a Conference League tournament: a new tournament mode run by UEFA.
 *
 * @author dsharma97
 * @version 11.0.12
 **/

public class ConferenceLeague extends Tournament {

    private int teamsPerLeague;
    private String currentHolder;

    /**
     * Creates a ConferenceLeague with all required parameters.
     *
     * @param finalReferee name of referee for final game of tournament
     * @param teamsPerLeague number of teams per league in ConferenceLeague
     * @param currentHolder name of team who won last
     */
    public ConferenceLeague(String finalReferee, int teamsPerLeague, String currentHolder) {
        super("Conference League", 32, true, finalReferee, 15000);
        this.teamsPerLeague = teamsPerLeague;
        this.currentHolder = currentHolder;
    }

    /**
     * @return a string of information about the ConferenceLeague
     */
    public String toString() {
        return "Name: " + getName() + ", Number of Teams: " + getNumTeams() + ", Final Referee: " + getFinalReferee()
                + ", Teams per League: " + teamsPerLeague + ", Current Holder: " + currentHolder;
    }

    /**
     * Checks if an object is equal to the ConferenceLeague calling the equals method.
     *
     * @param obj is compared to the ConferenceLeague object calling the method if it is equal
     *
     * @return true or false depending on whether the objects are equal or not
     */
    public boolean equals(Object obj) {
        if (obj instanceof ConferenceLeague) {
            return ((ConferenceLeague) obj).getFinalReferee() == getFinalReferee()
                    && ((ConferenceLeague) obj).currentHolder == currentHolder;
        } else {
            return false;
        }
    }

    /**
     * Changes up the ConferenceLeague settings in preparation for the next round.
     */
    public void nextRound() {
        if (getKnockout()) {
            if (getNumTeams() > 2) {
                setNumTeams(getNumTeams() / 2);
            } else {
                System.out.println("We have reached the final!");
                if (getMaxCapacity() > getFinalCapacity()) {
                    setMaxCapacity(getFinalCapacity());
                }
            }
        }
    }

    /**
     * Hires a referee and checks to see if the hired referee isn't an already saved referee.
     *
     * @param ref is the referee being hired
     */
    public void refereeHire(String ref) {
        if (ref.equals(getFinalReferee())) {
            System.out.println("We need a new referee!");
            setFinalReferee("Undecided");
        } else {
            System.out.println("We’re ready to go!");
            setMaxCapacity(getMaxCapacity() * 2);
        }
    }
}
