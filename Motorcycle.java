import java.util.ArrayList;

public class Motorcycle {

    double mpg;
    double tankSize;
    double gasInTank;
    double milesDriven;
    ArrayList<Double> tripLog;

    public Motorcycle(double mpg, double tankSize) {
        this.mpg = mpg;
        this.tankSize = tankSize;
        this.gasInTank = 0;
        this.milesDriven = 0;
        this.tripLog = new ArrayList<>();
    }

    public void showOdometer() {
        System.out.println("Miles Driven (Motorcycle): " + milesDriven);
    }

    public void checkRange() {
        double range = mpg * gasInTank;
        System.out.println("Miles Available (Motorcycle): " + range);
    }

    public void fillUp(double amount) {
        System.out.println("Adding gas to motorcycle...");
        gasInTank += amount;
        if (gasInTank > tankSize) {
            gasInTank = tankSize;
        }
    }

    public void goDrive(double distance) {
        if ((gasInTank * mpg) >= distance) {
            System.out.println("Driving motorcycle " + distance + " miles");
            milesDriven += distance;
            gasInTank -= distance / mpg;
            tripLog.add(distance);
        } else {
            System.out.println("Can't drive motorcycle " + distance + " miles. That's too far!");
        }
    }

    // Extra Credit #1
    public void showFuelOrCharge() {
        System.out.println("Gas left in Motorcycle: " + gasInTank + " gallons");
    }

    // Extra Credit #2
    public void showTripLog() {
        System.out.println("Motorcycle Trip Log: " + tripLog);
    }
}