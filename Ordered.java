/*
 * TechHire HR System
 * Author: Yusuf Almahoozi
 *
 * Ordered is the base comparison interface. A class that implements it
 * defines whether one object comes before (precedes) or after (follows)
 * another object of the same kind.
 */
public interface Ordered {

    // Returns true if this object comes before the other one.
    boolean precedes(Object other);

    // Returns true if this object comes after the other one.
    boolean follows(Object other);
}
