package com.tcs.bank.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
	 HttpSession session=req.getSession();
     session.removeAttribute("LoggedInUserID");
 	 session.invalidate();
 	 
	RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
	rd.include(req, resp);
	out.println("<script type=\"text/javascript\">");
	out.println("window.location.hash=\"no-back-button\";");
	out.println("window.location.hash=\"Again-No-back-button\";//again because google chrome don't insert first hash into history");
	out.println("window.onhashchange=function(){window.location.hash=\"no-back-button\";}");
	
	
       out.println("History.forward(-1);");
       out.println("</script>");
}
}
