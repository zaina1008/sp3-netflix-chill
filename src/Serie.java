import java.util.ArrayList;

// klassenavne starter med Stort, metodenavne skrives i camelCase, ligesom variabelnavne også skrives i camelCase

// git commit -am "commit message"
// git push

public class Serie extends Media{
    int season;
    int episode;
    int startYear;
    int endYear;

    public Serie(String title, double rating, String genre, int season, int episode, int startYear, int endYear) {
        super(title, rating, genre);
        this.season = season;
        this.episode = episode;
        this.startYear = startYear;
        this.endYear = endYear;

    }

    public int getSeason() {
        return season;
    }

    public int getEpisode() {
        return episode;
    }

    public int getStartYear(){
        return startYear; }

    public int getEndYear() {
        return endYear;
    }


    public void printInfo() {
        System.out.println(title + " (" + startYear + ") + (" + endYear + ") - " + genre + " - Rating: " + rating);
    }

    public void playSerie() {
        System.out.println(getTitle() + "Serie is playing...");
    }
}


