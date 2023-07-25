/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: This code defines a Property class with properties
 * such as property name, city, rent amount, owner, and a plot,
 * along with constructors, getters, and a toString() method to represent
 * the property object as a string.
 * Due: 07/17/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Mariia Honcharenko
*/

public class Property {
    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;
    private Plot plot;

    public Property() {
        // Default constructor initializes the property with empty values and a default plot
        this.propertyName = "";
        this.city = "";
        this.rentAmount = 0.0;
        this.owner = "";
        this.plot = new Plot();
    }

    public Property(String propertyName, String city, double rentAmount, String owner) {
        // Parameterized constructor sets the property with provided values and a default plot
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot();
    }

    public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
        // Parameterized constructor sets the property with provided values and a custom plot
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
    }

    public Property(Property otherProperty) {
        // Copy constructor creates a new Property object with the same values as another Property object
        this.propertyName = otherProperty.propertyName;
        this.city = otherProperty.city;
        this.rentAmount = otherProperty.rentAmount;
        this.owner = otherProperty.owner;
        this.plot = new Plot(otherProperty.plot);
    }

    public Plot getPlot() {
        // Getter method to retrieve the plot of the property
        return plot;
    }

    public String getPropertyName() {
        // Getter method to retrieve the property name
        return propertyName;
    }

    public String getCity() {
        // Getter method to retrieve the city of the property
        return city;
    }

    public double getRentAmount() {
        // Getter method to retrieve the rent amount of the property
        return rentAmount;
    }

    public String getOwner() {
        // Getter method to retrieve the owner of the property
        return owner;
    }

    @Override
    public String toString() {
        // Override the toString method to provide a string representation of the property
        return propertyName + "," + city + "," + owner + "," + rentAmount;
    }
}
