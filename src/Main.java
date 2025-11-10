
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        SignUp signUp = new SignUp(users);
        LogIn logIn = new LogIn(users);
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n Welcome to Netflix & Chill ");
            System.out.println("1. Sign Up");
            System.out.println("2. Log In");
            System.out.print("Choose an option: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    signUp.createUser();
                    break;
                case 2:
                    User loggedIn = logIn.loginUser();
                    if (loggedIn != null) {
                        System.out.println("You are now logged in!");
                        // Here you can call your Menu class later
                    }
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
       /* ReadFile readFile = new ReadFile();
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("The Godfather", "crime"));
        movieList.add(new Movie("Finding Nemo", "family"));
        movieList.add(new Movie("Die Hard", "action"));
        movieList.add(new Movie("The Dark Knight", "crime"));
        movieList.add(new Movie("Home Alone", "family"));

        Menu menu = new Menu(movieList);
        menu.showMoviesByGenre();
        ArrayList<Movie> movies = new ArrayList<Movie>();

        ArrayList<String> movieDataLines = readFile.readFile("/Users/danarulle/Documents/java/SP3 - Streamingtjeneste/Data_resource/movie.csv");

        for (int i = 1; i < movieDataLines.size(); i++) {
            Movie movie = new Movie();
            movie.parseDataString(movieDataLines.get(i));
            movies.add(movie);
        }

        System.out.println("tredie film i arraylisten: " + movies.get(2).title);



        ArrayList<String> serieData = readFile.readFile("/Users/danarulle/Documents/java/SP3 - Streamingtjeneste/Data_resource/serie.csv");
        for (int i = 0; i < serieData.size(); i++) {
            if (i == 1) {
                System.out.println(serieData.get(i));
            }
            // del linjen op, så i har isoleret data til jeres attributter i Movie en linje kan se sådan ud: "The Godfather; 1972; Crime, Drama; 9,2;" her skal i først dele linjen på semi-kolon gem det i variabler
            // konverter year og rating til de korrekte datatyper
            // lav ny objekt af Movie med de variabler
            // Movie movie = new Movie("The Godfather", 1972, "Crime, Drama", 9.2);

            // gør noget, for at få delt data op, og konverteret til korrekt datatype (typecasting) og gemt i et Movie objekt. herefter tilføjer i Movie objektet til ArrayListen "movies"
        }
    }*/
