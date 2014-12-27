import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import java.awt.Color;

public class RPSRunner
{
    public static void main(String[] args)
    {
	    BoundedGrid<Actor> mygrid = new BoundedGrid<Actor>(10,10);
        ActorWorld world = new ActorWorld(mygrid);
		world.add(new Location(1,0), new Rok());
		world.add(new Location(1,1), new Paper());
		world.add(new Location(1,2), new Scissors());
		
		world.show();
    }
}