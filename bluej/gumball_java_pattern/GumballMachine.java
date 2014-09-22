

public class GumballMachine implements IGumballMachine {
 
    State soldOutState;
    State noEnoughCoinState;
    State hasEnoughCoinState;
    State soldState;
 
    State state = soldOutState;          
    int count = 0;
    int gumballInSlot = 0;   
    int coins = 0;
 
    public GumballMachine(int numberGumballs) {
        soldOutState = new SoldOutState(this);
        noEnoughCoinState = new NoEnoughCoinState(this);
        hasEnoughCoinState = new HasEnoughCoinState(this);
        soldState = new SoldState(this);

        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = noEnoughCoinState;          //init state with noEnoughCoi   nState
        } 
    }
    
    public void insertQuarter() {
        state.insertCoin(25);                  // quarter value 25
    }
    

    public void insertDime() {
        state.insertCoin(10);                    // dime value 10
    }

    
    public void insertNickel( ) {
        state.insertCoin(5);                    // Nickel value 5
    }
    
    
    public void ejectCoin() {
        state.ejectCoin();                     //ejectCoin
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    void setState(State state) {
        this.state = state;
    }
 
    void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) {
            count = count - 1;
            gumballInSlot = gumballInSlot +1;          //add 1 gumball in slot
            coins = coins - 50;                        //reduce 50 from coin value
        }
        
        System.out.println("You have " +getGumballInSlot() + " gumball in the slot");
        System.out.println("And " +getCoins() + " cents left in the gumball machine");
    }
 
    int getCount() {
        return count;
    }
 
    public int getCoins() {                
        return coins;               //get coins value
    }
    
    public void setCoins(int coin) {                
        coins = coin;               //set coins value
    }
    
    public int getGumballInSlot() {
        return gumballInSlot;       //get gumball in slot number
    }
    
    void refill(int count) {
        this.count = count;
        state = noEnoughCoinState;
    }

    public State getState() {
        return state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoEnoughCoinState() {       
        return noEnoughCoinState;               //get state of noEnoughCoin
    }

    public State getHasEnoughCoinState() {
        return hasEnoughCoinState;              //get state of hasEnoughCoin
    }

    public State getSoldState() {
        return soldState;
    }
 
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\nMighty Gumball, Inc.");
        result.append("\nJava-enabled Standing Gumball Model #2004");
        result.append("\nInventory: " + count + " gumball");
        if (count != 1) {
            result.append("s");
        }
        result.append("\n");
        result.append("Machine is " + state + "\n");
        return result.toString();
    }
    
    public  boolean isGumballInSlot( ) {        //check gumball in slot or not
        if(gumballInSlot > 0){
             System.out.println("Have gumball in slot.");
             return true;            
        } else{
             System.out.println("No gumball in slot.");
             return false;
        }               
    }
    
    public void takeGumballFromSlot( ) {        // take gumball from slot
        if(isGumballInSlot()){   
            System.out.println("You can take all "  + getGumballInSlot() + " gumball in the slot");
            gumballInSlot = 0;
            
        }else{
            System.out.println("Sorry, there is no gumball in slot");
        }
        
    }
        
}
