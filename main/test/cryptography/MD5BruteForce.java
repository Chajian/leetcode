package cryptography;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5BruteForce {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String targetHash = "your_target_md5_hash_here"; // Replace with the MD5 hash you want to break
        String charset = "abcdefghijklmnopqrstuvwxyz"; // Characters to try in the brute-force attack

        StringBuilder candidate = new StringBuilder();

        long startTime = System.currentTimeMillis();

        bruteForce(targetHash, charset, candidate);

        long endTime = System.currentTimeMillis();



        System.out.println("Brute force completed in " + (endTime - startTime) + " ms.");
    }

    private static void bruteForce(String targetHash, String charset, StringBuilder candidate) throws NoSuchAlgorithmException {
        for (int length = 1; length <= 8; length++) { // Set a reasonable maximum length
            generateCombinations(targetHash, charset, candidate, "", length);
        }
    }

    private static void generateCombinations(String targetHash, String charset, StringBuilder candidate, String current, int length) throws NoSuchAlgorithmException {
        if (current.length() == length) {
            String hash = calculateMD5Hash(current);
            if (hash.equals(targetHash)) {
                System.out.println("Hash matched! Input: " + current);
                System.exit(0); // Exit when a match is found
            }
            return;
        }

        for (char c : charset.toCharArray()) {
            generateCombinations(targetHash, charset, candidate, current + c, length);
        }
    }

    private static String calculateMD5Hash(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashBytes = md.digest(input.getBytes());

        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

}
