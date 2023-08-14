/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: This code represents a beverage shop that implements the `BevShopInterface`.
 * Due: 08/07/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Mariia Honcharenko
*/

import java.util.ArrayList;
import java.util.List;

/**
 * The `BevShop` class represents a beverage shop that implements the `BevShopInterface`,
 * providing functionalities for managing orders of various beverages.
 * It tracks the order history, enforces business rules, and calculates statistics.
 */
public class BevShop implements BevShopInterface {
	// Instance variables
    private int numOfAlcoholDrinks; // Number of alcohol drinks ordered for the current order
    private List<Order> orders; // List to keep track of orders

    // Constants from BevShopInterface
    public static final int MAX_FRUIT = 5; // Maximum number of fruits allowed in a smoothie
    public static final int MAX_ORDER_FOR_ALCOHOL = 3; // Maximum number of alcohol orders per customer
    public static final int MIN_TIME = 8; // Minimum time for placing an order
    public static final int MAX_TIME = 23; // Maximum time for placing an order
    public static final int MIN_AGE_FOR_ALCOHOL = 21; // Minimum age for ordering alcohol

    /**
     * Default constructor for initializing a `BevShop` object.
     * Initializes instance variables and sets up the order tracking list.
     */
    public BevShop() {
        numOfAlcoholDrinks = 0;
        orders = new ArrayList<>();
    }

    /**
     * Checks if the provided time is within the valid range for placing an order.
     *
     * @param time The time to be checked.
     * @return `true` if the time is valid, otherwise `false`.
     */
    @Override
    public boolean isValidTime(int time) {
        return time >= MIN_TIME && time <= MAX_TIME;
    }

    /**
     * Gets the maximum number of fruits allowed in a smoothie.
     *
     * @return The maximum number of fruits allowed.
     */
    @Override
    public int getMaxNumOfFruits() {
        return MAX_FRUIT;
    }

