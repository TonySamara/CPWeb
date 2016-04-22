package com.dao;

import com.models.Biography;
import com.models.Player;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ANTON on 07.03.2016.
 */
public class BiographyDAOImpl implements BiographyDAO {
    @Override
    public void addBiography(Biography biography) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(biography);
            session.getTransaction().commit();
        } catch (ExceptionInInitializerError e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateBiography(Biography biography) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(biography);
            session.getTransaction().commit();
        } catch (ExceptionInInitializerError e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Biography getBiographyById(int id) throws SQLException {
        Biography biography = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
           biography = (Biography) session.get(Biography.class, id);
        } catch (ExceptionInInitializerError e) {
            System.out.println(e.getMessage());
        }
        return  biography;
    }

    @Override
    public List getAllBiography() throws SQLException {
        List<Biography> list = new ArrayList<Biography>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            list = session.createCriteria(Biography.class).list();
        } catch (ExceptionInInitializerError e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void deleteBiography(Biography biography) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(biography);
            session.getTransaction().commit();
        } catch (ExceptionInInitializerError e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delBiographyByPlayer(int id) throws SQLException {
        String query = "delete from \"biography\" where id_player = "+id;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.createSQLQuery(query).executeUpdate();
        } catch (ExceptionInInitializerError e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Biography> getBiographyByPlayerId(Player player) throws SQLException {
        List<Biography> players = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
           players=session.createCriteria(Biography.class).add(Restrictions.eq("player",player)).list();
        } catch (ExceptionInInitializerError e) {
            System.out.println(e.getMessage());
        }
        return players;
    }
}
