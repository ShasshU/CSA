
// starter code
import java.util.Scanner;

public class BillMain {
    public static void main(String[] args) {
        int guests;
        double cost;
        Scanner input = new Scanner(System.in);
        System.out.print("Number of guests: ");
        guests = input.nextInt();
        System.out.print("Cost of meal: $");
        cost = input.nextDouble();
        Bill check = new Bill(cost, guests);
        check.addTip();
        System.out.println(check);
    }
}
