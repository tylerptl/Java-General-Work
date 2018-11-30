import java.io.IOException;

/**
* MergeSortDriver for red-black tree implementation of bible words.
*
* @author  T.Sergeant
* @version for Data Structures Homework
*
*/

public class Driver
{
  public static void main(String[] args) throws IOException {
	  RBTreeExpanded rbtree= new RBTreeExpanded();

	  rbtree.createTree();  //test for BibleWord
	  rbtree.insert("test");    //test for strings
	  rbtree.insert("123");
	  rbtree.insert(99);    //test for non-string object
	  System.out.println(rbtree.find("123"));   //test for found
	  System.out.println(rbtree.find("zxcvasdf"));  //test for not found
	  System.out.println(rbtree.find(99));  //test for non-String found

	  rbtree.fillArray(rbtree.root);
	  rbtree.sortFreqArray();
	  rbtree.calcStats();
	  System.out.println("\n\nBlack height : " + rbtree.bheight());

	  rbtree.display();
  }
}

