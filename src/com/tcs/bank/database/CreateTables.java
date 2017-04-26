package com.tcs.bank.database;
import static com.tcs.bank.database.GetDBConnection.getDBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {
public static void main(String[] args) {
	try {
		Connection connection=getDBConnection();
		Statement stmt=connection.createStatement();
		//create tables
		String sql1="CREATE TABLE user_pass(user_id VARCHAR(20) NOT NULL,user_password VARCHAR(45) NOT NULL,PRIMARY KEY(user_id))";
		stmt.executeUpdate(sql1);
		System.out.println("user_pass Table successfully created.");
		String sql2="CREATE table account_details(Account_No int(10) not null, Name varchar(30) not null,DOB date not null, Address varchar(100) not null,Email varchar(30) not null,Type_of_Account varchar(45) not null, Balance double,user_id varchar(45) not null, primary key(Account_No), constraint fk_PerAccount_details foreign key(user_id) references user_pass(user_id))";
		stmt.executeUpdate(sql2);
		System.out.println("account_details table successfully created.");
		String sql3="create table transactions(Sr_No int not null, Date date, Description varchar(45) , Cheque_No varchar(45), Withdraw varchar(45), Deposit varchar(45), Available_Balance varchar(45), Account_No varchar(45), primary key(Sr_No))";
		stmt.executeUpdate(sql3);
		System.out.println("transactions table successfully created.");
		String sql4="create table credit_card(Name varchar(45) not null, Card_Number varchar(20) not null, CVV2 varchar(3) not null, Account_No int(10), primary key(Card_Number), constraint fk_Percredit_card foreign key(Account_No) references account_details(Account_No))";
		stmt.executeUpdate(sql4);
		System.out.println("credit_card table created.");
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
