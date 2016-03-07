package com.dao;

import com.models.Biography;
import com.models.Player;
import com.models.Position;
import com.models.Statistics;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * Created by ANTON on 05.03.2016.
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    static {
        try {
            sessionFactory = new Configuration()
                    .configure()
                    .setProperty("hibernate.show_sql", "true")
                    .addAnnotatedClass(Player.class)
                    .addAnnotatedClass(Statistics.class)
                    .addAnnotatedClass(Biography.class)
                    .addAnnotatedClass(Position.class)
                    .buildSessionFactory();
            ;
        } catch (Throwable ex) {
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
