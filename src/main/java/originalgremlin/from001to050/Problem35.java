package originalgremlin.from001to050;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

/**
 * Circular primes
 * Problem 35
 *
 * The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
 *
 * There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
 *
 * How many circular primes are there below one million?
 */

public class Problem35 {
    private static Set<Integer> primes = new HashSet<>();
    static {
        IntStream.range(2, 1000000).filter(Problem35::isPrime).forEach(primes::add);
    }

    public static void main (String[] args) {
        long count = IntStream.range(2, 1000000)
                .filter(i -> areAllPrime(getRotations(i)))
                .count();
        System.out.println(count);
    }

    private static LinkedList<Integer> getRotations (int num) {
        LinkedList<Integer> rotations = new LinkedList<>();
        int[] digits = String.valueOf(num).chars().map(Character::getNumericValue).toArray();
        for (int start = 0, length = digits.length; start < length; start++) {
            int rotation = 0;
            for (int pos = 0; pos < length; pos++) {
                rotation *= 10;
                rotation += digits[(start + pos) % length];
            }
            rotations.add(rotation);
        }
        return rotations;
    }

    private static boolean areAllPrime (Iterable<Integer> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false).allMatch(primes::contains);
    }

    private static boolean isPrime (int test) {
        if (test == 2) {
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
}
