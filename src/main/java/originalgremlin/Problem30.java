package originalgremlin;

import java.util.stream.IntStream;

/**
 * Digit fifth powers
 * Problem 30
 *
 * Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:

 1634 = 1^4 + 6^4 + 3^4 + 4^4
 8208 = 8^4 + 2^4 + 0^4 + 8^4
 9474 = 9^4 + 4^4 + 7^4 + 4^4

 * (As 1 = 1^4 is not a sum it is not included.)
 *
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 *
 * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 */

public class Problem30 {
    public static void main (String[] args) {
        int sum = IntStream.range(10, 300000)
                .filter((i) -> i == sumOfDigits(i, 5))
                .sum();
        System.out.println(sum);
    }

    public static int sumOfDigits (int num, int pow) {
        return Integer.toString(num).chars()
                .map(Character::getNumericValue)
                .map((i) -> (int) Math.pow(i, pow))
                .sum();
    }
}
