package binarySearchTree;

public class Tree 
{
	//The right side of the tree
	private Tree right;
	
	//The left side of the tree
	private Tree left;
	
	//The data in the node
	private int data;
	
	//Constructor to assign initial values
	public Tree()
	{
		right = null;
		left = null;
		data = 0;
	}
	
	//Setting the data to node
	public void setData(int value)
	{
		data = value;
	}
	
	//Setting the left child
	public void setLeft(Tree left)
	{
		this.left = left;
	}
	
	//Setting the right child
	public void setRight(Tree right)
	{
		this.right = right;
	}

	//Retrieving the right node
	public Tree getRight()
	{
		return right;
	}
	
	//Retrieving the Left node
	public Tree getLeft()
	{
		return left;
	}
	
	//Retrieving the data
	public int getData()
	{
		return data;
	}
}
