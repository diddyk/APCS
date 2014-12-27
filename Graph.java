// David Kong		11/2/11
// Graph.java

public class Graph
{
	private double minx, maxx, miny, maxy;
	private int xaxis, yaxis;
	private final int horizontalfield = 110;
	private final int verticalfield = 55;
	private int [] plotoutput;
	
	public Graph()
	{
		minx = -6.0;
		maxx = 6.0;
		miny = -3.0;
		maxy = 3.0;
		plotoutput = new int [horizontalfield];
	}
	
	public static void main (String [] args)
	{
		Graph run = new Graph(-Math.PI, 2 * Math.PI, -1.2, 1.2);
		run.showGraph();
	}
	
	public void showGraph()
	{
		Sine mysine = new Sine();
		setPlotOutput(mysine);
		printOutput();
	}
	
	public Graph(double mnx, double mxx, double mny, double mxy)
	{
		minx = mnx;
		maxx = mxx;
		miny = mny;
		maxy = mxy;
		plotoutput = new int [horizontalfield];
	}
	
	public void setPlotOutput(Function f)
	{
		yaxis = horizontalfield - (int)(maxx*horizontalfield /(maxx - minx));
		xaxis = verticalfield + (int)(miny*verticalfield/(maxy-miny));
		double xincrement = (maxx - minx)/horizontalfield;
		double yincrement = verticalfield/(maxy - miny);
		for (int i = 0; i < plotoutput.length; i++)
		{
			double value = f.eval(minx + i*xincrement);
			plotoutput[i] = (int)((maxy - value)*yincrement);
		}
	}
	
	public void printOutput ()
	{
		for (int i = 0; i <= verticalfield; i++)
		{
			for (int j = 0; j < horizontalfield; j++)
			{
				if (plotoutput[j] == i)
					System.out.print("*");
				else if (yaxis == j && xaxis == i)
					System.out.print("+");
				else if (yaxis == j)
					System.out.print("|");
				else if (xaxis == i)
					System.out.print("-");
				else
					System.out.print(" ");	
			}
			System.out.println();	
		}
	}
}