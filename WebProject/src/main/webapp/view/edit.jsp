<%@ page import="com.models.Statistics" %>
<%@ page import="com.dao.StatisticsDAOImpl" %>
<%@ page import="com.models.Player" %>
<%@ page import="com.dao.PlayerDAOImpl" %>
<%@ page import="com.dao.BiographyDAOImpl" %>
<%@ page import="com.models.Biography" %>
<%@ page import="com.models.Position" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.dao.PositionDAOImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: ANTON
  Date: 21.04.2016
  Time: 5:23
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Editor</title>
    <style><%@include file="/resources/table.css" %></style>
    <style><%@include file="/resources/style.css" %></style>
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
    Position position = player.getPosition();
%>
<form action="/edit" align="center">
<table border="1px" width="60%" align="center">
    <tr>
        <td rowspan="3"><a href="/player?playerId=<%=player.getId()%>"><img src="<%=player.getImage()%>"/></a></td>
        <td>
            <%try{ %>
            <input name ="firstname" placeholder="firstname" value="<%=player.getFirstname()%>">
            <%
                }
                catch (Exception e){
                    %><input name ="firstname" placeholder="firstname" value=""><%
                }
            %>
        </td>
        <td>
        <%try{ %>
        <input name ="lastname" placeholder="lastname" value="<%=player.getLastname()%>">
        <%
        }
        catch (Exception e){
        %><input name ="lastname" placeholder="lastname" value=""><%
        }
    %>
        </td>
        <td>
            <%try{ %>
            <input name ="number" placeholder="number" value="<%=player.getNumber()%>">
            <%
            }
            catch (Exception e){
            %><input name ="number" placeholder="number" value=""><%
            }
        %>
        </td>
        <td>
        <select name="position"><%
            List<Position> positionList = new ArrayList<Position>();
            PositionDAOImpl positionDAO = new PositionDAOImpl();
            positionList = positionDAO.getAllPosition();
            boolean check;
        %>
            <option selected value="<%=position.getId_position()%>"><%=position.getPosition()%></option>
            <% for (Position pos: positionList){
                check=true;

                if (pos.getId_position()== position.getId_position()) check=false;

            if (check==true){
        %>

                <option value="<%=pos.getId_position()%>"><%=pos.getPosition()%></option>
                    <%
                }
            }
        %>
        </td>
    </tr>
    <tr>
        <td>
            <%try{ %>
            <input name ="ppg" placeholder="ppg" value="<%=stat.getPpg()%>">
            <%
            }
            catch (Exception e){
            %><input name ="ppg" placeholder="ppg" value=""><%
            }
        %>
        </td>
        <td>
            <%try{ %>
            <input name ="apg" placeholder="apg" value="<%=stat.getApg()%>">
            <%
            }
            catch (Exception e){
            %><input name ="apg" placeholder="apg" value=""><%
            }
        %>
        </td>
        <td>
            <%try{ %>
            <input name ="rpg" placeholder="rpg" value="<%=stat.getRpg()%>">
            <%
            }
            catch (Exception e){
            %><input name ="rpg" placeholder="rpg" value=""><%
            }
        %>
        </td>
        <td>
            <%try{ %>
            <input name ="fg" placeholder="fg" value="<%=stat.getFg()%>">
            <%
            }
            catch (Exception e){
            %><input name ="fg" placeholder="fg" value=""><%
            }
        %>
        </td>
    </tr>
    <tr>
        <td>
            <%try{ %>
            <input name ="height" placeholder="height" value="<%=biography.getHeight()%>">
            <%
            }
            catch (Exception e){
            %><input name ="height" placeholder="height" value=""><%
            }
        %>
        </td>
        <td>
            <%try{ %>
            <input name ="weight" placeholder="weight" value="<%=biography.getWeight()%>">
            <%
            }
            catch (Exception e){
            %><input name ="weight" placeholder="weight" value=""><%
            }
        %>
        </td>
        <td>
            <%try{ %>
            <input name ="country" placeholder="country" value="<%=biography.getCountry()%>">
            <%
            }
            catch (Exception e){
            %><input name ="country" placeholder="country" value=""><%
            }
        %>
        </td>
    </tr>
</table>
    <input type="hidden" name ="id" value="<%=player.getId()%>">
    <button class="a" type="submit" align="center">Save</button>
</form>
<form action="/" align="center">
    <button class="a" type="submit" align="center">Home</button>
</form>
</body>
</html>

