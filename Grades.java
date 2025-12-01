import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Grades {
    public static void main(String[] args) {
        Scanner shawn = new Scanner(System.in);

        LocalDateTime startTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("Grade Counter Program");
        System.out.println("Start Date and Time: " + startTime.format(formatter));

        int gradeA = 0;
        int gradeB = 0;
        int gradeC = 0;
        int gradeD = 0;
        int gradeF = 0;

        System.out.println("Enter your grades (0-100). Enter -1 when done:");

        int grade = 0;
        while (grade != -1) {
            System.out.print("Enter a grade: ");
            grade = shawn.nextInt();

            if (grade == -1) {
                break;
            }

            if (grade < 0 || grade > 100) {
                System.out.println("Invalid grade! Please enter a grade between 0 and 100.");
                continue;
            }

            if (grade >= 90 && grade <= 100) {
                gradeA++;
            } else if (grade >= 80 && grade < 90) {
                gradeB++;
            } else if (grade >= 70 && grade < 80) {
                gradeC++;
            } else if (grade >= 60 && grade < 70) {
                gradeD++;
            } else if (grade >= 0 && grade < 60) {
                gradeF++;
            }
        }

        System.out.println("\nGrade Distribution:");
        System.out.println("Total A's (90-100): " + gradeA);
        System.out.println("Total B's (80-89):  " + gradeB);
        System.out.println("Total C's (70-79):  " + gradeC);
        System.out.println("Total D's (60-69):  " + gradeD);
        System.out.println("Total F's (0-59):   " + gradeF);

        int totalGrades = gradeA + gradeB + gradeC + gradeD + gradeF;
        System.out.println("Total grades entered: " + totalGrades);

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("End Date and Time: " + endTime.format(formatter));
        shawn.close();
    }
}
