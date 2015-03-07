package originalgremlin.from001to050;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Pandigital prime
 * Problem 41
 *
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once.
 * For example, 2143 is a 4-digit pandigital and is also prime.
 *
 * What is the largest n-digit pandigital prime that exists?
 */

public class Problem41 {
    public static void main (String[] args) {
        long max = getLexicographicPermutations("1234567").stream()
                .mapToLong(Long::valueOf)
                .filter(Problem41::isPrime)
                .max().orElse(0);
        System.out.println(max);
    }

    public static ArrayList<String> getLexicographicPermutations (String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        return getPermutations(sorted);
    }

    public static ArrayList<String> getPermutations (String s) {
        return getPermutations("", s);
    }

    private static ArrayList<String> getPermutations (String prefix, String rest) {
        ArrayList<String> list = new ArrayList<>();
        int length = rest.length();
        if (length == 0) {
            list.add(prefix);
        } else {
            for (int i = 0; i < length; i++) {
                list.addAll(getPermutations(prefix + rest.charAt(i), rest.substring(0, i) + rest.substring(i + 1, length)));
            }
        }
        return list;
    }

    private static boolean isPrime (long test) {
        if (test < 2) {
            return false;
        } else if (test == 2) {
            return true;
        } else if (test % 2 == 0) {
            return false;
        } else {
            double sqrt = Math.round(Math.sqrt(test));
            for (int i = 3; i <= sqrt; i += 2) {
                if (test % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
