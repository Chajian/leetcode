package cryptography;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class RainbowTableExample {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // Define the range of characters to use in passwords
        String charset = "abcdefghijklmnopqrstuvwxyz";

        // Create a map to store chains of hash values
        Map<String, String> chainMap = new HashMap<>();

        // Generate and store chains in the map
        int chainLength = 1000; // Number of chain iterations
        for (int i = 0; i < charset.length(); i++) {
            String password = String.valueOf(charset.charAt(i));
            String hash = calculateMD5Hash(password);

            for (int j = 0; j < chainLength; j++) {
                password = calculateNextPassword(password, charset);
                hash = calculateMD5Hash(password);
            }

            chainMap.put(hash, password);
        }
        String a = "sjdkf";
        // Now you have a basic rainbow table in the chainMap
        // You can use it to look up hash values and recover passwords
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

    private static String calculateNextPassword(String password, String charset) {
        // This is a simplified reduction function
        // You can implement more complex functions
        int index = password.hashCode() % charset.length();
        if (index < 0) {
            index += charset.length();
        }
        return String.valueOf(charset.charAt(index));
    }
}