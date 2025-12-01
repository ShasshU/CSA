import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WhileLoops {
    public static void main(String[] args) {
        Scanner vaughn = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime startTime = LocalDateTime.now();
        System.out.println("While Loops Program");
        System.out.println("Start Date and Time: " + startTime.format(formatter));
        System.out.println();

        boolean running = true;
        while (running) {
            System.out.println("Which program would you like to use today?");
            System.out.println("1. Is a Factor?");
            System.out.println("2. Extract Digits");
            System.out.println("3. Sum and Average");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = vaughn.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    isFactor(vaughn);
                    break;
                case 2:
                    extractDigits(vaughn);
                    break;
                case 3:
                    sumAverage(vaughn);
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("End Date and Time: " + endTime.format(formatter));
        vaughn.close();
    }

    public static void isFactor(Scanner vaughn) {
        System.out.println("Enter the number: ");
        int number = vaughn.nextInt();

        System.out.println("Enter the divisor: ");
        int divisor = vaughn.nextInt();

        int originalNumber = number;

        if (divisor == 0) {
            System.out.println("Division by zero is not allowed");
        } else {
            while (number >= divisor) {
                number -= divisor;
            }

            if (number == 0) {
                System.out.println(divisor + " is a factor of " + originalNumber);
            } else {
                System.out.println(divisor + " is not a factor of " + originalNumber);
            }
        }
    }

    public static void extractDigits(Scanner vaughn) {
        System.out.println("Enter a positive integer: ");
        int number = vaughn.nextInt();

        while (number > 0) {
            int digit = number % 10;
            System.out.println(digit);
            number = number / 10;
        }
    }

    public static void sumAverage(Scanner vaughn) {
        int sum = 0;
        int count = 0;

        vaughn.nextLine();

        System.out.println("Enter a number, or the letter 'q' to end the sequence: ");
        String input = vaughn.nextLine();

        while (!input.equals("q")) {
            int number = Integer.parseInt(input);
            sum += number;
            count++;

            System.out.println("Enter a number, or the letter 'q' to end the sequence: ");
            input = vaughn.nextLine();
        }

        double average = (double) sum / count;
        System.out.println("The sum is: " + sum);
        System.out.println("The average is: " + average);
    }
}
