import java.sql.*;

public class SQLExample {

    public static void main(String[] args) {
        try {
            // STEP 1: Obtain a connection
            // The method establishes a database connection.
            // This method requires a database URL, which varies depending on the database.
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/course3?user=course3&password=course3")) {
                System.out.println("Connected to " + conn.getMetaData().getDatabaseProductName());

                // STEP 2: Create a Statement
                try (Statement stmt = conn.createStatement()) {

                    // STEP 3: Execute a SQL query
                    ResultSet rs = stmt.executeQuery("SELECT ORDER_ID, CUSTOMER_NAME FROM orders");
                    // TIP: Use executeUpdate to run INSERT,UPDATE or DELETE queries

                    System.out.println("Executed SQL query");
                }
            }
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
