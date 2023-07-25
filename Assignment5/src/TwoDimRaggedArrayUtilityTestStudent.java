/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: This code is a JUnit test class for the TwoDimRaggedArrayUtility class.
 * Due: 07/24/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Mariia Honcharenko
*/

import org.junit.Assert;
import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This is a JUnit test class for the TwoDimRaggedArrayUtility class.
 * It contains test cases for each public method in the TwoDimRaggedArrayUtility class.
 * Each test case validates the correctness of the corresponding method's functionality.
 * The test cases cover various scenarios and edge cases to ensure the reliability of the methods.
 * The class utilizes JUnit's Assert class for assertions to compare expected and actual results.
 * 
 * @author Mariia Honcharenko
 * @version 7/24/2023
 */
public class TwoDimRaggedArrayUtilityTestStudent {

    // Test case for readFile method
    @Test
    public void testReadFile() {
        File inputFile = new File("input_file1.txt");
        try {
            double[][] array = TwoDimRaggedArrayUtility.readFile(inputFile);
            // Add test assertions here to verify the content of the array read from the file
            // Example:
            Assert.assertEquals(100.25, array[0][0], 0.001);
            Assert.assertEquals(200.50, array[0][1], 0.001);
            // ...
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Assert.fail("File not found: " + inputFile.getAbsolutePath());
        }
    }

    // Test case for writeToFile method
    @Test
    public void testWriteToFile() {
        File outputFile = new File("output.txt");
        double[][] data = { { 1.0, 2.0 }, { 3.0, 4.0, 5.0 }, { 6.0, 7.0, 8.0, 9.0 } };
        try {
            TwoDimRaggedArrayUtility.writeToFile(data, outputFile);
            // Add test assertions here to verify the content of the file after writing
            // Example:
            double[][] readData = TwoDimRaggedArrayUtility.readFile(outputFile);
            Assert.assertEquals(data[0][0], readData[0][0], 0.001);
            Assert.assertEquals(data[0][1], readData[0][1], 0.001);
            // ...
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Assert.fail("Output file not found: " + outputFile.getAbsolutePath());
        }
    }

    // Test case for getTotal method
    @Test
    public void testGetTotal() {
        double[][] data = { { 1.0, 2.0 }, { 3.0, 4.0, 5.0 }, { 6.0, 7.0, 8.0, 9.0 } };
        double total = TwoDimRaggedArrayUtility.getTotal(data);
        // Add test assertion for total value
        // Example:
        Assert.assertEquals(45.0, total, 0.001);
    }

    // Test case for getAverage method
    @Test
    public void testGetAverage() {
        double[][] data = { { 1.0, 2.0 }, { 3.0, 4.0, 5.0 }, { 6.0, 7.0, 8.0, 9.0 } };
        double average = TwoDimRaggedArrayUtility.getAverage(data);
        // Add test assertion for average value
        // Example:
        Assert.assertEquals(5.0, average, 0.001);
    }

    // Test case for getRowTotal method
    @Test
    public void testGetRowTotal() {
        double[][] data = { { 1.0, 2.0 }, { 3.0, 4.0, 5.0 }, { 6.0, 7.0, 8.0, 9.0 } };
        double rowTotal = TwoDimRaggedArrayUtility.getRowTotal(data, 1);
        // Add test assertion for rowTotal value
        // Example:
        Assert.assertEquals(12.0, rowTotal, 0.001);
    }

    // Test case for getColumnTotal method
    @Test
    public void testGetColumnTotal() {
        double[][] data = { { 1.0, 2.0 }, { 3.0, 4.0, 5.0 }, { 6.0, 7.0, 8.0, 9.0 } };
        double columnTotal = TwoDimRaggedArrayUtility.getColumnTotal(data, 0);
        // Add test assertion for columnTotal value
        // Example:
        Assert.assertEquals(10.0, columnTotal, 0.001);
    }

    // Test case for getHighestInRow method
    @Test
    public void testGetHighestInRow() {
        double[][] data = { { 1.0, 2.0 }, { 3.0, 4.0, 5.0 }, { 6.0, 7.0, 8.0, 9.0 } };
        double highestInRow = TwoDimRaggedArrayUtility.getHighestInRow(data, 1);
        // Add test assertion for highestInRow value
        // Example:
        Assert.assertEquals(5.0, highestInRow, 0.001);
    }

