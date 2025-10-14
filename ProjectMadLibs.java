import java.util.Scanner;

public class ProjectMadLibs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String originalStory = "Yesterday in science class, we were supposed to mix exactly [INTEGER] drops of mystery liquid into a beaker. But I accidentally used [FLOAT/DECIMAL NUMBER] drops instead!\n"
                + //
                "The mixture started bubbling and turned [COLOR]. My lab partner asked, \"Is it supposed to smell like [NOUN]?\"\n"
                + //
                "I checked my notes and realized the \"safe\" setting was [BOOLEAN: true/false], but I had definitely set it to the opposite! The beaker started shaking and our teacher yelled \"EVACUATE!\"\n"
                + //
                "The good news? I got extra credit for \"thinking outside the box.\" The bad news? We're not allowed near the chemistry lab for a month.";
        System.out.println(originalStory);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Modify the original story!");

        System.out.println("Enter a whole number:");
        int number = scanner.nextInt();

        System.out.println("Enter a decimal: ");
        double decimal = scanner.nextDouble();

        System.out.println("Enter a color: ");
        String color = scanner.nextLine();
        color = scanner.nextLine();

        System.out.println("Enter a noun");
        String noun = scanner.nextLine();

        System.out.println("Enter true or false: ");
        Boolean booleanTF = scanner.nextBoolean();

        String madLib = originalStory.replace("[INTEGER]", String.valueOf(number));
        madLib = madLib.replace("[FLOAT/DECIMAL NUMBER]", String.valueOf(decimal));
        madLib = madLib.replace("[COLOR]", color);
        madLib = madLib.replace("[NOUN]", noun);
        madLib = madLib.replace("[BOOLEAN: true/false]", String.valueOf(booleanTF));

        System.out.println(madLib);

        scanner.close();

    }

}
