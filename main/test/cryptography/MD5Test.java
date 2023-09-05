package cryptography;

import org.junit.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Test {
    public static String generateMD5Hash(String input) throws NoSuchAlgorithmException {
        MessageDigest md5Digest = MessageDigest.getInstance("MD5");
        byte[] hashBytes = md5Digest.digest(input.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte hashByte : hashBytes) {
            String hex = Integer.toHexString(0xff & hashByte);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }

    public static String generateAESHash(String input) throws NoSuchAlgorithmException {
        MessageDigest md5Digest = MessageDigest.getInstance("AES");
        byte[] hashBytes = md5Digest.digest(input.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte hashByte : hashBytes) {
            String hex = Integer.toHexString(0xff & hashByte);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }

    public static String generateMD2Hash(String input) throws NoSuchAlgorithmException {
        MessageDigest md5Digest = MessageDigest.getInstance("MD2");
        byte[] hashBytes = md5Digest.digest(input.getBytes());
        StringBuilder hexString = new StringBuilder();

        for (byte hashByte : hashBytes) {
            String hex = Integer.toHexString(0xff & hashByte);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }




    @Test
    public void test() throws NoSuchAlgorithmException {
        String encode = generateMD5Hash("Input1692932849319");
        System.out.println(encode);

        String encode2 = generateMD5Hash("Input1692932849319");
        System.out.println(encode2);
    }
}
