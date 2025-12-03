import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CharOracle {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startTime = LocalDateTime.now();
        System.out.println("Start Date and Time: " + startTime.format(formatter));

        Scanner sc = new Scanner(System.in);
        String str;

        do {
            System.out.print("Enter a letter: ");
            str = sc.nextLine();
        } while (str.length() != 1);

        char ch = str.toLowerCase().charAt(0);

        switch (ch) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                System.out.println("\n" + str + " is a vowel.");
                break;
            default:
                if (Character.isLetter(ch)) {
                    System.out.println("\n" + str + " is a consonant.");
                } else {
                    System.out.println("\n" + str + " is not a letter.");
                }
                break;
        }

        sc.close();
    }
}
