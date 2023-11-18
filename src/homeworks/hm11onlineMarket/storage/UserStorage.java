package homeworks.hm11onlineMarket.storage;

import homeworks.hm11onlineMarket.model.enums.UserType;
import homeworks.hm11onlineMarket.model.User;
import homeworks.hm11onlineMarket.util.StorageSerializeUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserStorage implements Serializable {
    private final List<User> USERS = new ArrayList<>();

    public void addUser(User user) {
        USERS.add(user);
        StorageSerializeUtil.serializeUserStorage(this);
    }

    public void printOnlyAllUsers() {
        boolean exist = false;
        for (User user : USERS) {
            if (user.getUserType() == UserType.USER) {
                System.out.println(user);
                exist = true;
            }
        }
        if (!exist) {
            System.out.println("Not users at the moment");
        }
    }

    public User getUserBYEmailAndPassword(String email, String password) {
        for (User user : USERS) {
            if (user != null && user.getEmail() != null && user.getPassword() != null &&
                    user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public User getUserById(String userId) {
        for (User user : USERS) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        return null;
    }


    public boolean isValidEmail(String email) {
        if (!isValidEmailFormat(email)) {
            System.out.println("Invalid email format");
            return false;
        }
        if (isEmailExists(email)) {
            System.out.println(email + " this email already exist");
            return false;
        }
        return true;
    }

    private boolean isValidEmailFormat(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (email.matches(emailRegex)) {
            return true;
        }
        return false;
    }

    private boolean isEmailExists(String email) {
        for (User user : USERS) {
            if (user != null && user.getEmail() != null && user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
}
