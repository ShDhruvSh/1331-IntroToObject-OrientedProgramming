import java.util.Random;

public class ShapesOfDunshire {
    public static void main(String[] args) {
        Random r = new Random();

        double finalVolume = 0;
        double volume = 0;
        double radius;
        double height;
        double price;
        int numPieces = r.nextInt(10)+10;
        System.out.printf("Creating Shapes of Dunshire game with %d pieces.%n", numPieces);

        for(int i = 0; i < numPieces; i++) {
            int shapeType = r.nextInt(3)+1;
            switch(shapeType) {
                //if it is a sphere
                case 1:
                    radius = r.nextDouble() * 5 + 5;
                    radius = Math.round(radius * 100.0)/100.0;
                    volume = (4.0 / 3.0) * Math.pow(radius, 3) * Math.PI;
                    volume = Math.round(volume * 100.0) / 100.0;
                    finalVolume += volume;
                    System.out.printf("Manufacturing shape of type: %d and volume: %.2f cm3. " +
                            "Dimensions: radius = %.2f cm.%n", shapeType, volume, radius);
                    break;
                //if it is a cylinder
                case 2:
                    radius = r.nextDouble() * 5 + 5;
                    radius = Math.round(radius * 100.0)/100.0;
                    height = r.nextDouble() * 6 + 7;
                    height = Math.round(height * 100.0)/100.0;
                    volume = Math.pow(radius, 2) * Math.PI * height;
                    volume = Math.round(volume * 100.0)/100.0;
                    finalVolume += volume;
                    System.out.printf("Manufacturing shape of type: %d and volume: %.2f cm3. " +
                            "Dimensions: radius = %.2f cm and height = %.2f cm.%n", shapeType, volume, radius, height);
                    break;
                //if it is a cone
                case 3:
                    radius = r.nextDouble() * 5 + 5;
                    radius = Math.round(radius * 100.0)/100.0;
                    height = r.nextDouble() * 6 + 7;
                    height = Math.round(height * 100.0)/100.0;
                    volume = (1.0 / 3.0) * Math.pow(radius, 2) * Math.PI * height;
                    volume = Math.round(volume * 100.0)/100.0;
                    finalVolume += volume;
                    System.out.printf("Manufacturing shape of type: %d and volume: %.2f cm3. " +
                            "Dimensions: radius = %.2f cm and height = %.2f cm.%n", shapeType, volume, radius, height);
                    break;
            }
        }

        //price calculations using final volume
        finalVolume = Math.round(finalVolume * 100.0)/100.0;
        price = Math.round((0.55 * finalVolume) * 100.00)/100.0;
        System.out.printf("Total cost of manufacturing %d pieces, worth %.2f cm3 plastic, is $%.2f.%n", numPieces, finalVolume, price);

    }

}

