/**
 * @author Tyler Crill
 * @version 10/22/18
 * This is an extended class of RBTree - it contains additional support for reading in a file and creating
 * a tree based off the data it contains. This class will also provide the user with the 20 most frequent
 * entries in the tree.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class RBTreeExpanded extends RBTree {
    private RBTreeNodeExpanded[] mostFrequent = new RBTreeNodeExpanded[20];
    private ArrayList<RBTreeNodeExpanded> wordArrayList = new ArrayList<>();
    private double sorting, processing, total;
    Timer timer = new Timer();
    BufferedReader br = new BufferedReader(new FileReader("data\\biblewords.txt"));

    public RBTreeExpanded() throws FileNotFoundException {
    }

    /**
     * This method will read in data from a file and create a tree based on it.
     * @throws IOException
     */
    void createTree() throws IOException {
        timer.reset();
        timer.start();
        String input;
        while((input = br.readLine()) != null){
            insert(input);
        }
        timer.stop();
        processing = timer.seconds();


    }

    /**
     * This method will fill in an array with all objects in the tree.
     * @param root
     */
    void fillArray(RBTreeNodeExpanded root){
        timer.start();
        if(root == NIL){
            return;
        }
        wordArrayList.add(root);
        fillArray(root.left);
        fillArray(root.right);
        timer.stop();
        sorting = timer.seconds();

    }

    protected RBTreeNodeExpanded findInsertLocation(Object data)
    {
        RBTreeNodeExpanded prev, x;
        int result;

        prev= NIL;
        x= root;
        while (x != NIL)
        {
            prev= x;
            result= x.compareTo(data);
            if (result < 0)
                x= x.left;
            else if(result == 0){
                x.increment();
                return null;
            }else{
                x= x.right;
            }

        }
        return prev;
    }
    /**
     * This method will sort the array and present the 20 most frequently occuring objects.
     */
    void sortFreqArray(){
        int tracker = 0;
        timer.reset();
        timer.start();
        wordArrayList.sort(Comparator.comparing(RBTreeNodeExpanded::getCount));

        for(int i = wordArrayList.size()-1; i >= wordArrayList.size()-20; i--){
            mostFrequent[tracker] = wordArrayList.get(i);
            tracker++;
        }
        timer.stop();
        sorting += timer.seconds();
    }

    /**
     * This method will display pertinent information such as runtimes for the program.
     */
    void display(){
        int numOfSpaces = 5;
        total = sorting + processing;
        System.out.format("* %-25s * %7s *\n\n", "Word", "Frequency");
        for(RBTreeNodeExpanded n : mostFrequent) {
            if(n != NIL){
                System.out.format("* %-25s * %7d *\n", n.data(), n.getCount());
            }
        }
        System.out.println("\n\n Elapsed Times: ");
        System.out.format("%" + numOfSpaces + "s Processing = " + processing +"\n", "");
        System.out.format("%" + numOfSpaces + "s Sorting = " + sorting + "\n", "");
        System.out.format("%" + numOfSpaces + "s Total = " + total + "\n", "");
    }

}
