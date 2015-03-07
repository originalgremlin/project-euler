package originalgremlin.from001to050;

import java.util.stream.IntStream;

/**
 * Sum square difference
 * Problem 6
 *
 * The sum of the squares of the first ten natural numbers is,
 * 1^2 + 2^2 + ... + 10^2 = 385
 *
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)^2 = 55^2 = 3025
 *
 * Hence the difference between the sum of the squares of the first ten natural numbers and
 * the square of the sum is 3025 − 385 = 2640.
 *
 * Find the difference between the sum-of-the-squares and the square-of-the-sum of the first one hundred natural numbers.
 */

public class Problem6 {
    public static void main (String[] args) {
        int n = 100;
        int squareOfSum = (int) Math.pow(IntStream.rangeClosed(1, n).sum(), 2);
        int sumOfSquares = IntStream.rangeClosed(1, n).map((a) -> (a * a)).sum();
        int diff = squareOfSum - sumOfSquares;
        System.out.println(diff);
    }
}
