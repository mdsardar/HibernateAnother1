package com.jwt.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SimpleSelect {
	public static Session session = HibernateUtil.getSessionFactory().openSession();
	public static void main(String[] args) {
		 
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
 
        /*SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();*/
        Transaction tx = session.beginTransaction();
 
        // Get All Employees
        Query query = session.createQuery("from Student");
        List<Student> list = (List<Student>) query.list();
        for (Student st : list) {
            System.out.println("List of Employees::" + st.getId() + ","
                    + st.getName() + "," + st.getDegree());
        }
        // Get Employee with id
        query = session.createQuery("from Student where id= :id");
        query.setLong("id", 1);
        Student stu = (Student) query.uniqueResult();
		System.out.println("Student Name=" + stu.getName() + ", Degre=" + stu.getDegree());
 
        tx.commit();
        session.close();
        
    }

}
