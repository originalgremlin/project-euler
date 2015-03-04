package originalgremlin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Quadratic primes
 * Problem 27
 *
 * Euler discovered the remarkable quadratic formula:
 *
 * n^2 + n + 41
 *
 * It turns out that the formula will produce 40 primes for the consecutive values n = 0 to 39.
 * However, when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41 is divisible by 41, and certainly
 * when n = 41, 41² + 41 + 41 is clearly divisible by 41.
 *
 * The incredible formula  n² − 79n + 1601 was discovered, which produces 80 primes for the consecutive values n = 0 to 79.
 * The product of the coefficients, −79 and 1601, is −126479.
 *
 * Considering quadratics of the form:
 *
 * n^2 + an + b, where |a| < 1000 and |b| < 1000
 *
 * where |a| is the modulus/absolute value of a
 * e.g. |11| = 11 and |−4| = 4
 *
 * Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of
 * primes for consecutive values of n, starting with n = 0.
 */

public class Problem27 {
    private static Set<Integer> primes = new HashSet<>();
    static {
        IntStream.range(2, 1000000).filter(Problem27::isPrime).forEach(primes::add);
    }

    public static void main (String[] args) {
        int N = 1000;
        int maxN = 0;
        int maxA = 0;
        int maxB = 0;
        int n;

        for (int a = -N + 1; a < N; a++) {
            for (int b = -N + 1; b < N; b++) {
                n = 0;
                while (primes.contains(quadratic(n, a, b))) {
                    n++;
                }
                if (n > maxN) {
                    maxN = n;
                    maxA = a;
                    maxB = b;
                }
            }
        }
        System.out.format("n:   %d%na:   %d%nb:   %d%na*b: %d%n", maxN, maxA, maxB, maxA * maxB);
    }

    private static int quadratic (int n, int a, int b) {
        return (n * n) + (a * n) + b;
    }

    private static boolean isPrime (int test) {
        if (test % 2 == 0) {
            return false;
        }
        for (int i = 3, sqrt = (int) Math.round(Math.sqrt(test)); i < sqrt; i += 2) {
            if (test % i == 0) {
                return false;
            }
        }
        return true;
    }
}
