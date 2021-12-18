import java.util.Arrays;
import java.util.Iterator;

public class LinkedListDriver<E> {
    public static void main(String[] args) {
        LinkedList<String> l = new LinkedList();
        LinkedList<String> l1 = new LinkedList();
        l.add("lol"); //0
        l.add("bruh"); //1
        l.add("BRO"); //2 -> 3
        l.add("lol2"); //3 -> 4

        l.add(2, "lol BRUH"); //2

        l.add(5, "lol bro"); //5

        l.add("lol3"); //6


        System.out.println(l.get(0));
        System.out.println(l.get(1));
        System.out.println(l.get(2));
        System.out.println(l.get(3));
        System.out.println(l.get(4));
        System.out.println(l.get(5));
        System.out.println(l.get(6));
        System.out.println("-------------------------");




        //Remove
        l.remove(0);

        l.remove(3);

        System.out.println(l.get(0));
        System.out.println(l.get(1));
        System.out.println(l.get(2));
        System.out.println(l.get(3));
        System.out.println(l.get(4));
        System.out.println("-------------------------");



        l.remove("lol BRUH");
        System.out.println(l.get(0));
        System.out.println(l.get(1));
        System.out.println(l.get(2));
        System.out.println(l.get(3));
        System.out.println("-------------------------");

        l.remove("BRO");
        System.out.println(l.get(0));
        System.out.println(l.get(1));
        System.out.println(l.get(2));
        System.out.println("-------------------------");

        System.out.println(l.contains("BRO"));
        System.out.println(l.contains("lol bro"));
        System.out.println(l.contains("l"));
        System.out.println("-------------------------");


        l.set(0, "bruh");
        l.set(1, "lol bruh");
        System.out.println(l.get(0));
        System.out.println(l.get(1));
        System.out.println(l.get(2));
        System.out.println("-------------------------l2");


        l1.add("lol"); //0
        l1.add("bruh"); //1
        l1.add("BRO"); //2
        l1.add("lol2"); //3
        l1.add("lol"); //4
        l1.add("bruh"); //5
        l1.add("lol3"); //6
        l1.add("lol"); //7

        System.out.println(l1.get(0));
        System.out.println(l1.get(1));
        System.out.println(l1.get(2));
        System.out.println(l1.get(3));
        System.out.println(l1.get(4));
        System.out.println(l1.get(5));
        System.out.println(l1.get(6));
        System.out.println(l1.get(7));
        System.out.println("-------------------------");


        l1.removeDuplicates();

        System.out.println(l1.get(0));
        System.out.println(l1.get(1));
        System.out.println(l1.get(2));
        System.out.println(l1.get(3));
        System.out.println(l1.get(4));
        System.out.println("-------------------------");

        System.out.println("Array:");
        Object[] l1arr = l1.toArray();
        for (int i = 0; i < l1arr.length; i++) {
            System.out.println(l1arr[i]);
        }

        System.out.println("-------------------------");
        LinkedList<String> l2 = new LinkedList();
        l2.add("A");
        l2.add("B");
        l2.add("C");
        l2.add("D");
        l2.add(0, "E");

        System.out.println(l2.get(0));
        System.out.println(l2.get(1));
        System.out.println(l2.get(2));
        System.out.println(l2.get(3));
        System.out.println(l2.get(4));


        System.out.println(l2.contains(l2.get(0)));
        System.out.println(l2.contains(l2.get(1)));
        System.out.println(l2.contains(l2.get(2)));
        System.out.println(l2.contains(l2.get(3)));
        System.out.println(l2.contains(l2.get(4)));
        System.out.println("-------------------------");

        LinkedList<String> l3 = new LinkedList();
        l3.add("A");
        l3.add("A");
        l3.add("A");
        l3.add("A");

        l3.removeDuplicates();

        System.out.println(Arrays.toString(l3.toArray()));

        System.out.println(l3.get(0));

        System.out.println(l3.size());

        Iterator i1 = l3.iterator();

        while(i1.hasNext()) {
            System.out.println(i1.next());
        }

        l3.add("B");
        l3.add("B");
        l3.add("A");

        Iterator i2 = l3.iterator();




        l3.removeDuplicates();

        while(i2.hasNext()) {
            System.out.println(i2.next());
        }

        System.out.println(Arrays.toString(l3.toArray()));


        //System.out.println(l3.get(0));
        //System.out.println(l3.get(1));
        //System.out.println(l3.size());

        System.out.println("-------------------------");
        LinkedList<String> l4 = new LinkedList();
        l4.add("A");
        l4.add(0, "B");

        System.out.println(l4.get(0));
        System.out.println(l4.get(1));
        System.out.println("-------------------------");


        LinkedList<String> l5 = new LinkedList();

        l5.add("A");
        l5.add("A");
        l5.add("A");
        l5.add("A");

        Iterator i = l5.iterator();

        System.out.println(i.hasNext());
        i.next();
        System.out.println(i.hasNext());
        i.next();
        System.out.println(i.hasNext());
        i.next();
        System.out.println(i.hasNext());
        i.next();
        System.out.println(i.hasNext());
        System.out.println("-------------------------");

        //l.remove("lolBRUH");





    }
}
