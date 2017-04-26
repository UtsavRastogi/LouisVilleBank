package com.tcs.bank.transactions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tcs.bank.database.GetDBConnection;

public class Dispay {
public static void main(String[] args) {
	try {
		Connection connection=GetDBConnection.getDBConnection();
		Statement statement=connection.createStatement();
		String sql="SELECT * FROM transactions where Date between '2017-04-16' and '2017-04-17' and Account_No=1814602186";
		ResultSet set=statement.executeQuery(sql);
		while(set.next()){
			System.out.println(set.getString("Date")+" "+set.getString("Description")+" "+set.getString("Withdraw")+" "+set.getString("Deposit")+" "+set.getString("Available_Balance")+" "+set.getString("Account_No"));
			System.out.println();
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
