package originalgremlin.from051to100;

import originalgremlin.Euler;

import java.math.BigInteger;
import java.util.HashSet;

/**
 * Powerful digit counts
 * Problem 63
 *
 * The 5-digit number, 16807=7^5, is also a fifth power. Similarly, the 9-digit number, 134217728=8^9, is a ninth power.
 *
 * How many n-digit positive integers exist which are also an nth power?
 */

public class Problem63 {
    public static void main (String[] args) {
        HashSet<BigInteger> set = new HashSet<>();
        int base = 0;
        int exp;
        BigInteger num;
        int digits;
        OUTER: while (++base < 10) {
            exp = 0;
            INNER: while (++exp > 0) {
                num = new BigInteger(Integer.toString(base)).pow(exp);
                digits = Euler.numDigits(num);
                if (exp < digits) {
                    continue INNER;
                } else if (exp > digits) {
                    continue OUTER;
                } else {
                    System.out.format("%d %d %d%n", base, exp, num);
                    set.add(num);
                }
            }
        }
        System.out.println(set);
        System.out.println(set.size());
    }
}
