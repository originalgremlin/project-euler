package originalgremlin.from051to100;

import originalgremlin.Euler;

import java.math.BigInteger;

/**
 * Square root convergence
 * Problem 57
 *
 * It is possible to show that the square root of two can be expressed as an infinite continued fraction.
 * √ 2 = 1 + 1/(2 + 1/(2 + 1/(2 + ... ))) = 1.414213...
 *
 * By expanding this for the first four iterations, we get:
 * 1 + 1/2 = 3/2 = 1.5
 * 1 + 1/(2 + 1/2) = 7/5 = 1.4
 * 1 + 1/(2 + 1/(2 + 1/2)) = 17/12 = 1.41666...
 * 1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...
 *
 * The next three expansions are 99/70, 239/169, and 577/408, but the eighth expansion, 1393/985, is the first
 * example where the number of digits in the numerator exceeds the number of digits in the denominator.
 *
 * In the first one-thousand expansions, how many fractions contain a numerator with more digits than denominator?
 */

public class Problem57 {
    public static void main (String[] args) {
        int count = 0;
        BigInteger numerator = new BigInteger("1");
        BigInteger denominator = new BigInteger("2");
        BigInteger temp;
        for (int i = 2; i <= 1000; i++) {
            // 2 + n/d
            numerator = numerator.add(denominator).add(denominator);
            // 1 / (2 + n/d)
            temp = numerator;
            numerator = denominator;
            denominator = temp;
            // numerator has more digits?
            if (Euler.numDigits(numerator.add(denominator)) > Euler.numDigits(denominator)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
