package com.tcs.bank.Customer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
private static SessionFactory factory;
static{
	try {
		factory=new Configuration().configure().buildSessionFactory();
	} catch (Throwable e) {
		System.err.println("Failed to create session factory object."+e);
		throw new ExceptionInInitializerError(e);
	}
	
}

public static SessionFactory getSessionFactory(){
	return factory;
}
public static void main(String[] args) {
	Date date=new Date();
	String creationDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	System.out.println(creationDate);
	
	}
}
