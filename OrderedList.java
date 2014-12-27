// David Kong	5/16/12
// OrderedList.java
// Performs the following functions on a SinglyLinkedList
// Read data from a text file, print the list in order,
// search for a value, delete a value, count the nodes,
// and printing the list backwards.

import java.util.Scanner;
import java.io.*;

public class OrderedList
{
	public static void main ( String [] args )
	{
		OrderedList bringorder = new OrderedList();
		bringorder.mainMenu();
	}
 
	public void mainMenu ()
	{
		SinglyLinkedList list = new SinglyLinkedList();

		String choice;
		Scanner console = new Scanner(System.in);

		do
		{
			System.out.println("Linked List algorithm menu\n");
			System.out.println("(1) Read data from disk");//done
			System.out.println("(2) Print ordered list");//done
			System.out.println("(3) Search list");//done
			System.out.println("(4) Delete from list");//done
			System.out.println("(5) Clear entire list");//done
			System.out.println("(6) Count nodes in list");//done
			System.out.println("(7) Print list backwards");//done
			System.out.println("(Q) Quit\n");
			System.out.print("Choice ---> ");
			choice = console.nextLine() + " ";
			System.out.println();

			if ('1' <= choice.charAt(0) && choice.charAt(0) <= '7')
			{
				switch (choice.charAt(0))
				{
					case '1' :	
						list.loadData();		
						break;
					case '2' :
						System.out.println();
						System.out.println("The tree printed in order\n");
						list.printList();
						System.out.println();
						break;
					case '3' :
						list.testFind();
						break;
					case '4' :
						list.testDelete();
						break;
					case '5' :
						list.clear();
						break;
					case '6' :
						System.out.println("Number of nodes = " + list.size ());
						System.out.println();
						break;
					case '7' :
						list.printBackwards(list.getFirst2());
						System.out.println();
						break;
				}
			}
		}
		while (choice.charAt(0) != 'Q' && choice.charAt(0) != 'q');
	}
}