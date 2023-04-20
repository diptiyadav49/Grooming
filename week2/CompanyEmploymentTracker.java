import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CompanyEmploymentTracker {

    // Collection to store employees by their unique ID
    private Map<Integer, Employee> employees;

    public CompanyEmploymentTracker() {
        this.employees = new HashMap<>();
    }

    // Function to add new employees
    public void addEmployee(int id, String name, LocalDate joiningDate, EmploymentType employmentType,
                            String role, EmployeeStatus status) {
        Employee employee = new Employee(id, name, joiningDate, employmentType, role, status);
        employees.put(id, employee);
    }

    // Function to delete employees
    public void deleteEmployee(int id) {
        if (employees.containsKey(id)) {
            Employee employee = employees.get(id);
            employee.setStatus(EmployeeStatus.DISMISS);
        }
    }

    // Function to update employment type of an employee
    public void updateEmploymentType(int id, EmploymentType employmentType) {
        if (employees.containsKey(id)) {
            Employee employee = employees.get(id);
            employee.setEmploymentType(employmentType);
        }
    }

    // Function to update role of an employee
    public void updateRole(int id, String role) {
        if (employees.containsKey(id)) {
            Employee employee = employees.get(id);
            employee.setRole(role);
        }
    }

    // Function to identify senior most employees
    public List<Employee> getSeniorMostEmployees() {
        return employees.values().stream()
                .sorted(Comparator.comparing(Employee::getJoiningDate))
                .collect(Collectors.toList());
    }

    // Function to get employees with a particular status
    public List<Employee> getEmployeesByStatus(EmployeeStatus status) {
        return employees.values().stream()
                .filter(employee -> employee.getStatus() == status)
                .collect(Collectors.toList());
    }

    // Nested class to represent an Employee
    private static class Employee {
        private int id;
        private String name;
        private LocalDate joiningDate;
        private EmploymentType employmentType;
        private String role;
        private EmployeeStatus status;

        public Employee(int id, String name, LocalDate joiningDate, EmploymentType employmentType,
                        String role, EmployeeStatus status) {
            this.id = id;
            this.name = name;
            this.joiningDate = joiningDate;
            this.employmentType = employmentType;
            this.role = role;
            this.status = status;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public LocalDate getJoiningDate() {
            return joiningDate;
        }

        public EmploymentType getEmploymentType() {
            return employmentType;
        }

        public void setEmploymentType(EmploymentType employmentType) {
            this.employmentType = employmentType;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public EmployeeStatus getStatus() {
            return status;
        }

        public void setStatus(EmployeeStatus status) {
            this.status = status;
        }
    }

    // Enumeration to represent Employment Type
    private enum EmploymentType {
        CONTRACT,
        FULL_TIME
    }

    // Enumeration to represent Employee Status
    private enum EmployeeStatus {
        ACTIVE,
        EXIT,
        SERVING_NOTICE,
        DISMISS
    }

    public static void main(String[] args) {
        CompanyEmploymentTracker tracker = new CompanyEmploymentTracker();
    
        // Adding new employees
        tracker.addEmployee(1, "Riya Singh", LocalDate.of(2020, 1, 1), CompanyEmploymentTracker.EmploymentType.CONTRACT, "Developer", CompanyEmploymentTracker.EmployeeStatus.ACTIVE);
        tracker.addEmployee(2, "Rohit Khurana", LocalDate.of(2021, 1, 1), CompanyEmploymentTracker.EmploymentType.FULL_TIME, "Manager", CompanyEmploymentTracker.EmployeeStatus.ACTIVE);
        tracker.addEmployee(3, "Jyoti Singh", LocalDate.of(2021, 4, 1), CompanyEmploymentTracker.EmploymentType.CONTRACT, "Tester", CompanyEmploymentTracker.EmployeeStatus.SERVING_NOTICE);
    
        // Updating employment type and role of an employee
        tracker.updateEmploymentType(1, CompanyEmploymentTracker.EmploymentType.FULL_TIME);
        tracker.updateRole(2, "Senior Manager");
    
        // Deleting an employee
        tracker.deleteEmployee(3);
    
        // Getting the senior most employees
        List<CompanyEmploymentTracker.Employee> seniorMostEmployees = tracker.getSeniorMostEmployees();
        System.out.println("Senior most employees:");
        for (CompanyEmploymentTracker.Employee employee : seniorMostEmployees) {
            System.out.println(employee.getName());
        }
    
        // Getting employees with a particular status
        List<CompanyEmploymentTracker.Employee> activeEmployees = tracker.getEmployeesByStatus(CompanyEmploymentTracker.EmployeeStatus.ACTIVE);
        System.out.println("Active employees:");
        for (CompanyEmploymentTracker.Employee employee : activeEmployees) {
            System.out.println(employee.getName());
        }
    }
    
}
