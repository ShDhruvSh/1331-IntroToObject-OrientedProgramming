/**
 * Creates a class that has many functions that deal with money.
 *
 * @author dsharma97
 * @version 11.0.12
 **/

public class Money {

    /**
     * Counts the total number of cents in the inputted ArrayList.
     *
     * @param cents ArrayList of cent values
     * @return the sum of all the values in cents
     */
    public static double countTotal(int[] cents) {
        int returnCount = 0;

        if (cents.length == 0) {
            return returnCount;
        } else {
            int[] centsReturn = new int[cents.length - 1];
            for (int i = 1; i < cents.length; i++) {
                centsReturn[i - 1] = cents[i];
            }
            return cents[0] / 100.0 + countTotal(centsReturn);
        }
    }

    /**
     * Finds the difference between the money required for purchase
     * and the sum of the cent values in an ArrayList.
     *
     * @param moneyReq money required to buy an item
     * @param cents ArrayList of cent values
     * @return difference between price and total cents
     */
    public static double findDifference(double moneyReq, int[] cents) {
        return (moneyReq - countTotal(cents));
    }

    /**
     * Finds the number of coins required to equal an inputted change value.
     *
     * @param change money to be converted into change
     * @return number of coins required to equal inputted change value
     */
    public static int makeChange(int change) {
        if (change >= 25) {
            return 1 + makeChange(change - 25);
        } else if (change >= 10) {
            return 1 + makeChange(change - 10);
        } else if (change >= 5) {
            return 1 + makeChange(change - 5);
        } else if (change >= 1) {
            return 1 + makeChange(change - 1);
        } else {
            return 0;
        }
    }

    /**
     * Finds the number of coins required to equal an inputted change value.
     * @param change money to be converted into change
     * @param coins ArrayList of possible coins that change amount will be converted into
     * @return number of coins required to equal inputted change value
     */
    public static int makeChange(int change, int[] coins) {
        if (coins.length <= 0) {
            return 0;
        } else if (change >= coins[0]) {
            return 1 + makeChange(change - coins[0], coins);
        } else if (change == 0) {
            return 0;
        } else {
            int[] newCoins = new int[coins.length - 1];
            for (int i = 1; i < coins.length; i++) {
                newCoins[i - 1] = coins[i];
            }
            return makeChange(change, newCoins);
        }
    }

}
