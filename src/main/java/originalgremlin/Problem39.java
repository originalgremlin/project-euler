package originalgremlin;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.stream.IntStream;

/**
 * Integer right triangles
 * Problem 39
 *
 * If p is the perimeter of a right angle triangle with integral length sides, {a,b,c},
 * there are exactly three solutions for p = 120.
 *
 * {20,48,52}, {24,45,51}, {30,40,50}
 *
 * For which value of p ≤ 1000, is the number of solutions maximised?
 */

public class Problem39 {
    public static void main (String[] args) {
        int[] solutions = IntStream.rangeClosed(1, 1000)
                .map(i -> getRightTriangles(i).size())
                .toArray();
        int maxKey = 0, maxVal = 0;
        for (int i = 0; i < solutions.length; i++) {
            if (solutions[i] > maxVal) {
                maxKey = i + 1;
                maxVal = solutions[i];
            }
        }
        System.out.println(maxKey);
    }

    public static Collection<int[]> getRightTriangles (int perimeter) {
        LinkedList<int[]> solutions = new LinkedList<>();
        int a, b, c;
        for (a = 1; a < perimeter; a++) {
            for (b = a; b < perimeter - a; b++) {
                c = perimeter - a - b;
                if (a * a + b * b == c * c) {
                    solutions.add(new int[]{ a, b, c });
                }
            }
        }
        return solutions;
    }
}
