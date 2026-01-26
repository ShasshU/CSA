import java.util.ArrayList;
import java.time.LocalDateTime;

public class TraversingArrayLists {
    public static void main(String[] args) {
        // display current date and time using Java Time API
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Current Date and Time: " + now);
        System.out.println();

        // create ArrayList of Person objects
        ArrayList<Person> people = new ArrayList<>();

        people.add(new Person("Avri", 25));
        people.add(new Person("Alan", 30));
        people.add(new Person("Bob", 22));
        people.add(new Person("Evan", 40));
        people.add(new Person("Charlie", 35));

        // traverse using a standard for loop and print details
        System.out.println("Using standard for loop:");
        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i));
        }
        System.out.println();

        // traverse using an enhanced for loop and calculate the average age
        // also find the oldest and youngest person
        System.out.println("Using enhanced for loop:");
        int enhancedSumAge = 0;
        Person oldestPerson = people.get(0);
        Person youngestPerson = people.get(0);

        for (Person person : people) {
            System.out.println(person);
            enhancedSumAge += person.getAge();

            // check if this person is older than current oldest
            if (person.getAge() > oldestPerson.getAge()) {
                oldestPerson = person;
            }

            // check if this person is younger than current youngest
            if (person.getAge() < youngestPerson.getAge()) {
                youngestPerson = person;
            }
        }
        System.out.println();

        // calculate the average age
        double averageAge = (double) enhancedSumAge / people.size();
        System.out.println("Average Age: " + averageAge);
        System.out.println();

        // display the oldest and youngest person
        System.out.println("Oldest Person: " + oldestPerson.getName() + " (" + oldestPerson.getAge() + " years old)");
        System.out.println(
                "Youngest Person: " + youngestPerson.getName() + " (" + youngestPerson.getAge() + " years old)");
    }
}

// Person class with name and age attributes
class Person {
    private String name;
    private int age;

    // constructor to initialize name and age
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // getter method for name
    public String getName() {
        return name;
    }

    // getter method for age
    public int getAge() {
        return age;
    }

    // overridden toString method for user-friendly output
    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}
