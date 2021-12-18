/**
 * This is the driver of the Witch, Ghost, TrickOrTreater, and BlackCat classes.
 *
 * @author dsharma97
 * @version 11.0.12
 **/


public class HappyHalloween {

    /**
     * This is the main method of the driver.
     *
     * @param args makes making a driver class easier
     **/
    public static void main(String[] args) {
        TrickOrTreater t = new TrickOrTreater();

        BlackCat b1 = new BlackCat("b1", true);
        BlackCat b2 = new BlackCat("b2", true);
        BlackCat b3 = new BlackCat("b3", true);


        Witch w1 = new Witch("w1", "Hokas Pokas", b1);
        Witch w2 = new Witch("w2", "1234 Bruh Dr, Atlanta, GA", 21, "Abra", b2);
        Witch w3 = new Witch(w2);

        Ghost g1 = new Ghost(10);
        Ghost g2 = new Ghost("g2", "4321 Bro St, Atlanta, GA", 42, 3);
        Ghost g3 = new Ghost(g2);

        g1.spook();
        g2.spook();
        g3.spook(); //same as g2

        g3.setTransparency(2);
        g2.spook(); //Boo
        g3.spook(); //Not very spooky

        System.out.println(g2.getTotalCandy());
        System.out.println(t.getTotalCandy());


        System.out.println(g2.getNumCandy());

        g1.seekCandy(1);
        g2.seekCandy(1);
        g3.seekCandy(1);

        System.out.println(w3.getCompanion().getName());
        w3.setCompanion(b3);
        System.out.println(w2.getCompanion().getName());
        System.out.println(w3.getCompanion().getName());

        System.out.println(Witch.getTotalCandy());
        w1.castSpell();
        System.out.println(Witch.getTotalCandy());

        b2.setName("Kitty");
        System.out.println(w2.getCompanion().getName());


        w1.seekCandy(1);
        w2.seekCandy(1);
        w3.seekCandy(1);

        System.out.println(g2.getTotalCandy());


    }


}
