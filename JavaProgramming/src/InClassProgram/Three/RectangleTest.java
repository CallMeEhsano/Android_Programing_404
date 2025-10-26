package InClassProgram.Three;

public class RectangleTest {
    public static void main(String[] args) {
        // Create rectangles using different constructors
        Rectangle rect1 = new Rectangle(); // Default constructor
        Rectangle rect2 = new Rectangle(5.0, 3.0); // Parameterized constructor
        Rectangle rect3 = new Rectangle(rect2); // Copy constructor
        
        // Display rectangle information
        System.out.println("Rectangle 1 (default): " + rect1);
        System.out.println("Rectangle 2 (5x3): " + rect2);
        System.out.println("Rectangle 3 (copy of rect2): " + rect3);
        
        // Test methods
        System.out.println("\n--- Testing Methods ---");
        System.out.println("Rectangle 2 area: " + rect2.getArea());
        System.out.println("Rectangle 2 perimeter: " + rect2.getPerimeter());
        System.out.println("Is Rectangle 2 a square? " + rect2.isSquare());
        
        // Create a square
        Rectangle square = Rectangle.createSquare(4.0);
        System.out.println("\nSquare (4x4): " + square);
        System.out.println("Is it a square? " + square.isSquare());
        
        // Test scaling
        System.out.println("\n--- Testing Scaling ---");
        System.out.println("Before scaling: " + rect2);
        rect2.scale(2.0);
        System.out.println("After scaling by 2: " + rect2);
        
        // Test comparison
        System.out.println("\n--- Testing Comparison ---");
        Rectangle rect4 = new Rectangle(10.0, 6.0);
        System.out.println("Rectangle 2 equals Rectangle 4? " + rect2.equals(rect4));
        
        // Test static method
        System.out.println("\n--- Testing Static Method ---");
        Rectangle larger = Rectangle.getLarger(rect1, rect2);
        System.out.println("Larger rectangle: " + larger);
        
        // Test setters with validation
        System.out.println("\n--- Testing Setters ---");
        rect1.setWidth(-5.0); // Should show error message
        rect1.setWidth(7.0);  // Should work
        rect1.setHeight(4.0);
        System.out.println("Rectangle 1 after setting dimensions: " + rect1);
    }
}

