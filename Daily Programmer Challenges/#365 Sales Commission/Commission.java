import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Commission {
    private BufferedReader br;
    private boolean isRevenue;
    private List<String> names;
    private ArrayList<Person> employees;
    private static final Logger LOGGER = Logger.getLogger(Commission.class.getName());

    public ArrayList<Person> getEmployees() {
        return employees;
    }

    Commission() throws FileNotFoundException {
        br = new BufferedReader(new FileReader(new File("C:\\Users\\asdf\\Documents\\Programming\\Java Work\\Daily Programmer Challenges\\#365 Sales Commission\\input.txt")));
        employees = new ArrayList<>();
    }

    void fillTable() throws IOException {
        String key;
        while((key = br.readLine()) != null){
            br.readLine();
            if(key.toLowerCase().equals("revenue")){

                isRevenue = true;
                populateNames();
                populateExpensesRevenue();
            }else if(key.toLowerCase().equals("expenses")){

                isRevenue = false;
                populateNames();
                populateExpensesRevenue();
            }
        }

    }
    void populateNames() throws IOException {

        String key;
        if((key = br.readLine()) != null){
           key = key.trim();
            if(names !=null){
                return;
            }
            names = Arrays.asList(key.trim().split("\\s+"));
            for(String name : names){
                employees.add(new Person(name));
            }

        }
    }

    void populateExpensesRevenue() throws IOException {
        String key;
        String[] temp;

        while((key = br.readLine()) != null){
            if(key.toLowerCase().equals("expenses") || key.toLowerCase().equals("revenue") || key.isEmpty()){
                LOGGER.log(Level.FINE, "Invalid entry - exiting loop");
                return;
            }
            int x = 1;
            temp = key.trim().split("\\s+");

            if(temp.length != 0){
                for(Person p : employees){
                    if(!p.getProfits().containsKey(temp[0])){
                        p.profits.put(temp[0], Integer.parseInt(temp[x]));
                    }else{
                        if(isRevenue){
                            if(p.getProfits().get(temp[0]) >= Integer.parseInt(temp[x])){
                                p.profits.put(temp[0], Integer.parseInt(temp[x]) - p.profits.get(temp[0]));
                            }
                            else{
                                p.profits.put(temp[0], 0);
                            }
                        }else if(!isRevenue){
                            if(Integer.parseInt(temp[x]) >= p.getProfits().get(temp[0])){
                                p.getProfits().put(temp[0], 0);
                            }
                            else{
                                p.getProfits().put(temp[0], p.getProfits().get(temp[0]) - Integer.parseInt(temp[x]));
                            }
                        }
                    }

                    x++;

                }
            }

            }

        }

        void printCommission(){

            System.out.printf("%10s", " ");
            for(int i = 0; i < names.size(); i++){
                System.out.printf("%10s", names.get(i));
            }
            System.out.println();
            System.out.printf("Commission");
            for(Person p : employees){
                System.out.print(String.format("%10s", p.getCommissions()));
            }


        }
    }



