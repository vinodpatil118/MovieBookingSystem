package as;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class user {
	private int userId;
  private String name;
  private String email;
  private List<movie> bookedMovies;
  
  private static Set<Integer> usedUserIDs = new HashSet<>();
  public user(int userId, String name, String email) {
      // Check if the user ID is unique
      if (isUniqueUserID(userId)) {
          this.userId = userId;
      } else {
          throw new IllegalArgumentException("User ID already exists. Please enter a different User ID.");
      }
      this.name = name;
      if (isValidEmail(email)) {
          this.email = email;
      } else {
          throw new IllegalArgumentException("Invalid email format");
      }

      this.bookedMovies = new ArrayList<>();
  }
	
	
	
	

@Override
public String toString() {
	return "user [userId=" + userId + ", name=" + name + ", email=" + email + ", bookedMovies=" + bookedMovies + "]";
	
	
}

   public int getuserId() {
	    return userId;
   }
   
   public String getname() {
	   return name;
   }
   public String getemail() {
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
   
   
public void bookmovie(movie mov,int bookedSeats) {
	try {
		if(bookedSeats<=0) {
			throw new IllegalArgumentException("invalid number of seats");
		}
		
		if(mov.getavaliableSeats()>=bookedSeats) {
			mov.updateavaliableseats(bookedSeats);
			bookedMovies.add(mov);
			
			System.out.println("Booking successful!");
			
		}else {
			throw new RuntimeException("Booking successfull");
		}
	}catch(IllegalArgumentException e) {
		System.out.println( e.getMessage());
		
	}catch (RuntimeException e) {
		System.out.println(e.getMessage());
	}
	
		
			
		
	}


 public void displayuserdetails(int userID2, String name2, String email2, ArrayList arrayList) {
	 System.out.println("userId: "+userId);
	 System.out.println("name: "+name);
	 System.out.println("email: "+email);
	 System.out.println("booked movies");
	 for(movie mov:bookedMovies) {
		 System.out.println(" +" +mov.getmovie_id()+" :"+mov.gettitle());
	 }
 }
 
  
}




