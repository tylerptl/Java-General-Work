/**
 * @author Tyler Crill
 * @version 09/22/2018
 *
 * MergeSortDriver for a program that will read in a file, parse the words to a binary search
 * tree and track the occurrence of each word. It will allow for displaying of the most
 * frequent words as well as standard binary search tree functionality.
 */

import java.io.IOException;
public class Driver {
    public static void main(String... args) throws IOException {
        BinaryContainer bc = new BinaryContainer();
        bc.createSearchTree();
        bc.fillArrayAndSort();
        bc.display();

    }
}
