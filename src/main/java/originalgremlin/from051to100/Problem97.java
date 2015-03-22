package originalgremlin.from051to100;

import java.math.BigInteger;

/**
 * Large non-Mersenne prime
 * Problem 97
 *
 * The first known prime found to exceed one million digits was discovered in 1999, and is a Mersenne prime of the
 * form 2^6972593−1; it contains exactly 2,098,960 digits. Subsequently other Mersenne primes, of the form 2^p−1,
 * have been found which contain more digits.
 *
 * However, in 2004 there was found a massive non-Mersenne prime which contains 2,357,207 digits: 28433×2^7830457+1.
 *
 * Find the last ten digits of this prime number.
 */

public class Problem97 {
    public static void main (String[] args) {
        System.out.println(new BigInteger("2").pow(7830457).multiply(new BigInteger("28433")).add(BigInteger.ONE).mod(new BigInteger("10000000000")).toString());
    }
}
