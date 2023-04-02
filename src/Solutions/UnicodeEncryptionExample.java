package Solutions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Scanner;

public class UnicodeEncryptionExample {

    public static void main(String[] args) {

        //String -> unicode -> encrypt -> (save and read key ) -> decrypt -> unicode -> String

        Scanner input = new Scanner(System.in);
        //String originalSentence = "Hello,World!";
        String originalSentence = input.nextLine();
        int[] unicodeArray = convertToUnicodeArray(originalSentence);

        System.out.println("Original Sentence: " + originalSentence);
        System.out.println("Unicode Array: " + Arrays.toString(unicodeArray));

        String fileName = "sourceMaterial/key";
        int[] encryptedArray;
        try {
            encryptedArray = encryptUnicodeArray(unicodeArray, fileName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Encrypted Array: " + Arrays.toString(encryptedArray));

        int[] decryptedArray;
        try {
            decryptedArray = decryptUnicodeArray(encryptedArray, fileName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String decryptedSentence = convertToString(decryptedArray);
        System.out.println("Decrypted Sentence: " + decryptedSentence);

    }

    private static int[] convertToUnicodeArray(String sentence) {
        int[] unicodeArray = new int[sentence.length()];
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            unicodeArray[i] = c;
        }
        return unicodeArray;
    }

    private static String convertToString(int[] unicodeArray) {
        StringBuilder sb = new StringBuilder();
        for (int code : unicodeArray) {
            sb.append((char) code);
        }
        return sb.toString();
    }

    /**
     * private static int[] encryptUnicodeArray(int[] unicodeArray) {
     * int[] key = generateRandomKey(unicodeArray.length);
     * int[] encryptedArray = new int[unicodeArray.length];
     * for (int i = 0; i < unicodeArray.length; i++) {
     * encryptedArray[i] = (unicodeArray[i] + key[i]) % 65536;
     * }
     * return encryptedArray;
     * }
     */

    private static int[] encryptUnicodeArray(int[] unicodeArray, String fileName) throws Exception {
        byte[] byteArray = convertToByteArray(unicodeArray);
        byte[] key = generateRandomKey(16);
        byte[] encryptedData = encryptAES(byteArray, key, fileName);
        return convertToIntArray(encryptedData);
    }

    /**
     * private static int[] decryptUnicodeArray(int[] encryptedArray) {
     * byte[] key = generateRandomKey(encryptedArray.length);
     * int[] decryptedArray = new int[encryptedArray.length];
     * for (int i = 0; i < encryptedArray.length; i++) {
     * decryptedArray[i] = (encryptedArray[i] - key[i] + 65536) % 65536;
     * }
     * return decryptedArray;
     * }
     */

    private static int[] decryptUnicodeArray(int[] encryptedArray, String fileName) throws Exception {
        byte[] encryptedData = convertToByteArray(encryptedArray);
        byte[] decryptedData = decryptAES(encryptedData, fileName);
        return convertToIntArray(decryptedData);
    }

    /**
     * private static int[] generateRandomKey(int length) {
     * Random random = new Random();
     * int[] key = new int[length];
     * for (int i = 0; i < length; i++) {
     * key[i] = random.nextInt(65536);
     * }
     * return key;
     * }
     */

    private static byte[] generateRandomKey(int length) {
        Random random = new Random();
        byte[] key = new byte[length];
        random.nextBytes(key);
        return key;
    }


    public static byte[] encryptAES(byte[] data, byte[] key, String fileName) throws Exception {
        Key secretKey = new SecretKeySpec(key, "AES");
        saveKeyToFile(key, fileName);
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(data);
    }

    private static byte[] decryptAES(byte[] encryptedData, String fileName) throws Exception {
        byte[] key = readKeyFromFile(fileName);
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        return cipher.doFinal(encryptedData);
    }


    private static byte[] convertToByteArray(int[] array) {
        byte[] byteArray = new byte[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            byteArray[i * 2] = (byte) ((array[i] >> 8) & 0xFF);
            byteArray[i * 2 + 1] = (byte) (array[i] & 0xFF);
        }
        return byteArray;
    }

    private static int[] convertToIntArray(byte[] byteArray) {
        int[] intArray = new int[byteArray.length / 2];
        for (int i = 0; i < byteArray.length; i += 2) {
            intArray[i / 2] = ((byteArray[i] & 0xFF) << 8) | (byteArray[i + 1] & 0xFF);
        }
        return intArray;
    }

    private static void saveKeyToFile(byte[] key, String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static byte[] readKeyFromFile(String fileName) throws IOException {
        try (FileInputStream fis = new FileInputStream(fileName)) {
            byte[] key = new byte[fis.available()];
            if (fis.read(key) != -1) {
                return key;
            }
            return new byte[0];
        }
    }

}

