/**
 * Driver program that uses the Java built in sort to sort an input file.
 */

import java.io.File;
import java.io.IOException;

public class BuiltInSortDriver {
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
		cc.builtInSort();
		timer.stop();
		System.out.println("Builtin sort completed in " + timer.milliseconds() + "ms\n\n");
        cc.printHighest();

    }
}
