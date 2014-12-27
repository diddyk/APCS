// 

public class Merge
{	
	private int count, arraysize, donesize, size;
	
	public Merge(ArrayList<Integer> array)
	{
		count = arraysize =  size = 0;
		donesize = array.size();	
	}
	
	public void printMergeArray(ArrayList<Integer> array)
	{
		System.out.printf("\nNumber of Swaps: %6d%4s", count, " ");
		System.out.print("ArrayList: ");
		for (int i = 1; i < array.size(); i++)
		{
			System.out.printf("%4d", array.get(i));
		}
		count++;
	}
	
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
	
	public int getCount()
	{
		return count;
	}
}
	