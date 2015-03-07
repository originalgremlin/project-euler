package originalgremlin.from001to050;

import java.math.BigInteger;

/**
 * 1000-digit Fibonacci number
 * Problem 25
 *
 * The Fibonacci sequence is defined by the recurrence relation:
 *
 * Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
 *
 * Hence the first 12 terms will be:

 F1 = 1
 F2 = 1
 F3 = 2
 F4 = 3
 F5 = 5
 F6 = 8
 F7 = 13
 F8 = 21
 F9 = 34
 F10 = 55
 F11 = 89
 F12 = 144

 * The 12th term, F12, is the first term to contain three digits.
 *
 * What is the first term in the Fibonacci sequence to contain 1000 digits?
 */

public class Problem25 {
    public static final double PHI = 1.6180339887498948482045868343656;

    public static void main (String[] args) {
        int N = 1000;
        int i = 1;
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        while (b.toString().length() < N) {
            BigInteger c = new BigInteger(a.toByteArray());
            a = a.add(b);
            b = c;
            i++;
        }
        System.out.format("F%d %d %s%n", i, b.toString().length(), b);

        /*
            The nth Fibonacci number is equal to floor(phi^n).  For our problem we want the first n where:
            round(phi^n / sqrt(5)) >= 10^999
            n log phi - 0.5 log 5 >= 999 log 10
            n log phi >= 999 log 10 + 0.5 log 5
            n >= (999 log 10 + 0.5 log 5) / log phi
        */
        double byPhi = (999 * Math.log(10) + 0.5 * Math.log(5)) / Math.log(PHI);
        System.out.format("%d", Math.round(byPhi));
    }
}
