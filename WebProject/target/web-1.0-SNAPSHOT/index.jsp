
<%--
  Created by IntelliJ IDEA.
  User: ANTON
  Date: 25.02.2016
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cleveland Cavaliers</title>
</head>
<body>
${textA}
${textB}

<table width="100%" border="1px"  align="center" >
    <tr>
    <td class="tablehead">id</td>
    <td class="tablehead">firstname</td>
    <td class="tablehead">lastname</td>
    <td class="tablehead">number</td>
        </tr>
    <c:forEach var="player" items="${getRoster}">
        <tr>
            <td><c:out value="${player.id}"/></td>
            <td><c:out value="${player.firstname}"/></td>
            <td><c:out value="${player.lastname}"/></td>
            <td><c:out value="${player.number}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
