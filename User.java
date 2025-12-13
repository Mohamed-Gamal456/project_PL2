import java.time.LocalDateTime;

public abstract class User {

    protected int id;
    protected String name;
    protected String email;
    protected String phone;
    protected String password;
    protected LocalDateTime createdAt;
    protected boolean isLoggedIn = false;

    public User() {
        this.createdAt = LocalDateTime.now();
    }

    public User(int id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.createdAt = LocalDateTime.now();
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

    // ---------------------------- login -----------------------------------------
    public boolean login(String email, String password) {

        User found = UserRepository.findByEmail(email);
        if (found == null) {
            return false;
        }

        if (found.getPassword().equals(password)) {
            this.isLoggedIn = true;
            return true;
        }

        return false;
    }

    // ---------------------------- logout -----------------------------------------
    public void logout() {
        if (this.isLoggedIn) {
            this.isLoggedIn = false;
            System.out.println("Logged out successfully.");
        } else {
            System.out.println("User is already logged out.");
        }
    }

    // ---------------------------- update Profile -----------------------------------
    public void updateProfile(String newName, String newPhone, String newPassword) {

        if (newName != null && !newName.isEmpty())
            this.setName(newName);

        if (newPhone != null && !newPhone.isEmpty())
            this.setPhone(newPhone);

        if (newPassword != null && !newPassword.isEmpty())
            this.setPassword(newPassword);

        boolean updated = Admin.updateUser(this);

        if (updated)
            System.out.println("Profile updated successfully.");
        else
            System.out.println("Failed to update profile.");
    }
}
