public class Trie {
    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    //Insert into trie
    public void insert(String str){
        TrieNode p = root;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            int index = c-'a';
            if(p.arr[index]==null){
                TrieNode temp = new TrieNode();
                p.arr[index] = temp;
                p = temp;
            }else{
                p = p.arr[index];
            }
        }
        p.isEnd = true;
    }

    //Returns if word exists in trie
    public boolean search(String str){
        TrieNode p = searchNode(str);
        if(p==null){
            return false;
        }else{
            if(p.isEnd){
                return true;
            }
        }
        return false;
    }

    //Returns if any word starts with given prefix
    public boolean startsWith(String prefix){
        TrieNode p = searchNode(prefix);
        if(p==null){
            return false;
        }else{
            return true;
        }
    }
    public TrieNode searchNode(String s){
        TrieNode p = root;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int index = c-'a';
            if(p.arr[index]!= null){
                p = p.arr[index];
            }else{
                return null;
            }
        }
        if(p==root){
            return null;
        }
        return p;
    }
}
