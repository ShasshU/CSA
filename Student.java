import java.util.*;

public class Student {

    String name;
    int age;
    double gpa;

    public void Student() {
        this.name = "Unknown";
        this.age = 0;
        this.gpa = 0;
    }

    public void Student(String name) {
        this.name = name;
        this.age = 0;
        this.gpa = 0;
    }

    public void Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.gpa = 0;
    }

    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public String toString() {
        return "Name = " + name + ", age = " + age + ", gpa = " + gpa;
    }

}
