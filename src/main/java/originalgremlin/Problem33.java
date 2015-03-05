package originalgremlin;

/**
 * Digit cancelling fractions
 * Problem 33
 *
 * The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may
 * incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9's.
 *
 * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
 *
 * There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two
 * digits in the numerator and denominator.
 *
 * If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
 */

public class Problem33 {
    public static void main (String[] args) {
        int numerator = 1;
        int denominator = 1;

        for (int i = 10; i < 100; i++) {
            for (int j = i + 1; j < 100; j++) {
                if (isSpecial(i, j)) {
                    System.out.format("%d %d%n", i, j);
                    numerator *= i;
                    denominator *= j;
                }
            }
        }

        int gcd = gcd(numerator, denominator);
        System.out.format("%d/%d%n", numerator / gcd, denominator / gcd);
    }

    private static boolean isSpecial (int i, int j) {
        int i1 = i / 10;
        int i2 = i % 10;
        int j1 = j / 10;
        int j2 = j % 10;
        if (i2 == 0 && j2 == 0) {
            // trivial
            return false;
        } else if ((i1 == j1 && i * j2 == j * i2) || (i1 == j2 && i * j1 == j * i2) || (i2 == j1 && i * j2 == j * i1) || (i2 == j2 && i * j1 == j * i1)) {
            // special
            return true;
        } else {
            // neither trivial nor special
            return false;
        }
    }

    public static int gcd (int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}
