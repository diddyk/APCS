// David Kong	9/29/11
// Roman.java

import java.util.Scanner;

public class Roman
{	
	public Roman()				//constructor
	{
	}
	
	public static void main (String [] args)
	{
	}
	/*
	public void prompt()
	{
		Scanner keyboard = new Scanner(System.in);
		String temp = "";
		System.out.print("\n\n\nWhat would you like to convert?");
		System.out.print("\nType in 'Arabic' to convert into Arabic, and 'Roman' to convert into Roman.\n ->  ");
		temp = keyboard.next();
		if (temp.equalsIgnoreCase("roman"))
		{
			System.out.print("\nConverting to Roman...\n");
			toRoman();
		}
		else if (temp.equalsIgnoreCase("arabic"))
		{
			System.out.print("\nConverting to Arabic...\n");
			toArabic();
		}
	}
	*/
	
	public static String toRoman(int convert)
	{
		System.out.print("\n\n" + convert + "\n");
		return "";
	}
	
	public static int toArabic(String convert)
	{
		int total = 0;
		int [] nums = convert.length();
		for (int i = 0; i < convert.length(); i++)
		{
			char temp = convert.charAt(i);
			switch (temp)
			{
				case 'i': case 'I':
					nums[i] = 1
					break;
				case 'V':
					nums[i] = 5;
					break;
				case 'X':
					nums[i] = 10;
					break;
				case 'L':
					nums[i] = 50;
					break;
				case 'C':
					nums[i] = 100;
					break;
				case 'D':
					nums[i] = 500;
					break;
				case 'M':
					nums[i] = 1000;
					break;
				default:
					
			}
		}
		for (int i = 0; i < convert.length; i++)
		{
			if (nums[i] < convert.charAt(i))
				total =  nums[i]
			else
		}
		
		return total;
		
	}
}