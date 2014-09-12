import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GreenPicker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GreenPicker extends Picker
{
    /**
     * Act - do whatever the GreenPicker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void pickBall(){      //only pick green ball
        World world = getWorld();
        Gumball gb = new GreenGumball();
        world.addObject(gb, 500, 500 );
        
        String color = gb.getClass().getName();
        Greenfoot.delay(100);  
        setMessage("Green picker only select " +color);

    }
        
    public void act() 
    {
        // World world = getWorld();
         //world.removeObject(this);      //remove from the world
    }  
       
}
