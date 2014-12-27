// David Kong		11/4/11
// Farm.java
// This class groups together the classes of animals,
// then prints out the type and sound when animalSounds
// is called from OldMacDonald.java

public class Farm
{
	private Animal [] myFarm;

   	public Farm()
   	{
    	myFarm = new Animal [4];
		myFarm[0] = new Cow();
	 	myFarm[1] = new Chick();
		myFarm[2] = new Pig();
		myFarm[3] = new NamedCow("Elsie");
    }

	public void animalSounds()
    {
    	Animal temp;
        for(int i = 0; i < myFarm.length; i++)
        {
        	temp = myFarm[i];
         	System.out.println(temp.getType() + " goes " + temp.getSound());
      	}

      	Chick tweety = new Chick(true);
      	for(int i = 0; i < 5; i++)
      	{
        	System.out.println(tweety.getSound());
      	}

      	NamedCow named = (NamedCow)myFarm[3];
     	System.out.println(named.getName());
     }
}