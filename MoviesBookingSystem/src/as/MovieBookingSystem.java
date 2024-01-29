package as;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;





public class MovieBookingSystem {
    static int availableSeats;
    static ArrayList<Movie> dg = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieCatalog catalog = new MovieCatalog();

        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Movie");
            System.out.println("2. Display All Movies");
            System.out.println("3. Book a Movie");
            System.out.println("4. Remove a Movie");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addMovie(catalog, scanner);
                    break;
                case 2:
                    catalog.displayAllMovies();
                    break;
                case 3:
                    bookMovie(catalog, scanner);
                    break;
                case 4:
                    removeMovie(catalog, scanner);
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 5);
    }

    private static void addMovie(MovieCatalog catalog, Scanner scanner) {
    	
    	
    	System.out.print("Enter Movie ID (Please Provide An Integer): ");
        
        int movieID = scanner.nextInt();
        System.out.print("Enter Movie Title(Please Provide A String): ");
        String title = scanner.next();
        System.out.print("Enter Movie Genre(Please Provide A String): ");
        String genre = scanner.next();
        System.out.print("Enter Release Date (YYYY-MM-DD): ");
        String releaseDateStr = scanner.next();
        LocalDate releaseDate = LocalDate.parse(releaseDateStr);
        System.out.print("Enter Movie Duration (in minutes): ");
        int duration = scanner.nextInt();
        System.out.print("Enter Available Seats: ");
        availableSeats = scanner.nextInt();

        Movie movie = new Movie(movieID, title, genre, releaseDate, duration, availableSeats);
        catalog.addMovie(movie);

        dg.add(movie);
    }

    private static void removeMovie(MovieCatalog catalog, Scanner scanner) {
        if (dg.size() > 0) {
            System.out.print("Enter Movie ID to remove: ");
            int movieID = scanner.nextInt();

            List<Movie> matchingMovies = dg.stream()
                    .filter(m -> m.getMovieId() == movieID)
                    .collect(Collectors.toList());

            if (!matchingMovies.isEmpty()) {
                Movie removedMovie = matchingMovies.get(0);
                catalog.removeMovie(removedMovie);
                dg.remove(removedMovie);

                System.out.println("Movie removed successfully");
            } else {
                System.out.println("Movie with ID " + movieID + " not found.");

                
                System.out.print("Available Movie IDs: ");
                dg.forEach(movie -> System.out.print(movie.getMovieId() + " "));
                System.out.println();

                
                System.out.print("Enter an available Movie ID: ");
                int newMovieID = scanner.nextInt();

                
                removeMovie(catalog, scanner);
            }
        } else {
            System.out.println("No movies available. Please add movies to the catalog.");
        }
    }

    private static void bookMovie(MovieCatalog catalog, Scanner scanner) {
        if (dg.size() > 0) {
            System.out.print("Enter User ID(Please Provide An Integer): ");
            int userId = scanner.nextInt();
            System.out.print("Enter User Name(Please Provide A String): ");
            String name = scanner.next();
            System.out.print("Enter User Email: ");
            String email = scanner.next();

            User user = new User(userId, name, email);

            catalog.displayAllMovies();

            boolean validMovieSelection = false;

            do {
                System.out.print("Enter Movie ID to book: ");
                int movieID = scanner.nextInt();

                Movie selectedMovie = catalog.getMovieById(movieID);

                if (selectedMovie != null && selectedMovie.getAvailableSeats() > 0) {
                    System.out.print("Enter number of seats to book: ");
                    int bookedSeats = scanner.nextInt();

                    if (selectedMovie.getAvailableSeats() >= bookedSeats) {
                        selectedMovie.updateAvailableSeats(bookedSeats);
                        user.bookMovie(selectedMovie, bookedSeats);

                        System.out.println("Movie booked successfully");
                        System.out.println();

                        System.out.println("User details of booked movies:");
                        System.out.println();
                        user.displayUserDetails();

                        System.out.println();
                        System.out.println("Booked Movie Details:");
                        System.out.println();
                        List<Movie> as = dg.stream()
                                .filter(m -> m.getMovieId() == movieID)
                                .collect(Collectors.toList());
                        System.out.println(as);

                        int result = availableSeats - bookedSeats;
                        availableSeats = result;
                        System.out.println();
                        System.out.println("Now Available Seats are: " + result);

                        validMovieSelection = true;
                    } else {
                        System.out.println("Not enough available seats. Please choose a different number of seats.");
                    }
                } else {
                    System.out.println("Invalid movie selection. Please enter a valid Movie ID.");

                   
                    System.out.print("Available Movie IDs: ");
                    dg.forEach(movie -> System.out.print(movie.getMovieId() + " "));
                    System.out.println();

                    
                    System.out.print("Enter an available Movie ID: ");
                    int newMovieID = scanner.nextInt();

                    
                    selectedMovie = catalog.getMovieById(newMovieID);
                }
            } while (!validMovieSelection);
        } else {
            System.out.println("No movies available. Please add movies to the catalog.");
        }
    }
}




