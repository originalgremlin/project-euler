package originalgremlin.from051to100;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * XOR decryption
 * Problem 59
 *
 * Each character on a computer is assigned a unique code and the preferred standard is ASCII
 * (American Standard Code for Information Interchange). For example, uppercase A = 65, asterisk (*) = 42, and lowercase k = 107.
 *
 * A modern encryption method is to take a text file, convert the bytes to ASCII, then XOR each byte with a given value,
 * taken from a secret key. The advantage with the XOR function is that using the same encryption key on the cipher text,
 * restores the plain text; for example, 65 XOR 42 = 107, then 107 XOR 42 = 65.
 *
 * For unbreakable encryption, the key is the same length as the plain text message, and the key is made up of random
 * bytes. The user would keep the encrypted message and the encryption key in different locations, and without both
 * "halves", it is impossible to decrypt the message.
 *
 * Unfortunately, this method is impractical for most users, so the modified method is to use a password as a key.
 * If the password is shorter than the message, which is likely, the key is repeated cyclically throughout the message.
 * The balance for this method is using a sufficiently long password key for security, but short enough to be memorable.
 *
 * Your task has been made easy, as the encryption key consists of three lower case characters. Using cipher.txt
 * (https://projecteuler.net/project/resources/p059_cipher.txt), a file containing the encrypted ASCII codes, and the knowledge that the
 * plain text must contain common English words, decrypt the message and find the sum of the ASCII values in the original text.
 */

public class Problem59 {
    public static void main (String[] args) throws IOException {
        String path = "/Users/barry/Projects/project-euler/src/main/resources/Problem59.txt";
        String contents = new String(Files.readAllBytes(Paths.get(path)));
        int[] codes = Arrays.stream(contents.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] maxKey = new int[]{0, 0, 0};
        int maxSpaces = 0;
        int spaces;
        for (int a = 'a'; a <= 'z'; a++) {
            for (int b = 'a'; b <= 'z'; b++) {
                for (int c = 'a'; c <= 'z'; c++) {
                    spaces = countSpaces(Arrays.copyOfRange(codes, 0, 60), new int[]{a, b, c});
                    if (spaces > maxSpaces) {
                        maxSpaces = spaces;
                        maxKey = new int[]{a, b, c};
                    }
                }
            }
        }
        System.out.println(decrypt(codes, maxKey));
        System.out.println(getSum(codes, maxKey));
    }

    private static int countSpaces (int[] crypto, int[] key) {
        int count = 0;
        for (int i = 0; i < crypto.length; i++) {
            if ((crypto[i] ^ key[i % key.length]) == 32) {
                count++;
            }
        }
        return count;
    }

    private static int getSum (int[] crypto, int[] key) {
        int sum = 0;
        for (int i = 0; i < crypto.length; i++) {
            sum += crypto[i] ^ key[i % key.length];
        }
        return sum;
    }

    private static String decrypt (int[] crypto, int[] key) {
        char[] output = new char[crypto.length];
        for (int i = 0; i < crypto.length; i++) {
            output[i] = (char) (crypto[i] ^ key[i % key.length]);
        }
        return new String(output);
    }
}
