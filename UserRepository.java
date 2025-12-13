import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository{

    private static final String CUSTOMERS_FILE = "customers.txt";
    private static final String PM_FILE = "project_managers.txt";
    private static final String PROVIDERS_FILE = "service_providers.txt";
    private static final String ADMINS_FILE = "admins.txt";

    // ------------------- FIND USER BY EMAIL -------------------------------
    public static User findByEmail(String email) {

        User user;

        user = readUserFromFile(CUSTOMERS_FILE, email, "customer");
        if (user != null) return user;

        user = readUserFromFile(PM_FILE, email, "pm");
        if (user != null) return user;

        user = readUserFromFile(PROVIDERS_FILE, email, "provider");
        if (user != null) return user;

        user = readUserFromFile(ADMINS_FILE, email, "admin");
        if (user != null) return user;

        return null;
    }
    // ------------------- read User From File -------------------------------
    private static User readUserFromFile(String fileName, String targetEmail, String type) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = br.readLine()) != null) {

                String[] parts = line.split("\\|");

                if (parts.length < 5) continue;

                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                String email = parts[2].trim();
                String phone = parts[3].trim();
                String password = parts[4].trim();

                if (!email.equals(targetEmail)) continue;

                switch (type) {
                    case "customer":
                        return new Customer(id, name, email, phone, password);
                    case "pm":
                        return new ProjectManager(id, name, email, phone, password);
                    case "provider":
                        return new ServiceProvider(id, name, email, phone, password);
                    case "admin":
                        return new Admin(id, name, email, phone, password, "admin");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
  