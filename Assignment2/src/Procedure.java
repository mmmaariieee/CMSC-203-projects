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
 * The Procedure class represents a medical procedure, storing information
 * such as the procedure name, date, practitioner name, and procedure charge.
 */

public class Procedure {
	
	// Declaring fields' variables
	private String procedureName;
    private String procedureDate;
    private String practitionerName;
    private double procedureCharge;

    /**
     * Constructs a Procedure object with the given procedure name, procedure date, practitioner name,
     * and procedure charge.
     *
     * @param procedureName     The name of the procedure.
     * @param procedureDate     The date of the procedure.
     * @param practitionerName  The name of the practitioner performing the procedure.
     * @param procedureCharge   The charge for the procedure.
     */
    
    public Procedure(String procedureName, String procedureDate, String practitionerName, double procedureCharge) {
        this.procedureName = procedureName;
        this.procedureDate = procedureDate;
        this.practitionerName = practitionerName;
        this.procedureCharge = procedureCharge;
    }

    // Accessor methods
    public String getProcedureName() {
        return procedureName;
    }

    public String getProcedureDate() {
        return procedureDate;
    }

    public String getPractitionerName() {
        return practitionerName;
    }

    public double getProcedureCharge() {
        return procedureCharge;
    }

    // Mutator methods
    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public void setProcedureDate(String procedureDate) {
        this.procedureDate = procedureDate;
    }

    public void setPractitionerName(String practitionerName) {
        this.practitionerName = practitionerName;
    }

    public void setProcedureCharge(double procedureCharge) {
        this.procedureCharge = procedureCharge;
    }
}
