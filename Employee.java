/*
 * TechHire HR System
 * Author: Yusuf Almahoozi
 *
 * Employee represents an employee record with a name and a Department.
 * clone() performs a deep copy: the clone receives its own Department
 * object, so changing the clone's department does not affect the original.
 */
public class Employee implements Cloneable {

    private String name;        // the employee's name
    private Department dept;     // the employee's department (can change)

    // Builds an employee with a name and a department.
    public Employee(String name, Department dept) {
        this.name = name;
        this.dept = dept;
    }

    // Returns the employee's name.
    public String getName() {
        return name;
    }

    // Returns the employee's department.
    public Department getDept() {
        return dept;
    }

    // Changes the employee's department.
    public void setDept(Department dept) {
        this.dept = dept;
    }

    // Makes a deep copy of this employee.
    @Override
    public Employee clone() {
        try {
            // super.clone() copies the fields, but dept would still be shared.
            Employee copy = (Employee) super.clone();
            // So give the copy its own new Department to keep them separate.
            copy.dept = new Department(this.dept.getDeptName());
            return copy;
        } catch (CloneNotSupportedException e) {
            // This won't happen because we implement Cloneable.
            throw new AssertionError(e);
        }
    }

    // Prints the employee's name and department.
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Department: " + dept.getDeptName());
    }

    // Text shown when we print an employee.
    @Override
    public String toString() {
        return name + " - " + dept.getDeptName();
    }
}
