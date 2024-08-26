package Adv_Java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BLOB {

	private static Connection connection;
	private static PreparedStatement Statement;
	static final String PATH = "C:\\Users\\Admin\\eclipse-workspace\\Advance_Java_JDBC\\images\\jack.jpeg";

	public static void main(String[] args) {
     
		Scanner in = new Scanner(System.in);
	    String url = "jdbc:mysql://localhost:3306/jdbcclasses";
        String username = "root";
        String password = "root@dk";
		
		try {
			connection = DriverManager.getConnection(url, username, password);
			String SQL = "UPDATE employee SET dp = ? WHERE id = ?";
			
			Statement = connection.prepareStatement(SQL);
			FileInputStream fis = new FileInputStream(PATH);
			
			System.out.println("Enter the ID: ");
			Statement.setInt(2, in.nextInt());
			
			
			Statement.setBinaryStream(1, fis);
			
			int i = Statement.executeUpdate();
			System.out.println(i);
			/*
			 * if the exception occur  change the datatype to    longBlob to dp // that shall
			 * 
			 */
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}
