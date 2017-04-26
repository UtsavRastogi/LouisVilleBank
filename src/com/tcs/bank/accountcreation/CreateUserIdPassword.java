package com.tcs.bank.accountcreation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;

import com.tcs.bank.database.GetDBConnection;

public class CreateUserIdPassword {
	private static Random random = new Random((new Date()).getTime());
	   public static String generateNewPassword(int length) {
		      char[] values = {'a','b','c','d','e','f','g','h','i','j',
		               'k','l','m','n','o','p','q','r','s','t',
		               'u','v','w','x','y','z','0','1','2','3',
		               '4','5','6','7','8','9'};

		      String out = "";

		      for (int i=0;i<length;i++) {
		          int idx=random.nextInt(values.length);
		          out += values[idx];
		      }
		      return out;
		    }
	   
	   public static String NewUserId(){
		   String newUserId=null;
		   String s=null;
		   Long fResult=null;
		   Long result = null;
		   String i=null;
		   String UserId=null;
		   try {
			Connection connection=GetDBConnection.getDBConnection();
			Statement statement=connection.createStatement();
			String sql1="select user_id from user_pass order by user_id DESC LIMIT 1";
			statement.executeQuery(sql1);
			ResultSet rs=statement.getResultSet();
			while(rs.next()){
				String c=rs.getString("user_id").substring(3);
				i=c;
				
			}
			UserId=i;
			result = Long.valueOf(UserId);
			fResult=result+1;
			 s=String.valueOf(fResult);
			 String s1="LVC";
			 newUserId=s1+s;
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return newUserId;
	   }
	   
	   public static void saveNewCredentialsToUser_Pass(){
			String user_password=generateNewPassword(10);
			String user_id=NewUserId();
			String sql="insert into user_pass values('"+user_id+"','"+user_password+"')";
			try {
				Connection connection=GetDBConnection.getDBConnection();
				Statement stmt=connection.createStatement();
				stmt.executeUpdate(sql);
				connection.close();
			} catch (Exception e) {
				System.out.println("Duplicate");
			}
		}
	   
	   public static void main(String[] args) {
	String u=NewUserId();
	saveNewCredentialsToUser_Pass();
	System.out.println(u);
	}
}
