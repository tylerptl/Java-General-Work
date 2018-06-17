import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class IE {
    public static void main(String[] args) {

        Scanner file = null;
        try {
            file = new Scanner(new File("C:\\Users\\asdf\\Documents\\Programming\\Java Work\\Daily Programmer Challenges\\#363 - I before E\\enable1.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int exceptionCount = 0;
        while(file.hasNext()) {
            String word = file.next();
            if((word.contains("ei") || word.contains("cie")) && !word.contains("cei")) {
                System.out.println("False");
                exceptionCount++;
            } else {
                System.out.println("True");
            }
        }
        System.out.println(exceptionCount);
    }
}