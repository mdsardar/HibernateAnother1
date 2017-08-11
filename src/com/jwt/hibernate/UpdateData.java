package com.jwt.hibernate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateData {
	public static Session session = HibernateUtil.getSessionFactory().openSession();
	public static void main(String[] args) {
		 
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
 
       /* SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();*/
        Transaction tx = session.beginTransaction();
 
        // Update Employee
        Query query = session
                .createQuery("update Student set name= :name where id= :id");
        query.setParameter("name", "Amit Raj");
        query.setLong("id", 1);
        int result = query.executeUpdate();
        System.out.println("Student data Update Status=" + result);
 
        // Delete Employee, we need to take care of foreign key constraints too
        query = session.createQuery("delete from Student where id= :id");
        query.setLong("id", 3);
        result = query.executeUpdate();
        System.out.println("Student Data Delete Status=" + result);
 
        tx.commit();
        session.close();        
    }

}
