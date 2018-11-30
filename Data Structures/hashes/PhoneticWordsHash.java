import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PhoneticWordsHash extends HashMap{
    BufferedWriter bw = new BufferedWriter(new FileWriter("phoneticwordsTable.txt"));
    public PhoneticWordsHash() throws IOException {
    }

    /**
     * This method allows us to retrieve all matches related to the key.
     * @param key
     * @return
     */
    public ArrayList<String> get(String key){
        int hash = hash(key);
        ArrayList<String> foundWords = new ArrayList<>();
        if(table[hash] == null){
            return null;
        }
        else{
            LinkedHashNode entry = table[hash];
            while(entry.getNext() != null){
                if(entry.getKey().equals(key)){
                    foundWords.add(entry.getValue());
                }
                entry = entry.getNext();
            }
        }


        return foundWords;
    }

    /**
     * This method was mostly for logging on my end.
     * @throws IOException
     */
    public void fileDisplay() throws IOException {
        for (LinkedHashNode node : table) {
            if(node != null){
                while(node.getNext()!= null){
                    bw.write("Key: " + node.getKey() + ", Value: " + node.getValue() + "\n");
                    node = node.getNext();
                }
            }
        }
    }
}
