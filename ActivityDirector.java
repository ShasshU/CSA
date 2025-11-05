import java.util.Scanner;

public class ActivityDirector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number;

        System.out.println("Enter a temperature from 10-101");
        number = scanner.nextInt();

        if (number > 95 & number < 25) {
            System.out.println("Visit our shops!");
        } else if (number >= 80) {
            System.out.println("Go swimming!");
        } else if (number >= 60 & number < 80) {
            System.out.println("Play tennis!");
        } else if (number >= 40 & number < 60) {
            System.out.println("Play golf!");
        } else {
            System.out.println("Go skiing!");
        }
    }
}