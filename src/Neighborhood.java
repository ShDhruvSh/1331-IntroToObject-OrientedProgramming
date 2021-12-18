public class Neighborhood {
    private int numHouses;
    private House[] houses;

    public Neighborhood(House[] houses) {
        this.houses = houses;
        numHouses = 0;
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] != null) {
                numHouses++;
            }
        }
    }

    public Neighborhood() {
        this(new House[5]);
    }

    public void displayNewHouses(int year) {
        for (int i = 0; i < houses.length; i++) {
            String hasOrNot;
            if (houses[i] != null) {
                if (houses[i].getYearBuilt() == year) {
                    if (houses[i].getIsRenovated()) {
                        hasOrNot = "has";
                    } else {
                        hasOrNot = "has not";
                    }
                    System.out.printf("House located at %s was built in "
                                    + "%d, has %.1f number of bathrooms, and %s been renovated "
                                    + "recently.%n", houses[i].getAddress(), houses[i].getYearBuilt(),
                            houses[i].getNumBaths(), hasOrNot);
                }
            }
        }
    }

    public House addHouse(int index, House house) {
        //index can only be between 0 and the length of the array - 1
        if (index > houses.length - 1 || index < 0 || house == null) {
            return null;
        } else if (houses[index] != null) {
            House temp = houses[index];
            houses[index] = house;
            return temp;
        } else {
            houses[index] = house;
            numHouses++;
            return null;
        }
    }

    public House removeHouse(int index) {
        if (index > houses.length - 1 || index < 0 || houses[index] == null) {
            return null;
        } else {
            House temp = houses[index];
            houses[index] = null;
            numHouses--;
            return temp;
        }
    }

    public boolean isFull() {
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                return false;
            }
        }
        return true;
    }

    //Getters
    public House[] getHouses() {
        return this.houses;
    }

    public int getNumHouses() {
        return this.numHouses;
    }

    //Setters
    private void setHouses(House[] houses) {
        this.houses = houses;
    }

    private void setNumHouses(int numHouses) {
        this.numHouses = numHouses;
    }
}
