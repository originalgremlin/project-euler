package originalgremlin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

/**
 * Non-abundant sums
 * Problem 23
 *
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number.
 * For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a
 * perfect number.
 *
 * A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this
 * sum exceeds n.
 *
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum
 * of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can
 * be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis
 * even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is
 * less than this limit.
 *
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 */

public class Problem23 {
    public static final int MAX_NON_ABUNDANT_SUM = 28123;

    public static void main (String[] args) throws IOException {
        int[] abundant = IntStream.rangeClosed(1, MAX_NON_ABUNDANT_SUM)
                .filter(Problem23::isAbundant)
                .toArray();

        Set<Integer> set = new HashSet<>();
        for (int i : abundant) {
            for (int j : abundant) {
                if (i + j <= MAX_NON_ABUNDANT_SUM) {
                    set.add(i + j);
                } else {
                    break;
                }
            }
        }

        int total = IntStream.rangeClosed(1, MAX_NON_ABUNDANT_SUM).sum();
        int sum = set.stream().reduce(0, Integer::sum);
        System.out.println(total - sum);
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

    public static boolean isPerfect (int num) {
        return getSumOfDivisors(num) == num;
    }

    public static boolean isDeficient (int num) {
        return getSumOfDivisors(num) < num;
    }

    public static boolean isAbundant (int num) {
        return getSumOfDivisors(num) > num;
    }
}
