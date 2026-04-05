//Assignment 3: Inheritance, Method Overriding, and Method Overloading

// PROGRAM 1: SHAPES 
class Shapes {
    double area;

    // Constructor Overloading - Circle
    Shapes(double radius) {
        area = 3.14 * radius * radius;
        System.out.println("Area of Circle: " + area);
    }

    // Constructor Overloading - Rectangle
    Shapes(double length, double breadth) {
        area = length * breadth;
        System.out.println("Area of Rectangle: " + area);
    }

    // Method Overloading - Triangle
    void area(double base, double height) {
        area = 0.5 * base * height;
        System.out.println("Area of Triangle: " + area);
    }
}

// PROGRAM 2: HILLSTATIONS

// Parent Class
class Hillstations {

    // Method to be overridden
    void famousfor() {
        System.out.println("Hillstation is famous for its beautiful scenery");
    }
    
    void famousfood() {
        System.out.println("Hillstation has delicious local cuisine");
    }
}

// Subclass 1
class Manali extends Hillstations {

    @Override
    void famousfor() {
        System.out.println("Manali is famous for snow and mountains");
    }

    @Override
    void famousfood() {
        System.out.println("Manali's famous food: Fish");
    }
}

// Subclass 2
class Mussoorie extends Hillstations {

    @Override
    void famousfor() {
        System.out.println("Mussoorie is famous for hills and waterfalls");
    }

    @Override
    void famousfood() {
        System.out.println("Mussoorie famous food: Momos");
    }
}

// Subclass 3
class Gulmarg extends Hillstations {

    @Override
    void famousfor() {
        System.out.println("Gulmarg is famous for skiing");
    }

    @Override
    void famousfood() {
        System.out.println("Gulmarg famous food: Rogan Josh");
    }
}

// ---------------- MAIN CLASS ----------------
public class assign_03 {
    public static void main(String[] args) {

        // Shapes Program 
        System.out.println("---- Shapes Program ----");

        Shapes circle = new Shapes(10 );           // Circle
        Shapes rectangle = new Shapes(5, 6);     // Rectangle

        Shapes triangle = new Shapes(0);         // Dummy object
        triangle.area(3, 4);                     // Triangle

        // Hillstations Program
        System.out.println("\n---- Hillstations Program ----");

        Hillstations h;

        h = new Manali();
        h.famousfor();
        h.famousfood();

        h = new Mussoorie();
        h.famousfor();
        h.famousfood();

        h = new Gulmarg();
        h.famousfor();
        h.famousfood();
    }
}