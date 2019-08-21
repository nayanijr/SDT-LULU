package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Offerdao;
import userbean.Offerride;
@WebServlet("/Offerservlet")
public class Offerservlet extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		Offerride o=new Offerride();
		o.setFrom(request.getParameter("from"));
		o.setTo(request.getParameter("to"));
		o.setPickup(request.getParameter("pickup"));
		o.setDate(request.getParameter("date"));
		o.setTime(request.getParameter("time"));
		o.setSeat(Integer.parseInt(request.getParameter("seats")));
		o.setCarno(request.getParameter("carno"));
		try {
			Offerdao.insert(o);
			response.sendRedirect("firsrscreen.html");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
