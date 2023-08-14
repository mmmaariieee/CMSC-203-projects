import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This class contains JUnit tests to verify the functionality of the Type enum.
 * It ensures that Type enum values are correctly represented as strings.
 */
public class TypeTestStudent {

    @Test
    public void testTypeEnumValues() {
        // Test if the Type enum values are correctly represented as strings
        Type coffee = Type.COFFEE;
        Type smoothie = Type.SMOOTHIE;
        Type alcohol = Type.ALCOHOL;

        // Check if the toString() method returns the expected enum value as a string
        assertEquals("COFFEE", coffee.toString());
        assertEquals("SMOOTHIE", smoothie.toString());
        assertEquals("ALCOHOL", alcohol.toString());
    }

    // Add more test cases to cover different types if needed
}
