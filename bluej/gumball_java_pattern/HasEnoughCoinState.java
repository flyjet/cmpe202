

import java.util.Random;

public class HasEnoughCoinState implements State {
    GumballMachine gumballMachine;
 
    public HasEnoughCoinState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
  
    public void insertCoin(int coin) {      //insert coin, accept quarter, dime and nickel
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
        
    }
 
    public void ejectCoin() {
        System.out.println("All your coins of value " + gumballMachine.getCoins() + " returned.");
                                        //message show how much returned
        gumballMachine.setCoins(0);    //set coins vaule to 0                               
        gumballMachine.setState(gumballMachine.getNoEnoughCoinState());
                                        //set state to NoEnoughCoinState
    }
 
    public void turnCrank() {
        System.out.println("There total coins of value " + gumballMachine.getCoins() + " in gumball machine");
        System.out.println("You turned...");
        gumballMachine.setState(gumballMachine.getSoldState());
    }

    public void dispense() {
        System.out.println("No gumball dispensed");
    }
 
    public String toString() {
        return "waiting for turn of crank";
    }
}
