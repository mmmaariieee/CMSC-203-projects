/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: The provided code contains unit tests for the ManagmentCompany Class.
 * Due: 07/17/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Mariia Honcharenko
*/

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManagementCompanyTestStudent {
    Property sampleProperty;
    ManagementCompany managementCo;

    @Before
    public void setUp() throws Exception {
        managementCo = new ManagementCompany("ABC Company", "123456789", 8);
    }

    @After
    public void tearDown() throws Exception {
        managementCo = null;
    }

    @Test
    public void testAddProperty() {
        // Create a sample property
        sampleProperty = new Property("Property XYZ", "Cityville", 2000, "John Doe", 3, 4, 2, 2);
        // Test if the property is successfully added to the management company's properties array at index 0
        assertEquals(managementCo.addProperty(sampleProperty), 0, 0);
    }

    @Test
    public void testGetPropertiesCount() {
        // Create a sample property
        sampleProperty = new Property("Property XYZ", "Cityville", 2000, "John Doe", 3, 4, 2, 2);
        // Add the sample property to the management company's properties array
        assertEquals(managementCo.addProperty(sampleProperty), 0, 0);
        // Test if the properties count is correct (1)
        assertEquals(managementCo.getPropertiesCount(), 1);
    }

    @Test
    public void testToString() {
        // Test if the toString method returns the expected string representation of the management company
        assertEquals("12,12,6,6", managementCo.toString());
    }
}
