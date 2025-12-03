import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClassworkGuessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime startTime = LocalDateTime.now();
        System.out.println("Classwork Guessing Program");
        System.out.println("Start Date and Time: " + startTime.format(formatter));

        int guess;
        int numberToGuess = (int) (Math.random() * 100) + 1;

        do {
            System.out.println("Guess a number between 1-100: ");
            guess = scanner.nextInt();

            if (guess < 1 || guess > 100) {
                System.out.println("Your guess is out of range. Please try again.");
                continue;
            }
            if (guess == numberToGuess) {
                System.out.println("Congratulations! You have guessed the correct number");
            } else if (guess != numberToGuess) {
                System.out.println("Incorrect guess! You were off by " + Math.abs(numberToGuess - guess));
            } else if (guess < 1 || guess > 100) {
                System.out.println("Your guess is out of range. Please try again.");
            }
        } while (guess != numberToGuess);

    }
}