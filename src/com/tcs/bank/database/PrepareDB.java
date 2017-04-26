package com.tcs.bank.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PrepareDB {
	 // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost";
	   
	//  Database credentials
	   static final String USER = "root";   //Change accordingly
	   static final String PASS = "7417899737";   //Change accordingly
	   public static void main(String[] args) {
		
		   Connection conn = null;
		   Statement stmt = null;
		   
		   //Register JDBC Driver
		   try {
			Class.forName("com.mysql.jdbc.Driver");
			  conn = DriverManager.getConnection(DB_URL, USER, PASS);
			 
			 //STEP 4: Execute a query
			  stmt = conn.createStatement();
			  //create a schema
			  String sql = "CREATE DATABASE LouisvilleBank";
		      stmt.executeUpdate(sql);
			  System.out.println("Database Created");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   finally {
			 //finally block used to close resources
			try {
				if(stmt!=null)
		            stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
			 try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		}
		   
		   
	}
}
