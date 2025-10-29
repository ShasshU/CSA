import java.util.Scanner;

public class Bill {
    // attributes
    private double costOfMeal;
    private int totalCustomers;
    Scanner input = new Scanner(System.in);

    // Constructor
    public Bill(double totalBill, int numCustomers) {
        costOfMeal = totalBill;
        totalCustomers = numCustomers;
    }

    // Add a tip based on the number of guests

    public void addTip() {
        /* Your code here */
        if (totalCustomers >= 8) {
            costOfMeal = costOfMeal * 1.25;
        } else if (totalCustomers >= 4 && totalCustomers < 8) {
            costOfMeal = costOfMeal * 1.2;
        } else if (totalCustomers >= 2 && totalCustomers < 4) {
            costOfMeal = costOfMeal * 1.15;
        } else {
            System.out.println("How much would you like to tip (as a percentage)? ");
            double tipPercentage = input.nextDouble();
            costOfMeal = costOfMeal * (1 + tipPercentage / 100);
        }

    }

    public String toString() {
        // Round the bill to two decimal places
        double roundedBill = Math.round(costOfMeal * 100) / 100.0;

        return "The total cost of the bill with tip for " + totalCustomers + " customers comes to $" + roundedBill;
    }
}
