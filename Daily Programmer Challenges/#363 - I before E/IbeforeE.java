import java.io.*;
public class IbeforeE {
    private static int exceptions, numTrue, numFalse;

    public static void main(String... args) throws IOException {

        System.out.println(checkExpanded("a"));
        System.out.println(checkExpanded("zombie"));
        System.out.println(checkExpanded("transceiver"));
        System.out.println(checkExpanded("veil"));
        System.out.println(checkExpanded("icier"));
        System.out.println("********************\n\n");
        System.out.println(checkExpanded("ciecei"));
        System.out.println(checkExpanded("ceiei"));

        System.out.println("Checking for exceptions in enable1.txt");

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\asdf\\Documents\\Programming\\Java Work\\Daily Programmer Challenges\\#363 - I before E\\enable1.txt"));

        exceptions = 0;
        numTrue = 0;
        numFalse = 0;

        String line;
        while ((line = br.readLine()) != null) {
            checkExpanded(line);
            //System.out.println(line);
        }


        System.out.println("Exceptions found: " + exceptions);
        System.out.println("True = " + numTrue + ", false = " + numFalse);
        System.out.println("Complete.");

    }

    private static boolean check(String str) {
        if ((str.contains("ei") || str.contains("cie")) && !str.contains("cei")) {
            exceptions++;
            numFalse++;
            return false;
        }
        numTrue++;
        return true;
    }
    private static boolean checkExpanded(String str){

        if(!str.contains("ei")){
           if(str.contains("cie")){
               exceptions++;
               return false;
           }
           return true;
        }
        if(str.contains("cei") && str.length() < 3){
           numTrue++;
           return true;

        }if(str.contains("cei") && str.length()>3){
            String prefix, suffix;
            int index = str.indexOf("cei");
            prefix = str.substring(0, index);
            suffix = str.substring(index+3, str.length());
            if(prefix.contains("ei") || prefix.contains("cie") || suffix.contains("ei") || suffix.contains("cie")){
                numFalse++;
                return false;
            }else{
                numTrue++;
                return true;
            }

            //checkExpanded(str.substring(str.indexOf("cei")+3));
        }
        if(str.contains("ei") && !str.contains("cei")){
            exceptions++;
            numFalse++;
            return false;
        }

        numTrue++;
        return true;


    }
}


