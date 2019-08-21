<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.Dbcon"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width">
    <meta name="description" content="Happy Ride Sharing">
 <meta name="keywords" content="Car ">
  <meta name="author" content="Mad 316">
    <title>LULU Rides | Welcome</title>
    <link rel="stylesheet" href="./css/style.css">
  </head>
  <body>
    <header>
      <div class="container">
        <div id="branding">
          <h1><span class="highlight">LULU</span> Ride Sharing</h1>
        </div>
        <nav>
          <ul>
            <li class="current"><a href="index.html">Home</a></li>
            <li><a href="about.html">Log In</a></li>
            <li><a href="services.html">Sign Up</a></li>
          </ul>
        </nav>
      </div>
    </header>
<body>
    <div class="appName">
        <h1>Search Rides</h1>
    </div>

    <!--<div class="postedAlert">You are now registered!</div>-->

    <div id="postingForm">

     <!--   <form >
           <label for="from">from</label><br>
           <input type="text" id="from" name="from" placeholder=" Enter City"><br>

            <label for="destination">Destination</label><br>
            <input type="text" id="destination" name="destination" placeholder="City"><br>

            <label for="Pickup location">Pickup location</label><br>
            <input type="text" id="Pickup location" name="Pickup location" placeholder=""><br>

            <label for="date">Date of Journey</label><br>
            <input type="text" id="Date of Journey" name="Date of Journey" placeholder="date">
            <br>



            <label for="departureTime">Departure time</label><br>
            <input type="text" id="departureTime" name="departureTime" placeholder=" Enter time"><br>




            <label for="seats">Seats Required</label><br>
            <input type="text" id="seats" name="seats" placeholder="Enter no of Seats"><br>




             <input type="submit" class="button" value="Submit">
            <!--<input type="submit" class="button" value="Submit">

            <!-- <script>
                var input = document.getElementById("myInput");
                input.addEventListener("keyup", function(event) {
                    if (event.keyCode === 13) {
                        event.preventDefault();
                        document.getElementById("myBtn").click();
                    }
                });

            </script>
        </form>-->
        


    </div>

  

    <div class="feedContainer" id="feed">
      
       
        <table border="1">
   
    <thead align="center"><tr><td>Starting City</td><td>Destination</td><td>Pick-Up Location</td><td>date</td><td>Departure </td><td>Seats Available</td><td>Registration Num</td><td>Seats Required</td><td>confirm</td></tr></thead>
    <%
    Connection c=Dbcon.datacon();
    PreparedStatement p=c.prepareStatement("select * from ride where frm=? and too=?");
    p.setString(1, request.getParameter("from"));
    p.setString(2, request.getParameter("to"));
    ResultSet rs=p.executeQuery();
    int i=1;
    while(rs.next())
    {
    	%>
    	<form action="one.jsp" method="post">
    	<tr align="center"><td><%=rs.getString(1) %></td><td><%=rs.getString(2) %></td><td><%=rs.getString(3) %></td><td><%=rs.getString(4) %></td><td><%=rs.getString(5) %></td><td><%=rs.getInt(6) %></td><td><input type="text" value="<%=rs.getString(7)%>"> </td><td><input type="text" placeholder="No Of Seats" name="numse>"></td><td><input type="hidden" name="reg" value="<%=rs.getString(7)%>"></td><td><button type="submit" id="<%=rs.getString(7)%>">Confirm Seats</button></td></tr>
    	<% %></form><%
    	i++;
    }
    
    	%></table>
    </div>
    <script src="index.js"></script>
</body>
</html>