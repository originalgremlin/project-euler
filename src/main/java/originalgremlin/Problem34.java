package originalgremlin;

import java.util.stream.IntStream;

/**
 * Digit factorials
 * Problem 34
 *
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 *
 * Find the sum of all numbers which are equal to the sum of the factorial of their digits.
 *
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 */

public class Problem34 {
    public static void main (String[] args) {
        int sum = IntStream.range(3, 100000)
                .filter(i -> i == sumOfDigitFactorials(i))
                .sum();
        System.out.println(sum);
    }

    public static int sumOfDigitFactorials (int i) {
        int sum = Integer.toString(i)
                .chars()
                .map(Character::getNumericValue)
                .map(Problem34::factorial)
                .sum();
        return sum;
    }

    public static int factorial (int i) {
        int product = 1;
        while (i > 0) {
            product *= i;
            i--;
        }
        return product;
    }
}
