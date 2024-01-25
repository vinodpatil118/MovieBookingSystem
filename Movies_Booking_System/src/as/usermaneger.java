package as;

import java.util.ArrayList;
import java.util.List;

public class usermaneger {
  private List<user> users;
  public usermaneger() {
	  this.users=new ArrayList<>();
	  
  }
  
  public void adduser(user u) {
	  users.add(u);
	  System.out.println("user added to the system");
  }
  
  public void removeuser(user n) {
	  users.remove(n);
	  System.out.println("user removed the system");
  }
  
  public void displayalluser() {
	  System.out.println("all user: ");
	  for(user un:users) {
		  System.out.println("- "+ un.getuserId() +" :" + un.getname());
	  }
  }
}
