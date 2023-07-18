import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class represents student test cases for a Property object.
 *
 * Author: Mariia Honcharenko
 * Date: 07/17/2023
 */
class PropertyTestStudent {
    private Property property;

    @BeforeEach
    void setUp() throws Exception {
        property = new Property("My Property", "City A", 2000.00, "John Doe");
    }

    @AfterEach
    void tearDown() throws Exception {
        property = null;
    }

    @Test
    void testGetPropertyName() {
        assertEquals("My Property", property.getPropertyName());
    }

    @Test
    void testGetRentAmount() {
        assertEquals(2000.00, property.getRentAmount());
    }

    @Test
    void testGetPlot() {
        assertEquals(0, property.getPlot().getX());
        assertEquals(0, property.getPlot().getY());
        assertEquals(1, property.getPlot().getWidth());
        assertEquals(1, property.getPlot().getDepth());
    }

    @Test
    void testToString() {
        String expectedString = "My Property,City A,John Doe,2000.0";
        assertEquals(expectedString, property.toString());
    }
}
