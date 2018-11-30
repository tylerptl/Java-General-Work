/**
 * Driver program that uses merge sort to sort an input file.
 */

import java.io.*;

public class MergeSortDriver
{
	public static void main(String [] args) throws IOException {
		Timer timer = new Timer();
	    ContributorContainer cc = new ContributorContainer();

		// ex. java MergeSortDriver ..\data\medium.txt


		File inFile = null;
		if(args.length > 0){
			inFile = new File(args[0]);
			System.out.println("successfully loaded file + " + args[0]);
		}
		else{
			System.out.println("Invalid entry format...");
		}
		cc.readFile(inFile);
		//Only call this after issuing readFile()
		Contributor[] contributors = cc.getContributors();

		timer.reset();
		timer.start();
		cc.sort(contributors, 0, contributors.length-1);
		timer.stop();
		System.out.println("Mergesort completed in " + timer.milliseconds()+ "ms\n\n");
		cc.printHighest();
	}


}
