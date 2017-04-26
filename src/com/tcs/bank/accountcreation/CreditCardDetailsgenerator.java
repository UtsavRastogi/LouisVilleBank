package com.tcs.bank.accountcreation;
import static com.tcs.bank.database.GetDBConnection.getDBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;
import java.util.stream.LongStream;

public class CreditCardDetailsgenerator {
public static void generateCreditCardDetails(String name,int account_No){
	try {
		Connection connection=getDBConnection();
		int newCvv2No=cvv2();
		Long newCardNumber=cardNumber();
		String expirydate="17/37";
		String sql1="insert into credit_card values('"+name+"','"+newCardNumber+"','"+newCvv2No+"','"+account_No+"','"+expirydate+"')";
	Statement stmt=connection.createStatement();
	stmt.executeUpdate(sql1);
	connection.close();
	
	} catch (Exception e) {
		// TODO: handle exception
	}
}
public static int cvv2(){
	Random r = new Random();
	int Low = 100;
	int High = 999;
	int Result = r.nextInt(High-Low) + Low;
	return Result;
}
public static  Long cardNumber(){
        long leftLimit = 5924006183596376l;
	    long rightLimit = 9999999999999999l;
	    long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));

	
	return generatedLong;
}

}
