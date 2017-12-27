package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private HibernateUtil(){}

    private static SessionFactory sessionFactory;



    public static SessionFactory getSessionFactory() {
        if (sessionFactory==null){
            Configuration config = new Configuration().configure();
            StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
            StandardServiceRegistry ssr = ssrb.build();
            sessionFactory = config.buildSessionFactory(ssr);
            return sessionFactory;

        }else {
            return sessionFactory;
        }

    }
    public static final ThreadLocal<Session> session = new ThreadLocal<Session>();

    public static Session getCurrentSession() {
        Session s = (Session) session.get();
        if (s == null || !s.isOpen()) {
            s = sessionFactory.openSession();
            session.set(s);
        }
        return s;
    }

    public static void closeSession(Session session) {

        if (null != session) {
            session.close();
        }
    }
}