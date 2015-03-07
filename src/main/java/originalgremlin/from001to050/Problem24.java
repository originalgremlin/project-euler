package originalgremlin.from001to050;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * Lexicographic permutations
 * Problem 24
 *
 * A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits
 * 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order.
 * The lexicographic permutations of 0, 1 and 2 are:
 *
 * 012   021   102   120   201   210
 *
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */

public class Problem24 {
    private static final int[] digits = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

    public static void main (String[] args) {
        int N = 1000000;
        ArrayList<String> permutations = getLexicographicPermutations("0123456789");
        System.out.println(permutations.get(N - 1));
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
}
