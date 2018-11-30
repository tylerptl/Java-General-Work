public class Node {
    private int count;
    private String key;
    private Node left, right;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    Node(String key){
        this.key = key;
        left= null;
        right = null;
        this.setCount(1);   // check here if count is wrong
    }

    @Override
    public String toString() {
        return getKey() + ": (" + getCount() + ") ";
    }
}
