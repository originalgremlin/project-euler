package originalgremlin;

/**
 * Special Pythagorean triplet
 * Problem 9
 *
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 *
 * a^2 + b^2 = c^2
 *
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */

public class Problem9 {
    public static void main (String[] args) {
        int total = 1000;
        int c;
        for (int a = 1; a < total; a++) {
            for (int b = 1; b < total - a; b++) {
                c = 1000 - a - b;
                if (a * a + b * b == c * c) {
                    System.out.println(a + ", " + b + ", " + c);
                    System.out.println(a * b * c);
                    return;
                }
            }
        }
    }
}
