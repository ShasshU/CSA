public class ShapeMain {
    public static void main(String[] args) {
        // Create a triangle with sides 6
        Shape triangle = new Shape("triangle", 6);

        // Create a square with sides 5
        Shape square = new Shape("square", 5);

        // Create a circle with radius 8
        Shape circle = new Shape("circle", 8);

        // call and print perimeter/area of Triangle
        System.out.println("Perimeter of triangle: " + triangle.getPerimeter());
        System.out.println("Area of triangle: " + triangle.getArea());
        // call and print perimeter/area of Square

        System.out.println();

        System.out.println("Perimeter of square: " + square.getPerimeter());
        System.out.println("Area of square: " + square.getArea());
        // call and print perimeter/area of Circle

        System.out.println();

        System.out.println("Perimeter of circle: " + circle.getPerimeter());
        System.out.println("Area of circle: " + circle.getArea());
    }
}