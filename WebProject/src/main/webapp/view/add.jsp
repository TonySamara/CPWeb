<%--
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
    <title>Add Player</title>
</head>
<body>
<form action="/" align="center">
    <button type="submit">Home</button>
</form>
<form action="/add" method="get" align="center" name="data">
    <p>Enter firstname</p>
    <input type="text" name="firstname"  required value="">
    <p>Enter lastname</p>
    <input type="text" name="lastname"  required value="">
    <p>Enter number</p>
    <input type="text" name="number"  required value="">
    <p>Enter Image URL</p>
    <input type="text" name="url" >
    <p>Points per game</p>
    <input type="text" name="ppg"  required value="">
    <p>Assists per game</p>
    <input type="text" name="apg"  required value="">
    <p>Rebounds per game</p>
    <input type="text" name="rpg"  required value="">
    <p>FG%</p>
    <input type="text" name="fg"  required value="">
    <p>Height</p>
    <input type="text" name="height">
    <p>Weight</p>
    <input type="text" name="weight">
    <p>Prior to NBA</p>
    <input type="text" name="ptNBA">
    <p>Country</p>
    <input type="text" name="country">
    <p>YearsPro</p>
    <input type="text" name="yPro"  required value="">
    <p></p>
    <button type="submit" name="add">Add player</button>
</form>
</body>
</html>
