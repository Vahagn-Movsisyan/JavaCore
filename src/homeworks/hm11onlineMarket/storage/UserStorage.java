package homeworks.hm11onlineMarket.storage;

import homeworks.hm11onlineMarket.model.enums.UserType;
import homeworks.hm11onlineMarket.model.User;
import homeworks.hm11onlineMarket.util.StorageSerializeUtil;

import java.io.Serializable;

public class UserStorage implements Serializable {
    private User[] users = new User[10];
    private int size;

    public void addUser(User user) {
        if (users.length == size) {
            extend();
        }
        users[size++] = user;
        StorageSerializeUtil.serializeUserStorage(this);
    }

    public void printOnlyAllUsers() {
        boolean exist = false;
        for (int i = 0; i < size; i++) {
            if (users[i].getUserType() == UserType.USER && size >= 1) {
                System.out.println(users[i]);
                exist = true;
            }
        }
        if (!exist) {
            System.out.println("Not users at the moment");
        }
    }

    public User getUserBYEmailAndPassword(String email, String password) {
        for (int i = 0; i < size; i++) {
            if (users[i] != null && users[i].getEmail() != null && users[i].getPassword() != null &&
                    users[i].getEmail().equals(email) && users[i].getPassword().equals(password)) {
                return users[i];
            }
        }
        return null;
    }

    public User getUserById(String userId) {
        for (int i = 0; i < size; i++) {
            if (users[i].getId().equals(userId)) {
                return users[i];
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
        for (int i = 0; i < size; i++) {
            if (users[i] != null && users[i].getEmail() != null && users[i].getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    private void extend() {
        User[] tmp = new User[users.length + 10];
        System.arraycopy(users, 0, tmp, 0, users.length);
        users = tmp;
    }
}
