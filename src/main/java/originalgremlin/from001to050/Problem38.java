package originalgremlin.from001to050;

import java.util.Arrays;

/**
 * Pandigital multiples
 * Problem 38
 *
 * Take the number 192 and multiply it by each of 1, 2, and 3:
 *
 * 192 × 1 = 192
 * 192 × 2 = 384
 * 192 × 3 = 576
 *
 * By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated
 * product of 192 and (1,2,3)
 *
 * The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645,
 * which is the concatenated product of 9 and (1,2,3,4,5).
 *
 * What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer
 * with (1,2, ... , n) where n > 1?
 */

public class Problem38 {
    public static void main (String[] args) {
        StringBuilder sb;
        String s;
        long max = 0;
        long current;
        for (int i = 1; i < 10000; i++) {
            sb = new StringBuilder();
            for (int j = 1; j < 10 && sb.length() < 9; j++) {
                sb.append(i * j);
            }
            s = sb.toString();
            if (isPandigital(s)) {
                current = Integer.valueOf(s);
                if (current > max) {
                    max = current;
                }
            }
        }
        System.out.println(max);
    }

    public static boolean isPandigital (String s) {
        int[] digits = s.chars().map(Character::getNumericValue).toArray();
        Arrays.sort(digits);
        for (int i = 1; i <= digits.length; i++) {
            if (digits[i - 1] != i) {
                return false;
            }
        }
        return true;
    }
}
