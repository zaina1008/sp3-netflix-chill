import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;




public class Media {
    String title;
    double rating;
    String genre;

    public Media(String title, double rating, String genre) {
        this.title = title;
        this.rating = rating;
        this.genre = genre;

    }

    public Media() {
    }



    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String readFile(String filePath) {
        String file = "movie.csv";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                for (String value : values) {
                    System.out.print(value + " | ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;

    }

    public void readfile(String s) {
    }
}
