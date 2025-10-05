package J2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Taklif2 {
    static double factorial(int num){
        if (num == 1){
            return 1; //base
        }
        else{
            return num*factorial(num-1);
        }
    }

    static boolean isPrime(int num){
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
        while (num != 0){
            sum = sum + num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Math Functions Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout(10, 10));

        // Title panel
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Mathematical Operations");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titlePanel.add(titleLabel);
        frame.add(titlePanel, BorderLayout.NORTH);

        // Main panel with buttons and input
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        // Input field
        JLabel inputLabel = new JLabel("Enter Number:");
        inputLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        JTextField inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 14));

        mainPanel.add(inputLabel);
        mainPanel.add(inputField);

        // Factorial button
        JButton factorialBtn = new JButton("Calculate Factorial");
        factorialBtn.setFont(new Font("Arial", Font.BOLD, 12));
        factorialBtn.setBackground(new Color(100, 149, 237));
        factorialBtn.setForeground(Color.WHITE);
        JLabel factorialResult = new JLabel("");
        factorialResult.setFont(new Font("Arial", Font.PLAIN, 12));

        mainPanel.add(factorialBtn);
        mainPanel.add(factorialResult);

        // Prime check button
        JButton primeBtn = new JButton("Check if Prime");
        primeBtn.setFont(new Font("Arial", Font.BOLD, 12));
        primeBtn.setBackground(new Color(60, 179, 113));
        primeBtn.setForeground(Color.WHITE);
        JLabel primeResult = new JLabel("");
        primeResult.setFont(new Font("Arial", Font.PLAIN, 12));

        mainPanel.add(primeBtn);
        mainPanel.add(primeResult);

        // Sum of digits button
        JButton sumBtn = new JButton("Sum of Digits");
        sumBtn.setFont(new Font("Arial", Font.BOLD, 12));
        sumBtn.setBackground(new Color(255, 140, 0));
        sumBtn.setForeground(Color.WHITE);
        JLabel sumResult = new JLabel("");
        sumResult.setFont(new Font("Arial", Font.PLAIN, 12));

        mainPanel.add(sumBtn);
        mainPanel.add(sumResult);

        frame.add(mainPanel, BorderLayout.CENTER);

        // Clear button at bottom
        JPanel bottomPanel = new JPanel();
        JButton clearBtn = new JButton("Clear All");
        clearBtn.setFont(new Font("Arial", Font.BOLD, 12));
        clearBtn.setBackground(new Color(220, 20, 60));
        clearBtn.setForeground(Color.WHITE);
        bottomPanel.add(clearBtn);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Action Listeners
        factorialBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int num = Integer.parseInt(inputField.getText());
                    if (num < 1) {
                        factorialResult.setText("Enter positive number");
                        factorialResult.setForeground(Color.RED);
                    } else if (num > 20) {
                        factorialResult.setText("Number too large (max 20)");
                        factorialResult.setForeground(Color.RED);
                    } else {
                        double result = factorial(num);
                        factorialResult.setText("Result: " + String.format("%.0f", result));
                        factorialResult.setForeground(new Color(0, 100, 0));
                    }
                } catch (NumberFormatException ex) {
                    factorialResult.setText("Invalid input");
                    factorialResult.setForeground(Color.RED);
                }
            }
        });

        primeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int num = Integer.parseInt(inputField.getText());
                    if (num < 2) {
                        primeResult.setText("Enter number >= 2");
                        primeResult.setForeground(Color.RED);
                    } else {
                        boolean result = isPrime(num);
                        if (result) {
                            primeResult.setText(num + " is PRIME");
                            primeResult.setForeground(new Color(0, 100, 0));
                        } else {
                            primeResult.setText(num + " is NOT prime");
                            primeResult.setForeground(new Color(139, 0, 0));
                        }
                    }
                } catch (NumberFormatException ex) {
                    primeResult.setText("Invalid input");
                    primeResult.setForeground(Color.RED);
                }
            }
        });

        sumBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int num = Integer.parseInt(inputField.getText());
                    if (num < 0) {
                        num = Math.abs(num); // Handle negative numbers
                    }
                    int result = sumOfDigits(num);
                    sumResult.setText("Sum: " + result);
                    sumResult.setForeground(new Color(0, 100, 0));
                } catch (NumberFormatException ex) {
                    sumResult.setText("Invalid input");
                    sumResult.setForeground(Color.RED);
                }
            }
        });

        clearBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inputField.setText("");
                factorialResult.setText("");
                primeResult.setText("");
                sumResult.setText("");
            }
        });

        // Allow Enter key on input field to trigger all calculations
        inputField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                factorialBtn.doClick();
                primeBtn.doClick();
                sumBtn.doClick();
            }
        });

        // Center the frame on screen
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}