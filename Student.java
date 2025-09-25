import java.util.*;

public class Student {

    String name;
    int age;
    double gpa;

    public Student() {
        this.name = "Unknown";
        this.age = 0;
        this.gpa = 0;
    }

    public Student(String name) {
        this.name = name;
        this.age = 0;
        this.gpa = 0;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.gpa = 0;
    }

    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public void printStudentInfo() {
        System.out.println("Student Information: " + name + " is " + age + " years old with a GPA of " + gpa);
    }

    /*
     * public void printStudentInfo(String name) {
     * System.out.println("Student Information: " + name + " is " + age +
     * " years old with a GPA of " + gpa);
     * }
     * 
     * public void printStudentInfo(String name, int age) {
     * System.out.println("Student Information: " + name + " is " + age +
     * " years old with a GPA of " + gpa);
     * }
     */

    public String toString() {
        return "Name = " + name + ", age = " + age + ", gpa = " + gpa;
    }

}
