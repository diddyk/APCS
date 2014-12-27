// David Kong		5/11/12
// ListDemo.java
// Tester class for modifed methods of SinglyLinkedList

public class ListDemo
{
	public static void main (String [] args)
	{
		/*
		ListNode list;
		list = new ListNode(new Integer(13), null);
		System.out.println("\n\nThe node contains: " + (Integer)list.getValue());

		list.setValue(new Integer(17));
		System.out.println("\n\nThe node contains: " + (Integer)list.getValue());

		SinglyLinkedList mylist;
		mylist = new SinglyLinkedList();
		for (int i = 0; i < 10; i++)
		{
			mylist.addFirst(new Integer(i*i));		
			mylist.addLast((Integer)5);
		}
		SinglyLinkedList testempty = new SinglyLinkedList();
		//testempty.addLast((Integer)999999);
		//testempty.addFirst((Integer)5555);

		System.out.println(mylist.size());
		System.out.println("\n\n\n");
		mylist.printList();
		testempty.printList();
		System.out.println("\n\n\n");
		*/
		
		SinglyLinkedList order = new SinglyLinkedList();
		for (int i = 1; i <= 20; i++)
		{
			Integer temp = new Integer(i);
			order.addLast(temp);
		}
		
		System.out.println("\n\n");
		System.out.println("First Element: " + order.getFirst());
		System.out.println("Last Element: " + order.getLast());
		System.out.print("SinglyLinkedList: ");
		order.printList();
		System.out.println("\nNodes: " + order.size());
		System.out.println("\n\n");
		
	}
}