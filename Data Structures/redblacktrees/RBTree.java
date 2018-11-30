/**
* Implements a red-black tree for BibleWord objects.
*
* @author  Terry Sergeant
* @version for Data Structures homework
* @see RBTreeNode
*/

public abstract class RBTree
{
	protected RBTreeNodeExpanded NIL;  // sentinel node
	protected RBTreeNodeExpanded root; // marks root of tree
	protected int n;           // number of nodes in tree
	protected int height;      // height of tree
	protected int bheight;     // black height of tree

	// NOTE: height and bheight are NOT kept by insert and delete
   //       You must explcitly call calcStats to update values.


	/**
	* Creates new tree and defines NIL.
	*/
	public RBTree()
	{
		NIL= new RBTreeNodeExpanded(null,NIL);
		NIL.left= NIL;
		NIL.right= NIL;
		root= NIL;
		n= height= bheight= 0;
	}


	/**
	* Show tree stats.
	*/
	public String toString()
	{
		return "size("+n+"), height("+height+"), black height("+bheight+")";
	}


	/**
	* Getter for the NIL node.
	* @return reference to NIL node
	*/
	public RBTreeNode NIL()
	{
		return NIL;
	}


	/**
	* Traverses tree to calculate n, height, and bheight.
	*/
	public void calcStats()
	{
		n= height= bheight= 0;
		doCalc(root,1,1);
	}


	/**
	* Does the "dirty work" for calcStats() by recursively obtaining stats.
	*
	* @param x current node being evaluated
	* @param h height/depth of current node
	* @param bh black height of current node
	*/
	protected void doCalc(RBTreeNode x, int h, int bh)
	{
		if (x != NIL) {
			n++;
			if (h > height)	 height= h;
			if (bh > bheight) bheight= bh;
			if (x.right.color=='B')
				doCalc(x.right,h+1,bh+1);
			else
				doCalc(x.right,h+1,bh);
			if (x.left.color=='B')
				doCalc(x.left,h+1,bh+1);
			else
				doCalc(x.left,h+1,bh);
		}
	}


	/**
	* Performs left-rotate operation on node x.
	*/
	public void leftRotate(RBTreeNodeExpanded x)
	{
		if (x.parent != NIL) {
			if (x == x.parent.left) {
				x.parent.left = x.right;
			} else {
				x.parent.right = x.right;
			}
			x.right.parent = x.parent;
			x.parent = x.right;
			if (x.right.left != NIL) {
				x.right.left.parent = x;
			}
			x.right = x.right.left;
			x.parent.left = x;
		} else {	//Need to rotate root
			RBTreeNodeExpanded right = root.right;
			root.right = right.left;
			right.left.parent = root;
			root.parent = right;
			right.left = root;
			right.parent = NIL;
			root = right;
		}
		}


	/**
	* Performs a right-rotate operation on node x.
	 * @param x
	 */
	public void rightRotate(RBTreeNodeExpanded x)
	{
		if (x.parent != NIL) {
			if (x == x.parent.left) {
				x.parent.left = x.left;
			} else {
				x.parent.right = x.left;
			}

			x.left.parent = x.parent;
			x.parent = x.left;
			if (x.left.right != NIL) {
				x.left.right.parent = x;
			}
			x.left = x.left.right;
			x.parent.right = x;
		} else {	//Need to rotate root
			RBTreeNodeExpanded left = root.left;
			root.left = root.left.right;
			left.right.parent = root;
			root.parent = left;
			left.right = root;
			left.parent = NIL;
			root = left;
		}
	}


	/**
	* Getter for height.
	*
	* @return height of tree
	*
	* <p>NOTE: Must call calcStats() before this is valid.</p>
	*/
	public int height()
	{
		return height;
	}


	/**
	* Getter for black height.
	*
	* @return black height of tree
	*
	* <p>NOTE: Must call calcStats() before this is valid.</p>
	*/
	public int bheight()
	{
		return bheight;
	}


	/**
	* Getter for number of nodes in the tree.
	*
	* @return black height of tree
	*
	* <p>NOTE: Must call calcStats() before this is valid.</p>
	*/
	public int size() { return n; }


	/**
	* Searches for node with specified key.
	*
	* @param data data to find
	* @return reference to requested node; NIL if not found.
	*/
	public RBTreeNode find(Object data)
	{
		RBTreeNode x= root;
		int result;

		while (x != NIL) {
			result= x.compareTo(data);
			if (result==0){
				System.out.println(data +" was found in the tree...");
				return x;
			}
			if (result < 0)
				x= x.left;
			else
				x= x.right;
		}
		System.out.println(data + " was not found in tree...");
		return NIL;
	}


	/**
	* Displays contents of tree via an inorder traversal.
	*/
	public void inorder()
	{
		inorder(root);
	}


	/**
	* Helper function for inorder() that recursively performs inorder traversal.
	*
	* @param p current node being looked at during inorder traversal
	*/
	public void inorder(RBTreeNode p)
	{
		if (p==NIL) return;
		inorder(p.left);
		System.out.println(p.data);
		inorder(p.right);
	}
	protected RBTreeNode findInsertLocation(Object data)
	{
		RBTreeNode prev, x;
		int result;

		prev= NIL;
		x= root;
		while (x != NIL)
		{
			prev= x;
			result= x.compareTo(data);
			if (result < 0)
				x= x.left;
			else if(result == 0){
				//x.increment();
				return null;
			}else{
				x= x.right;
			}

		}
		return prev;
	}


