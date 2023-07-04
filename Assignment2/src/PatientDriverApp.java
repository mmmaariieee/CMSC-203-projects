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

import java.util.Scanner;

/**
 *
 * The PatientDriverApp class creates an instance of the Patient class
 * and three instances of the Procedure class.
 *
 * It allows the user to enter their own information
 * or use default information for the patient.
 * 
 * It displays patient information, information about each procedure,
 * and calculates the total charges of the procedures.
 */

public class PatientDriverApp {
	public static void main(String[] args) {
		
		// Constants
	    final String STUDENT_NAME = "Mariia Honcharenko";
	    final String STUDENT_MC_NUMBER = "M21162171";
	    final String DUE_DATE = "07/03/23";
	    
	    // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        
        // Print application header
        System.out.println("********** Patient Charges Calculator **********\n");
        
        // Ask the user if they want to enter their own information
        System.out.println("Do you want to enter your own information? (yes/no): ");
        String input = scanner.nextLine();
        
        // Create an instance of the Patient class
        Patient patient;
        
        if (input.equalsIgnoreCase("yes")) {
        	
        	// If the user wants to enter their own information, read it from the user
            System.out.print("\nEnter first name: ");
            String firstName = scanner.nextLine();
            
            System.out.print("Enter middle name: ");
            String middleName = scanner.nextLine();
            
            System.out.print("Enter last name: ");
            String lastName = scanner.nextLine();
            
            System.out.print("Enter address: ");
            String address = scanner.nextLine();
            
            System.out.print("Enter city: ");
            String city = scanner.nextLine();
            
            System.out.print("Enter state: ");
            String state = scanner.nextLine();
            
            System.out.print("Enter ZIP code: ");
            String zipCode = scanner.nextLine();
            
            String phoneNumber = "";
            
            // Ask the user to enter a phone number with validation
            while (phoneNumber.isEmpty()) {
                System.out.print("Enter phone number: ");
                phoneNumber = scanner.nextLine();
                
                if (phoneNumber.isEmpty()) {
                    System.out.println("Phone number cannot be empty. Please try again.");
                }
            }
            
            System.out.print("Enter emergency contact name: ");
            String emergencyContactName = scanner.nextLine();
            
            System.out.print("Enter emergency contact number: ");
            String emergencyContactNumber = scanner.nextLine();

            // Create an instance of the Patient class with user-provided information
            patient = new Patient(firstName, middleName, lastName, address, city, state, zipCode,
                    phoneNumber, emergencyContactName, emergencyContactNumber);
        } else {
        	
        	// If the user wants to use default information
        	patient = new Patient("Jenny", "Elaine", "Santori", "123 Main Street", "Rockville", "MD", "20877",
        			"777-555-1212", "Bill Santori", "777-555-1212");
        }

        // Close the Scanner
        scanner.close();
        
        // Create three instances of the Procedure class
        Procedure procedure1 = new Procedure("Physical Exam", "7/20/2023", "Dr. Irvine", 250.0);
        Procedure procedure2 = new Procedure("X-ray", "7/20/2023", "Dr. Jamison", 500.0);
        Procedure procedure3 = new Procedure("Blood Test", "7/20/2023", "Dr. Smith", 200.0);
  
        
        // Display patient information
        displayPatientInformation(patient);

        // Display information about each procedure
        displayProcedureInformation(procedure1);
        displayProcedureInformation(procedure2);
        displayProcedureInformation(procedure3);

        // Calculate and display the total charges of the three procedures
        double totalCharges = procedure1.getProcedureCharge() + procedure2.getProcedureCharge() + procedure3.getProcedureCharge();
        System.out.println("\nTotal Charges: " + totalCharges);
        
        // Display constant student information
        System.out.println("\nStudent name: " + STUDENT_NAME);
        System.out.println("Student MC M#: " + STUDENT_MC_NUMBER);
        System.out.println("Due Date: " + DUE_DATE);
    }
	
	/**
     * Displays patient information.
     *
     * @param patient The Patient object containing patient information.
     */
    public static void displayPatientInformation(Patient patient) {
        System.out.println("\nPatient name: " + patient.getFirstName() + " " + patient.getMiddleName() + " " + patient.getLastName());
        System.out.println("Address: " + patient.getAddress());
        System.out.println("City: " + patient.getCity());
        System.out.println("State: " + patient.getState());
        System.out.println("ZIP: " + patient.getZipCode());
        System.out.println("Emergency Contact: " + patient.getEmergencyContactName() + " " + patient.getEmergencyContactNumber());
    }
    
    /**
     * Displays information about a procedure.
     *
     * @param procedure The Procedure object containing procedure information.
     */
    public static void displayProcedureInformation(Procedure procedure) {
        System.out.println("\nProcedure: " + procedure.getProcedureName());
        System.out.println("Procedure Date: " + procedure.getProcedureDate());
        System.out.println("Practitioner: " + procedure.getPractitionerName());
        System.out.println("Procedure Charge: " + procedure.getProcedureCharge());
    }

}
