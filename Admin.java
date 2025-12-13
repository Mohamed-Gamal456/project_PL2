import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Admin extends User {
     private static final String CUSTOMERS_FILE = "customers.txt";
    private static final String PM_FILE = "project_managers.txt";
    private static final String PROVIDERS_FILE = "service_providers.txt";
    private static final String ADMINS_FILE = "admins.txt";
    String role;
    Admin(){
        this.createAt = LocalDateTime.now();
    }
    Admin( int id, String name, String email, String phone, String password, String role ){
        super(id, name, email, phone, password);
        this.createAt = LocalDateTime.now();
        this.role = role;
    }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    //-----------------------add User--------------------------------------
    public static boolean addUser(User user) {

        String fileName = getFileNameForUser(user);

        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName, true))) {

            pw.println(user.getId() + " | " +
                       user.getName() + " | " +
                       user.getEmail() + " | " +
                       user.getPhone() + " | " +
                       user.getPassword());

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    //----------------------delete User----------------------------
    public static boolean deleteUser(int id, String type) {

        String fileName = getFileNameByType(type);

        try {
            File file = new File(fileName);
            if (!file.exists()) return false;

            List<String> lines = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                int fileId = Integer.parseInt(parts[0].trim());

                if (fileId != id)
                    lines.add(line);
            }

            br.close();

            PrintWriter pw = new PrintWriter(new FileWriter(file));
            for (String l : lines) pw.println(l);
            pw.close();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    //---------------------------update User-------------------------
    public static boolean updateUser(User user) {

        String fileName = getFileNameForUser(user);

        try {
            File file = new File(fileName);
            if (!file.exists()) return false;

            List<String> lines = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;

            while ((line = br.readLine()) != null) {

                String[] parts = line.split("\\|");
                int fileId = Integer.parseInt(parts[0].trim());

                if (fileId == user.getId()) {

                    String updated = user.getId() + " | " +
                            user.getName() + " | " +
                            user.getEmail() + " | " +
                            user.getPhone() + " | " +
                            user.getPassword();

                    lines.add(updated);

                } else {
                    lines.add(line);
                }
            }

            br.close();

            PrintWriter pw = new PrintWriter(new FileWriter(file));
            for (String l : lines) pw.println(l);
            pw.close();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    //--------------------------- receive Request -------------------------
    public static void  receiveRequest(int requestID ){
        ServiceRequest req = RequestRepository.findById(requestID);                           // method in ProjectManager
        if (req == null) {
            System.out.println("Request not found.");
            return;
        }

            System.out.println("Admin received request: " + req.getRequestDetails());
    }
    //---------------------------  forward Request To PM -------------------------
    public static void forwardRequestToPM(int requestID , int pmID ) {
        ServiceRequest req = RequestRepository.findById(requestID);
        if (req == null) {
            System.out.println("Request not found.");
            return;
        }

        ProjectManager pm = UserRepository.findPMById(pmID);                                       // method in ProjectManager
        if (pm == null) {
            System.out.println("PM not found.");
            return;
        }

        req.setPm(pm);
        pm.addRequest(req);

        System.out.println("Request " + requestID + " forwarded to PM " + pmID + ".");   
    }
    //-------------------------- get File Name For User ------------------------------
    private static String getFileNameForUser(User user) {
        if (user instanceof Customer) return CUSTOMERS_FILE;
        if (user instanceof ProjectManager) return PM_FILE;
        if (user instanceof ServiceProvider) return PROVIDERS_FILE;
        if (user instanceof Admin) return ADMINS_FILE;
        return "";
    }
    
    //-------------------------- get File Name By Type ------------------------------
    private static String getFileNameByType(String type) {
        switch (type.toLowerCase()) {
            case "customer": return CUSTOMERS_FILE;
            case "pm": return PM_FILE;
            case "provider": return PROVIDERS_FILE;
            case "admin": return ADMINS_FILE;
        }
        return "";
    }
    
    @Override
    public boolean login() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void logout() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void updateProfil() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
