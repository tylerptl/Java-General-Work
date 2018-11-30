public class RBTreeNodeExpanded extends RBTreeNode {
    int count = 1;

    RBTreeNodeExpanded left,right,parent; // pointers

    public void increment(){
        count++;
    }
    public void setCount(int count) {
        this.count = count;
    }

    public int getCount(){	return count; }

}
