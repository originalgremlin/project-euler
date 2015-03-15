package originalgremlin.from001to050;

/**
 * Self powers
 * Problem 48
 *
 * The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.
 *
 * Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
 */

import java.math.BigInteger;
import java.util.stream.IntStream;

public class Problem48 {
    public static void main (String[] args) {
        int N = 1000;
        BigInteger big = BigInteger.ZERO;
        for (int i = 1; i <= N; i++) {
            big = big.add(new BigInteger(Integer.toString(i)).pow(i));
        }
        BigInteger answer = big.remainder(new BigInteger("10").pow(10));
        System.out.println(answer.toString());
    }
}
