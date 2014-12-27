// David Kong	5/14/12
// SinglyLinkedList.java
// Modify the SinglyLinkedList class to contain the following methods and functions
// as also specified in OrderedList.java
// Performs the following functions on a list,
// read data from a text file, print the list in order,
// search for a value, delete a value, count the nodes,
// and printing the list backwards.

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SinglyLinkedList
{
	private ListNode first;
	private ListNode last;

	public SinglyLinkedList()
	{
		first = null;
		last = null;
	}

	//returns value of first element
	public Object getFirst() 
	{
		if (first == null)
		{
			throw new NoSuchElementException();
		}
		else
		{
			return first.getValue();
		}
	}

	public void addFirst(Object value) //returns the value of the first ListNode
	{
		first = new ListNode(value, first);
	}

	public void printList()	//prints out the list 
	{
		ListNode temp = first; // start at the first node
		while (temp != null) 
		{
			Item i = (Item)(temp.getValue());
			int id1 = i.getId();
			int inv1 = i.getInv();
			System.out.println("Id=" + id1 + ", " + "Inv=" + inv1);
			temp = temp.getNext(); // go to next node
		}
	}
	
	public void addLast(Object value)	//adds passed in value as a ListNode to the end of the list
	{
		//if list is not empty
		if (first != null)
		{

			ListNode val = new ListNode(value, null);
			last.setNext(val);
			last = val;
		}
		//if empty, just assign new value to first and last
		else
		{
			ListNode o = new ListNode(value, null);
			first = o;
			last = o;
		}
	}
	
	//returns last element in the SinglyLinkedList
	public Object getLast()
	{
		if (first == null)
		{
			throw new NoSuchElementException();
		}
		else
		{
			return last.getValue();
		}
	}
	
	//returns number of nodes in the SinglyLinkedList
	public int size()
	{
		int count = 0;
		for (ListNode n = first; n != null; n = n.getNext())
		{
			count++;
		}
		return count;
	}
	
	//loads Item objects from specified file, inserts in ascending order
	public void loadData()
	{
		clear();
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
			insert(i);
		}
	}
	
	//inserts Item objects in the correct order, ascending
	public void insert(Item i)
	{
		boolean found = false;
		//if empty
		if (first == null)
		{
			addFirst(i);
			last = first;
			return;
		}
		ListNode prev = first;
		ListNode curr = first;
		ListNode n = new ListNode(i, null);
		
		//find prev, curr, where to insert
		while((curr != null) && (i.compareTo(curr.getValue()) > 0))
		{
			prev = curr;
			curr = curr.getNext();

		}
		//insert before first
		if (curr == first)
		{
			n.setNext(curr);
			first = n;
		}
		//insert after last
		else if (prev == last)
		{
			prev.setNext(n);
			last = n;
		}
		//normal case
		else
		{
			n.setNext(curr);
			prev.setNext(n);
		}
	}
	
	//returns the first ListNode, as opposed to the value in getFirst()
	public ListNode getFirst2()
	{
		return first;
	}
	
	//recursive implementation required
	//prints the LinkedList in reverse order
	public void printBackwards(ListNode n)
	{
		if (n != null)
		{
			printBackwards(n.getNext());
	
			Item i = (Item)(n.getValue());
			int id = i.getId();
			int inv = i.getInv();
			System.out.println("Id= " + id + ", Inv=" + inv);
		}	
	}
	
	//searches for the inputted Id, returns the inventory avaialble
	public void testFind()
	{
		boolean found = false;
		Scanner keyboard = new Scanner (System.in);
		int id = 0;
		System.out.println();
		while (true)
		{
			found = false;
			System.out.print("Please enter an ID number to search for (-1 to quit) -> ");
			id = keyboard.nextInt();
			if (id == -1)
			{
				System.out.println("\n");
				break;
			}
			for (ListNode n = first; n != null; n = n.getNext())
			{
				Object obj = n.getValue();
				Item i = (Item)obj;
				int newid = i.getId();
				if (id == newid)
				{
					System.out.println("Id = " + newid + " Inv = " + i.getInv());
					System.out.println();
					found = true;
					break;
				}		
			}
			if (found == false)
			{
				System.out.println("Id = " + id + " No such part in stock!");
				System.out.println();
			}
		}
	}
	
	//delets a ListNode from the list, given an Id
	public void testDelete()
	{
		int id = 0;
		boolean found = false;
		Scanner keyboard = new Scanner (System.in);
		System.out.println();
		while (true)
		{
			System.out.print("\nPlease enter an ID number to delete (-1 to quit) -> ");
			id = keyboard.nextInt();
			if (id == -1)
			{
				System.out.println();
				break;
			}
			if (first == null)
			{
				System.out.println("List is empty!");
				continue;
			}
			ListNode prev = first;
			ListNode curr = first;
			while((curr != null) && (id != ((Item)(curr.getValue())).getId()))
			{
				prev = curr;
				curr = curr.getNext();
			}
			//if id not in list
			if (curr == null)
			{
				System.out.println("Id # " + id+ "  No such part in stock!");
				continue;
			}
			//if insert after last element
			if (curr == last)
			{
				prev.setNext(null);
				last = prev;
			}
			//if insert before first element
			else if (curr == first)
			{
				first = first.getNext();
				curr.setNext(null);
			}
			//normal case
			else
			{
				prev.setNext(curr.getNext());
			}
			System.out.println("Id #" + id+ " was deleted!");
		}
	}
	
	//sets all ListNodes in the list to null
	public void clear()
	{
		ListNode n = first;
		while (first != null)
		{
			 n = first;
			 first = first.getNext();
			 n.setNext(null);
		}
		first = last = null;
	}
} 