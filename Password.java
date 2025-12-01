// FRQ 1: Password

public class Password {

    // Question 1 FRQ, Part a

    public static boolean isValid(String password) {
        int len = password.length();
        if (len >= 8 && len <= 16) {
            return hasUpper(password) && hasLower(password) && hasDigit(password);
        }
        return false;
    }

    // Question 2 FRQ, Part b
    public static String makePasswordLetters(String phrase) {
        String result = "";
        String[] words = phrase.split(" ");

        int i = 0;
        while (i < words.length) {
            result += words[i].charAt(0);
            i++;
        }
        return result;
    }

    public static String makePassword(String phrase, int n) {
        String letters = makePasswordLetters(phrase);
        String digits = "";

        while (n > 0) {
            digits = n % 10 + digits;
            n = n / 10;
        }

        String password = letters + digits;

        if (isValid(password)) {
            return password;
        }
        return null;
    }
}
