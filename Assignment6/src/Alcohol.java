/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: This code represents an Alcohol beverage that extends the Beverage class.
 * Due: 08/07/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Mariia Honcharenko
*/

/**
 * This class represents an Alcohol beverage that extends the Beverage class.
 * It contains additional information about whether the beverage is offered during weekends
 * and calculates the price of the alcohol based on its attributes.
 */
public class Alcohol extends Beverage {

    private boolean isWeekend; // Indicates whether the beverage is offered during weekends

    /**
     * Constructs an Alcohol object using the given values.
     *
     * @param bevName   Name of the beverage
     * @param size      Size of the beverage
     * @param isWeekend Whether the beverage is offered during weekends or not
     */
    public Alcohol(String bevName, Size size, boolean isWeekend) {
        super(bevName, Type.ALCOHOL, size);
        this.isWeekend = isWeekend;
    }

    /**
     * Calculates the price of the alcohol based on its attributes.
     *
     * @return The calculated price of the alcohol
     */
    @Override
    public double calcPrice() {
    	double sizePrice = addSizePrice();
        double totalCost = sizePrice;
        if (isWeekend) {
            totalCost += 0.6; // Additional cost for drinks offered during weekends
        }
        return totalCost;
    }

    /**
     * Returns a string representation of the Alcohol beverage.
     * Format: name, size, whether or not beverage is offered in weekend, price
     *
     * @return String representation of the Alcohol beverage
     */
    @Override
    public String toString() {
        return String.format("%s,%s,%b,%.2f", getBevName(), getSize(), isWeekend, calcPrice());
    }

    /**
     * Checks if this Alcohol beverage is equal to another object.
     *
     * @param anotherBev The other object to compare with
     * @return True if the name, type, size, base price, and whether beverage is offered in weekend are the same; false otherwise
     */
    @Override
    public boolean equals(Object anotherBev) {
        if (this == anotherBev) return true;
        if (anotherBev == null || getClass() != anotherBev.getClass()) return false;
        if (!super.equals(anotherBev)) return false;

        Alcohol alcohol = (Alcohol) anotherBev;
        return isWeekend == alcohol.isWeekend;
    }

    /**
     * Checks if the alcohol beverage is offered during weekends.
     *
     * @return True if the beverage is offered during weekends; false otherwise
     */
    public boolean isWeekend() {
        return isWeekend;
    }
}
