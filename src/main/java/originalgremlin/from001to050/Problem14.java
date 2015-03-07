package originalgremlin.from001to050;

import java.util.Date;
import java.util.LinkedList;

/**
 * Longest Collatz sequence
 * Problem 14
 *
 * The following iterative sequence is defined for the set of positive integers:
 *
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 *
 * Using the rule above and starting with 13, we generate the following sequence:
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 *
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
 * Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 *
 * Which starting number, under one million, produces the longest chain?
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */

public class Problem14 {
    public static void main (String[] args) {
        long N = 1000000;
        long current;
        long max = 0;
        long rv = 0;

        for (int i = 1; i < N; i++) {
            current = collatzCount(i);
            if (current > max) {
                max = current;
                rv = i;
            }
        }
        System.out.println(rv);
    }

    private static long collatzCount (long n) {
        long count = 1;
        while (n != 1) {
            n = (n % 2 == 0) ? (n / 2) : (3 * n + 1);
            count++;
        }
        return count;
    }
}
