import java.util.ArrayList;

public class EV {

    double milesPerKWh;
    double batteryCapacity;
    double batteryLevel;
    double milesDriven;
    ArrayList<Double> tripLog; // extra credit #3

    public EV(double milesPerKWh, double batteryCapacity) {
        this.milesPerKWh = milesPerKWh;
        this.batteryCapacity = batteryCapacity;
        this.batteryLevel = 0;
        this.milesDriven = 0;
        this.tripLog = new ArrayList<>();
    }

    public void showOdometer() {
        System.out.println("Miles Driven (EV): " + milesDriven);
    }

    public void checkRange() {
        double range = milesPerKWh * batteryLevel;
        System.out.println("Miles Available (EV): " + range);
    }

    public void fillUp(double amount) {
        System.out.println("Adding charge to EV...");
        batteryLevel += amount;
        if (batteryLevel > batteryCapacity) {
            batteryLevel = batteryCapacity;
        }
    }

    public void goDrive(double distance) {
        if ((batteryLevel * milesPerKWh) >= distance) {
            System.out.println("Driving EV " + distance + " miles");
            milesDriven += distance;
            batteryLevel -= distance / milesPerKWh;
            tripLog.add(distance);
        } else {
            System.out.println("Can't drive EV " + distance + " miles. Not enough charge!");
        }
    }

    // extra credit #1
    public void showFuelOrCharge() {
        System.out.println("Charge left in EV: " + batteryLevel + " kWh");
    }

    // extra credit #2
    public void showTripLog() {
        System.out.println("EV Trip Log: " + tripLog);
    }
}