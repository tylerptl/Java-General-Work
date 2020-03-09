import java.util.Scanner;

public class DBConnector {
    Scanner kb = new Scanner(System.in);
    DBConnector(){

    }


    void generateMenu(){
        System.out.println("****************** Main Menu *******************");
        System.out.println("* 1.) Make a Reservation                       *");
        System.out.println("* 2.) Cancel a Reservation                     *");
        System.out.println("* 3.) List Current/Upcoming Reservations       *");
        System.out.println("* 4.) Display Monthly Revenue                  *");
        System.out.println("* 5.) Exit                                     *");
        System.out.println("************************************************");

    }

    void getUserInput(){
        int i;

        do{
            generateMenu();
            System.out.println("\n\n Select a choice.");
            while(!kb.hasNextInt()){
                System.out.println("Enter a numeric value between 1 and 5 ....\n");
                generateMenu();
                kb.next();
            }
            i = kb.nextInt();

        } while(i <= 0 || i > 5);
        System.out.println("You entered " + i);


        // int action = i == 1 ? makeReservation() : i == 2 ? cancelReservation() : i == 3 ? showReservations() : i == 4 ? getRevenue() : System.exit(0) ;
        if(i == 1 ){
            makeReservation();
        } else if (i == 2){
            cancelReservation();
        }
        else if (i == 3){
            showReservations();
        }
        else if ( i == 4){
            getRevenue();
        }
        else{
            System.out.println("exiting");
            System.exit(0);

        }

    }

    void makeReservation(){
        System.out.println("Creating reservation...");
    }

    void cancelReservation(){
        System.out.println("Cancelling reservation...");
    }

    void showReservations(){
        System.out.println("Displaying reservations...");
    }

    private double getRevenue(){
        System.out.println("Displaying revenue...");
        double revenue = 00.00;
        return revenue;
    }
}

