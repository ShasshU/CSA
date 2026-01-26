import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;

public class StringLists {
    public static void main(String[] args) {
        // display current date and time using Java Time API
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Current Date and Time: " + now);

        // intialize ArrayList to store words and scanner for input
        ArrayList<String> stringlist = new ArrayList<String>();
        String input;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter words. Enter STOP to stop the loop");
        input = scanner.nextLine();

        while (!input.equals("STOP")) {
            stringlist.add(input);
            input = scanner.nextLine();
        }
        if (input.equals("STOP")) {
            System.out.println(stringlist.size());
            System.out.println(stringlist);

            if (stringlist.size() > 2) {
                stringlist.remove(stringlist.size() - 1);
                stringlist.remove(0);

                System.out.println(stringlist);
            }
            for (int i = stringlist.size() - 1; i >= 0; i--) {
                System.out.println(stringlist.get(i));
            }

        }

    }

}
