import java.util.Scanner;

public class Driver {
    public static void main(String... args){
        Scanner kb = new Scanner(System.in);
        int index = 0;
        String[] arr = new String[5];
        Trie trie = new Trie();
        boolean exit = false;
        System.out.println("Enter 5 words that you want to insert into Trie...");
        while(kb.hasNextLine() && index < 5){
            String line = kb.nextLine().toLowerCase();
            arr[index] = line;
            trie.insert(line);
            System.out.println("Added " + line + " to trie...");
            index++;
        }
        System.out.println("Finished adding to trie - Displaying entries now...\n\n");
        System.out.println("-------------------");

        for(String s : arr){
            System.out.println(s);
        }
        System.out.println("-------------------\n\n");

        kb.nextLine();
        System.out.println("Would you like to see if there is a correlating starting " +
                "letter in the trie? Or perhaps search for an entire word?");
        while(!exit) {
        System.out.println("Enter 1 to search for starting prefixes or 2 for entire words - blank space will exit");

            String str = kb.nextLine();
            if (str.equals("1")) {
                System.out.println("enter prefix");
                String pre = kb.nextLine();
                System.out.println(trie.startsWith(pre));
                continue;
            }
            if (str.equals("2")) {
                System.out.println("Enter word to search for...");
                String word = kb.nextLine();
                System.out.println(trie.search(word));
                continue;
            }
            if (str.equals("")) {
                System.out.println("Exiting program...");
                exit = true;
                System.exit(0);
            }
            if (!str.equals("1") || !str.equals("2") || str.equals("")) {
                System.out.println("Invalid entry...");
                continue;

            }
            System.out.println("Again?");
        }




        }
}
