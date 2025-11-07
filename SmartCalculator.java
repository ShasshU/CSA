import java.util.Scanner;

public class SmartCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(
                "Welcome to Smart Calculator!\nSelect a mode:\n1. Basic Math\n2. Geometry\n3. Conversions\n4. Quit");
        int mode = scanner.nextInt();
        scanner.nextLine();

        switch (mode) {
            case 1:
                System.out.println("Enter first number:");
                double firstNumber = scanner.nextDouble();
                System.out.println("Enter second number: ");
                double secondNumber = scanner.nextDouble();
                scanner.nextLine();

                System.out
                        .println("Choose operation: \n a. Addition\n b. Subtraction\n c. Multiplication\n d. Division");

                String mode1 = scanner.nextLine();

                double result;

                switch (mode1) {
                    case "a":
                        result = firstNumber + secondNumber;
                        System.out.println("Result is " + firstNumber + " + " + secondNumber + " = " + result);
                        break;
                    case "b":
                        result = firstNumber - secondNumber;
                        System.out.println("Result is " + firstNumber + " - " + secondNumber + " = " + result);
                        break;
                    case "c":
                        result = firstNumber * secondNumber;
                        System.out.println("Result is " + firstNumber + " * " + secondNumber + " = " + result);
                        break;
                    case "d":
                        result = firstNumber / secondNumber;
                        System.out.println("Result is " + firstNumber + " / " + secondNumber + " = " + result);
                        break;
                    default:
                        System.out.println("Invalid operation");
                }
                break;
            case 2:
                System.out.println("Choose shape:\n a. Circle (Area)\n b. Rectangle (Area)\n c. Triangle (Area)");
                String mode2 = scanner.nextLine();
                switch (mode2) {
                    case "a":
                        System.out.println("Enter radius: ");
                        double radius = scanner.nextDouble();
                        double areaCircle = Math.PI * Math.pow(radius, 2);
                        System.out.println("Area of Circle: " + areaCircle);
                        break;
                    case "b":
                        System.out.println("Enter length: ");
                        double length = scanner.nextDouble();
                        System.out.println("Enter width: ");
                        double width = scanner.nextDouble();
                        double areaRectangle = length * width;
                        System.out.println("Area of Rectangle: " + areaRectangle);
                        break;
                    case "c":
                        System.out.println("Enter base: ");
                        double base = scanner.nextDouble();
                        System.out.println("Enter height: ");
                        double height = scanner.nextDouble();
                        double areaTriangle = 0.5 * base * height;
                        System.out.println("Area of Triangle: " + areaTriangle);
                        break;
                    default:
                        System.out.println("Invalid shape");
                }
                break;
            case 3:
                System.out.println(
                        "Choose conversion:\n a. Celsius to Fahrenheit\n b. Fahrenheit to Celsius\n c. Inches to Centimeters\n d. Centimeters to Inches");
                String mode3 = scanner.nextLine();
                switch (mode3) {
                    case "a":
                        System.out.println("Enter temperature in Celsius: ");
                        double celsius = scanner.nextDouble();
                        double fahrenheit = (celsius * 9 / 5) + 32;
                        System.out.println(celsius + " Celsius is " + fahrenheit + " Fahrenheit.");
                        break;
                    case "b":
                        System.out.println("Enter temperature in Fahrenheit: ");
                        double fahr = scanner.nextDouble();
                        double cels = (fahr - 32) * 5 / 9;
                        System.out.println(fahr + " Fahrenheit is " + cels + " Celsius.");
                        break;
                    case "c":
                        System.out.println("Enter length in Inches: ");
                        double inches = scanner.nextDouble();
                        double centimeters = inches * 2.54;
                        System.out.println(inches + " Inches is " + centimeters + " Centimeters.");
                        break;
                    case "d":
                        System.out.println("Enter length in Centimeters: ");
                        double cms = scanner.nextDouble();
                        double inch = cms / 2.54;
                        System.out.println(cms + " Centimeters is " + inch + " Inches.");
                        break;
                    default:
                        System.out.println("Invalid conversion");
                }
                break;
            case 4:
                System.out.println("Goodbye! Thanks for using SmartCalculator.");
                break;
            default:
                System.out.println("Invalid mode");
        }
        scanner.close();
    }

}
