/**
 * Represents a department of the office.
 *
 * @author dsharma97
 * @version 11.0.12
 **/

public class Department {

    private String name; //the name of the department
    private boolean hasFireExtinguisher; //indicates if the department has a fire extinguisher

    /**
     * Creates a Department with all required parameters.
     *
     * @param name name of Department
     * @param hasFireExtinguisher whether the Department has a fire extinguisher
     */
    public Department(String name, boolean hasFireExtinguisher) {
        this.name = name;
        this.hasFireExtinguisher = hasFireExtinguisher;
    }

    /**
     * @return whether the department has a fire extinguisher
     */
    //Getters
    public boolean getHasFireExtinguisher() {
        return hasFireExtinguisher;
    }
}
