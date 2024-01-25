package as;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class moviecatlog {
   private List<movie> movies;
   public moviecatlog() {
	   this.movies=new ArrayList<>();
   }
   
   public void addmovie(movie m) {
	   movies.add(m);
	   System.out.println("movie added to catelog");
   }
   public void removemovie(movie n) {
	   movies.remove(n);
	   System.out.println("removed movies");
   }
   
   public void displayallmovies() {
	   System.out.println("all avaliable movies");
	   for(movie movi:movies) {
		   System.out.println("* " + movi.getmovie_id()+ ":-" +movi.gettitle());
	   }
   }
   
   public List<movie> findrelesedmoviesixmounth(){
	   LocalDate sixmonthago=LocalDate.now().minusMonths(6);
	   return movies.stream().map(m->m).collect(Collectors.toList());
   }

public movie getMovieById(int movieID) {
	// TODO Auto-generated method stub
	return null;
}
}
