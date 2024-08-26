package Adv_Java;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;


public class Stored_Procedure_2 {

	private static Object connection;
	private static Object Statement;


	public static void main(String[] args) {
		
		/*
		 * count the number of employess salary is greater than the specfic salary stored procedure in database
		 * input = 50000   output = 8
		 */
   
		
		Scanner in = new Scanner(System.in);
	     
        String url = "jdbc:mysql://localhost:3306/jdbcclasses";
        String username = "root";
        String password = "root@dk";
        
        try {
			connection= DriverManager.getConnection(url, username, password);
			 Statement =  ((Connection) connection).prepareCall("{ call employee_count(?)}") ;
			 
				System.out.println("Enter the salary");
			    ((CallableStatement) Statement).setInt(1,50000);
			    
			    ((CallableStatement) Statement).registerOutParameter(1, Types.INTEGER); 
			    ((PreparedStatement) Statement).execute();
				
				int noOfEmployee = ((CallableStatement) Statement).getInt(1);  // getting the count of how many dept
				System.out.println(noOfEmployee);
				
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
