import java.util.ArrayList;

public class Car {

    double mpg;
    double tankSize;
    double gasInTank;
    double milesDriven;
    ArrayList<Double> tripLog; // extra credit #3

    public Car(double mpg, double tankSize) {
        this.mpg = mpg;
        this.tankSize = tankSize;
        this.gasInTank = 0;
        this.milesDriven = 0;
        this.tripLog = new ArrayList<>();
    }

    public void showOdometer() {
        System.out.println("Miles Driven (Car): " + milesDriven);
    }

    public void checkRange() {
        double range = mpg * gasInTank;
        System.out.println("Miles Available (Car): " + range);
    }

    public void fillUp(double amount) {
        System.out.println("Adding gas to car...");
        gasInTank += amount;
        if (gasInTank > tankSize) {
            gasInTank = tankSize;
        }
    }

    public void goDrive(double distance) {
        if ((gasInTank * mpg) >= distance) {
            System.out.println("Driving car " + distance + " miles");
            milesDriven += distance;
            gasInTank -= distance / mpg;
            tripLog.add(distance);
        } else {
            System.out.println("Can't drive car " + distance + " miles. That's too far!");
        }
    }

    // extra credit #1
    public void showFuelOrCharge() {
        System.out.println("Gas left in Car: " + gasInTank + " gallons");
    }

    // extra redit #2
    public void showTripLog() {
        System.out.println("Car Trip Log: " + tripLog);
    }
}