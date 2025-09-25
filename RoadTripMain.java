import java.util.Scanner;

public class RoadTripMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Car car = new Car(20, 15);
        EV ev = new EV(4, 85);
        Motorcycle motorcycle = new Motorcycle(60, 4);

        car.fillUp(15);
        ev.fillUp(85);
        motorcycle.fillUp(4);

        System.out.print("Enter miles to drive the Car: ");
        double carMiles = sc.nextDouble();
        car.goDrive(carMiles);
        car.showOdometer();
        car.checkRange();
        car.showFuelOrCharge();
        car.showTripLog();

        System.out.print("\nEnter miles to drive the EV: ");
        double evMiles = sc.nextDouble();
        ev.goDrive(evMiles);
        ev.showOdometer();
        ev.checkRange();
        ev.showFuelOrCharge();
        ev.showTripLog();

        System.out.print("\nEnter miles to drive the Motorcycle: ");
        double motorcycleMiles = sc.nextDouble();
        motorcycle.goDrive(motorcycleMiles);
        motorcycle.showOdometer();
        motorcycle.checkRange();
        motorcycle.showFuelOrCharge();
        motorcycle.showTripLog();

        sc.close();
    }
}