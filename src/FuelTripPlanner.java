public class FuelTripPlanner {
    public static void main(String[] args) {
        int backRoadMiles = 25;
        int highwayMiles = 60;
        int hillyMiles = 10;
        int currentGasGallons = 20;
        int numberOfPeople = 5;
        double gallonsPerPerson = 0;

        gallonsPerPerson += backRoadMiles * 2; //2 gal/mile  on back roads
        gallonsPerPerson += highwayMiles * 1; //1 gal/mile  on highways
        gallonsPerPerson += hillyMiles *5; //5 gal/mile  on hilly roads
        gallonsPerPerson -= currentGasGallons; //as already in the car
        gallonsPerPerson /= numberOfPeople; //divide per person

        System.out.printf("Each passenger is responsible for %.1f gallons of gas.\n", gallonsPerPerson);
    }
}
