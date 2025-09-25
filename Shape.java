public class Shape {
    // attributes
    private String type; // type of shape: triangle, square, or circle
    private double length; // length of a side of an equilateral triangle or square. length of radius of a
                           // circle

    // Constructors
    public Shape(String type, double length) {
        this.type = type;
        this.length = length;
    }

    // methods getPerimeter() & getArea()
    public double getPerimeter() {
        if (this.type.equals("triangle")) {
            return 3 * this.length;
        } else if (this.type.equals("square")) {
            return 4 * this.length;
        } else if (this.type.equals("circle")) {
            return 2 * 3.14 * this.length;
        } else {
            System.out.println("Unknown shape type");
            return 0;
        }
    }

    public double getArea() {
        if (this.type.equals("triangle")) {
            return 0.25 * 1.732 * length * length;
        } else if (this.type.equals("square")) {
            return this.length * this.length;
        } else if (this.type.equals("circle")) {
            return 3.14 * this.length * this.length;
        } else {
            System.out.println("Unknown shape type");
            return 0;
        }
    }

}