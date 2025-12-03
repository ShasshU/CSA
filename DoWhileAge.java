
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DoWhileAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startTime = LocalDateTime.now();
        System.out.println("Start Date and Time: " + startTime.format(formatter));

        String name;
        do {
            System.out.println("What is your first name?");
            name = scanner.nextLine();

            if (name.length() < 4) {
                System.out.println("Your name needs to be at least 4 characters long.");
            }
        } while (name.length() < 4);

        int age;
        do {
            System.out.println("\nWhat is your current age?");
            age = scanner.nextInt();

            if (age < 18 || age > 65) {
                System.out.println("Your age must be between 18 and 65, inclusive.");
            }
        } while (age < 18 || age > 65);

        System.out.println("\n" + name + " is " + age + " years old.");

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("\nEnd Date and Time: " + endTime.format(formatter));
    }
}