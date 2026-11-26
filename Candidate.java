/*
 * TechHire HR System
 * Author: Yusuf Almahoozi
 *
 * Candidate represents a job applicant with a name and an interview score.
 * It implements Ordered: a candidate with a lower score precedes one with
 * a higher score.
 */
public class Candidate implements Ordered {

    private String name;   // the candidate's name
    private int score;     // the candidate's interview score

    // Builds a candidate with a name and a score.
    public Candidate(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // Returns the candidate's name.
    public String getName() {
        return name;
    }

    // Returns the candidate's score.
    public int getScore() {
        return score;
    }

    // This candidate comes before the other one if its score is lower.
    @Override
    public boolean precedes(Object other) {
        // Make sure the other object is really a Candidate first.
        if (!(other instanceof Candidate)) {
            return false;
        }
        Candidate o = (Candidate) other;   // treat other as a Candidate
        return this.score < o.score;
    }

    // This candidate comes after the other one if its score is higher.
    @Override
    public boolean follows(Object other) {
        if (!(other instanceof Candidate)) {
            return false;
        }
        Candidate o = (Candidate) other;
        return this.score > o.score;
    }

    // Text shown when we print a candidate, e.g. "Alice (score: 70)".
    @Override
    public String toString() {
        return name + " (score: " + score + ")";
    }
}
