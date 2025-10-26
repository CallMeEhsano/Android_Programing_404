package InClassProgram.Three;

public class Rectangle {
    // Private fields
    private double width;
    private double height;
    
    // Default constructor
    public Rectangle() {
        this.width = 1.0;
        this.height = 1.0;
    }
    
    // Parameterized constructor
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    // Copy constructor
    public Rectangle(Rectangle other) {
        this.width = other.width;
        this.height = other.height;
    }
    
    // Getter methods
    public double getWidth() {
        return width;
    }
    
    public double getHeight() {
        return height;
    }
    
    // Setter methods
    public void setWidth(double width) {
        if (width > 0) {
            this.width = width;
        } else {
            System.out.println("Width must be positive!");
        }
    }
    
    public void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        } else {
            System.out.println("Height must be positive!");
        }
    }
    
    // Method to calculate area
    public double getArea() {
        return width * height;
    }
    
    // Method to calculate perimeter
    public double getPerimeter() {
        return 2 * (width + height);
    }
    
    // Method to check if rectangle is a square
    public boolean isSquare() {
        return width == height;
    }
    
    // Method to scale rectangle
    public void scale(double factor) {
        if (factor > 0) {
            this.width *= factor;
            this.height *= factor;
        } else {
            System.out.println("Scale factor must be positive!");
        }
    }
    
    // Method to compare rectangles
    public boolean equals(Rectangle other) {
        if (other == null) return false;
        return this.width == other.width && this.height == other.height;
    }
    
    // toString method
    @Override
    public String toString() {
        return String.format("Rectangle[width=%.2f, height=%.2f, area=%.2f, perimeter=%.2f]", 
                           width, height, getArea(), getPerimeter());
    }
    
    // Static method to create a square
    public static Rectangle createSquare(double side) {
        return new Rectangle(side, side);
    }
    
    // Static method to find the larger rectangle
    public static Rectangle getLarger(Rectangle r1, Rectangle r2) {
        if (r1.getArea() > r2.getArea()) {
            return r1;
        } else {
            return r2;
        }
    }
}

