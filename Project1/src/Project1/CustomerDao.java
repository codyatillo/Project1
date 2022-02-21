package Project1;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {
    void addCustomer(preCustomer customer) throws SQLException;
    void withdrawFunds() throws SQLException;
    void depositFunds() throws SQLException;
    void moneyTransfer() throws SQLException;
    void employeeLogin() throws SQLException;
    void Logins()throws SQLException;
    void createAccount() throws SQLException;
    //will show all the customers an Employee function
    List<Customer> getCustomer() throws SQLException;
    List<showCustomer> getSpecific() throws SQLException;

}


