import java.util.ArrayList;

/**
 * Represents an entire office that contains departments.
 *
 * @author dsharma97
 * @version 11.0.12
 **/

public class Office {
    private String name;
    private ArrayList<Department> departments;
    private ArrayList<Employee> employees;

    /**
     * Creates an Office with all required parameters.
     *
     * @param name name of Office
     */
    public Office(String name) {
        departments = new ArrayList<Department>();
        employees = new ArrayList<Employee>();
    }

    /**
     * Adds a Department to the Office.
     *
     * @param d Department to be added to Office
     */
    public void addDepartment(Department d) {
        departments.add(d);
    }

    /**
     * Adds an Employee to the Office.
     *
     * @param e Employee to be added to Office
     */
    public void addEmployee(Employee e) {
        for (int i = 0; i < employees.size(); i++) {
            if (e.getHeight() > employees.get(i).getHeight()) {
                employees.add(i, e);
                break;
            }
            if (i == employees.size() - 1) {
                employees.add(e);
                break;
            }
        }
        if (employees.size() == 0) {
            employees.add(e);
        }
    }

    /**
     * Removes an Employee from the Office.
     *
     * @param e Employee to be removed from Office
     * @return removed Employee
     */
    public Employee removeEmployee(Employee e) {
        Employee toBeReturned = null;
        for (int i = 0; i < employees.size(); i++) {
            if (e.equals(employees.get(i))) {
                toBeReturned = employees.get(i);
                employees.remove(e);
                return toBeReturned;
            }
        }
        return null;
    }

    //Getters
    /**
     * @return an ArrayList of departments in the Office
     */
    public ArrayList<Department> getDepartments() {
        return departments;
    }

    /**
     * @return an ArrayList of Employees in the Office
     */
    public ArrayList<Employee> getEmployees() {
        return employees;
    }
}