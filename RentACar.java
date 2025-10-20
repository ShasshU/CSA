import java.util.Scanner;

public class RentACar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your name?");
        String name = scanner.nextLine();

        System.out.println("What is your age?");
        int age = scanner.nextInt();

        System.out.println("How much money do you have?");
        double money = scanner.nextDouble();

        if (age >= 25 && money >= 999) {
            System.out.println("You can rent a car " + name + "!");

        } else if (age > -25 && money < 999) {
            System.out.println(name + ", you cannot rent a car. You need more money.");
        } else {
            System.out.println(
                    name + ", you are not old enough to rent a car. You need to wait" + (25 - age) + " more years.");
        }

    }

}
