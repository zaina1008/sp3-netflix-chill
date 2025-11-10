import java.util.ArrayList;

public class User {


    String userName;
    String password;
    boolean subscription;

    public User(String userName, String password, boolean subscription) {
        this.userName = userName;
        this.password = password;
        this.subscription = subscription;
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

    public boolean isSubscription() {
        return subscription;
    }

    public void setSubscription(boolean subscription) {
        this.subscription = subscription;
    }


}
