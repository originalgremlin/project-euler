package originalgremlin;

import java.util.*;

/**
 * Coin sums
 * Problem 31
 *
 * In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 *
 * It is possible to make £2 in the following way:
 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 *
 * How many different ways can £2 be made using any number of coins?
 */

public class Problem31 {
    public static Integer[] coins = { 1, 2, 5, 10, 20, 50, 100, 200 };

    @SuppressWarnings("unchecked")
    public static void main (String[] args) {
        int N = 200;

        int counts[] = new int[N + 1];
        counts[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j < counts.length; j++) {
                if (j >= coins[i]) {
                    counts[j] += counts[j - coins[i]];
                }
            }
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.format("%d: %d%n", i, counts[i]);
        }
    }
}
