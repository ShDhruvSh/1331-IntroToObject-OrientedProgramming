/**
 * Represents an employee in a department.
 *
 * @author dsharma97
 * @version 11.0.12
 **/

public class Employee implements Comparable<Employee> {
    private String name; //the name of the employee
    private int height; //the height of the employee

    /**
     * Creates an Employee with all required parameters.
     *
     * @param name name of Employee
     * @param height height of Employee
     */
    public Employee(String name, int height) {
        this.name = name;
        this.height = height;
    }

    /**
     * @return a string of information about the Employee
     */
    public String toString() {
        return "My name is " + name + " and I am " + height + " inches tall";
    }

    /**
     * Checks if an object is equal to the Employee calling the equals method.
     *
     * @param obj is compared to the Employee object calling the method if it is equal
     *
     * @return true or false depending on whether the objects are equal or not
     */
    public boolean equals(Object obj) {
        if (obj instanceof Employee) {
            return ((Employee) obj).name == name && ((Employee) obj).height == height;
        } else {
            return false;
        }
    }

    /**
     * Checks if an Employee is greater than, less than, or equal to to the Employee calling the compareTo method.
     *
     * @param e is compared to the Employee object calling the method if it is equal
     *
     * @return 1 if the Employee calling the compareTo method is greater than the one being passed in,
     *         -1 if it is less than the one being passed in, or 0 if they are both equal
     */
    public int compareTo(Employee e) {
        if (this.height > e.height) {
            return 1;
        } else if (e.height > this.height) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * @return the height of Employee
     */
    //Getters
    public int getHeight() {
        return height;
    }

}
