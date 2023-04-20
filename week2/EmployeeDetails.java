import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmployeeDetails {
    private static final String FILENAME = "./employee.txt";
    private static final String DELIMITER = ";";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    
    private List<Employee> employees = new ArrayList<>();
    
    public void readFromFile() throws IOException, ParseException {
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(DELIMITER);
                if (tokens.length == 6) {
                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                Date joiningDate = DATE_FORMAT.parse(tokens[2]);
                // EmploymentType employmentType = EmploymentType.valueOf(tokens[3]);
                String employmentType = tokens[3];
                String role = tokens[4];
                String domain = tokens[5];
                employees.add(new Employee(id, name, joiningDate, employmentType, role, domain));
            } else {
                System.out.println("Invalid line: " + line);
            }
            }
        } finally {
            if (br != null) br.close();
            if (fr != null) fr.close();
        }
    }
    
    public void displayEmployeeDetails(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                System.out.println(employee);
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }
    
    public void displayEmployeesByRole(String role) {
        for (Employee employee : employees) {
            if (employee.getRole().equalsIgnoreCase(role)) {
                System.out.println(employee);
            }
        }
    }
    
    public void displayEmployeesByExperience(int minExperience) {
        Date currentDate = new Date();
        for (Employee employee : employees) {
            long experienceInMilliseconds = currentDate.getTime() - employee.getJoiningDate().getTime();
            long experienceInYears = experienceInMilliseconds / (1000L * 60L * 60L * 24L * 365L);
            if (experienceInYears >= minExperience) {
                System.out.println(employee);
            }
        }
    }
    
    public static void main(String[] args) {
        EmployeeDetails handler = new EmployeeDetails();
        try {
            handler.readFromFile();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return;
        }
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter 1 to display employee details by ID.");
            System.out.println("Enter 2 to display employees by role.");
            System.out.println("Enter 3 to display employees by minimum years of experience.");
            System.out.println("Enter 4 to exit.");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter employee ID:");
                    int id = scanner.nextInt();
                    handler.displayEmployeeDetails(id);
                    break;
                case 2:
                    System.out.println("Enter employee role:");
                    String role = scanner.next();
                    handler.displayEmployeesByRole(role);
                    break;
                case 3:
                    System.out.println("Enter minimum years of experience:");
                    int minExperience = scanner.nextInt();
                    handler.displayEmployeesByExperience(minExperience);
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                System.out.println("Invalid choice!");
            }
    
            System.out.println("\nEnter your choice:");
            System.out.println("1. Display employee details by ID");
            System.out.println("2. Display employees by role");
            System.out.println("3. Display employees by minimum years of experience");
            System.out.println("4. Exit");
    
            choice = scanner.nextInt();
        }
        // System.out.println("Exiting program...");
    }
}
