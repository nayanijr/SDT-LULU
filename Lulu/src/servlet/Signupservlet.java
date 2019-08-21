package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dbcon;

import dao.Signupdao;
import userbean.Signup;
@WebServlet("/Signupservlet")
public class Signupservlet extends HttpServlet  {
	
	
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		Signup s=new Signup();
		PrintWriter out=response.getWriter();
		
		if(request.getParameter("pass").equals(request.getParameter("cpass")))
		{
			s.setFirst(request.getParameter("first"));
			s.setLast(request.getParameter("last"));
			s.setMail(request.getParameter("mail"));
			s.setNum(request.getParameter("num"));
			s.setPass(request.getParameter("pass"));
			try {
				Signupdao.insert(s);
				response.sendRedirect("about.html");
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			} 
			
		
		
		else
		{
		out.println("<h6>Registration Unsuccessful</h6>");
				request.getRequestDispatcher("services.html").include(request, response);
			
		}
	}
	
}



