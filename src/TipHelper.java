/*
Dhruv Sharma
I like to play tennis and the keyboard.
 */
public class TipHelper {
    public static void main(String[] args) {

        double tipPercentage = 0.15; //doubles are the larger of the two floating point variables (float and double)
        double mealTotal = 20.17;
        int numberItemsOrdered = 3;
        String customerName = "Jacob";
        double totalTip = tipPercentage * mealTotal;
        double totalAmountPaid = totalTip + mealTotal;

        System.out.printf("The total tip was $%.2f!\n", totalTip);
        System.out.printf(customerName + " owes a total of $%.2f.\n", totalAmountPaid);
    }
}
