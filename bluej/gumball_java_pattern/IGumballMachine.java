
/**
 * Write a description of interface IGumballMachine here.
 * 
 * @author (Qi) 
 * @version (09-21-2014)
 */
public interface IGumballMachine
{
  
     void insertQuarter();
     void insertDime();
     void insertNickel();
     void turnCrank();
     boolean isGumballInSlot();
     void takeGumballFromSlot();

}