	/**
	* Inserts node into red-black tree.
	*
	* @param data reference to data object of node being inserted
	* @return reference to newly inserted node
	*/
	public RBTreeNodeExpanded insert(Object data)
	{
		if(findInsertLocation(data) == null){
			return null;
		}
		RBTreeNodeExpanded prev= findInsertLocation(data);
		RBTreeNodeExpanded newNode= new RBTreeNodeExpanded(data,'R',NIL,prev);
		insertFixup(newNode,prev);
		n++;
		return newNode;
	}


	/**
	* Searches tree for location of insert.
	*
	* @param data data to be inserted
	* @return reference to parent-to-be of new node
	*/



	/**
	* Restores red-black tree properties after an insert.
	*
	* @param newNode reference to node that was just inserted
	* @param prev reference to parent of node that was just inserted
	*/
	protected void insertFixup(RBTreeNode newNode, RBTreeNode prev)
	{
		RBTreeNode x,y;
		int result;

		if (prev == NIL)		// if first node
			root= newNode;
		else {
			result= newNode.compareTo(prev.data);
			if (result > 0)
				prev.left= newNode;
			else
				prev.right= newNode;
		}

		/* fix up tree if necessary */
		x= newNode;
		while ((x!=root) && (x.parent.color=='R')) {
			if (x.parent == x.parent.parent.left) {      /* cases 1-3 */
				y= x.parent.parent.right;
				if (y.color == 'R') {                     /* case 1 */
					x.parent.color= 'B';
					y.color= 'B';
					x.parent.parent.color= 'R';
					x= x.parent.parent;
				}
				else {
					if (x == x.parent.right) {             /* case 2 */
						x= x.parent;
						leftRotate(x);
					}
					x.parent.color= 'B';                   /* case 3 */
					x.parent.parent.color= 'R';
					rightRotate(x.parent.parent);
				}
			}
			else {                                       /* symmetric cases */
				y= x.parent.parent.left;
				if (y.color == 'R') {                     /* case 1' */
					x.parent.color= 'B';
					y.color= 'B';
					x.parent.parent.color= 'R';
					x= x.parent.parent;
				}
				else {
					if (x == x.parent.left) {              /* case 2' */
						x= x.parent;
						rightRotate(x);
					}
					x.parent.color= 'B';                   /* case 3' */
					x.parent.parent.color= 'R';
					leftRotate(x.parent.parent);
				}
			}
		}
		root.color= 'B';
	}


	/**
	* Removes node from red-black tree.
	*
	* @param data data to be removed
	* @return true if key is in tree, false otherwise
	*/
	public boolean delete(Object data)
	{
		RBTreeNode x,y,z= find(data);   // z is node to be removed
		if (z == NIL) return false;

		if (z.right != NIL && z.left != NIL) { // y is node to be spliced out
			y= z.right;
			while (y.left != NIL)               // which is succ(z) if z has 2 children
				y= y.left;
		}
		else
			y= z;

		if (y.left !=NIL)                      // x is child of y (possibly NIL)
			x= y.left;
		else
			x= y.right;
		x.parent= y.parent;

		if (y == root)                         // splice out y
			root= x;
		else if (y==y.parent.left)
			y.parent.left= x;
		else
			y.parent.right= x;

		if (y != z) {        // if node spliced out different than node
			z.data= y.data;   // to be removed, copy appropriate info.
		}

		if (y.color=='B')
			deleteFixup(x);

		n--;
		return true;
	}



	/**
	* Restores red-black tree properties after a node is deleted.
	*
	* @param x child of node that was spliced out of the tree by BST delete
	*/
	protected void deleteFixup(RBTreeNode x)
	{
		RBTreeNode w;

		while (x != root && x.color=='B') {
			if (x.parent.left==x) {              // cases 1-4 (regular)
				w= x.parent.right;
				if (w.color=='R') {               // case 1
					w.color='B';
					x.parent.color='R';
					leftRotate(x.parent);
					w= x.parent.right;
				}

				if (w.left.color=='B' && w.right.color=='B') {  // case 2
					w.color= 'R';
					x= x.parent;
				}
				else {
					if (w.right.color=='B') {                    // case 3
						w.left.color= 'B';
						w.color= 'R';
						rightRotate(w);
						w= x.parent.right;
					}

					w.color= x.parent.color;                     // case 4
					x.parent.color= 'B';
					w.right.color= 'B';
					leftRotate(x.parent);
					x= root;
				}
			}
			else {                                            // symmetric cases 1-4
				w= x.parent.left;
				if (w.color=='R') {                            // case 1'
					w.color='B';
					x.parent.color='R';
					rightRotate(x.parent);
					w= x.parent.left;
				}

				if (w.right.color=='B' && w.left.color=='B') { // case 2'
					w.color= 'R';
					x= x.parent;
				}
				else {
					if (w.left.color=='B') {                    // case 3'
						w.right.color= 'B';
						w.color= 'R';
						leftRotate(w);
						w= x.parent.left;
					}

					w.color= x.parent.color;                    // case 4'
					x.parent.color= 'B';
					w.left.color= 'B';
					rightRotate(x.parent);
					x= root;
				}
			}
		}
		x.color= 'B';
	}
}
