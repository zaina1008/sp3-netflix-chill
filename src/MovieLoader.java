import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MovieLoader {
    private MovieLoader() {}

    public static List<Movie> load(Path csvPath) throws IOException {
        List<Movie> movies = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(csvPath)) {
            String line;
            boolean first = true;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                // If the first line looks like a header, skip it
                if (first && line.toLowerCase().startsWith("title;") ) {
                    first = false;
                    continue;
                }
                first = false;
// coden virkede efter vi lavde en try catch
                // Simple split (works if fields do not contain commas inside quotes)
                //String[] parts = line.split(",", -1);
                //String title = parts.length > 0 ? parts[0] : "";
                //String genre = parts.length > 1 ? parts[1] : "";
                //movies.add(new Movie(title, genre));

                try {
                    Movie movie = new Movie();
                    movie.parseDataString(line);
                    movies.add(movie);
                } catch (Exception e) {
                    System.out.println("⚠️ Skipping invalid line: " + line);
                }
            }
        }


        return movies;
    }
}
