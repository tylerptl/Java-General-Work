public class SubstitutionCipher {
    Alphabet scAlpha;
    String plainText;

    SubstitutionCipher(String text){
        this.plainText = text;
    }
        // Need to scrap this and just look back to alphabet class List<String>
    private String encrypt(){

        byte[] textBytes = plainText.getBytes();
        for (int i = 0; i < textBytes.length; i++)
        {
            int currentByteValue = (int)textBytes[i];
            textBytes[i] = (byte)(currentByteValue > 255 ? currentByteValue - 255 + 2 : currentByteValue + 2);
        }
        String strbyte=new String(textBytes);
        return strbyte;
    }
    void decrypt(){
        byte[] textBytes = text.getBytes();
        for (int i = 0; i < textBytes.length; i++)
        {
            int currentByteValue = (int)textBytes[i];
            textBytes[i] = (byte)(currentByteValue < 0 ? currentByteValue + 255 - 2 : currentByteValue - 2);
        }
        String strbyte=new String(textBytes);
        return strbyte;
    }
    }

}
