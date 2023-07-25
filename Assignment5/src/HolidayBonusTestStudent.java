/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: This code represents test cases for the HolidayBonus class.
 * Due: 07/24/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Mariia Honcharenko
*/

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * This class represents test cases for the HolidayBonus class.
 * It contains test methods for each public method in HolidayBonus class.
 * 
 * @author Your Name
 * @version Date
 * 
 */
public class HolidayBonusTestStudent {

    private double[][] dataSet1 = {{1, 2, 3}, {4, 5}, {6, 7, 8}};
    private double[][] dataSet2 = {{10, 20, 30}, {40, 50, 60}, {70, 80}, {90}};

    @Before
    public void setUp() throws Exception {
    }

    /**
     * Test for calculateHolidayBonus method.
     * It verifies that the holiday bonuses are calculated correctly for different data sets.
     */
    @Test
    public void testCalculateHolidayBonus() {
        // Test with dataSet1
        double[] result1 = HolidayBonus.calculateHolidayBonus(dataSet1);
        assertEquals(3000.0, result1[0], 0.001);
        assertEquals(4000.0, result1[1], 0.001);
        assertEquals(15000.0, result1[2], 0.001);

        // Test with dataSet2
        double[] result2 = HolidayBonus.calculateHolidayBonus(dataSet2);
        assertEquals(3000.0, result2[0], 0.001);
        assertEquals(9000.0, result2[1], 0.001);
        assertEquals(7000.0, result2[2], 0.001);
        assertEquals(5000.0, result2[3], 0.001);
    }

    /**
     * Test for calculateTotalHolidayBonus method.
     * It verifies that the total holiday bonus is calculated correctly for different data sets.
     */
    @Test
    public void testCalculateTotalHolidayBonus() {
        // Test with dataSet1
        double total1 = HolidayBonus.calculateTotalHolidayBonus(dataSet1);
        assertEquals(22000.0, total1, 0.001);

        // Test with dataSet2
        double total2 = HolidayBonus.calculateTotalHolidayBonus(dataSet2);
        assertEquals(24000.0, total2, 0.001);
    }
}
