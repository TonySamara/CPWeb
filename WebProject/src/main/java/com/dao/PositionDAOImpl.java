package com.dao;

import com.models.Biography;
import com.models.Position;
import com.models.Statistics;
import org.hibernate.Session;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ANTON on 07.03.2016.
 */
public class PositionDAOImpl implements PositionDAO {


    @Override
    public void addPosition(Position position) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(position);
            session.getTransaction().commit();
        } catch (ExceptionInInitializerError e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updatePosition(Position position) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(position);
            session.getTransaction().commit();
        } catch (ExceptionInInitializerError e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Position getPositionById(Long id) throws SQLException {
        Position position = new Position();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            position = (Position) session.get(Position.class, id);
        } catch (ExceptionInInitializerError e) {
            System.out.println(e.getMessage());
        }
        return  position;
    }

    @Override
    public List getAllPosition() throws SQLException {
        List<Position> list = new ArrayList<Position>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            list = session.createCriteria(Position.class).list();
        } catch (ExceptionInInitializerError e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void deletePosition(Position position) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(position);
            session.getTransaction().commit();
        } catch (ExceptionInInitializerError e) {
            System.out.println(e.getMessage());
        }
    }
}
