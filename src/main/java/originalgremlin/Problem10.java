package originalgremlin;

import java.util.ArrayList;
import java.util.stream.LongStream;

/**
 * Summation of primes
 * Problem 10
 *
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 *
 */

public class Problem10 {
    private static ArrayList<Long> primes = new ArrayList<>();

    public static void main (String[] args) {
        long sum = LongStream
                .range(2, 2000000)
                .filter(i -> i % 2 == 1 || i == 2)
                .filter(i -> isPrime(i))
                .sum();
        System.out.println(sum);
    }

    private static boolean isPrime (long test) {
        long sqrt = Math.round(Math.sqrt(test));
        for (long prime : primes) {
            if (prime > sqrt) {
                break;
            } else if (test % prime == 0) {
                return false;
            }
        }
        primes.add(test);
        return true;
    }
}
