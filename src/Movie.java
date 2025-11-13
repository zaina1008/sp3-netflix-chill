import java.time.Year;

public class Movie  extends Media {
    int year;
    public Movie() {

    }
    public Movie(String title, int year, String genre, double rating) {
        super(title, rating, genre);
        this.year = year;
    }
    public String getGenre() {
        return genre;
    }
    public void printInfo() {
        System.out.println(title + " (" + year + ") - " + genre + " - Rating: " + rating);
    }

    public void playMovie() {
        System.out.println(getTitle() + "Movie is playing...");
    }

    public void parseDataString(String line) {
        /*// System.out.println(line);
        String[] parts = line.split(";");
        this.title = parts[0].trim();
        this.year = Integer.parseInt(parts[1].trim());
        this.genre = parts[2].trim();
        this.rating = Double.parseDouble(parts[3].trim().replace(",", "."));
        // System.out.println("title: " + title + " | year: " + year + " | genre: " + genre + " | rating: " + rating);
*/
        //this is the one working
        String[] parts = line.split(";");
        this.title = parts[0].trim();
        this.year = Integer.parseInt(parts[1].trim());
        this.genre = parts[2].trim().toLowerCase(); // lowercase
        this.rating = Double.parseDouble(parts[3].trim().replace(",", "."));
    }
}