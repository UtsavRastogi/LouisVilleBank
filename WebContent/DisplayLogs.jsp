<%@page import="com.tcs.bank.database.GetDBConnection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<jsp:include page="ViewLogs.jsp"></jsp:include>
<%
String account_No = request.getParameter("accountNo").toString();
String fromDate=request.getParameter("fromdate");
String todate=request.getParameter("todate");
System.out.println(account_No);

Connection connection = GetDBConnection.getDBConnection();
Statement statement = null;
ResultSet resultSet = null;
%>
<h2 align="center" style="color: white;" ><font><strong >All The Records</strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr bgcolor="#A52A2A">
<td><b>Sr No</b></td>
<td><b>Date</b></td>
<td><b>Description</b></td>
<td><b>Cheque_No</b></td>
<td><b>Withdraw</b></td>
<td><b>Deposit</b></td>
<td><b>Available Balance</b></td>
<td><b>Account No</b></td>
</tr>
<%
try{ 
statement=connection.createStatement();


String sql="SELECT * FROM transactions WHERE Date BETWEEN '"+fromDate+"' AND '"+todate+"' AND Account_No='"+account_No+"'";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr bgcolor="#DEB887">

<td><%=resultSet.getString("Sr_No") %></td>
<td><%=resultSet.getString("Date") %></td>
<td><%=resultSet.getString("Description") %></td>
<td><%=resultSet.getString("Cheque_No") %></td>
<td><%=resultSet.getString("Withdraw") %></td>
<td><%=resultSet.getString("Deposit") %></td>
<td><%=resultSet.getString("Available_Balance") %></td>
<td><%=resultSet.getString("Account_No") %></td>

</tr>

<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
