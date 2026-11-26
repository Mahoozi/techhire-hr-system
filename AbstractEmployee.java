/*
 * TechHire HR System
 * Author: Yusuf Almahoozi
 *
 * AbstractEmployee is the shared base class for scored employees. It
 * stores a role and a score, implements precedes() and follows() by
 * comparing scores, and holds an optional comparison target. It leaves
 * showComparisonResult() abstract so each subclass decides how to print it.
 */
public abstract class AbstractEmployee implements DisplayableComparison {

    protected String role;    // job title, e.g. "JuniorDev"
    protected int score;      // the employee's score

    // The other employee we want to compare this one against.
    protected AbstractEmployee comparisonTarget;

    // Builds an employee with a role and a score.
    public AbstractEmployee(String role, int score) {
        this.role = role;
        this.score = score;
    }

    // Returns the job title.
    public String getRole() {
        return role;
    }

    // Returns the score.
    public int getScore() {
        return score;
    }

    // Picks which employee to compare against before showing the result.
    public void setComparisonTarget(AbstractEmployee comparisonTarget) {
        this.comparisonTarget = comparisonTarget;
    }

    // Comes before the other employee if this score is lower.
    @Override
    public boolean precedes(Object other) {
        if (!(other instanceof AbstractEmployee)) {
            return false;
        }
        return this.score < ((AbstractEmployee) other).score;
    }

    // Comes after the other employee if this score is higher.
    @Override
    public boolean follows(Object other) {
        if (!(other instanceof AbstractEmployee)) {
            return false;
        }
        return this.score > ((AbstractEmployee) other).score;
    }

    // showComparisonResult() is not implemented here; each concrete subclass provides it.

    // Text shown when we print an employee, e.g. "JuniorDev (score: 75)".
    @Override
    public String toString() {
        return role + " (score: " + score + ")";
    }
}
