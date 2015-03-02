package originalgremlin;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.stream.IntStream;

/**
 * Number letter counts
 * Problem 17
 *
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are
 * 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 *
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
 *
 * NOTE:
 * Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and
 * 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance
 * with British usage.
 */

public class Problem17 {
    private static int AND = 3;
    private static final HashMap<Integer, Integer> counts;
    static {
        counts = new HashMap<>();
        counts.put(0, "".length());
        counts.put(1, "one".length());
        counts.put(2, "two".length());
        counts.put(3, "three".length());
        counts.put(4, "four".length());
        counts.put(5, "five".length());
        counts.put(6, "six".length());
        counts.put(7, "seven".length());
        counts.put(8, "eight".length());
        counts.put(9, "nine".length());
        counts.put(10, "ten".length());
        counts.put(11, "eleven".length());
        counts.put(12, "twelve".length());
        counts.put(13, "thirteen".length());
        counts.put(14, "fourteen".length());
        counts.put(15, "fifteen".length());
        counts.put(16, "sixteen".length());
        counts.put(17, "seventeen".length());
        counts.put(18, "eighteen".length());
        counts.put(19, "nineteen".length());
        counts.put(20, "twenty".length());
        counts.put(30, "thirty".length());
        counts.put(40, "forty".length());
        counts.put(50, "fifty".length());
        counts.put(60, "sixty".length());
        counts.put(70, "seventy".length());
        counts.put(80, "eighty".length());
        counts.put(90, "ninety".length());
        counts.put(100, "hundred".length());
        counts.put(1000, "thousand".length());
    }

    public static void main (String[] args) {
        int sum = IntStream.rangeClosed(1, 1000)
                .map(Problem17::letterCount)
                .sum();
        System.out.println(sum);
    }

    public static int letterCount (int i) {
        int count = 0;

        // thousands
        int thousands = i / 1000;
        if (thousands > 0) {
            count += counts.get(thousands) + counts.get(1000);
        }

        // hundreds
        int hundreds = (i % 1000) / 100;
        if (hundreds > 0) {
            count += counts.get(hundreds) + counts.get(100);
        }

        // tens and ones
        int tens = (i % 100) / 10;
        int ones = (i % 10);
        if (tens < 2) {
            // 1-19 are special
            count += counts.get(i % 20);
        } else {
            // 20-99 are normal
            count += counts.get(tens * 10) + counts.get(ones);
        }

        // "and"
        if ((thousands + hundreds > 0) && (tens + ones > 0)) {
            count += AND;
        }

        return count;
    }
}
