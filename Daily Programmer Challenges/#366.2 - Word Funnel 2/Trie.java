import java.util.HashMap;
import java.util.Map;

public class Trie {
    TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    //Insert word into the trie
    public void insert(String str){
        HashMap<Character, TrieNode> children = root.children;
        for(char c : str.toCharArray()){
            TrieNode t;
            if(children.containsKey(c)){
                t = children.get(c);
            }else{
                t = new TrieNode(c);
                children.put(c,t);
            }
            children = t.children;

            //set child node
            if(c == str.length()-1){
                t.isChild = true;
            }
        }

    }
    public boolean search(String str){
        TrieNode t = searchNode(str);

        if(t != null && t.isChild){
            return true;
        }else{
            return false;
        }

    }
    //Returns if there is any word in the trie that starts w/prefix
    public boolean startsWith(String prefix){
        if(searchNode(prefix) == null){
            return false;
        }else{
            return true;
        }

    }
    public TrieNode searchNode(String str) {
        Map<Character, TrieNode> children = root.children;
        TrieNode t = null;

        for(int i =0; i < str.length(); i++){
            char c = str.charAt(i);
            if(children.containsKey(c)){
                t = children.get(c);
                children = t.children;
            }else{
                return null;
            }
        }
        return t;

    }
}
