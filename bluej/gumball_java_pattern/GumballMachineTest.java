
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GumballMachineTest.
 *
 * @author  (Qi)
 * @version (09-21-2014)
 */
public class GumballMachineTest
{
    private GumballMachine gm1;

    /**
     * Default constructor for test class GumballMachineTest
     */
    public GumballMachineTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        gm1 = new GumballMachine(5);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }



    @Test
    public void testNoCoinCrank()    //test if no coin in the machine and turn crank
    {                       
        System.out.println("\n------Test No Coin to crank ---------");
        gm1.turnCrank();
        assertEquals(false, gm1.isGumballInSlot());
        gm1.takeGumballFromSlot();
    }
    

    @Test
    public void testNoEnoughCoinCrank()   //test if have coin but not enough, 50 cents in the machine and turn crank
    {
        System.out.println("\n------Test No Enough Coin to crank ---------");
        gm1.insertDime();
        gm1.insertNickel();
        gm1.insertQuarter();
        gm1.turnCrank();
        assertEquals(false, gm1.isGumballInSlot());
        gm1.takeGumballFromSlot();
    }
    
    
    @Test
    public void testEnoughCoinCrank()    //test if have enough coin, 50 cents in the machine and turn crank
    {
        System.out.println("\n------Test have Enough Coin to crank ---------");
        gm1.insertQuarter();
        gm1.insertNickel();
        gm1.insertDime();
        gm1.insertQuarter();
        gm1.turnCrank();
        assertEquals(true, gm1.isGumballInSlot());
        gm1.takeGumballFromSlot();
        assertEquals(false, gm1.isGumballInSlot());
    }
    
    
    @Test
    public void testEnoughCoinsForTwoCrank()   //test have more than 50 cents to crank,                   
    {                                           //and have other enough 50 cents to crank again
        System.out.println("\n------Test have Enough Coin for two gumball and crank ---------");
        gm1.insertQuarter();
        gm1.insertNickel();
        gm1.insertQuarter();
        gm1.turnCrank();
        assertEquals(true, gm1.isGumballInSlot());
        gm1.insertQuarter();
        gm1.insertQuarter();
        gm1.insertDime();
        gm1.turnCrank();
        gm1.takeGumballFromSlot();
        assertEquals(false, gm1.isGumballInSlot());
        
    }
    

    @Test
    public void testNoEnoughCoinsForTwoCrank()   //test have more than 50 cents to crank,
    {                                            // but have not other enough 50 cents to crank again
        System.out.println("\n------Test have not Enough Coin for two gumball and crank ---------");
        gm1.insertQuarter();
        gm1.insertNickel();
        gm1.insertQuarter();
        gm1.insertNickel();
        gm1.turnCrank();
        assertEquals(true, gm1.isGumballInSlot());
        gm1.turnCrank();
        gm1.takeGumballFromSlot();
        assertEquals(false, gm1.isGumballInSlot());
    }

    
    @Test
    public void testEjectAllCoins()            //test inset coins and eject all coins
    {
        System.out.println("\n------Test insert Coin and eject all coins ---------");
        gm1.insertQuarter();                
        gm1.insertNickel();
        gm1.insertDime();
        gm1.insertQuarter();
        gm1.ejectCoin();
        assertEquals(false, gm1.isGumballInSlot());
        gm1.takeGumballFromSlot();
    }
    

    @Test
    public void testEjectCoinsAfterTakeGumball()   //test eject left coins after take gumball
    {
        System.out.println("\n------Test insert Coin and eject left coin after take gumball ---------");
        gm1.insertNickel();
        gm1.insertQuarter();
        gm1.insertDime();
        gm1.insertQuarter();
        gm1.insertNickel();
        gm1.insertQuarter();
        gm1.turnCrank();
        assertEquals(true, gm1.isGumballInSlot());
        gm1.takeGumballFromSlot();
        assertEquals(false, gm1.isGumballInSlot());
        gm1.ejectCoin();
    }
}









