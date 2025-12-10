import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class NestedIteration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startTime = LocalDateTime.now();
        System.out.println("Nested Iteration Programs");
        System.out.println("Start Date and Time: " + startTime.format(formatter));
        System.out.println();

        boolean running = true;

        while (running) {
            System.out.println(
                    "What artwork would you like to display?\n1. Christmas Tree\n2. Number Staircase\n3. Number Triangle\n4. Exit Program");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("You have chosen the christmas tree display");
                System.out.println("...");
                System.out.println("creating");
                System.out.println("...");

                int n = 5;

                for (int row = 0; row < n; row++) {

                    int maxWidth = 2 * n - 1;
                    int currentRowWidth = 2 * (row + 1) - 1;
                    int leadingSpaces = (maxWidth - currentRowWidth) / 2;

                    for (int space = 0; space < leadingSpaces; space++) {
                        System.out.print(" ");
                    }

                    for (int star = 0; star < row + 1; star++) {
                        System.out.print("*");

                        if (star != row) {
                            System.out.print(" ");
                        }
                    }

                    System.out.println();
                }
                System.out.println();
            } else if (choice == 2) {
                System.out.println("Creating number staircase...");

                int n = 5;
                for (int i = 0; i < n; i++) {
                    for (int num = 1; num <= i + 1; num++) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            } else if (choice == 3) {
                System.out.println("Creating number triangle...");

                int n = 5;
                for (int row = 0; row < n; row++) {

                    int leadingSpaces = n - row - 1;
                    for (int space = 0; space < leadingSpaces; space++) {
                        System.out.print(" ");
                    }

                    for (int num = 1; num <= row + 1; num++) {
                        System.out.print(num);

                        if (num != row + 1) {
                            System.out.print(" ");
                        }
                    }

                    System.out.println();
                }
                System.out.println();
            } else if (choice == 4) {
                System.out.println("Exiting program...");
                running = false;
            } else {
                System.out.println("Invalid choice. Please select 1, 2, 3, or 4.");
                System.out.println();
            }
        }

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("End Date and Time: " + endTime.format(formatter));
        scanner.close();
    }
}