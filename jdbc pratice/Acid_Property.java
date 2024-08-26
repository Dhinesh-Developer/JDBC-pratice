package Adv_Java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class Acid_Property {
	static final Scanner in =new Scanner(System.in);
	private static Connection connection;
	private static PreparedStatement prepareStatement;

	public static void main(String[] args) {
		
		/*Enter the Amount: 
		5000
		Enter the Sender Name: 
		alex
		Enter the Receiver Name: 
		bob
		1
		1
		Do you want to confirm the transcation yes/no
		yes

		 * 

		 */
	
        
        String url = "jdbc:mysql://localhost:3306/jdbcclasses";
        String username = "root";
        String password = "root@dk";
        
        try {
			connection = DriverManager.getConnection(url, username, password);
			
			connection.setAutoCommit(false);
			boolean transaction = transaction();
			
			if(transaction)
			{
				connection.commit();
			}
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}

	}

	private static boolean transaction() {
		
		System.out.println("Enter the Amount: ");
		int amount = in.nextInt();
	    
		System.out.println("Enter the Sender Name: ");
		String sender = in.next();
		System.out.println("Enter the Receiver Name: ");
		String receiver = in.next();
		
		
		int i = updateAmount(sender,amount);
		int j = updateAmount(receiver,-amount);
		
		return ifConfirm(i,j);
	}

	private static boolean ifConfirm(int i, int j) {
	    System.out.println("Do you want to confirm the transcation yes/no");
	    String choice = in.next();
	    if(choice.equalsIgnoreCase("yes") && i==1 && j==1)
	    {
	    	return true;
	    }
	    else
	    {
	    	return false;
	    }
	}

	private static int updateAmount(String sender, int amount) {
		
		
		String SQL = "UPDATE employee SET salary = salary - ? WHERE name = ?";
		
		try {
			prepareStatement = connection.prepareStatement(SQL);
			prepareStatement.setInt(1, amount);
			prepareStatement.setString(2, sender);
			
			int i = prepareStatement.executeUpdate();
		    return i;
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return 0;
	}

}
