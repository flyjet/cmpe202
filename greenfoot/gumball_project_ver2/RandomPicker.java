import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RandomPicker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RandomPicker extends Picker
{
    /**
     * Act - do whatever the RandomPicker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void pickBall(){
        Gumball gb = new Gumball();
        int lottery = Greenfoot.getRandomNumber(3);
        switch(lottery){
            case 0: gb = new BlueGumball(); break;
            case 1: gb = new RedGumball(); break;
            case 2: gb = new GreenGumball(); break;
        }
        
        World world = getWorld();
        world.addObject(gb, 500, 500);
        
        String color = gb.getClass().getName();
        Greenfoot.delay(100);  
        setMessage("Select the random gumball is " +color);
        
    }
       
    public void act() 
    {
        // Add your action code here.             
    }           
}
