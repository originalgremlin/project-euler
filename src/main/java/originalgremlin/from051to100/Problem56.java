package originalgremlin.from051to100;

import originalgremlin.Euler;

import java.math.BigInteger;

/**
 * Powerful digit sum
 * Problem 56
 *
 * A googol (10^100) is a massive number: one followed by one-hundred zeros;
 * 100^100 is almost unimaginably large: one followed by two-hundred zeros.
 *
 * Despite their size, the sum of the digits in each number is only 1. Considering natural numbers of the form, ab,
 * where a, b < 100, what is the maximum digital sum?
 */

public class Problem56 {
    public static void main (String[] args) {
        int max = 0;
        int sum;
        BigInteger big;
        for (int a = 1; a < 100; a++) {
            for (int b = 1; b < 100; b++) {
                big = new BigInteger(Integer.toString(a)).pow(b);
                sum = Euler.sumOfDigits(big);
                max = Math.max(sum, max);
            }
        }
        System.out.println(max);
    }
}
