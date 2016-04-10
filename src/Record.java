
/**
 * Record.java
 * This class is the data payload class for our BST.
 * Copyright (C) 2012 by Casey A. Cole.  All rights reserved.
 * @author Casey A. Cole <coleca@email.sc.edu> 
 * @version 1.0 Nov 10, 2012
 */


public class Record implements IRecord 
{

	//changed to int for purpose of project
	private int element;


	/***************************************************************************
	 * Constructor 
	 * 
	 */
	public Record()
	{
		element = 0;
	}

	/*********************************************************************
	 * Accessors and Mutators
	 **/
	public int getElement() 
	{
		return element;
	}


	public void setElement(int what) 
	{
		element = what;
	}
}
