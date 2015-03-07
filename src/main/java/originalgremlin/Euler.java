package originalgremlin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class Euler {
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

    public static int[] getTriangleNumbers (int n) {
        return IntStream.rangeClosed(0, n)
                .map(i -> i * (i + 1) / 2).toArray();
    }

    public static boolean isPrime (long test) {
        if (test < 2) {
            return false;
        } else if (test == 2) {
            return true;
        } else if (test % 2 == 0) {
            return false;
        } else {
            double root = Math.round(Math.sqrt(test));
            for (int i = 3; i <= root; i += 2) {
                if (test % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static Stream<String> toFileStream (String path) throws IOException {
        return toFileStream(path, ",");
    }

    public static Stream<String> toFileStream (String path, String separator) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get(path)));
        return Arrays.stream(contents.split(separator))
                .map((s) -> s.substring(1, s.length() - 1));
    }

    public static int toWordScore (String s) {
        return s.chars().map((c) -> (c - 'A' + 1)).sum();
    }
}
