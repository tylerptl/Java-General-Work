import java.util.ArrayList;
import java.util.List;

/**
 * https://www.reddit.com/r/dailyprogrammer/comments/98ufvz/20180820_challenge_366_easy_word_funnel_1/
 *
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
    protected char[] inbound, outbound;

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

        inbound = input.toCharArray();
        outbound = check.toCharArray();

        for(int i =0; i < outbound.length; i++){
            if(outbound[i] != inbound[i]){
                if(inbound[i+1] != outbound[i]){
                    System.out.println("\nChecked string can not be created by removing one character.");
                    return false;
                }
            }
        }
        System.out.println("\n("+check+") is a viable mutation of (" + input + ").");
        return true;

    }

    void optionalOne(String input, List<String> list){
        String resultString;
        ArrayList<String> matchedWords = new ArrayList();

        for(int i = 0; i < input.length(); i++){
            // Prevent duplicate characters causing duplicate returns i.e boots returning bots twice
            if(i>0 && input.charAt(i-1) == input.charAt(i)){
                continue;
            }
            StringBuilder sb = new StringBuilder(input);
            resultString = sb.deleteCharAt(i).toString();
            if(list.contains(resultString)){
                matchedWords.add(resultString);

            }

        }
        //System.out.print(matchedWords.toArray());
        if(matchedWords.size()>= 1){
            System.out.print(matchedWords.get(0));
        }
        for(int i = 1; i < matchedWords.size(); i++){
            System.out.print(", " + matchedWords.get(i));
        }
    }




}
