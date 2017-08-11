package com.jwt.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertData {
	public static Session session = HibernateUtil.getSessionFactory().openSession();
	public static void main(String[] args) {		
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
 
//        SessionFactory factory = 
//        Session session = factory.openSession();
        Student student = new Student();
        student.setName("Ravi");
        student.setRoll("102");
        student.setPhone("8888");
        student.setDegree("B.E");
 
        Student student1 = new Student();
        student1.setName("Mukesh");
        student1.setRoll("103");
        student1.setPhone("9999");
        student1.setDegree("B.E");
 
        Transaction tx = session.beginTransaction();
        session.save(student);
        session.save(student1);
        System.out.println("Object saved successfully.....!!");
        tx.commit();
        session.close();        
    }

}
