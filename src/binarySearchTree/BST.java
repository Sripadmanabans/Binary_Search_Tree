package binarySearchTree;

public class BST 
{
	//Root of the tree
	private Tree root = null;
	private static boolean status;
	
	//Insertion into the tree
	public Tree insert(Tree next, int value)
	{
		if(next == null) //Inserting the root node
		{
			next = new Tree();
			next.setData(value);
			next.setRight(null);
			next.setLeft(null);
			root = next;
		}
		else //inserting nodes after the root
		{
			Tree temp = null;
			while(true)
			{
				if(next.getData() < value) //Value is greater than root insert into left
				{
					if(next.getRight() != null) //Moving to the leaf node so that the node can be added
					{
						next = next.getRight();
					}
					else //Adding to the leaf node
					{
						temp = new Tree();
						temp.setData(value);
						next.setRight(temp);
						break;
					}
				}
				else //Value is less than or equal to the value of the root so adding to the left of the root
				{
					if(next.getLeft() != null) //Moving to the leaf node
					{
						next = next.getLeft();
					}
					else //Adding to the leaf node
					{
						temp = new Tree();
						temp.setData(value);
						next.setLeft(temp);
						break;
					}
				}
			}
		}
		return root;
	}
	
	//Finding an element in the tree 
	public void find(Tree temp, int value)
	{
		if(temp.getData() == value) //Checking if the data in the node is what we want
		{
			System.out.println("The Value is there in the tree");
			return;
		}
		else //Trying to find the node
		{
			if(temp.getData() < value) //Checking if value is greater than root
			{
				if(temp.getRight() != null) //Moving to right node if present
				{
					find(temp.getRight(), value);
				}
			}
			else //The value is equal or less than root
			{
				if(temp.getLeft() != null) //Moving to left if it is present
				{
					find(temp.getLeft(), value);
				}
			}
		}
		if(temp.getLeft() == null && temp.getRight() == null && temp.getData() != value) //The data is not present
		{
			System.out.println("Not there");
		}
	}
	
	//Finding the height of the tree
	public int treeHeight(Tree temp)
	{
		if(temp == null)
		{
			return 0;
		}
		return 1 + Math.max(treeHeight(temp.getLeft()), treeHeight(temp.getRight()));
	}
	
	public static boolean isSame(Tree main, Tree sub)
	{
		if(main.getData() == sub.getData())
		{
			if(main.getLeft() != null && sub.getLeft() !=null)
			{
				isSame(main.getLeft(), sub.getLeft());
			}
			if(main.getRight() != null && sub.getRight() !=null)
			{
				isSame(main.getRight(), sub.getRight());
			}
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//Subtree check
	public static boolean subTree(Tree main, Tree sub)
	{
		status = false;
		if(main.getData() == sub.getData())
		{
			status = isSame(main, sub);
			return status;
		}
		else 
		{	
			if(main.getData() < sub.getData())
			{
				if(main.getRight() != null)
				{
					subTree(main.getRight(),sub);
				}
			}
			else
			{
				if(main.getLeft() != null)
				{
					subTree(main.getLeft(),sub);
				}
			}
		}
		return status;
	}
	
	//Main method
	public static void main(String[] args) 
	{
		int[] array1 = {4,2,1,3,6,5,7};
		int[] array2 = {2,1,4};
		int count = 0;
		Tree root = null;
		Tree root2 = null;
		BST tree = new BST();
		BST sub = new BST();
		while(count < 7)
		{
			root = tree.insert(root, array1[count]);
			count++;
		}
		count = 0;
		while(count < 3)
		{
			root2 = sub.insert(root2, array2[count]);
			count++;
		}		
		tree.find(root, 6);
		tree.find(root2, 1);
		tree.find(root2, 5);
		System.out.println("The height of the tree is : " + tree.treeHeight(root));
		System.out.println("Status : " + subTree(root,root2));
	}
}
