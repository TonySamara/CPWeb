
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
<body style='background: url(http://www.look.com.ua/pic/201507/1366x768/look.com.ua-122808.jpg) '>
<table align = "center" bgcolor="fffcf5">
    <tr>
        <td>
            <table  border="1px">
                <c:forEach  var="player" items="${roster}" begin="0"  end="2">
                    <tr>
                        <td rowspan="3"><a href="/player?playerId=${player.getId()}"><img src="${player.getImage()}"/></a></td>
                        <td>${player.getFirstname()}</td>
                    </tr>
                    <tr>
                        <td>${player.getLastname()}</td>
                    </tr>
                    <tr>
                        <td>Number ${player.getNumber()}</td>
                    </tr>
                    <tr>
                        <td>
                             <form action="/delete" align="center">
                                 <input type="hidden" value="${player.getId()}" name="playerId"/>
                                <button type="submit" name="delete">Delete</button>
                             </form>
                        </td>
                        <td>
                            <form action="/edit" align="center">
                                <input type="hidden" value="${player.getId()}" name="playerId"/>
                                <button type="submit" name="edit">Edit</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </td>
        <td>
            <table border="1px" >
                <c:forEach  var="player" items="${roster}" begin="3"  end="5">
                    <tr>
                        <td rowspan="3"><a href="/player?playerId=${player.getId()}"><img src="${player.getImage()}"/></a></td>
                        <td>${player.getFirstname()}</td>
                    </tr>
                    <tr>
                        <td>${player.getLastname()}</td>
                    </tr>
                    <tr>
                        <td>Number ${player.getNumber()}</td>
                    </tr>
                    <tr>
                        <td>
                            <form action="/delete" align="center">
                                <input type="hidden" value="${player.getId()}" name="playerId"/>
                                <button type="submit" name="delete">Delete</button>
                            </form>
                        </td>
                        <td>
                            <form action="/edit" align="center">
                                <input type="hidden" value="${player.getId()}" name="playerId"/>
                                <button type="submit" name="edit">Edit</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </td>
        <td>
            <table  border="1px">
                <c:forEach  var="player" items="${roster}" begin="6"  end="8">
                    <tr>
                        <td rowspan="3"><a href="/player?playerId=${player.getId()}"><img src="${player.getImage()}"/></a></td>
                        <td>${player.getFirstname()}</td>
                    </tr>
                    <tr>
                        <td>${player.getLastname()}</td>
                    </tr>
                    <tr>
                        <td>Number ${player.getNumber()}</td>
                    </tr>
                    <tr>
                        <td>
                            <form action="/delete" align="center">
                                <input type="hidden" value="${player.getId()}" name="playerId"/>
                                <button type="submit" name="delete">Delete</button>
                            </form>
                        </td>
                        <td>
                            <form action="/edit" align="center">
                                <input type="hidden" value="${player.getId()}" name="playerId"/>
                                <button type="submit" name="edit">Edit</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </td>
        <tr>
        <td>
            <table  border="1px">
                <c:forEach  var="player" items="${roster}" begin="9"  end="11">
                    <tr>
                        <td rowspan="3"><a href="/?player?playerId=${player.getId()}"><img src="${player.getImage()}"/></a></td>
                        <td>${player.getFirstname()}</td>
                    </tr>
                    <tr>
                        <td>${player.getLastname()}</td>
                    </tr>
                    <tr>
                        <td>Number ${player.getNumber()}</td>
                    </tr>
                    <tr>
                        <td>
                            <form action="/delete" align="center">
                                <input type="hidden" value="${player.getId()}" name="playerId"/>
                                <button type="submit" name="delete">Delete</button>
                            </form>
                        </td>
                        <td>
                            <form action="/edit" align="center">
                                <input type="hidden" value="${player.getId()}" name="playerId"/>
                                <button type="submit" name="edit">Edit</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </td>
    </tr>
</table>
<form action="view/add.jsp" align="center">
    <button type="submit">Add new player</button>
</form>
</body>
</html>
