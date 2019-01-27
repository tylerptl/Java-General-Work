import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BitwiseTest {
    public static void main(String... args){
        int num1 = 13;              // 00001101
        int num2 = 34;              // 00100010
        int num3 = 212;             // 11010100
        System.out.print("num1 = ");
        System.out.println(String.format("%8s", Integer.toBinaryString(num1)).replace(' ', '0'));
        //System.out.println("\n");
        System.out.print("num2 = ");
        System.out.print(String.format("%8s", Integer.toBinaryString(num2)).replace(' ', '0'));
        System.out.println("\n\n");

        int result = num1 | num2;   // 00101111
        System.out.println("num1 | num2 = " + result); // Should be 47

        int andResult = num1 & num2;
        System.out.println("num1 & num2 = " + andResult); // Should be 0

        int complementResult = ~num2;   //Converts to 2's complement
        System.out.println("~num2 = " + complementResult + ": " + Integer.toBinaryString(complementResult));  // For any num n,2's comp of n = -(n+1)

        int xorResult = num1 ^ num2;
        System.out.println("num1 ^ num2 = " + xorResult);  //Insert 1 if entries are different, 0 otherwise

        //Bit-shifting is just multiplying and dividing by powers of two to add and remove digits.
        // Left-shifting by n is multiplying by 2^n, and right-shifting is dividing by 2^n and flooring

        int leftShiftResult = num1 << 4;    //01101000 - also this is signed
        System.out.println("num1 << 4 = " + leftShiftResult);

        int signedRightShiftResult = num3 >> 3;
        System.out.println("num3 >> 3 = " + signedRightShiftResult);// 11010100 becomes 00011010 should be 26

        int unsignedRightShiftResult = num3 >>> 2;
        System.out.println("num3 >>> 2 = " + unsignedRightShiftResult);

        ////////////////////////////////////////////////////////////////////

        String[] setVals = new String[] {"a","b","c","e","f"};
        String[] setVals2 = new String[] {"a","c","f","g","z"};
        Integer[] intVals, intVals2;
        intVals = new Integer[] {1,3,5,7,9};
        intVals2 = new Integer[] {1,3,4,7,8,9};
        Set<String> stringSet = new HashSet<>(Arrays.asList(setVals));
        Set<String> stringSet2 = new HashSet<>(Arrays.asList(setVals2));
        Set<Integer> intSet = new HashSet<Integer>(Arrays.asList(intVals));
        Set<Integer> intSet2 = new HashSet<Integer>(Arrays.asList(intVals2));

        






    }
}
