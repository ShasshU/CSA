import java.util.Scanner;
import java.util.ArrayList;

public class Sevens {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int player1;
        String player1Name;
        ArrayList<Integer> player1List = new ArrayList<Integer>();

        int player2;
        String player2Name;

        int rounds;
        int removeNumber1;
        int removeNumber2;

        int firstRoll;
        int secondRoll;
        int thirdRoll;
        int fourthRoll;
        int fifthRoll;
        int sixthRoll;

        System.out.println("How many rounds will you play?");
        rounds = scanner.nextInt();

        System.out.println("Player 1, what is your name?");
        player1Name = scanner.next();
        System.out.println("Player 2, what is your name?");
        player2Name = scanner.next();

        System.out.println("Great! Let's start the game.");
        System.out.println("ROLLING...");
        System.out.println("Player 1: " + player1Name + "s round 1 results:");
        firstRoll = (int) (Math.random() * 6) + 1;
        System.out.println("You rolled a " + firstRoll);
        secondRoll = (int) (Math.random() * 6) + 1;
        System.out.println("You rolled a " + secondRoll);
        thirdRoll = (int) (Math.random() * 6) + 1;
        System.out.println("You rolled a " + thirdRoll);
        fourthRoll = (int) (Math.random() * 6) + 1;
        System.out.println("You rolled a " + fourthRoll);
        fifthRoll = (int) (Math.random() * 6) + 1;
        System.out.println("You rolled a " + fifthRoll);
        sixthRoll = (int) (Math.random() * 6) + 1;
        System.out.println("You rolled a " + sixthRoll);
        player1List.add(firstRoll);
        player1List.add(secondRoll);
        player1List.add(thirdRoll);
        player1List.add(fourthRoll);
        player1List.add(fifthRoll);
        player1List.add(sixthRoll);

        System.out.println(
                "Which numbers do you want to remove? Remember that the two numbers must add up to 7. Pick a number 1-6, and pick 0 if your done");

    }

}
