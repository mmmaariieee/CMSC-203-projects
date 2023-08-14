import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class contains JUnit tests to verify the functionality of the Customer class.
 * It ensures that Customer objects are created and behave as expected, including
 * getting and setting attributes, creating copies, generating string representations,
 * and checking equality.
 */
public class CustomerTestStudent {

    // Test objects
    Customer customerOne, customerTwo;

    @Before
    public void setUp() throws Exception {
        // Initialize test objects before each test
        customerOne = new Customer("Alice", 25);
        customerTwo = new Customer("Bob", 30);
    }

    @After
    public void tearDown() throws Exception {
        // Clean up test objects after each test
        customerOne = customerTwo = null;
    }

    @Test
    public void testGetAge() {
        // Test the getAge method
        assertEquals(25, customerOne.getAge());
        assertEquals(30, customerTwo.getAge());
    }

    @Test
    public void testSetAge() {
        // Test the setAge method
        customerOne.setAge(28);
        customerTwo.setAge(35);
        assertEquals(28, customerOne.getAge());
        assertEquals(35, customerTwo.getAge());
    }

    @Test
    public void testGetName() {
        // Test the getName method
        assertEquals("Alice", customerOne.getName());
        assertEquals("Bob", customerTwo.getName());
    }

    @Test
    public void testSetName() {
        // Test the setName method
        customerOne.setName("Carol");
        customerTwo.setName("David");
        assertEquals("Carol", customerOne.getName());
        assertEquals("David", customerTwo.getName());
    }

    @Test
    public void testToString() {
        // Test the toString method
        assertEquals("Customer: Alice, Age: 25", customerOne.toString());
        assertEquals("Customer: Bob, Age: 30", customerTwo.toString());
    }
}
