import java.util.*;

public class StudentMain {

    public static void main(String[] args) {

        Student unknown = new Student();
        Student alice = new Student("Alice");
        Student bob = new Student("Bob", 17);
        Student charlie = new Student("Charlie", 18, 3.7);

        System.out.println(unknown.toString());
        System.out.println(alice.toString());
        System.out.println(bob.toString());
        System.out.println(charlie.toString());

    }

}
