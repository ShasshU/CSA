
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Searching {
    public static void main(String[] args) {
        // create ArrayList to hold 100 random numbers
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int target;

        // display current date and time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy hh:mm:ss a");
        System.out.println("Program executed on: " + now.format(formatter));
        System.out.println();

        // generate 100 unique random numbers between 0 and 999
        while (numbers.size() < 100) {
            int num = random.nextInt(1000);
            // only add the number if it's not already in the list
            if (!numbers.contains(num)) {
                numbers.add(num);
            }
        }

        System.out.println("Generated ArrayList of 100 numbers:");
        System.out.println(numbers);
        System.out.println();

        String continueSearch = "Y";

        // keep searching as long as the user enters "Y"
        while (continueSearch.equalsIgnoreCase("Y")) {
            // prompt the user for a number to search
            System.out.print("Enter a number to search for: ");
            target = scanner.nextInt();

            // call the linearSearch method and store the result
            int result = linearSearch(numbers, target);

            // display result
            if (result != -1) {
                System.out.println("The number " + target + " was found in the ArrayList at index " + result + ".");
            } else {
                System.out.println(result);
                System.out.println("The number " + target + " was not found in the List.");
            }

            // ask the user if they want to search again
            System.out.println("Do you want to search for another number? Enter 'Y' if you do.");
            scanner.nextLine(); // Clears the leftover newline from nextInt()
            continueSearch = scanner.nextLine();
            System.out.println();
        }

        scanner.close();
    }

    // linear search method
    public static int linearSearch(ArrayList<Integer> numbers, int target) {
        // loop through each element in the ArrayList
        for (int i = 0; i < numbers.size(); i++) {
            // check if current element matches the target
            if (numbers.get(i).equals(target)) {
                return i;
            }
        }
        // if target was not found after checking all elements
        return -1;
    }

}
