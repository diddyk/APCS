// David Kong		11/17/11
// InOrder.java
// This program will prompt the user for the length of the ArrayList
// and which swap algorithm to use. 
// It then fills the ArrayList with random digits from 1-100.
// The program will then utilize the selected algorithm
// to order the ArrayList, least to greatest. When the 
// ArrayList is in order, it will notify the user the number
// of swaps taken.
// Dumb Sort -> swap 2 numbers at random until in order
// Bubble Sort -> Compares 2 adjacent integers, if a > b, swap
// Selection Sort -> Searches for smallset int, and places it in the first available swap.
// Insertion Sort -> "Intakes" 1 integer at a time, and puts it in order

import java.util.*;

public class InOrder
{
	private int length;		//instance variables
	private int choice;
	private int count;
	private ArrayList <Integer> numbers;
	private long time;
	
	public InOrder()		//constructor
	{
		length = count = 0;
		choice = -1;
		numbers = new ArrayList <Integer>();
		time = 0;
	}
	
	public static void main (String[] args)
	{
		InOrder order = new InOrder();
		
		order.promptUser();
		order.fillArrayList();
		order.swap();
		order.exitMessage();
	}
	
	//Prompts the user for the size of the ArrayList
	public void promptUser()
	{
		Scanner keyboard = new Scanner (System.in);
		System.out.println("\n\nWelcome to InOrder.java!");
		do
		{
			System.out.print("Choose the size of the array, between 2 and 10 -> ");
 			length = keyboard.nextInt();
		}while (length < 2 || length > 10);
		
		String temp;
		do
		{
			System.out.println("\n(0) Dumb Sort");
			System.out.println("(1) Bubble Sort");
			System.out.println("(2) Selection Sort");
			System.out.println("(3) Insertion Sort");
			System.out.println("(4) Merge Sort");
			System.out.print("\nPlease choose a type of sort (0 - 4) -> ");
			temp = keyboard.next();
			choice = temp.charAt(0);
			choice = choice - 48;
		}while (choice < 0 || choice > 4);;
	}
	
	//Fills the ArrayList with random numbers from 1-100
	public void fillArrayList()
	{
		System.out.println("\n");
		Dice die = new Dice(100);
		for (int i = 0; i < length; i++)
		{
			numbers.add(die.roll());
		}
		if (choice != 4)
		{
			System.out.printf("Number of swaps: %5d", count);
			printArrayList();
		}
	}
	
	//Prints out the elements of the array list
	public void printArrayList()
	{
		if (choice != 4)
		{
			int index = 0;
			System.out.print("\t  ArrayList:\t");
			while (index < numbers.size())
			{
				System.out.print(numbers.get(index) + "   ");
				index++;
			}
		}
	}
	
	//Checks the order of the array list
	public boolean checkOrder()
	{
		int index = 0;
		for (index = 0; index < length - 1; index++)
		{
			if (numbers.get(index) > numbers.get(index + 1))
				return false;
		}
		return true;
	}
	
	//Determines which swap algorithm to use
	public void swap()
	{
		time = System.currentTimeMillis();//record time when starting to sort
		switch(choice)
		{
			case 0: dumbSort(); break;
			case 1: bubbleSort(); break;
			case 2: selectionSort(); break;
			case 3: insertionSort(); break;	
			case 4: mergeSort(numbers); break;
		}
	}
	
	//Orders ArrayList by swapping 2 numbers at random
	public void dumbSort()
	{
		System.out.println();
		count++;
		boolean done = false;
		Dice die = new Dice(length);
		int rollvalue1 = 0;
		int rollvalue2 = 0;
		System.out.println();
		while (!done)
		{	
			do
			{
				rollvalue1 = die.roll() - 1;
				rollvalue2 = die.roll() - 1;
			}while (rollvalue1 == rollvalue2);
			
			int temp1 = numbers.get(rollvalue1);
			int temp2 = numbers.get(rollvalue2);
			numbers.set(rollvalue1, temp2);
			numbers.set(rollvalue2, temp1);	
			System.out.printf("Number of swaps: %5d", count);
			
			done = checkOrder();

			printArrayList();
			count++;
			System.out.println("\n");
		}
		count--;
	}
	
