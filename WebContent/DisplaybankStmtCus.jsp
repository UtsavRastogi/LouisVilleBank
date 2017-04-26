<%@page import="com.tcs.bank.database.GetDBConnection"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bank Statement</title>
</head>
<body>
<%!
private int loggedInUserAccNo;
private String date;
private String description;
private String chequeNo;
private String withdraw;
private String deposit;
private 	String Available_Balance;
int i=1;
%>
<%@include file="ViewLogsCus.jsp" %>
<%
String fromDate=request.getParameter("DateFrom");
String todate=request.getParameter("DateTo");
String loggedInUserId=(String)session.getAttribute("LoggedInUserID");  
String sql1="select * from account_details where user_id='"+loggedInUserId+"'";

Connection connection=GetDBConnection.getDBConnection();
Statement stmt=connection.createStatement();
ResultSet rs=stmt.executeQuery(sql1);

while(rs.next()){
	this.loggedInUserAccNo=rs.getInt("Account_No");
}
String sql2="SELECT * FROM transactions WHERE Date BETWEEN '"+fromDate+"' AND '"+todate+"' AND Account_No='"+loggedInUserAccNo+"'";
ResultSet rs1=stmt.executeQuery(sql2);
out.println("<table border=1 cellspacing=1 cellpadding=0 align=center>");
ResultSetMetaData rsmd=rs1.getMetaData();  
int total=rsmd.getColumnCount();  
out.print("<tr bgcolor=#A52A2A>");  
for(int i=1;i<total;i++)  
{  
out.print("<th>"+rsmd.getColumnName(i)+"</th>");  
}  
out.print("</tr>");  
out.println("<br>");
while(rs1.next())  
{  
out.print("<tr bgcolor=#DEB887><td>"+i+"</td><td>"+rs1.getString("Date")+"</td><td>"+rs1.getString("Description")+"</td><td>"+rs1.getString("Cheque_No")+"</td><td>"+rs1.getString("Withdraw")+"</td><td>"+rs1.getString("Deposit")+"</td><td>"+rs1.getString("Available_Balance")+"</td></tr>");  
   i=i+1;               
}  
  
out.print("</table>");  

%>
</body>
</html>