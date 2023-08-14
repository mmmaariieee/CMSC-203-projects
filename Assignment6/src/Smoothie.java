/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: This code represents a Smoothie beverage.
 * Due: 08/07/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Mariia Honcharenko
*/

/**
 * A subclass of Beverage representing a Smoothie beverage.
 * Contains additional information about the number of fruits and whether protein is added.
 * Smoothies have additional costs for protein and each fruit.
 */
public class Smoothie extends Beverage {

    // Additional instance variables
    private int numOfFruits;
    private boolean addProtein;

    // Constants for pricing
    private static final double PROTEIN_COST = 1.50;
    private static final double FRUIT_COST = 0.50;

    /**
     * Creates a Smoothie object with the given parameters.
     * 
     * @param bevName    Name of the smoothie beverage
     * @param size       Size of the smoothie beverage
     * @param numOfFruits Number of fruits to be added
     * @param addProtein Whether protein is added
     */
    public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein) {
        super(bevName, Type.SMOOTHIE, size);
        this.numOfFruits = numOfFruits;
        this.addProtein = addProtein;
    }

    /**
     * Returns the number of fruits in the smoothie.
     * 
     * @return Number of fruits
     */
    public int getNumOfFruits() {
        return numOfFruits;
    }

    /**
     * Indicates whether protein is added to the smoothie.
     * 
     * @return True if protein is added, false otherwise
     */
    public boolean getAddProtein() {
        return addProtein;
    }

    /**
     * Calculates and returns the price of the smoothie beverage.
     * Includes base price, size cost, protein cost, and fruit cost.
     * 
     * @return Price of the smoothie
     */
    @Override
    public double calcPrice() {
        double sizePrice = addSizePrice();
        double totalCost = sizePrice;

        if (addProtein) {
            totalCost += PROTEIN_COST;
        }

        totalCost += numOfFruits * FRUIT_COST;
        return totalCost;
    }

    /**
     * Generates a string representation of the Smoothie beverage.
     * Includes name, size, protein, number of fruits, and price.
     * 
     * @return String representation of the smoothie
     */
    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s",
                getBevName(), getSize(), addProtein, numOfFruits, calcPrice());
    }

    /**
     * Compares this Smoothie with another object for equality.
     * Overrides the equals method in the Beverage class.
     * 
     * @param anotherBev The object to compare with
     * @return True if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object anotherBev) {
        if (!(anotherBev instanceof Smoothie)) {
            return false;
        }
        Smoothie otherSmoothie = (Smoothie) anotherBev;
        return super.equals(otherSmoothie) &&
               this.numOfFruits == otherSmoothie.numOfFruits &&
               this.addProtein == otherSmoothie.addProtein;
    }
}
