package Project1;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.Executor;

public class ConnectionFactory {

    private static Connection connection = null;

    private ConnectionFactory(){
    }

    public static Connection getConnection(){
        if(connection == null){
            ResourceBundle resourceBundle = ResourceBundle.getBundle("Project1/dbConfig");
            String url = resourceBundle.getString("url");
            String username = resourceBundle.getString("username");
            String password = resourceBundle.getString("password");
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return connection;
    }
}
