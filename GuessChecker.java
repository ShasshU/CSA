import java.util.Scanner;

public class GuessChecker {
    public static void main(String[] args) {
        /* Add any variables you will need throughout the program here. */
        // Part 1: Hit counter variable - 11/05/2025
        int hits = 0;
        // Part 2: Near hit counter variable - 11/07/2025
        int nearHits = 0;
        // Part 3: Guess counter and maximum guesses - 11/10/2025
        int maxGuesses = 3;
        int guessCount = 0;
        boolean correctGuess = false;

        // Generate the random number
        String targetStr = makeCode();
        System.out.println(targetStr); // uncommented for Part 1

        // Break the random number into four variables.
        int r1 = Integer.parseInt(targetStr.substring(0, 1));
        int r2 = Integer.parseInt(targetStr.substring(1, 2));
        int r3 = Integer.parseInt(targetStr.substring(2, 3));
        int r4 = Integer.parseInt(targetStr.substring(3, 4));

        // Part 3: Loop to give user multiple guesses - 11/10/2025
        // Using compound boolean expression to check if user should continue guessing
        while (guessCount < maxGuesses && !correctGuess) {
            // Reset counters for each guess - 11/10/2025
            hits = 0;
            nearHits = 0;

            // Get the user's guess.
            String guess = getGuess();

            // Break the user's guess into four variables.
            int g1 = Integer.parseInt(guess.substring(0, 1));
            int g2 = Integer.parseInt(guess.substring(1, 2));
            int g3 = Integer.parseInt(guess.substring(2, 3));
            int g4 = Integer.parseInt(guess.substring(3, 4));

            /* Part 1: Check for hits (correct digit in correct position) - 11/05/2025 */
            if (g1 == r1) {
                hits++;
            }
            if (g2 == r2) {
                hits++;
            }
            if (g3 == r3) {
                hits++;
            }
            if (g4 == r4) {
                hits++;
            }

            /* Part 2: Check for near hits - 11/07/2025 */
            // Check if g1 matches any other position (not position 1)
            if (g1 != r1 && (g1 == r2 || g1 == r3 || g1 == r4)) {
                nearHits++;
            }
            // Check if g2 matches any other position (not position 2)
            if (g2 != r2 && (g2 == r1 || g2 == r3 || g2 == r4)) {
                nearHits++;
            }
            // Check if g3 matches any other position (not position 3)
            if (g3 != r3 && (g3 == r1 || g3 == r2 || g3 == r4)) {
                nearHits++;
            }
            // Check if g4 matches any other position (not position 4)
            if (g4 != r4 && (g4 == r1 || g4 == r2 || g4 == r3)) {
                nearHits++;
            }

            guessCount++;

            // Display results for this guess
            System.out.println("Number of hits: " + hits);
            System.out.println("Number of near hits: " + nearHits);

            // Part 3: Check if user guessed correctly using compound boolean - 11/10/2025
            if (hits == 4 && nearHits == 0) {
                correctGuess = true;
            }

            System.out.println("You have " + (maxGuesses - guessCount) + " guesses remaining.");
            System.out.println();
        }

        // Part 3: Final message - 11/10/2025
        if (correctGuess) {
            System.out.println("Congratulations! You guessed the code!");
        } else {
            System.out.println("Sorry, you've run out of guesses. The code was: " + targetStr);
        }
    }

    // Checks to ensure no duplicate digits in a int
    public static boolean hasDupes(int num) {
        boolean[] digs = new boolean[10];
        while (num > 0) {
            if (digs[num % 10])
                return true;
            digs[num % 10] = true;
            num /= 10;
        }
        return false;
    }

    // Creates a new random 4 digit code 1000-9999 with no duplicates
    public static String makeCode() {
        int target = (int) (Math.random() * 9000 + 1000);
        while (hasDupes(target))
            target = (int) (Math.random() * 9000 + 1000);
        String targetStr = target + "";
        return targetStr;
    }

    // Prompts the user for a guess and repeats until valid guess is made
    public static String getGuess() {
        Scanner sc = new Scanner(System.in);
        boolean validGuess = false;
        int userGuess = 0;
        while (!validGuess) {
            System.out.print("Guess a 4-digit number from 1000 to 9999 with no duplicate digits: ");
            userGuess = sc.nextInt();
            if (!(hasDupes(userGuess) || (userGuess < 1000)))
                validGuess = true;
        }
        String userStr = userGuess + "";
        return userStr;
    }
}