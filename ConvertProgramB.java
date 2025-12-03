
// Program B
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConvertProgramB {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    LocalDateTime startTime = LocalDateTime.now();
    System.out.println("Start Date and Time: " + startTime.format(formatter));

    System.out.println("Enter a String: ");
    String input = scanner.nextLine();
    String output = "";
    int i = input.length();

    do {
      output += input.substring(i - 1, i);
      i--;
    } while (i > 0);

    System.out.println(output);

    LocalDateTime endTime = LocalDateTime.now();
    System.out.println("End Date and Time: " + endTime.format(formatter));

    // Scanner sc = new Scanner(System.in);
    // System.out.println("Enter a String: ");
    // String input = sc.nextLine();
    // String output = "";

    // for (int i = input.length(); i > 0; i--)
    // output += input.substring(i - 1, i);

    // System.out.println(output);
  }
}