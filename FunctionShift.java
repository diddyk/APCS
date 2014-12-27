// David Kong		11/2/11
// FunctionShift.java

public class FunctionShift
{
	private double vertstretch, horizcompact, leftshift, upshift;
	
	public FunctionShift()
	{
		vertstretch = 1.0;
		horizcompact = 1.0;
		leftshift = 0.0;
		upshift = 0.0; 
	}	
	
	public FunctionShift(double a, double b, double c, double d)
	{
		vertstretch = a;
		horizcompact = b;
		leftshift = c;
		upshift = d;
	}	
	
	public double geta()
	{
		return vertstretch;
	}
	
	public double getb()
	{
		return horizcompact;
	}
	
	public double getc()
	{
		return leftshift;
	}
	
	public double getd()
	{
		return upshift;
	}
}