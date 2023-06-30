import java.util.Scanner;

public class MovieDriver_Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continueInput;

        do {
            // Create a new movie object
            Movie movie = new Movie();

            // Prompt the user to enter the title of a movie
            System.out.println("Enter the name of a movie:");
            String title = scanner.nextLine();

            // Set the title in the movie object
            movie.setTitle(title);

            // Prompt the user to enter the movie's rating
            System.out.println("Enter the rating of the movie:");
            String rating = scanner.nextLine();

            // Set the rating in the movie object
            movie.setRating(rating);

            // Prompt the user to enter the number of tickets sold
            System.out.println("Enter the number of tickets sold for this movie:");
            int soldTickets = scanner.nextInt();
            scanner.nextLine(); // Consume the remaining newline character

            // Set the number of tickets sold in the movie object
            movie.setSoldTickets(soldTickets);

            // Print out the information using the movie's toString method
            System.out.println(movie.toString());

            // Ask the user if they want to enter another movie
            System.out.println("Do you want to enter another? (y or n)");
            continueInput = scanner.nextLine();
        } while (continueInput.equalsIgnoreCase("y"));

        System.out.println("Goodbye");

        scanner.close();
    }
}
