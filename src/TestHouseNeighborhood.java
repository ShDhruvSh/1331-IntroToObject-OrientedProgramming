public class TestHouseNeighborhood {
    public static void main(String[] args) {
        House house1 = new House();
        House house2 = new House("iehrni", 1.5);



        Neighborhood neigh1 = new Neighborhood();
        System.out.println(neigh1.getNumHouses());

        neigh1.addHouse(3, house1);
        neigh1.addHouse(4, house2);


        System.out.println(neigh1.getNumHouses());

        neigh1.displayNewHouses(1984);
        System.out.println(neigh1.isFull());

        //Filling neigh1 with same house
        neigh1.addHouse(0, house1);
        neigh1.addHouse(1, house1);
        neigh1.addHouse(2, house1);
        neigh1.addHouse(4, house1);

        System.out.println(neigh1.isFull());

        System.out.println(neigh1.removeHouse(5)); //return null because index error
        neigh1.removeHouse(3);


        Neighborhood neigh2 = new Neighborhood(neigh1.getHouses());
        System.out.println(neigh2.getNumHouses());

    }
}
