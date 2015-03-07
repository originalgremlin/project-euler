package originalgremlin.from001to050;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Pandigital products
 * Problem 32
 *
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once;
 * for example, the 5-digit number, 15234, is 1 through 5 pandigital.
 *
 * The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product
 * is 1 through 9 pandigital.
 *
 * Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
 *
 * HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
 */

public class Problem32 {
    public static void main (String[] args) {
        int N = 9876;
        int numDigits;
        HashSet<Integer> products = new HashSet<>();
        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                numDigits = countDigits(i) + countDigits(j) + countDigits(i * j);
                if (numDigits > 9) {
                    break;
                } else if (numDigits < 9) {
                    continue;
                } else if (hasPandigitalProduct(i, j)) {
                    products.add(i * j);
                }
            }
        }
        System.out.println(products.stream().mapToInt(Integer::valueOf).sum());
    }

    private static int countDigits (int i) {
        return (int) (Math.ceil(Math.log10(i)));
    }

    public static boolean hasPandigitalProduct (int a, int b) {
        int[] digits = (String.valueOf(a) + String.valueOf(b) + String.valueOf(a * b))
                .chars()
                .map(Character::getNumericValue)
                .toArray();
        Arrays.sort(digits);
        for (int i = 1; i <= digits.length; i++) {
            if (digits[i - 1] != i) {
                return false;
            }
        }
        return true;
    }
}
