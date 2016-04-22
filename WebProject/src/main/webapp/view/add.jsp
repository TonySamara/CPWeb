<%@ page import="java.util.List" %>
<%@ page import="com.models.Position" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.dao.PositionDAOImpl" %><%--
  Created by IntelliJ IDEA.
  User: ANTON
  Date: 25.03.2016
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="./validation.js"></script>
<head>
    <style>
        <%@include file="/resources/style.css" %>
    </style>
    <title>Add Player</title>
</head>
<body>
<form action="/" align="center">
    <button class="a" type="submit">Home</button>
</form>
<form action="/add" method="get" align="center" name="data">
    <p></p><input type="text" name="firstname"  placeholder="Firstname" required value="">
    <p></p><input type="text" name="lastname"  placeholder="Lastname" required value="">
    <p></p><input type="text" name="number"  placeholder="Number" required value="">
    <p></p><select size="3" name="position" align="center">
    <%
            List<Position> positionList = new ArrayList<Position>();
            PositionDAOImpl positionDAO = new PositionDAOImpl();
            positionList = positionDAO.getAllPosition();
            for (Position position: positionList){
    %>
        <option value="<%=position.getId_position()%>"><%=position.getPosition()%></option>
    <%}%>
        <p></p><input type="text" placeholder="Image url" name="url" >
        <p></p><input type="text" name="ppg" placeholder="Points" required value="">
        <p></p><input type="text" name="apg"  placeholder="Assists" required value="">
        <p></p><input type="text" name="rpg"  placeholder="Rebounds" required value="">
        <p></p><input type="text" name="fg"  placeholder="FG%" required value="">
        <p></p><input type="text" name="height" placeholder="Height">
        <p></p><input type="text" name="weight" placeholder="Weight">
        <p></p><input type="text" name="ptNBA" placeholder="Priot to NBA">
        <p></p><input type="text" name="country" placeholder="Country">
        <p></p><input type="text" name="yPro"  required value="" placeholder="Years pro">
    <p></p>
    <button class="a" type="submit" name="add">Add player</button>
</form>
</body>
</html>
