package J3;

import javax.swing.*;

public class EX2 {
    static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for(int i = 2; i <= Math.sqrt(n); i++){
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] primeArray = new int[21];
        int index = 0;


        for(int i = 10; i <= 99; i++){
            if(isPrime(i)){
                primeArray[index] = i;
                index++;  // Fixed: Increment index
            }
        }

        // Build output string
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Two-digit prime numbers:\n");
        stringBuilder.append("Count: ").append(index).append("\n\n");

        for(int i = 0; i < index; i++){
            stringBuilder.append(primeArray[i]).append(" ");
        }

        JOptionPane.showMessageDialog(null, stringBuilder.toString());
    }
}