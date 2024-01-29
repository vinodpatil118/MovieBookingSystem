package as;

import java.time.LocalDate;



public class Movie {

	private int movieId;
	private String title;
	private String genre;
	private LocalDate releaseDate;
	private int duration;
	private int availableSeats;

	public Movie(int movieId, String title, String genre, LocalDate releaseDate, int duration, int availableSeats) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.duration = duration;
		this.availableSeats = availableSeats;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", title=" + title + ", genre=" + genre + ", releaseDate=" + releaseDate
				+ ", duration=" + duration + ", availableSeats=" + availableSeats + "]";
	}

	public void displayMovieDetails() {
		System.out.println("movieId: " + movieId);
		System.out.println("title: " + title);
		System.out.println("genre: " + genre);
		System.out.println("releaseDate: " + releaseDate);
		System.out.println("duration: " + duration);
		System.out.println("availableSeats: " + availableSeats);
	}

	public int getMovieId() {
		return movieId;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public String getTitle() {
		return title;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void updateAvailableSeats(int bookedSeats) {
		if (bookedSeats <= availableSeats) {
			availableSeats -= bookedSeats;
		} else {
			System.out.println("Error: Not Enough available seats");
		}
	}
}

