/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: This code calculates holiday bonuses for retail stores in District #5 based on sales.
 * Due: 07/24/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Mariia Honcharenko
*/

/**
 * The HolidayBonus class calculates holiday bonuses for retail stores in District #5 based on sales.
 * Highest-selling store receives $5,000, lowest-selling store gets $1,000, others receive $2,000.
 * Stores with negative or no sales in a category aren't eligible for bonuses in that category.
 * Sole sellers in a category get the highest bonus of $5,000.
 *
 * @author Mariia Honcharenko
 * @version 7/24/2023
 */
public class HolidayBonus {

    // Constants for bonus amounts
    public static final double HIGHEST_BONUS = 5000.0;
    public static final double LOWEST_BONUS = 1000.0;
    public static final double OTHER_BONUS = 2000.0;

    /**
     * Calculates the holiday bonus for each store in the district based on their sales.
     *
     * @param data the two-dimensional array of store sales
     * @return an array of the bonus for each store
     */
    public static double[] calculateHolidayBonus(double[][] data) {
        int rows = data.length;
        int cols = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, 0) + 1;
        double[] holidayBonuses = new double[rows];

        double[] highestSalesInCategory = new double[cols];
        double[] lowestSalesInCategory = new double[cols];
        
        // Initialize highestSalesInCategory and lowestSalesInCategory with the first valid sales value in each category
        for (int col = 0; col < cols; col++) {
            highestSalesInCategory[col] = Double.NEGATIVE_INFINITY;
            lowestSalesInCategory[col] = Double.POSITIVE_INFINITY;
        }

        // Find the highest and lowest sales in each category across different rows
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < data[row].length; col++) {
                double sales = data[row][col];
                if (sales > 0) {
                    if (sales > highestSalesInCategory[col]) {
                        highestSalesInCategory[col] = sales;
                    }
                    if (sales < lowestSalesInCategory[col]) {
                        lowestSalesInCategory[col] = sales;
                    }
                }
            }
        }

        // Calculate bonuses based on the highest and lowest sales in each category
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < data[row].length; col++) {
                double sales = data[row][col];
                if (sales > 0) {
                    if (sales == highestSalesInCategory[col]) {
                        holidayBonuses[row] += HIGHEST_BONUS;
                    } else if (sales == lowestSalesInCategory[col]) {
                        holidayBonuses[row] += LOWEST_BONUS;
                    } else {
                        holidayBonuses[row] += OTHER_BONUS;
                    }
                }
            }
        }

        return holidayBonuses;
    }



    /**
     * Calculates the total of all holiday bonuses for the district.
     *
     * @param data the two-dimensional array of store sales
     * @return the total of all holiday bonuses
     */
    public static double calculateTotalHolidayBonus(double[][] data) {
        double totalBonus = 0.0;
        double[] holidayBonuses = calculateHolidayBonus(data);

        for (double bonus : holidayBonuses) {
            totalBonus += bonus;
        }

        return totalBonus;
    }
}
