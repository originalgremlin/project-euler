package originalgremlin.from051to100;

import java.util.Arrays;

/**
 * Permuted multiples
 * Problem 52
 *
 * It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.
 *
 * Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
 */

public class Problem52 {
    public static void main (String[] args) {
        int i = 1;
        while (!hasSameMultiples(i)) {
            i++;
        }
        System.out.format("%d%n%d%n%d%n%d%n%d%n%d%n", i, 2 * i, 3 * i, 4 * i, 5 * i, 6 * i);
    }

    private static boolean hasSameMultiples (int a) {
        return
                hasSameDigits(a, 2 * a) &&
                hasSameDigits(a, 3 * a) &&
                hasSameDigits(a, 4 * a) &&
                hasSameDigits(a, 5 * a) &&
                hasSameDigits(a, 6  *a);
    }

    private static boolean hasSameDigits (int a, int b) {
        char[] aChars = Integer.toString(a).toCharArray();
        char[] bChars = Integer.toString(b).toCharArray();
        Arrays.sort(aChars);
        Arrays.sort(bChars);
        return new String(aChars).equals(new String(bChars));
    }
}
