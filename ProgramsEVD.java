import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Random;

public class ProgramsEVD {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime startTime = LocalDateTime.now();
        System.out.println("String programs");
        System.out.println("Start Date and Time: " + startTime.format(formatter));
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.nextLine();

        System.out.println(
                "What program do you want to run? 1 for Every Other Character, 2 for Remove Vowels, and 3 for dbpq:");
        String choice = scanner.nextLine();
        System.out.println();

        if (choice.equals("1")) {
            for (int i = 0; i < input.length(); i += 2) {
                System.out.print(input.charAt(i));
            }
        } else if (choice.equals("2")) {
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' &&
                        c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U') {
                    System.out.print(c);
                }
            }
        } else if (choice.equals("3")) {
            Random random = new Random();
            String dbpq = "dbpq";

            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                char lowerC = Character.toLowerCase(c);

                if (lowerC == 'd' || lowerC == 'b' || lowerC == 'p' || lowerC == 'q') {
                    int randomIndex = random.nextInt(4);
                    System.out.print(dbpq.charAt(randomIndex));
                } else {
                    System.out.print(c);
                }
            }
        }

        System.out.println();
        System.out.println();
        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("End Date and Time: " + endTime.format(formatter));
        scanner.close();
    }
}