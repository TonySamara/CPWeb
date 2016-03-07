package com;

import com.dao.BiographyDAOImpl;
import com.dao.HibernateUtil;
import com.dao.PlayerDAO;
import com.dao.PlayerDAOImpl;
import com.models.Biography;
import com.models.Player;
import org.hibernate.Session;
import org.hibernate.sql.ordering.antlr.Factory;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ANTON on 04.03.2016.
 */
public class Main {

    public static void main(final String[] args) throws SQLException {
        PlayerDAOImpl playerDAO = new PlayerDAOImpl();
        List<Player> list = playerDAO.getAllPlayers();

        for (int i =0; i<list.size();i++){
            System.out.println(list.get(i).getLastname());
        }
    }
}