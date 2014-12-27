// David Kong		2/29/12
// TreeTester.java
// Runner class for BinarySearchTree

import java.util.Scanner;
import java.io.*;

public class TreeTester
{
	private Scanner keyboard;
	
	public TreeTester()
	{
		keyboard = new Scanner(System.in);
	}
	public static void main (String [] args)
	{
		TreeTester test = new TreeTester();
		test.menu();
	}
	
	public void menu()
	{
		String choice;
		Scanner console = new Scanner(System.in);
		BinarySearchTree apple = new BinarySearchTree();
		System.out.println("\n");
		do
		{
			System.out.println("BinarySearchTree algorithms\n");
			System.out.println("(1) Read a file from the disk, build the binary tree");//done
			System.out.println("(2) Print the tree in order");//done
			System.out.println("(3) Find an Id in the Binary Tree");//done
			System.out.println("(4) Delete an Id from the Binary Tree"); //done
			System.out.println("(5) Count the number of nodes in the Binary Tree");//done
			System.out.println("(6) Clear the binary tree"); //done
			System.out.println("(Q) Quit\n");
			System.out.print("Choice ---> ");
			choice = console.nextLine() + " ";
			System.out.println();

			if ('1' <= choice.charAt(0) && choice.charAt(0) <= '6')
			{
				switch (choice.charAt(0))
				{
					case '1' :	
						apple.loadData();	
						break;
					case '2' :
						System.out.println();
						System.out.println("The tree printed in order\n");
						apple.printList(apple.getRoot());
						System.out.println();
						break;
					case '3' :
						apple.search();
						System.out.println();
						break;
					case '4' :
						while (true)
						{
							System.out.print("Enter an ID to delete (-1 to quit) -> ");
							int id = keyboard.nextInt();
							if (id == -1)
								break;
							apple.delete(id);
						}
						System.out.println();
						break;
					case '5' :
						int total = apple.count(apple.getRoot());
						System.out.println("Number of TreeNodes: " + total);
						System.out.println("");
						break;
					case '6' :
						apple.clear();
						System.out.println("Binary Tree cleared!\n");
						break;
				}
			}
		}while (choice.charAt(0) != 'Q' && choice.charAt(0) != 'q');
	}
}