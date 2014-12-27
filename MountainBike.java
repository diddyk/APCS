// David Kong		10/28/11
// MountainBike.java

//sublcass of bicycle

public class MountainBike extends Bicycle 
{
    // the MountainBike subclass adds one field
    private int seatHeight;

    // the MountainBike subclass has one constructor
    public MountainBike(int startHeight, int startCadence, int startSpeed, int startGear) 
    {
    	//calling super constructor
        super(startCadence, startSpeed, startGear);
        seatHeight = startHeight;
    }	
	
    // the MountainBike subclass adds one method
    // setter method
    public void setHeight(int newValue) 
    {
        seatHeight = newValue;
    }	
}
