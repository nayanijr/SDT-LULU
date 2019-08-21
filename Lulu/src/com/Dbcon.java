package com;

import java.sql.Connection;
import java.sql.DriverManager;


public class Dbcon {
	public static Connection datacon() {
		// TODO Auto-generated constructor stub
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","puneeth","puneeth");
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		return con;
	
		
		
		
	}

}
