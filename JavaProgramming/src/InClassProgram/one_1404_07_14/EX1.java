/*
Getting even numbers in range 10-100 and prime numbers up to a given number
 */



package InClassProgram.one_1404_07_14;

import java.util.ArrayList;

public class EX1 {

    // Method to find all prime numbers up to num
    static void givePrimeNumber(int num) {
        ArrayList<Integer> primes = new ArrayList<>();

        for (int j = 2; j <= num; j++) {
            boolean isPrime = true;

            // Check if j is divisible by any number from 2 to sqrt(j)
            for (int i = 2; i <= Math.sqrt(j); i++) {
                if (j % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                primes.add(j);
            }
        }

        // Convert ArrayList to array
        int[] result = new int[primes.size()];
        for (int i = 0; i < primes.size(); i++) {
            result[i] = primes.get(i);
        }

        System.out.println("\nPrime numbers up to " + num + ":");
        for (int prime : result) {
            System.out.print(prime + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        // Get even numbers in range 10-100
        int[] evenArray = new int[45];
        for (int i = 10, j = 0; i < 100; i++) {
            if (i % 2 == 0) {
                evenArray[j] = i;
                j++;
            }
        }

        System.out.println("Even numbers from 10 to 100:");
        for (int num : evenArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Get prime numbers up to 100
        givePrimeNumber(100);
    }
}