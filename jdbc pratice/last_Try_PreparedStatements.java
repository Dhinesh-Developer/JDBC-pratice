package Adv_Java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.Scanner;

public class last_Try_PreparedStatements {

	private static Connection connection;
	private static PreparedStatement statement;

	public static void main(String[] args) {
	
		String url = "jdbc:mysql://localhost:3306/jdbcclasses";
		String username = "root";
		String password = "root@dk";
		String SQL = "INSERT INTO 'employee' (id,name,email,dept,salary) VALUES (?,?,?,?,?)";
		
		try {
			connection = DriverManager.getConnection(url, username, password);
			Scanner in = new Scanner(System.in);
			statement = connection.prepareStatement(SQL);
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
			statement.setString(3,email);
			statement.setString(3, dept);
            statement.setInt(4, salary);	
            
            int res = statement.executeUpdate();	
            System.out.println(res);
			
				} catch (SQLException e) {
			
			e.printStackTrace();
		}
		

	}

}
