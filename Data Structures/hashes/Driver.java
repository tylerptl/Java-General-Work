/**
 * @author Tyler Crill
 * @version 10/08/2018
 */

import java.io.IOException;

public class Driver {
    public static void main(String... args) throws IOException {
        HashContainer hc = new HashContainer();
        hc.loadDictionary();
        hc.readText();
        hc.printStats();
        //hc.loadResultFiles();
    }
}
