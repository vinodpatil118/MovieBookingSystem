package as;

public class Booking {

    private int bookingId;
    private String dateAndTime;
    private Movie bookedMovie;
    private User bookingUser;

    public Booking(int bookingId, String dateAndTime, Movie bookedMovie, User bookingUser) {
        super();
        this.bookingId = bookingId;
        this.dateAndTime = dateAndTime;
        this.bookedMovie = bookedMovie;
        this.bookingUser = bookingUser;
    }

    @Override
    public String toString() {
        return "Booking [bookingId=" + bookingId + ", dateAndTime=" + dateAndTime + ", bookedMovie=" + bookedMovie
                + ", bookingUser=" + bookingUser + "]";
    }

    public void displayBooking() {
        System.out.println("BookingId: " + bookingId);
        System.out.println("Date and Time: " + dateAndTime);
        System.out.println("Booked Movie: " + bookedMovie);
        System.out.println("Booking User: " + bookingUser);
    }
}

