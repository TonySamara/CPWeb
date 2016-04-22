package com.dao;

import com.models.Biography;
import com.models.Player;
import com.models.Statistics;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ANTON on 07.03.2016.
 */
public class StatisticsDAOImpl implements  StatisticsDAO {
    @Override
    public void addStatistic(Statistics statistic) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(statistic);
            session.getTransaction().commit();
        } catch (ExceptionInInitializerError e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateStatistic(Statistics statistic) throws SQLException {
      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        session.beginTransaction();
        session.update(statistic);
        session.getTransaction().commit();
    } catch (ExceptionInInitializerError e) {
        System.out.println(e.getMessage());
    }
    }

    @Override
    public Statistics getStatisticById(int id) throws SQLException {
        Statistics statistic = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            statistic = (Statistics) session.get(Statistics.class, id);
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
    public void deleteStatistic(Statistics statistic) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(statistic);
            session.getTransaction().commit();
        } catch (ExceptionInInitializerError e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delStatByPlayer(int id) throws SQLException {
        String query = "delete from \"statistics\" where id_player = "+id;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.createSQLQuery(query).executeUpdate();
        } catch (ExceptionInInitializerError e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Statistics> getStatByPlayerId(Player player) throws SQLException {
        List<Statistics> stats = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            stats=session.createCriteria(Statistics.class).add(Restrictions.eq("player",player)).list();

        } catch (ExceptionInInitializerError e) {
            System.out.println(e.getMessage());
        }
        return stats;
    }
}
