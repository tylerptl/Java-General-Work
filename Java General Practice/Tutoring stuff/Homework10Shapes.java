//*@author=Tyler Crill
import java.util.*;
import java.io.*;

public class Homework10Shapes {
   
   public static void main (String[]args) throws FileNotFoundException {
   
      Scanner fileIn = new Scanner(new File("Java General Practice\\Tutoring stuff\\input.txt"));
      
      int myInt = fileIn.nextInt();
      
     /* System.out.println(myInt);
      
      for(i = 0; i< myInt; i = i + 2);
         System.out.println(i);
         */
      if(myInt <= 0)
      {
      System.out.println("ERROR: Cannot print that size.");
      }   
         
      if(myInt%2 == 1)
       {       
          int spaces = (myInt/2);
          int odd = 1;
        
               
          //System.out.println(spaces);
          for(int i = 1; i <= myInt; i++) 
          {
           for(int j = spaces; j>=1; j--)
           {
             System.out.print(" ");
           }
           for(int j = 1; j<=odd; j++) 
           {
             System.out.print("*");
           } 
           System.out.println();
           
         if(i < ((myInt/2) + 1))
          {
          odd += 2;
          spaces -= 1;
          }
         else
         {
          odd -= 2;
          spaces += 1;              
         }
         }//end of loop
      
      
      }else 
       {
         
       int k = myInt;//spaces
       int d = myInt+2;//stars
       
       //rows
        for(int i = 0; i < myInt; i++){
            
             for(int l = k; l > 1; l--){
                System.out.print(" ");            
                }           
            //columns
            for(int j = 0; j < d; j++){
                System.out.print("*");
            }
            
             System.out.println();
             
             k--;
             d += 2;      
            }               
              
              
        } // end of loop  
            
     }
    
   }
 
 