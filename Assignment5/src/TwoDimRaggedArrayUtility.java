/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: This code provides various methods for working with two-dimensional ragged arrays of doubles.
 * Due: 07/24/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Mariia Honcharenko
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This utility class provides various methods for working with two-dimensional ragged arrays of doubles.
 * It includes methods for reading from a file, calculating totals, averages, finding maximum and minimum values,
 * and writing to a file.
 * The maximum rows allowed is 10, and the maximum columns for each row is 10.
 * The class does not have any instance variables and all methods are static.
 * 
 * @author Mariia Honcharenko
 * @version 7/24/2023
 */

public class TwoDimRaggedArrayUtility {

    public TwoDimRaggedArrayUtility() {
        // Constructor (not used in this utility class)
    }

    /**
     * Reads from a file and returns a ragged array of doubles.
     * The maximum rows is 10, and the maximum columns for each row is 10.
     * Each row in the file is separated by a new line.
     * Each element in the row is separated by a space.
     * 
     * @param file the file to read from
     * @return a two-dimensional ragged array of doubles if the file is not empty, returns null if the file is empty
     * @throws FileNotFoundException if the specified file is not found
     */
    public static double[][] readFile(File file) throws FileNotFoundException {
        final int MAX_ROW = 10;
        final int MAX_COLUMN = 10;
        double[][] array = new double[MAX_ROW][];

        Scanner scanner = new Scanner(file);

        int row = 0;
        while (scanner.hasNextLine() && row < MAX_ROW) {
            String line = scanner.nextLine();
            String[] elements = line.split(" ");
            int numColumns = Math.min(MAX_COLUMN, elements.length);

            array[row] = new double[numColumns];
            for (int col = 0; col < numColumns; col++) {
                array[row][col] = Double.parseDouble(elements[col]);
            }

            row++;
        }

        scanner.close();

        return array;
    }

