import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class contains JUnit tests to verify the functionality of the Coffee class.
 * It ensures that Coffee beverage objects are created and behave as expected,
 * including calculating prices, generating string representations, and checking equality.
 */

public class CoffeeTestStudent {

    // Test objects
    Coffee coffeeRegularSmall, coffeeExtraShotMedium, coffeeExtraSyrupLarge;

    @Before
    public void setUp() throws Exception {
        // Initialize test objects before each test
        coffeeRegularSmall = new Coffee("Regular Coffee", Size.SMALL, false, false);
        coffeeExtraShotMedium = new Coffee("Extra Shot Coffee", Size.MEDIUM, true, false);
        coffeeExtraSyrupLarge = new Coffee("Extra Syrup Coffee", Size.LARGE, false, true);
    }

    @After
    public void tearDown() throws Exception {
        // Clean up test objects after each test
        coffeeRegularSmall = coffeeExtraShotMedium = coffeeExtraSyrupLarge = null;
    }

    @Test
    public void testGetExtraShot() {
        // Test the getExtraShot method
        assertTrue(coffeeExtraShotMedium.getExtraShot());
        assertFalse(coffeeRegularSmall.getExtraShot());
    }

    @Test
    public void testGetExtraSyrup() {
        // Test the getExtraSyrup method
        assertTrue(coffeeExtraSyrupLarge.getExtraSyrup());
        assertFalse(coffeeRegularSmall.getExtraSyrup());
    }

    @Test
    public void testCalcPrice() {
        // Test the calcPrice method
        assertEquals(2.0, coffeeRegularSmall.calcPrice(), 0.01);
        assertEquals(3.5, coffeeExtraShotMedium.calcPrice(), 0.01);
        assertEquals(4.5, coffeeExtraSyrupLarge.calcPrice(), 0.01);
    }

    @Test
    public void testToString() {
        // Test the toString method
        assertEquals("Regular Coffee,SMALL,false,false,2.0", coffeeRegularSmall.toString());
        assertEquals("Extra Shot Coffee,MEDIUM,true,false,3.5", coffeeExtraShotMedium.toString());
        assertEquals("Extra Syrup Coffee,LARGE,false,true,4.5", coffeeExtraSyrupLarge.toString());
    }

    @Test
    public void testEquals() {
        // Test the equals method
        Coffee anotherExtraSyrupLarge = new Coffee("Extra Syrup Coffee", Size.LARGE, false, true);
        assertTrue(coffeeExtraSyrupLarge.equals(anotherExtraSyrupLarge));
        assertFalse(coffeeRegularSmall.equals(coffeeExtraSyrupLarge));
    }
}
