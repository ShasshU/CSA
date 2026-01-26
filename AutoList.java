import java.util.ArrayList;

public class AutoList {
    private String model;
    private int year;
    private double value;
    static ArrayList<AutoList> showroom = new ArrayList<AutoList>();

    public AutoList(String model, int year, double value) {
        this.model = model;
        this.year = year; 
        this.value = value;
        showroom.add(this);
        // add this car to showroom

    }

    // getter methods for each specific object so therefore not static
    public String getModel() {
        return this.model;
    }

    public int getYear() {
        return this.year;
    }

    public double getValue() {
        return this.value;
    }

    // static methods

    public static String printShowroom() {
        String names = "";
        for (AutoList name : showroom) {
            names += name.getModel() + "\n";
        }
        return "\n" + names;
    }

    public static String getBestInShow() {
        return showroom.get(0).getModel();
    }

    public static void gotBought(int index) {
        showroom.remove(index);
    }

    public static String oldestCar() {
        AutoList oldest = showroom.get(0);
        for (AutoList AutoList : showroom) {
            if (AutoList.getYear() < oldest.getYear()) {
                oldest = AutoList;
            }
        }
        return oldest.getModel();
    }
}