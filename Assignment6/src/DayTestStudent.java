import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This class contains JUnit tests to verify the functionality of the Day enum.
 * It ensures that Day enum values are correctly represented as strings.
 */
public class DayTestStudent {

    @Test
    public void testDayEnumValues() {
        // Test if the Day enum values are correctly represented as strings
        Day monday = Day.MONDAY;
        Day friday = Day.FRIDAY;
        Day sunday = Day.SUNDAY;

        // Check if the toString() method returns the expected enum value as a string
        assertEquals("MONDAY", monday.toString());
        assertEquals("FRIDAY", friday.toString());
        assertEquals("SUNDAY", sunday.toString());
    }
}
