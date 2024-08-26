package Adv_Java;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class Stored_Procedure_1_count_dept {

	private static Connection connection;
	private static CallableStatement statement;

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
	     
        String url = "jdbc:mysql://localhost:3306/jdbcclasses";
        String username = "root";
        String password = "root@dk";
        
       try {
		connection =  DriverManager.getConnection(url, username, password);
		statement = connection.prepareCall("{call count_employee(? , ?)}");   // input and output parameter
		
		System.out.println("Enter the department");
		
		// first ? number 
		statement.setString(1, in.next());// directly getting the input from the user.
		
		//second ? number
		statement.registerOutParameter(2, Types.INTEGER);  // types is class present in util.SQL package  and types in integer
		
		statement.execute();   // executing the jdbc
		
		int noOfEmployee = statement.getInt(2);  // getting the count of how many dept
		System.out.println(noOfEmployee);
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
		
	}

}
