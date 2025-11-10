import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
//no need to extend Media
public class Menu {
    private List<Movie> movies;

    public Menu(List<Movie> movies) {
        this.movies = movies;
    }

        //Bellow a method to disply list of movies based on user input
        //method called showMoviesByGenre
        // method is void because it disply the list directly in the terminal and it does not return anything
        public void showMoviesByGenre ()
    {
            Scanner scanner = new Scanner(System.in);
            System.out.print("What type of movies would you like to see? (e.g., crime, family, comedy): ");
            String userInput = scanner.nextLine().toLowerCase();

            //bellow is a method where you compare user input into the "genre" you have in your CSV to retun the list of the movies.
            //if the user type something else they will get the message "Sorry, I don't recognize that genre"
            String genre = null;
            if (userInput.contains("crime")) {
                genre = "crime";
            } else if (userInput.contains("family")) {
                genre = "family";
            } else if (userInput.contains("comedy")) {
                genre = "comedy";
            } else if (userInput.contains("action")) {
                genre = "action";
            } else if (userInput.contains("drama")) {
                genre = "drama";
            } else {
                System.out.println("Sorry, I don't recognize that genre.");
                return;
            }
            //once the user input is similar to what we have in the CSV file then a list of the movies belong to that genre will be found
            List<Movie> filteredMovies = new ArrayList<>();
            for (Movie movie : movies) {
                if (movie.getGenre().equals(genre)) {
                    filteredMovies.add(movie);
                }
            }
            //This is a nice to have where you cound how many movies are there for the requested genre
            if (filteredMovies.isEmpty()) {
                System.out.println("\nNo " + genre + " movies found in the database.\n");
            } else {

                //Here a list of the movies will be displyed
                System.out.println("\nHere is a list of " + genre + " movies:\n");
                for (Movie movie : filteredMovies) {
                    System.out.println("- " + movie.getTitle());
                }
            }
        }
    }
