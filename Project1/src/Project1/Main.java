package Project1;

import java.util.Scanner;
import java.sql.SQLException;


public class Main {

    public static void main(String[] args) throws SQLException{
        CustomerDao dao = CustomerDaoFactory.getCustomerDao();
        int choice = 0;
        System.out.println();

        do {
            switch (choice) {

                case 1://employee login
                    dao.employeeLogin();
                    break;
                case 2://Customer login
                    dao.Logins();
                    break;
                case 3: //Create Account
                   dao.createAccount();
                    break;

                case 4:
                    exit(0);
                default:
                    System.out.println("Enter a valid Option");
            }// End of switch statement
            System.out.println();
            System.out.println("Banking Application: Select an option");
            System.out.println("1. Employee Login");
            System.out.println("2. Customer Login");
            System.out.println("3. Create Account");  // username, Password, ID, name, email, balance (dont need email)
            System.out.println("4. Exit");
            System.out.println();
            System.out.println("Select a menu option: ");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
        } while (choice != 4);    // <--- changed
    }

    private static void exit(int i) {
    }

}




