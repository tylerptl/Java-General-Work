import java.util.Scanner;

public class ReadingIn
{
   public static void main(String [] args)
   {   
      Scanner keyboard= new Scanner(System.in);
		int number;
                  
      System.out.print("What is your favorite positive integer?: ");
		number= keyboard.nextInt();
      
      
      System.out.println("Your favoritve number is: " +number);
      System.out.println("Your favoritve number doubled is: " +(2*number));
      System.out.println("Your favoritve number squared is: " +(number*number));
      System.out.println("Your favoritve number negative is: -" +number);
      System.out.printf("Your inverse of your favoritve number is: %.3f%n", +(1.0/number));
      }

}