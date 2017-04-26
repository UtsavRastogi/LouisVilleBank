package com.tcs.bank.mailing;

import static com.tcs.bank.database.GetDBConnection.getDBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmailDemo {
	private static String acccemail=null;
	private static String email;
	 private static String name;
     private static String password;
     private static String cardNO;
     private static String Cvv2;
	private static String emailFrmAccNO;
	private static String nameacc;
	 public static void accountOpeningEmail(String emailId, String name,String UserId,String Acc_No){
		String User_pass=findPassword(UserId);
		String card_No=findCardNo(Acc_No);
		String cvv2=findCvv2(Acc_No);
		 String to[]={emailId};
			System.out.println("Sending account opening email.");
			if(EmailSender.sendNewAccEmail
					("louisvillebanks@gmail.com",
							"7417899737",
							"<img alt=\"Louisville Banks\" src=\"http://images.clipartpanda.com/bank-clipart-cliparti1_bank-clipart_02.jpg\">"
							+ "<h1>Dear "+name+", <br>We welcomes you at Louisville family.<br>"
									+ "Your Login Credentials :<br>"
									+ "User ID:"+UserId+"<br>"
											+ "Password: "+User_pass+"<br><br>"
													+ "Your Account Numbar :"+Acc_No+"<br>"
															+ "Your Card No: "+card_No+"<br>"
																	+ " CVV2 No: "+cvv2+"<br>"
																			+ "Expiry Date: 17/37 <br>"
									+ "Thanks & Regards<br> Team Louisville</h1> ", 
							to))System.out.println("email sent successfully");
			else
				System.out.println("some error occured");
	 }
	
public static void sendLoggedInUserEmail(String emailId,String name){
	String to[]={emailId};
	System.out.println("Sending Login email.");
	if(EmailSender.sendLoginEmail
			("louisvillebanks@gmail.com",
					"7417899737",
					"<img alt=\"Louisville Banks\" src=\"https://s-media-cache-ak0.pinimg.com/originals/ef/b7/22/efb722a1b4fbf928038ee3ec06b74935.jpg\">"
					+ "<h1>Dear "+name+", <br>You have just logged in successfully. We welcomes you again.<br>Thanks & Regards<br> Team Louisville</h1> ", 
					to))System.out.println("email sent successfully");
	else
		System.out.println("some error occured");
     
}


public static void transactionDebitEmailwithAccNo(String accNo,String amount){
	String emailId=findEmailFromAcc(accNo);
	String name=findNamefromAccNO(accNo);
	String to[]={emailId};
	System.out.println("Sending Login email.");
	if(EmailSender.sendAccDebitEmail
			("louisvillebanks@gmail.com",
					"7417899737",
					"<img alt=\"Louisville Banks\" src=\"https://s-media-cache-ak0.pinimg.com/originals/ef/b7/22/efb722a1b4fbf928038ee3ec06b74935.jpg\">"
					+ "<h1>Dear "+name+", <br>.Your account is successfully debited by "+amount+".<br>Thanks & Regards<br> Team Louisville</h1> ", 
					to))System.out.println("email sent successfully");
	else
		System.out.println("some error occured");
     
}


public static void transactionDebitEmailwithAccNo(int accNo,String amount){
	String emailId=findEmailFromAcc(accNo);
	String name=findNamefromAccNO(accNo);
	String to[]={emailId};
	System.out.println("Sending Login email.");
	if(EmailSender.sendAccDebitEmail
			("louisvillebanks@gmail.com",
					"7417899737",
					"<img alt=\"Louisville Banks\" src=\"https://s-media-cache-ak0.pinimg.com/originals/ef/b7/22/efb722a1b4fbf928038ee3ec06b74935.jpg\">"
					+ "<h1>Dear "+name+", <br>.Your account is successfully debited by "+amount+".<br>Thanks & Regards<br> Team Louisville</h1> ", 
					to))System.out.println("email sent successfully");
	else
		System.out.println("some error occured");
     
}

public static void transactionDebitEmailwithAccNo(String accNo,int amount){
	String emailId=findEmailFromAcc(accNo);
	String name=findNamefromAccNO(accNo);
	String to[]={emailId};
	System.out.println("Sending Login email.");
	if(EmailSender.sendAccDebitEmail
			("louisvillebanks@gmail.com",
					"7417899737",
					"<img alt=\"Louisville Banks\" src=\"https://s-media-cache-ak0.pinimg.com/originals/ef/b7/22/efb722a1b4fbf928038ee3ec06b74935.jpg\">"
					+ "<h1>Dear "+name+", <br>.Your account is successfully debited by "+amount+".<br>Thanks & Regards<br> Team Louisville</h1> ", 
					to))System.out.println("email sent successfully");
	else
		System.out.println("some error occured");
     
}

public static void transactionCreditEmailwithAccNo(String accNo,int amount){
	String emailId=findEmailFromAcc(accNo);
	String name=findNamefromAccNO(accNo);
	String to[]={emailId};
	System.out.println("Sending Login email.");
	if(EmailSender.sendAccCreditEmail
			("louisvillebanks@gmail.com",
					"7417899737",
					"<img alt=\"Louisville Banks\" src=\"https://s-media-cache-ak0.pinimg.com/originals/ef/b7/22/efb722a1b4fbf928038ee3ec06b74935.jpg\">"
					+ "<h1>Dear "+name+", <br>.Your account is successfully credited by "+amount+".<br>Thanks & Regards<br> Team Louisville</h1> ", 
					to))System.out.println("email sent successfully");
	else
		System.out.println("some error occured");
     
}

public static void transactionCreditEmail(String UserID,String amount){
	String name=findName(UserID);
	String emailId1=findEmail(UserID);
	String to[]={emailId1};
	System.out.println("Sending Login email.");
	if(EmailSender.sendLoginEmail
			("louisvillebanks@gmail.com",
					"7417899737",
					"<img alt=\"Louisville Banks\" src=\"https://s-media-cache-ak0.pinimg.com/originals/ef/b7/22/efb722a1b4fbf928038ee3ec06b74935.jpg\">"
					+ "<h1>Dear "+name+", <br>.Your account is successfully credited by "+amount+".<br>Thanks & Regards<br> Team Louisville</h1> ", 
					to))System.out.println("email sent successfully");
	else
		System.out.println("some error occured");
     
}

public static  String findEmail(String UserID){
	try {
		
		Connection connection=getDBConnection();
		String sql="select Email from account_details where user_id='"+UserID+"'";
		Statement statement=connection.createStatement();
		statement.executeQuery(sql);
		ResultSet resultSet=statement.getResultSet();
		while(resultSet.next()){
			email=resultSet.getString("Email").toString();
			System.out.println(email);
			}
		connection.close();
		
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return email;
}


public static  String findEmailFromAcc(String accNo){
	
	try {
		
		Connection connection=getDBConnection();
		String sql="select Email from account_details where Account_No='"+accNo+"'";
		Statement statement=connection.createStatement();
		statement.executeQuery(sql);
		ResultSet resultSet=statement.getResultSet();
		while(resultSet.next()){
			acccemail=resultSet.getString("Email").toString();
			
			}
		connection.close();
		
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return acccemail;
}


public static  String findEmailFromAcc(int accNo){
	
	try {
		
		Connection connection=getDBConnection();
		String sql="select Email from account_details where Account_No='"+accNo+"'";
		Statement statement=connection.createStatement();
		statement.executeQuery(sql);
		ResultSet resultSet=statement.getResultSet();
		while(resultSet.next()){
			acccemail=resultSet.getString("Email").toString();
			
			}
		connection.close();
		
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return acccemail;
}


public static String findName(String UserID){
	try {
		Connection connection=getDBConnection();
	    String sql2="select Name from account_details where user_id='"+UserID+"'";
	    Statement statement=connection.createStatement();
		ResultSet resultSet2=statement.executeQuery(sql2);
		while(resultSet2.next()){
			name=resultSet2.getString("Name").toString();
			System.out.println(name);
			}
		connection.close();
	} catch (Exception e) {
		// TODO: handle exception
	}
	return name;
	
}

public static String findNamefromAccNO(String accNo){
	try {
		Connection connection=getDBConnection();
	    String sql2="select Name from account_details where Account_No='"+accNo+"'";
	    Statement statement=connection.createStatement();
		ResultSet resultSet2=statement.executeQuery(sql2);
		while(resultSet2.next()){
			nameacc=resultSet2.getString("Name").toString();
			}
		connection.close();
	} catch (Exception e) {
		// TODO: handle exception
	}
	return nameacc;
	
}

public static String findNamefromAccNO(int accNo){
	try {
		Connection connection=getDBConnection();
	    String sql2="select Name from account_details where Account_No='"+accNo+"'";
	    Statement statement=connection.createStatement();
		ResultSet resultSet2=statement.executeQuery(sql2);
		while(resultSet2.next()){
			nameacc=resultSet2.getString("Name").toString();
			}
		connection.close();
	} catch (Exception e) {
		// TODO: handle exception
	}
	return nameacc;
	
}


public static String findPassword(String UserID){
	try {
		Connection connection=getDBConnection();
	    String sql2="select user_password from user_pass where user_id='"+UserID+"'";
	    Statement statement=connection.createStatement();
		ResultSet resultSet2=statement.executeQuery(sql2);
		while(resultSet2.next()){
			password=resultSet2.getString("user_password").toString();
			System.out.println(password);
			}
		connection.close();
	} catch (Exception e) {
		// TODO: handle exception
	}
	return password;
	
}

public static String findCardNo(String Acc_No){
	try {
		Connection connection=getDBConnection();
	    String sql2="select Card_Number from credit_card where Account_No='"+Acc_No+"'";
	    Statement statement=connection.createStatement();
		ResultSet resultSet2=statement.executeQuery(sql2);
		while(resultSet2.next()){
			cardNO=resultSet2.getString("Card_Number").toString();
			System.out.println(cardNO);
			}
		connection.close();
	} catch (Exception e) {
		// TODO: handle exception
	}
	return cardNO;
	
}

public static String findCvv2(String Acc_No){
	try {
		Connection connection=getDBConnection();
	    String sql2="select CVV2 from credit_card where Account_No='"+Acc_No+"'";
	    Statement statement=connection.createStatement();
		ResultSet resultSet2=statement.executeQuery(sql2);
		while(resultSet2.next()){
			Cvv2=resultSet2.getString("CVV2").toString();
			System.out.println(Cvv2);
			}
		connection.close();
	} catch (Exception e) {
		// TODO: handle exception
	}
	return Cvv2;
	
}


public static void sendEmailToJustLoggedInUser(String userID){
	EmailDemo.sendLoggedInUserEmail(EmailDemo.findEmail(userID), EmailDemo.findName(userID));
	
}
public static void main(String[] args) {
EmailDemo.transactionDebitEmailwithAccNo("1814602186", 2000);
}
	
}

