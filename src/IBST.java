/*
 * Binary Search Tree Interface
 * Dion de Jong 4/16/2014
 * Ver: 1.00
 * Description: This is the interface for the binary search tree. 
 * Last modified: 4/02/14
 */
	public interface IBST<T>
	{

	  // retuns the Height of the tree	
	  public int getMaxHeight();

	  // counts/ keep the number of the nodes 	
	  public int getNodeCount();

	  // returns the root node
	  public BTNode<T> getRoot();

	  // returns true if testRecord exists in BST
	  public boolean contains(T testRecord);

	  //inserts a new record/item in tree and returns corresponding 
	  //node
	  public BTNode<T> insert(T rec);

	  // checks if BST is empty
	  public boolean isEmpty();

	  // traverse BST using  Inorder algorithm 
	  public String toStringInorder(BTNode<T> v);

	  // traverse BST using  Preorder algorithm
	  public String toStringPreorder(BTNode<T> v);

	  // traverse BST using  Postorder algorithm
	  public String toStringPostorder(BTNode<T> v);

	} // public interface IBT

