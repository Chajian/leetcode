package cryptography;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.Base16;
import org.junit.Test;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Base64;

/**
 * 编码测试
 * 测试Base16，32，64分别对char数组进行编码的结果
 */
public class BaseTest {

    private char[] generateChars(){
        char[] chars = new char[128];
        for(int i = 0 ; i < 128;i++){
            chars[i] = (char)i;
        }
        return chars;
    }

    private byte[] charsTobytes(char[] chars){
        byte[] bytes = new byte[chars.length];
        for(int i = 0 ; i < chars.length ;i++){
            bytes[i] = (byte) chars[i];
        }
        return bytes;
    }


    @Test
    public void Base16() throws EncoderException {
        char[] chars = generateChars();
        Base16 base16 = new Base16();
        byte[] bytes = charsTobytes(chars);
        byte[] encodes = base16.encode(bytes);
        System.out.println("encode:"+encodes.length);
        for(byte c:encodes){
            System.out.print(Integer.toBinaryString(c)+",");
        }
        byte[] decodes = base16.decode(encodes);
        System.out.println("\ndecodes:"+decodes.length);
        for(byte c:decodes){
            System.out.print(Integer.toBinaryString(c)+",");
        }
    }

    @Test
    public void Base32(){
        char[] chars = generateChars();
        Base32 base16 = new Base32();
        byte[] bytes = charsTobytes(chars);
        byte[] encodes = base16.encode(bytes);
        System.out.println("encode:"+encodes.length);
        for(byte c:encodes){
            System.out.print(Integer.toBinaryString(c)+",");
        }
        byte[] decodes = base16.decode(encodes);
        System.out.println();
        for(byte c:decodes){
            System.out.print(Integer.toBinaryString(c)+",");
        }
    }

    @Test
    public void Base64(){
        char[] chars = generateChars();
        Base64 base16 = new Base64();
        byte[] bytes = charsTobytes(chars);
        byte[] encodes = base16.encode(bytes);
        System.out.println("encode:"+encodes.length);
        for(byte c:encodes){
            System.out.print(Integer.toBinaryString(c)+",");
        }
        byte[] decodes = base16.decode(encodes);
        System.out.println();
        for(byte c:decodes){
            System.out.print(Integer.toBinaryString(c)+",");
        }
    }

    @Test
    public void flipByte(){
        int number = 0b101010; // Example number: 42 in binary
        int positionToFlip = 3; // Flipping the 4th bit (0-based index)

// Flip the bit at the specified position
        int flippedNumber = number ^ (1 << positionToFlip);

        System.out.println(Integer.toBinaryString(flippedNumber)); // Output: 100010

    }


}
