import java.util.InputMismatchException;
import java.util.Scanner;

enum Technology {
    JAVA(8, "MANAGER", 0.45),
    SAP(4, "SR.ASSOCIATE", 0.30),
    QA(3, "ASSOCIATE", 0.20);

    private final int minExp;
    private final String role;
    private final double increment;

    Technology(int minExp, String role, double increment) {
        this.minExp = minExp;
        this.role = role;
        this.increment = increment;
    }

    public int getMinExp() {
        return minExp;
    }

    public String getRole() {
        return role;
    }

    public double getIncrement() {
        return increment;
    }
}

public class EnumsQue {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter technology stack (JAVA, SAP, QA): ");
        String techStr = input.nextLine().toUpperCase();
        Technology tech = null;
        try {
            tech = Technology.valueOf(techStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Sorry, Currently we are not hiring for this role.");
            System.exit(0);
        }
        System.out.print("Enter years of experience: ");
        int exp = input.nextInt();
        input.nextLine(); // Consume newline character
        if (exp < tech.getMinExp()) {
            System.out.println("Minimum " + tech.getMinExp() + " years of experience required.");
            System.exit(0);
        }
        int salary = 0;
        while (true) {
            System.out.print("Enter current salary: ");
            try {
                salary = input.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number for salary.");
                input.nextLine(); // Consume invalid input
            }
        }
        input.close();

        String role = tech.getRole();
        double increment = tech.getIncrement();
        for (int i = 0; i < tech.ordinal(); i++) {
            increment *= increment;
        }
        double newSalary = salary * (1 + increment);
        System.out.println("Role: " + role);
        System.out.println("Expected salary: " + newSalary);
    }

}
