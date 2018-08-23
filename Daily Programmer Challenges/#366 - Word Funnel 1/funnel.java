/**
 * Given two strings of letters, determine whether the second can be made from the first
 * by removing one letter. The remaining letters must stay in the same order.
 *
 * funnel("leave", "eave") => true
 * funnel("reset", "rest") => true
 * funnel("dragoon", "dragon") => true
 * funnel("eave", "leave") => false
 * funnel("sleet", "lets") => false
 * funnel("skiff", "ski") => false
 */

public class funnel {

    funnel(){

    }

    boolean compare(String input, String check){
        //Remove any strings that obviously don't match
        if(check.length() >= input.length() || input.length() - check.length() > 1){
            System.out.println("check length invalid - dismissing...");
            return false;
        }
        //Remove any strings in which check doesn't contain same letters as input
        for(char c : check.toCharArray()){
            if(input.indexOf(c) < 0){
                System.out.println("\nChecked string contains invalid character (" + c + ").");
                return false;
            }
        }
        char[] inbound, outbound;
        inbound = input.toCharArray();
        outbound = check.toCharArray();
        for(char c : inbound){
            System.out.print(c);
        }
        System.out.println("\n");
        for(char c : outbound){
            System.out.print(c);
        }

        for(int i =0; i < outbound.length; i++){
            if(outbound[i] != inbound[i]){
                if(inbound[i+1] != outbound[i]){
                    System.out.println("\nChecked string can not be created by removing one character.");
                    return false;
                }
            }
        }
        System.out.println("\nMatch found...");
        return true;

    }

}
