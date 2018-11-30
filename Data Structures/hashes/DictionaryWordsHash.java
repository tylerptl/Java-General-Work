import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DictionaryWordsHash extends HashMap{
    BufferedWriter bw = new BufferedWriter(new FileWriter("dictionaryTable.txt"));

    public DictionaryWordsHash() throws IOException {
    }

    /**
     * This method is unique to the DictionaryWordHash as it allows us to check whether or not a dictionaryWordHash contains
     * a certain key. The phonetic variant of this table does not require this functionality.
     * @param str
     * @return
     */
    public boolean contains(String str){
        int hash = hash(str);
        LinkedHashNode temp = table[hash];
        if(temp == null){
            return false;
        }
        else{
            while(temp != null){
                if(temp.getKey().equals(str)){
                    return true;
                }
                if(temp.getNext()!= null){
                    temp = temp.getNext();
                }else{
                    return false;
                }
            }
            return false;
        }
    }

    /**
     * This method was mostly for logging - it ouput to a file what K,V pairs were added.
     * @throws IOException
     */
    public void fileDisplay() throws IOException {
        for(LinkedHashNode node : table){
            if(node != null){
                bw.write(node.getKey() + ": ");
                while(node.getNext()!= null){
                    bw.write(node.getValue() + " ");
                    node=node.getNext();
                }
                bw.write("\n");
            }

        }
    }
}
