package com.tcs.bank.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GetDBConnection  {
public static Connection connection;
public static Connection getDBConnection() throws ClassNotFoundException, SQLException{
	Class.forName("com.mysql.jdbc.Driver");
	Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/louisvillebank","root","7417899737");
	return connection;
	
}
}
