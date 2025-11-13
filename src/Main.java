import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Hardcoded users (for testing)
        ArrayList<User> users = new ArrayList<>();
        // users.add(new User("nada", "123456", true)); // ✅ Hardcoded login

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

                    //  Hardcoded login check
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
                        Main m = new Main();
                        m.userOptionsAfterLogin(); // ✅ show menu after login
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


    public void userOptionsAfterLogin() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n1. List movies by genre");
            System.out.println("2. Search movie by name");
            System.out.println("3. Mark movie as watched");
            System.out.println("4. Log out");
            System.out.print("Choose an option: ");

            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Please enter a number between 1–4");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1 -> listMoviesByGenre();
                case 2 -> searchMovieByName();
                case 3 -> {
                    System.out.print("Enter the title of the movie you watched: ");
                    String watchedTitle = scanner.nextLine().trim();
                    System.out.println("Marked \"" + watchedTitle + "\" as watched!");
                }
                case 4 -> {
                    System.out.println("Logging out... bye!");
                    running = false;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void listMoviesByGenre() {
        try {
            Path csvPath = Paths.get("/Users/danarulle/Documents/java/SP3 - Streamingtjeneste/Data_source/movie.csv");

            System.out.println("Looking for the movie file at: " + csvPath.toAbsolutePath());
            if (!Files.exists(csvPath)) {
                Path alt1 = Paths.get("Data_resource/movie.csv");
                Path alt2 = Paths.get("data source", "movie.csv");
                if (Files.exists(alt1)) csvPath = alt1;
                else if (Files.exists(alt2)) csvPath = alt2;
                else {
                    System.out.println("File was not found.");
                    return;
                }
            }

            List<Movie> movies = MovieLoader.load(csvPath);

            Scanner scanner = new Scanner(System.in);
            System.out.print("What type of movies would you like to see? (e.g., crime, family, comedy): ");
            String userInput = scanner.nextLine().trim().toLowerCase();

            String genre = null;
            if (userInput.contains("crime")) genre = "crime";
            else if (userInput.contains("family")) genre = "family";
            else if (userInput.contains("comedy")) genre = "comedy";
            else if (userInput.contains("action")) genre = "action";
            else if (userInput.contains("drama")) genre = "drama";
            else {
                System.out.println("Sorry, I don't recognize that genre.");
                return;
            }

            /*List<Movie> filtered = new ArrayList<>();
            for (Movie m : movies) {
                if (genre.equalsIgnoreCase(m.getGenre())) {
                    filtered.add(m);
                }
            }*/

           /* List<Movie> filtered = new ArrayList<>();
            for (Movie m : movies) {
                if (m.getGenre() != null && m.getGenre().trim().equalsIgnoreCase(genre)) {
                    filtered.add(m);
                }*/
// this is the one working for genre
            List<Movie> filtered = new ArrayList<>();
            for (Movie m : movies) {
                if (m.getGenre() != null) {
                    String[] genres = m.getGenre().split(","); // split multiple genres
                    for (String g : genres) {
                        if (g.trim().equalsIgnoreCase(genre)) {
                            filtered.add(m);
                            break; // stop after first match
                        }
                    }
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

    public static void searchMovieByName() {
        try {
            Path csvPath = Paths.get("/Users/danarulle/Documents/java/SP3 - Streamingtjeneste/Data_source/movie.csv");

            System.out.println("Looking for the movie file at: " + csvPath.toAbsolutePath());
            if (!Files.exists(csvPath)) {
                Path alt1 = Paths.get("Data_resource/movie.csv");
                Path alt2 = Paths.get("data source", "movie.csv");
                if (Files.exists(alt1)) csvPath = alt1;
                else if (Files.exists(alt2)) csvPath = alt2;
                else {
                    System.out.println("File was not found.");
                    return;
                }
            }

            List<Movie> movies = MovieLoader.load(csvPath);

            Scanner scanner = new Scanner(System.in);
            System.out.print("What movie would you like to see? (e.g., \"The Godfather\"): ");
            String movieName = scanner.nextLine().trim().toLowerCase();

            List<Movie> filtered = new ArrayList<>();
            //for (Movie m : movies) {
                //  if (m.getTitle().toLowerCase().contains(movieName)) {
                //  filtered.add(m);
                // }

           // }
            for (Movie m : movies) {
                if (m.getTitle() != null && m.getTitle().toLowerCase().contains(movieName)) {
                    filtered.add(m);
                }
            }


            if (filtered.isEmpty()) {
                System.out.println("\nNo movies matching \"" + movieName + "\" found in the database.");
            } else {
                System.out.println("\nHere is a list of movies that match your search:\n");
                for (Movie movie : filtered) {
                    System.out.println("- " + movie.getTitle());
                }
            }

        } catch (Exception e) {
            System.out.println("Error loading or filtering movies: " + e.getMessage());
        }
    }
}
