package originalgremlin;

import java.util.stream.IntStream;

/**
 * Largest prime factor
 * Problem 3
 *
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 */

public class Problem3 {
    public static void main (String[] args) {
        long num = 600851475143L;
        long sqrt = Math.round(Math.sqrt(num));
        long i = 3;
        while (i < sqrt) {
            if (num % i == 0) {
                num /= i;
                sqrt = Math.round(Math.sqrt(num));
            } else {
                i += 2;
            }
        }
        System.out.println(num);
    }
}
