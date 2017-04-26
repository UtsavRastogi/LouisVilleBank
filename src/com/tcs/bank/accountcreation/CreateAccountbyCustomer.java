package com.tcs.bank.accountcreation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tcs.bank.Customer.GetAccountBalance;
import com.tcs.bank.database.GetDBConnection;
import com.tcs.bank.mailing.EmailDemo;
import com.tcs.bank.transactions.TransactionDetails;

public class CreateAccountbyCustomer extends HttpServlet {
	private int withdraweraccno;
	private Connection connection;
	private 	Statement stmt;
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
	try {
		connection=GetDBConnection.getDBConnection();
		stmt=connection.createStatement();
		System.out.println("Hello");
		HttpSession session=req.getSession();
		String logedInUserId=session.getAttribute("LoggedInUserID").toString();
		String sql11="select * from account_details where user_id='"+logedInUserId+"'";
		ResultSet rs=stmt.executeQuery(sql11);
		while(rs.next()){
			this.withdraweraccno=rs.getInt("Account_No");
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	int withdraweebal=0;
	if((withdraweebal=GetAccountBalance.getAccountBalance(withdraweraccno))>=25000){
		try {
			System.out.println("Hello1");
			String user_id=CreateUserIdPassword.NewUserId();
			CreateUserIdPassword.saveNewCredentialsToUser_Pass();
			String name,dob,address,email,typeofacc;
			int account_no=AccountNoGenerator.AccountNumber();
			name=req.getParameter("UserName").toString();
			dob=req.getParameter("dob").toString();
			address=req.getParameter("address").toString();
			email=req.getParameter("email").toString();
			typeofacc=req.getParameter("TypeOfAccount").toString();
			int balance=25000;
			Date date=new Date();
			String creationDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			String sql2="insert into account_details values('"+account_no+"','"+name+"','"+dob+"','"+address+"','"+email+"','"+typeofacc+"','"+balance+"','"+user_id+"','"+creationDate+"')";
			
			stmt.executeUpdate(sql2);
			int newBal=withdraweebal-25000;
		 String	sql3="update account_details set Balance='"+newBal+"' where Account_No='"+withdraweraccno+"'";
		 stmt.executeUpdate(sql3);
		 CreditCardDetailsgenerator.generateCreditCardDetails(name, account_no);
		 TransactionDetails.saveLoggedInUserTransactionHistory("Account Created from your deposits", null, 25000, 0, newBal, withdraweraccno);
		 TransactionDetails.otherUserAccTransactions("Account Created ", null, 0, 25000, 25000, account_no );
		 String acc=String.valueOf(account_no);
				EmailDemo.accountOpeningEmail(email, name, user_id, acc);
				EmailDemo.transactionCreditEmail(user_id, "25000");
				EmailDemo.transactionDebitEmailwithAccNo(withdraweraccno, "25000");
		 connection.close();
			RequestDispatcher rd=req.getRequestDispatcher("createaccountbycus.jsp");
			rd.include(req, resp);
			out.println("<script type=\"text/javascript\">");
		       out.println("successfull();");
		       out.println("</script>");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}else{
		RequestDispatcher rd=req.getRequestDispatcher("createaccount.jsp");
		rd.include(req, resp);
		out.println("<script type=\"text/javascript\">");
	       out.println("noBalance();");
	       out.println("</script>");
	}
	
	

	
}

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req, resp);
}
}
