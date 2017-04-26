<%@page import="com.tcs.bank.database.GetDBConnection"%>
<%@ page import="java.sql.*" %>  
<%  
String name=request.getParameter("val");  
if(name==null||name.trim().equals("")){  
out.print("<p>Please enter name!</p>");  
}else{  
try{  
Connection connection=GetDBConnection.getDBConnection();  
PreparedStatement ps=connection.prepareStatement("select  * from account_details where Name like '"+name+"%'");  
ResultSet rs=ps.executeQuery();  
  
if(!rs.isBeforeFirst()) {      
 out.println("<p>No Record Found!</p>");   
}else{  
out.print("<table border='1' cellpadding='2' width='100%'>"); 
out.print("<tr><th>Account No</th><th>Name</th><th>Current Balance</th></tr>");  
while(rs.next()){  
out.print("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(7)+"</td></tr>");  
}  
out.print("</table>");  
}//end of else for rs.isBeforeFirst  
connection.close();  
}catch(Exception e){out.print(e);}  
}//end of else  
%>   