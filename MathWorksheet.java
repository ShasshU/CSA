public class MathWorksheet {
    public static void main(String[] args) {

        int num1 = 5;
        int num2 = 10;

        System.out.println(3 % 7); // LINE 1
        System.out.println(7 % 5); // LINE 2
        System.out.println(7.2 % 4); // LINE 3
        System.out.println('a' + 1); // LINE 4
        System.out.println('a' + (char) 1); // LINE 5
        System.out.println(Math.pow(4, 3)); // LINE 6
        System.out.println(Math.ceil(2.09)); // LINE 7
        System.out.println(Math.floor(5.8)); // LINE 8
        System.out.println(Math.sqrt(25)); // LINE 9
        System.out.println(Math.sqrt(36.0)); // LINE 10
        System.out.println(Math.round(6.34)); // LINE 11
        System.out.println(Math.round(6.56)); // LINE 12
        System.out.println(Math.abs(-7.3)); // LINE 13
        System.out.println(Math.abs(23)); // LINE 14
        System.out.println(Math.ceil(Math.sqrt(24))); // LINE 15

        System.out.println(++num1);
        System.out.println(num2++);

        System.out.println(++num2 / num1++);

        System.out.println((char) ('A' + 1));
    }

}
