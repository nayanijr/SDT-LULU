package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.Dbcon;

import userbean.Signup;

public class Signupdao {
	public static void insert(Signup r) throws Exception
	{
		//Connection c=Dbcon.datacon();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","puneeth","puneeth");
		PreparedStatement p=c.prepareStatement("insert into signin values(?,?,?,?,?)");
		p.setString(1, r.getLast());
		p.setString(2, r.getFirst());
		p.setString(3, r.getNum());
		p.setString(4, r.getMail());
		p.setString(5, r.getPass());
		p.executeUpdate();
		
	}

}
