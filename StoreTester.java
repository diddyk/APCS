// David Kong	1/4/12
// StoreTester.java
// Tester/driver class for Store.java
public class StoreTester
{
    public static void main (String [] args)
    {
    	System.out.println("\n\n\n");
    	Store str = new Store("file100.txt");
    	str.Sort();
    	str.displayStore();
    	str.Search();
    	System.out.println("\n\n\n");
	}
}