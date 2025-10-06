public class WrapperExamples {
    public static void main(String[] args) {

        Integer num = new Integer(10);
        int primitiveNum = num.intValue();
        System.out.println("Primitive int value: " + primitiveNum);

        Double doubleNum = new Double(5.5);
        double primitiveDouble = doubleNum.doubleValue();
        System.out.println("Primitive double value: " + primitiveDouble);

        // max double value
        Double maxDouble = Double.MAX_VALUE;
        System.out.println("Maximum Double value: " + maxDouble);

        // min double value
        Double minDouble = Double.MIN_VALUE;
        System.out.println("Minimum Double value: " + minDouble);

        // unboxing
        Integer wrappedNum2 = new Integer(30);
        int unboxedNum = wrappedNum2;
        System.out.println("Unboxed int value: " + unboxedNum);
        // autoboxing
        int primitiveNum2 = 40;
        Integer autoboxedNum = primitiveNum2;
        System.out.println("Autoboxed Integer value: " + autoboxedNum);

    }
}