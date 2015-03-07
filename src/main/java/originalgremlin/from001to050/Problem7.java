package originalgremlin.from001to050;

import java.util.ArrayList;

/**
 * 10001st prime
 * Problem 7
 *
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * What is the 10 001st prime number?
 */

public class Problem7 {
    private static ArrayList<Long> primes;
    static {
        primes = new ArrayList<>();
        primes.add(2L);
    }

    public static void main (String[] args) {
        int n = 10001;
        primes.ensureCapacity(n);

        long x = 2;
        while (n-- > 0) {
            while (!isPrime(x++));
            primes.add(x - 1);
        }
        System.out.println(x - 1);
    }

    private static boolean isPrime (long test) {
        for (Long prime : primes) {
            if (test > prime && test % prime == 0) {
                return false;
            }
        }
        return true;
    }
}