	//Orders ArrayList with Bubble Sort
	public void bubbleSort()
	{
		for (int outer = 0; outer < numbers.size() - 1; outer++)
		{
    		for (int inner = 0; inner < numbers.size()-outer-1; inner++)
    		{
     			if (numbers.get(inner) > numbers.get(inner + 1))
     			{
					//swap list[inner] & list[inner+1]
					int temp = numbers.get(inner);
					numbers.set(inner, numbers.get(inner + 1));
					numbers.set(inner + 1, temp);
				}				
      		}
      		count++;
      		System.out.println("\n");
      		System.out.printf("Number of swaps: %5d", count);
			printArrayList();      		
    	}
  	}
	
	//Orders ArrayList with Selection Sort
	public void selectionSort()
	{
		int min, temp;

  		for (int outer = 0; outer < numbers.size() - 1; outer++)
  		{
			min = outer;
			for (int inner = outer + 1; inner < numbers.size(); inner++)
			{
				if (numbers.get(inner) < numbers.get(min)) 
				{
					min = inner; // a new smallest item is found
				}
			}
			//swap list[outer] & list[min]
			temp = numbers.get(outer);
			numbers.set(outer, numbers.get(min));
			numbers.set(min, temp);
			count++;
      		System.out.println("\n");
      		System.out.printf("Number of swaps: %5d", count);
			printArrayList();  
		}
	}
	
	//Orders ArrayList with Insertion Sort
	public void insertionSort()
	{
		for (int outer = 1; outer < numbers.size(); outer++)
		{
			int position = outer;
			int key = numbers.get(position);

			// Shift larger values to the right
			while (position > 0 && numbers.get(position - 1) > key)
			{	
				numbers.set(position, numbers.get(position - 1));
				position--;
			}
			numbers.set(position, key);
			count++;
      		System.out.println("\n");
      		System.out.printf("Number of swaps: %5d", count);
			printArrayList(); 	
	  	}	
	}
	
	//Prints out the MergeSort
	public void printMergeArray(ArrayList<Integer> array)
	{
		System.out.printf("\nNumber of Swaps: %6d%4s", (count + 1), " ");
		System.out.print("ArrayList: ");
		for (int i = 1; i < array.size(); i++)
		{
			System.out.printf("%4d", array.get(i));
		}
		count++;
	}
	
	//MergeSort algorithm
	public void mergeSort (ArrayList<Integer> numbers) 
	{	
		int length = numbers.size()-1;
		if (length < 1)
		{
			return;  // the numbers is already sorted in this case
		}
		// divide
		ArrayList<Integer> array1 = new ArrayList<Integer>(); 
		ArrayList<Integer> array2 = new ArrayList<Integer>(); 
		int i = 0;
	    
		while (i <= length/2)
		{
			array1.add(numbers.remove(0)); // move the first n/2 elements to array1
			i++;
		}
		while (!numbers.isEmpty())
		{
			array2.add(numbers.remove(0)); // move the rest to array2
		}
	    
		mergeSort(array1);
		mergeSort(array2);
		merge(array1,array2,numbers); 
		printMergeArray(numbers);
	}	
	
	//Creates temp arrays for mergesort
	public void merge (ArrayList<Integer> array1, ArrayList<Integer> array2, ArrayList<Integer> array)
	{	
		while (!array1.isEmpty() && !array2.isEmpty())
		{
			if ((array1.get(0).compareTo(array2.get(0)) <= 0))
			{
				array.add(array1.remove(0));
			}
			else
			{
				array.add(array2.remove(0));
			}
		}
		while(!array1.isEmpty()) // move the remaining elements of array1
		{
			array.add(array1.remove(0));
		}
		while(!array2.isEmpty()) // move the remaining elements of array2
		{
			array.add(array2.remove(0));
		}
	}
	
	//Prints an exit message
	public void exitMessage()
	{
		time = System.currentTimeMillis() - time; //calculate total time taken
		System.out.print("\n\nThanks for playing. It took " + count + " random swaps and " + time + " thousandths of a second to order the ArrayList of Integers.\n\n\n");
	}
}