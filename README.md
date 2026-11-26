# TechHire HR System

A small Java console program that models a few HR concepts (job candidates, scored developers, and employee records with departments) to demonstrate interfaces, abstract classes, inheritance, and deep copying with `clone()`.

It is a learning and portfolio demo of object-oriented design in Java. It is not a recruitment platform: there is no user input, persistence, or user interface, and all data is hard-coded in `Main`.

## Features

- **Candidate comparison.** `Candidate` implements the `Ordered` interface, so one candidate can be checked as coming before (`precedes`) or after (`follows`) another based on interview score.
- **Developer comparison through an abstract class.** `AbstractEmployee` implements the shared comparison logic once. `Developer` extends it and prints a readable result: *precedes*, *follows*, or *ties with*.
- **Deep cloning of employee records.** `Employee.clone()` gives the copy its own `Department`, so renaming the clone's department leaves the original unchanged.

## Requirements

- A Java Development Kit (JDK) 8 or newer. The sources use only the standard library. They were tested on JDK 24, including a `javac --release 8` compile.
- No build tool or external libraries are needed.

## Compile and run

From the repository root:

```bash
javac -d out *.java
java -cp out Main
```

`javac` writes the compiled `.class` files to `out/`, which is ignored by Git. To clean up:

```bash
rm -rf out
```

## File structure

```
techhire-hr-system/
├── Ordered.java                # Interface: precedes() / follows()
├── DisplayableComparison.java  # Interface extending Ordered: showComparisonResult()
├── Candidate.java              # Job applicant; implements Ordered
├── AbstractEmployee.java       # Abstract base: role, score, shared comparison logic
├── Developer.java              # Concrete AbstractEmployee; prints the comparison
├── Department.java             # Mutable department name
├── Employee.java               # Employee record with deep-copying clone()
├── Main.java                   # Entry point; runs the three demonstrations
├── README.md
└── .gitignore
```

| Class / interface | Responsibility |
| --- | --- |
| `Ordered` | Declares `boolean precedes(Object other)` and `boolean follows(Object other)`. |
| `DisplayableComparison` | Extends `Ordered` and adds `void showComparisonResult()`. |
| `Candidate` | Holds a name and interview score. Compares with other `Candidate` objects by score. |
| `AbstractEmployee` | Holds a role, a score, and an optional comparison target. Implements `precedes`/`follows` by score. Leaves `showComparisonResult()` to subclasses. |
| `Developer` | Implements `showComparisonResult()` to print whether it precedes, follows, or ties with its target. |
| `Department` | Stores a department name that can be changed with `setDeptName()`. |
| `Employee` | Holds a name and a `Department`. Implements `Cloneable` and overrides `clone()` to deep-copy the department. |
| `Main` | Builds sample objects and prints each demonstration. |

## How comparison works

Both comparison paths use the same rule: **a lower score comes first**.

| This score vs. other score | `precedes(other)` | `follows(other)` | `Developer` prints |
| --- | --- | --- | --- |
| Lower | `true` | `false` | `... precedes ...` |
| Equal | `false` | `false` | `... ties with ...` |
| Higher | `false` | `true` | `... follows ...` |

Details:

- `Candidate.precedes`/`follows` return `false` if the other object is not a `Candidate` (including `null`).
- `AbstractEmployee.precedes`/`follows` return `false` if the other object is not an `AbstractEmployee`.
- A `Developer` compares against the object passed to `setComparisonTarget(...)`. If no target has been set, `showComparisonResult()` prints `<developer> has no employee to compare against.`

## How department cloning works

`Employee` has two fields: a `String` name and a `Department`. `Object.clone()` alone would make a *shallow* copy, so the clone and the original would point to the same `Department` object, and renaming one would rename both.

`Employee.clone()` avoids that:

```java
Employee copy = (Employee) super.clone();               // copies fields (shallow)
copy.dept = new Department(this.dept.getDeptName());    // give the copy its own Department
```

`String` is immutable, so sharing the name is safe. `Department` contains only a `String`, so creating a new `Department` with the same name is a complete deep copy. After cloning, `cloned.getDept().setDeptName("Research")` changes only the clone.

## Design notes: interfaces, inheritance, deep copying

- **Interfaces.** `Ordered` defines a minimal comparison contract. `DisplayableComparison` extends it (interface inheritance) to add display behaviour. `Candidate` implements only `Ordered`. `AbstractEmployee` implements `DisplayableComparison`.
- **Abstract class and inheritance.** `AbstractEmployee` implements part of `DisplayableComparison` (`precedes`, `follows`, `toString`) and is declared `abstract` because it does not implement `showComparisonResult()`. `Developer` inherits the shared fields and logic and supplies the missing method. More employee types could be added the same way.
- **Deep copying.** `Employee` implements `Cloneable` and overrides `clone()` with a covariant `Employee` return type, copying its one mutable field by hand.

## Example output

```
=== Candidate Comparison ===

Comparing Alice and Bob:
Alice precedes Bob? true
Alice follows Bob? false

Comparing Charlie and Bob:
Charlie precedes Bob? false
Charlie follows Bob? true

=== Developer Comparison (Abstract Class) ===

Comparing Junior Developer vs. Senior Developer:
Score Comparison Result:
JuniorDev (score: 75) precedes SeniorDev (score: 92)

Comparing Intern vs. Junior Developer:
Score Comparison Result:
Intern (score: 65) precedes JuniorDev (score: 75)

=== Deep Cloning of Employee Records ===

Original Employee:
Name: Emma
Department: Engineering

Cloning Emma...

Modified cloned employee's department to: Research

Cloned Employee:
Name: Emma
Department: Research

Original Employee after cloning:
Name: Emma
Department: Engineering
```

## Limitations

- All sample data is hard-coded in `Main`. There is no interactive input, file storage, or database.
- Scores are plain `int` values with no defined range.
- `Ordered` takes `Object` parameters instead of using generics or `Comparable<T>`, so type mismatches are handled at runtime by returning `false`.
- `Candidate` and `AbstractEmployee` are separate hierarchies; a candidate cannot be compared with a developer.
- There is no automated test suite.

## Author

Yusuf Almahoozi
