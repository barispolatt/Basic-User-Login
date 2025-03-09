import java.util.Scanner;

public class BasicUserLogin {
    public static void main(String[] args) {
        String userID = "", password = "";  // saving user info
        Scanner input = new Scanner(System.in);
        boolean isRegistered = false;

        while (true) {  // main menu loop
            System.out.println("\n1. Create new account\n2. Login\n3. Exit");
            System.out.print("Choose an option: ");
            int choice = input.nextInt();
            input.nextLine();  // Cleaning buffer

            if (choice == 1) {
                // New account
                System.out.print("Enter your ID: ");
                userID = input.nextLine();

                System.out.print("Enter your password: ");
                password = input.nextLine();

                System.out.println("\nAccount Created! Returning to main menu...\n");
                isRegistered = true;
            }
            else if (choice == 2) {
                // logging in
                if (!isRegistered) {
                    System.out.println("No account found. Please create an account first.");
                    continue;
                }
                int attempts = 0;
                while (attempts < 3) {
                    System.out.print("ID: ");
                    String inputID = input.nextLine();
                    System.out.print("Password: ");
                    String inputPass = input.nextLine();

                    if (inputID.equals(userID) && inputPass.equals(password)) {
                        System.out.println("Welcome " + userID + "!");
                        return;
                    } else {
                        attempts++;
                        System.out.println("Invalid ID or Password. Attempts left: " + (3 - attempts));
                    }
                }
                System.out.println("Too many failed attempts. Please reset your password.");
                System.out.print("Enter a new password: ");
                password = input.nextLine();
                System.out.println("Password has been reset successfully!");
                }
            else if (choice == 3) {
                // exit program
                System.out.println("Exiting... Goodbye!");
                input.close();
                return;
            }
            else {
                System.out.println("Invalid choice! Please select 1, 2, or 3.");
            }
        }
    }

}
