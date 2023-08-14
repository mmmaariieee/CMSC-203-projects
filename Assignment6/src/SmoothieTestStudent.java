import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class contains JUnit tests to verify the functionality of the Smoothie class.
 * It ensures that Smoothie beverage objects are created and behave as expected,
 * including calculating prices, generating string representations, and checking equality.
 */
public class SmoothieTestStudent {

    // Test objects
    Smoothie smoothieBasicSmall, smoothieProteinMedium, smoothieFruitLarge;

    @Before
    public void setUp() throws Exception {
        // Initialize test objects before each test
        smoothieBasicSmall = new Smoothie("Basic Smoothie", Size.SMALL, 2, false);
        smoothieProteinMedium = new Smoothie("Protein Smoothie", Size.MEDIUM, 3, true);
        smoothieFruitLarge = new Smoothie("Fruit Smoothie", Size.LARGE, 4, false);
    }

    @After
    public void tearDown() throws Exception {
        // Clean up test objects after each test
        smoothieBasicSmall = smoothieProteinMedium = smoothieFruitLarge = null;
    }

    @Test
    public void testGetNumOfFruits() {
        // Test the getNumOfFruits method
        assertEquals(2, smoothieBasicSmall.getNumOfFruits());
        assertEquals(3, smoothieProteinMedium.getNumOfFruits());
    }

    @Test
    public void testGetAddProtein() {
        // Test the getAddProtein method
        assertTrue(smoothieProteinMedium.getAddProtein());
        assertFalse(smoothieBasicSmall.getAddProtein());
    }

    @Test
    public void testCalcPrice() {
        // Test the calcPrice method
        // Price = base price + size cost + fruit cost
        assertEquals(3.0, smoothieBasicSmall.calcPrice(), 0.01);
        assertEquals(6.0, smoothieProteinMedium.calcPrice(), 0.01);
        assertEquals(6.0, smoothieFruitLarge.calcPrice(), 0.01);
    }

    @Test
    public void testToString() {
        // Test the toString method
        // Format: name, size, addProtein, numOfFruits, price
        assertEquals("Basic Smoothie,SMALL,false,2,3.0", smoothieBasicSmall.toString());
        assertEquals("Protein Smoothie,MEDIUM,true,3,6.0", smoothieProteinMedium.toString());
        assertEquals("Fruit Smoothie,LARGE,false,4,6.0", smoothieFruitLarge.toString());
    }

    @Test
    public void testEquals() {
        // Test the equals method
        // Two smoothies with same details should be considered equal
        Smoothie anotherFruitLarge = new Smoothie("Fruit Smoothie", Size.LARGE, 4, false);
        assertTrue(smoothieFruitLarge.equals(anotherFruitLarge));
        assertFalse(smoothieProteinMedium.equals(smoothieFruitLarge));
    }
}
