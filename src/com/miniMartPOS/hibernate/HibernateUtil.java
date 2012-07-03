/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miniMartPOS.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author srikanthmuppavarapu
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static Session beginTransaction(){
        Session hibernateSession;
        
        hibernateSession = getSessionFactory().getCurrentSession();
        hibernateSession.beginTransaction();
        
        return hibernateSession;
    }
    
    public static void commitTransaction(){
        Session hibernateSession = getSessionFactory().getCurrentSession();
        hibernateSession.getTransaction().commit();
    }
    
    public static void rollbackTransaction(){
        Session hibernateSession = getSessionFactory().getCurrentSession();
        hibernateSession.getTransaction().rollback();
    }
    
    public static void closeSession(){
        getSessionFactory().getCurrentSession().close();
    }
}
