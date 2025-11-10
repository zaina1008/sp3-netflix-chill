import java.util.ArrayList;
import java.util.Scanner;

public class LogIn {
    private ArrayList<User> users; //  creates a variable that can hold a list of User objects.

    public LogIn(ArrayList<User> users) {
        this.users = users;
    }

    public User loginUser() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = input.next(); // input username

        System.out.print("Enter password: ");
        String password = input.next(); // input pasword

// loop checks every user in the list
        for (User u : users) {
            if (u.getUserName().equals(username) && u.getPassword().equals(password)) {
                System.out.println("Login successful! Welcome " + username);
                return u;

                //Loop through each user in the list.
                //Check if the username and password match the input.
                //If a match is found: print a welcome message and return that user.
            }
        }
        System.out.println("Invalid username or password."); // prints error massage if no user match found
        return null; // indicate login fail
    }
}

