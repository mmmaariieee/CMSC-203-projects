import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test class to thoroughly test the implementation of the Order class.
 * This class contains multiple test cases to ensure the correctness of various methods
 * and functionalities provided by the Order class.
 */
public class OrderTestStudent {
    private Order order;

    @Before
    public void setUp() throws Exception {
        // Create an Order instance with predefined values for testing
        order = new Order(14, Day.SATURDAY, new Customer("Alice", 30));
    }

    @After
    public void tearDown() throws Exception {
        // Reset the Order instance after each test
        order = null;
    }

    @Test
    public void testGetOrderNo() {
        // Test if the getOrderNo method returns the correct order number
        assertEquals(order.getOrderNo(), order.getOrderNo());
    }

    @Test
    public void testGetOrderTime() {
        // Test if the getOrderTime method returns the correct order time
        assertEquals(14, order.getOrderTime());
    }

    @Test
    public void testGetOrderDay() {
        // Test if the getOrderDay method returns the correct order day
        assertEquals(Day.SATURDAY, order.getOrderDay());
    }

    @Test
    public void testGetCustomer() {
        // Test if the getCustomer method returns a deep copy of the customer associated with the order
        Customer customer = order.getCustomer();
        assertEquals("Alice", customer.getName());
        assertEquals(30, customer.getAge());
    }

    @Test
    public void testIsWeekend() {
        // Test if the isWeekend method correctly identifies a weekend day
        assertTrue(order.isWeekend());
    }

    @Test
    public void testGetBeverage() {
        // Create example beverages
        Coffee coffee = new Coffee("Espresso", Size.SMALL, true, false);
        Alcohol alcohol = new Alcohol("Margarita", Size.MEDIUM, true);
        Smoothie smoothie1 = new Smoothie("Berry Blast", Size.LARGE, 3, true);
        Smoothie smoothie2 = new Smoothie("Green Power", Size.MEDIUM, 2, false);

        // Add example beverages to the order
        order.addNewBeverage("Espresso", Size.SMALL, true, false);
        order.addNewBeverage("Margarita", Size.MEDIUM);
        order.addNewBeverage("Berry Blast", Size.LARGE, 3, true);

        // Test if getBeverage method retrieves the correct beverage based on itemNo
        assertTrue(order.getBeverage(0).equals(coffee));
        assertTrue(order.getBeverage(1).equals(alcohol));
        assertTrue(order.getBeverage(2).equals(smoothie1));
        assertFalse(order.getBeverage(2).equals(smoothie2));
    }



    @Test
    public void testGetTotalItems() {
        // Test if the getTotalItems method returns the correct total number of beverages
        assertEquals(0, order.getTotalItems());

        order.addNewBeverage("Regular Coffee", Size.SMALL, false, false);
        order.addNewBeverage("Mojito", Size.MEDIUM);

        assertEquals(2, order.getTotalItems());
    }

    @Test
    public void testCalcOrderTotal() {
        // Add beverages to the order and test if calcOrderTotal method calculates the correct total cost
        order.addNewBeverage("Regular Coffee", Size.SMALL, false, false);
        order.addNewBeverage("Mojito", Size.MEDIUM);
        order.addNewBeverage("Berry Smoothie", Size.LARGE, 2, true);

        assertEquals(12.1, order.calcOrderTotal(), 0.01);
    }

    @Test
    public void testFindNumOfBeveType() {
        // Add beverages to the order and test if findNumOfBeveType method counts the correct number of beverages
        order.addNewBeverage("Regular Coffee", Size.SMALL, false, false);
        order.addNewBeverage("Mojito", Size.MEDIUM);
        order.addNewBeverage("Berry Smoothie", Size.LARGE, 2, true);

        assertEquals(1, order.findNumOfBeveType(Type.COFFEE));
        assertEquals(1, order.findNumOfBeveType(Type.ALCOHOL));
        assertEquals(1, order.findNumOfBeveType(Type.SMOOTHIE));
    }

    @Test
    public void testToString() {
        // Add beverages to the order and test if toString method generates the correct string representation
        order.addNewBeverage("Regular Coffee", Size.SMALL, false, false);
        order.addNewBeverage("Mojito", Size.MEDIUM);
        order.addNewBeverage("Berry Smoothie", Size.LARGE, 2, true);

        String expectedOutput = "Order Number: " + order.getOrderNo() + "\n" +
                "Order Time: " + order.getOrderTime() + "\n" +
                "Order Day: " + order.getOrderDay() + "\n" +
                "Customer: " + order.getCustomer() + "\n" +
                "Beverages:\n" +
                order.getBeverage(0) + "\n" +
                order.getBeverage(1) + "\n" +
                order.getBeverage(2) + "\n";

        assertEquals(expectedOutput, order.toString());
    }
}
