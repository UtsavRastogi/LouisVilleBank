package com.tcs.bank.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SendToWelcomePage extends HttpServlet{
	private String UserId;
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
	HttpSession session=req.getSession(false);
	if(session==null){
		
		System.out.println("Session not available.");
		RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
		rd.include(req, resp);
		
	}
	else
		System.out.println("Session available.");
	    this.UserId=session.getAttribute("LoggedInUserID").toString();
	    if(UserId.startsWith("LVC")){
	    	resp.sendRedirect("WelcomeCus.jsp");
	    }else if (UserId.startsWith("LVA")) {
			resp.sendRedirect("WelcomeMan.jsp");
		}
}
}
