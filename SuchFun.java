public class SuchFun {
    public static void main(String[] args) {
        SuchFun sf = new SuchFun();
        sf.suchFun(1, 2, 3);
        sf.suchFun(2, 2, 2);
        sf.suchFun(1, 2, 1);
    }

    public void suchFun(int a, int b, int c) {
        if (a != b && b != c && a != c) {
            System.out.println("Unique");
        } else if (a == b && b == c) {
            System.out.println("Boring");
        } else {
            System.out.println("Twins");
        }
    }
}
