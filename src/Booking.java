import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Creates a class that allows one to read and write to the database.
 *
 * @author dsharma97
 * @version 11.0.12
 **/

public class Booking {
    /**
     * Reads a file to make a Transportation ArrayList.
     *
     * @param fileName name of file to be read
     * @return an Transportation ArrayList of Transportation elements
     * @throws FileNotFoundException if file not found
     * @throws InvalidBookingException if booking type is invalid
     */
    public static ArrayList<Transportation> outputBookings(String fileName)
            throws FileNotFoundException, InvalidBookingException {
        if (fileName == null) {
            throw new FileNotFoundException();
        }
        File myFile = new File(fileName);
        ArrayList<Transportation> tList = new ArrayList<Transportation>();
        if (myFile.exists() && myFile.isFile() && myFile.canRead()) {
            Scanner s = new Scanner(myFile);
            s.useDelimiter(",");
            String currentTransportation = "";
            while (s.hasNextLine()) {
                currentTransportation = s.next();
                if (currentTransportation.equals("Flight")) {
                    tList.add(new Flight(s.next(), Integer.parseInt(s.next()), s.next(),
                            s.next(), s.next(), Integer.parseInt(s.nextLine().substring(1))));
                } else if (currentTransportation.equals("Bus")) {
                    tList.add(new Bus(s.next(), Integer.parseInt(s.next()), s.next(),
                            s.next(), s.next(), Integer.parseInt(s.nextLine().substring(1))));
                } else {
                    throw new InvalidBookingException();
                }
            }
        } else {
            throw new FileNotFoundException();
        }
        return tList;
    }

    /**
     * Writes from a Transportation ArrayList to a file.
     *
     * @param fileName name of file to be written to
     * @param tList Transportation ArrayList to be written to file
     * @return whether write was successful or not
     * @throws FileNotFoundException if file not found
     * @throws InvalidBookingException if booking type is invalid
     */
    public static boolean writeBookings(String fileName, ArrayList<Transportation> tList)
            throws FileNotFoundException, InvalidBookingException {
        ArrayList<Transportation> tListOriginal = Booking.outputBookings(fileName);
        try {
            PrintWriter outWriter = new PrintWriter(fileName);
            File myFile = new File(fileName);
            Scanner s = new Scanner(myFile);


            for (int i = 0; i < tListOriginal.size(); i++) {
                outWriter.append(tListOriginal.get(i).toString() + "\n");
            }
            for (int i = 0; i < tList.size(); i++) {
                outWriter.append(tList.get(i) + "\n");
            }
            outWriter.close();
            return true;
        } catch (FileNotFoundException f) {
            return false;
        }
    }

    /**
     * Reads a file to make an Integer ArrayList of line numbers of a certain Transportation.
     *
     * @param fileName name of file to be read
     * @param transportation Transportation to be checked
     * @return Integer ArrayList of line numbers where the certain Transportation exists in file
     * @throws FileNotFoundException if file not found
     * @throws InvalidBookingException if booking type is invalid
     */
    public static ArrayList<Integer> readBookings(String fileName, Transportation transportation)
            throws FileNotFoundException, InvalidBookingException {
        File myFile = new File(fileName);
        ArrayList<Integer> integerList = new ArrayList<Integer>();

        if (myFile.exists() && myFile.isFile()) {
            Scanner s = new Scanner(myFile);
            int lineCount = 0;
            String currentTransportation = "";
            while (s.hasNextLine()) {
                lineCount++;
                currentTransportation = s.nextLine();
                if (currentTransportation.toString().equals(transportation.toString())) {
                    integerList.add(lineCount);
                }
            }
            if (integerList.isEmpty()) {
                throw new InvalidBookingException();
            }
        } else {
            throw new FileNotFoundException();
        }
        return integerList;
    }

    /**
     * Testing the classes Booking.java, Transportation.java, Flight.java, Bus.java, and InvalidBookingException.java.
     *
     * @param args allows psvm to run
     * @throws FileNotFoundException if file not found
     * @throws InvalidBookingException if booking type is invalid
     */
    public static void main(String[] args) throws FileNotFoundException, InvalidBookingException {
        Flight f1 = new Flight("Southwest", 12345, "01-01-2021",
                "1200", "0300", 2);
        Flight f2 = new Flight("Delta", 54321, "02-02-2021",
                "0100", "0400", 3);
        Flight f3 = new Flight("Spirit", 98765, "03-03-2021",
                "0200", "0500", 4);

        Bus b1 = new Bus("Greyhound", 33333, "07-27-2021",
                "0400", "0500", 5);
        Bus b2 = new Bus("Megabus", 99999, "08-28-2021",
                "0500", "0600", 6);

        ArrayList<Transportation> t1 = new ArrayList<>();
        t1.add(f1);
        t1.add(f2);
        t1.add(b1);
        t1.add(b2);


        System.out.println(Booking.writeBookings("TestBooking.csv", t1));

        System.out.println(Booking.outputBookings("TestBooking.csv"));

        ArrayList<Transportation> t2 = new ArrayList<Transportation>();
        t2.add(f3);
        System.out.println(Booking.writeBookings("TestBooking.csv", t2));

        System.out.println(Booking.readBookings("TestBooking.csv", f2));
    }
}
