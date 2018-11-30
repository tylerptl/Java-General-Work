/**
 * This container contains 6 hashstables half of which are phonetic tables and the other dictionary tables. Each table in
 * each half utilize 1 of 3 hash function variants. This container allows the instantiation, filling, searching, and adding
 * of these hashtables as well as the gathering of stats for their performance.
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HashContainer {
    private DictionaryWordsHash baseDictionaryWordsA;
    private DictionaryWordsHash baseDictionaryWordsB;
    private DictionaryWordsHash baseDictionaryWordsC;
    private PhoneticWordsHash phoneticWordsA;
    private PhoneticWordsHash phoneticWordsB;
    private PhoneticWordsHash phoneticWordsC;
    BufferedReader br;
    BufferedWriter writer, writer2, writer3;
    Metaphone3 m3;
    protected int counter;
    protected String dictionaryFile;
    protected DictionaryWordsHash[] dWords;
    protected PhoneticWordsHash[] phoneticWords;
    Timer timer;
    String stage;


    HashContainer() throws IOException {
        setBaseDictionaryWordsA(new DictionaryWordsHash());
        setBaseDictionaryWordsB(new DictionaryWordsHash());
        setBaseDictionaryWordsC(new DictionaryWordsHash());
        setPhoneticWordsA(new PhoneticWordsHash());
        setPhoneticWordsB(new PhoneticWordsHash());
        setPhoneticWordsC(new PhoneticWordsHash());
        setCounter(0);

        br = new BufferedReader(new FileReader("data\\melville.txt")); // Better way to handle exceptions??
        writer = new BufferedWriter(new FileWriter("addedToTable.txt"));
        writer2 = new BufferedWriter(new FileWriter("phoneticAddedToTable.txt"));
        writer3 = new BufferedWriter(new FileWriter("results.txt"));
        m3 = new Metaphone3();
        timer = new Timer();
        setDictionaryFile("data\\dictionary.txt"); // Putting this var into the streamDictionary requires List<String> casting??

        getBaseDictionaryWordsA().hashStage = 0;
        getPhoneticWordsA().hashStage = 0;

        getBaseDictionaryWordsB().hashStage = 1;
        getPhoneticWordsB().hashStage = 1;

        getBaseDictionaryWordsC().hashStage = 2;
        getPhoneticWordsC().hashStage = 2;

        setdWords(new DictionaryWordsHash[3]);
        setPhoneticWords(new PhoneticWordsHash[3]);
        getdWords()[0] = getBaseDictionaryWordsA();
        getdWords()[1] = getBaseDictionaryWordsB();
        getdWords()[2] = getBaseDictionaryWordsC();
        getPhoneticWords()[0] = getPhoneticWordsA();
        getPhoneticWords()[1] = getPhoneticWordsB();
        getPhoneticWords()[2] = getPhoneticWordsC();

    }

    /**
     * This method will load the dictionary and create 6 hashtables. 1 dictionary and 1 phonetic table each will be assigned to
     * 1 of 3 hash functions.
     * @throws IOException
     */
    void loadDictionary() throws IOException {
        List<String> streamDictionary = Files.lines(Paths.get(getDictionaryFile()))
                .filter(x -> x.length() > 0)
                .collect(Collectors.toList());

        for(String str : streamDictionary){
            m3.SetWord(str);
            m3.Encode();
            String temp = m3.GetMetaph();

            for(DictionaryWordsHash dWord : getdWords()){
                timer.start();
                dWord.put(str, temp);
                timer.stop();
                dWord.dictionaryTime = Double.parseDouble(timer.toString());
                timer.reset();

            }
            for(PhoneticWordsHash pWord : getPhoneticWords()){
                timer.start();
                pWord.put(temp, str);
                timer.stop();
                pWord.dictionaryTime = Double.parseDouble(timer.toString());
                timer.reset();

            }
            writer.write("Added: " + str + " - " + temp + "\n");

            writer2.write("Phonetic Added: " + temp + " - " + str + "\n");

        }
    }

    /**
     * This method will read in the melville.txt file and for each string meeting certain requirements it will check the dictionary
     * for a suggested spelling and then the phonetic table if one is not found.
     * @throws IOException
     */
    public void readText() throws IOException {
        String line;

        // Skip header
        for (int i = 0; i < 5; i++) {
            br.readLine();
        }

        //readin test
//        while((line = br.readLine()) != null){
//            System.out.println(line);
//        }

        while((line = br.readLine()) != null){  // another exception here
            line = line.replaceAll("[^A-Za-z]", " ");
            for(String str : line.split("\\s+")){
                if(str.equals(str.toLowerCase()) && str.length() > 2){
                    m3.SetWord(str);
                    m3.Encode();
                    String metaph = m3.GetMetaph();


                    if(!getBaseDictionaryWordsA().contains(str)){
                        timer.start();
                        ArrayList<String> tempList = getPhoneticWordsA().get(metaph);
                        if(tempList != null){
                            printSuggestions(str, metaph, "A", tempList);
                        }
                        timer.stop();

                        baseDictionaryWordsA.textTime = Double.parseDouble(timer.toString());
                        phoneticWordsA.textTime =  Double.parseDouble(timer.toString());
                        timer.reset();

                        System.out.print("\n\n");
                    }
                    if(!getBaseDictionaryWordsB().contains(str)){
                        timer.start();
                        ArrayList<String> tempList = getPhoneticWordsB().get(metaph);
                        if(tempList != null){
                            printSuggestions(str, metaph, "B", tempList);
                        }
                        timer.stop();
                        baseDictionaryWordsB.textTime = Double.parseDouble(timer.toString());
                        phoneticWordsB.textTime =  Double.parseDouble(timer.toString());
                        timer.reset();

                        System.out.print("\n\n");
                    }
                    if(!getBaseDictionaryWordsC().contains(str)){
                        timer.start();
                        ArrayList<String> tempList = getPhoneticWordsC().get(metaph);
                        if(tempList != null){
                            printSuggestions(str, metaph,"C", tempList);
                        }
                        timer.stop();
                        baseDictionaryWordsC.textTime = Double.parseDouble(timer.toString());
                        phoneticWordsC.textTime =  Double.parseDouble(timer.toString());
                        timer.reset();

                        System.out.print("\n\n");
                    }
            }
        }


    }
        /**
         * This method was mostly for logging - it created files showing what was added to a dictionary and phonetic word table.
         */
//    void loadResultFiles() throws IOException {
//        baseDictionaryWords.fileDisplay();
//        phoneticWords.fileDisplay();
//    }
    }

    /**
     * This method will output, for each hashtable, suggestions for an improperly spelled word.
     * @param key
     * @param metaph
     * @param hashVersion
     * @param tempList
     */
    void printSuggestions(String key, String metaph, String hashVersion, ArrayList<String> tempList){
        System.out.println("(" + hashVersion + ") Suggestions for (" +key+ "): (" + metaph + ").");
        for(String s : tempList){
            System.out.print(s + ". ");
        }
        System.out.print("\n\n");
    }

    /**
     * This method prints out all stats relevant to the operation of the program
     */
    void printStats() throws IOException {

        for(DictionaryWordsHash dWord : dWords){

            dWord.getStats();
            if(dWord.hashStage == 0){
                stage = "A";
            }
            if(dWord.hashStage == 1){
                stage = "B";
            }
            if(dWord.hashStage == 2){
                stage = "C";
            }
            writer3.write("***Stats for tables utilizing hash" +stage+ "***\n");
            writer3.write("Time spent on dictionary = " + dWord.dictionaryTime + ", time spent on reading file and suggesting corrections = " +dWord.textTime +"\n");
            writer3.write("Elapsed time = " + (dWord.dictionaryTime+dWord.textTime) + "\n");
            writer3.write("Word count: " + dWord.size + "\n");
            writer3.write("Capacity = " + dWord.getTableSize() + "\n");
            writer3.write("Load Factor: " + dWord.getLoadFactor() + "\n");
            writer3.write("Longest list starts with: Key= " + dWord.getLongestList().getKey() + ", Value= " + dWord.getLongestList().getValue() + "\n");
            writer3.write("Length of longest list: " + dWord.getLongestListSize() + "\n");
            writer3.write("Number of lists in table: " + dWord.getNumLists() + "\n\n");

        }
        writer3.close();
    }

    public DictionaryWordsHash getBaseDictionaryWordsC() {
        return baseDictionaryWordsC;
    }

    public void setBaseDictionaryWordsC(DictionaryWordsHash baseDictionaryWordsC) {
        this.baseDictionaryWordsC = baseDictionaryWordsC;
    }

    public PhoneticWordsHash getPhoneticWordsA() {
        return phoneticWordsA;
    }

    public void setPhoneticWordsA(PhoneticWordsHash phoneticWordsA) {
        this.phoneticWordsA = phoneticWordsA;
    }

    public PhoneticWordsHash getPhoneticWordsB() {
        return phoneticWordsB;
    }

    public void setPhoneticWordsB(PhoneticWordsHash phoneticWordsB) {
        this.phoneticWordsB = phoneticWordsB;
    }

    public PhoneticWordsHash getPhoneticWordsC() {
        return phoneticWordsC;
    }

    public void setPhoneticWordsC(PhoneticWordsHash phoneticWordsC) {
        this.phoneticWordsC = phoneticWordsC;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getDictionaryFile() {
        return dictionaryFile;
    }

    public void setDictionaryFile(String dictionaryFile) {
        this.dictionaryFile = dictionaryFile;
    }

    public DictionaryWordsHash[] getdWords() {
        return dWords;
    }

    public void setdWords(DictionaryWordsHash[] dWords) {
        this.dWords = dWords;
    }

    public PhoneticWordsHash[] getPhoneticWords() {
        return phoneticWords;
    }

    public void setPhoneticWords(PhoneticWordsHash[] phoneticWords) {
        this.phoneticWords = phoneticWords;
    }

    public DictionaryWordsHash getBaseDictionaryWordsA() {
        return baseDictionaryWordsA;
    }

    public void setBaseDictionaryWordsA(DictionaryWordsHash baseDictionaryWordsA) {
        this.baseDictionaryWordsA = baseDictionaryWordsA;
    }

    public DictionaryWordsHash getBaseDictionaryWordsB() {
        return baseDictionaryWordsB;
    }

    public void setBaseDictionaryWordsB(DictionaryWordsHash baseDictionaryWordsB) {
        this.baseDictionaryWordsB = baseDictionaryWordsB;
    }
}

