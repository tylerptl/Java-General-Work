import java.util.Scanner;

public class Driver {
    public static void main(String... args){
        Scanner kb = new Scanner(System.in);
        funnel funnel = new funnel();
        System.out.println("Enter your base word...");
        String in = kb.nextLine();
        System.out.println("Entered - " + in + " Enter your next word...");
        String check = kb.nextLine();
        System.out.println("Entered - " + check +" - comparing now...");

        funnel.compare(in,check);

    }
}
