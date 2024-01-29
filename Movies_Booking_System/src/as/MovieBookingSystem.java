package as;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
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
            System.out.println("4. Exit");
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
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 4);
    }

    private static void addMovie(MovieCatalog catalog, Scanner scanner) {
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

        Movie movie = new Movie(movieID, title, genre, releaseDate, duration, availableSeats);
        catalog.addMovie(movie);

        dg.add(movie);
    }

    private static void bookMovie(MovieCatalog catalog, Scanner scanner) {
        if (dg.size() > 0) {
            System.out.print("Enter User ID: ");
            int userId = scanner.nextInt();
            System.out.print("Enter User Name: ");
            String name = scanner.next();
            System.out.print("Enter User Email: ");
            String email = scanner.next();

            User user = new User(userId, name, email);

            System.out.println("Available Movies:");
            catalog.displayAllMovies();

            System.out.print("Enter Movie ID to book: ");
            int movieID = scanner.nextInt();
            Movie selectedMovie = catalog.getMovieById(movieID);

            System.out.print("Enter number of seats to book: ");
            int bookedSeats = scanner.nextInt();

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
        } else {
            System.out.println("Please insert movies.");
        }
    }
}
