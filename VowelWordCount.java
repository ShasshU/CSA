import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class VowelWordCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime startTime = LocalDateTime.now();
        System.out.println("Start Date and Time: " + startTime.format(formatter));

        System.out.println("Enter a phrase:");
        String input = scanner.nextLine();

        int wordCount = 0;
        int vowelCount = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                wordCount++;
            }
        }
        wordCount++;

        for (int i = 0; i < input.length(); i++) {
            char c = Character.toLowerCase(input.charAt(i));
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowelCount++;
            }
        }

        System.out.println("This phrase has " + wordCount + " words and " + vowelCount + " vowels.");
        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("End Date and Time: " + endTime.format(formatter));

        scanner.close();
    }
}