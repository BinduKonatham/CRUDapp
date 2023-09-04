package dao;

import java.sql.*;
import model.Login;

import connectionmanager.ConnectionManager;

public class LoginDAO {
	public boolean checkCredentials(Login l) throws ClassNotFoundException, SQLException
	{
		//1.get the details from Login.java file
		String username = l.getUsername();
		String password = l.getPassword();
		
		//2.jdbc cconnection
		//i)add jar file
		//ii)
		ConnectionManager cm=new ConnectionManager();
		Connection con = cm.establishConnection();
		
		//3.create statement
		Statement st = con.createStatement();
		
		//4.write and execute the query
		ResultSet rt=st.executeQuery("select * from login");
		
		//5.check user name and password
		while(rt.next())
		{
			if(username.equals(rt.getString("username")) && password.equals(rt.getString("password"))) {
				cm.closeConnection();
				return true;
			}
		}
		return false;
	} 
}
