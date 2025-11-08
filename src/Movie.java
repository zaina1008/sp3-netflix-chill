import java.time.Year;

public class Movie  extends Media{
    int year;
    public Movie(String title, int year, String genre, double rating) {
        super(title, rating, genre);
        this.year = year;
    }
    public void printInfo() {
        System.out.println(title + " (" + year + ") - " + genre + " - Rating: " + rating);
    }
    public void playMovie() {
        System.out.println(getTitle() + "Movie is playing...");
    }
}