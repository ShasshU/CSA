import java.util.Random;

public class ActivityDirector {
    public static void main(String[] args) {
        Random rand = new Random();

        int temp = rand.nextInt(92) + 10;

        System.out.println("Temperature:");
        System.out.println(temp);

        if (temp >= 80) {
            System.out.println("Go swimming!");
        } else if (temp >= 60 && temp < 80) {
            System.out.println("Play tennis!");
        } else if (temp >= 40 && temp < 60) {
            System.out.println("Play golf!");
        } else {
            System.out.println("Go skiing!");
        }

        if (temp > 95 || temp < 20) {
            System.out.println("Visit our shops!");
        }
    }
}