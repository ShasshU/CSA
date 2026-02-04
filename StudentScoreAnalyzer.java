import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StudentScoreAnalyzer {

    public static void main(String[] args) {

        // ArrayLists to store data
        ArrayList<Integer> studentIDs = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> testNames = new ArrayList<>();
        ArrayList<Integer> scores = new ArrayList<>();

        // Student test score data
        String[] data = {
                "1001,Alice Nguyen,Unit 1 Test,78",
                "1002,Brandon Lee,Unit 1 Test,85",
                "1003,Carlos Martinez,Unit 1 Test,92",
                "1004,Diana Patel,Unit 1 Test,88",
                "1005,Ethan Johnson,Unit 1 Test,69",
                "1006,Fatima Khan,Unit 1 Test,94",
                "1007,Grace Kim,Unit 1 Test,81",
                "1008,Hannah Brown,Unit 1 Test,73",
                "1009,Isaac Wilson,Unit 1 Test,90",
                "1010,Jasmine Lopez,Unit 1 Test,84",
                "1011,Kevin Chen,Unit 1 Test,76",
                "1012,Liam OConnor,Unit 1 Test,89",
                "1013,Maya Rodriguez,Unit 1 Test,95",
                "1014,Noah Smith,Unit 1 Test,67",
                "1015,Olivia Davis,Unit 1 Test,88" };

        // Read data into ArrayLists
        for (String row : data) {
            String[] parts = row.split(",");
            studentIDs.add(Integer.parseInt(parts[0]));
            names.add(parts[1]);
            testNames.add(parts[2]);
            scores.add(Integer.parseInt(parts[3]));
        }

        // calculates the sum and the count (realized we could just do scores.size()
        // after)
        int sum = 0;
        int count = 0;
        for (int i = 0; i < scores.size(); i++) {
            sum += scores.get(i);
            count++;
        }
        double average = (double) sum / count; // converts average to a double

        // find highest and lowest
        int highest = scores.get(0);
        int lowest = scores.get(0);
        for (int score : scores) {
            if (score > highest) {
                highest = score;
            }
            if (score < lowest) {
                lowest = score;
            }
        }

        // curve scores by +5, max 100
        for (int i = 0; i < scores.size(); i++) {
            int updated = scores.get(i) + 5;
            if (updated > 100) {
                updated = 100;
            }
            scores.set(i, updated);
        }

        // count students with 90 or above
        int highScoreCount = 0;
        for (int score : scores) {
            if (score >= 90) {
                highScoreCount++;
            }
        }

        // Print report
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("STUDENT SCORE REPORT");
        System.out.println("Report Generated: " + now.format(formatter));
        System.out.println("-----------------------------------------------");
        System.out.println("Average Score: " + average);
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);
        System.out.println();

        // Print curved scores
        System.out.println("UPDATED SCORES (After Curve)");
        System.out.println("ID\tName\t\t\tTest\t\tScore");
        System.out.println("------------------------------------------------");

        for (int i = 0; i < studentIDs.size(); i++) {
            System.out.println(
                    studentIDs.get(i) + "\t" + names.get(i) + "\t\t" + testNames.get(i) + "\t" + scores.get(i));
        }

        System.out.println();
        System.out.println("Students scoring 90 or above after curve: " + highScoreCount);
    }
}
