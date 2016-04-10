/*
 * BTNode Interface
 * Dion de Jong 4/02/2014
 * Ver: 1.00
 * Description: This is the interface for the Binary Tree Node class that 
 * defines Binary Tree nodes and implements all methods that allows them 
 * to be manipulated and used. 
 * Last modified: 4/02/14
 */

public interface IBTNode<T>
{
  public int getHeight();
  public void setHeight(int i);
  
  public BTNode<T> getLeft();

  public void setLeft(BTNode<T> v);

  public BTNode<T> getParent();

  public void setParent(BTNode<T> v);

  public T getRecord();

  public void setRecord(T rec);

  public BTNode<T> getRight();

  public void setRight(BTNode<T> v);

  public boolean hasLeft();

  public boolean hasRight();

  public String toString();

} // public interface IBTNode