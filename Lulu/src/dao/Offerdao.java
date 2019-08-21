package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.omg.CORBA.Request;

import com.Dbcon;

import userbean.Offerride;

public class Offerdao {
	public static void insert(Offerride r) throws SQLException
	{
		Connection c=Dbcon.datacon();
		PreparedStatement p=c.prepareStatement("insert into ride values(?,?,?,?,?,?,?)");
		p.setString(1,r.getFrom());
		p.setString(2, r.getTo());
		p.setString(3, r.getPickup());
		p.setString(4, r.getDate());
		p.setString(5, r.getTime());
		p.setInt(6,r.getSeat());
		p.setString(7, r.getCarno());
		p.executeUpdate();
		
		
	}

}
