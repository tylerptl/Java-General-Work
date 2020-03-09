/* @author=Tyler Crill
*/

import java.util.Scanner;

public class Homework7 {

public static void main(String[]args){

      int sum=0;
      int a;
      int b=0;
          
      Scanner input=new Scanner(System.in);
      System.out.println("Enter a positive integer");  
      a = input.nextInt();   
      
           
      while (a <= 0){
         System.out.println("Enter a positive integer");
         a = input.nextInt();}   
         
       if ( a >= 0){
         System.out.print("This program will seek the sum of: " +a );

                  
            while (a>=1){
            sum+= a;
            a--;
            System.out.print( " + " +a);
            }
            
            System.out.println(" = " +sum);
            }
                    
   }
   }   