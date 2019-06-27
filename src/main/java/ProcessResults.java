import java.sql.*;

public class ProcessResults {

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
                    // TIP: Use executeUpdate to run INSERT,UPDATE or DELETE queries
                    try (ResultSet rs = stmt.executeQuery("SELECT ORDER_ID, CUSTOMER_NAME FROM orders")) {
                        System.out.println("Executed SQL query");

                        // STEP 4: Process the results
                        while (rs.next()) {
                            int orderId = rs.getInt("ORDER_ID");
                            String customerName = rs.getString("CUSTOMER_NAME");

                            // TIP: You can also read by the index of the column in the query
                            // int orderId = rs.getInt(1);
                            // String customerName = rs.getString(2);

                            System.out.println("ID: " + orderId);
                            System.out.println("Customer name: " + customerName);
                        }
                    }
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
