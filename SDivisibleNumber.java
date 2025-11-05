public class SDivisibleNumber {
    public static void main(String[] args) {

        for (int i = 1; i <= 10000; i++) {

            if (i % 2 != 0 || i % 3 != 0 || i % 4 != 0 || i % 5 != 0) {
                continue;

            } else if (i % 6 != 0 || i % 7 != 0 || i % 8 != 0) {
                continue;

            } else if (i % 9 != 0 || i % 10 != 0) {
                continue;

            } else {
                System.out.println("The smallest number evenly divisible by 1-10 is: " + i);
                break;
            }
        }
    }
}