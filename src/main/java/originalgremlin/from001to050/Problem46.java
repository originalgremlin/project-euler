package originalgremlin.from001to050;

import originalgremlin.Euler;

import java.util.stream.IntStream;

/**
 * Goldbach's other conjecture
 * Problem 46
 *
 * It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.
 *
 * 9 = 7 + 2×1^2
 * 15 = 7 + 2×2^2
 * 21 = 3 + 2×3^2
 * 25 = 7 + 2×3^2
 * 27 = 19 + 2×2^2
 * 33 = 31 + 2×1^2
 *
 * It turns out that the conjecture was false.
 *
 * What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
 */

public class Problem46 {
    public static void main (String[] args) {
        int fail = IntStream.iterate(3, i -> i + 2)
                .filter(i -> !Euler.isPrime(i))
                .filter(i -> !followsConjecture(i))
                .findFirst().orElse(0);
        System.out.println(fail);
    }

    private static boolean followsConjecture (int i) {
        for (int j = 1; 2 * j * j < i; j++) {
            if (Euler.isPrime(i - 2 * j * j)) {
                return true;
            }
        }
        return false;
    }
}
