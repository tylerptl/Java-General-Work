/**
* Defines single node of a red-black tree.
*
* @author  Terry Sergeant
* @version for Data Structures HW
* @see RBTree
*
*/
public abstract class RBTreeNode<T> implements Comparable
{
	T data;               // for Bible program
	char color;                   // (R)ed or (B)lack
	RBTreeNode left,right,parent; // pointers
	int count =1;



	RBTreeNode(){

	}

	/**
	* Create a red node with specified data and NIL parent.
	*
	* @param data reference to data object of node
	* @param NIL reference to NIL node
	*
	* <p>NOTE: This implementation uses a NIL sentinel (instead of null) for
	* representation of dead-end pointers ... so a reference to NIL
	* must be supplied.</p>
	*/
	public RBTreeNode(T data, RBTreeNode NIL)
	{
		this(data,'R',NIL,NIL);
	}


	/**
	* Create a node with specified data and color and NIL parent.
	*
	* @param data reference to data object of node
	* @param color color of node
	* @param NIL reference to NIL node
	*/
	public RBTreeNode(T data, char color, RBTreeNode NIL)
	{
		this(data,color,NIL,NIL);
	}


	/**
	* Create a node with specified data, color, and parent.
	*
	* @param data reference to data object of node
	* @param color color of node
	* @param NIL reference to NIL node
	* @param parent reference to parent of node being created
	*/
	public RBTreeNode(T data, char color, RBTreeNode NIL, RBTreeNode parent)
	{
		this.data= data;
		this.color= color;
		this.parent= parent;
		left= right= NIL;
	}


	/**
	* Getter for data object.
	* @return reference to the data object
	*/
	public Object data()
	{
		return data;
	}


	/**
	* Display the data using it's toString() method.
	* @return String representation of the data
	*/
	public String toString()
	{
		return ""+data;
	}
//	public void increment(){
//		count++;
//	}

//	public void setCount(int count) {
//		this.count = count;
//	}
//
//	public int getCount(){	return count; }



	@Override
	public int compareTo(Object o) {
		String temp1 = this.toString();
		String temp2 = o.toString();
		return temp1.compareTo(temp2);

	}
}
