package Adv_Java;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class program_3_CRUD_UPDATE {
	private static Connection con;
	

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbcclasses";
		String username = "root";
		String password = "root@dk";
		String SQL = "UPDATE 'employee' SET 'salary' = 'salary'+5000 WHERE 'dept' = 'IT'";
		
		try {
			Connection con = DriverManager.getConnection(url,username,password);
			System.out.println("Connection Established");
        
			
			// Connection Established     1  // one row inserted in the database
			

			 java.sql.Statement statement = con.createStatement();
			   int inc= statement.executeUpdate(SQL); 
			   System.out.println(inc);
	
			
		} 
		catch (SQLException e) {

			
			e.printStackTrace();
		}

		
	}

}
