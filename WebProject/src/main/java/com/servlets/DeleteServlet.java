package com.servlets;

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
        Player player = new Player();
        PlayerDAOImpl playerDAO =new PlayerDAOImpl();
        try {
            player = playerDAO.getPlayerById(id);
            playerDAO.deletePlayer(player);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/index.jsp");
        dispatcher.forward(request, response);
    }
}
