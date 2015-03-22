package originalgremlin.from051to100;

import originalgremlin.Euler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/**
 * Passcode derivation
 * Problem 79
 *
 * A common security method used for online banking is to ask the user for three random characters from a passcode.
 * For example, if the passcode was 531278, they may ask for the 2nd, 3rd, and 5th characters; the expected reply
 * would be: 317.
 *
 * The text file, keylog.txt (https://projecteuler.net/project/resources/p079_keylog.txt), contains fifty successful
 * login attempts.
 *
 * Given that the three characters are always asked for in order, analyse the file so as to determine the shortest
 * possible secret passcode of unknown length.
 */

public class Problem79 {
    private static String ANSWER = "73162890";

    public static void main (String[] args) throws IOException {
        // read all attempts
        String path = "/Users/barry/Projects/project-euler/src/main/resources/Problem79.txt";
        String[] attempts = new String(Files.readAllBytes(Paths.get(path))).split("\n");

        // turn attempts into char[]
        LinkedList<Character>[] chars = new LinkedList[attempts.length];
        for (int i = 0; i < attempts.length; i++) {
            chars[i] = new LinkedList<>();
            for (int j = 0; j < attempts[i].length(); j++) {
                chars[i].add(attempts[i].charAt(j));
            }
        }

        // find next digit in passcode
        LinkedList<Character> passcode = new LinkedList<>();
        HashSet<Character> next = new HashSet<>();
        boolean hasNext = true;
        while (hasNext) {
            hasNext = false;
            // find all possibilities for next character
            for (LinkedList<Character> llc : chars) {
                if (llc.size() > 0) {
                    next.add(llc.get(0));
                }
            }

            // remove all possibilities that are followers
            for (LinkedList<Character> llc : chars) {
                if (llc.size() > 1) {
                    next.remove(llc.get(1));
                }
                if (llc.size() > 2) {
                    next.remove(llc.get(2));
                }
            }

            // add acceptable possibilities to the passcode
            // remove those possibilities from further consideration
            for (Character c : next) {
                passcode.add(c);
                for (LinkedList<Character> llc : chars) {
                    if (c.equals(llc.peekFirst())) {
                        llc.removeFirst();
                        hasNext = true;
                    }
                }
            }

            // reset
            next.clear();
        }

        System.out.println(passcode);
    }

    private static boolean isValidPasscode (String passcode, String[] attempts) {
        int prev, current;
        for (String attempt : attempts) {
            prev = -1;
            for (char c : attempt.toCharArray()) {
                current = passcode.indexOf(c);
                if (current <= prev) {
                    System.out.println(attempt);
                    return false;
                }
            }
        }
        return true;
    }
}
