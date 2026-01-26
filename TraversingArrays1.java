import java.util.ArrayList;

public class TraversingArrays1 {
    public static void main(String[] args) {
        // Creating an ArrayList of Integers
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);

        // Standard for loop to print each number
        for (int i = 0; i <= numbers.size() - 1; i++) {
            System.out.println(numbers.get(i));
        }

        // Enhanced for loop to print each number
        for (Integer num : numbers) {
            System.out.println(num);
        }

    }
}