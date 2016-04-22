<%@ page import="com.models.Statistics" %>
<%@ page import="com.dao.StatisticsDAOImpl" %>
<%@ page import="com.models.Player" %>
<%@ page import="com.dao.PlayerDAOImpl" %>
<%@ page import="com.dao.BiographyDAOImpl" %>
<%@ page import="com.models.Biography" %>
<%@ page import="com.models.Position" %>
<%@ page import="com.dao.PositionDAOImpl" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ANTON
  Date: 24.03.2016
  Time: 23:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Statistics</title>
    <title>Cleveland Cavaliers</title>
    <style><%@include file="/resources/table.css" %></style>
    <style>
        <%@include file="/resources/style.css" %>
    </style>
</head>
<body>
<%
    Player player = new Player();
    PlayerDAOImpl playerDAO = new PlayerDAOImpl();
    player = playerDAO.getPlayerById(Integer.parseInt(request.getParameter("playerId")));
    Statistics stat = new Statistics();
    StatisticsDAOImpl statDAO = new StatisticsDAOImpl();
    List <Statistics> statisticsList = statDAO.getStatByPlayerId(player);
    stat=statisticsList.get(0);
    Biography biography = new Biography();
    BiographyDAOImpl biographyDAO = new BiographyDAOImpl();
    List<Biography> biographyList = biographyDAO.getBiographyByPlayerId(player);
    biography = biographyList.get(0);
%>
<form align="center">
    <table border="1px" width="60%" align="center">
        <tr>
            <td rowspan="4"><a href="/player?playerId=<%=player.getId()%>"><img src="<%=player.getImage()%>"/></a></td>
            <td>
                Firstname
            </td>
            <td>
                Lastname
            </td>
            <td>
                Number
            </td>
            <td>
                Position
            </td>
        </tr>
        <tr>
            <td><%=player.getFirstname()%></td>
            <td>
                <%=player.getLastname()%>
            </td>
            <td>
                <%=player.getNumber()%>
            </td>
            <td>
                <%Position position = player.getPosition(); %>
                <%=position.getPosition()%>
            </td>
        </tr>
        <tr>
            <td>
                Points
            </td>
            <td>
                Assists
            </td>
            <td>
               Rebounds
            </td>
            <td>
                Field Goal %
            </td>
        </tr>
        <tr>
            <td>
                <%=stat.getPpg()%>
            </td>
            <td>
                <%=stat.getApg()%>
            </td>
            <td>
                <%=stat.getRpg()%>
            </td>
            <td>
                <%=stat.getFg()%>
            </td>
        </tr>
        <tr>
            <td>
               Height
            </td>
            <td>
               Weight
            </td>
            <td>
                Country
            </td>
            <td>
                Prior to NBA
            </td>
            <td>
               Years Pro
            </td>
        </tr>
        <tr>
            <td>
                <%=biography.getHeight() %>
            </td>
            <td>
                <%=biography.getWeight() %>
            </td>
            <td>
                <%=biography.getCountry() %>
            </td>
            <td>
                <%=biography.getPriorToNBA()%>
            </td>
            <td>
                <%=biography.getYearsPro()%>
            </td>
        </tr>
    </table>
</form>
<form action="/" align="center">
    <button class="a" type="submit">Home</button>
</form>
</body>
</html>
