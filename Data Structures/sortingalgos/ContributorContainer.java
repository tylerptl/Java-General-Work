/**
 * Container Class allowing for the sorting of contributor objects based
 * on file input. This class contains three different sorting methods -
 * Java built in sort, selection sort, and merge sort. Methods include printing out
 * top contributors, printing out entire input, and sorting the objects.
 *
 * @author Tyler Crill
 *
 */

import java.io.*;
import java.util.Arrays;

public class ContributorContainer {
    private final int TINY_SIZE = 20;
    private final int SMALL_SIZE = 2000;
    private final int MEDIUM_SIZE = 200000;
    private final int LARGE_SIZE = 2000000;

    Contributor[] contributors;
    BufferedReader br;
    Timer timer;
    ContributorContainer(){
        timer = new Timer();
    }

    /**
     * This method allows for the constructing of an array based on the file size.
     * Since there are only 4 options for the file input, the size can be limited to
     * 4 choices.
     * @param name
     */
    void setArraySize(String name){
        if(name.contains("tiny.txt")){
            contributors = new Contributor[TINY_SIZE];
            System.out.println("Initialized tiny.txt array");

        }
        if(name.contains("small.txt")){
            contributors = new Contributor[SMALL_SIZE];
            System.out.println("Initialized small.txt array");

        }
        if(name.contains("medium.txt")){
            contributors = new Contributor[MEDIUM_SIZE];
            System.out.println("Initialized medium.txt array");

        }
        if(name.contains("large.txt")){
            contributors = new Contributor[LARGE_SIZE];
            System.out.println("Initialized large.txt array");

        }

    }

    /**
     * This method will read in the input file and fill out an array with all
     * objects listed. No sorting will be done here.
     * @param file
     * @throws IOException
     */
    void readFile(File file) throws IOException {
        timer.start();
        String fileName = file.getName();
        setArraySize(fileName);


        String firstName, lastName;
        int money;
        int counter = 0;
        br = new BufferedReader(new FileReader(file));
        String line;
        while((line = br.readLine()) != null){
            String[] lineTemp = line.split(" ");
            firstName = lineTemp[0];
            lastName = lineTemp[1];
            money = Integer.parseInt(lineTemp[2]);
            contributors[counter] = new Contributor(firstName, lastName, money);
            counter++;
        }
        timer.stop();
        System.out.println("Successfully read file in ( " + timer.milliseconds() + "ms) - ready to begin sorting.");
    }

    /**
     * This method sorts the array via selectionSort.
     */
    void selectionSort(){

        int min;
        int i;
        int j;

        System.out.println("Beginning sort now...");
        for(i = 0; i < contributors.length-1; i++){
            min = i;
            for(j = i + 1; j < contributors.length; j++){
                if(contributors[j].getAmount() < contributors[min].getAmount()){
                    min =j;
                }
                swap(i, min);
            }

        }
    }

    /**
     * This method will sort the array based on the Java built in sort.
     */
    void builtInSort(){
        Arrays.sort(contributors);
    }

    /**
     * This method will provide the merge in mergeSort.
     * @param arr
     * @param l
     * @param m
     * @param r
     */

    void merge(Contributor arr[], int l, int m, int r)
    {
        // Find sizes of sub arrays
        int n1 = m - l + 1;
        int n2 = r - m;

        //Create temps
        Contributor leftArray[] = new Contributor [n1];
        Contributor rightArray[] = new Contributor [n2];

        // Copy data to temps
        for (int i=0; i<n1; ++i)
            leftArray[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            rightArray[j] = arr[m + 1+ j];


        // Merge temps & get initial indexes

        int i = 0, j = 0;
        int k = l;

        while (i < n1 && j < n2)
        {
            if (leftArray[i].getAmount() <= rightArray[j].getAmount())
            {
                arr[k] = leftArray[i];
                i++;
            }
            else
            {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray
        while (i < n1)
        {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray[]
        while (j < n2)
        {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    /**
     * This method will provide the sorting in mergeSort.
     * @param arr
     * @param l
     * @param r
     */
    void sort(Contributor[] arr, int l, int r){

        if(l < r){

            //Get middle
            int m = (l+r)/2;

            //Sort halves
            sort(arr, l, m);
            sort(arr, m+1, r);

            //Merge halves
            merge(arr, l, m, r);
        }


    }

    /**
     * This method will print the entire array - to print top 10 use the printHighest().
     */
    void printResults(){
        for(Contributor c : contributors){
            System.out.println(c);
        }
    }

    /**
     * This method will allow for the printing of the top 10 contributors based on
     * money value.
     */
    void printHighest(){
        for(int i = contributors.length-1; i > contributors.length-11; i--){
            System.out.println(contributors[i]);
        }
    }

    /**
     * This method is used in the selection sort algorithm. This will allow
     * objects to swap places in an array.
     * @param i
     * @param min
     */
    void swap(int i, int min){
        Contributor temp = contributors[min];
        contributors[min] = contributors[i];
        contributors[i] = temp;
    }

    public Contributor[] getContributors() {
        return contributors;
    }

}
