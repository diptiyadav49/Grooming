import java.util.Scanner;

public class UsernameGenerator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // user input
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        System.out.print("Enter your date of birth (dd-mm-yyyy): ");
        String dob = input.nextLine();
        System.out.print("Enter your Aadhar card number: ");
        String aadhar = input.nextLine();

        input.close();

        try {
            // Validate name
            if (name.isEmpty() || !name.matches("^[a-zA-Z ]*$")) {
                throw new Exception("Invalid name. Name should not be empty and should consist only alphabets.");
            }
            String[] nameParts = name.split(" ");
            if (nameParts.length == 1) {
                // If there is no last name, set it to an empty string
                nameParts = new String[]{nameParts[0], ""};
            }
            if (nameParts.length > 2) {
                throw new Exception("Invalid name. First Name and Last Name should be separated by a space.");
            }

            // Validate DOB
            if (!dob.matches("^\\d{2}-\\d{2}-\\d{4}$")) {
                throw new Exception("Invalid date of birth. Date of birth should be in dd-mm-yyyy format.");
            }
            int birthYear = Integer.parseInt(dob.substring(6));
            if (2023 - birthYear < 18) {
                throw new Exception("User's age should be of minimum 18 years.");
            }

            // Validate Aadhar card number
            if (!aadhar.matches("^\\d{12}$")) {
                throw new Exception("Invalid Aadhar card number. Aadhar card number should be a 12 digit number.");
            }

            // Generate username
            String firstName = nameParts[0];
            String lastName = nameParts[1];
            String username;
            if (firstName.length() >= 4) {
                username = firstName.substring(0, 4);
            } else {
                int remainingLetters = 4 - firstName.length();
                username = firstName + lastName.substring(0, remainingLetters);
            }
            username += dob.substring(0, 2) + dob.substring(6) + aadhar.substring(8);

            // Printing the generated username
            System.out.println("Generated username: " + username);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}