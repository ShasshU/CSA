import java.util.Scanner;

public class BMI_Index {

    public static double bmi(double height, double weight) {
        return weight / (height * height);
    }

    public static String weightClass(double height, double weight) {
        double bmiValue = bmi(height, weight);

        if (bmiValue < 18.5) {
            return "underweight";
        } else if (bmiValue < 25.0) {
            return "normal";
        } else if (bmiValue < 30.0) {
            return "overweight";
        } else {
            return "obese";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Would you like to calculate your weight using metric(m) or imperial(i) standard?\n");
        String standard = scanner.nextLine().toLowerCase();

        double height = 0;
        double weight = 0;

        if (standard.equals("i")) {
            System.out.print("\nHeight (in inches): ");
            double heightInches = scanner.nextDouble();

            System.out.print("Weight (in pounds): ");
            double weightPounds = scanner.nextDouble();

            height = heightInches * 0.0254; // inches to meters
            weight = weightPounds * 0.453592; // pounds to kilograms

            // calculate BMI using imperial formula
            double bmiValue = (weightPounds / (heightInches * heightInches)) * 703;

            System.out.println("BMI = " + bmiValue);
            System.out.println("You are considered " + weightClass(height, weight) + ".");

        } else if (standard.equals("m")) {
            System.out.print("\nHeight (in meters or centimeters): ");
            height = scanner.nextDouble();

            // convert cm to meters if necessary because height cant be more than 3 meters
            if (height > 3) { // assumes it's in centimeters
                height = height / 100;
            }

            System.out.print("Weight (in kilograms): ");
            weight = scanner.nextDouble();

            double bmiValue = bmi(height, weight);

            System.out.println("BMI = " + bmiValue);
            System.out.println("You are considered " + weightClass(height, weight) + ".");

        } else {
            System.out.println("Invalid input. Please enter 'm' or 'i'.");
        }

        scanner.close();
    }

}
