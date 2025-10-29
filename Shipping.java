import java.util.Scanner;

public class Shipping {
    public static void main(String[] args) {
        double shippingCost = 0;
        int shippingDays = 5;
        String secretCode = "COUPON17";
        Scanner input = new Scanner(System.in);

        // code goes below
        System.out.println("Weight of package: ");
        double weight = input.nextDouble();
        input.nextLine();
        System.out.println("What is the method of shipping? Standard, Express, or Overnight: ");
        String method = input.nextLine();

        System.out.println("Coupon code (enter 'none' if there is no coupon): ");
        String coupon = input.nextLine();

        if (0 < weight && weight < 1) {
            shippingCost = 1.0;
        } else if (weight >= 1 && weight < 7) {
            shippingCost = 7.5;
            shippingDays += 1;
        } else {
            shippingCost = 10.25;
            shippingDays += 3;
        }

        if (method.equalsIgnoreCase("Standard")) {
            shippingDays += 3;
        } else if (method.equalsIgnoreCase("Express")) {
            shippingCost += 10.0;
            shippingDays -= 3;
        } else if (method.equalsIgnoreCase("Overnight")) {
            shippingCost += 20.0;
            shippingDays = 1;
        }
        if (coupon.equals(secretCode)) {
            shippingCost -= 2.0;
            if (shippingCost < 0) {
                shippingCost = 0;
            }
        }

        // print final shipping cost and days
        System.out.println("\nTotal Shipping Cost: $" + shippingCost);
        System.out.println("Days to Deliver: " + shippingDays);

    }
}