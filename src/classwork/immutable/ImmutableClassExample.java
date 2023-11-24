package classwork.immutable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class ImmutableClassExample {
    private final String name;
    private final String email;
    private final String password;
    private final List<String> userLanguage;

    public ImmutableClassExample(String name, String email, String password, List<String> userLanguage) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.userLanguage = new ArrayList<>(userLanguage);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getUserLanguage() {
        return new ArrayList<>(userLanguage);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImmutableClassExample that = (ImmutableClassExample) o;

        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(email, that.email)) return false;
        if (!Objects.equals(password, that.password)) return false;
        return Objects.equals(userLanguage, that.userLanguage);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (userLanguage != null ? userLanguage.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ImmutableClassExample{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userLanguage=" + userLanguage +
                '}';
    }
}
