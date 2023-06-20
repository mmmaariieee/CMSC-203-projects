/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: includes a game that checks the user's ability
 * to guess colors using their ESP skills. It randomly picks a
 * color from a set of options for each round. The user is asked
 * to guess the color, and their answer is compared to the
 * randomly chosen color. The game keeps track of the number
 * of correct guesses, and the final score is shown at the end.
 * Due: 06/19/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Mariia Honcharenko
*/

import java.util.Scanner;
import java.util.Random;

public class Assignment1 {

	public static void main(String[] args) {
		
		// Create a new Scanner object to read input from the user
		Scanner input = new Scanner(System.in);
		
		// Create a new Random object to generate random numbers
        Random random = new Random();

        // Declare variables for storing user information
        String userName, mcMNumber, userDescription;
        int correctGuesses = 0;

        // Prompt for user's name
        System.out.print("Enter your name: ");
        userName = input.nextLine();

        // Prompt for user's MC M#
        System.out.print("Enter your MC M#: ");
        mcMNumber = input.nextLine();

        // Prompt for user's description
        System.out.print("Describe yourself: ");
        userDescription = input.nextLine();

        System.out.println("Due Date: 06/19/23");

        System.out.println("CMSC203 Assignment1: Test your ESP skills!");

        String[] colors = {"Red", "Green", "Blue", "Orange", "Yellow"};
        int numColors = colors.length;
        
        // Run the following code 10 times
        for (int round = 1; round <= 10; round++) {
        	
        	// Display the current round number
            System.out.println("Round " + round + "\n");
            System.out.println("I am thinking of a color.");
            System.out.println("Is it Red, Green, Blue, Orange, or Yellow?");
            
            // Prompt the user to guess the color
            System.out.print("Enter your guess here: ");
            int guess = input.nextInt();
            
            // Consume the newline character
            input.nextLine();

            // Generate a random index for the color selection
            int randomIndex = random.nextInt(numColors);
            System.out.println("\nI was thinking of " + colors[randomIndex]);

            // Check if the user's guess matches the random color
            if (guess == randomIndex) {
                correctGuesses++;
            }
        }
        
        System.out.println("Game Over\n");
        System.out.println("You guessed " + correctGuesses + " out of 10 colors correctly.");

        // Close the input scanner to free up system resources
        input.close();
        
        // Display user's name
        System.out.println("User Name: " + userName);
        
        // Display user's MC M#
        System.out.println("Student MC M#: " + mcMNumber);
        
        // Display user's description
        System.out.println("User Description: " + userDescription);
        
        System.out.println("Date: 06/19/23");
        
	}

}
