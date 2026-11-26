/*
 * TechHire HR System
 * Author: Yusuf Almahoozi
 *
 * Main is the console entry point. It runs three demonstrations:
 * candidate comparison through the Ordered interface, developer comparison
 * through the AbstractEmployee hierarchy, and deep cloning of Employee
 * records.
 */
public class Main {

    // The program starts here.
    public static void main(String[] args) {
        candidateComparisonDemo();
        developerComparisonDemo();
        deepCloningDemo();
    }

    // Compares candidates using the Ordered interface.
    private static void candidateComparisonDemo() {
        System.out.println("=== Candidate Comparison ===");
        System.out.println();

        // Make three candidates with different scores.
        Candidate alice = new Candidate("Alice", 70);
        Candidate bob = new Candidate("Bob", 85);
        Candidate charlie = new Candidate("Charlie", 90);

        // Alice has a lower score than Bob, so she precedes him.
        System.out.println("Comparing Alice and Bob:");
        System.out.println("Alice precedes Bob? " + alice.precedes(bob));
        System.out.println("Alice follows Bob? " + alice.follows(bob));
        System.out.println();

        // Charlie has a higher score than Bob, so he follows him.
        System.out.println("Comparing Charlie and Bob:");
        System.out.println("Charlie precedes Bob? " + charlie.precedes(bob));
        System.out.println("Charlie follows Bob? " + charlie.follows(bob));
        System.out.println();
    }

    // Compares developers through the AbstractEmployee hierarchy.
    private static void developerComparisonDemo() {
        System.out.println("=== Developer Comparison (Abstract Class) ===");
        System.out.println();

        // Make three developers with different scores.
        Developer intern = new Developer("Intern", 65);
        Developer junior = new Developer("JuniorDev", 75);
        Developer senior = new Developer("SeniorDev", 92);

        // Set the target, then let the developer print the result.
        System.out.println("Comparing Junior Developer vs. Senior Developer:");
        junior.setComparisonTarget(senior);
        junior.showComparisonResult();
        System.out.println();

        System.out.println("Comparing Intern vs. Junior Developer:");
        intern.setComparisonTarget(junior);
        intern.showComparisonResult();
        System.out.println();
    }

    // Shows that deep cloning keeps the original employee record unchanged.
    private static void deepCloningDemo() {
        System.out.println("=== Deep Cloning of Employee Records ===");
        System.out.println();

        // Make the original employee.
        Employee original = new Employee("Emma", new Department("Engineering"));

        System.out.println("Original Employee:");
        original.display();
        System.out.println();

        // Make a clone of Emma.
        System.out.println("Cloning Emma...");
        System.out.println();
        Employee cloned = original.clone();

        // Change the clone's department only.
        cloned.getDept().setDeptName("Research");
        System.out.println("Modified cloned employee's department to: "
                + cloned.getDept().getDeptName());
        System.out.println();

        // The clone shows "Research".
        System.out.println("Cloned Employee:");
        cloned.display();
        System.out.println();

        // The original still shows "Engineering" (deep copy worked).
        System.out.println("Original Employee after cloning:");
        original.display();
    }
}
