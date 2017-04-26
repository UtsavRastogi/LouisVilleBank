package com.tcs.bank.mailing;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class EmailSender {
public static boolean sendLoginEmail(String from, String password,String message, String to[]){
	String host="smtp.gmail.com";
	Properties props=System.getProperties();
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", host);
	props.put("mail.smtp.user", from);
	props.put("mail.smtp.password", password);
	props.put("mail.smtp.port", 587);
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.port", 587);
	Session session=Session.getDefaultInstance(props,null);
	MimeMessage mimeMessage=new MimeMessage(session);
	try {
		mimeMessage.setFrom(new InternetAddress(from));
		//now get the address of the recipient 
		InternetAddress[] toAddresses=new InternetAddress[to.length];
		
		for(int i=0;i<to.length;i++){
			toAddresses[i]=new InternetAddress(to[i]);
			
		}
		for (int i = 0; i < toAddresses.length; i++) {
			mimeMessage.addRecipient(RecipientType.TO, toAddresses[i]);
			}
		//add subject
		mimeMessage.setSubject("Account Login");
	
		//mimeMessage.setText(message);
		mimeMessage.setContent(message, "text/html; charset=utf-8");
		Transport transport=session.getTransport("smtp");
		transport.connect(host,from,password);
		transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
		transport.close();
		return true;
		
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
}
public static boolean sendNewAccEmail(String from, String password,String message, String to[]){
	String host="smtp.gmail.com";
	Properties props=System.getProperties();
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", host);
	props.put("mail.smtp.user", from);
	props.put("mail.smtp.password", password);
	props.put("mail.smtp.port", 587);
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.port", 587);
	Session session=Session.getDefaultInstance(props,null);
	MimeMessage mimeMessage=new MimeMessage(session);
	try {
		mimeMessage.setFrom(new InternetAddress(from));
		//now get the address of the recipient 
		InternetAddress[] toAddresses=new InternetAddress[to.length];
		
		for(int i=0;i<to.length;i++){
			toAddresses[i]=new InternetAddress(to[i]);
			
		}
		for (int i = 0; i < toAddresses.length; i++) {
			mimeMessage.addRecipient(RecipientType.TO, toAddresses[i]);
			}
		//add subject
		mimeMessage.setSubject("Welcome");
	
		//mimeMessage.setText(message);
		mimeMessage.setContent(message, "text/html; charset=utf-8");
		Transport transport=session.getTransport("smtp");
		transport.connect(host,from,password);
		transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
		transport.close();
		return true;
		
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
}

public static boolean sendAccDebitEmail(String from, String password,String message, String to[]){
	String host="smtp.gmail.com";
	Properties props=System.getProperties();
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", host);
	props.put("mail.smtp.user", from);
	props.put("mail.smtp.password", password);
	props.put("mail.smtp.port", 587);
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.port", 587);
	Session session=Session.getDefaultInstance(props,null);
	MimeMessage mimeMessage=new MimeMessage(session);
	try {
		mimeMessage.setFrom(new InternetAddress(from));
		//now get the address of the recipient 
		InternetAddress[] toAddresses=new InternetAddress[to.length];
		
		for(int i=0;i<to.length;i++){
			toAddresses[i]=new InternetAddress(to[i]);
			
		}
		for (int i = 0; i < toAddresses.length; i++) {
			mimeMessage.addRecipient(RecipientType.TO, toAddresses[i]);
			}
		//add subject
		mimeMessage.setSubject("Account Debit.");
	
		//mimeMessage.setText(message);
		mimeMessage.setContent(message, "text/html; charset=utf-8");
		Transport transport=session.getTransport("smtp");
		transport.connect(host,from,password);
		transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
		transport.close();
		return true;
		
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
}

public static boolean sendAccCreditEmail(String from, String password,String message, String to[]){
	String host="smtp.gmail.com";
	Properties props=System.getProperties();
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", host);
	props.put("mail.smtp.user", from);
	props.put("mail.smtp.password", password);
	props.put("mail.smtp.port", 587);
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.port", 587);
	Session session=Session.getDefaultInstance(props,null);
	MimeMessage mimeMessage=new MimeMessage(session);
	try {
		mimeMessage.setFrom(new InternetAddress(from));
		//now get the address of the recipient 
		InternetAddress[] toAddresses=new InternetAddress[to.length];
		
		for(int i=0;i<to.length;i++){
			toAddresses[i]=new InternetAddress(to[i]);
			
		}
		for (int i = 0; i < toAddresses.length; i++) {
			mimeMessage.addRecipient(RecipientType.TO, toAddresses[i]);
			}
		//add subject
		mimeMessage.setSubject("Account Credit.");
	
		//mimeMessage.setText(message);
		mimeMessage.setContent(message, "text/html; charset=utf-8");
		Transport transport=session.getTransport("smtp");
		transport.connect(host,from,password);
		transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
		transport.close();
		return true;
		
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
}



public static boolean sendTransactionEmail(String from, String password,String message, String to[]){
	String host="smtp.gmail.com";
	Properties props=System.getProperties();
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", host);
	props.put("mail.smtp.user", from);
	props.put("mail.smtp.password", password);
	props.put("mail.smtp.port", 587);
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.port", 587);
	Session session=Session.getDefaultInstance(props,null);
	MimeMessage mimeMessage=new MimeMessage(session);
	try {
		mimeMessage.setFrom(new InternetAddress(from));
		//now get the address of the recipient 
		InternetAddress[] toAddresses=new InternetAddress[to.length];
		
		for(int i=0;i<to.length;i++){
			toAddresses[i]=new InternetAddress(to[i]);
			
		}
		for (int i = 0; i < toAddresses.length; i++) {
			mimeMessage.addRecipient(RecipientType.TO, toAddresses[i]);
			}
		//add subject
		mimeMessage.setSubject("Transaction Successfull.");
	
		//mimeMessage.setText(message);
		mimeMessage.setContent(message, "text/html; charset=utf-8");
		Transport transport=session.getTransport("smtp");
		transport.connect(host,from,password);
		transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
		transport.close();
		return true;
		
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
}
}
