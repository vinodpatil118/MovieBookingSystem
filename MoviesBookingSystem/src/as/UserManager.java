package as;


import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private List<User> users;

    public UserManager() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        if (user == null) {
            throw new MovieBookingException("User cannot be null.");
        }
        users.add(user);
        System.out.println("User added to the system");
    }

    public void removeUser(User user) {
        users.remove(user);
        System.out.println("User removed from the system");
    }

    public void displayAllUsers() {
        System.out.println("All users: ");
        for (User user : users) {
            System.out.println("- " + user.getUserId() + " :" + user.getName());
        }
    }
}
