<%@ page import="com.models.Statistics" %>
<%@ page import="com.dao.StatisticsDAOImpl" %>
<%@ page import="com.models.Player" %>
<%@ page import="com.dao.PlayerDAOImpl" %>
<%@ page import="com.dao.BiographyDAOImpl" %>
<%@ page import="com.models.Biography" %><%--
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
</head>
<body>
<%
    Statistics stat = new Statistics();
    StatisticsDAOImpl statDAO = new StatisticsDAOImpl();
    stat=statDAO.getStatisticById(Integer.parseInt(request.getParameter("playerId")));
    Player player = new Player();
    PlayerDAOImpl playerDAO = new PlayerDAOImpl();
    player = playerDAO.getPlayerById(Integer.parseInt(request.getParameter("playerId")));
    Biography biography = new Biography();
    BiographyDAOImpl biographyDAO = new BiographyDAOImpl();
    biography = biographyDAO.getBiographyById(Integer.parseInt(request.getParameter("playerId")));
%>
    <table border="1px" width="60%" align="center">
        <tr>
            <td rowspan="3"><a href="/player?playerId=<%=player.getId()%>"><img src="<%=player.getImage()%>"/></a></td>
            <td><%=player.getFirstname()%></td>
        <td>
            <%=player.getLastname()%>
        </td>
        <td>
            <%=player.getNumber()%>
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
                <%=biography.getHeight() %>
            </td>
            <td>
                <%=biography.getWeight() %>
            </td>
            <td>
                <%=biography.getCountry() %>
            </td>
        </tr>
    </table>
<form action="/">
    <button type="submit">Home</button>
</form>
</body>
</html>
