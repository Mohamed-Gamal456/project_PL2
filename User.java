
import java.time.LocalDateTime;

public abstract class User {

    protected int id;
    protected String name;
    protected String email;
    protected String phone;
    protected String password;
    protected LocalDateTime createdAt;
    protected boolean loggedIn;

    public User() {
        this.createdAt = LocalDateTime.now();
    }

    public User(int id, String name, String email, String phone, String password) {
        this();
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getPassword() { return password; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setPassword(String password) { this.password = password; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public boolean login(String email, String password) {
        User user = UserRepository.findByEmail(email);
        if (user != null && user.password.equals(password)) {
            this.loggedIn = true;
            copyFrom(user);
            return true;
        }
        return false;
    }

    protected void copyFrom(User user) {
        this.id = user.id;
        this.name = user.name;
        this.email = user.email;
        this.phone = user.phone;
        this.password = user.password;
        this.createdAt = user.createdAt;
    }

    public void logout() {
        loggedIn = false;
    }

    public void updateProfile(String name, String phone, String password) {
        if (name != null) this.name = name;
        if (phone != null) this.phone = phone;
        if (password != null) this.password = password;

        UserRepository.update(this);
    }
}







