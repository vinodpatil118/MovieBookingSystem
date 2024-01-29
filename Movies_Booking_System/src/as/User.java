package as;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {

    private int userId;
    private String name;
    private String email;
    private List<Movie> bookedMovies;

    private static Set<Integer> usedUserIDs = new HashSet<>();

    public User(int userId, String name, String email) {
        try {

            if (isUniqueUserID(userId)) {
                this.userId = userId;
            } else {
                throw new IllegalArgumentException("User ID already exists. Please enter a different User ID.");
            }

            this.name = name;

            if (isValidEmail(email)) {
                this.email = email;
            } else {
                throw new IllegalArgumentException("Invalid email format. Please enter a valid email address.");
            }

            this.bookedMovies = new ArrayList<>();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", bookedMovies=" + bookedMovies + "]";
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    private boolean isUniqueUserID(int userId) {
        return usedUserIDs.add(userId);
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void bookMovie(Movie mov, int bookedSeats) {
        try {
            if (bookedSeats <= 0) {
                throw new IllegalArgumentException("Invalid number of seats");
            }

            if (mov.getAvailableSeats() >= bookedSeats) {
                mov.updateAvailableSeats(bookedSeats);
                bookedMovies.add(mov);

                System.out.println("Booking successful!");

            } else {
                throw new RuntimeException("Booking unsuccessful");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayUserDetails() {
        System.out.println("UserId: " + userId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Booked Movies:");
        for (Movie mov : bookedMovies) {
            System.out.println(" +" + mov.getMovieId() + " :" + mov.getTitle());
        }
    }
}




