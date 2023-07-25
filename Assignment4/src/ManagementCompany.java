/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: This code represents a property management application
 * that allows users to manage properties and a management company.
 * Due: 07/17/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Mariia Honcharenko
*/

public class ManagementCompany {
    private String name;
    private String taxID;
    private double mgmFeePer;
    private Property[] properties;
    private Plot plot;
    private int numberOfProperties;

    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;

    // Default constructor
    public ManagementCompany() {
        this.name = "";
        this.taxID = "";
        this.mgmFeePer = 0.0;
        this.properties = new Property[MAX_PROPERTY];
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.numberOfProperties = 0;
    }

    // Parameterized constructor
    public ManagementCompany(String name, String taxID, double mgmFeePer) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFeePer;
        this.properties = new Property[MAX_PROPERTY];
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.numberOfProperties = 0;
    }

    // Parameterized constructor with plot dimensions
    public ManagementCompany(String name, String taxID, double mgmFeePer, int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFeePer;
        this.properties = new Property[MAX_PROPERTY];
        this.plot = new Plot(x, y, width, depth);
        this.numberOfProperties = 0;
    }

    // Copy constructor
    public ManagementCompany(ManagementCompany otherCompany) {
        this.name = otherCompany.name;
        this.taxID = otherCompany.taxID;
        this.mgmFeePer = otherCompany.mgmFeePer;
        this.properties = new Property[MAX_PROPERTY];
        for (int i = 0; i < otherCompany.numberOfProperties; i++) {
            this.properties[i] = new Property(otherCompany.properties[i]);
        }
        this.plot = new Plot(otherCompany.plot);
        this.numberOfProperties = otherCompany.numberOfProperties;
    }

    // Method to add a property using name, city, rent, and owner
    public int addProperty(String name, String city, double rent, String owner) {
        return addProperty(new Property(name, city, rent, owner));
    }

    // Method to add a property using name, city, rent, owner, and plot dimensions
    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
        return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
    }

    // Method to add a Property object to the properties array
    public int addProperty(Property property) {
        if (numberOfProperties >= MAX_PROPERTY) {
            return -1; // Array is full
        }

        if (property == null) {
            return -2; // Property object is null
        }

        if (!plot.encompasses(property.getPlot())) {
            return -3; // Property plot is not encompassed by the management company plot
        }

        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i].getPlot().overlaps(property.getPlot())) {
                return -4; // Property plot overlaps with another property's plot
            }
        }

        properties[numberOfProperties] = property;
        numberOfProperties++;
        return numberOfProperties - 1; // Return the index of the array where the property was added
    }

    // Method to remove the last property from the properties array
    public void removeLastProperty() {
        if (numberOfProperties > 0) {
            properties[numberOfProperties - 1] = null;
            numberOfProperties--;
        }
    }

    // Method to check if the properties array is full
    public boolean isPropertiesFull() {
        return numberOfProperties >= MAX_PROPERTY;
    }

    // Method to get the count of properties
    public int getPropertiesCount() {
        return numberOfProperties;
    }

    // Method to calculate and return the total rent of all properties
    public double getTotalRent() {
        double totalRent = 0.0;
        for (int i = 0; i < numberOfProperties; i++) {
            totalRent += properties[i].getRentAmount();
        }
        return totalRent;
    }

    // Method to get the property with the highest rent
    public Property getHighestRentProperty() {
        if (numberOfProperties > 0) {
            Property highestRentProperty = properties[0];
            for (int i = 1; i < numberOfProperties; i++) {
                if (properties[i].getRentAmount() > highestRentProperty.getRentAmount()) {
                    highestRentProperty = properties[i];
                }
            }
            return highestRentProperty;
        }
        return null;
    }

    // Method to check if the management fee percentage is valid
    public boolean isManagementFeeValid() {
        return mgmFeePer >= 0 && mgmFeePer <= 100;
    }

    // Getter method for the name
    public String getName() {
        return name;
    }

    // Getter method for the tax ID
    public String getTaxID() {
        return taxID;
    }

    // Getter method for the properties array
    public Property[] getProperties() {
        return properties;
    }

    // Getter method for the management fee percentage
    public double getMgmFeePer() {
        return mgmFeePer;
    }

    // Getter method for the plot
    public Plot getPlot() {
        return plot;
    }

    // Override the toString method to provide a string representation of the management company
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (numberOfProperties == 0) {
            sb.append("12,12,6,6");
        } else {
            sb.append("List of the properties for ").append(name).append(", taxID: ").append(taxID).append("\n");
            sb.append("________________________________________________").append("\n");
            for (int i = 0; i < numberOfProperties; i++) {
                sb.append(properties[i].toString()).append("\n");
            }
            sb.append("________________________________________________").append("\n");
            sb.append("\n total management Fee: ").append(getTotalRent() * (mgmFeePer / 100));
        }
        return sb.toString();
    }
}