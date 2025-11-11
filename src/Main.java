
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Hardcoded users (for testing)
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("nada", "123456", true)); // ✅ Hardcoded login

        // Your existing SignUp and LogIn objects (optional if they depend on this list)
        SignUp signUp = new SignUp(users);
        LogIn logIn = new LogIn(users);
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to Netflix & Chill");
            System.out.println("1. Sign Up");
            System.out.println("2. Log In");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice;
            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine(); // consume newline
            } else {
                System.out.println("Please enter a number (1-3).");
                input.nextLine();
                continue;
            }

            switch (choice) {
                case 1 -> {
                    // Sign up adds to the same users list
                    signUp.createUser();
                }

                case 2 -> {
                    System.out.print("Enter username: ");
                    String username = input.nextLine().trim();
                    System.out.print("Enter password: ");
                    String password = input.nextLine().trim();

                    // ✅ Hardcoded login check
                    boolean validLogin = false;
                    for (User u : users) {
                        if (u.getUserName().equalsIgnoreCase(username) &&
                                u.getPassword().equals(password)) {
                            validLogin = true;
                            break;
                        }
                    }

                    if (validLogin) {
                        System.out.println("You are now logged in!");
                        listMoviesByGenre(); // ✅ Show movies after login
                    } else {
                        System.out.println("Invalid username or password. Try again.");
                    }
                }

                case 3 -> {
                    System.out.println("Goodbye!");
                    input.close();
                    return;
                }

                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    // ✅ Existing method unchanged
    public static void listMoviesByGenre() {
        try {
            Path csvPath = Paths.get("/Users/danarulle/Documents/java/SP3 - Streamingtjeneste/Data_source/movie.csv");

            System.out.println("looking for the movie file " + csvPath.toAbsolutePath());
            if (!Files.exists(csvPath)){
                Path alt1 =Paths.get("data source", "movie.csv");
                Path alt2 = Paths.get("Data_source/movie.csv");
                if (Files.exists(alt1)) csvPath = alt1;
                        else if (Files.exists(alt2)) csvPath = alt2;
                        else {
                            System.out.println("file does not found ");
                            return;
                }
            }

            List<Movie> movies = MovieLoader.load(csvPath);

            Scanner scanner = new Scanner(System.in);
            System.out.print("What type of movies would you like to see? (e.g., crime, family, comedy): ");
            String userInput = scanner.nextLine().trim().toLowerCase();

            String genre = null;
            if (userInput.contains("crime"))       genre = "crime";
            else if (userInput.contains("family")) genre = "family";
            else if (userInput.contains("comedy")) genre = "comedy";
            else if (userInput.contains("action")) genre = "action";
            else if (userInput.contains("drama"))  genre = "drama";
            else {
                System.out.println("Sorry, I don't recognize that genre.");
                return;
            }

            List<Movie> filtered = new ArrayList<>();
            for (Movie m : movies) {
                if (genre.equalsIgnoreCase(m.getGenre())) {
                    filtered.add(m);
                }
            }

            if (filtered.isEmpty()) {
                System.out.println("\nNo " + genre + " movies found in the database.");
            } else {
                System.out.println("\nHere is a list of " + genre + " movies:\n");
                for (Movie movie : filtered) {
                    System.out.println("- " + movie.getTitle());
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading or filtering movies: " + e.getMessage());
        }
    }
}