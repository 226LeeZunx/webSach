package murach.general;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import murach.entity.User;

public class UserPool {
    private List<User> users;

    public UserPool() {
        this.users = new ArrayList<>();
        initData();
    }

    private void initData() {
        users.add(new User(
            "admin", 
            "admin123", 
            "admin@example.com", 
            "2024-01-01", 
            "Nguyen", 
            "Quan Tri", 
            true, 
            "ADMIN"
        ));

        users.add(new User(
            "student01", 
            "pass123", 
            "student01@example.com", 
            "2024-02-15", 
            "Tran", 
            "Van A", 
            true, 
            "USER"
        ));

        users.add(new User(
            "teacher01", 
            "pass456", 
            "teacher01@example.com", 
            "2024-03-20", 
            "Le", 
            "Thi B", 
            false, 
            "USER"
        ));
    }


    public List<User> getAllUsers() {
        return users;
    }

    public User getUserByAccount(String account) {
        return users.stream().filter(u->u.getUserAccount().equals(account)).findFirst().orElse(null);
    }
    public boolean addUser(String userFirstName, String userLastName, boolean isMale, String email, String userAccount, String userPass) {
        if (getUserByAccount(userAccount) != null) {
            return false; 
        }


        String createDate = LocalDate.now().toString();

        String role = "USER";

        User newUser = new User( userAccount, userPass, email, createDate, userFirstName, userLastName, isMale, role);
        users.add(newUser);
        
        return true; 
    }
}