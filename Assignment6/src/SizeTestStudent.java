import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This class contains JUnit tests to verify the functionality of the Size enum.
 * It ensures that Size enum values are correctly represented as strings.
 */
public class SizeTestStudent {

    @Test
    public void testSizeEnumValues() {
        // Test if the Size enum values are correctly represented as strings
        Size small = Size.SMALL;
        Size medium = Size.MEDIUM;
        Size large = Size.LARGE;

        // Check if the toString() method returns the expected enum value as a string
        assertEquals("SMALL", small.toString());
        assertEquals("MEDIUM", medium.toString());
        assertEquals("LARGE", large.toString());
    }

    // Add more test cases to cover different sizes if needed
}
