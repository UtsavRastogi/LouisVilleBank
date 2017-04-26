package com.tcs.bank.login;

import static com.tcs.bank.mailing.EmailDemo.sendEmailToJustLoggedInUser;
import static com.tcs.bank.database.GetDBConnection.getDBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{
 

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
	String UserID=req.getParameter("UserId");
	String UserPass=req.getParameter("Password");
try {
		
		Connection connection=getDBConnection();
		String sql="select * from user_pass where user_id='"+UserID+"' and user_password='"+UserPass+"'";
		Statement statement=connection.createStatement();
		statement.executeQuery(sql);
		ResultSet resultSet=statement.getResultSet();
		if(resultSet.next()){
			if(UserID.startsWith("LVC")){
				HttpSession session=req.getSession();
				session.setAttribute("LoggedInUserID", UserID);
				session.setAttribute("LoggedInUserPassword", UserPass);
				
				// sending login email
				sendEmailToJustLoggedInUser(UserID);
				
				
				resp.sendRedirect("WelcomeCus.jsp");
				connection.close();
			}else if(UserID.startsWith("LVA")){
				HttpSession session=req.getSession();
				session.setAttribute("LoggedInUserID", UserID);
				session.setAttribute("LoggedInUserPassword", UserPass);
				sendEmailToJustLoggedInUser(UserID);
				resp.sendRedirect("WelcomeMan.jsp");
				connection.close();
			}
			
		}else
			System.out.println("Wrong credentials ");
		RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
		rd.include(req, resp);
		out.println("<script type=\"text/javascript\">");
	       out.println("highlightinput();");
	       out.println("</script>");
	       connection.close();
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
}
}
