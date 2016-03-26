package com.servlets;

import com.dao.BiographyDAOImpl;
import com.dao.PlayerDAOImpl;
import com.dao.StatisticsDAOImpl;
import com.models.Biography;
import com.models.Player;
import com.models.Position;
import com.models.Statistics;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by ANTON on 25.03.2016.
 */
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try {
            Position position = new Position();
            Player player = new Player();
            player.setFirstname(request.getParameter("firstname"));
            player.setLastname(request.getParameter("lastname"));
            player.setNumber(Integer.parseInt(request.getParameter("number")));
            player.setImage(request.getParameter("url"));
            Statistics statistics = new Statistics();
            statistics.setPpg(Double.parseDouble(request.getParameter("ppg")));
            statistics.setApg(Double.parseDouble(request.getParameter("apg")));
            statistics.setRpg(Double.parseDouble(request.getParameter("rpg")));
            statistics.setFg(Double.parseDouble(request.getParameter("fg")));
            statistics.setPlayer(player);
            Biography biography = new Biography();
            biography.setHeight(Integer.parseInt(request.getParameter("height")));
            biography.setWeight(Integer.parseInt(request.getParameter("weight")));
            biography.setYearsPro(Integer.parseInt(request.getParameter("yPro")));
            biography.setCountry((request.getParameter("country")));
            biography.setPriorToNBA((request.getParameter("ptNBA")));
            biography.setPlayer(player);
            PlayerDAOImpl playerDAO = new PlayerDAOImpl();
            try {
                playerDAO.addPlayer(player);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            StatisticsDAOImpl statisticsDAO = new StatisticsDAOImpl();
            try {
                statisticsDAO.addStatistic(statistics);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            BiographyDAOImpl biographyDAO = new BiographyDAOImpl();
            try {
                biographyDAO.addBiography(biography);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/add.jsp");
            dispatcher.forward(request, response);
        }
        catch (Exception e){
            System.out.println("Something wrong:(");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/add.jsp");
            dispatcher.forward(request, response);
        }

    }
}
