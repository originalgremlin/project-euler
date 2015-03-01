package originalgremlin;

import java.util.HashMap;

/**
 * Lattice paths
 * Problem 15
 *
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down,
 * there are exactly 6 routes to the bottom right corner.
 *
 * How many such routes are there through a 20×20 grid?
 */

public class Problem15 {
    private static class Pair<T> {
        public final T first;
        public final T second;

        public Pair (T first, T second) {
            this.first = first;
            this.second = second;
        }

        public int hashCode () {
            int hashFirst = first == null ? 0 : first.hashCode();
            int hashSecond = second == null ? 0 : second.hashCode();
            return (hashFirst + hashSecond) * hashSecond + hashFirst;
        }

        public boolean equals (Object other) {
            if (other instanceof Pair) {
                return this.first.equals(((Pair) other).first) && this.second.equals(((Pair) other).second);
            } else {
                return false;
            }
        }

        public String toString () {
            return String.format("(%s, %s)", first, second);
        }
    }

    private static HashMap<Pair<Integer>, Long> memo = new HashMap<>();

    public static void main (String[] args) {
        int N = 20;
        long start = System.nanoTime();
        System.out.println(pathCount(N, N));
        long end = System.nanoTime();
        System.out.println(end - start);
    }

    private static long pathCount (int width, int height) {
        if (width == 0 || height == 0) {
            // there is only one way through the empty box
            return 1;
        } else if (width > height) {
            // the number of ways through an m*n box is the same as through an n*m box
            // don't duplicate the work
            return pathCount(height, width);
        } else {
            // recursively calculate paths through the smaller sized boxes
            Pair<Integer> current = new Pair<>(width, height);
            if (!memo.containsKey(current))
                memo.put(current, pathCount(width, height - 1) + pathCount(width - 1, height));
            return memo.get(current);
        }
    }
}
