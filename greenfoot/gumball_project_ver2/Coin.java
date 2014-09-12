import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin here.
 * 
 * @author (Qi Cao) 
 * @version (09-09-2014)
 */
public class Coin extends Actor
{
    //init
    boolean isReal = true;        //real coin or fake
    int coinValue = 0;            //coin value to know is penny or quarter
    
    public int getValue(){
        return coinValue;
    }
    
    public boolean isReal(){
        return isReal;
    }

    public void act() 
    {
        int mouseX, mouseY ;
        
        //Greenfoot API mouseDragged to moving coin
        
        if(Greenfoot.mouseDragged(this)) {          
            MouseInfo mouse = Greenfoot.getMouseInfo();  
            mouseX=mouse.getX();  
            mouseY=mouse.getY();  
            setLocation(mouseX, mouseY);  
        } 
    }    
}
