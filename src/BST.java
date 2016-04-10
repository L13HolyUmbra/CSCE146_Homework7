import java.util.ArrayList;

/*
 * Binary Search tree -- BST.java
 * Dion de Jong 4/16/2014
 * Ver: 1.00
 * Description: This is the Binary Search Tree class, which will create 
 * a binary tree using Nodes from BTNode. It can traversed through using 
 * the different traversal methods. 
 * Last modified: 4/02/14
 */

public class BST<T> implements  IBST<T> {
	//private instance variables used throughout class
	private int maxHeight = 0;
	private BTNode<T> root; 
	private int NumberofNodes; 
	private ArrayList<Integer> myList = new ArrayList<Integer>();

	//keeps track of how many levels deep the binary tree is
	@Override
	public int getMaxHeight() 
	{
		return this.maxHeight;
	}

	//keeps track of how many nodes the tree has total
	@Override
	public int getNodeCount() 
	{
		return this.NumberofNodes; 
	}

	//keeps track of the root of the tree
	@Override
	public BTNode<T> getRoot() 
	{
		return this.root;
	}

	//method that will test if the current tree holds the input value
	@Override
	public boolean contains(T testRecord)
	{
		//if the root holds this value, the method is immediately done.
		if(Integer.parseInt(testRecord.toString()) == Integer.parseInt(root.getRecord().toString()))
		{
			return true;
		}
		//if not, we need a recursive method to traverse through the nodes to see if the value does exist somewhere further down. 
		else
		{ 
			return RecursiveContains(testRecord, root); 
		}
	}

	//the recursive part of the contains method. Input includes the value and a node which starts of as the root and will continue to be the parent node. 
	public boolean RecursiveContains(T testRecord, BTNode<T> curNode)
	{
		//Test if the value is equal to the parents (current nodes) value, if so the method is down
		if (Integer.parseInt(testRecord.toString()) == Integer.parseInt(curNode.getRecord().toString()))
		{
			return true; 
		}

		//case 2: test if the value is greater than the parents value
		else if (Integer.parseInt(testRecord.toString()) > Integer.parseInt(root.getRecord().toString()))
		{
			//if it is, see if the parent has a right node.
			if (curNode.hasRight())
			{
				//if it does, recursively call the method again using that node as the new parent. 
				return RecursiveContains(testRecord, curNode.getRight()); 
			}
			else
			{
				//if there is no right node, despite the value being greater than the parent value, the input does not exist in the tree. 
				return false; 
			}
		}

		//case 3: test if the value is less than the parents value
		else if (Integer.parseInt(testRecord.toString()) < Integer.parseInt(root.getRecord().toString()))
		{
			//if it is, see if the parent has a left node.
			if(curNode.hasLeft())
			{
				//if it does, recursively call the method again using that node as the new parent. 
				return RecursiveContains(testRecord, curNode.getLeft()); 
			}

			else
			{
				//if there is no left node, despite the value being less than the parent value, the input does not exist in the tree. 
				return false;
			}
		}
		//the compiler is annoying so I needed this, will never be reached. 
		else
			return false; 
	}

	//this method will add a new node to the binary tree
	@Override
	public BTNode<T> insert(T rec) 
	{
		//create a temp node placeholder
		BTNode<T> temp; 
		//if the tree is empty, the input value creates a root node. 
		if (isEmpty()) 
		{
			//create the actual root node and set the value
			root = new BTNode<T>();
			root.setRecord(rec);
			//height is zero
			root.setHeight(0); 
			//need the temp value for recursive call
			temp = root;
			//add 1 to the number of nodes. 
			NumberofNodes++; 
		}

		else 
		{
			//if this is not the first node in the tree 
			temp = new BTNode<T>(); 
			temp.setRecord(rec);
			//call the recursive method to add a new node to the tree. 
			insert_tree(temp, root); 
			//add one to the number of nodes 
			NumberofNodes++; 
		}
		//return the temp node
		return temp;
	}

