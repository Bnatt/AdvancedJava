package com.bhuvana.dto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bhuvana.hibernate.utilities.HibernateUtil;

public class BookTest {

	public static void main(String[] args) {
		Book book = new Book();
		book.setBookName("Yavana Rani");
		
		Address add1 = new Address();
		add1.setStreet("First st");
		add1.setCity("Alpharetta");
		
		Address add2 = new Address();
		add2.setStreet("First st");
		add2.setCity("Alpharetta");
		
		book.getListOfAdd().add(add1);
		book.getListOfAdd().add(add2);
		
		SessionFactory factory = HibernateUtil.createSessionFactory();
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		try {
			session.save(book);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			session.close();
		}
		
		session = factory.openSession();
		book = null;
		book = (Book) session.get(Book.class, 1);
		session.close();
		System.out.println(book.getListOfAdd().size());
		
	}
}