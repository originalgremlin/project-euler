package originalgremlin.from001to050;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

/**
 * Amicable numbers
 * Problem 21
 *
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
 *
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284.
 * The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 *
 * Evaluate the sum of all the amicable numbers under 10000.
 */

public class Problem21 {
    public static void main (String[] args) {
        int N = 10000;
        int sum = 0;
        int[] sumOfDivisors = IntStream.range(0, N)
                .map(Problem21::getSumOfDivisors)
                .toArray();
        for (int i = 0; i < N; i++) {
            if (isAmicable(sumOfDivisors, i)) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    public static Set<Integer> getDivisors (int num) {
        Set<Integer> set = new TreeSet<>();
        set.add(1);
        for (int i = 2, root = (int) Math.round(Math.sqrt(num)); i <= root; i++) {
            if (num % i == 0) {
                set.add(i);
                set.add(num / i);
            }
        }
        return set;
    }

    public static int getSumOfDivisors (int num) {
        return getDivisors(num).stream().reduce(0, Integer::sum);
    }

    public static boolean isAmicable (int[] sums, int a) {
        int b = sums[a];
        return (b < sums.length) && (a != b) && (a == sums[b]);
    }
}
