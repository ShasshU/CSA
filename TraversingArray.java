import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TraversingArray {

    // prints array neatly with commas and "and" before last element
    public static void printNeatly(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                System.out.println("and " + array[i] + ".");
            } else {
                System.out.print(array[i] + ", ");
            }
        }
    }

    // prints array in reverse with commas and "and" before last element
    public static void reverseNeatly(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (i == 0) {
                System.out.println("and " + array[i] + ".");
            } else {
                System.out.print(array[i] + ", ");
            }
        }
    }

    // counts and displays games with zero goals
    public static void countZero(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                System.out.println("We scored 0 goals in game " + (i + 1));
                count++;
            }
        }
        System.out.println("We had " + count + " games, where we did not score a goal.");
    }

    // calculates and returns average goals per game
    public static double getAverage(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        double average = (double) sum / array.length;
        return Math.round(average * 100.0) / 100.0; // round to 2 decimal places
    }

    // switches the first and second elements in the array
    public static void switchFirstSecond(int[] array) {
        int temp = array[0];
        array[0] = array[1];
        array[1] = temp;
    }

    public static void main(String[] args) {
        // print current date and time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy 'at' hh:mm:ss a");
        System.out.println("Program executed on: " + now.format(formatter));
        System.out.println();

        // goals array
        int[] goals = { 1, 2, 0, 3, 2, 4, 2, 1, 0, 2, 0, 1, 3, 2 };

        // test printNeatly method
        System.out.print("The goals scored were ");
        printNeatly(goals);
        System.out.println();

        // test reverseNeatly method
        System.out.print("The goals scored backwards are ");
        reverseNeatly(goals);
        System.out.println();

        // test countZero method
        countZero(goals);
        System.out.println();

        // test getAverage method
        System.out.println("The average number of goals score per game is " + getAverage(goals));
        System.out.println();

        // test switchFirstSecond method
        switchFirstSecond(goals);
        System.out.print("The actual goals were ");
        printNeatly(goals);
    }
}
