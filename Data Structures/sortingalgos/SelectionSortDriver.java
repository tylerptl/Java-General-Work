/**
 * Driver program that uses selection sort to sort an input file.
 */

import java.io.File;
import java.io.IOException;

public class SelectionSortDriver {
    public static void main(String[] args) throws IOException {
        Timer timer = new Timer();
        ContributorContainer cc = new ContributorContainer();

        File inFile = null;
        if(args.length > 0){
            inFile = new File(args[0]);
            System.out.println("successfully loaded file + " + args[0]);
        }
        else{
            System.out.println("Invalid entry format...");
        }
        cc.readFile(inFile);


        timer.reset();
		timer.start();
		cc.selectionSort();
		timer.stop();
		System.out.println("Selection sort completed in " + timer.milliseconds() + "ms\n\n");
        cc.printHighest();

    }
}
