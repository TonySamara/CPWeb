package com.dao;

import com.models.Biography;
import com.models.Player;
import com.models.Statistics;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ANTON on 07.03.2016.
 */
public class PlayerDAOImpl implements PlayerDAO {
    public void addPlayer(Player player) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(player);
            session.getTransaction().commit();
        } catch (ExceptionInInitializerError e) {
            System.out.println(e.getMessage());
        }
    }

    public void updatePlayer(Player player) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(player);
            session.getTransaction().commit();
        } catch (ExceptionInInitializerError e) {
            System.out.println(e.getMessage());
        }
    }

    public Player getPlayerById(int id) throws SQLException {
        Player player = new Player();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            player = (Player) session.get(Player.class, id);
        } catch (ExceptionInInitializerError e) {
            System.out.println(e.getMessage());
        }
        return  player;
    }

    public List getAllPlayers() throws SQLException {
        List<Player> list = new ArrayList<Player>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            list = session.createCriteria(Player.class).list();
        } catch (ExceptionInInitializerError e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void deletePlayer(Player player) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.beginTransaction();

            session.delete(player);
            session.getTransaction().commit();
        } catch (ExceptionInInitializerError e) {
            System.out.println(e.getMessage());
        }
    }
}
