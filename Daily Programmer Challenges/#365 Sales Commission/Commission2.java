import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Commission2 {
    List<String> names;
    int[][] values;
    ArrayList<String> products;
    BufferedReader br;
    boolean isRevenue;

    public Commission2() throws FileNotFoundException {
        br = new BufferedReader(new FileReader(new File("C:\\Users\\asdf\\Documents\\Programming\\Java Work\\Daily Programmer Challenges\\#365 Sales Commission\\input.txt")));
        names = new ArrayList<>();
        products = new ArrayList<>();
    }

    void createTable() throws IOException {
        String key;
        if((key = br.readLine()) != null){
            if(key.toLowerCase().equals("revenue")){
                isRevenue = true;

            }else if(key.toLowerCase().equals("expenses")){

            }
        }
    }

    void fillTable(boolean boo) throws IOException {
        br.readLine();

    }
}
