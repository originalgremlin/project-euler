package originalgremlin.from001to050;

import java.util.stream.IntStream;

/**
 * Truncatable primes
 * Problem 37
 *
 * The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from
 * left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left:
 * 3797, 379, 37, and 3.
 *
 * Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
 *
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 */

public class Problem37 {
    public static void main (String[] args) {
        int sum = IntStream.range(10, 1000000)
                .filter(Problem37::isPrime)
                .filter(Problem37::isTruncatable)
                .sum();
        System.out.println(sum);
    }

    private static boolean isPrime (int test) {
        if (test < 2) {
            return false;
        } else if (test == 2) {
            return true;
        } else if (test % 2 == 0) {
            return false;
        } else {
            for (int i = 3, sqrt = (int) Math.round(Math.sqrt(test)); i <= sqrt; i += 2) {
                if (test % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    private static boolean isTruncatable (int test) {
        String s = Integer.toString(test);
        String sub;
        for (int i = 1, len = s.length(); i < len; i++) {
            sub = s.substring(i, len);
            if (!isPrime(Integer.valueOf(sub))) {
                return false;
            }
        }
        for (int i = s.length() - 1; i > 0; i--) {
            sub = s.substring(0, i);
            if (!isPrime(Integer.valueOf(sub))) {
                return false;
            }
        }
        return true;
    }
}
