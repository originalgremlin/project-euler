package originalgremlin.from051to100;

import originalgremlin.Euler;
import originalgremlin.from001to050.Problem4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.IntStream;

/**
 * Square digit chains
 * Problem 92
 *
 * A number chain is created by continuously adding the square of the digits in a number to form a new number until it has been seen before.
 *
 * For example,
 * 44 → 32 → 13 → 10 → 1 → 1
 * 85 → 89 → 145 → 42 → 20 → 4 → 16 → 37 → 58 → 89
 *
 * Therefore any chain that arrives at 1 or 89 will become stuck in an endless loop. What is most amazing is that
 * EVERY starting number will eventually arrive at 1 or 89.
 *
 * How many starting numbers below ten million will arrive at 89?
 */

public class Problem92 {
    public static void main (String[] args) {
        int[] terminii = IntStream.rangeClosed(1, 567)
                .map(Problem92::getTerminus)
                .toArray();
        long count = IntStream.range(1, 10000000)
                .filter(i -> terminii[getSumOfSquaresOfDigits(i) - 1] == 89)
                .count();
        System.out.println(count);
    }

    private static HashSet<Integer> getChain (int i) {
        HashSet<Integer> seen = new HashSet<>();
        int next = i;
        while (!seen.contains(next)) {
            seen.add(next);
            next = getSumOfSquaresOfDigits(next);
        }
        return seen;
    }

    private static int getTerminus (int i) {
        int next = i;
        while (next != 1 && next != 89) {
            next = getSumOfSquaresOfDigits(next);
        }
        return next;
    }

    private static int getSumOfSquaresOfDigits (int i) {
        return Arrays.stream(Euler.getDigits(i)).map(j -> j * j).sum();
    }
}
