/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: This code represents  a customer with a name and age.
 * Due: 08/07/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Mariia Honcharenko
*/

/**
 * This class represents a customer with a name and age. It provides methods to
 * create and manipulate customer objects.
 */
public class Customer {

    // Instance variables for name and age
    private String name;
    private int age;

    /**
     * Parametrized constructor to create a Customer object with a name and age.
     *
     * @param name The name of the customer.
     * @param age The age of the customer.
     */
    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Copy constructor to create a Customer object based on another Customer object.
     *
     * @param c The Customer object to copy.
     */
    public Customer(Customer c) {
        this.name = c.name;
        this.age = c.age;
    }

    /**
     * Getter for the age of the customer.
     *
     * @return The age of the customer.
     */
    public int getAge() {
        return age;
    }

    /**
     * Setter for the age of the customer.
     *
     * @param age The age of the customer.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Getter for the name of the customer.
     *
     * @return The name of the customer.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name of the customer.
     *
     * @param name The name of the customer.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * String representation of the customer, including name and age.
     *
     * @return A string containing the customer's information.
     */
    @Override
    public String toString() {
        return "Customer: " + name + ", Age: " + age;
    }
}
