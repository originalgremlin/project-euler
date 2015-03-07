package originalgremlin;

/**
 * Champernowne's constant
 * Problem 40
 *
 * An irrational decimal fraction is created by concatenating the positive integers:
 * 0.123456789101112131415161718192021...
 * It can be seen that the 12th digit of the fractional part is 1.
 *
 * If dn represents the nth digit of the fractional part, find the value of the following expression.
 * d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
 */

public class Problem40 {
    public static void main (String[] args) {
        int N = 1000000;

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (sb.length() <= N) {
            sb.append(i);
            i++;
        }

        int product = 1;
        int j = 1;
        while (j <= N) {
            product *= Character.getNumericValue(sb.charAt(j));
            j *= 10;
        }
        System.out.println(product);
    }
}
