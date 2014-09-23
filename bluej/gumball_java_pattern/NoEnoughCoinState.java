

public class NoEnoughCoinState implements State {
    GumballMachine gumballMachine;
 
    public NoEnoughCoinState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
 
    public void insertCoin(int coin) {   //insert coin, accept quarter, dime and nickel
        if(coin == 25){
            System.out.println("You insert a quarter.");
            
        } else if(coin == 10){
            System.out.println("You insert a dime.");
            
        } else if (coin == 5) {
            
            System.out.println("You insert a nickel");
        } else{
            
            System.out.println("Sorry, the machine only acceptes quarter, dime or nickel.");
        }
 
        gumballMachine.setCoins( gumballMachine.getCoins() + coin);  
                                        //add the coin value to all previous coins value
        
        if(gumballMachine.getCoins() >= 50){
            gumballMachine.setState (gumballMachine.getHasEnoughCoinState());       
                                        //have more than 50 cents, set state to hasEnoughCoinState
        } else{
             
            System.out.println("Please insert more coin ");
        }
    }
 
    public void ejectCoin() {
       int n = gumballMachine.getCoins();
       if (n > 0){        //have coin in machine
           System.out.println("All your coins of value " + gumballMachine.getCoins() + " returned.");
                                          //message show how much returned ");
           gumballMachine.setCoins(0);    //set coins vaule to 0    
           
        } else{           //no coin in machine
            
           System.out.println("You have not inserted a coin." );
        }
    }

 
    public void turnCrank() {
       int n = gumballMachine.getCoins();
       if (n > 0){        //have coin in machine
            System.out.println("You have coins of value " + gumballMachine.getCoins() + " cents in machine");
            System.out.println("You turned, but there's no enough coins");
       } else{
           
           System.out.println("You turned, but have not inserted a coin." );
       }
    }
 
    public void dispense() {
       int n = gumballMachine.getCoins();
       if (n > 0){        //have coin in machine
            System.out.println("You have coins of value " + gumballMachine.getCoins() + "in machine");
            System.out.println("But there's no enough coins");
       } else{
           
            System.out.println("You need to pay first");
       }
        
    } 
 
    public String toString() {
        return "waiting for enough coins";
    }

}
