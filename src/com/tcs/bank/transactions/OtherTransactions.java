package com.tcs.bank.transactions;

import java.io.IOException;
import static com.tcs.bank.transactions.TransactionDetails.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.bank.database.GetDBConnection;
import com.tcs.bank.mailing.EmailDemo;

public class OtherTransactions extends HttpServlet{
	private int WithdraweeAccountBal;
	private int depositeeAccBal;
	private int withdraweeNewBal;
	private int depositeeNewAccBal;
	private RequestDispatcher rds;
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
	String withdrawnAccNo=req.getParameter("withdrawAcNo").toString();
    String depositAccNo=req.getParameter("depositAcNo").toString();	
    String Amount=req.getParameter("amount").toString();
    int transferAmount=Integer.parseInt(Amount);
    try {
    	
		Connection connection=GetDBConnection.getDBConnection();
		Statement statement=connection.createStatement();
		
		
		String sql1="select * from account_details where Account_No='"+withdrawnAccNo+"'";
		String sql2="select * from account_details where Account_No='"+depositAccNo+"'";
		ResultSet rs=statement.executeQuery(sql1);
		while(rs.next()){
			this.WithdraweeAccountBal=rs.getInt("Balance");
		}
		
		
		
		rs=statement.executeQuery(sql2);
		while(rs.next()){
			this.depositeeAccBal=rs.getInt("Balance");
		}
		
		
		if(WithdraweeAccountBal>transferAmount){
			withdraweeNewBal=WithdraweeAccountBal-transferAmount;
			depositeeNewAccBal=depositeeAccBal+transferAmount;
			Statement statement2=connection.createStatement();
			 String sql4="update account_details set Balance='"+withdraweeNewBal+"' where Account_No='"+withdrawnAccNo+"'";
			 String sql5="update account_details set Balance='"+depositeeNewAccBal+"' where Account_No='"+depositAccNo+"'";
			 statement2.executeUpdate(sql4);
			 statement2.executeUpdate(sql5);
			 rds=req.getRequestDispatcher("OtherTransfer.jsp");
			 rds.include(req, resp);
			 out.println("<script type=\"text/javascript\">");
		       out.println("success();");
		       out.println("</script>");
			 connection.close();
			 saveLoggedInUserTransactionHistory("Credited", null, 0, transferAmount, depositeeNewAccBal, depositAccNo);
			 saveLoggedInUserTransactionHistory("Debited", null, transferAmount, 0, withdraweeNewBal, withdrawnAccNo);
			 EmailDemo.transactionCreditEmailwithAccNo(depositAccNo, transferAmount);
			 EmailDemo.transactionDebitEmailwithAccNo(withdrawnAccNo, transferAmount);
		}else if(WithdraweeAccountBal<transferAmount){
			  rds=req.getRequestDispatcher("OtherTransfer.jsp");
		      rds.include(req, resp);
		      out.println("<script type=\"text/javascript\">");
		       out.println("NoBal();");
		       out.println("</script>");}
		      
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
}
}
