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
        sampleProperty = new Property("Property XYZ", "Cityville", 2000, "John Doe", 3, 4, 2, 2);
        assertEquals(managementCo.addProperty(sampleProperty), 0, 0); // Property has been successfully added to index 0
    }

    @Test
    public void testGetPropertiesCount() {
        sampleProperty = new Property("Property XYZ", "Cityville", 2000, "John Doe", 3, 4, 2, 2);
        assertEquals(managementCo.addProperty(sampleProperty), 0, 0);
        assertEquals(managementCo.getPropertiesCount(), 1);
    }

    @Test
    public void testToString() {
        assertEquals("12,12,6,6", managementCo.toString());
    }
}
