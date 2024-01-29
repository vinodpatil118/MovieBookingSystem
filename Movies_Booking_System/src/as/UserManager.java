package as;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private List<User> users;

    public UserManager() {
        this.users = new ArrayList<>();
    }

    public void addUser(User u) {
        users.add(u);
        System.out.println("User added to the system");
    }

    public void removeUser(User n) {
        users.remove(n);
        System.out.println("User removed from the system");
    }

    public void displayAllUsers() {
        System.out.println("All users: ");
        for (User un : users) {
            System.out.println("- " + un.getUserId() + " :" + un.getName());
        }
    }
}

