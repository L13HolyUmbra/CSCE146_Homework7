/*
 * BTNode.java
 * Dion de Jong 4/02/2014
 * Ver: 1.00
 * Description: This is the BTNode class. It defines a binary tree node, and 
 * allows this object to be manipulated and used as a data structure. 
 * Last modified: 4/02/14
 */

public class BTNode<T> implements IBTNode<T> 
{
	//instance variables needed that will be attached in the Binary Tree
	private int height;
	private BTNode<T> left;
	private BTNode<T> right;
	private BTNode<T> parent;
	private T record;


	/***************************************************************************
	 * Constructor 
	 * 
	 */
	//default constructor
	public BTNode()
	{
		height = 0;
		left = null;
		right = null;
		parent = null;
		record = null;
	}

	//default constructor that takes in a parameter that is assigned to the node's record(value)
	public BTNode(T blah)
	{
		height = 0;
		left = null;
		right = null;
		parent = null;
		record = blah;
	}

	//setter and getter for height. 
	@Override
	public int getHeight() 
	{
		return height;
	}

	@Override
	public void setHeight(int i) 
	{
		this.height = i; 
	}

	//getters and setters for all instance variables. 
	@Override
	public BTNode<T> getLeft() 
	{
		return left;
	}

	@Override
	public void setLeft(BTNode<T> v) 
	{
		this.left = v; 
	}

	@Override
	public BTNode<T> getParent() 
	{
		return parent;
	}

	@Override
	public void setParent(BTNode<T> v) 
	{
		this.parent = v; 
	}

	@Override
	public T getRecord() 
	{
		return record;
	}

	@Override
	public void setRecord(T rec)
	{
		this.record = rec; 
	}

	@Override
	public BTNode<T> getRight() 
	{
		return right;
	}

	@Override
	public void setRight(BTNode<T> v) 
	{
		this.right = v; 
	}

	//test if the current node has a left or right by testing if the 
	// corresponding instance variable is set to null
	@Override
	public boolean hasLeft() 
	{
		if (this.left == null)
		{
			return false;
		}
		else
			return true; 
	}

	@Override
	public boolean hasRight() 
	{
		if (this.right == null)
		{
			return false;
		}
		else
			return true;
	}

	//return the element inside a record in the node as a string value. 
	public String toString()
	{
		String RecordString = this.getRecord().toString(); 
		return RecordString; 
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		BTNode test = new BTNode(3); 
//		System.out.println(test.toString()); 
//	}
}
