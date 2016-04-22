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
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ANTON on 21.04.2016.
 */
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try {
            PlayerDAOImpl playerDAO = new PlayerDAOImpl();
            Player player = playerDAO.getPlayerById(Integer.parseInt(request.getParameter("id")));
            player.setFirstname(request.getParameter("firstname"));
            player.setLastname(request.getParameter("lastname"));
            player.setNumber(Integer.parseInt(request.getParameter("number")));
            Statistics statistics;
            StatisticsDAOImpl statDAO = new StatisticsDAOImpl();
            try {
                List<Statistics> statisticses = statDAO.getStatByPlayerId(player);
                statistics=statisticses.get(0);
            }
            catch (Exception e)
            {
                statistics = new Statistics();
            }
            statistics.setPpg(Double.parseDouble(request.getParameter("ppg")));
            statistics.setApg(Double.parseDouble(request.getParameter("apg")));
            statistics.setRpg(Double.parseDouble(request.getParameter("rpg")));
            statistics.setFg(Double.parseDouble(request.getParameter("fg")));
            statistics.setPlayer(player);
            BiographyDAOImpl biographyDAO = new BiographyDAOImpl();
            Biography biography;
            try {
                List<Biography> biographyList = biographyDAO.getBiographyByPlayerId(player);
                biography = biographyList.get(0);
            }
            catch (Exception e){
                biography = new Biography();
            }
            biography.setHeight(Integer.parseInt(request.getParameter("height")));
            biography.setWeight(Integer.parseInt(request.getParameter("weight")));
            biography.setCountry((request.getParameter("country")));
            biography.setPlayer(player);
            try {

                playerDAO.updatePlayer(player);
                try {
                    statDAO.updateStatistic(statistics);
                }
                catch (Exception e){
                    statDAO.addStatistic(statistics);
                }
                try {
                    biographyDAO.updateBiography(biography);
                }
                catch (Exception e){
                    biographyDAO.addBiography(biography);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/edit.jsp?playerId="+player.getId());
            dispatcher.forward(request, response);
        }
        catch (Exception e){
            System.out.println("Something wrong:(");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/index.jsp");
            dispatcher.forward(request, response);
        }

    }
}
