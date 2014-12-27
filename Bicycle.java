// David Kong		10/28/11
// Bicycle.java

public class Bicycle 
{
    // the Bicycle class has three fields
    private int cadence;
    private int gear;
    private int speed;
	
    // the Bicycle class has two constructors
    public Bicycle() 
    {
        gear = 0;
        cadence = 1;
        speed = 1;
    }

    public Bicycle(int startCadence, int startSpeed, int startGear) 
    {
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;
    }
	
    // the Bicycle class has four methods
    // accessor methods [getter/setter]
    public void setCadence(int newValue) 
    {
        cadence = newValue;
    }
	
    public void setGear(int newValue) 
    {
        gear = newValue;
    }
	
    public void applyBrake(int decrement) 
    {
        speed -= decrement;
    }
	
    public void speedUp(int increment) 
    {
        speed += increment;
    }

    public void changeCadence(int newValue) 
    {
        cadence = newValue;
    }

    public void changeGear(int newValue) 
    {
         gear = newValue;
    }

    public void applyBrakes(int decrement) 
    {
         speed = speed - decrement;
    }

    public void printStates() 
    {
         System.out.println("cadence:"+cadence+" speed:"+speed+" gear:"+gear);
    }
}