import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTester {
	
	private GradeBook gradeBook1;
    private GradeBook gradeBook2;

	@BeforeEach
	void setUp() throws Exception {
		gradeBook1 = new GradeBook(5);
        gradeBook2 = new GradeBook(5);
	}

	@AfterEach
	void tearDown() throws Exception {
		gradeBook1 = null;
        gradeBook2 = null;
	}

	@Test
	void testAddScore() {
		// Test the addScore method for gradeBook1
        gradeBook1.addScore(75);
        gradeBook1.addScore(80);
        gradeBook1.addScore(90);

        // Test the addScore method for gradeBook2
        gradeBook2.addScore(85);
        gradeBook2.addScore(95);
        
        // Test the contents of scores array using toString method
        assertTrue(gradeBook1.toString().equals("75.0 80.0 90.0"));
        assertTrue(gradeBook2.toString().equals("85.0 95.0"));
        
        // Test the scoreSize
        assertEquals(3, gradeBook1.getScoreSize());
        assertEquals(2, gradeBook2.getScoreSize());
	}

	@Test
	void testSum() {
		// Test the sum method for gradeBook1
        gradeBook1.addScore(75);
        gradeBook1.addScore(80);
        gradeBook1.addScore(90);

        // Test the sum method for gradeBook2
        gradeBook2.addScore(85);
        gradeBook2.addScore(95);

        // Test the sum of scores
        assertEquals(245, gradeBook1.sum());
        assertEquals(180, gradeBook2.sum());
	}

	@Test
	void testMinimum() {
		// Test the minimum method for gradeBook1
        gradeBook1.addScore(75);
        gradeBook1.addScore(80);
        gradeBook1.addScore(90);

        // Test the minimum method for gradeBook2
        gradeBook2.addScore(85);
        gradeBook2.addScore(95);

        // Test the minimum score
        assertEquals(75, gradeBook1.minimum());
        assertEquals(85, gradeBook2.minimum());
	}

	@Test
	void testFinalScore() {
		// Test the finalScore method for gradeBook1
        gradeBook1.addScore(75);
        gradeBook1.addScore(80);
        gradeBook1.addScore(90);

        // Test the finalScore method for gradeBook2
        gradeBook2.addScore(85);
        gradeBook2.addScore(95);

     // Test the final score with delta
        assertEquals(170.0, gradeBook1.finalScore()); 
        assertEquals(95.0, gradeBook2.finalScore());
	}

	@Test
	void testGetScoreSize() {
		// Test the getScoreSize method for gradeBook1
        gradeBook1.addScore(75);
        gradeBook1.addScore(80);
        gradeBook1.addScore(90);

        // Test the getScoreSize method for gradeBook2
        gradeBook2.addScore(85);
        gradeBook2.addScore(95);
        
        // Test the scoreSize
        assertEquals(3, gradeBook1.getScoreSize());
        assertEquals(2, gradeBook2.getScoreSize());
	}

	@Test
	void testToString() {
		// Test the toString method for gradeBook1
        gradeBook1.addScore(75);
        gradeBook1.addScore(80);
        gradeBook1.addScore(90);

        // Test the toString method for gradeBook2
        gradeBook2.addScore(85);
        gradeBook2.addScore(95);

        // Test the string representation of scores
        assertEquals("75.0 80.0 90.0", gradeBook1.toString());
        assertEquals("85.0 95.0", gradeBook2.toString());
	}

}
