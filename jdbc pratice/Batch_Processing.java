package Adv_Java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Batch_Processing {

    private static final String URL = "jdbc:mysql://localhost:3306/jdbcclasses";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root@dk";
    private static final String INSERT_SQL = "INSERT INTO employee (id, name, email, dept, salary) VALUES (?, ?, ?, ?, ?)";

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            connection.setAutoCommit(false); // Disable auto-commit for batch processing
            statement = connection.prepareStatement(INSERT_SQL);

            // Example loop for batch processing
            int size = in.nextInt();
            for (int i = 0; i < size; i++) { // Assuming you want to insert 3 rows
                System.out.println("Enter the id value: ");
                int id = in.nextInt();
                System.out.println("Enter the name: ");
                String name = in.next();
                System.out.println("Enter the email: ");
                String email = in.next();
                System.out.println("Enter the dept: ");
                String dept = in.next();
                System.out.println("Enter the salary: ");
                int salary = in.nextInt();

                statement.setInt(1, id);
                statement.setString(2, name);
                statement.setString(3, email);
                statement.setString(4, dept);
                statement.setInt(5, salary);

                statement.addBatch(); // Add to batch
            }

            int[] result = statement.executeBatch(); // Execute batch

            connection.commit(); // Commit transaction

            for (int res : result) {
                System.out.println(res + " row(s) affected.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback(); // Roll back on error
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
        } finally {
            // Close resources in reverse order of creation
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            in.close(); // Close the scanner
        }
    }
}

        


