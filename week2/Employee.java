import java.util.Date;

public class Employee {
    private int id;
    private String name;
    private Date joiningDate;
    private String employmentType;
    private String role;
    private String domain;

    // Constructor
    public Employee(int id, String name, Date joiningDate, String employmentType, String role, String domain) {
        this.id = id;
        this.name = name;
        this.joiningDate = joiningDate;
        this.employmentType = employmentType;
        this.role = role;
        this.domain = domain;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    // toString method to print Employee details
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", joiningDate=" + joiningDate +
                ", employmentType='" + employmentType + '\'' +
                ", role='" + role + '\'' +
                ", domain='" + domain + '\'' +
                '}';
    }
}