    // Test case for getHighestInRowIndex method
    @Test
    public void testGetHighestInRowIndex() {
        double[][] data = { { 1.0, 2.0 }, { 3.0, 4.0, 5.0 }, { 6.0, 7.0, 8.0, 9.0 } };
        int highestInRowIndex = TwoDimRaggedArrayUtility.getHighestInRowIndex(data, 1);
        // Add test assertion for highestInRowIndex value
        // Example:
        Assert.assertEquals(2, highestInRowIndex);
    }

    // Test case for getLowestInRow method
    @Test
    public void testGetLowestInRow() {
        double[][] data = { { 1.0, 2.0 }, { 3.0, 4.0, 5.0 }, { 6.0, 7.0, 8.0, 9.0 } };
        double lowestInRow = TwoDimRaggedArrayUtility.getLowestInRow(data, 1);
        // Add test assertion for lowestInRow value
        // Example:
        Assert.assertEquals(3.0, lowestInRow, 0.001);
    }

    // Test case for getLowestInRowIndex method
    @Test
    public void testGetLowestInRowIndex() {
        double[][] data = { { 1.0, 2.0 }, { 3.0, 4.0, 5.0 }, { 6.0, 7.0, 8.0, 9.0 } };
        int lowestInRowIndex = TwoDimRaggedArrayUtility.getLowestInRowIndex(data, 1);
        // Add test assertion for lowestInRowIndex value
        // Example:
        Assert.assertEquals(0, lowestInRowIndex);
    }

    // Test case for getHighestInColumn method
    @Test
    public void testGetHighestInColumn() {
        double[][] data = { { 1.0, 2.0 }, { 3.0, 4.0, 5.0 }, { 6.0, 7.0, 8.0, 9.0 } };
        double highestInColumn = TwoDimRaggedArrayUtility.getHighestInColumn(data, 0);
        // Add test assertion for highestInColumn value
        // Example:
        Assert.assertEquals(6.0, highestInColumn, 0.001);
    }

    // Test case for getHighestInColumnIndex method
    @Test
    public void testGetHighestInColumnIndex() {
        double[][] data = { { 1.0, 2.0 }, { 3.0, 4.0, 5.0 }, { 6.0, 7.0, 8.0, 9.0 } };
        int highestInColumnIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, 0);
        // Add test assertion for highestInColumnIndex value
        // Example:
        Assert.assertEquals(2, highestInColumnIndex);
    }

    // Test case for getLowestInColumn method
    @Test
    public void testGetLowestInColumn() {
        double[][] data = { { 1.0, 2.0 }, { 3.0, 4.0, 5.0 }, { 6.0, 7.0, 8.0, 9.0 } };
        double lowestInColumn = TwoDimRaggedArrayUtility.getLowestInColumn(data, 0);
        // Add test assertion for lowestInColumn value
        // Example:
        Assert.assertEquals(1.0, lowestInColumn, 0.001);
    }

    // Test case for getLowestInColumnIndex method
    @Test
    public void testGetLowestInColumnIndex() {
        double[][] data = { { 1.0, 2.0 }, { 3.0, 4.0, 5.0 }, { 6.0, 7.0, 8.0, 9.0 } };
        int lowestInColumnIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, 0);
        // Add test assertion for lowestInColumnIndex value
        // Example:
        Assert.assertEquals(0, lowestInColumnIndex);
    }

    // Test case for getHighestInArray method
    @Test
    public void testGetHighestInArray() {
        double[][] data = { { 1.0, 2.0 }, { 3.0, 4.0, 5.0 }, { 6.0, 7.0, 8.0, 9.0 } };
        double highestInArray = TwoDimRaggedArrayUtility.getHighestInArray(data);
        // Add test assertion for highestInArray value
        // Example:
        Assert.assertEquals(9.0, highestInArray, 0.001);
    }

    // Test case for getLowestInArray method
    @Test
    public void testGetLowestInArray() {
        double[][] data = { { 1.0, 2.0 }, { 3.0, 4.0, 5.0 }, { 6.0, 7.0, 8.0, 9.0 } };
        double lowestInArray = TwoDimRaggedArrayUtility.getLowestInArray(data);
        // Add test assertion for lowestInArray value
        // Example:
        Assert.assertEquals(1.0, lowestInArray, 0.001);
    }
}
