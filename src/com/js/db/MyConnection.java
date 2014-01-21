package com.js.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");    		
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public Connection getConnection() throws Exception{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsinformatics","root","root");
		return con;
	}
}
