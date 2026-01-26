import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;

public class NumberLists {
    public static void main(String[] args) {
        // display current date and time using Java Time API
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Current Date and Time: " + now);

        // intialize ArrayList to store numbers and scanner for input
        ArrayList<Integer> numberlist = new ArrayList<Integer>();
        ArrayList<Integer> oddList = new ArrayList<Integer>();
        ArrayList<Integer> evenList = new ArrayList<Integer>();
        String input;
        Scanner scanner = new Scanner(System.in);

        // ask user for input
        System.out.println("Please enter numbers, enter STOP to stop the loop.");
        input = scanner.nextLine();

        // loop to collect numbers until user enters STOP
        while (!input.equals("STOP")) {
            // Convert string input to integer and add to list
            int number = Integer.parseInt(input);
            numberlist.add(number);

            // Sort into odd or even list 
            if (number % 2 == 0) {
                evenList.add(number);
            } else {
                oddList.add(number);
            }

            input = scanner.nextLine();
        }

        // Print the full list
        System.out.println(numberlist);

        // Calculate sum and average using a for loop
        int sum = 0;
        for (int i = 0; i < numberlist.size(); i++) {
            sum += numberlist.get(i);
        }
        double average = (double) sum / numberlist.size();

        // Print sum and average
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);

        // Print odd and even lists
        System.out.println("Odds List: " + oddList);
        System.out.println("Even List: " + evenList);
    }
}
