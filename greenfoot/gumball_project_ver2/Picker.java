import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Picker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Picker extends Alien
{
    /**
     * Act - do whatever the Picker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    abstract void pickBall();
    
    public void moveTo(int x, int y){
        setLocation( x, y);
    }
    
    public void act() 
    {
        // Add your action code here.
    }   
    
   public void setMessage(String msg){
         Message m = new Message();
         int mouseX, mouseY ;
         MouseInfo mouse = Greenfoot.getMouseInfo();  
         mouseX=mouse.getX();  
         mouseY=mouse.getY();  
         World world = getWorld();
         world.addObject(m, mouseX, mouseY);
         m.setText( msg);    
    }
}
