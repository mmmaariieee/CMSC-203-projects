/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: Patient Charges Calculator manages patient information
 * and calculates the total charges for medical procedures. It provides
 * the option for users to enter their own information or use default data.
 * Due: 07/03/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Mariia Honcharenko
*/

/**
 * The Patient class represents a patient's information, including their name,
 * address, contact details, and emergency contact information.
 */

public class Patient {
	
	// Declaring fields' variables
	private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String emergencyContactName;
    private String emergencyContactNumber;

    /**
     * Constructs a Patient object with the provided personal and contact information.
     *
     * @param firstName               The first name of the patient.
     * @param middleName              The middle name of the patient.
     * @param lastName                The last name of the patient.
     * @param address                 The address of the patient.
     * @param city                    The city of residence of the patient.
     * @param state                   The state of residence of the patient.
     * @param zipCode                 The ZIP code of the patient's location.
     * @param phoneNumber             The phone number of the patient.
     * @param emergencyContactName    The name of the patient's emergency contact.
     * @param emergencyContactNumber  The phone number of the patient's emergency contact.
     */
    public Patient(String firstName, String middleName, String lastName, String address, String city, String state,
                   String zipCode, String phoneNumber, String emergencyContactName, String emergencyContactNumber) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactNumber = emergencyContactNumber;
    }

    // Accessor methods
    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    // Mutator methods
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public void setEmergencyContactNumber(String emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }

}
