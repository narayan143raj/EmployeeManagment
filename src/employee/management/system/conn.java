package employee.management.system;
import java.sql.*;

public class conn {
    Connection connection;
    Statement statement;

public conn(){
     try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementSystem",
    "root","2005");
    statement= connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
