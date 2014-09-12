import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * class GumballMachine
 * 
 * @author (Qi Cao) 
 * @version (09-09-2014)
 * 
 */

public class GumballMachine extends Actor
{
    //init
    Message m = new Message();
    Coin haveCoin = null;
    
    public GumballMachine()
    {
        GreenfootImage image = getImage() ;
        image.scale( 350, 400 ) ; 
    }

    public void act() 
    {      
        Actor coin =getOneObjectAtOffset(+10,+10, Coin.class);
        if( coin != null){                  //if there is coin
            if (haveCoin != null){
                coin.move ( -300);
            } else{
                haveCoin = (Coin) coin;
                setMessage( "Have Coin! Click to Crank!");
                insertCoin(coin);  //insert the coin, make the coin dispear   
            }
            
        }
                
        if(Greenfoot.mousePressed(this)) {     //if mouse pressed

            if ( haveCoin == null){
                setMessage("No Coin in Slot!");
            } else{
                setMessage("Crank Turned!");   //if there is coin, Crank turned
                Greenfoot.delay(100); 
  
                moveInspector(533-80,291-40);   // select Inspector to inspect the coin
                setMessage("Check Coin!");
                
                Greenfoot.delay(100);           
                checkCoin(haveCoin);            // inspector check the coin

            }           
        }       
    } 
    
    public void setMessage(String msg){
         int mouseX, mouseY ;
         MouseInfo mouse = Greenfoot.getMouseInfo();  
         mouseX=mouse.getX();  
         mouseY=mouse.getY();  
         World world = getWorld();
         if( m.getWorld() !=null){
             world.removeObject( m );
         }
         world.addObject(m, mouseX, mouseY);
         m.setText( msg);    
    }
    
    private void insertCoin(Actor coin){        
        World world = getWorld();
        world.removeObject( coin );          // the coin dispear  
    }
    
    public void moveInspector(int x, int y){
         Inspector inspector;         
         inspector = (Inspector)this.getOneIntersectingObject( Inspector.class );
         inspector.moveTo(x,y);              //inspector move to gumball machine           
    }
    
    public void checkCoin( Coin coin){
        moveInspector(533,291);              // inspector move back 

        if(coin.isReal()){                   //real coin
            if(coin.getValue() == 25){  
                //check coin value is 25, then continue 
                setMessage("Real Quarter, please wait!");
                selectPicker();              //Random select a picker                   
              
            }else if(coin.getValue() == 1){      //value is 1, it is penny     
                
                setMessage("Sorry, no enough coin!");   
            }     
        }else{                                  //fake quarter
            
          setMessage("Sorry, the coin is Fake!");   
        }       
        
    }
    
    public void selectPicker(){
         int pickerN =Greenfoot.getRandomNumber(2);    //get Random number to select the picker
         World world = getWorld();
         if (pickerN == 1){          //Green Picker
             List<Picker> pickers = world.getObjects(GreenPicker.class );  
             Picker picker =pickers.remove(0);
             Greenfoot.delay(100);   
             setMessage("Green Picker");
             picker.moveTo( 669 -200, 456-60);      //picker move gumball machine
             Greenfoot.delay(100);  
             picker.pickBall();                     //pick green ball
             Greenfoot.delay(100);
             picker.moveTo( 669 , 456 );            //picker move back
                    
         }else{                      //Random Picker
            List<Picker> pickers = world.getObjects(RandomPicker.class );  
            Picker picker =pickers.remove(0);            
            Greenfoot.delay(100);   
            setMessage("Random Picker");
            picker.moveTo( 655 -200, 94 +60);      //picker move gumball machine
            Greenfoot.delay(100);  
            picker.pickBall();    
            Greenfoot.delay(100);                  //pick random ball
            picker.moveTo( 655, 94);               //picker move back
            
         }
        
    }
    
}
