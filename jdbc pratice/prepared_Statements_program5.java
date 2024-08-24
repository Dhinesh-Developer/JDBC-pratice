package Adv_Java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class prepared_Statements_program5 {
	
	private static Connection connection;
	private static PreparedStatement statement;
	private static ResultSet i;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/jdbcclasses";
		String username = "root";
		String password = "root@dk";
		
		String SQL = "SELECT * from 'employee' WHERE 'dept' = ?";
		
		try {
			connection = DriverManager.getConnection(url, username, password);
			
			statement = connection.prepareStatement(SQL);
			System.out.println("Enter the Department name");
			String dept = in.next();
			statement.setString(1,dept);

			ResultSet i = statement.executeQuery();		
			System.out.println(i);
	
			
			/*(while(res.next())
			{
				int id = res.getInt("id");
				String name = res.getString("name");
				String email = res.getString("email");
				String dept2 = res.getString("dept");
				int salary = res.getInt("salary");
				System.out.println(id+ " " + name + " " + email+ " " + dept+ " " + salary);
			}
		
		*/
		
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		

	}

}
