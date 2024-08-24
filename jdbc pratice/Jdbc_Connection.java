package Adv_Java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * using the jdbc we must implement the four steps.
 * 1.load the driver
 * 2.create a connection to database
 * 3.create a sql statement
 * 4.Execute the sql statements
 * 5.   optional     process the data     // if you update sometimes  you no need to display the data
 */

public class Jdbc_Connection {
	



	/*  output
	 * Connection Established...
1 alex alex@gmail.com HR 25000
2 bob bob@gmail.com IT 55000
3 clark clark@gmail.com IT 75000
4 max max@gmail.com Finance 60000

	 */
	public static void main(String[] args)
	{
		
		Connection con =null;
		Statement st = null;
		ResultSet res =null;
		
		
		String url = "jdbc:mysql://localhost:3306/jdbcclasses";
		String username = "root";
		String password = "root@dk";
		String SQL = "SELECT * from employee";
		
		try {
			 con = DriverManager.getConnection(url, username, password);
			
			System.out.println("Connection Established...");
			
		   display(con,st,res,SQL);
			
			} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			close(con, st, res);
		}
	}

  // display the result using seperate method
	public static void display(Connection con,Statement st,ResultSet res, String SQL) throws SQLException
	{

		 st = con.createStatement();
		 res = st.executeQuery(SQL);
		// System.out.println(res);   for getting the object.
		
		
		// getting the data from the sql using jdbc
		while(res.next())
		{
			int id = res.getInt("id");
			String name = res.getString("name");
			String email = res.getString("email");
			String dept = res.getString("dept");
			int salary = res.getInt("salary");
			System.out.println(id+ " " + name + " " + email+ " " + dept+ " " + salary);
		}
		
	}
	
// closing all the resource using the separate method
	private static void close(Connection con, Statement st, ResultSet res) {
		try {
			if(res != null)
			{
				res.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(st != null)
			{
				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(con!= null)
			{
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
