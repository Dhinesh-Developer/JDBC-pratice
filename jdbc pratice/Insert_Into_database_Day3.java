package Adv_Java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.AddStatement;
import com.mysql.cj.xdevapi.Statement;

public class Insert_Into_database_Day3 {

	public static void main(String[] args) {
		
	
    
		
		String url = "jdbc:mysql://localhost:3306/jdbcclasses";
		String username = "root";
		String password = "root@dk";
		String SQL = "INSERT into employee (id,name,email,dept,salary) values (5,'joe','joe@gmail.com','account','50000')";
		
		try {
			Connection con = DriverManager.getConnection(url,username,password);
			System.out.println("Connection Established");
        
			
			// Connection Established     1  // one row inserted in the database
			

			
			 java.sql.Statement statement = con.createStatement();
			   int i = statement.executeUpdate(SQL); 
			   System.out.println(i);
	
			
		} catch (SQLException e) {

			
			e.printStackTrace();
		}
	

		 
	}

}
