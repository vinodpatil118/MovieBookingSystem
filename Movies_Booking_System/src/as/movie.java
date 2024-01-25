package as;

import java.time.LocalDate;

public class movie {

	private int movie_id;
	private String title;
	private String genre;
	private LocalDate release_date;
	private int duration;
	private int avaliableSeats;
	public movie(int movie_id, String title, String genre, LocalDate localDate, int duration, int avaliabeSeats) {
		super();
		this.movie_id = movie_id;
		this.title = title;
		this.genre = genre;
		this.release_date = localDate;
		this.duration = duration;
		this.avaliableSeats = avaliableSeats;
		
	}
  @Override
	public String toString() {
		return "movie [movie_id=" + movie_id + ", title=" + title + ", genre=" + genre + ", release_date="
				+ release_date + ", duration=" + duration + ", avaliableSeats=" + avaliableSeats + "]";
	}
public void displayMoviesDetails() {
	  System.out.println("movie_id: "+movie_id);
	  System.out.println("title: "+title);
	  System.out.println("genre: "+genre);
	  System.out.println("release_date: "+release_date);
	  System.out.println("duration: "+duration);
	  System.out.println("avaliableSeats: "+avaliableSeats);
  }
  public int getmovie_id() {
	  return movie_id;
  }
  
  public int getavaliableSeats() {
	  return avaliableSeats ;
  }
  
  public String gettitle() {
	  return title;
  }
  
  public LocalDate getrelease_date() {
	  return release_date;
  }
  public void updateavaliableseats(int bookedSeats) {
	  if(bookedSeats<=avaliableSeats) {
		  avaliableSeats-=bookedSeats;
	  }else {
		  System.out.println("Error Not Enough avaliable seats");
	  }
  }
}
