import java.io.IOException;
import java.util.ArrayList;

public abstract class HashMap {
    LinkedHashNode[] table;

    public static int getTableSize() {
        return TABLE_SIZE;
    }

    private final static int TABLE_SIZE = 355097;
    int hashStage;
    int size = 0;
    double dictionaryTime;
    double textTime;
    double elapsedTime;
    double loadFactor;
    int notNullEntry =0;    //Used to track non null entries in hashtable
    int listSize = 0;       // Used to track length of lists on each node in table
    int longestListSize = 0;    // Tracks how many links are in the longest list
    int numlists = 0;       //Used to track how many nodes in table have lists attached
    LinkedHashNode longestList;

    HashMap(){
        table  = new LinkedHashNode[TABLE_SIZE];
        for(int i = 0; i < TABLE_SIZE; i++){
            table[i] = null;
        }
    }

    /**
     * This method will check the table for any matches to the parameter key. If a match is found the program will continue to search
     * on that table[hash] node until null is found. Upon finishing the search the method will then return an ArrayList of matches.
     * @param key
     * @return
     */
    public ArrayList<String> get(String key){
        int hash = hash(key);
        ArrayList<String> foundWords = new ArrayList<>();
        if(table[hash] == null){
            System.out.println("String not found...(HM)");
            return null;
        }
        LinkedHashNode temp = table[hash];
        if(temp != null){
            while(temp.getNext() != null){
                foundWords.add(temp.getValue());
                temp = temp.getNext();
            }
        }
        else{
            return null;
        }

        return foundWords;
    }

    /**
     * This method utilizes one of the hash functions, based on the hashStage, and inserts a K,V pair into the table.
     * @param key
     * @param value
     */
    public void put(String key, String value){

        int hash = hash(key);
        if(table[hash] == null){
            table[hash] = new LinkedHashNode(key, value);
        }
        else{
            LinkedHashNode entry = table[hash];
            while(entry.getNext()!=null){
                entry = entry.getNext();
            }
            entry.setNext(new LinkedHashNode(key, value));
        }
        size++;

    }

    /**
     * This method will remove a K,V pair @ the given table[hash] location.
     * @param key
     */
    public void remove(String key){
        int hash = hash(key);
        if(table[hash] != null){
            LinkedHashNode prevEntry = null;
            LinkedHashNode entry = table[hash];
            while(entry.getNext() != null && !entry.getKey().equals(key)){
                prevEntry = entry;
                entry = entry.getNext();
            }
            if(entry.getKey().equals(key)){
                if(prevEntry == null){
                    table[hash] = entry.getNext();
                }
                else{
                    prevEntry.setNext(entry.getNext());
                }
            }
        }
    }

    /**
     * This method will return an int based on 1 of 3 hash functions. It determines which hash to use based on the variable
     * hashStage.
     * @param key
     * @return
     */
    protected int hash(String key){
        if(hashStage == 0){
            return hashA(key);
        }
        if(hashStage == 1){
            return hashB(key);
        }
        else{
            return hashC(key);
        }

    }

    /**
     * It returns and int based on a hash function
     * @param key
     * @return
     */
    private int hashA(String key){
        return key.hashCode() & TABLE_SIZE-1;
    }
    /**
     * It returns and int based on a hash function
     * @param key
     * @return
     */
    private int hashB(String key){
        int hash = 31;
        for(int i = 0; i <key.length(); i++){
            hash = hash*31 + key.charAt(i);
        }
        return hash & TABLE_SIZE-1;
    }
    /**
     * It returns and int based on a hash function
     * @param key
     * @return
     */
    private int hashC(String key){
        int hash = 11;
        for(int i = 0; i < key.length(); i++){
            hash = hash/3 * key.charAt(i);
        }
        return hash & TABLE_SIZE-1;

    }

    /**
     * This method will display all nodes in the hash table as well as all links on the node
     */
    public void display() {
        for (LinkedHashNode node : table) {
            if(node != null){
                while(node.getNext()!= null){
                    System.out.println("Key: " + node.getKey() + ", Value: " + node.getValue());
                    node = node.getNext();
                }
            }
        }
    }
    public void fileDisplay () throws IOException {

    }
    public double getLoadFactor(){
        return loadFactor;
    }
    public LinkedHashNode getLongestList(){
        return longestList;
    }
    public int getLongestListSize(){
        return longestListSize;
    }
    public int getNumLists(){
        return numlists;
    }

    /**
     * This method is used to gather all relevant stats for the hashtable.
     */
    public void getStats(){
        for(LinkedHashNode node : table){
            if(node != null){
                notNullEntry++;
                if(node.getNext() != null){
                    numlists++;
                }
                while(node.getNext() != null){
                    listSize++;
                    node = node.getNext();
                }
            }

            if(longestListSize == 0){
                longestListSize = listSize;
                longestList = node;
            }
            if(listSize > longestListSize){
                longestListSize = listSize;
                longestList = node;
            }

            loadFactor = notNullEntry/TABLE_SIZE;
        }
    }

    }
