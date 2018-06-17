import java.io.*;
public class IbeforeE {
    private static int exceptions;

    public static void main(String... args) throws FileNotFoundException {

        System.out.println(check("a"));
        System.out.println(check("zombie"));
        System.out.println(check("transceiver"));
        System.out.println(check("veil"));
        System.out.println(check("icier"));
        System.out.println("********************\n\n");
        System.out.println("Checking for exceptions in enable1.txt");

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\asdf\\Documents\\Programming\\Java Work\\Daily Programmer Challenges\\#363 - I before E\\enable1.txt"));

        exceptions = 0;
        try {
            String line;
            while ((line = br.readLine()) != null) {
                check(line);
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Exceptions found: " + exceptions);
        System.out.println("Complete.");

    }

    private static boolean check(String str) {
        if ((str.contains("ei") || str.contains("cie")) && !str.contains("cei")) {
            exceptions++;
            return false;
        }
        return true;
    }
}


