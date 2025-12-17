public class Admin extends User {

    private String role;

    public Admin() {
        super();
    }

    public Admin(int id, String name, String email,
                 String phone, String password, String role) {
        super(id, name, email, phone, password);
        this.role = role;
    }

    // ------------------- role -------------------
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // ------------------- user management -------------------

    // add new user (Customer / PM / Provider / Admin)
    public void addUser(User user) {
        UserRepository.save(user);
    }

    // update any user by admin (as UML)
    public void updateUser(int userId, String type,
                           String name, String phone, String password) {

        User user = UserRepository.findById(userId, type);
        if (user == null) return;

        if (name != null && !name.isEmpty())
            user.setName(name);

        if (phone != null && !phone.isEmpty())
            user.setPhone(phone);

        if (password != null && !password.isEmpty())
            user.setPassword(password);

        UserRepository.update(user);
    }

    // delete user
    public void deleteUser(int userId, String type) {
        UserRepository.delete(userId, type);
    }

    // ------------------- requests -------------------

    public void receiveRequest(ServiceRequest request) {
        if (request == null) return;
        System.out.println("Admin received request:");
        System.out.println(request.getRequestDetails());
    }

    public void forwardRequestToPM(ServiceRequest request,
                                   ProjectManager pm) {
        if (request == null || pm == null) return;
        request.setPm(pm);
        pm.addRequest(request);
    }
}
