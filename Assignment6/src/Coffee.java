/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: This code represents the Coffee beverage type.
 * Due: 08/07/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Mariia Honcharenko
*/

/**
 * Subclass representing the Coffee beverage type.
 * Inherits from the Beverage class.
 */
public class Coffee extends Beverage {

    // Additional instance variables
    private boolean extraShot;  // Indicates if an extra shot of coffee is added
    private boolean extraSyrup; // Indicates if extra syrup is added
    private final double EXTRA_COST = 0.5; // Cost of extra shot or syrup

    // Parametrized constructor
    /**
     * Constructs a new Coffee object with the given parameters.
     * 
     * @param bevName The name of the coffee beverage
     * @param size The size of the coffee beverage
     * @param extraShot Indicates whether an extra shot of coffee is added
     * @param extraSyrup Indicates whether extra syrup is added
     */
    public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        super(bevName, Type.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    // Getter methods
    /**
     * Checks if an extra shot of coffee is added to the coffee beverage.
     * 
     * @return True if an extra shot is added, false otherwise
     */
    public boolean getExtraShot() {
        return extraShot;
    }

    /**
     * Checks if extra syrup is added to the coffee beverage.
     * 
     * @return True if extra syrup is added, false otherwise
     */
    public boolean getExtraSyrup() {
        return extraSyrup;
    }

    // Overridden method to calculate the price of Coffee
    /**
     * Calculates the price of the coffee beverage, accounting for its size and any extra additions.
     * 
     * @return The calculated price of the coffee beverage
     */
    @Override
    public double calcPrice() {
        double sizePrice = addSizePrice();
        double totalPrice = sizePrice;

        if (extraShot) {
            totalPrice += EXTRA_COST;
        }
        if (extraSyrup) {
            totalPrice += EXTRA_COST;
        }

        return totalPrice;
    }

    // Overridden toString method
    /**
     * Returns a string representation of the Coffee beverage, including its name, size, extra shot, extra syrup, and price.
     * 
     * @return The string representation of the Coffee beverage
     */
    @Override
    public String toString() {
        return getBevName() + "," + getSize() + "," + extraShot + "," + extraSyrup + "," + calcPrice();
    }

    // Overridden equals method
    /**
     * Compares this Coffee beverage with another object for equality.
     * 
     * @param anotherBev The object to compare with
     * @return True if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object anotherBev) {
        if (!super.equals(anotherBev)) {
            return false;
        }
        Coffee other = (Coffee) anotherBev;
        return extraShot == other.extraShot && extraSyrup == other.extraSyrup;
    }
}
