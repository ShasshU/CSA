import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Arrays {

    // returns the last element of a String array
    public static String getLastElement(String[] array) {
        return array[array.length - 1];
    }

    // prints all elements in a String array
    public static void printArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Item " + (i + 1) + ": " + array[i]);
        }
    }

    public static void main(String[] args) {
        // print current date and time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy 'at' hh:mm:ss a");
        System.out.println("Program executed on: " + now.format(formatter));
        System.out.println();

        // parallel arrays for city climate data
        String[] cities = { "Las Vegas", "Minsk", "Sao Paulo" };
        int[] avgHighTemps = { 104, 73, 80 };
        double[] avgPrecipitation = { 4.17, 26.7, 55.0 };

        // print climate data for each city
        for (int i = 0; i < cities.length; i++) {
            System.out.println(cities[i] + " has an average annual precipitation of "
                    + avgPrecipitation[i] + " inches.");
            System.out.println(cities[i] + " has an average annual high temp of "
                    + avgHighTemps[i] + " degrees Fahrenheit.");
        }

        System.out.println();

        // test getLastElement method
        String lastCity = getLastElement(cities);
        System.out.println("The last element of the String array is: " + lastCity);

        System.out.println();

        // test printArray method
        printArray(cities);
    }
}