    /**
     * Gets the minimum age required for ordering alcohol beverages.
     *
     * @return The minimum age required for ordering alcohol.
     */
    @Override
    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }

    /**
     * Checks if the provided number of fruits exceeds the maximum allowed.
     *
     * @param numOfFruits The number of fruits to check.
     * @return `true` if the number of fruits exceeds the maximum, otherwise `false`.
     */
    @Override
    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits > MAX_FRUIT;
    }

    /**
     * Gets the maximum number of alcohol orders allowed per customer.
     *
     * @return The maximum number of alcohol orders allowed.
     */
    @Override
    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }

    /**
     * Checks if a customer is eligible to order more alcohol beverages.
     *
     * @return `true` if eligible, otherwise `false`.
     */
    @Override
    public boolean isEligibleForMore() {
        return numOfAlcoholDrinks < MAX_ORDER_FOR_ALCOHOL;
    }

    /**
     * Gets the current number of alcohol beverages ordered.
     *
     * @return The number of alcohol beverages ordered.
     */
    @Override
    public int getNumOfAlcoholDrink() {
        return numOfAlcoholDrinks;
    }

    /**
     * Checks if the provided age is valid for ordering alcohol beverages.
     *
     * @param age The age to check.
     * @return `true` if the age is valid, otherwise `false`.
     */
    @Override
    public boolean isValidAge(int age) {
        return age >= MIN_AGE_FOR_ALCOHOL;
    }

    /**
     * Starts a new order by creating a new order object and adding it to the order list.
     *
     * @param time         The order time.
     * @param day          The order day.
     * @param customerName The customer's name.
     * @param customerAge  The customer's age.
     */
    @Override
    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
        Order newOrder = new Order(time, day, new Customer(customerName, customerAge));
        orders.add(newOrder);
    }

    /**
     * Processes a coffee order by adding a new coffee beverage to the current order.
     * Checks if the order time is valid before adding the beverage.
     *
     * @param bevName    The name of the coffee beverage.
     * @param size       The size of the coffee beverage.
     * @param extraShot  Specifies if an extra shot should be added.
     * @param extraSyrup Specifies if extra syrup should be added.
     */
    @Override
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        Order currentOrder = getCurrentOrder();
        if (currentOrder != null) {
            if (isValidTime(currentOrder.getOrderTime())) {
                currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
            } else {
                System.out.println("Cannot add coffee beverage. Invalid order time.");
            }
        } else {
            System.out.println("No current order to add beverage to.");
        }
    }

    /**
     * Processes an alcohol order by adding a new alcohol beverage to the current order.
     * Checks if the order time and customer age are valid before adding the beverage.
     *
     * @param bevName The name of the alcohol beverage.
     * @param size    The size of the alcohol beverage.
     */
    @Override
    public void processAlcoholOrder(String bevName, Size size) {
        Order currentOrder = getCurrentOrder();
        if (currentOrder != null) {
            if (isValidTime(currentOrder.getOrderTime()) && isValidAge(currentOrder.getCustomer().getAge())) {
                currentOrder.addNewBeverage(bevName, size);
                numOfAlcoholDrinks++;
            } else {
                System.out.println("Cannot add alcohol beverage. Invalid order time or customer age.");
            }
        } else {
            System.out.println("No current order to add beverage to.");
        }
    }

    /**
     * Processes a smoothie order by adding a new smoothie beverage to the current order.
     * Checks if the order time is valid and the number of fruits is within limits before adding the beverage.
     *
     * @param bevName    The name of the smoothie beverage.
     * @param size       The size of the smoothie beverage.
     * @param numOfFruits The number of fruits to be added to the smoothie.
     * @param addProtein  Specifies if protein should be added to the smoothie.
     */
    @Override
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        Order currentOrder = getCurrentOrder();
        if (currentOrder != null) {
            if (isValidTime(currentOrder.getOrderTime()) && !isMaxFruit(numOfFruits)) {
                currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
            } else {
                System.out.println("Cannot add smoothie beverage. Invalid order time or exceeding maximum fruits.");
            }
        } else {
            System.out.println("No current order to add beverage to.");
        }
    }

    /**
     * Finds the index of an order in the order list based on the provided order number.
     *
     * @param orderNo The order number to search for.
     * @return The index of the order in the list, or -1 if not found.
     */
    @Override
    public int findOrder(int orderNo) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNo() == orderNo) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Calculates the total price of an order based on the provided order number.
     *
     * @param orderNo The order number.
     * @return The total price of the specified order, or 0.0 if not found.
     */
    @Override
    public double totalOrderPrice(int orderNo) {
        int index = findOrder(orderNo);
        if (index != -1) {
            return orders.get(index).calcOrderTotal();
        }
        return 0.0;
    }

    /**
     * Calculates the total monthly sales amount.
     *
     * @return The total monthly sales amount.
     */
    @Override
    public double totalMonthlySale() {
        double totalSale = 0;
        for (Order order : orders) {
            totalSale += order.calcOrderTotal();
        }
        return totalSale;
    }

    /**
     * Gets the total number of orders in the current month.
     *
     * @return The total number of orders in the current month.
     */
    @Override
    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    /**
     * Gets the most recent order in the order list.
     *
     * @return The most recent order, or null if no orders exist.
     */
    @Override
    public Order getCurrentOrder() {
        if (!orders.isEmpty()) {
            return orders.get(orders.size() - 1);
        }
        return null;
    }

    /**
     * Gets the order at the specified index in the order list.
     *
     * @param index The index of the order to retrieve.
     * @return The order at the specified index, or null if the index is out of bounds.
     */
    @Override
    public Order getOrderAtIndex(int index) {
        if (index >= 0 && index < orders.size()) {
            return orders.get(index);
        }
        return null;
    }

    /**
     * Sorts the order list in ascending order based on the total order amounts.
     */
    @Override
    public void sortOrders() {
        for (int i = 0; i < orders.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < orders.size(); j++) {
                if (orders.get(j).compareTo(orders.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Order temp = orders.get(i);
                orders.set(i, orders.get(minIndex));
                orders.set(minIndex, temp);
            }
        }
    }

    /**
     * Generates a string representation of the beverage shop's orders, along with
     * a summary of the total monthly sales.
     *
     * @return A formatted string that includes order details and total monthly sales.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Order order : orders) {
            sb.append(order).append("\n");
        }
        sb.append("Total Monthly Sale: ").append(totalMonthlySale());
        return sb.toString();
    }
}
