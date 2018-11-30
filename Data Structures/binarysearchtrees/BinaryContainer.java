/**
 * dijkstras for a BinarySearchTree. This container will allow the driver to assign a file
 * destination, read in the input, send to a binary search tree, and display the most
 * common words as well as their frequency.
 * @author Tyler Crill
 * @version 09/22/2018
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BinaryContainer {
    protected BinarySearchTree tree;
    private String input = " ";
    private String fileName = "data\\biblewords.txt";
    private BufferedReader br;
    private Timer timer;
    private double processing, sorting, total;

    BinaryContainer() throws FileNotFoundException {
        tree = new BinarySearchTree();
        timer = new Timer();
        br = new BufferedReader(new FileReader(fileName));
    }

    /**
     * This method will create the BinarySearchTree and fill it based on input
     * read in from a file
     * @throws IOException
     */
    void createSearchTree() throws IOException {
        timer.start();
        while((input = br.readLine()) != null){
            tree.insert(input);
        }
        timer.stop();
        processing = timer.seconds();
    }

    /**
     * This method will gather the 20 most frequent words found in the BinarySearchTree.
     */
    void fillArrayAndSort(){
        timer.reset();
        timer.start();
        tree.fillArray(tree.getRoot());
        tree.sortByMostFrequent();

        timer.stop();
        sorting = timer.seconds();

    }

    /**
     * This method will display the 20 most frequently occuring words in the file that
     * was read in and print it in a formatted table.
     */
    void display(){
        int numOfSpaces = 5;
        total = sorting+processing;

        System.out.format("* %-25s * %7s *\n\n", "Word", "Frequency");
        for(Node n : tree.getFreq()) {
           System.out.format("* %-25s * %7d *\n", n.getKey(), n.getCount());
        }
        System.out.println("\n\n Elapsed Times: ");
        System.out.format("%" + numOfSpaces + "s Processing = " + processing +"\n", "");
        System.out.format("%" + numOfSpaces + "s Sorting = " + sorting + "\n", "");
        System.out.format("%" + numOfSpaces + "s Total = " + total + "\n", "");

    }
}
