/**
 * Represents a ship with cargo.
 *
 * @author dsharma97
 * @version 11.0.12
 **/

public class Ship implements Plunderable {
    private Loot[] cargo;
    private double totalCargoValue;
    private String name;

    /**
     * Creates a Ship with all required parameters.
     *
     * @param name name of Ship
     */
    public Ship(String name) {
        this.name = name;
        totalCargoValue = 0;
        cargo = new Loot[10];
    }

    /**
     * Creates a Ship with name preset to "Black Pearl".
     */
    public Ship() {
        this("Black Pearl");
    }

    /**
     * @return a string of information about the Ship
     */
    public String toString() {
        String toBeReturned = "A ship called " + name + " with cargo ";
        for (int i = 0; i < cargo.length; i++) {
            if (cargo[i] != null) {
                toBeReturned += cargo[i].toString() + ", ";
            }
        }
        toBeReturned += "which has a total value of " + (Math.round(totalCargoValue / 100.00) / 100.00) + ".";

        return toBeReturned;
    }

    /**
     * Adds a cargo item to the Ship.
     *
     * @param newItem the new Loot item being added to Ship.
     */
    public void addCargo(Loot newItem) {
        totalCargoValue += newItem.getValue();
        int freeIndex = -1; //value of first available index slot in array
        for (int i = 0; i < cargo.length; i++) {
            if (cargo[i] == null) {
                freeIndex = i;
                break;
            }
        }
        if (freeIndex == -1) {
            Loot[] newCargo = new Loot[cargo.length * 2];
            for (int i = 0; i < cargo.length; i++) {
                newCargo[i] = cargo[i];
            }
            newCargo[cargo.length] = newItem;
            cargo = newCargo;
        } else {
            cargo[freeIndex] = newItem;
        }
    }

    /**
     * Removes the first available cargo item from the Ship.
     *
     * @return the removed item or null
     */
    public Loot removeCargo() {
        for (int i = 0; i < cargo.length; i++) {
            if (cargo[i] != null) {
                Loot remove = cargo[i];
                totalCargoValue -= cargo[i].getValue();
                cargo[i] = null;
                return remove;
            }
        }
        return null;
    }

    /**
     * Removes a specific cargo item from the Ship.
     *
     *
     * @param cargoItem the item to be removed
     * @return the removed item or null
     */
    public Loot removeCargo(Loot cargoItem) {
        for (int i = 0; i < this.cargo.length; i++) {
            if (this.cargo[i].equals(cargoItem)) {
                Loot remove = this.cargo[i];
                totalCargoValue -= this.cargo[i].getValue();
                this.cargo[i] = null;
                return remove;
            }
        }
        return null;
    }

    /**
     * Plunders a ship.
     *
     *
     * @return an array of the the plundered loot
     */
    public Loot[] bePlundered() {
        totalCargoValue = 0;
        int numLoot = 0;
        for (int i = 0; i < cargo.length; i++) {
            if (cargo[i] != null) {
                numLoot++;
            }
        }
        Loot[] plunder = new Loot[numLoot];
        int curIndex = 0;
        for (int i = 0; i < cargo.length; i++) {
            if (cargo[i] != null) {
                plunder[curIndex] = cargo[i];
                curIndex++;
                cargo[i] = null;
            }
        }
        return plunder;
    }

}
