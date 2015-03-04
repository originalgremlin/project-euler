package originalgremlin;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Reciprocal cycles
 * Problem 26
 *
 * A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:

 1/2	= 	0.5
 1/3	= 	0.(3)
 1/4	= 	0.25
 1/5	= 	0.2
 1/6	= 	0.1(6)
 1/7	= 	0.(142857)
 1/8	= 	0.125
 1/9	= 	0.(1)
 1/10	= 	0.1

 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.
 *
 * Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
 */

public class Problem26 {
    public static void main (String[] args) {
        int d = 1000;
        int[] cycles = IntStream.range(0, d)
                .map(Problem26::reciprocalCycleLength)
                .toArray();

        int max = 0;
        for (int i = 0; i < cycles.length; i++) {
            if (cycles[i] > cycles[max]) {
                max = i;
            }
        }
        System.out.println(max);
    }

    public static int reciprocalCycleLength (int i) {
        if (i == 0) {
            return -1;
        } else {
            Map<Integer, Integer> used = new HashMap<>();
            int remainder = 1;
            while (!used.containsKey(remainder)) {
                used.put(remainder, used.size());
                remainder = (remainder % i) * 10;
            }
            return used.size() - used.get(remainder);
        }
    }
}
