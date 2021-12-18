public class MoneyTester {
    public static void main(String[] args) {
        int[] cents = new int[4];
        int[] cents2 = new int[0];

        cents[0] = 9;
        cents[1] = 4;
        cents[2] = 5;
        cents[3] = 2;

        System.out.println(Money.countTotal(cents));

        System.out.println(Money.makeChange(22, cents));

        System.out.println(Money.makeChange(22, cents2));



    }
}
