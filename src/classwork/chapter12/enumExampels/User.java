package classwork.chapter12.enumExampels;

public class User {
    private String username;
    private String password;
    private Language language;

    public User(String username, String password, Language language) {
        this.username = username;
        this.password = password;
        this.language = language;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
