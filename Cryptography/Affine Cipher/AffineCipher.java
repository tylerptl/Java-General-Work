import java.math.BigInteger;

/**
 * Encrypt: E(x) = (ax + b) mod 26
 *          a and b are coprime keys
 * Decrypt: D(x) = a^-1(x-b) mod 26
 *
 * Given 5, 19 for keys, E(x) = (5x+19)%26 and D(x) = 21(x-19)%26
 *
 *
 */
public class AffineCipher {
    // Keys must be coprime
    private static int firstKey = 5;
    private static int secondKey = 19;
    private static int module = 26;
    private static char baseline;

    static String encrypt(String text){
        baseline = 'a';
        StringBuilder sb = new StringBuilder();
        for(char ch : text.toCharArray()){
            char character = ch;
            if(Character.isLetter(ch)){
                character = (char)((firstKey * (ch - baseline) + secondKey) % module + baseline);
            }
            sb.append(character);
        }
        return sb.toString();
    }

    static String decrypt(String text){
        StringBuilder sb = new StringBuilder();

        //Find modular inverse for first key
        BigInteger inverse = BigInteger.valueOf(firstKey).modInverse(BigInteger.valueOf(module));

        // perform decryption

        for(char ch : text.toCharArray()){
            char character = ch;
            if(Character.isLetter(character)){
                // Reverse encryption by replacing firstKey in encryption function with its inverse
                int decoded = inverse.intValue() * (character - baseline - secondKey + module);
                character = (char) (decoded%module + baseline);
            }
            sb.append(character);
        }
        return sb.toString();
    }
}
