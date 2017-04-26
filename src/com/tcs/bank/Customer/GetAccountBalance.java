package com.tcs.bank.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.tcs.bank.database.GetDBConnection;

public class GetAccountBalance {
	public static int getAccountBalance(String accountNO){
		int i = 0;
		int balance=0;
		try {
			Connection connection=GetDBConnection.getDBConnection();
			Statement stmt=connection.createStatement();
			String sql1="select Balance from account_details where Account_No='"+accountNO+"'";
			stmt.executeQuery(sql1);
			ResultSet rs=stmt.getResultSet();
			
			while(rs.next()){
				int c=rs.getInt("Balance");
				i=c;
			}
			balance=i;
			connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return balance;
	}
	
	public static int getAccountBalance(int accountNO){
		int i = 0;
		int balance=0;
		try {
			Connection connection=GetDBConnection.getDBConnection();
			Statement stmt=connection.createStatement();
			String sql1="select Balance from account_details where Account_No='"+accountNO+"'";
			stmt.executeQuery(sql1);
			ResultSet rs=stmt.getResultSet();
			
			while(rs.next()){
				int c=rs.getInt("Balance");
				i=c;
			}
			balance=i;
			connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return balance;
	}
	
	
	
}
