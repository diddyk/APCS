// David Kong
// 8/25/11
// Nested.java

public class Nested
{
	public static void main (String [] args)
	{
		System.out.print("\n\n");
		for (int row = 1; row <= 18; row++) //outer loop controls rows
		{
			for (int col = 1; col <= 22; col++) //inner loop controls columns
			{
				System.out.printf("%6d", row * col);
			}
			System.out.println();
		}
		System.out.print("\n\n");		
		
		int [] number;
		number = new int [10];
		
		for (int i = 0; i < number.length; i++)
		{
			number [i] = i*i - i + 3;
			System.out.println(i);
		}
		System.out.print("\n\n");	
	}
}