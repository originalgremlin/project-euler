package originalgremlin.from001to050;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.IntStream;

/**
 * Coded triangle numbers
 * Problem 42
 *
 * The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten triangle numbers are:
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 *
 * By converting each letter in a word to a number corresponding to its alphabetical position and adding these values
 * we form a word value. For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle
 * number then we shall call the word a triangle word.
 *
 * Using words.txt (https://projecteuler.net/project/resources/p042_words.txt), a 16K text file containing nearly
 * two-thousand common English words, how many are triangle words?
 */

public class Problem42 {
    public static HashSet<Integer> triangles = new HashSet<>();
    static {
        IntStream.range(1, 100).forEach(i -> triangles.add(i * (i + 1) / 2));
    }

    public static void main (String[] args) throws IOException {
        String filename = "/Users/barry/Projects/project-euler/src/main/resources/Problem42.txt";
        String contents = new String(Files.readAllBytes(Paths.get(filename)));
        long count = Arrays.stream(contents.split(","))
                .map((s) -> s.substring(1, s.length() - 1))
                .filter(s -> triangles.contains(toWordScore(s)))
                .count();
        System.out.println(count);
    }

    public static int toWordScore (String s) {
        return s.chars().map((c) -> (c - 'A' + 1)).sum();
    }
}
