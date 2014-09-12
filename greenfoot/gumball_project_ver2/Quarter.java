import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Quarter here.
 * 
 * @author (Qi Cao) 
 * @version (09-09-2014)
 */
public class Quarter extends Coin
{

    public Quarter()
    {
        GreenfootImage image = getImage() ;
        image.scale( 80, 80 ) ;   
        isReal = true;     
        coinValue = 25;        // set real quarter value is 25
    }
  
}
