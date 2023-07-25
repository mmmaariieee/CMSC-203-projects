/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: The provided code contains unit tests for the Plot Class.
 * Due: 07/17/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Mariia Honcharenko
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlotTestStudent {
    private Plot plot1, plot2;

    @BeforeEach
    void setUp() throws Exception {
        plot1 = new Plot(1, 1, 5, 5);
        plot2 = new Plot(3, 3, 4, 4);
    }

    @AfterEach
    void tearDown() throws Exception {
        plot1 = plot2 = null;
    }

    /**
     * Tests the overlaps method to check if plot1 overlaps with plot2.
     * Expects the result to be true.
     */
    @Test
    void testOverlaps() {
        assertTrue(plot1.overlaps(plot2));
    }

    /**
     * Tests the overlaps method to check if plot1 overlaps with plot3, which does not overlap.
     * Expects the result to be false.
     */
    @Test
    void testNotOverlaps() {
        Plot plot3 = new Plot(7, 7, 3, 3);
        assertFalse(plot1.overlaps(plot3));
    }

    /**
     * Tests the toString method to check if the string representation of plot2 is correct.
     * Expects the result to be "3,3,4,4".
     */
    @Test
    void testToString() {
        String expectedString = "3,3,4,4";
        assertEquals(expectedString, plot2.toString());
    }
}




