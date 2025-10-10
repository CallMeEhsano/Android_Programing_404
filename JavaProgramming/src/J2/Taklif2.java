package J2;

import javax.swing.JOptionPane;

public class Taklif2 {
    static double factorial(int num){
        if (num == 1 || num == 0){
            return 1; //base
        }
        else{
            return num*factorial(num-1);
        }
    }

    static boolean isPrime(int num){
        if (num < 2){
            return false;
        }
        if (num == 2){
            return true;
        }
        else{
            for (int i = 2; i <= Math.sqrt(num); i++){
                if (num % i == 0){
                    return false;
                }
            }
        }
        return true;
    }

    static int sumOfDigits(int num){
        int sum = 0;
        num = Math.abs(num); // Handle negative numbers
        while (num != 0){
            sum = sum + num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            // Display menu
            String menu = "Please select an option:\n\n" +
                    "1. Calculate Factorial\n" +
                    "2. Check if Number is Prime\n" +
                    "3. Calculate Sum of Digits\n" +
                    "4. Exit";

            String choice = JOptionPane.showInputDialog(null, menu,
                    "Main Menu", JOptionPane.QUESTION_MESSAGE);

            // If user clicks Cancel or closes the window
            if (choice == null) {
                int confirm = JOptionPane.showConfirmDialog(null,
                        "Do you want to exit?",
                        "Confirm Exit",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    exit = true;
                }
                continue;
            }

            try {
                int option = Integer.parseInt(choice.trim());

                switch (option) {
                    case 1:
                        // Calculate factorial
                        String numStr = JOptionPane.showInputDialog(null,
                                "Enter a number to calculate its factorial:",
                                "Factorial",
                                JOptionPane.QUESTION_MESSAGE);

                        if (numStr != null) {
                            int num = Integer.parseInt(numStr.trim());
                            if (num < 0) {
                                JOptionPane.showMessageDialog(null,
                                        "Factorial is not defined for negative numbers!",
                                        "Error",
                                        JOptionPane.ERROR_MESSAGE);
                            } else {
                                double result = factorial(num);
                                JOptionPane.showMessageDialog(null,
                                        "Factorial of " + num + " = " + (long)result,
                                        "Result",
                                        JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                        break;

                    case 2:
                        // Check if prime
                        numStr = JOptionPane.showInputDialog(null,
                                "Enter a number to check if it's prime:",
                                "Prime Number",
                                JOptionPane.QUESTION_MESSAGE);

                        if (numStr != null) {
                            int num = Integer.parseInt(numStr.trim());
                            boolean prime = isPrime(num);
                            String message = prime ?
                                    "The number " + num + " is a prime number ✓" :
                                    "The number " + num + " is not a prime number ✗";
                            JOptionPane.showMessageDialog(null,
                                    message,
                                    "Result",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;

                    case 3:
                        // Calculate sum of digits
                        numStr = JOptionPane.showInputDialog(null,
                                "Enter a number to calculate the sum of its digits:",
                                "Sum of Digits",
                                JOptionPane.QUESTION_MESSAGE);

                        if (numStr != null) {
                            int num = Integer.parseInt(numStr.trim());
                            int sum = sumOfDigits(num);
                            JOptionPane.showMessageDialog(null,
                                    "Sum of digits of " + num + " = " + sum,
                                    "Result",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;

                    case 4:
                        // Exit
                        int confirm = JOptionPane.showConfirmDialog(null,
                                "Are you sure you want to exit?",
                                "Confirm Exit",
                                JOptionPane.YES_NO_OPTION);
                        if (confirm == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null,
                                    "Thank you for using this program!",
                                    "Goodbye",
                                    JOptionPane.INFORMATION_MESSAGE);
                            exit = true;
                        }
                        break;

                    default:
                        JOptionPane.showMessageDialog(null,
                                "Please enter a number between 1 and 4!",
                                "Invalid Input",
                                JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Please enter a valid number!",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        System.exit(0);
    }
}