package Project1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;


public class CustomerDaoImp implements CustomerDao {

    Connection connection;
    //alter table customer modify column balance double UNSIGNED NOT NULL; //altered table to make balance not negative
    public CustomerDaoImp() {

        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public void addCustomer(preCustomer customer) throws SQLException {
        String sql = "insert into customer (users_name, users_password, name, balance) values (?, ?, ?, ?)";
        //switch this up to where you insert values
        //inputs variables from preCustomer class
        // insert into customer(users_name, users_password, name, balance) values ('cody1', 'atillo1', 'cody atillo', 0);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, customer.getUsers_name());
        preparedStatement.setString(2, customer.getUsers_password());
        preparedStatement.setString(3, customer.getName());
        preparedStatement.setDouble(4, customer.getBalance());
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("Customer created");
        } else {
            System.out.println("Oops!, something went wrong");
        }
    }

    @Override
    public void withdrawFunds() throws SQLException {
        Scanner sc = new Scanner(System.in);
        //Figure out how to get a specific place might use username
        System.out.println("Enter a value you would like to Withdraw: ");
        Double withdrawAmu = sc.nextDouble();
        while (withdrawAmu < 0) {
            System.out.println("Unable to Withdraw a negative Amount ");
            System.out.println("Enter a value you would like to Withdraw: ");
            withdrawAmu = sc.nextDouble();
        }

        System.out.println("Enter ID: ");
        int id = sc.nextInt();

        String SQL = "update customer SET balance = balance - " + withdrawAmu + " WHERE id = " + id + ";";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("Balance Updated Withdrawal Amount Approved");
        } else {
            System.out.println("Oops!, something went wrong");
        }


    }

    @Override
    public void depositFunds() throws SQLException {
        Scanner sc = new Scanner(System.in);
        //Figure out how to get a specific place might use username
        System.out.println("Enter a value you would like to deposit: ");
        Double depositAmu = sc.nextDouble();

        while (depositAmu < 0) {
            System.out.println("Unable to Deposit a negative Amount");
            System.out.println("Enter a value you would like to deposit: ");
            depositAmu = sc.nextDouble();
        }

        System.out.println("Enter ID: ");
        int id = sc.nextInt();

        String SQL = "update customer SET balance = balance + " + depositAmu + " WHERE id = " + id + ";";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("Balance Updated Deposit Amount approved");
        } else {
            System.out.println("Oops!, something went wrong");
        }

        //alter table
    }

    @Override
    public void moneyTransfer() throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a value you would like to Send: ");
        Double sentAmu = sc.nextDouble();
        while (sentAmu < 0) {
            System.out.println("Unable to Send a Negative Amount ");
            System.out.println("Enter a value you would like to Send: ");
            sentAmu = sc.nextDouble();
        }

        System.out.println("Enter Account ID: ");
        int id = sc.nextInt();
        System.out.println("Enter Account ID you wish to transfer too: ");
        int id2 = sc.nextInt();

        String SQL = "update customer SET balance = balance - " + sentAmu + " WHERE id = " + id + ";";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        int count = preparedStatement.executeUpdate();

        String SQL2 = "update customer SET balance = balance + " + sentAmu + " WHERE id = " + id2 + ";";
        PreparedStatement preparedStatement2 = connection.prepareStatement(SQL2);
        int count2 = preparedStatement2.executeUpdate();

        if (count > 0 && count2 > 0) {
            System.out.println("Balance Updated Transaction Approved");
        } else {
            System.out.println("Oops!, something went wrong");
        }
        //alter table
    }


    @Override
    public void employeeLogin() throws SQLException {
        Scanner sc = new Scanner(System.in);
        String databaseUsername = " ";
        String databasePassword = " ";
        CustomerDao dao = CustomerDaoFactory.getCustomerDao();

        // Check Username and Password
        System.out.print("Enter Username: ");
        String name = sc.next();
        System.out.print("Enter Password: ");
        String password = sc.next();

        // Create SQL Query
        Statement stmt = connection.createStatement();
        String SQL = "SELECT * FROM employee WHERE users_name='" + name + "' && users_password='" + password + "'";

        ResultSet rs = stmt.executeQuery(SQL);

        // Check Username and Password
        while (rs.next()) {
            databaseUsername = rs.getString("users_name");
            databasePassword = rs.getString("users_password");
        }

        if (name.equals(databaseUsername) && password.equals(databasePassword)) {
            System.out.println();
            System.out.println("Successful Login!\n----");
            System.out.println("~~Employee Account~~");
            //employee can approve or reject an account
            //employee can view bank accounts
            //throw into loop to make cleaner
                int selection = 5;
            do {
                switch (selection) {

                    case 1://employee login
                     //Approve or reject account
                        Scanner scanner = new Scanner(System.in);

                        int select;
                        dao.getCustomer();
                        System.out.println();
                        System.out.println("Check or Accept accounts based off customers ID");
                        System.out.println("1. Accept Account");
                        System.out.println("2. Reject Account");
                        System.out.println("Select an option: ");
                        select = scanner.nextInt();

                        while(select > 2 || select <1){
                            System.out.println("Enter a valid option");
                            select = sc.nextInt();
                        }

                        if (select == 1){
                            System.out.println("Account number you wish to Accept");

                            int acceptID;
                            acceptID = scanner.nextInt();
                            String sql = "UPDATE customer Set isVeri = true Where id = " + acceptID ;
                            PreparedStatement preparedStatement = connection.prepareStatement(sql);
                            int count = preparedStatement.executeUpdate();
                            if (count > 0) {
                                System.out.println("Account Updated ~ Approved");
                            } else {
                                System.out.println("Oops!, something went wrong");
                            }
                        }else if(select == 2){
                            System.out.println("Account number you wish to Reject");

                            int acceptID;
                            acceptID = scanner.nextInt();
                            String sql2 = "UPDATE customer Set isVeri = false Where id = " + acceptID ;
                            PreparedStatement preparedStatement = connection.prepareStatement(sql2);
                            int count = preparedStatement.executeUpdate();
                            if (count > 0) {
                                System.out.println("Account Updated ~ Rejected");
                            } else {
                                System.out.println("Oops!, something went wrong");
                            }
                        }
                            break;

                    case 2:

                      dao.getCustomer();
                        break;

                    case 3: //Create Account
                        exit(0);

                    default:
                        System.out.println("Enter a valid Option");
                }// End of switch statement
                System.out.println();
                System.out.println("1. Approve or Rejected Account"); //working with integers will be easier
                System.out.println("2. View Bank Account records");   //this is just gonna be a show all
                System.out.println("3. Logout");                      //exit employee mode back to login
                System.out.println();
                System.out.println("Enter Menu Selection");

                selection = sc.nextInt();
            } while (selection != 3);

        } // end of inital if
        else {
            System.out.println("Login Failed Not an Employee Account\n----");
        }

    }

    @Override
    public void Logins() throws SQLException {
        Scanner sc = new Scanner(System.in);

        String databaseUsername = " ";
        String databasePassword = " ";
        CustomerDao dao = CustomerDaoFactory.getCustomerDao();

        // Check Username and Password
        System.out.print("Enter Username: ");
        String name = sc.next();
        System.out.print("Enter Password: ");
        String password = sc.next();

        // Create SQL Query
        Statement stmt = connection.createStatement();
        String SQL = "SELECT * FROM customer WHERE users_name='" + name + "' && users_password='" + password + "'";

        ResultSet rs = stmt.executeQuery(SQL);
        // Check Username and Password
        while (rs.next()) {
            databaseUsername = rs.getString("users_name");
            databasePassword = rs.getString("users_password");

        }

        if (name.equals(databaseUsername) && password.equals(databasePassword)) {
            System.out.println();
            System.out.println("Successful Login!\n----");
            System.out.println("~~Custom Account~~");

            Statement states = connection.createStatement();
            String sql = "call checkveri(false)";

            ResultSet resultSet = states.executeQuery(sql);
            // Check Username and Password
            String databaseU = " ";
            String databaseP = " ";
            while (resultSet.next()) {
                databaseU = resultSet.getString("users_name");
                databaseP = resultSet.getString("users_password");

            }
            if(name.equals(databaseU) && password.equals(databaseP)){
                System.out.println("Account is NOT Verified");

            }
            else{
                System.out.println("Account is Verified ");
                System.out.println();
                //
                    int choice = 6;
                do {
                    switch (choice) {

                        case 1://employee login
                           dao.withdrawFunds();
                            break;
                        case 2://Customer login
                            dao.depositFunds();
                            break;
                        case 3: //Create Account
                            dao.moneyTransfer();
                            break;
                        case 4:
                            exit(0);

                        default:
                            System.out.println("Enter a valid Option");
                    }// End of switch statement
                    System.out.println();
                    System.out.println("1. Withdraw"); // take away from balance //update checks
                    System.out.println("2. Deposit"); // add too balance //Fine add loop
                    System.out.println("3. Post Money Transfer"); //by customer id be able to send money given the account number
                    // can post money transfers
                    System.out.println("4. Logout");    //exit program
                    System.out.println();
                    System.out.println("Select a menu option: ");

                    choice = sc.nextInt();
                } while (choice != 4);
            }
    }
        else
    {
        System.out.println("Incorrect Login\n----");
    }
}



    @Override
    public List<Customer> getCustomer() throws SQLException {
        String sql = "select * from customer";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);

        List<Customer> allEmp = new ArrayList<Customer>();


        //create table custom (userN char(50), pass char(50),
        // id integer NOT NULL AUTO_INCREMENT, name char(50), balance double, isVerified boolean not null default 0,
        //Primary key(id));
        while (result.next()) {
            String users_name = result.getString("users_name");
            String users_password = result.getString("users_password");
            int id = result.getInt("id");
            String name = result.getString("name");
            double balance = result.getDouble("balance");
            boolean isVeri = result.getBoolean("isVeri");

            allEmp.add(new Customer(users_name, users_password, id, name, balance, isVeri));
        }
        allEmp.forEach(System.out::println);
        return allEmp;
    }

    @Override
    public void createAccount() throws SQLException {
        CustomerDao dao = CustomerDaoFactory.getCustomerDao();

        System.out.println("~~Create New Account~~");
        System.out.println();
        Scanner sc = new Scanner(System.in);


        //int id; make the id in the database automatically update

        //so if i throw everything into table i could use WHERE =
        //to only show accounts based off of user name and password
        //pulling up only one file for the customer so they can only see their account
        System.out.println("Create An Account"); //Allow user to make a customer account
        //Enter Username
        System.out.println("Enter Account UserName: ");
        String userName = sc.next();

        //Enter Password
        System.out.println("Enter Account Password: ");
        String userPass = sc.next();
        //id is going to automatically generate
        //Enter name

        System.out.println("Enter Users First Name: ");
        String firstName = sc.next();

        System.out.println("Enter users Last Name");
        String lastName = sc.next();

        String fullName = firstName + " " + lastName;

        //Enter account balance
        System.out.println("Enter Balance");
        double balance1 = sc.nextDouble();

            while (balance1 < 0) {
                System.out.println("Cannot have a negative balance input new balance: ");
                sc.nextDouble();
            }

        //End login creation
        preCustomer custom1 = new preCustomer(userName, userPass, fullName, balance1);
        System.out.println();
        dao.addCustomer(custom1);
        }


    }
