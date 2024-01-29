package as;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MovieCatalog {

    private List<Movie> movies;

    public MovieCatalog() {
        this.movies = new ArrayList<>();
    }

    public void addMovie(Movie m) {
        movies.add(m);
        System.out.println("Movie added to catalog");
    }

    public void removeMovie(Movie n) {
        movies.remove(n);
        System.out.println("Removed movie");
    }

    public void displayAllMovies() {
        System.out.println("All available movies");
        for (Movie movi : movies) {
            System.out.println("* " + movi.getMovieId() + ":-" + movi.getTitle());
        }
    }

    public List<Movie> findReleasedMoviesInLastSixMonths() {
        LocalDate sixMonthsAgo = LocalDate.now().minusMonths(6);
        // Logic to filter movies released in the last six months
        return movies;
    }

    public Movie getMovieById(int movieId) {
        // Placeholder implementation, replace with actual logic
        return null;
    }
}

