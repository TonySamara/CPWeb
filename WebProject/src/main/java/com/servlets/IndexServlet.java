package com.servlets;


import com.dao.PlayerDAOImpl;
import com.models.Player;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ANTON on 25.02.2016.
 */
 public class IndexServlet extends HttpServlet {

    public IndexServlet(){
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        List<Player> roster = null;
        String a = null;
        PlayerDAOImpl playerDAO = new PlayerDAOImpl();
        try {
            roster = playerDAO.getAllPlayers();
            a = roster.get(1).getFirstname();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/index.jsp");
        System.out.println(roster.get(0).getFirstname());
        request.setAttribute("roster", roster);
        dispatcher.forward(request, response);
    }
}
