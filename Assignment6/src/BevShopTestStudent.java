import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The `BevShopTestStudent` class serves as a JUnit test suite to thoroughly test the functionality
 * of the `BevShop` class, which represents a beverage shop implementing the `BevShopInterface`.
 * This test suite covers a range of scenarios for validating the behavior of the `BevShop` methods
 * and ensuring that they comply with the specified business rules.
 */
public class BevShopTestStudent {
    private BevShop bevShop;

    @Before
    public void setUp() {
        bevShop = new BevShop();
    }

    @Test
    public void testIsValidTime_ValidTime() {
        assertTrue(bevShop.isValidTime(10)); // Valid time within the range
    }

    @Test
    public void testIsValidTime_InvalidTimeBeforeOpening() {
        assertFalse(bevShop.isValidTime(7)); // Invalid time before opening
    }

    @Test
    public void testIsValidTime_InvalidTimeAfterClosing() {
        assertFalse(bevShop.isValidTime(24)); // Invalid time after closing
    }

    @Test
    public void testMaxNumOfFruits() {
        assertEquals(BevShop.MAX_FRUIT, bevShop.getMaxNumOfFruits()); // Verify max number of fruits
    }

    @Test
    public void testMinAgeForAlcohol() {
        assertEquals(BevShop.MIN_AGE_FOR_ALCOHOL, bevShop.getMinAgeForAlcohol()); // Verify min age for alcohol
    }

    @Test
    public void testIsMaxFruit_ExceedsMaxFruits() {
        assertTrue(bevShop.isMaxFruit(BevShop.MAX_FRUIT + 1)); // Exceeds maximum allowed fruits
    }

    @Test
    public void testIsMaxFruit_NotExceedsMaxFruits() {
        assertFalse(bevShop.isMaxFruit(BevShop.MAX_FRUIT)); // Does not exceed maximum allowed fruits
    }

    @Test
    public void testGetMaxOrderForAlcohol() {
        assertEquals(BevShop.MAX_ORDER_FOR_ALCOHOL, bevShop.getMaxOrderForAlcohol()); // Verify max alcohol orders
    }

    @Test
    public void testIsEligibleForMore_LessThanMaxOrders() {
        assertTrue(bevShop.isEligibleForMore()); // Eligible for more orders since less than max
    }

    @Test
    public void testTotalMonthlySale() {
        // Create orders and add them to the bevShop
        bevShop.startNewOrder(10, Day.MONDAY, "Alice", 25);
        bevShop.processCoffeeOrder("Latte", Size.MEDIUM, false, true);
        bevShop.processAlcoholOrder("Wine", Size.SMALL);
        bevShop.startNewOrder(15, Day.TUESDAY, "Bob", 30);
        bevShop.processSmoothieOrder("Berry Blast", Size.LARGE, 3, true);

        assertEquals(12.5, bevShop.totalMonthlySale(), 0.001); // Verify total monthly sale
    }

    @Test
    public void testSortOrders() {
        // Create orders and add them to the bevShop in unsorted order
        bevShop.startNewOrder(10, Day.MONDAY, "Alice", 25);
        bevShop.processCoffeeOrder("Latte", Size.MEDIUM, false, true);
        bevShop.startNewOrder(15, Day.TUESDAY, "Bob", 30);
        bevShop.processAlcoholOrder("Wine", Size.SMALL);

        bevShop.sortOrders(); // Sort the orders

        // Verify that orders are sorted based on total order amounts
        double firstOrderTotal = bevShop.getOrderAtIndex(0).calcOrderTotal();
        double secondOrderTotal = bevShop.getOrderAtIndex(1).calcOrderTotal();
        assertTrue(firstOrderTotal <= secondOrderTotal);
    }

}
