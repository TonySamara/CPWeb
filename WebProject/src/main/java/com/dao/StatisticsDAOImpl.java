package com.dao;

import com.models.Biography;
import com.models.Statistics;
import org.hibernate.Session;

import javax.management.j2ee.statistics.Statistic;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ANTON on 07.03.2016.
 */
public class StatisticsDAOImpl implements  StatisticsDAO {
    @Override
    public void addStatistic(Statistic statistic) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(statistic);
            session.getTransaction().commit();
        } catch (ExceptionInInitializerError e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateStatistic(Statistic statistic) throws SQLException {
      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        session.beginTransaction();
        session.update(statistic);
        session.getTransaction().commit();
    } catch (ExceptionInInitializerError e) {
        System.out.println(e.getMessage());
    }
    }

    @Override
    public Statistic getStatisticById(Long id) throws SQLException {
        Statistic statistic = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            statistic = (Statistic) session.get(Statistics.class, id);
        } catch (ExceptionInInitializerError e) {
            System.out.println(e.getMessage());
        }
        return  statistic;
    }

    @Override
    public List getAllStatistic() throws SQLException {
        List<Statistics> list = new ArrayList<Statistics>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            list = session.createCriteria(Statistics.class).list();
        } catch (ExceptionInInitializerError e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void deleteStatistic(Statistic statistic) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(statistic);
            session.getTransaction().commit();
        } catch (ExceptionInInitializerError e) {
            System.out.println(e.getMessage());
        }
    }
}
