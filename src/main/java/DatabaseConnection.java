import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            // The method establishes a database connection.
            // This method requires a database URL, which varies depending on the database.
            conn = DriverManager.getConnection("jdbc:mysql://localhost/course3?user=course3&password=course3");

            System.out.println("Connected to " + conn.getMetaData().getDatabaseProductName());
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

}
