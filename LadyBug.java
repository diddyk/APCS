// David Kong       3/13/12
// LadyBug.java
// Creates a LadyBug
// Precedence of eating:
//  a) one space away AphidEgg
//  b) two space away AphidEgg (jumps)
//  c) one space away Aphid
//  d) two space away AphidEgg (jumps)
//  If nothing within 2 radius, search for nearest Aphid/AphidEgg
//  It will move 2 spaces at a time to eat it.
//  Once there are no more Aphid/AphidEggs, LadyBug stops moving. (Retain Direction/Orientation)

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;

public class LadyBug extends Critter
{
    private int choice;
    
    //constructor
    public LadyBug ()
    {
        choice = -1;
        setColor(Color.RED);
    }
    
    //gets move locations for both objects within a 1 and 2 radius.
    public ArrayList<Location> getMoveLocations()
    {
        //arraylist to store location values for 1 radius and 2 radius Aphid and AphidEgg
        ArrayList <Location> AphidEggs1 = new ArrayList <Location> ();
        ArrayList <Location> AphidEggs2 = new ArrayList <Location> ();
        ArrayList <Location> Aphids1 = new ArrayList <Location> ();
        ArrayList <Location> Aphids2 = new ArrayList <Location> ();
        
        //pass in each array and an int for 1 radius and 2 radius methods.
        AphidEggs1 = getWithinOneRadius(0);
        AphidEggs2 = getWithinTwoRadius(0);
        Aphids1 = getWithinOneRadius(1);
        Aphids2 = getWithinTwoRadius(1);
        
        //determine move based on precedence listed in requirements
        if (AphidEggs1.size() != 0)
            return AphidEggs1;
        else if (AphidEggs2.size() != 0)
            return AphidEggs2;
        else if (Aphids1.size() != 0)
            return Aphids1;
        else if (Aphids2.size() != 0)
            return Aphids2;           
        
        //returns appropriate move
        return nearestLoc();   
    }
    
    //returns Aphid/AphidEggs within a 1 radius
    public ArrayList<Location> getWithinOneRadius(int choice)
    {
        ArrayList <Location> loc = new ArrayList <Location> ();
        ArrayList<Actor> actors = getGrid().getNeighbors(getLocation());
        
        for (Actor a : actors)
        {
            //if Aphid or AphidEgg
            if (choice == 0)
            {
                if (a instanceof AphidEgg)
                    loc.add(a.getLocation());
            }
            else if (choice == 1)
            {
                if (a instanceof Aphid)
                    loc.add(a.getLocation());
            }

        }
        
        return loc;
    }

    //searches for closest direction
    public ArrayList<Location> nearestLoc()
    {
        ArrayList<Location> locations = getGrid().getOccupiedLocations();
        Location temploc = null;
        double min = 9999999.99;
        
        if(locations.size() == ladyBugCount())
        {
            ArrayList<Location> empty = new ArrayList<Location>();
            empty.add(getLocation());
            return empty;
        }
        
        for (int i = 0; i < locations.size(); i++)
        {
            if(distanceCalc(locations.get(i)) < min && (distanceCalc(locations.get(i)) != 0) && !(getGrid().get(locations.get(i)) instanceof LadyBug) && ( (getGrid().get(locations.get(i)) instanceof Aphid) ||(getGrid().get(locations.get(i)) instanceof AphidEgg) ))  
            {
                min = distanceCalc(locations.get(i));
                temploc = locations.get(i);    
            }
        }
        
        //prevents null pointer if not an Aphid or AphidEgg is placed in the grid
        Location loc = getLocation();
        if (loc != null && temploc != null)
        {
            int direction = loc.getDirectionToward(temploc);
            Location OneSteplocation = getLocation().getAdjacentLocation(direction);
            Location TwoSteplocation = OneSteplocation.getAdjacentLocation(direction);
            
            ArrayList<Location> loca  = new ArrayList<Location>();
            loca.add(TwoSteplocation);
            return loca;
        }
        //if no more Aphid/AphidEgg, return nothing
        ArrayList<Location> empty = new ArrayList<Location>();
        return empty;
    }

    //return Aphid/AphidEggs within a 2 radius
    public ArrayList<Location> getWithinTwoRadius(int choice)
    {
        ArrayList <Location> locs = new ArrayList <Location> ();
        ArrayList<Actor> actors = new ArrayList <Actor> ();
        Location loc = getLocation();
        
        for (int r = loc.getRow() - 2; r <= loc.getRow() + 2; r++)
        {
            for(int c = loc.getCol() - 2; c <= loc.getCol() + 2; c++)
            {
                Location tempLoc = new Location(r,c);
                if(getGrid().isValid(tempLoc))
                {
                    Actor a = getGrid().get(tempLoc);
                    if(a != null && a != this)
                        actors.add(a);
                }
            }
        }
        
        for (Actor a : actors)
        {
            //if Aphid or AphidEgg
            if(choice == 1)
            {
                if (a instanceof Aphid)
                    locs.add(a.getLocation());
            }
            else if (choice == 2)
            {
                if (a instanceof AphidEgg)
                    locs.add(a.getLocation());
            }
        }  
        return locs;
    }
    
    
    //gets the distance towards an Aphid/AphidEgg to determine
    //closest distance with distance formula.
    public double distanceCalc(Location loc)
    {
        int row = loc.getRow();
        int col = loc.getCol();
        double beforesquare = Math.pow((double)row - (double)getLocation().getRow(),2) + Math.pow((double)col - (double)getLocation().getCol(),2); 
        double distance = Math.sqrt(beforesquare);
        return distance;
    }

    //checks for number of LadyBugs
    public int ladyBugCount()
    {
        ArrayList<Location> locations = getGrid().getOccupiedLocations();
        int ladycount = 0;
        for(Location l: locations)
        {   
            Actor a = getGrid().get(l);
            if(a instanceof LadyBug)
                ladycount++;
        }
        return ladycount;
    }
    
    //move in that direction, turning to face direction
    public void makeMove(Location loc)
    {
        //prevents LadyBug from eating itself
        if (!(getGrid().get(loc) instanceof LadyBug))
        {
            if (!(getLocation().equals(loc)))
            {
                int direction = getLocation().getDirectionToward(loc);
                setDirection(direction);
                super.makeMove(loc);
            }
        }
    }
}