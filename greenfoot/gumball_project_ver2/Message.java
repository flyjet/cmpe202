import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Message here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Message extends Actor
{
    GreenfootImage gi;
    
    public Message(){
        gi = new GreenfootImage(260,50);
        setImage(gi);
        
    }
    
    public void setText(String msg){
        gi.clear();
        gi.setColor( java.awt.Color.YELLOW);     // message background color
        gi.fill();
        gi.setColor( java.awt.Color.BLACK);      // message text color
        gi.drawString(msg,0,25);
    }
    
    public void act() 
    {
        if(Greenfoot.mousePressed(this)){
            World world = getWorld();
            world.removeObject(this);           //remove from the world
        }
             
    }    
}
