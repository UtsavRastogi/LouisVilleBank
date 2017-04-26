package com.tcs.bank.transactions;
import static com.tcs.bank.database.GetDBConnection.getDBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionDetails {
	
	public static void saveLoggedInUserTransactionHistory(String description,String chequeNo,int withdrawlAmount,int depositedAmount,int currentBal,String accountNo){
try {
			Connection connection=getDBConnection();
			Statement stmt=connection.createStatement();
			
			
			Date d=new Date();
			SimpleDateFormat dft=new SimpleDateFormat("yyyy-MM-dd");
			String date=dft.format(d);  //Date
			
			
			String sql10="select Sr_No from transactions order by Sr_No DESC LIMIT 1";
			 ResultSet rs=stmt.executeQuery(sql10);
			int SrNo = 0;                    //serial no to assign in table
			while(rs.next()){
				int c=rs.getInt("Sr_No");
				SrNo=c+1;
			}
			
			String sql12="insert into transactions values('"+SrNo+"','"+date+"','"+description+"','"+chequeNo+"','"+withdrawlAmount+"','"+depositedAmount+"','"+currentBal+"','"+accountNo+"')";
			Statement stm=connection.createStatement();
			stm.executeUpdate(sql12);
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void saveLoggedInUserTransactionHistory(String description,String chequeNo,int withdrawlAmount,int depositedAmount,int currentBal,int accountNo){
		try {
					Connection connection=getDBConnection();
					Statement stmt=connection.createStatement();
					
					
					Date d=new Date();
					SimpleDateFormat dft=new SimpleDateFormat("yyyy-MM-dd");
					String date=dft.format(d);  //Date
					
					
					String sql10="select Sr_No from transactions order by Sr_No DESC LIMIT 1";
					 ResultSet rs=stmt.executeQuery(sql10);
					int SrNo = 0;                    //serial no to assign in table
					while(rs.next()){
						int c=rs.getInt("Sr_No");
						SrNo=c+1;
					}
					
					String sql12="insert into transactions values('"+SrNo+"','"+date+"','"+description+"','"+chequeNo+"','"+withdrawlAmount+"','"+depositedAmount+"','"+currentBal+"','"+accountNo+"')";
					Statement stm=connection.createStatement();
					stm.executeUpdate(sql12);
					connection.close();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
	
	public static void otherUserAccTransactions(String description,String chequeNo,int withdrawlAmount,int depositedAmount,int currentBal,int accountNo){
try {
			Connection connection=getDBConnection();
			Statement stmt=connection.createStatement();
			
			
			Date d=new Date();
			SimpleDateFormat dft=new SimpleDateFormat("yyyy-MM-dd");
			String date=dft.format(d);  //Date
			
			
			String sql10="select Sr_No from transactions order by Sr_No DESC LIMIT 1";
			 ResultSet rs=stmt.executeQuery(sql10);
			int SrNo = 0;                    //serial no to assign in table
			while(rs.next()){
				int c=rs.getInt("Sr_No");
				SrNo=c+1;
			}
			
			String sql12="insert into transactions values('"+SrNo+"','"+date+"','"+description+"','"+chequeNo+"','"+withdrawlAmount+"','"+depositedAmount+"','"+currentBal+"','"+accountNo+"')";
			Statement stm=connection.createStatement();
			stm.executeUpdate(sql12);
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void otherUserAccTransactions(String description,String chequeNo,int withdrawlAmount,int depositedAmount,int currentBal,String accountNo){
		try {
					Connection connection=getDBConnection();
					Statement stmt=connection.createStatement();
					
					
					Date d=new Date();
					SimpleDateFormat dft=new SimpleDateFormat("yyyy-MM-dd");
					String date=dft.format(d);  //Date
					
					
					String sql10="select Sr_No from transactions order by Sr_No DESC LIMIT 1";
					 ResultSet rs=stmt.executeQuery(sql10);
					int SrNo = 0;                    //serial no to assign in table
					while(rs.next()){
						int c=rs.getInt("Sr_No");
						SrNo=c+1;
					}
					
					String sql12="insert into transactions values('"+SrNo+"','"+date+"','"+description+"','"+chequeNo+"','"+withdrawlAmount+"','"+depositedAmount+"','"+currentBal+"','"+accountNo+"')";
					Statement stm=connection.createStatement();
					stm.executeUpdate(sql12);
					connection.close();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
}
