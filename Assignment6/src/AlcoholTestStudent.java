import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class contains JUnit tests to verify the functionality of the Alcohol class.
 * It ensures that Alcohol beverage objects are created and behave as expected,
 * including calculating prices, generating string representations, and checking equality.
 */
public class AlcoholTestStudent {

    // Test objects
    Alcohol alcoholRegularWeekend, alcoholLargeWeekday;

    @Before
    public void setUp() throws Exception {
        // Initialize test objects before each test
        alcoholRegularWeekend = new Alcohol("Regular Alcohol", Size.SMALL, true);
        alcoholLargeWeekday = new Alcohol("Large Alcohol", Size.LARGE, false);
    }

    @After
    public void tearDown() throws Exception {
        // Clean up test objects after each test
        alcoholRegularWeekend = alcoholLargeWeekday = null;
    }

    @Test
    public void testIsWeekend() {
        // Test the isWeekend method
        assertTrue(alcoholRegularWeekend.isWeekend());
        assertFalse(alcoholLargeWeekday.isWeekend());
    }

    @Test
    public void testCalcPrice() {
        // Test the calcPrice method
        assertEquals(2.6, alcoholRegularWeekend.calcPrice(), 0.01);
        assertEquals(4.0, alcoholLargeWeekday.calcPrice(), 0.01);
    }

    @Test
    public void testToString() {
        // Test the toString method
        assertEquals("Regular Alcohol,SMALL,true,2.60", alcoholRegularWeekend.toString());
        assertEquals("Large Alcohol,LARGE,false,4.00", alcoholLargeWeekday.toString());
    }

    @Test
    public void testEquals() {
        // Test the equals method
        Alcohol anotherRegularWeekend = new Alcohol("Regular Alcohol", Size.SMALL, true);
        assertTrue(alcoholRegularWeekend.equals(anotherRegularWeekend));
        assertFalse(alcoholRegularWeekend.equals(alcoholLargeWeekday));
    }
}
