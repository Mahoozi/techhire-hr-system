/*
 * TechHire HR System
 * Author: Yusuf Almahoozi
 *
 * Department is a mutable holder for a department name. Because its
 * name can change after creation, Employee copies it when cloning so that
 * a clone and its original never share the same Department object.
 */
public class Department {

    private String deptName;   // the department's name

    // Builds a department with a name.
    public Department(String deptName) {
        this.deptName = deptName;
    }

    // Returns the department name.
    public String getDeptName() {
        return deptName;
    }

    // Changes the department name.
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    // Text shown when we print a department (just its name).
    @Override
    public String toString() {
        return deptName;
    }
}
