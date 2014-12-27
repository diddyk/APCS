// David Kong	1/4/12
// Store.java
// A store with items of the Item Class containing
// ID nums and inventories. Arranges the items
// in order with merge sort according to ID number.
// Uses a binary search to search for a user-
// inputted ID number and returns the index.

import java.io.*;
import java.util.*;

public class Store
{
	private Item [] myStore = new Item [1];	//instance variables
	private int counter;
	private int length;

	//constructors
    public Store(String fName)
    {
    	loadFile(fName);
    	//Item [] myStore = new Item [length];
		for(Item i: myStore)
    		i = new Item(0,0);
    	counter = 0;
    }

    public Store()
    {
    	for(Item i: myStore)
    		i = new Item(0,0);
    	counter = 0;
    }
    
    //loads the file with ID nums and inventories
    private void loadFile(String inFileName)
    { 
    	Scanner keyboard = new Scanner (System.in);
		File file = new File (inFileName);
		
		Scanner in = null;
		try 
		{
			in = new Scanner(file);
		}
		catch (FileNotFoundException e)
		{
			System.out.println ("\nError: Unable to find " + file + ".");
			System.out.print("\n\n");
			System.exit(1);
		}
		int temp = 0;
		
		//creates array with same length as number of items in the text file
		if (in.hasNext())	
		{
			length = in.nextInt();
			myStore = new Item [length];
		}
		
		//reads in the id and inv for every item, stores it in the Item array
		while (in.hasNext())
		{
			int id = in.nextInt();
			int inv = in.nextInt();
			myStore[temp] = new Item(id, inv);
			temp++;
		}
    }
    
    //Prints out the ID nums and inventory numbers of the store
    public void displayStore()
    {	
    	System.out.println("\t\t Id\t\tInv");
    	int temp = 1;
    	for (int i = 0; i < myStore.length; i++)
    	{
    		System.out.println();
    		System.out.printf("%3d\t\t%4d\t\t%3d", temp, myStore[i].getId(), myStore[i].getInv());
    		if (temp%10 == 0)
    			System.out.println(); 
    		temp++;
    	}
    }
    
    //manages mergesort
    public void Sort()
    {		
    	mergesort(myStore, 0, myStore.length);
    } 
    
    // mergesort a  
	public static void mergesort (Item [] data, int first, int n)
	{
		int n1; // Size of the first half of the array
		int n2; // Size of the second half of the array

		if (n > 1)
		{
			// Compute sizes of the two halves
			n1 = n / 2;
			n2 = n - n1;

			mergesort(data, first, n1);      // Sort data[first] through data[first+n1-1]
			mergesort(data, first + n1, n2); // Sort data[first+n1] to the end

			// Merge the two sorted halves.
			merge(data, first, n1, n2);
		}
	} 
  
	//mergesort b
	private static void merge (Item [] data, int first, int n1, int n2)
	{
		Item [] temp = new Item[n1+n2]; // Allocate the temporary array
		int copied  = 0; // Number of elements copied from data to temp
		int copied1 = 0; // Number copied from the first half of data
		int copied2 = 0; // Number copied from the second half of data
		int i;           // Array index to copy from temp back into data

		// Merge elements, copying from two halves of data to the temporary array.
		while ((copied1 < n1) && (copied2 < n2))
		{
			if (data[first + copied1].getId() < data[first + n1 + copied2].getId())
			{
				temp[copied++] = data[first + (copied1++)];
			}
			else
			{
				temp[copied++] = data[first + n1 + (copied2++)];
			}
		}

		// Copy any remaining entries in the left and right subarrays.
		while (copied1 < n1)
			temp[copied++] = data[first + (copied1++)];
		while (copied2 < n2)
			temp[copied++] = data[first + n1 + (copied2++)];

		// Copy from temp back to the data array.
		for (i = 0; i < n1+n2; i++)
			data[first + i] = temp[i];
   }
	
	//manages binary search
	public void Search()
	{
		binarySetUp();
	}
	
	//sets up another array for the binary search
	public void binarySetUp()
	{
		Scanner keyboard = new Scanner(System.in);
        Integer [] a = new Integer [length];
        for( int i = 0; i < length; i++ )
            a[i] = myStore[i].getId();
          
        System.out.print("\n\n\n");
        int i = 0;
        do
        {
        	System.out.println("\n\n-----------------------------------------------------------------------------");
			do
			{
				System.out.print("Please enter an ID number to look for (0 to 10000, -1 to exit) -> ");
				i = keyboard.nextInt();
				if (i == -1)
				{
					System.out.println("\n\n\n");
					System.exit(1);
				}
			}while (i < 0 || i > 10000);
			int INDEX = (binarySearch(a, new Integer(i)) + 1);
			if (INDEX != 0)
			{
				System.out.println("The binary search took " + counter + " steps to find this inventory item.");
				System.out.println("\nThe inventory item was found at index "  + INDEX + " out of " + length + " items in the inventory.");
				System.out.println("\n ID number\tNumber of Item");
				System.out.printf("  %5d\t\t    %3d", myStore[INDEX - 1].getId(), myStore[INDEX-1].getInv());
				counter = 0;
			}
			else
			{
				System.out.print("\nThe binary search took " + counter + " steps to determine that this inventory item does not exist.");
				counter = 0;
			}
		}while(true);
	}
	
	//binary search
	public int binarySearch(Integer [] a, Integer x)
    {
        int low = 0;
        int high = a.length - 1;
        int mid;

        while( low <= high )
        {
        	counter++;
            mid = ( low + high ) / 2;
            if( a[mid].compareTo( x ) < 0 )
                low = mid + 1;
            else if( a[mid].compareTo( x ) > 0 )
                high = mid - 1;
            else
                return mid;
        }
        return -1;     // NOT_FOUND = -1
    }
}