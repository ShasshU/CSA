import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SquaredNOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime startTime = LocalDateTime.now();
        System.out.println("Squared & Odd Program");
        System.out.println("Start Date and Time: " + startTime.format(formatter));
        System.out.println();

        System.out.println("Enter the number of squares:");
        int numSquares = scanner.nextInt();

        for (int i = 1; i <= numSquares; i++) {
            System.out.println(i + " squared = " + (i * i));
        }

        System.out.println();

        scanner.nextLine();
        int oddCount = 0;
        String input = "";

        while (!input.equals("done")) {
            System.out.println("Enter a number (type \"done\" when complete):");
            input = scanner.nextLine().trim();

            if (!input.equals("done")) {
                int number = Integer.parseInt(input);
                if (number % 2 != 0) {
                    oddCount++;
                }
            }
        }

        System.out.println();
        System.out.println("You had " + oddCount + " odd numbers.");

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println();
        System.out.println("End Date and Time: " + endTime.format(formatter));

        scanner.close();
    }
}
