public class SDivisibleNumber {
    public static void main(String[] args) {
        int result = 1;

        result = result * 8;

        result = result * 9;

        result = result * 5;

        result = result * 7;

        System.out.println("The smallest number evenly divisible by 1-10 is: " + result);

        if (result % 1 == 0 && result % 2 == 0 && result % 3 == 0 &&
                result % 4 == 0 && result % 5 == 0 && result % 6 == 0 &&
                result % 7 == 0 && result % 8 == 0 && result % 9 == 0 &&
                result % 10 == 0) {
            System.out.println("Verified: " + result + " is divisible by all numbers 1-10");
        } else {
            System.out.println("Error in calculation");
        }
    }
}