import java.util.HashMap;

public class Person {
    HashMap<String, Integer> profits;
    String name;
    int commissions;

    public HashMap<String, Integer> getProfits() {
        return profits;
    }


    public int getCommissions() {
        for(int n : profits.values()){
            commissions += n;
        }
        return (int) (commissions * .062);
    }



    Person(String str){
        this.name = str;
        profits = new HashMap<>();
    }



}
