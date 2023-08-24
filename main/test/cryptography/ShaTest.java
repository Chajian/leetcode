package cryptography;
import org.junit.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * Secure Hash arithmetic - 2
 * test
 */
public class ShaTest {

    public static String generateSHA2Hash(String input) throws NoSuchAlgorithmException {
        MessageDigest sha256Digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = sha256Digest.digest(input.getBytes());
        StringBuilder hexString = new StringBuilder();

        for (byte hashByte : hashBytes) {
            String hex = Integer.toHexString(0xff & hashByte);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }

    public static String generateSHA3Hash(String input) throws NoSuchAlgorithmException {
        MessageDigest sha256Digest = MessageDigest.getInstance("SHA3-256");
        byte[] hashBytes = sha256Digest.digest(input.getBytes());
        StringBuilder hexString = new StringBuilder();

        for (byte hashByte : hashBytes) {
            String hex = Integer.toHexString(0xff & hashByte);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }

    public static String generateSHA1Hash(String input) throws NoSuchAlgorithmException {
        MessageDigest sha1Digest = MessageDigest.getInstance("SHA-1");
        byte[] hashBytes = sha1Digest.digest(input.getBytes());
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
        System.out.println(generateSHA1Hash("1"));
        System.out.println(generateSHA1Hash("Hello"));
        System.out.println(generateSHA1Hash("Hella"));
    }

    @Test
    public void test2() throws NoSuchAlgorithmException{
        System.out.println(generateSHA3Hash("AliceBob10015")+"\n"+generateSHA2Hash("Alice\"\"Bob\"\"100\"\"15").length());
        System.out.println(generateSHA3Hash("AliceBob10015"));
        System.out.println(generateSHA2Hash("username=bob"));
        System.out.println(generateSHA2Hash("username=bob || PADDING || &admin=true"));
    }



}
