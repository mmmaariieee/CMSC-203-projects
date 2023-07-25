import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: The provided code contains unit tests for the Property Class.
 * Due: 07/17/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Mariia Honcharenko
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
    	// Test the getter method for property name
        assertEquals("My Property", property.getPropertyName());
    }

    @Test
    void testGetRentAmount() {
    	// Test the getter method for rent amount
        assertEquals(2000.00, property.getRentAmount());
    }

    @Test
    void testGetPlot() {
    	// Test the getter methods for the plot
        assertEquals(0, property.getPlot().getX());
        assertEquals(0, property.getPlot().getY());
        assertEquals(1, property.getPlot().getWidth());
        assertEquals(1, property.getPlot().getDepth());
    }

    @Test
    void testToString() {
    	// Test the toString method
        String expectedString = "My Property,City A,John Doe,2000.0";
        assertEquals(expectedString, property.toString());
    }
}