    /**
     * Writes the ragged array of doubles into the specified file.
     * Each row is on a separate line within the file, and each double is separated by a space.
     * 
     * @param data the two-dimensional ragged array of doubles
     * @param outputFile the file to write to
     * @throws FileNotFoundException if the specified output file is not valid
     */
    public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(outputFile);

        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                writer.print(data[row][col] + " ");
            }
            writer.println();
        }

        writer.close();
    }

    /**
     * Returns the total of all the elements in the two-dimensional array.
     * 
     * @param data the two-dimensional array for which the total is calculated
     * @return the sum of all the elements in the two-dimensional array
     */
    public static double getTotal(double[][] data) {
        double total = 0.0;
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                total += data[row][col];
            }
        }
        return total;
    }

    /**
     * Returns the average of all the elements in the two-dimensional array.
     * 
     * @param data the two-dimensional array for which the average is calculated
     * @return the average of all the elements in the two-dimensional array (total of elements / number of elements)
     */
    public static double getAverage(double[][] data) {
        double total = getTotal(data);
        int numElements = 0;
        for (int row = 0; row < data.length; row++) {
            numElements += data[row].length;
        }
        return total / numElements;
    }

    /**
     * Returns the total of the selected row in the two-dimensional array.
     * Index 0 refers to the first row.
     * 
     * @param data the two-dimensional array
     * @param row the row index to take the total of (0 refers to the first row)
     * @return the total of the selected row
     */
    public static double getRowTotal(double[][] data, int row) {
        double total = 0.0;
        if (row >= 0 && row < data.length) {
            for (int col = 0; col < data[row].length; col++) {
                total += data[row][col];
            }
        }
        return total;
    }

    /**
     * Returns the total of the selected column in the two-dimensional array.
     * Index 0 refers to the first column.
     * If a row in the two-dimensional array doesn't have this column index, it is not an error and doesn't participate in this method.
     *
     * @param data the two-dimensional array
     * @param col  the column index to take the total of (0 refers to the first column)
     * @return the total of the selected column
     */
    public static double getColumnTotal(double[][] data, int col) {
        double total = 0.0;
        for (int row = 0; row < data.length; row++) {
            if (col >= 0 && col < data[row].length) {
                total += data[row][col];
            }
        }
        return total;
    }

    /**
     * Returns the largest element of the selected row in the two-dimensional array.
     * Index 0 refers to the first row.
     *
     * @param data the two-dimensional array
     * @param row  the row index to find the largest element of (0 refers to the first row)
     * @return the largest element of the selected row
     */
    public static double getHighestInRow(double[][] data, int row) {
        double highest = Double.MIN_VALUE;
        if (row >= 0 && row < data.length) {
            for (int col = 0; col < data[row].length; col++) {
                highest = Math.max(highest, data[row][col]);
            }
        }
        return highest;
    }

    /**
     * Returns the index of the largest element of the selected row in the two-dimensional array.
     * Index 0 refers to the first row.
     *
     * @param data the two-dimensional array
     * @param row  the row index to find the largest element of (0 refers to the first row)
     * @return the index of the largest element of the selected row
     */
    public static int getHighestInRowIndex(double[][] data, int row) {
        int index = -1;
        double highest = Double.MIN_VALUE;
        if (row >= 0 && row < data.length) {
            for (int col = 0; col < data[row].length; col++) {
                if (data[row][col] > highest) {
                    highest = data[row][col];
                    index = col;
                }
            }
        }
        return index;
    }
    
    /**
     * Returns the smallest element of the selected row in the two-dimensional array.
     * Index 0 refers to the first row.
     *
     * @param data the two-dimensional array
     * @param row  the row index to find the smallest element of (0 refers to the first row)
     * @return the smallest element of the selected row
     */
    public static double getLowestInRow(double[][] data, int row) {
        double lowest = Double.MAX_VALUE;
        if (row >= 0 && row < data.length) {
            for (int col = 0; col < data[row].length; col++) {
                lowest = Math.min(lowest, data[row][col]);
            }
        }
        return lowest;
    }

    /**
     * Returns the index of the smallest element of the selected row in the two-dimensional array.
     * Index 0 refers to the first row.
     *
     * @param data the two-dimensional array
     * @param row  the row index to find the smallest element of (0 refers to the first row)
     * @return the index of the smallest element of the selected row
     */
    public static int getLowestInRowIndex(double[][] data, int row) {
        int index = -1;
        double lowest = Double.MAX_VALUE;
        if (row >= 0 && row < data.length) {
            for (int col = 0; col < data[row].length; col++) {
                if (data[row][col] < lowest) {
                    lowest = data[row][col];
                    index = col;
                }
            }
        }
        return index;
    }

    /**
     * Returns the largest element of the selected column in the two-dimensional array.
     * Index 0 refers to the first column.
     * If a row in the two-dimensional array doesn't have this column index, it is not an error and doesn't participate in this method.
     *
     * @param data the two-dimensional array
     * @param col  the column index to find the largest element of (0 refers to the first column)
     * @return the largest element of the selected column
     */
    public static double getHighestInColumn(double[][] data, int col) {
        double highest = Double.MIN_VALUE;
        for (int row = 0; row < data.length; row++) {
            if (col >= 0 && col < data[row].length) {
                highest = Math.max(highest, data[row][col]);
            }
        }
        return highest;
    }

    /**
     * Returns the index of the largest element of the selected column in the two-dimensional array.
     * Index 0 refers to the first column.
     * If a row in the two-dimensional array doesn't have this column index, it is not an error and doesn't participate in this method.
     *
     * @param data the two-dimensional array
     * @param col  the column index to find the largest element of (0 refers to the first column)
     * @return the index of the largest element of the selected column
     */
    public static int getHighestInColumnIndex(double[][] data, int col) {
        int index = -1;
        double highest = Double.MIN_VALUE;
        for (int row = 0; row < data.length; row++) {
            if (col >= 0 && col < data[row].length) {
                if (data[row][col] > highest) {
                    highest = data[row][col];
                    index = row;
                }
            }
        }
        return index;
    }

    /**
     * Returns the smallest element of the selected column in the two-dimensional array.
     * Index 0 refers to the first column.
     * If a row in the two-dimensional array doesn't have this column index, it is not an error and doesn't participate in this method.
     *
     * @param data the two-dimensional array
     * @param col  the column index to find the smallest element of (0 refers to the first column)
     * @return the smallest element of the selected column
     */
    public static double getLowestInColumn(double[][] data, int col) {
        double lowest = Double.MAX_VALUE;
        for (int row = 0; row < data.length; row++) {
            if (col >= 0 && col < data[row].length) {
                lowest = Math.min(lowest, data[row][col]);
            }
        }
        return lowest;
    }

    /**
     * Returns the index of the smallest element of the selected column in the two-dimensional array.
     * Index 0 refers to the first column.
     * If a row in the two-dimensional array doesn't have this column index, it is not an error and doesn't participate in this method.
     *
     * @param data the two-dimensional array
     * @param col  the column index to find the smallest element of (0 refers to the first column)
     * @return the index of the smallest element of the selected column
     */
    public static int getLowestInColumnIndex(double[][] data, int col) {
        int index = -1;
        double lowest = Double.MAX_VALUE;
        for (int row = 0; row < data.length; row++) {
            if (col >= 0 && col < data[row].length) {
                if (data[row][col] < lowest) {
                    lowest = data[row][col];
                    index = row;
                }
            }
        }
        return index;
    }

    /**
     * Returns the largest element in the two-dimensional array.
     *
     * @param data the two-dimensional array
     * @return the largest element in the two-dimensional array
     */
    public static double getHighestInArray(double[][] data) {
        double highest = Double.MIN_VALUE;
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                highest = Math.max(highest, data[row][col]);
            }
        }
        return highest;
    }


/**
 * Returns the smallest element in the two-dimensional array.
 *
 * @param data the two-dimensional array
 * @return the smallest element in the two-dimensional array
 */
    public static double getLowestInArray(double[][] data) {
        double lowest = Double.MAX_VALUE;
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                lowest = Math.min(lowest, data[row][col]);
            }
        }
        return lowest;
    }
}
