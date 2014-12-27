// David Kong	5/22/12
// BinarySearchTree.java
// Performs the following functions for a Binary Tree
// (1) Read a file from the disk, build the binary tree
// (2) Print the tree in order
// (3) Find an Id in the Binary Tree
// (4) Delete an Id from the Binary Tree
// (5) Count the number of nodes in the Binary Tree
// (6) Clear the binary tree

import java.util.Scanner;
import java.io.*;
import java.util.NoSuchElementException;

public class BinarySearchTree
{
	private TreeNode root;		//instance variables
	private boolean deleted, clear;
	
	//constructor
	public BinarySearchTree()
	{
		root = null;	
		deleted = false;
		clear = false;
	}

	public void loadData()
	{
		File afile = new File ("file50.txt");
		Scanner fromfile = null;
		int id, inv;
		try
		{
			fromfile = new Scanner(afile);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("\nFile not found!\n");
			System.exit(1);
		}
		while(fromfile.hasNext())			//if next element, enter loop. if not, exit
		{
			id = fromfile.nextInt();
			inv = fromfile.nextInt();
			Item i = new Item (id,inv);
			if(root == null)
			{
				root = new TreeNode(i, null, null);
				continue;
			}
			insert(root, i);
		}
	}
	
	//inserts TreeNodes in the correct place
	public void insert (TreeNode temp, Item data) 
	{
		if (data.getId() < ((Item)(temp.getValue())).getId())
		{
			if (temp.getLeft() == null)
				temp.setLeft(new TreeNode(data, null, null));
			else
				insert(temp.getLeft(), data);
		}
		else 
		{
			if (temp.getRight() == null)
				temp.setRight(new TreeNode(data, null, null));
			else
				insert(temp.getRight(), data);
		}
	}
	
	//Prints the Binary Tree in order
	public void printList(TreeNode temp)
	{
		if (temp != null) 
  		{
			printList (temp.getLeft());
			System.out.println(temp.getValue());
			printList (temp.getRight());
  		}
	}
	
	//returns root
	public TreeNode getRoot()
	{
		return root;
	}
	
	//Counts the number of Tree nodes
	public int count(TreeNode temp)
	{
		deleted = false;
		int counter = 0;
		if (temp == null) 
  			return counter;
  		counter = count(temp.getLeft());
  		counter++;//root node  
  		counter = counter + count(temp.getRight());
  		return counter;
	}
	
	//Searches for an ID
	public void search()
	{
		while(true)
		{
			Scanner key = new Scanner(System.in);
			System.out.print("Enter an ID number to search for (-1 to quit) -> ");
			int id = key.nextInt();
			if (id == -1)
				return;
			searchrec(id, root);
		}
	}
	
	//recursive method for search
	public void searchrec(int id, TreeNode nodes)
	{
		if (nodes == null)
		{
			System.out.println("\nNot in stock!\n");
			return;
		}
		else if (id == ((Item)(nodes.getValue())).getId())
		{
			Item i = (Item)(nodes.getValue());
			System.out.println();
			System.out.println(i);
			System.out.println();
		}
		else if (id < ((Item)(nodes.getValue())).getId())
			searchrec(id, nodes.getLeft());
		else 
			searchrec(id, nodes.getRight());
	}

	//clears the Binray Tree
	public void clear()
	{
		clear = true;
		while (root != null)
			delete(((Item)(root.getValue())).getId());
		clear = false;
	}

	//Deletes an ID from the Binary Tree
	public void delete(int id)
	{
		deleted = false;
    	root = deleteHelper(root, id);
    	if (!deleted && !clear)
    		System.out.println("\nId # " + id + " Successfully deleted!\n");
	}

	//recursive method for delete
	private TreeNode deleteHelper(TreeNode node, int id)
	{
	  	if (node == null) 
	  	{
	    	System.out.println("\nId # " + id + " Not such part in stock!\n");
	    	deleted = true;
	    	return null;
	  	}
	  	else if (id == (((Item)(node.getValue())).getId()))
	  	{
	    	return deleteTargetNode(node);
	  	}
	  	else if (id <= (((Item)(node.getValue())).getId()))
	  	{
	    	node.setLeft(deleteHelper(node.getLeft(), id));
	    	return node;
	  	}
	  	else
	  	{ 
	    	node.setRight(deleteHelper(node.getRight(), id));
	    	return node;
	  	}
  	}

	//delete helper
  	private TreeNode deleteTargetNode(TreeNode target)
  	{
	  	if (target.getRight() == null) 
	  	{
	    	return target.getLeft();
	  	}
	  	else if (target.getLeft() == null) 
	  	{
	    	return target.getRight();
	  	}
	  	else if (target.getLeft().getRight() == null) 
	  	{
		    target.setValue(target.getLeft().getValue());
		    target.setLeft(target.getLeft().getLeft());
		    return target;
	  	}
	  	else
	  	{ 
			// left child has right child
			TreeNode marker = target.getLeft();
			while (marker.getRight().getRight() != null)
				marker = marker.getRight();
			target.setValue(marker.getRight().getValue());
			marker.setRight(marker.getRight().getLeft());
			return target;
	  	}
  	}
}