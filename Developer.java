/*
 * TechHire HR System
 * Author: Yusuf Almahoozi
 *
 * Developer is a concrete AbstractEmployee. It implements
 * showComparisonResult() to print whether this developer precedes, follows,
 * or ties with its comparison target.
 */
public class Developer extends AbstractEmployee {

    // Builds a developer with a role and a score.
    public Developer(String role, int score) {
        super(role, score);
    }

    // Prints whether this developer comes before or after its target.
    @Override
    public void showComparisonResult() {
        System.out.println("Score Comparison Result:");

        // If no one was set to compare with, say so and stop.
        if (comparisonTarget == null) {
            System.out.println(this + " has no employee to compare against.");
            return;
        }

        // Print the result based on the scores.
        if (this.precedes(comparisonTarget)) {
            System.out.println(this + " precedes " + comparisonTarget);
        } else if (this.follows(comparisonTarget)) {
            System.out.println(this + " follows " + comparisonTarget);
        } else {
            System.out.println(this + " ties with " + comparisonTarget);
        }
    }
}
