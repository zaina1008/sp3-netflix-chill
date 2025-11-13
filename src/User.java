import java.util.ArrayList;

public class User {


    String userName;
    String password;

    ArrayList<Movie> watchedMovies;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.watchedMovies = new ArrayList<Movie>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
