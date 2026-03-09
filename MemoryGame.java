/*=============================================================================
 |   Assignment:  Project 3.6.5 Memory Game
 |       Author:  Shassh Umamaheswaran
 |      Partner:  None
 |
 |  Course Name:  AP Computer Science A
 |   Instructor:  Jonathan Virak
 |     Due Date:  March 17, 2026 3:30pm
 |
 |  Description:  Memory Game that shows a random sequence of single-character
 |                strings in a row of buttons one at a time. The player then
 |                recreates the sequence from memory. Tracks score across rounds.
 |                Enhancements: difficulty levels, vary speed, vary sequence
 |                length, and randomized button colors.
 |
 |     Language:  Java 8
 | Ex. Packages:  java.time.LocalDateTime,
 |                java.time.format.DateTimeFormatter,
 |                javax.swing.JOptionPane
 |
 | Deficiencies:  NA
 *===========================================================================*/

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class MemoryGame {

    public static void main(String[] args) {

        // display program name and current date/time using Java Time API
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy hh:mm:ss a");
        System.out.println("Memory Game - Project 3.6.5");
        System.out.println("Started: " + now.format(formatter));

        // ask the player to pick a difficulty level
        String[] levels = {
            "Easy   (3 buttons | starts 2-item sequence | 1.0s)",
            "Medium (4 buttons | starts 2-item sequence | 0.7s)",
            "Hard   (5 buttons | starts 3-item sequence | 0.5s)",
            "Expert (6 buttons | starts 3-item sequence | 0.3s)"
        };

        int levelChoice = JOptionPane.showOptionDialog(null,
            "Welcome to Memory Game!\nSelect a difficulty level:",
            "Memory Game", JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE, null, levels, levels[0]);

        if (levelChoice < 0) {
            System.out.println("Game cancelled.");
            return;
        }

        int numButtons;
        int seqLength;
        double delay; // measured in tenths of a second

        switch (levelChoice) {
            case 1:  numButtons = 4; seqLength = 2; delay = 7;  break;
            case 2:  numButtons = 5; seqLength = 3; delay = 5;  break;
            case 3:  numButtons = 6; seqLength = 3; delay = 3;  break;
            default: numButtons = 3; seqLength = 2; delay = 10; break;
        }

        // ask if the player wants a randomized or non-randomized board
        int randChoice = JOptionPane.showConfirmDialog(null,
            "Randomize button order during play?",
            "Board Type", JOptionPane.YES_NO_OPTION);
        boolean isRandom = (randChoice == JOptionPane.YES_OPTION);

        // create the "memory strings" - an array of single character strings to
        // show in the buttons, one element at a time
        String[] allStrings = {"A", "B", "C", "D", "E", "F"};
        String[] memoryStrings = new String[numButtons];
        for (int i = 0; i < numButtons; i++) {
            memoryStrings[i] = allStrings[i];
        }

        // create the game and gameboard, configure a randomized board
        MemoryGameGUI game = new MemoryGameGUI();
        game.createBoard(numButtons, isRandom);

        int score = 0;
        int rounds = 0;
        int currentSeqLength = seqLength;
        double currentDelay = delay;

        // play the game until user wants to quit
        do {
            rounds++;
            System.out.println("\nRound " + rounds);

            // create a new array that will contain the randomly ordered memory strings
            String[] randomSequence = new String[currentSeqLength];

            // create a list of randomly ordered integers with no repeats, the length
            // of memory strings, and use it to create a random sequence
            RandomPermutation rp = new RandomPermutation(numButtons);
            int[] perm = rp.next();
            for (int i = 0; i < currentSeqLength; i++) {
                randomSequence[i] = memoryStrings[perm[i]];
            }

            System.out.print("Sequence: ");
            for (String s : randomSequence) System.out.print(s + " ");
            System.out.println();

            // play one sequence, delaying half a second for the strings to show
            // in the buttons, save the player's guess
            String guess = game.playSequence(randomSequence, currentDelay);

            if (guess == null) {
                System.out.println("Player cancelled.");
                JOptionPane.showMessageDialog(null, "Game cancelled.", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
                break;
            }

            if (guess.trim().isEmpty()) {
                System.out.println("No input entered.");
                JOptionPane.showMessageDialog(null, "You didn't enter anything. Try again!", "No Input", JOptionPane.WARNING_MESSAGE);

            } else {
                // cleanup the guess - remove commas and spaces
                String cleanGuess = guess.replace(",", "").replace(" ", "").toUpperCase();

                System.out.println("Guess: " + cleanGuess);

                String expected = "";
                for (String s : randomSequence) expected += s;

                // iterate to determine if guess matches sequence
                boolean match = true;

                if (cleanGuess.length() != randomSequence.length) {
                    match = false;
                    if (cleanGuess.length() > randomSequence.length) {
                        System.out.println("Guess was too long.");
                        JOptionPane.showMessageDialog(null, "Your guess was too long! The sequence was only "
                            + randomSequence.length + " character(s).", "Too Long", JOptionPane.WARNING_MESSAGE);
                    } else {
                        System.out.println("No match. Expected: " + expected);
                        game.tryAgain();
                    }
                } else {
                    for (int i = 0; i < randomSequence.length; i++) {
                        if (!String.valueOf(cleanGuess.charAt(i)).equals(randomSequence[i])) {
                            match = false;
                            break;
                        }
                    }

                    // if match, increase score, and signal a match, otherwise try again
                    if (match) {
                        score++;
                        System.out.println("Match! Score: " + score + "/" + rounds);
                        game.matched();

                        // vary the speed of the game after each correct answer
                        if (currentDelay > 3) currentDelay -= 0.5;

                        // vary the length of the sequence after each correct answer
                        if (currentSeqLength < numButtons) currentSeqLength++;

                    } else {
                        System.out.println("No match. Expected: " + expected);
                        game.tryAgain();
                    }
                }
            }

            // ask if user wants to play another round of the game
        } while (game.playAgain());

        // when done playing, show score and end the game
        game.showScore(score, rounds);
        System.out.println("\nFinal score: " + score + " / " + rounds);
        now = LocalDateTime.now();
        System.out.println("Ended: " + now.format(formatter));

        game.quit();
    }
}
