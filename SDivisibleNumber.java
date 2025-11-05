public class SDivisibleNumber {
    public static void main(String[] args) {
        int number = 0;
        boolean found = false;

        for (int i = 1; i <= 10000; i++) {
            if (i % 1 == 0 &&
                    i % 2 == 0 &&
                    i % 3 == 0 &&
                    i % 4 == 0 &&
                    i % 5 == 0 &&
                    i % 6 == 0 &&
                    i % 7 == 0 &&
                    i % 8 == 0 &&
                    i % 9 == 0 &&
                    i % 10 == 0) {

                number = i;
                found = true;
                break;
            } else {
                continue;
            }
        }

        if (found) {
            System.out.println("The smallest number evenly divisible by 1-10 is: " + number);
        } else {
            System.out.println("Number not found in range. Try increasing the limit.");
        }
    }
}