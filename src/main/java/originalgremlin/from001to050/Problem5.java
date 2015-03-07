package originalgremlin.from001to050;

import java.util.stream.LongStream;

/**
 * Smallest multiple
 * Problem 5
 *
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */

public class Problem5 {
    public static void main (String[] args) {
        int n = 32;
        long max = LongStream
            .rangeClosed(1, n)
            .reduce(1, (a, b) -> lcm(a, b));
        System.out.println(max);
    }

    public static long lcm (long a, long b) {
        return a * b / gcd(a, b);
    }

    public static long gcd (long a, long b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}
