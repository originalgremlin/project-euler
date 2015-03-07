package originalgremlin.from001to050;

/**
 * Number spiral diagonals
 * Problem 28
 *
 * Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:

 21 22 23 24 25
 20  7  8  9 10
 19  6  1  2 11
 18  5  4  3 12
 17 16 15 14 13

 * It can be verified that the sum of the numbers on the diagonals is 101.
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
 */

public class Problem28 {
    public static void main (String[] args) {
        int N = 1001;
        int sum = 1;        // inner layer is the center point (1) not 4 corners
        int current = 1;    // corner value
        int diff = 2;       // jumps between corner values
        while (N > 1) {
            for (int i = 0; i < 4; i++) {
                current += diff;
                sum += current;
            }
            diff += 2;
            N -= 2;
        }
        System.out.println(sum);
    }
}
