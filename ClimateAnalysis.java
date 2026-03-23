/*=============================================================================
 |   Assignment:  Project 2D Array Climate Analysis
 |       Author:  Shassh Umamaheswaran
 |      Partner:  None
 |
 |  Course Name:  AP Computer Science A
 |   Instructor:  Jonathan Virak
 |     Due Date:  March 28, 2026 3:30pm
 |
 |  Description:  This program simulates a 300x300 grid of temperature sensors
 |                spread across a large region. Each cell holds a temperature
 |                in degrees Celsius. The program calculates the overall average,
 |                the hottest and coldest locations, row and column averages, and
 |                counts heat wave cells (above 35C). It also applies a calibration
 |                fix (+1.5C to every cell) and normalizes extreme values to the
 |                range [0, 50]. The Java Time API is used to display the current
 |                date and time at startup.
 |
 |     Language:  Java 8
 | Ex. Packages:  java.time.LocalDateTime,
 |                java.time.format.DateTimeFormatter
 |
 | Deficiencies:  NA
 *===========================================================================*/

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClimateAnalysis {

    // returns the average temperature across the entire grid
    public static double getAverage(double[][] grid) {
        double sum = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                sum += grid[r][c];
            }
        }
        return sum / (grid.length * grid[0].length);
    }

    // returns the highest temperature found anywhere in the grid
    public static double getMax(double[][] grid) {
        double max = grid[0][0];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] > max) {
                    max = grid[r][c];
                }
            }
        }
        return max;
    }

    // returns the lowest temperature found anywhere in the grid
    public static double getMin(double[][] grid) {
        double min = grid[0][0];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] < min) {
                    min = grid[r][c];
                }
            }
        }
        return min;
    }

    // returns the average temperature of a single row
    public static double rowAverage(double[][] grid, int row) {
        double sum = 0;
        for (int c = 0; c < grid[row].length; c++) {
            sum += grid[row][c];
        }
        return sum / grid[row].length;
    }

    // returns the average temperature of a single column
    public static double columnAverage(double[][] grid, int col) {
        double sum = 0;
        for (int r = 0; r < grid.length; r++) {
            sum += grid[r][col];
        }
        return sum / grid.length;
    }

    // counts how many cells are above 35C (heat wave threshold)
    public static int heatWaveCount(double[][] grid) {
        int count = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] > 35) {
                    count++;
                }
            }
        }
        return count;
    }

    // adds 1.5 to every cell to correct the sensor under-reading
    public static void calibrate(double[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                grid[r][c] += 1.5;
            }
        }
    }

    // clamps all values to the range [0, 50]
    public static void normalize(double[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] < 0) {
                    grid[r][c] = 0;
                } else if (grid[r][c] > 50) {
                    grid[r][c] = 50;
                }
            }
        }
    }

    public static void main(String[] args) {
        // display program name and timestamp using Java Time API
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy hh:mm:ss a");
        System.out.println("Climate Analysis Program");
        System.out.println("Started: " + now.format(formatter));
        System.out.println();

        // build the 300x300 sensor grid with random temperatures from -15 to 60C
        // this range ensures some values hit the normalize boundaries on both ends
        int rows = 300;
        int cols = 300;
        double[][] grid = new double[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // random value in [-15, 60)
                grid[r][c] = Math.random() * 75 - 15;
            }
        }

        System.out.println("=== Before Calibration ===");
        System.out.printf("Overall Average : %.2f C%n", getAverage(grid));
        System.out.printf("Hottest Cell    : %.2f C%n", getMax(grid));
        System.out.printf("Coldest Cell    : %.2f C%n", getMin(grid));
        System.out.printf("Row 0 Average   : %.2f C%n", rowAverage(grid, 0));
        System.out.printf("Row 150 Average : %.2f C%n", rowAverage(grid, 150));
        System.out.printf("Col 0 Average   : %.2f C%n", columnAverage(grid, 0));
        System.out.printf("Col 150 Average : %.2f C%n", columnAverage(grid, 150));
        System.out.printf("Heat Wave Cells : %d (> 35 C)%n", heatWaveCount(grid));

        // all sensors read 1.5C too cold, fix the whole grid
        calibrate(grid);
        System.out.println("\n=== After Calibration (+1.5 C) ===");
        System.out.printf("Overall Average : %.2f C%n", getAverage(grid));
        System.out.printf("Hottest Cell    : %.2f C%n", getMax(grid));
        System.out.printf("Coldest Cell    : %.2f C%n", getMin(grid));
        System.out.printf("Heat Wave Cells : %d (> 35 C)%n", heatWaveCount(grid));

        // clamp anything below 0 to 0 and anything above 50 to 50
        normalize(grid);
        System.out.println("\n=== After Normalization [0, 50] ===");
        System.out.printf("Overall Average : %.2f C%n", getAverage(grid));
        System.out.printf("Hottest Cell    : %.2f C%n", getMax(grid));
        System.out.printf("Coldest Cell    : %.2f C%n", getMin(grid));
        System.out.printf("Heat Wave Cells : %d (> 35 C)%n", heatWaveCount(grid));
    }
}