	//the recursive half of the insert node method
	private boolean insert_tree(BTNode<T> newNode, BTNode<T> currentNode)
	{
		//save the values of the two input nodes (the one that is being added and the parent node) 
		int newVal = Integer.parseInt(newNode.getRecord().toString()); 
		int CurVal = Integer.parseInt(currentNode.getRecord().toString());

		//if the new nodes value is less than the parent node
		if(newVal < CurVal) 
		{
			//check if there is a left node to that parent, 
			if (currentNode.hasLeft())
			{
				//if there is, set the new parent to that left and recursively call the method again using that parameter. 
				currentNode = currentNode.getLeft();  
				insert_tree(newNode, currentNode); 
			}
			else 
			{
				//if there is no left, the new node becomes the left node of the parent node
				newNode.setParent(currentNode);
				currentNode.setLeft(newNode);
				//set the height of that node
				newNode.setHeight(newNode.getParent().getHeight() + 1);
				//if the new nodes is greater than the instance variable max height, set it to be the new max height
				if (newNode.getHeight() >= getMaxHeight())
				{
					this.maxHeight = newNode.getHeight(); 
				}
			}
		}

		//if the new nodes value is greater than the parent node
		if(CurVal < newVal)
		{
			//check if there is a right node to that parent,
			if (currentNode.hasRight())
			{
				//if there is, set the new parent to that right and recursively call the method again using that parameter.
				currentNode = currentNode.getRight();  
				insert_tree(newNode, currentNode); 
			}
			else
			{
				//if there is no right, the new node becomes the right node of the parent node
				newNode.setParent(currentNode);
				currentNode.setRight(newNode);
				//set the height of that node
				newNode.setHeight(newNode.getParent().getHeight() + 1);
				//if the new nodes is greater than the instance variable max height, set it to be the new max height
				if (newNode.getHeight() >= getMaxHeight())
				{
					this.maxHeight = newNode.getHeight(); 
				}
			}
		}
		return true; 
	}

	//check if the current is empty
	@Override
	public boolean isEmpty() 
	{
		if (root == null)
		{
			return true; 
		}
		else
		{
			return false;
		}
	}

	//use the recursive InOrder method and print out the array list created from that. 
	@Override
	public String toStringInorder(BTNode<T> v)
	{
		//clear the list 
		myList.clear();
		//call the traverse method starting at the root
		traverseInorder(root);
		//initialize the returned string
		String numbers = ""; 
		//loop through the array list and print each value. 
		for (int i = 0; i < myList.size(); i ++)
		{
			numbers = numbers + " " + myList.get(i).toString(); 
		}
		return numbers; 
	}

	//recursive half of the InOrder
	private void traverseInorder(BTNode<T> root)
	{
		//if there is a left node to the "parent" node, call the recursive method on that left node. 
		if (root.hasLeft())
		{
			traverseInorder(root.getLeft());
		}

		//if we're here that means we're as far left as we could have gone and we should now store the value.
		int rootval = Integer.parseInt(root.getRecord().toString());
		myList.add(rootval); 

		//right nodes are the last ones to get added, so we should recursively call the method on the right node if it exists after going left.
		if(root.hasRight())
		{
			traverseInorder(root.getRight());
		}

	}

	//use the recursive PreOrder method and print out the array list created from that. 
	@Override
	public String toStringPreorder(BTNode<T> v)
	{
		//clear the list
		myList.clear();
		//call the traverse method starting at the root
		traversePreorder(root);
		//initialize the returned string
		String numbers = ""; 
		//loop through the array list and print each value. 
		for (int i = 0; i < myList.size(); i ++)
		{
			numbers = numbers + " " + myList.get(i).toString(); 
		}
		return numbers; 
	}

	//recursive half of the PreOrder
	private void traversePreorder(BTNode<T> root)
	{
		//the parents in preorder are saved first
		int rootval = Integer.parseInt(root.getRecord().toString());
		myList.add(rootval); 

		//if there is a left node to the "parent" node, call the recursive method on that left node, since lefts are saved afterwards
		if (root.hasLeft())
		{
			traversePreorder(root.getLeft());
		}

		//rights are saved last so after all the lefts are gone recursively call on the right node to save that value. 
		if(root.hasRight())
		{
			traversePreorder(root.getRight());
		}

	}

	//use the recursive PostOrder method and print out the array list created from that. 
	@Override
	public String toStringPostorder(BTNode<T> v)
	{
		//clear the list
		myList.clear();
		//call the traverse method starting at the root
		traversePostorder(root);
		//initialize the returned string
		String numbers = ""; 
		//loop through the array list and print each value. 
		for (int i = 0; i < myList.size(); i ++)
		{
			numbers = numbers + " " + myList.get(i).toString(); 
		}
		return numbers; 
	}

	//recursive half of the PostOrder
	private void traversePostorder(BTNode<T> root)
	{	
		//the left node is saved first, so go as far left as possible
		if (root.hasLeft())
		{
			traversePostorder(root.getLeft());
		}

		//then go as far right as possible since rights are saved second
		if(root.hasRight())
		{
			traversePostorder(root.getRight());
		}

		//then save the parents or root 
		int rootval = Integer.parseInt(root.getRecord().toString());
		myList.add(rootval); 
	}


}
