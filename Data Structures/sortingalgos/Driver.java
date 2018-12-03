/**
 * Driver to be used when running program from within IDE. This driver also uses all 3 sorting methods for testing
 * purposes. Use any of the other 3 sorting methods when running from CMD line.
 */

import java.io.*;

public class Driver {
    public static void main(String... args) throws IOException {
        File fileIn = new File("data\\medium.txt");
        Timer timer = new Timer();
        ContributorContainer cc = new ContributorContainer();
        cc.readFile(fileIn);
        Contributor[] contributors = cc.getContributors();


        timer.start();
        cc.builtInSort();
        timer.stop();
        System.out.println("Builtin sort completed in " + timer.milliseconds() + "ms\n\n");
        timer.reset();

        timer.start();
        cc.selectionSort();
        timer.stop();
        System.out.println("Selection sort completed in " + timer.milliseconds() + "ms\n\n");
        timer.reset();

        timer.start();
        cc.sort(contributors,0,contributors.length-1);
        timer.stop();
        System.out.println("Mergesort completed in " + timer.milliseconds() + "ms\n\n");

    }
}
