import java.util.HashMap;

public class Person {
    private HashMap<String, Integer> profits;
    private String name;

    public void setProfits(HashMap<String, Integer> profits) {
        this.profits = profits;
    }
    public void addToProfits(String str, Integer n){
        profits.put(str, n);
    }
    public Integer checkInProfits(String str){
        return profits.get(str);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCommissions(int commissions) {
        this.commissions = commissions;
    }

    private int commissions;

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
