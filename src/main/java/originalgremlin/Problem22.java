package originalgremlin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Names scores
 * Problem 22
 *
 * Using names.txt (https://projecteuler.net/project/resources/p022_names.txt), a 46K text file containing over
 * five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value
 * for each name, multiply this value by its alphabetical position in the list to obtain a name score.
 *
 * For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53,
 * is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.
 *
 * What is the total of all the name scores in the file?
 */

public class Problem22 {
    public static void main (String[] args) throws IOException {
        String filename = "/Users/barry/Projects/project-euler/src/main/resources/Problem22.txt";
        String contents = new String(Files.readAllBytes(Paths.get(filename)));
        String[] names = Arrays.stream(contents.split(","))
                .map((s) -> s.substring(1, s.length() - 1))
                .sorted()
                .toArray(String[]::new);
        for (int i = 0; i < names.length; i++) {

        }
        int sum = IntStream.range(0, names.length)
                .map((i) -> (i + 1) * toNameScore(names[i]))
                .sum();
        System.out.println(sum);
    }

    public static int toNameScore (String s) {
        return s.chars().map((c) -> (c - 'A' + 1)).sum();
    }
}
