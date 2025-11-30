import java.util.Scanner;

public class Sevens {

    static int score1 = 0;
    static int score2 = 0;
    static int player1Rolls = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many rounds will you play? (max 10)");
        int rounds = scanner.nextInt();
        while (rounds < 1 || rounds > 10) {
            System.out.println("Please enter a number between 1 and 10:");
            rounds = scanner.nextInt();
        }

        System.out.println("Player 1, what is your name?");
        String player1 = scanner.next();
        System.out.println("Player 2, what is your name?");
        String player2 = scanner.next();

        System.out.println("\nGreat! Let's start the game.\n");

        for (int currentRound = 1; currentRound <= rounds; currentRound++) {
            System.out.println("ROUND " + currentRound + " \n");

            System.out.println(player1 + "'s turn:");
            player1Turn(scanner);

            System.out.println("\n" + player2 + "'s turn:");
            player2Turn(scanner);

            System.out.println("\nEnd of Round " + currentRound);
            System.out.println(player1 + ": " + score1);
            System.out.println(player2 + ": " + score2 + "\n");
        }

        System.out.println("GAME OVER! ");
        System.out.println(player1 + "'s final score: " + score1);
        System.out.println(player2 + "'s final score: " + score2);

        if (score1 > score2) {
            System.out.println(player1 + " WINS!");
        } else if (score2 > score1) {
            System.out.println(player2 + " WINS!");
        } else {
            System.out.println("TIE!");
        }

        scanner.close();
    }

    public static void player1Turn(Scanner scan) {
        player1Rolls = 0; // Reset for this round
        int d1 = 0, d2 = 0, d3 = 0, d4 = 0, d5 = 0, d6 = 0;
        int roundScore = 0;
        int maxRolls = 3;

        for (int rollCount = 1; rollCount <= maxRolls; rollCount++) {
            System.out.println("\nRoll " + rollCount + ":");

            if (rollCount == 1 || roundScore == 0) {
                d1 = (int) (Math.random() * 6) + 1;
                d2 = (int) (Math.random() * 6) + 1;
                d3 = (int) (Math.random() * 6) + 1;
                d4 = (int) (Math.random() * 6) + 1;
                d5 = (int) (Math.random() * 6) + 1;
                d6 = (int) (Math.random() * 6) + 1;
            } else {
                // Re-roll only the remaining dice (non-zero ones)
                if (d1 != 0) d1 = (int) (Math.random() * 6) + 1;
                if (d2 != 0) d2 = (int) (Math.random() * 6) + 1;
                if (d3 != 0) d3 = (int) (Math.random() * 6) + 1;
                if (d4 != 0) d4 = (int) (Math.random() * 6) + 1;
                if (d5 != 0) d5 = (int) (Math.random() * 6) + 1;
                if (d6 != 0) d6 = (int) (Math.random() * 6) + 1;
            }

            System.out.println("You rolled: " + d1 + ", " + d2 + ", " + d3 + ", " + d4 + ", " + d5 + ", " + d6);

            int[] dice = { d1, d2, d3, d4, d5, d6 };

            for (int i = 0; i < 6; i++) {
                for (int j = i + 1; j < 6; j++) {
                    if (dice[i] + dice[j] == 7) {
                        dice[i] = 0;
                        dice[j] = 0;
                    }
                }
            }

            d1 = dice[0];
            d2 = dice[1];
            d3 = dice[2];
            d4 = dice[3];
            d5 = dice[4];
            d6 = dice[5];

            roundScore = d1 + d2 + d3 + d4 + d5 + d6;
            System.out.println("Remaining dice: " + d1 + " " + d2 + " " + d3 + " " + d4 + " " + d5 + " " + d6);
            System.out.println("Your score: " + roundScore);

            if (rollCount < maxRolls) {
                System.out.print("Roll again? (y/n): ");
                String answer = scan.next();
                if (!answer.equals("y")) {
                    player1Rolls = rollCount;
                    break;
                }
            }
        }

        score1 = score1 + roundScore;
        player1Rolls = player1Rolls == 0 ? maxRolls : player1Rolls; // If didn't break, they rolled all 3 times
    }

    public static void player2Turn(Scanner scan) {
        int d1 = 0, d2 = 0, d3 = 0, d4 = 0, d5 = 0, d6 = 0;
        int roundScore = 0;

        for (int rollCount = 1; rollCount <= player1Rolls; rollCount++) {
            System.out.println("\nRoll " + rollCount + ":");

            if (rollCount == 1 || roundScore == 0) {
                d1 = (int) (Math.random() * 6) + 1;
                d2 = (int) (Math.random() * 6) + 1;
                d3 = (int) (Math.random() * 6) + 1;
                d4 = (int) (Math.random() * 6) + 1;
                d5 = (int) (Math.random() * 6) + 1;
                d6 = (int) (Math.random() * 6) + 1;
            } else {
                // Re-roll only the remaining dice (non-zero ones)
                if (d1 != 0) d1 = (int) (Math.random() * 6) + 1;
                if (d2 != 0) d2 = (int) (Math.random() * 6) + 1;
                if (d3 != 0) d3 = (int) (Math.random() * 6) + 1;
                if (d4 != 0) d4 = (int) (Math.random() * 6) + 1;
                if (d5 != 0) d5 = (int) (Math.random() * 6) + 1;
                if (d6 != 0) d6 = (int) (Math.random() * 6) + 1;
            }

            System.out.println("You rolled: " + d1 + ", " + d2 + ", " + d3 + ", " + d4 + ", " + d5 + ", " + d6);

            int[] dice = { d1, d2, d3, d4, d5, d6 };

            for (int i = 0; i < 6; i++) {
                for (int j = i + 1; j < 6; j++) {
                    if (dice[i] + dice[j] == 7) {
                        dice[i] = 0;
                        dice[j] = 0;
                    }
                }
            }

            d1 = dice[0];
            d2 = dice[1];
            d3 = dice[2];
            d4 = dice[3];
            d5 = dice[4];
            d6 = dice[5];

            roundScore = d1 + d2 + d3 + d4 + d5 + d6;
            System.out.println("Remaining dice: " + d1 + " " + d2 + " " + d3 + " " + d4 + " " + d5 + " " + d6);
            System.out.println("Your score: " + roundScore);

            if (rollCount < player1Rolls) {
                System.out.print("Roll again? (y/n): ");
                String answer = scan.next();
                if (!answer.equals("y")) {
                    break;
                }
            }
        }

        score2 = score2 + roundScore;
    }
}