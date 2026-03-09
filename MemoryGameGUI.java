/*=============================================================================
 |   Assignment:  Project 3.6.5 Memory Game - GUI Class
 |       Author:  Shassh Umamaheswaran
 |      Partner:  None
 |
 |  Course Name:  AP Computer Science A
 |   Instructor:  Jonathan Virak
 |     Due Date:  March 17, 2026 3:30pm
 |
 |  Description:  GUI class for the Memory Game. Extends JFrame to build a row
 |                of buttons that flash memory strings one at a time. Handles
 |                all dialogs for player input, score display, and game flow.
 |
 |     Language:  Java 8
 | Ex. Packages:  javax.swing, java.awt
 |
 | Deficiencies:  NA
 *===========================================================================*/

import javax.swing.*;
import java.awt.*;

public class MemoryGameGUI extends JFrame {

    private JButton[] buttons;
    private Color[] buttonColors;
    private boolean playRandom;
    private int numButtons;

    // each button gets one of these colors so they are all visually distinct
    private Color[] palette = {
        Color.RED, Color.GREEN, Color.BLUE,
        Color.YELLOW, Color.ORANGE, Color.MAGENTA
    };

    public MemoryGameGUI() {
        setTitle("Memory Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void createBoard(int numButtons, Boolean playRandom) {
        this.numButtons = numButtons;
        this.playRandom = playRandom;

        buttons = new JButton[numButtons];
        buttonColors = new Color[numButtons];

        JPanel buttonPanel = new JPanel(new GridLayout(1, numButtons, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        buttonPanel.setBackground(new Color(173, 216, 230));

        for (int i = 0; i < numButtons; i++) {
            buttonColors[i] = palette[i];
            buttons[i] = new JButton(" ");
            buttons[i].setFont(new Font("Arial", Font.BOLD, 48));
            buttons[i].setPreferredSize(new Dimension(110, 110));
            buttons[i].setBackground(buttonColors[i]);
            buttons[i].setOpaque(true);
            buttons[i].setBorderPainted(false);
            buttonPanel.add(buttons[i]);
        }

        JLabel titleLabel = new JLabel("Memory Game", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        getContentPane().removeAll();
        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public String playSequence(String[] sequence, double delay) {
        int delayMs = (int) (delay * 100);

        // determine which button to flash for each item in the sequence
        int[] order = new int[sequence.length];
        if (playRandom) {
            RandomPermutation rp = new RandomPermutation(numButtons);
            int[] perm = rp.next();
            for (int i = 0; i < sequence.length; i++) {
                order[i] = perm[i % numButtons];
            }
        } else {
            for (int i = 0; i < sequence.length; i++) {
                order[i] = i % numButtons;
            }
        }

        for (int i = 0; i < sequence.length; i++) {
            int btnIdx = order[i];

            buttons[btnIdx].setText(sequence[i]);
            buttons[btnIdx].repaint();

            try { Thread.sleep(delayMs); } catch (InterruptedException e) {}

            buttons[btnIdx].setText(" ");
            buttons[btnIdx].repaint();

            try { Thread.sleep(200); } catch (InterruptedException e) {}
        }

        return JOptionPane.showInputDialog(this,
            "What was the sequence?\n(Enter the characters in order, e.g. A B C or A,B,C)",
            "Your Turn!", JOptionPane.QUESTION_MESSAGE);
    }

    public void matched() {
        JOptionPane.showMessageDialog(this,
            "Correct! You remembered the sequence!",
            "Great Job!", JOptionPane.INFORMATION_MESSAGE);
    }

    public void tryAgain() {
        JOptionPane.showMessageDialog(this,
            "Not quite right. Keep trying!",
            "Try Again", JOptionPane.WARNING_MESSAGE);
    }

    public boolean playAgain() {
        int result = JOptionPane.showConfirmDialog(this,
            "Would you like to play another round?",
            "Play Again?", JOptionPane.YES_NO_OPTION);
        return result == JOptionPane.YES_OPTION;
    }

    public void showScore(int score, int rounds) {
        JOptionPane.showMessageDialog(this,
            "Final Score: " + score + " correct out of " + rounds + " round(s)",
            "Game Over", JOptionPane.INFORMATION_MESSAGE);
    }

    public void quit() {
        dispose();
        System.exit(0);
    }
}
