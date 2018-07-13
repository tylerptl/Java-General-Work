import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Commission {
    List<String> names;
    int[][] values;
    ArrayList<ArrayList<Integer>> sums;
    ArrayList<String> products;
    BufferedReader br;
    boolean isRevenue;
    int productCount;

    public int[] getProfits() {
        return profits;
    }

    int[] profits;


    public List<String> getNames() {
        return names;
    }

    public ArrayList<String> getProducts() {
        return products;
    }



    public Commission() throws IOException {
       br = new BufferedReader(new FileReader(new File("C:\\Users\\asdf\\Documents\\Programming\\Java Work\\Daily Programmer Challenges\\#365 Sales Commission\\input.txt")));
       names = new ArrayList<>();
       products = new ArrayList<>();




    }


    void createTable() throws IOException {
        String key;
        while((key = br.readLine()) != null){
            br.readLine();
            if(key.toLowerCase().equals("revenue")){
                isRevenue = true;
                populateNames();
                if(profits == null){
                    profits = new int[names.size()];
                }

                values = new int[names.size()][];
                readInLines();
            }
            else if(key.toLowerCase().equals("expenses")){
                isRevenue = false;
                populateNames();
                if(profits == null){
                    profits = new int[names.size()];
                }

                readInLines();


            }

        }
    }
    void populateNames() throws IOException {
        System.out.println("Adding names...\n\n");
        String key;
        if((key = br.readLine()) != null){
            if(key.toLowerCase().equals("expenses") || key.toLowerCase().equals("revenue") || key.isEmpty()){
                System.out.println("new table found");

            }
            key = key.trim();

            names = Arrays.asList(key.trim().split("\\s+"));
            for(String name : names){
                System.out.println(name);
            }

        }

    }
    void readInLines() throws IOException {

        System.out.println("\n\nAdding products...\n\n");
        values[productCount] = new int[names.size()];

        String key;
        String[] temp;
        while((key = br.readLine()) != null) {
            if(key.toLowerCase().equals("expenses") || key.toLowerCase().equals("revenue") || key.isEmpty()){
                break;
            }
            temp = key.split("\\s+");
            System.out.println("Added " + temp[0]);
            for(int i = 1; i < temp.length; i++){
                if(isRevenue){
                    profits[i-1] += Integer.parseInt(temp[i]);
                }else{
                    profits[i-1] -= Integer.parseInt(temp[i]);
                }

            }
            products.add(temp[0]);
            productCount++;



        }

    }

    void calcCommission(){
        int[] com = new int[profits.length];

        for(int j = 0; j < profits.length; j++){
            com[j] = profits[j];
        }
        for(int i =0; i < com.length; i++){
            if(com[i] <= 0){
                com[i] = 0;
            }
            else{
                com[i] = (int) (profits[i] * .062);
            }
        }
        System.out.println("\n");
        for(int n : com){
            System.out.print( n +", ");
        }

    }
}
