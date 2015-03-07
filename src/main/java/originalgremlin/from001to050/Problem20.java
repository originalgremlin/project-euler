package originalgremlin.from001to050;

import java.math.BigInteger;

/**
 * Factorial digit sum
 * Problem 20
 *
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 *
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 *
 * Find the sum of the digits in the number 100!
 */

public class Problem20 {
    public static void main (String[] args) {
        BigInteger big = BigInteger.ONE;
        for (int i = 1; i <= 100; i++) {
            big = big.multiply(new BigInteger(Integer.toString(i)));
        }
        int sum = big.toString().chars().map(Character::getNumericValue).sum();
        System.out.println(sum);
    }
}
