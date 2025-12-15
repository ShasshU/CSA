import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class JavaTimeApi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Activity 4.0.1: Birthday Countdown
        System.out.print("Enter your birth month (1-12): ");
        int month = scanner.nextInt();
        System.out.print("Enter your birth day (1-31): ");
        int day = scanner.nextInt();

        LocalDate today = LocalDate.now();
        LocalDate nextBirthday = LocalDate.of(today.getYear(), month, day);

        if (nextBirthday.isBefore(today)) {
            nextBirthday = nextBirthday.plusYears(1);
        }

        Period period = Period.between(today, nextBirthday);
        System.out.println("Your birthday is in " + period.getMonths() + " months and " + period.getDays() + " days!");
        System.out.println();

        // Activity 4.0.2: Date Formatting Challenge
        LocalDateTime now = LocalDateTime.now();

        System.out.println("ISO format: " + now.format(DateTimeFormatter.ISO_DATE_TIME));
        System.out.println("Short format: " + now.format(DateTimeFormatter.ofPattern("MM/dd/yy")));
        System.out.println("Long format: " + now.format(DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy HH:mm")));
        System.out.println();

        // Activity 4.0.3: Event Timer
        LocalTime start = LocalTime.now();
        System.out.println("Start time: " + start);

        for (int i = 0; i < 10000000; i++) {
            // loop to take some time
        }

        LocalTime end = LocalTime.now();
        System.out.println("End time: " + end);

        long nanosDifference = Duration.between(start, end).toNanos();
        System.out.println("Time taken (nanoseconds): " + nanosDifference);

        scanner.close();
    }
}
