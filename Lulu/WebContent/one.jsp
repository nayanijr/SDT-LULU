<%@page import="java.sql.ResultSet"%>
<%@page import="java.security.interfaces.RSAKey"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.Dbcon"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Connection c=Dbcon.datacon();
String s=request.getParameter("reg");
int i=Integer.parseInt(request.getParameter("numse"));
PreparedStatement p1=c.prepareStatement("select seats from ride where reg=?");
p1.setString(1,s);
ResultSet rs=p1.executeQuery();
rs.next();
if(rs.getInt(1)!=0 && rs.getInt(1)>i )
{
i=rs.getInt(1)-i;	
}
else
{
%>
<h4>Booking Unsuccessful</h4>
<%
request.getRequestDispatcher("showride.jsp").include(request, response);

}
	
PreparedStatement p=c.prepareStatement("Update ride set seats=? where reg=?");
p.setInt(1, i);
p.setString(2, s);
p.executeUpdate();
%>
<h4>Booking Confirmed</h4>
<% 
request.getRequestDispatcher("showride.jsp").forward(request, response);
%>
</body>
</html>