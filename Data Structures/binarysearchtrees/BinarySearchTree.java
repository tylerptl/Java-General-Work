/**
 * @author Tyler Crill
 * @version 09/22/2018
 */

import java.util.ArrayList;
import java.util.Comparator;

public class BinarySearchTree {
    private ArrayList<Node> wordArrayList = new ArrayList<>();
    private Node[] freq = new Node[20];
    private Node root;

    protected Node[] getFreq() {
        return freq;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    protected BinarySearchTree(){
        this.root = null;
    }

    /**
     * This method will search the tree for a key matching the String which was passed to it.
     * If a match is found the method returns true, otherwise it will return false.
     * @param key
     * @return
     */
    public boolean find(String key){
        Node current = root;
        while(current!=null){
            if(current.getKey().equals(key)){
                return true;
            }else if(current.getKey().compareTo(key) > 0){
                current = current.getLeft();
            }else{
                current = current.getRight();
            }
        }
        return false;
    }

    /**
     * Removes nodes from the binary search tree based on the passed String. Will check
     * each node against it's key to verify.
     * @param key
     * @return
     */
    public boolean delete(String key){
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;

        while(!current.getKey().equals(key)){
            parent = current;
            if(current.getKey().compareTo(key) > 0){
                isLeftChild = true;
                current = current.getLeft();
            }else{
                isLeftChild = false;
                current = current.getRight();
            }
            if(current == null){
                return false;
            }
        }

        //Node has been found
        if(current.getLeft() == null && current.getRight() == null){
            if(current == root){
                root = null;
            }
            if(isLeftChild){
                parent.setLeft(null);
            }
            else{
                parent.setRight(null);
            }
        }
        // Node to be deleted has 1 child
        else if(current.getRight() == null){
            if(current == root){
                root = current.getLeft();
            }
            else if(isLeftChild){
                parent.setLeft(current.getLeft());
            }
            else{
                parent.setRight(current.getLeft());
            }
        }
        else if(current.getLeft() == null){
            if(current == root){
                root = current.getRight();
            }
            else if(isLeftChild){
                parent.setLeft(current.getRight());
            }
            else{
                parent.setRight(current.getRight());
            }
        }
        else if(current.getLeft()!= null && current.getRight() != null){

            // min element has been found in right sub tree
            Node successor = getSuccessor(current);
            if(current == root){
                root = successor;
            }
            else if(isLeftChild){
                parent.setLeft(successor);
            }
            else{
                parent.setRight(successor);
            }
            successor.setLeft(current.getLeft());
        }
        return true;
    }

    /**
     * This method will grab the successor to the parameter node and return it
     * @param deleteNode
     * @return
     */
    private Node getSuccessor(Node deleteNode){
        Node successsor =null;
        Node successsorParent =null;
        Node current = deleteNode.getRight();
        while(current!=null){
            successsorParent = successsor;
            successsor = current;
            current = current.getLeft();
        }
        //check if successor has the right child, it cannot have left child for sure
        // if it does have the right child, add it to the left of successorParent.
//		successsorParent
        if(successsor!=deleteNode.getRight()){
            successsorParent.setLeft(successsor.getRight());
            successsor.setRight(deleteNode.getRight());
        }
        return successsor;
    }

    /**
     * This method will create a new node based on the passed String. If the
     * binary search tree already has that entry then the existing entry is incremented
     * and no node is created.
     * @param key
     */
    public void insert(String key){
        Node newNode = new Node(key);

        if(root == null){
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;
        while(true){
            parent = current;
            //potentially skip this as if key is not less nor more than current.getKey,
            // you can auto increment
            if(key.equals(current.getKey())){
                current.setCount(current.getCount()+1);
                return;
            }
            if(key.compareTo(current.getKey()) < 0){
                current = current.getLeft();
                if(current == null){
                    parent.setLeft(newNode);
                    return;
                }
            }
            else{
                current = current.getRight();
                if(current == null){
                    parent.setRight(newNode);
                    return;
                }
            }
        }
    }

    /**
     * This method will give a very basic display of all elements in the tree along with their
     * count.
     * @param root
     */
    public void display(Node root){
        if(root != null){
            display(root.getLeft());
            System.out.print(" " + root.getKey() + ": ("+root.getCount() + ")");
            display(root.getRight());
        }
    }

    /**
     * This method will populate an array of Nodes from the binary search tree.
     * @param root
     */
    void fillArray(Node root){
        if(root == null){
            return;
        }
        wordArrayList.add(root);
        fillArray(root.getLeft());
        fillArray(root.getRight());

    }

    /**
     * This method will take the most frequently occuring Strings and put their associated
     * nodes in to an array for later display.
     */
    void sortByMostFrequent(){
        int n =0; // Tracking for adding to array
        wordArrayList.sort(Comparator.comparing(Node::getCount));

        for(int i = wordArrayList.size()-1; i >= wordArrayList.size()-20; i--){
            freq[n] = wordArrayList.get(i);
            n++;
        }
    }
}
