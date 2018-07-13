import java.io.IOException;

public class Driver {
    public static void main(String... args) throws IOException {
        Commission com = new Commission();
        com.createTable();
        //System.out.println(com.getProducts());
        for(int n : com.getProfits()){
            System.out.print(n + " ");
        }
         com.calcCommission();

    }
}
