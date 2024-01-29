package as;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        if (movies.isEmpty()) {
            System.out.println("No movies available. Please add movies to the catalog.");
        } else {
            System.out.println("All available movies:");
            for (Movie movi : movies) {
                System.out.println("* " + movi.getMovieId() + ":-" + movi.getTitle());
            }
        }
    }

    

    public Movie getMovieById(int movieId) {
        for (Movie movie : movies) {
            if (movie.getMovieId() == movieId) {
                return movie;
            }
        }
        return null;
    }

    public List<Movie> getMovies() {
        return movies;
    }
}

