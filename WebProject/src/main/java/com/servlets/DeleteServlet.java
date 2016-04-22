package com.servlets;

import com.dao.BiographyDAO;
import com.dao.BiographyDAOImpl;
import com.dao.PlayerDAOImpl;
import com.dao.StatisticsDAOImpl;
import com.models.Biography;
import com.models.Player;
import com.models.Statistics;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by ANTON on 26.03.2016.
 */
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("playerId"));
        BiographyDAOImpl biographyDAO = new BiographyDAOImpl();
        PlayerDAOImpl playerDAO =new PlayerDAOImpl();
        StatisticsDAOImpl statisticsDAO = new StatisticsDAOImpl();
        try {
            Player player = playerDAO.getPlayerById(id);
            statisticsDAO.delStatByPlayer(id);
            biographyDAO.delBiographyByPlayer(id);
            playerDAO.deletePlayer(player);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/index.jsp");
        dispatcher.forward(request, response);
    }
}
