// David Kong		11/2/11
// Sine.java

public class Sine extends FunctionShift implements Function 
{
	
	public Sine ()
	{
		super();
	}
	
	public Sine (double a, double b, double c, double d)
	{
		super(a, b, c, d);
	}
	
	public double eval(double x)
	{
		double shiftx = getb() * (x + getc());
		return geta() * Math.sin(shiftx) + getd();
		
	}
}