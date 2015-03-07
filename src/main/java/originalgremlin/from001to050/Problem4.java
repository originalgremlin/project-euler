package originalgremlin.from001to050;

/**
 * Largest palindrome product
 * Problem 4
 *
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two
 * 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */

public class Problem4 {
    public static void main (String[] args) {
        int max = 0;
        int product;
        for (int i = 100; i <= 999; i++) {
            for (int j = 100; j <= 999; j++) {
                product = i * j;
                if (product > max && isPalindrome(product)) {
                    max = product;
                }
            }
        }
        System.out.println(max);
    }

    private static boolean isPalindrome (int i) {
        int fwd = i;
        int rev = 0;
        while (fwd > 0) {
            rev *= 10;
            rev += fwd % 10;
            fwd /= 10;
        }
        return rev == i;
    }
}
