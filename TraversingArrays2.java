import java.util.ArrayList;

public class TraversingArrays2 {
    public static void main(String[] args) {
        // Creating an ArrayList of Integers
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);

        // Calculating the sum using the standard for loop
        int sum = 0;
        for (int i = 0; i <= numbers.size() - 1; i++) {
            sum += numbers.get(i);
        }
        System.out.println("Sum: " + sum);

        // Calculating the sum using the enhanced for loop
        int enhancedsum = 0;
        for (Integer num : numbers) {
            enhancedsum += num;
        }
        System.out.println("Enhanced Sum: " + enhancedsum);

    }
}
