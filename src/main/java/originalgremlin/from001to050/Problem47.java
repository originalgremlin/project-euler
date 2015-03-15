package originalgremlin.from001to050;

import originalgremlin.Euler;

import java.util.stream.IntStream;

/**
 * Distinct primes factors
 * Problem 47
 *
 * The first two consecutive numbers to have two distinct prime factors are:
 * 14 = 2 × 7
 * 15 = 3 × 5
 *
 * The first three consecutive numbers to have three distinct prime factors are:
 * 644 = 2² × 7 × 23
 * 645 = 3 × 5 × 43
 * 646 = 2 × 17 × 19.
 *
 * Find the first four consecutive integers to have four distinct prime factors.  What is the first of these numbers?
 */

public class Problem47 {
    public static void main (String[] args) {
        int N = 4;
        int i = 1;
        int count = 0;
        long distinct;
        while (count < N) {
            distinct = Euler.getPrimeFactors(i).stream().distinct().count();
            if (distinct == N) {
                count++;
            } else {
                count = 0;
            }
            i++;
        }
        System.out.println(i - N);
    }
}
