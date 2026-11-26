/*
 * TechHire HR System
 * Author: Yusuf Almahoozi
 *
 * DisplayableComparison extends Ordered with a method that prints how an
 * object compares to the object it has been paired with.
 */
public interface DisplayableComparison extends Ordered {

    // Prints how this object compares to the one it is paired with.
    void showComparisonResult();
}
