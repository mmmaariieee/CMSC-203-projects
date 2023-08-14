/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: This code represents an order for beverages at Bradley shop.
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
 * Represents an order for beverages at Bradley shop.
 * This class implements the OrderInterface for managing beverages in an order
 * and Comparable for comparing orders based on order numbers.
 * 
 * An order includes information such as order number, order time, order day, customer,
 * and a list of beverages associated with the order.
 */
public class Order implements OrderInterface, Comparable<Order> {
    private int orderNo;
    private int orderTime;
    private Day orderDay;
    private Customer customer;
    private List<Beverage> beverages;

    /**
     * Constructor to create an order.
     *
     * @param orderTime The time of the order (between 8 and 23).
     * @param orderDay  The day of the order.
     * @param cust      The customer placing the order.
     */
    public Order(int orderTime, Day orderDay, Customer cust) {
        this.orderNo = generateOrder();
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = new Customer(cust);
        this.beverages = new ArrayList<>();
    }

    /**
     * Generates a random order number between 10000 and 90000.
     *
     * @return A randomly generated order number.
     */
    public int generateOrder() {
        return (int) (Math.random() * 80000) + 10000;
    }

    /**
     * Retrieves the order number.
     *
     * @return The order number.
     */
    public int getOrderNo() {
        return orderNo;
    }

    /**
     * Retrieves the order time.
     *
     * @return The order time.
     */
    public int getOrderTime() {
        return orderTime;
    }

    /**
     * Retrieves the order day.
     *
     * @return The order day.
     */
    public Day getOrderDay() {
        return orderDay;
    }

    /**
     * Retrieves a deep copy of the customer associated with the order.
     *
     * @return A deep copy of the customer.
     */
    public Customer getCustomer() {
        return new Customer(customer);
    }

    /**
     * Retrieves the day of the order.
     *
     * @return The day of the order.
     */
    public Day getDay() {
        return orderDay;
    }

    /**
     * Checks if the order day is a weekend day.
     *
     * @return True if the order day is a weekend day, false otherwise.
     */
    public boolean isWeekend() {
        return orderDay == Day.SATURDAY || orderDay == Day.SUNDAY;
    }

    /**
     * Retrieves the beverage listed at the specified item number in the order.
     *
     * @param itemNo The item number of the beverage in the order.
     * @return The beverage at the specified item number or null if not found.
     */
    public Beverage getBeverage(int itemNo) {
        if (itemNo >= 0 && itemNo < beverages.size()) {
            return beverages.get(itemNo);
        }
        return null;
    }

    /**
     * Retrieves the total number of beverages in the order.
     *
     * @return The total number of beverages in the order.
     */
    public int getTotalItems() {
        return beverages.size();
    }

    /**
     * Adds a new coffee beverage to the order.
     *
     * @param bevName    The name of the beverage.
     * @param size       The size of the beverage.
     * @param extraShot  True if an extra shot is added, false otherwise.
     * @param extraSyrup True if extra syrup is added, false otherwise.
     */
    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        Coffee coffee = new Coffee(bevName, size, extraShot, extraSyrup);
        beverages.add(coffee);
    }

    /**
     * Adds a new alcohol beverage to the order.
     *
     * @param bevName The name of the beverage.
     * @param size    The size of the beverage.
     */
    public void addNewBeverage(String bevName, Size size) {
    	boolean isWeekend = false;
    	
    	if (orderDay == Day.SATURDAY || orderDay == Day.SUNDAY) {
    		isWeekend = true;
    	}
        Alcohol alcohol = new Alcohol(bevName, size, isWeekend);
        beverages.add(alcohol);
    }

    /**
     * Adds a new smoothie beverage to the order.
     *
     * @param bevName    The name of the beverage.
     * @param size       The size of the beverage.
     * @param numOfFruits The number of fruits added.
     * @param addProtein True if protein is added, false otherwise.
     */
    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        Smoothie smoothie = new Smoothie(bevName, size, numOfFruits, addProtein);
        beverages.add(smoothie);
    }

    /**
     * Calculates the total cost of the order.
     *
     * @return The total cost of the order.
     */
    public double calcOrderTotal() {
        double total = 0;
        for (Beverage beverage : beverages) {
            total += beverage.calcPrice();
        }
        return total;
    }

    /**
     * Finds the number of beverages of a specific type in the order.
     *
     * @param type The type of beverage to search for.
     * @return The number of beverages of the specified type in the order.
     */
    public int findNumOfBeveType(Type type) {
        int count = 0;
        for (Beverage beverage : beverages) {
            if (beverage.getType() == type) {
                count++;
            }
        }
        return count;
    }

    /**
     * Generates a string representation of the order.
     *
     * @return A string containing order details.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Number: ").append(orderNo).append("\n");
        sb.append("Order Time: ").append(orderTime).append("\n");
        sb.append("Order Day: ").append(orderDay).append("\n");
        sb.append("Customer: ").append(customer).append("\n");
        sb.append("Beverages:\n");
        for (Beverage beverage : beverages) {
            sb.append(beverage).append("\n");
        }
        return sb.toString();
    }

    /**
     * Compares this order with another order based on order number.
     *
     * @param anotherOrder The order to compare to.
     * @return 0 if order numbers are equal, 1 if this order is greater, -1 if this order is smaller.
     */
    @Override
    public int compareTo(Order anotherOrder) {
        if (orderNo == anotherOrder.orderNo) {
            return 0;
        } else if (orderNo < anotherOrder.orderNo) {
            return -1;
        } else {
            return 1;
        }
    }
}