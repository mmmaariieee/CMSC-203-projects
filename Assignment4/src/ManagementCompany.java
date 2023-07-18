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

    public ManagementCompany() {
        this.name = "";
        this.taxID = "";
        this.mgmFeePer = 0.0;
        this.properties = new Property[MAX_PROPERTY];
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.numberOfProperties = 0;
    }

    public ManagementCompany(String name, String taxID, double mgmFeePer) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFeePer;
        this.properties = new Property[MAX_PROPERTY];
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.numberOfProperties = 0;
    }

    public ManagementCompany(String name, String taxID, double mgmFeePer, int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFeePer;
        this.properties = new Property[MAX_PROPERTY];
        this.plot = new Plot(x, y, width, depth);
        this.numberOfProperties = 0;
    }

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

    public int addProperty(String name, String city, double rent, String owner) {
        return addProperty(new Property(name, city, rent, owner));
    }

    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
        return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
    }

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

    public void removeLastProperty() {
        if (numberOfProperties > 0) {
            properties[numberOfProperties - 1] = null;
            numberOfProperties--;
        }
    }

    public boolean isPropertiesFull() {
        return numberOfProperties >= MAX_PROPERTY;
    }

    public int getPropertiesCount() {
        return numberOfProperties;
    }

    public double getTotalRent() {
        double totalRent = 0.0;
        for (int i = 0; i < numberOfProperties; i++) {
            totalRent += properties[i].getRentAmount();
        }
        return totalRent;
    }

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

    public boolean isManagementFeeValid() {
        return mgmFeePer >= 0 && mgmFeePer <= 100;
    }

    public String getName() {
        return name;
    }

    public String getTaxID() {
        return taxID;
    }

    public Property[] getProperties() {
        return properties;
    }

    public double getMgmFeePer() {
        return mgmFeePer;
    }

    public Plot getPlot() {
        return plot;
    }

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
