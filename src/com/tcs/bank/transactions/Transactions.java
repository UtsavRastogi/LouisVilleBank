package com.tcs.bank.transactions;

import static com.tcs.bank.transactions.TransactionDetails.otherUserAccTransactions;
import static com.tcs.bank.transactions.TransactionDetails.saveLoggedInUserTransactionHistory;
import static com.tcs.bank.transactions.TransactionDetails.otherUserAccTransactions;

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

import com.tcs.bank.database.GetDBConnection;
import com.tcs.bank.mailing.EmailDemo;

public class Transactions extends HttpServlet{
	private int loggedInUserAccNo;
	private String debiterAccNo;
	private String crediterAccNo;
	private int debiterAccBal;
	private int crediterAccBal;
	private int loggedInUserAccBal;
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Object loggedInUserId = req.getSession().getAttribute("LoggedInUserID");
	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
	String sql1="select * from account_details where user_id='"+loggedInUserId+"'";
	String selectOperation=req.getParameter("Transaction");
	try {
		Connection connection=GetDBConnection.getDBConnection();
		Statement stmt=connection.createStatement();
		ResultSet rs=stmt.executeQuery(sql1);
		while(rs.next()){
			this.loggedInUserAccNo=rs.getInt("Account_No");
		}
		
		
		if("DebitFrom".equals(selectOperation)){
			 debiterAccNo=req.getParameter("AccountNo");
			 String sql2="select * from account_details where Account_No='"+debiterAccNo+"'";
			 ResultSet rs2=stmt.executeQuery(sql2);
			 while(rs2.next()){
				 this.debiterAccBal=rs2.getInt("Balance");
			 }
			 
			 String sql3="select * from account_details where Account_No='"+loggedInUserAccNo+"'";
			 ResultSet rs3=stmt.executeQuery(sql3);
			 while(rs3.next()){
				 this.loggedInUserAccBal=rs3.getInt("Balance");
			 }
			 
			 String Amount=req.getParameter("Amount");
			 int transferAmount=Integer.parseInt(Amount);
			 
			 if(transferAmount<debiterAccBal){
				 int loggedInUserAccNewBal=loggedInUserAccBal+transferAmount;
				 int debiterAccNewBal=debiterAccBal-transferAmount;
				 String sql4="update account_details set Balance='"+loggedInUserAccNewBal+"' where Account_No='"+loggedInUserAccNo+"'";
				 String sql5="update account_details set Balance='"+debiterAccNewBal+"' where Account_No='"+debiterAccNo+"'";
				 stmt.executeUpdate(sql4);
				 stmt.executeUpdate(sql5);
				
					
				 RequestDispatcher rds=req.getRequestDispatcher("OwnTransfers.jsp");
				 rds.include(req, resp);
				 out.println("<script type=\"text/javascript\">");
			       out.println("success();");
			       out.println("</script>");
				 connection.close();
				 String chequeNo=null;
				 int withdrawlAmount=0;
				 saveLoggedInUserTransactionHistory("Transferred into my account", chequeNo, withdrawlAmount, transferAmount, loggedInUserAccNewBal,loggedInUserAccNo);
				 
				 otherUserAccTransactions("Transferred from my account", chequeNo, transferAmount, 0, debiterAccNewBal, debiterAccNo);
				 
				 EmailDemo.transactionDebitEmailwithAccNo(crediterAccNo, transferAmount);
				 
			 }else  if(transferAmount>debiterAccBal){
				 System.out.println("No bal");
			 out.println("Insufficient Balance in your account.");
				 RequestDispatcher dispatcher=req.getRequestDispatcher("OwnTransfers.jsp");
				 dispatcher.include(req, resp);
				 out.println("<script type=\"text/javascript\">");
			       out.println("noBalance();");
			       out.println("</script>");
			 }
			 
			

		}else
			if("CreditTo".equals(selectOperation)){
				crediterAccNo=req.getParameter("AccountNo");
				String sql6="select * from account_details where Account_No='"+crediterAccNo+"'";
				ResultSet rs4=stmt.executeQuery(sql6);
				while(rs4.next()){
					this.crediterAccBal=rs4.getInt("Balance");
					
				}
				
				String sql7="select * from account_details where Account_No='"+loggedInUserAccNo+"'";
				ResultSet rs5=stmt.executeQuery(sql7);
				while (rs5.next()) {
					this.loggedInUserAccBal=rs5.getInt("Balance");
					
				}
				
				 String Amount=req.getParameter("Amount");
				 int transferAmount=Integer.parseInt(Amount);
				 
				if(transferAmount<loggedInUserAccBal){
					 int loggedInUserAccNewBal=loggedInUserAccBal-transferAmount; 
					 int crediterAccNewBalance=crediterAccBal+transferAmount;
					 String sql8="update account_details set Balance='"+loggedInUserAccNewBal+"' where Account_No='"+loggedInUserAccNo+"'";
					 String sql9="update account_details set Balance='"+crediterAccNewBalance+"' where Account_No='"+crediterAccNo+"'";
					 stmt.executeUpdate(sql8);
					 stmt.executeUpdate(sql9);
					 
					 RequestDispatcher rds=req.getRequestDispatcher("OwnTransfers.jsp");
					 rds.include(req, resp);
					 out.println("<script type=\"text/javascript\">");
				       out.println("success();");
				       out.println("</script>");
					 connection.close();
					 System.out.println("credited successfully.");
					 String chequeNo=null;
					 saveLoggedInUserTransactionHistory("Transferred from my account", chequeNo, transferAmount, 0, loggedInUserAccNewBal, loggedInUserAccNo);
					 
					 otherUserAccTransactions("Transferred in my account", chequeNo, 0, transferAmount, crediterAccNewBalance, crediterAccNo);
					 EmailDemo.transactionCreditEmailwithAccNo(crediterAccNo, transferAmount);
				}else if(transferAmount>loggedInUserAccBal){
					out.println("Insufficient Balance in your account.");
					RequestDispatcher dispatcher=req.getRequestDispatcher("OwnTransfers.jsp");
					 dispatcher.include(req, resp);
					 out.println("<script type=\"text/javascript\">");
				       out.println("noBalance();");
				       out.println("</script>");
				}
					 
					
					
			}
			
	} catch (Exception e) {
		// TODO: handle exception
	}
	
}
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req, resp);
}
}
