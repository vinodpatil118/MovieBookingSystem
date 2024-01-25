package as;

public class booking {
   private int bookingid;
   private String dateandtime;
   private movie bookedmovie;
   private user bookinguser;
public booking(int bookingid, String dateandtime, movie bookedmovie, user bookinguser) {
	super();
	this.bookingid = bookingid;
	this.dateandtime = dateandtime;
	this.bookedmovie = bookedmovie;
	this.bookinguser = bookinguser;
	
}
   

  @Override
public String toString() {
	return "booking [bookingid=" + bookingid + ", dateandtime=" + dateandtime + ", bookedmovie=" + bookedmovie
			+ ", bookinguser=" + bookinguser + "]";
}


public void displaybooking() {
	  System.out.println("bookingid: "+bookingid);
	  System.out.println("date and time: "+dateandtime);
	  System.out.println("bookedmovie: "+bookedmovie);
	  System.out.println("bookinguser: "+bookinguser);
  }
}
