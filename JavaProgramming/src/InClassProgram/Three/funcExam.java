package InClassProgram.Three;

public class funcExam {
    public static void main(String[] args) {
        // Test the generic method that returns double
        System.out.println("Sum of integers: " + sumToDouble(10, 20, 30));
        System.out.println("Sum of doubles: " + sumToDouble(1.5, 2.5, 3.5));
        System.out.println("Sum of mixed numbers: " + sumToDouble(10, 20.5, 30));
        
        // Test with different number types
        System.out.println("Average: " + average(10, 20, 30, 40));
        System.out.println("Product: " + product(2.5, 3.0, 4.0));
    }
    
    // Generic method that converts numbers to double and returns their sum
    public static <T extends Number> double sumToDouble(T... numbers) {
        double sum = 0.0;
        for (T number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }
    
    // Generic method that returns average as double
    public static <T extends Number> double average(T... numbers) {
        if (numbers.length == 0) return 0.0;
        
        double sum = 0.0;
        for (T number : numbers) {
            sum += number.doubleValue();
        }
        return sum / numbers.length;
    }
    
    // Generic method that returns product as double
    public static <T extends Number> double product(T... numbers) {
        double result = 1.0;
        for (T number : numbers) {
            result *= number.doubleValue();
        }
        return result;
    }
}
