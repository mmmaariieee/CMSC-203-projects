import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class represents student test cases for a Plot object.
 *
 * Author: [Your Name]
 * Date: [Current Date]
 */
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

    @Test
    void testOverlaps() {
        assertTrue(plot1.overlaps(plot2));
    }

    @Test
    void testNotOverlaps() {
        Plot plot3 = new Plot(7, 7, 3, 3);
        assertFalse(plot1.overlaps(plot3));
    }


    @Test
    void testToString() {
        String expectedString = "3,3,4,4";
        assertEquals(expectedString, plot2.toString());
    }

}
