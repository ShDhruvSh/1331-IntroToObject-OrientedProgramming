public class TestLoot {
    public static void main(String[] args) {
        Loot c1 = new Coin(3,true,1000,"Silver");
        Coin c2 = new Coin(false,600);

        Loot s1 = new Sugar(21,32);
        Sugar s2 = new Sugar(30,45);

        Plunderable sh1 = new Ship();
        Ship sh2 = new Ship();

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(sh1);
        System.out.println(sh2);
    }
}
