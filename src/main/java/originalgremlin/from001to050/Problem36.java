package originalgremlin.from001to050;

import java.util.stream.IntStream;

/**
 * Double-base palindromes
 * Problem 36
 *
 * The number 585 (decimal) = 1001001001 (binary), is palindromic in both bases.
 *
 * Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
 *
 * (Please note that the palindromic number, in either base, may not include leading zeros.)
 */

public class Problem36 {
    public static void main (String[] args) {
        int N = 1000000;

        IntStream.range(1, N)
                .filter(i -> isPalindrome(toDecimalString(i)) && isPalindrome(toBinaryString(i)))
                .forEach(i -> System.out.format("%32s %32s%n", toDecimalString(i), toBinaryString(i)));

        int sum = IntStream.range(1, N)
                .filter(i -> isPalindrome(toDecimalString(i)) && isPalindrome(toBinaryString(i)))
                .sum();
        System.out.println(sum);
    }

    private static String toDecimalString (int i) {
        return Integer.toString(i, 10);
    }

    private static String toBinaryString (int i) {
        return Integer.toString(i, 2);
    }

    private static boolean isPalindrome (String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }
}
