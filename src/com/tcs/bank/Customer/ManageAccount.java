package com.tcs.bank.Customer;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class ManageAccount {

	public Integer addAccount(String name, String dob, String address, String email, String typeOfAcc, double balance, String user_id, String creationDate){
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		Integer accPrimaryKey=null;
		try {
			tx=session.beginTransaction();
			AccountDetails details=new AccountDetails(name, dob, address, email, typeOfAcc, balance, user_id, creationDate);
			accPrimaryKey=(Integer)session.save(details);
			tx.commit();
		} catch (HibernateException e) {
			if(tx!=null){
				tx.rollback();
				e.printStackTrace();
			}
			
		}finally {
			session.close();
		}
		return accPrimaryKey;
	}
}



