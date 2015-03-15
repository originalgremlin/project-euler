package originalgremlin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public final class Euler {
    public static Set<Integer> getDivisors (int num) {
        Set<Integer> set = new TreeSet<>();
        set.add(1);
        for (int i = 2, root = (int) Math.round(Math.sqrt(num)); i <= root; i++) {
            if (num % i == 0) {
                set.add(i);
                set.add(num / i);
            }
        }
        return set;
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

    public static long[] getPrimesLessThan (int num) {
        return LongStream.range(2, num)
                .filter(Euler::isPrime)
                .toArray();
    }

    public static ArrayList<Integer> getPrimeFactors (int num) {
        ArrayList<Integer> factors = new ArrayList<>();
        int root = (int) Math.ceil(Math.sqrt(num));
        int i = 2;
        while (i <= root) {
            if (num % i == 0) {
                factors.add(i);
                num /= i;
                root = (int) Math.round(Math.sqrt(num));
            } else if (i == 2) {
                i += 1;
            } else {
                i += 2;
            }
        }
        if (num != 1) {
            factors.add(num);
        }
        return factors;
    }

    public static long getTriangleNumber (long i) {
        return i * (i + 1) / 2;
    }

    public static long getPentagonNumber (long i) {
        return i * (3 * i - 1) / 2;
    }

    public static long getHexagonNumber (long i) {
        return i * (2 * i - 1);
    }

    public static boolean isTriangleNumber (long i) {
        long square = 1 + 8 * i;
        long root = (int) Math.sqrt(square);
        return (root * root == square) && ((-1 + root) % 2 == 0);
    }

    public static boolean isPentagonNumber (long i) {
        long square = 1 + 24 * i;
        long root = (int) Math.sqrt(square);
        return (root * root == square) && ((1 + root) % 6 == 0);
    }

    public static boolean isHexagonNumber (long i) {
        long square = 1 + 8 * i;
        long root = (int) Math.sqrt(square);
        return (root * root == square) && ((1 + root) % 4 == 0);
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
