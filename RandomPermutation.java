/*=============================================================================
 |   Assignment:  Project 3.6.5 Memory Game - RandomPermutation Helper
 |       Author:  Shassh Umamaheswaran
 |      Partner:  None
 |
 |  Course Name:  AP Computer Science A
 |   Instructor:  Jonathan Virak
 |     Due Date:  March 17, 2026 3:30pm
 |
 |  Description:  Helper class for the Memory Game. Generates a random ordering
 |                of integers 0..n-1 with no repeats. Also has an overloaded
 |                next() method that takes a String array and returns a randomly
 |                shuffled copy of it.
 |
 |     Language:  Java 8
 | Ex. Packages:  java.util.Random
 |
 | Deficiencies:  NA
 *===========================================================================*/

import java.util.Random;

public class RandomPermutation {

    private int n;
    private Random rand;

    public RandomPermutation(int n) {
        this.n = n;
        this.rand = new Random();
    }

    // returns a randomly ordered array of integers 0..n-1 with no repeats
    public int[] next() {
        int[] perm = new int[n];
        for (int i = 0; i < n; i++) perm[i] = i;

        for (int i = n - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = perm[i];
            perm[i] = perm[j];
            perm[j] = temp;
        }

        return perm;
    }

    // overload: returns a randomly shuffled copy of the given String array
    public String[] next(String[] items) {
        String[] result = items.clone();

        for (int i = result.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            String temp = result[i];
            result[i] = result[j];
            result[j] = temp;
        }

        return result;
    }
}
