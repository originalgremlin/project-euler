package originalgremlin.from001to050;

import originalgremlin.Euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Prime permutations
 * Problem 49
 *
 * The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways:
 * (i) each of the three terms are prime, and,
 * (ii) each of the 4-digit numbers are permutations of one another.
 *
 * There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property, but there
 * is one other 4-digit increasing sequence.
 *
 * What 12-digit number do you form by concatenating the three terms in this sequence?
 */

public class Problem49 {
    public static void main (String[] args) {
        IntStream.range(1000, 10000)
                .filter(Euler::isPrime)
                .mapToObj(i -> {
                    int[] permutations = Euler.getPermutations(Integer.toString(i))
                            .stream()
                            .distinct()
                            .mapToInt(Integer::parseInt)
                            .filter(j -> j >= 1000)
                            .filter(Euler::isPrime)
                            .sorted()
                            .toArray();

                    HashSet<Integer> permset = new HashSet<>();
                    for (int permutation : permutations) {
                        permset.add(permutation);
                    }

                    int diff;
                    for (int j = 0; j < permutations.length; j++) {
                        for (int k = j + 1; k < permutations.length; k++) {
                            diff = permutations[k] - permutations[j];
                            if (permset.contains(permutations[k] + diff)) {
                                return String.format("%d%d%d", permutations[j], permutations[k], permutations[k] + diff);
                            }
                        }
                    }
                    return "";
                })
                .filter(s -> !s.isEmpty())
                .distinct()
                .forEach(System.out::println);
    }
}
