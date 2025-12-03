
//Program A
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConvertProgramA {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    LocalDateTime startTime = LocalDateTime.now();
    System.out.println("Start Date and Time: " + startTime.format(formatter));

    String input;
    do {
      System.out.println("Enter a String with at least 3 characters: ");
      input = sc.nextLine();
    } while (input.length() < 3);

    String pattern = "aaa";
    int howMany = 0;
    int i = 0;

    do {
      String currSeq = input.substring(i, i + pattern.length());
      if (currSeq.equals(pattern))
        howMany++;
      i++;
    } while (i < input.length() - pattern.length() + 1);

    System.out.println("There were " + howMany +
        " substrings matching " + pattern);

    LocalDateTime endTime = LocalDateTime.now();
    System.out.println("End Date and Time: " + endTime.format(formatter));
  }
}