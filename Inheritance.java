/*=============================================================================
 |   Assignment:  Inheritance & Polymorphism Project
 |       Author:  Shassh Umamaheswaran
 |      Partner:  None
 |
 |  Course Name:  AP Computer Science A
 |   Instructor:  Jonathan Virak
 |     Due Date:  May 8, 2026 
 |
 |  Description:  Models a school system using inheritance and polymorphism.
 |                Person is the abstract superclass, with Admin, Teacher,
 |                Counselor, and Student as subclasses. Each subclass
 |                overrides performRole() and toString(). An ArrayList of
 |                Person references demonstrates polymorphism, and instanceof
 |                with casting is used to call subclass-specific methods.
 |                Uses the Java Time API to display the current date and time.
 |
 |     Language:  Java 8
 | Ex. Packages:  java.util.ArrayList,
 |                java.time.LocalDateTime,
 |                java.time.format.DateTimeFormatter
 |
 | Deficiencies:  NA
 *===========================================================================*/

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// superclass - every person in the school has a name, age, and id
// abstract because you can't just be a "person" - you have to have a role
abstract class Person {

    protected String name;
    protected int age;
    protected String id;

    public Person(String name, int age, String id) {
        this.name = name;
        this.age  = age;
        this.id   = id;
    }

    // every subclass has to define what their role actually does
    public abstract void performRole();

    // shared helper - prints what the person did with a timestamp
    public void logActivity(String activity) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("[" + now.format(fmt) + "] " + name + " (" + id + "): " + activity);
    }

    // override toString so printing a Person actually shows something useful
    @Override
    public String toString() {
        return getClass().getSimpleName() + " | Name: " + name + " | Age: " + age + " | ID: " + id;
    }
}

// Admin subclass - runs the school, manages records and policy
class Admin extends Person {

    private String department; // which part of the school they manage

    public Admin(String name, int age, String id, String department) {
        super(name, age, id); // call Person constructor first
        this.department = department;
    }

    @Override
    public void performRole() {
        System.out.println(name + " [Admin, " + department + "] is overseeing school operations and managing records.");
        logActivity("Reviewed attendance records");
    }

    // admin-specific - not on the superclass, only accessible after casting
    public void sendAdminNotice(String message) {
        System.out.println("  NOTICE from " + name + " (" + department + "): " + message);
    }

    @Override
    public String toString() {
        return super.toString() + " | Dept: " + department;
    }
}

// Teacher subclass - teaches a subject, can grade assignments
class Teacher extends Person {

    private String subject;
    private int yearsOfExperience;

    public Teacher(String name, int age, String id, String subject, int yearsOfExperience) {
        super(name, age, id);
        this.subject = subject;
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public void performRole() {
        System.out.println(name + " [Teacher] is teaching " + subject
                + " (" + yearsOfExperience + " yrs exp).");
        logActivity("Delivered lesson on " + subject);
    }

    // teacher-specific method
    public void gradeAssignment(String studentName) {
        System.out.println("  " + name + " is grading " + studentName + "'s " + subject + " assignment.");
    }

    @Override
    public String toString() {
        return super.toString() + " | Subject: " + subject + " | Exp: " + yearsOfExperience + " yrs";
    }
}

// Counselor subclass - meets with students for guidance
class Counselor extends Person {

    private String specialization; // e.g. college prep, mental health

    public Counselor(String name, int age, String id, String specialization) {
        super(name, age, id);
        this.specialization = specialization;
    }

    @Override
    public void performRole() {
        System.out.println(name + " [Counselor, " + specialization + "] is meeting with students for guidance.");
        // using super.logActivity() to show the super keyword works on methods too
        super.logActivity("Held counseling session (" + specialization + ")");
    }

    @Override
    public String toString() {
        return super.toString() + " | Specialization: " + specialization;
    }
}

// Student subclass - attends class and takes exams
class Student extends Person {

    private int grade;
    private double gpa;

    public Student(String name, int age, String id, int grade, double gpa) {
        super(name, age, id);
        this.grade = grade;
        this.gpa   = gpa;
    }

    @Override
    public void performRole() {
        System.out.println(name + " [Student, Grade " + grade + ", GPA: " + gpa + "] is attending class and studying.");
        logActivity("Submitted homework assignment");
    }

    // student-specific method - only reachable after casting
    public void takeExam(String subject) {
        System.out.println("  " + name + " is taking a " + subject + " exam. Good luck!");
    }

    public int getGrade()    { return grade; }
    public double getGpa()   { return gpa;   }

    @Override
    public String toString() {
        return super.toString() + " | Grade: " + grade + " | GPA: " + gpa;
    }
}

public class Inheritance {

    public static void main(String[] args) {

        // Java Time API - show date and time at startup
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("EEEE, MMMM d yyyy  HH:mm:ss");
        System.out.println("=== School System | " + now.format(fmt) + " ===");
        System.out.println();

        // ArrayList of Person holds all subclass types - this is polymorphism
        // the list doesn't care what specific type each object is, just that it's a Person
        ArrayList<Person> school = new ArrayList<>();

        school.add(new Admin    ("Ms. Rivera",  45, "A001", "Administration"));
        school.add(new Teacher  ("Mr. Chen",    38, "T001", "Computer Science", 12));
        school.add(new Teacher  ("Ms. Patel",   31, "T002", "Mathematics",       6));
        school.add(new Counselor("Dr. Kim",     40, "C001", "College Prep"));
        school.add(new Student  ("Jordan Lee",  16, "S001", 11, 3.8));
        school.add(new Student  ("Alex Torres", 15, "S002", 10, 3.2));

        // loop through and call performRole() on each person
        // Java figures out at runtime which version to call - that's dynamic dispatch
        System.out.println("--- Everyone Performing Their Role ---");
        for (Person p : school) {
            p.performRole();
            System.out.println();
        }

        // toString() is overridden in each class so this prints detailed info
        System.out.println("--- toString() Output ---");
        for (Person p : school) {
            System.out.println(p);
        }
        System.out.println();

        // instanceof + casting - check the type before casting so it doesn't crash
        // this lets us call methods that only exist on the subclass
        System.out.println("--- instanceof + Casting ---");
        for (Person p : school) {

            if (p instanceof Admin) {
                Admin a = (Admin) p; // safe downcast to Admin
                a.sendAdminNotice("School picture day is this Friday.");
            }

            if (p instanceof Teacher) {
                Teacher t = (Teacher) p; // safe downcast to Teacher
                t.gradeAssignment("Jordan Lee");
            }

            if (p instanceof Student) {
                Student s = (Student) p; // safe downcast to Student
                s.takeExam("Computer Science");
                // use the subclass getter to check honor roll
                if (s.getGpa() >= 3.5) {
                    System.out.println("  *** " + s.name + " is on the Honor Roll! (GPA " + s.getGpa() + ") ***");
                }
            }
        }
        System.out.println();

        // count teachers and students using a plain loop
        System.out.println("--- Summary ---");
        int teacherCount = 0;
        int studentCount = 0;
        for (Person p : school) {
            if (p instanceof Teacher) teacherCount++;
            if (p instanceof Student) studentCount++;
        }
        System.out.println("Total people : " + school.size());
        System.out.println("Teachers     : " + teacherCount);
        System.out.println("Students     : " + studentCount);
    }
}
