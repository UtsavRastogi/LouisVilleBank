<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/manheader.css" type="text/css"> 
<link rel="stylesheet" type="text/css"
          href="https://fonts.googleapis.com/css?family=Lobster">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

<header>
<img alt="logo" src="img/logo3.png" id="logo">
</header>

<div id="navbar">
<ul>
<li><a href="WelcomeMan.jsp">HOME</a></li>
<li><a href="createaccount.jsp">OPEN NEW ACCOUNT</a></li>
<li><a href="OwnTransfers.jsp">OWN TRANSFERS</a></li>
<li><a href="OtherTransfer.jsp">OTHER TRANSFERS</a></li>
<li><a href="ExchangeRate.jsp">EXCHANGE RATE</a></li>
<li><a href="ViewLogs.jsp">VIEW LOGS</a></li>
</ul>
</div>

<form action="LogoutServlet" method="post"><button  id="loginform" type="submit"  style="font-size: 15.3px; margin-top: 27px; font-family: Lobster;">LOGOUT</button></form>

</body>
</html>