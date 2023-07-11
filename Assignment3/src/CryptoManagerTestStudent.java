
/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: The provided code contains unit tests for the CryptoManager class.
 * The tests validate the functionality of various methods such as checking
 * if a string is within allowable ASCII bounds, encrypting and decrypting strings
 * using Caesar and Bellaso ciphers.
 * Due: 07/10/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Mariia Honcharenko
*/

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * This class contains unit tests for the CryptoManager class.
 */

public class CryptoManagerTestStudent {
	
	/**
     * Tests the isStringInBounds method of the CryptoManager class.
     * It verifies if a string is within the allowable bounds of ASCII codes.
     */
	@Test
	public void testIsStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("HELLO"));
		assertTrue(CryptoManager.isStringInBounds("TESTING123"));
		assertTrue(CryptoManager.isStringInBounds("ABCDEFGHIJKLMNOPQRSTUVWXY"));
		assertFalse(CryptoManager.isStringInBounds("abcdefghijklmnopqrstuvwxyz"));
		assertFalse(CryptoManager.isStringInBounds("This string has special characters: [ ] { }"));
	}

	/**
     * Tests the caesarEncryption method of the CryptoManager class.
     * It encrypts a string using the Caesar Cipher algorithm.
     */
	@Test
	public void testCaesarEncryption() {
		assertEquals("KHOOR", CryptoManager.caesarEncryption("HELLO", 3));
		assertEquals("WKLV#LV#DQRWKHU#WHVW", CryptoManager.caesarEncryption("THIS IS ANOTHER TEST", 3));
		assertEquals("DEF", CryptoManager.caesarEncryption("ABC", 3));
		assertEquals("UFTUJOH", CryptoManager.caesarEncryption("TESTING", 1));
		assertEquals("1.558", CryptoManager.caesarEncryption("HELLO", 105));
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("bye", 3));
	}

	/**
     * Tests the caesarDecryption method of the CryptoManager class.
     * It decrypts a string encrypted using the Caesar Cipher algorithm.
     */
	@Test
	public void testCaesarDecryption() {
		assertEquals("HELLO", CryptoManager.caesarDecryption("KHOOR", 3));
		assertEquals("THIS IS ANOTHER TEST", CryptoManager.caesarDecryption("WKLV#LV#DQRWKHU#WHVW", 3));
		assertEquals("ABC", CryptoManager.caesarDecryption("DEF", 3));
		assertEquals("TESTING", CryptoManager.caesarDecryption("UFTUJOH", 1));
		assertEquals("HELLO", CryptoManager.caesarDecryption("1.558", 105));
	}

	/**
     * Tests the bellasoEncryption method of the CryptoManager class.
     * It encrypts a string using the Bellaso Cipher algorithm.
     */
	@Test
	public void testBellasoEncryption() {
		assertEquals("WN#\\N &", CryptoManager.bellasoEncryption("TESTING", "CIPHER_IS_LONGER_THAN_THE_PLAIN_TEXT"));
		assertEquals("UJ^^((HT^X[YYM\"", CryptoManager.bellasoEncryption("MERRY CHRISTMAS", "HELLO"));
		assertEquals("WU\\VR9F#N!RF88U-'HED", CryptoManager.bellasoEncryption("THIS IS ANOTHER TEST", "CMSC203"));
	}

	/**
     * Tests the bellasoDecryption method of the CryptoManager class.
     * It decrypts a string encrypted using the Bellaso Cipher algorithm.
     */
	@Test
	public void testBellasoDecryption() {
		assertEquals("TESTING", CryptoManager.bellasoDecryption("WN#\\N &", "CIPHER_IS_LONGER_THAN_THE_PLAIN_TEXT"));
		assertEquals("MERRY CHRISTMAS", CryptoManager.bellasoDecryption("UJ^^((HT^X[YYM\"", "HELLO"));
		assertEquals("THIS IS ANOTHER TEST", CryptoManager.bellasoDecryption("WU\\VR9F#N!RF88U-'HED", "CMSC203"));
	}

}