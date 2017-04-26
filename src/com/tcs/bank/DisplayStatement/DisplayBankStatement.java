package com.tcs.bank.DisplayStatement;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.bank.database.GetDBConnection;

public class DisplayBankStatement extends HttpServlet{
	private int loggedInUserAccNo;
	private String date;
	private String description;
	private String chequeNo;
	private String withdraw;
	private String deposit;
	private 	String Available_Balance;
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
	String fromDate=req.getParameter("DateFrom");
	String todate=req.getParameter("DateTo");
	
	
	Object loggedInUserId = req.getSession().getAttribute("LoggedInUserID");
	String sql1="select * from account_details where user_id='"+loggedInUserId+"'";
	
	try {
		Connection connection=GetDBConnection.getDBConnection();
		Statement stmt=connection.createStatement();
		ResultSet rs=stmt.executeQuery(sql1);
		while(rs.next()){
			this.loggedInUserAccNo=rs.getInt("Account_No");
		}
		System.out.println(loggedInUserAccNo);
		System.out.println(fromDate);
		System.out.println(todate);
		//String sql2="select * from transactions where((Date between '"+fromDate+"' and '"+todate+"') and Account_No='"+loggedInUserAccNo+"' ";
		String sql2="SELECT * FROM transactions WHERE Date BETWEEN '"+fromDate+"' AND '"+todate+"' AND Account_No='"+loggedInUserAccNo+"'";
		
		ResultSet rs1=stmt.executeQuery(sql2);
		
		while(rs1.next()){
			date=rs1.getString("Date");
		    description=rs1.getString("Description");
			chequeNo=rs1.getString("Cheque_No");
			withdraw=rs1.getString("Withdraw");
			deposit=rs1.getString("Deposit");
			Available_Balance=rs1.getString("Available_Balance");
			
			out.println(date+" "+description+" "+chequeNo+" "+withdraw+" "+deposit+" "+Available_Balance+"<br><br>");
			
			}
		
		RequestDispatcher rds=req.getRequestDispatcher("ViewLogsCus.jsp");
		rds.include(req, resp);
		
		connection.close();
		out.println("Date  "+"Description  "+"Cheque No"+"  Withdraw"+"  Deposit"+"  Available Balance"+"<br><br>");
	
		
		
	} catch (Exception e) {
		// TODO: handle exception
	}
}
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
