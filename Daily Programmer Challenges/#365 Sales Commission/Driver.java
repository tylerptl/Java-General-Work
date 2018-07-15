import java.io.IOException;

public class Driver {
    public static void main(String... args) throws IOException {
        Commission logic = new Commission();
        logic.fillTable();

//        for(Person p : logic.getEmployees()){
//            System.out.println(p.getName() + ": " + p.getProfits() + "-- Commission: " + p.getCommissions());
//        }
        logic.printCommission();

    }
}
