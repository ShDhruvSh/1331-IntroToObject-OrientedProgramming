import java.util.ArrayList;

/**
 * Represents a Dwight, the office fire marshal.
 *
 * @author dsharma97
 * @version 11.0.12
 **/

public class Dwight extends Employee {

    /**
     * Creates Dwight; does not need any input parameters.
     */
    public Dwight() {
        super("Dwight Schrute", 74);
    }

    /**
     * @return who Dwight is
     */
    public String toString() {
        return "My name is Dwight and I am the fire marshal";
    }

    /**
     * Checks if 50% or more of the departments have a fire extinguisher.
     *
     * @param o office to be checked
     * @return whether 50% or more of the departments have a fire extinguisher
     */
    public boolean checkOffice(Office o) {
        double extinguisherCount = 0;
        for (int i = 0; i < o.getDepartments().size(); i++) {
            if (o.getDepartments().get(i).getHasFireExtinguisher()) {
                extinguisherCount++;
            }
        }
        return extinguisherCount / o.getDepartments().size() >= 0.5;
    }

    /**
     * Checks if an Employee is in the ArrayList of Employees.
     *
     * @param e is the Employee that is checked
     * @param employeeArrayList is the ArrayList that the Employee is being checked in
     * @return whether Employee was in ArrayList or not
     */
    public boolean findEmployee(Employee e, ArrayList<Employee> employeeArrayList) {
        int startIndex = 0;
        int endIndex = employeeArrayList.size() - 1;
        while (startIndex <= endIndex) {
            if (employeeArrayList.get(endIndex / 2).equals(e)) {
                return true;
            } else if (startIndex == endIndex) {
                return employeeArrayList.get(endIndex).equals(e);
            } else if (employeeArrayList.get((endIndex - startIndex) / 2).getHeight() > e.getHeight()) {
                endIndex = (endIndex - startIndex) / 2;

            } else {
                startIndex = ((endIndex - startIndex) - 1) / 2 + 1;
            }
        }
        return false;
    }

    /**
     * Returns Employees that are in the office but not in the ArrayList of Employees.
     *
     * @param e is the ArrayList of Employees
     * @param o is the broader Office
     * @return ArrayList with all Employees in office but not in inputted ArrayList
     */
    public ArrayList<Employee> doRecount(ArrayList<Employee> e, Office o) {
        ArrayList<Employee> toBeReturned = new ArrayList<Employee>();
        for (int i = 0; i < o.getEmployees().size(); i++) {
            if (!(findEmployee(o.getEmployees().get(i), e))) {
                toBeReturned.add(o.getEmployees().get(i));
            }
        }
        return toBeReturned;
    }
}
