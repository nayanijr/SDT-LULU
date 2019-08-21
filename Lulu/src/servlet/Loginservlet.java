package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dbcon;
@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		Connection c=Dbcon.datacon();
		try {
			PreparedStatement p=c.prepareStatement("select * from signin where email=? and pass=? ");
			p.setString(1, request.getParameter("mail"));
			p.setString(2, request.getParameter("pass"));
			ResultSet rs=p.executeQuery();
			//rs.next();
			
			if(rs.next())
			{
				response.sendRedirect("firsrscreen.html");
				
			}
			else
			{
				response.sendRedirect("about.html");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
