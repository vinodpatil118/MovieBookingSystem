package as;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovieBookingSystem {
	static int availableSeats;
	
	static ArrayList<movie> dg=new ArrayList<>();
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        moviecatlog catalog = new moviecatlog();
           //ArrayList<movie> dg=new ArrayList<>();
	        int choice;
    
	        do {
	            System.out.println("\nMenu:");
	            System.out.println("1. Add Movie");
	            System.out.println("2. Display All Movies");
	            System.out.println("3. Book a Movie");
	            //System.out.println("4. Display User Details");
	            System.out.println("4. Exit");
	            System.out.print("Enter your choice: ");
	            choice = scanner.nextInt();
           
	            switch (choice) {
	                case 1:
	                    addMovie(catalog, scanner);
	                    break;
	                case 2:
	                    catalog.displayallmovies();
	                    break;
	                case 3:
	                    bookMovie(catalog, scanner);
	                    break;
	                //case 4:
	                  //  displayUserDetails(scanner);
	                   // break;
	                case 4:
	                    System.out.println("Exiting the system. Goodbye!");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please enter a valid option.");
	            }
	        } while (choice != 5);
	    }

	    private static void addMovie(moviecatlog catalog, Scanner scanner) {
	    	//ArrayList<movie> dg=new ArrayList<>();
	        System.out.print("Enter Movie ID: ");
	        int movieID = scanner.nextInt();
	        System.out.print("Enter Movie Title: ");
	        String title = scanner.next();
	        System.out.print("Enter Movie Genre: ");
	        String genre = scanner.next();
	        System.out.print("Enter Release Date (YYYY-MM-DD): ");
	        String releaseDateStr = scanner.next();
	        LocalDate releaseDate = LocalDate.parse(releaseDateStr);
	        System.out.print("Enter Movie Duration (in minutes): ");
	        int duration = scanner.nextInt();
	        System.out.print("Enter Available Seats: ");
	        availableSeats = scanner.nextInt();

	        movie movie = new movie(movieID, title, genre, releaseDate, duration, availableSeats);
	        catalog.addmovie(movie);
	        
			dg.add(movie);
			
			
	    }

	    private static void bookMovie(moviecatlog catalog, Scanner scanner) {
	    	if(dg.size()>0) {
	    		
	    	
	    	
	        System.out.print("Enter User ID: ");
	        int userId = scanner.nextInt();
	        
	        System.out.print("Enter User Name: ");
	        String name = scanner.next();
	        System.out.print("Enter User Email: ");
	        String email = scanner.next();

	        user us = new user(userId, name, email);

	        System.out.println("Available Movies:");
	        catalog.displayallmovies();
	        

	        System.out.print("Enter Movie ID to book: ");
	        int movieID = scanner.nextInt();
	        movie selectedMovie = catalog.getMovieById(movieID);

	        
	            System.out.print("Enter number of seats to book: ");
	            int bookedSeats = scanner.nextInt();
	            //user.bookmovie(selectedMovie, bookedSeats);
	        
	            System.out.println(" movie booked succesfully");
	            System.out.println();
	            
	            System.out.println("this is user details of booked movies");
	            System.out.println();
	            //ArrayList bookedMovies;
				us.displayuserdetails(userId,name,email,new ArrayList<>());
				
				System.out.println();
				System.out.println("This are the Booked Movie Details");
				
				System.out.println();
				//System.out.println(dg);
				List<movie> as=dg.stream().filter(m->m.getmovie_id()==movieID).collect(Collectors.toList());
				System.out.println(as);
				int a= availableSeats;
				int b=bookedSeats;
				int result=a-b;
				availableSeats=result;
				System.out.println();
				System.out.println("Now Avaliable Seats are:-");
				System.out.println(result);
	    	}else {
	    		System.out.println("please insert movies");
	    	}
				
				
	        }
	    
	    
}  

        

	   /* private static void displayUserDetails(Scanner scanner) {
	        System.out.print("Enter User ID: ");
	        int userID = scanner.nextInt();

	        
	        user user = new user(userID, name, email , new ArrayList<>());

	        if (user != null) {
	            user.displayuserdetails();
	        } else {
	            System.out.println("Error: User not found");
	        }
	    }
	}*/

