<%@ page import="com.models.Player" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.dao.PlayerDAOImpl" %>
<%@ page import="com.models.Position" %>
<%--
  Created by IntelliJ IDEA.
  User: ANTON
  Date: 25.02.2016
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cleveland Cavaliers</title>
    <style>
        <%@include file="/resources/style.css" %>
    </style>
</head>
<%
    PlayerDAOImpl playerDAO = new PlayerDAOImpl();
    List<Player> playerList = new ArrayList<Player>();
    playerList = playerDAO.getAllPlayers();
    Player player = null ;
%>
<body style='background: url(http://www.look.com.ua/pic/201507/1366x768/look.com.ua-122808.jpg) '>
<table align = "center" bgcolor="fffcf5">
    <tr>
        <td>
            <table  border="1px">
                <%
                    int i;
                    for (i=0;i<3;i++){
                        player = playerList.get(i);
                %>
                <tr>
                    <td rowspan="4"><a href="/player?playerId=<%=player.getId()%>"><img src="<%=player.getImage()%>"/></a></td>
                    <td><%=player.getFirstname()%></td>
                </tr>
                <tr>
                    <td><%=player.getLastname()%></td>
                </tr>
                <tr>
                    <td>Number <%=player.getNumber()%></td>
                </tr>
                <tr>
                    <%Position position = player.getPosition(); %>
                    <td><%=position.getPosition()%></td>
                </tr>
                <tr>
                    <td>
                        <form action="/delete" align="center">
                           <input type="hidden" value="<%=player.getId()%>" name="playerId"/>
                           <button class="but" type="submit" name="delete">Delete</button>
                         </form>
                    </td>
                    <td>
                        <form action="/view/edit.jsp" align="center">
                          <input type="hidden" value="<%=player.getId()%>" name="playerId"/>
                          <button class="but" type="submit" name="edit">Edit</button>
                         </form>
                    </td>
                </tr>
                <%} %>
            </table>
        </td>
        <td>
            <table  border="1px">
                <%
                    for (i=3;i<6;i++){
                        player = playerList.get(i);
                %>
                <tr>
                    <td rowspan="4"><a href="/player?playerId=<%=player.getId()%>"><img src="<%=player.getImage()%>"/></a></td>
                    <td><%=player.getFirstname()%></td>
                </tr>
                <tr>
                    <td><%=player.getLastname()%></td>
                </tr>
                <tr>
                    <td>Number <%=player.getNumber()%></td>
                </tr>
                <tr>
                    <%Position position = player.getPosition(); %>
                    <td><%=position.getPosition()%></td>
                </tr>
                <tr>
                    <td>
                        <form action="/delete" align="center">
                            <input type="hidden" value="<%=player.getId()%>" name="playerId"/>
                            <button class="but" type="submit" name="delete">Delete</button>
                        </form>
                    </td>
                    <td>
                        <form action="/view/edit.jsp" align="center">
                            <input type="hidden" value="<%=player.getId()%>" name="playerId"/>
                            <button class="but" type="submit" name="edit">Edit</button>
                        </form>
                    </td>
                </tr>
                <%} %>
            </table>
        </td>
        <td>
            <table  border="1px">
                <%
                    try {
                    for (i=6;i<9;i++){
                        player = playerList.get(i);
                %>
                <tr>
                    <td rowspan="4"><a href="/player?playerId=<%=player.getId()%>"><img src="<%=player.getImage()%>"/></a></td>
                    <td><%=player.getFirstname()%></td>
                </tr>
                <tr>
                    <td><%=player.getLastname()%></td>
                </tr>
                <tr>
                    <td>Number <%=player.getNumber()%></td>
                </tr>
                <tr>
                    <%Position position = player.getPosition(); %>
                    <td><%=position.getPosition()%></td>
                </tr>
                <tr>
                    <td>
                        <form action="/delete" align="center">
                            <input type="hidden" value="<%=player.getId()%>" name="playerId"/>
                            <button class="but" type="submit" name="delete">Delete</button>
                        </form>
                    </td>
                    <td>
                        <form action="/view/edit.jsp" align="center">
                            <input type="hidden" value="<%=player.getId()%>" name="playerId"/>
                            <button  class="but" type="submit" name="edit">Edit</button>
                        </form>
                    </td>
                </tr>
                <%} %>
            </table>
            <%
                }
                catch (Exception e)
                {
                    System.out.print("Something wrong");
                }
            %>
        </td>
        <td>
            <table  border="1px">
                <%
                    try {
                    for (i=9;i<12;i++){
                        player = playerList.get(i);
                %>
                <tr>
                    <td rowspan="4"><a href="/player?playerId=<%=player.getId()%>"><img src="<%=player.getImage()%>"/></a></td>
                    <td><%=player.getFirstname()%></td>
                </tr>
                <tr>
                    <td><%=player.getLastname()%></td>
                </tr>
                <tr>
                    <td>Number <%=player.getNumber()%></td>
                </tr>
                <tr>
                    <%Position position = player.getPosition(); %>
                    <td><%=position.getPosition()%></td>
                </tr>
                <tr>
                    <td>
                        <form action="/delete" align="center">
                            <input type="hidden" value="<%=player.getId()%>" name="playerId"/>
                            <button class="but" type="submit" name="delete">Delete</button>
                        </form>
                    </td>
                    <td>
                        <form action="/view/edit.jsp" align="center">
                            <input type="hidden" value="<%=player.getId()%>" name="playerId"/>
                            <button  class="but" type="submit" name="edit">Edit</button>
                        </form>
                    </td>
                </tr>
                <%
                    }
                %>
            </table>
            <%
                }
                catch (Exception e)
                {
                    System.out.print("Something wrong");
                }
            %>
        </td>
    </tr>
</table>
<form action="view/add.jsp" align="center">
    <button class="a" type="submit">Add new player</button>
</form>
</body>
</html>
