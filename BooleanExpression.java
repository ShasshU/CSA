import java.util.Scanner;

public class BooleanExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input a number");
        double firstNumber = scanner.nextDouble();

        System.out.println("Input another number");
        double secondNumber = scanner.nextDouble();

        System.out
                .println(firstNumber + " IS LESS THAN " + secondNumber + " evalues to " + (firstNumber < secondNumber));
        System.out.println(
                firstNumber + " IS GREATER THAN " + secondNumber + " evalues to " + (firstNumber > secondNumber));
        System.out
                .println(firstNumber + " IS EQUAL TO " + secondNumber + " evalues to " + (firstNumber == secondNumber));
        System.out.println(
                firstNumber + " IS NOT EQUAL TO " + secondNumber + " evalues to " + (firstNumber != secondNumber));
        System.out.println(firstNumber + " IS GREATER THAN OR EQUAL TO " + secondNumber + " evalues to "
                + (firstNumber >= secondNumber));
        System.out.println(firstNumber + " IS LESS THAN OR EQUAL TO " + secondNumber + " evalues to "
                + (firstNumber <= secondNumber));

    }

}
