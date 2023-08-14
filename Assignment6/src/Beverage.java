/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: This code represents different types of beverages available in the shop.
 * Due: 08/07/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Mariia Honcharenko
*/

/**
 * Abstract class representing different types of beverages available in the shop.
 * Subclasses such as Coffee, Smoothie, and Alcohol extend this class to provide specific implementations.
 */
public abstract class Beverage {

    // Instance variables
    private String bevName;  // Name of the beverage
    private Type type;       // Type of the beverage (COFFEE, SMOOTHIE, ALCOHOL)
    private Size size;       // Size of the beverage (SMALL, MEDIUM, LARGE)
    private final double BASE_PRICE = 2.0;  // Base price for all beverages
    private final double SIZE_PRICE = 1.0;  // Additional price for larger sizes

    // Parametrized constructor
    /**
     * Constructs a new Beverage object with the given parameters.
     * 
     * @param bevName The name of the beverage
     * @param type The type of the beverage
     * @param size The size of the beverage
     */
    public Beverage(String bevName, Type type, Size size) {
        this.bevName = bevName;
        this.type = type;
        this.size = size;
    }

    // Getter methods
    /**
     * Gets the base price for all beverages.
     * 
     * @return The base price
     */
    public double getBasePrice() {
        return BASE_PRICE;
    }

    /**
     * Gets the type of the beverage.
     * 
     * @return The beverage type
     */
    public Type getType() {
        return type;
    }

    /**
     * Gets the name of the beverage.
     * 
     * @return The beverage name
     */
    public String getBevName() {
        return bevName;
    }

    /**
     * Gets the size of the beverage.
     * 
     * @return The beverage size
     */
    public Size getSize() {
        return size;
    }

    // Method to calculate price based on size
    /**
     * Calculates the price of the beverage based on its size.
     * 
     * @return The calculated price
     */
    public double addSizePrice() {
        if (size == Size.SMALL) {
            return BASE_PRICE;
        } else if (size == Size.MEDIUM) {
            return BASE_PRICE + SIZE_PRICE;
        } else { // size == Size.LARGE
            return BASE_PRICE + (SIZE_PRICE * 2);
        }
    }

    // toString method
    /**
     * Returns a string representation of the beverage.
     * 
     * @return The string representation
     */
    @Override
    public String toString() {
        return bevName + "," + size;
    }

    // equals method
    /**
     * Compares this Beverage with another object for equality.
     * 
     * @param anotherBev The object to compare with
     * @return True if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object anotherBev) {
        if (this == anotherBev) {
            return true;
        }
        if (!(anotherBev instanceof Beverage)) {
            return false;
        }
        Beverage other = (Beverage) anotherBev;
        return bevName.equals(other.bevName) && type == other.type && size == other.size;
    }

    // Abstract method to calculate the beverage price
    /**
     * Abstract method to be implemented by subclasses.
     * Calculates the price of the beverage.
     * 
     * @return The calculated price
     */
    public abstract double calcPrice();
}
