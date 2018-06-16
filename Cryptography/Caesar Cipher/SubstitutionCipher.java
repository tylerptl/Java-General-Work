import java.util.*;

class SubstitutionCipher
{

    public static void main(String args[])
    {
        String plainText = "It was the best of times, it was the worst of times, it was\n" +
                "the age of wisdom, it was the age of foolishness, it was the\n" +
                "epoch of belief, it was the epoch of incredulity, it was the\n" +
                "season of Light, it was the season of Darkness, it was the\n" +
                "spring of hope, it was the winter of despair, we had\n" +
                "everything before us, we had nothing before us, we were\n" +
                "all going direct to Heaven, we were all going direct the\n" +
                "other way—in short, the period was so far like the present\n" +
                "period, that some of its noisiest authorities insisted on its\n" +
                "being received, for good or for evil, in the superlative\n" +
                "degree of comparison only. ";
        int shift = 5;
        String strcipherText = Encrypt(plainText, shift);
        String strdecryptedText = Decrypt(strcipherText, shift);

        System.out.println("Plain Text : "+plainText + "\n\n");
        System.out.println("Encrypted Text : "+strcipherText + "\n\n");
        System.out.println("Decrypted Text : "+strdecryptedText + "\n\n");
    }

    private static String Encrypt(String text, int shift)
    {

        byte[] textBytes = text.getBytes();
        for (int i = 0; i < textBytes.length; i++)
        {
            int currentByteValue = (int)textBytes[i];
            textBytes[i] = (byte)(currentByteValue > 255 ? currentByteValue - 255 + shift : currentByteValue + shift);
        }
        String strbyte=new String(textBytes);
        return  strbyte;
    }

    private static String Decrypt(String text, int shift)
    {
        byte[] textBytes = text.getBytes();
        for (int i = 0; i < textBytes.length; i++)
        {
            int currentByteValue = (int)textBytes[i];
            textBytes[i] = (byte)(currentByteValue < 0 ? currentByteValue + 255 - shift : currentByteValue - shift);
        }
        String strbyte=new String(textBytes);
        return strbyte;
    }
}