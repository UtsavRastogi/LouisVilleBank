package com.tcs.bank.accountcreation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.tcs.bank.database.GetDBConnection;

public class AccountNoGenerator {
	public static int AccountNumber(){
		int i = 0;
		int newAccNo=0;
		try {
			Connection connection=GetDBConnection.getDBConnection();
			Statement stmt=connection.createStatement();
			String sql1="select Account_No from account_details order by Account_No DESC LIMIT 1";
			stmt.executeQuery(sql1);
			ResultSet rs=stmt.getResultSet();
			
			while(rs.next()){
				int c=rs.getInt("Account_No");
				i=c;
			}
			newAccNo=i+1;
			System.out.println(newAccNo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return newAccNo;
	}
	public static void main(String[] args) {
		System.out.println();
		
	}
}
