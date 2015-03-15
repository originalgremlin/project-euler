package originalgremlin.from001to050;

import originalgremlin.Euler;

import java.util.HashSet;

/**
 * Consecutive prime sum
 * Problem 50
 *
 * The prime 41, can be written as the sum of six consecutive primes:
 * 41 = 2 + 3 + 5 + 7 + 11 + 13
 *
 * This is the longest sum of consecutive primes that adds to a prime below one-hundred.
 *
 * The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.
 *
 * Which prime, below one-million, can be written as the sum of the most consecutive primes?
 */

public class Problem50 {
    public static void main (String[] args) {
        int N = 1000000;
        long[] primes = Euler.getPrimesLessThan(N);

        HashSet<Long> set = new HashSet<>();
        for (long prime : primes) {
            set.add(prime);
        }

        long max = 0, maxCount = 0, sum;
        for (int i = 0; i < primes.length; i++) {
            sum = 0;
            for (int j = 0; sum < N && i + j < primes.length; j++) {
                sum += primes[i + j];
                if (j > maxCount && set.contains(sum)) {
                    maxCount = j;
                    max = sum;
                }
            }
        }
        System.out.format("%d %d%n", maxCount + 1, max);
    }
}
